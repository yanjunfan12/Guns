package com.stylefeng.guns.modular.adverse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.common.annotion.Permission;
import com.stylefeng.guns.common.constant.factory.PageFactory;
import com.stylefeng.guns.common.persistence.model.AdverseReactionPhoto;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.page.PageInfoBT;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionPhotoService;

/**
 * 治疗过程中不良反应记录（病人填表）的图片附件控制器
 *
 * @author fengshuonan
 * @Date 2018-01-27 21:06:51
 */
@Validated
@Controller
@RequestMapping("/adverseReactionPhoto")
public class AdverseReactionPhotoController extends BaseController {
	
	/**
	 *  Excel表头中文到数据库字段名的映射
	 */
	public static final Map<String,String> TITLE_2_KEY=new LinkedHashMap<String,String>();
	static {
		TITLE_2_KEY.put("主键id", "id");
		TITLE_2_KEY.put("姓名", "name");
		TITLE_2_KEY.put("图片路径", "photoPath");
		TITLE_2_KEY.put("上传人", "createUser");
		TITLE_2_KEY.put("填表日期", "createtime");
		TITLE_2_KEY.put("修改日期", "updatetime");

	}

    private String PREFIX = "/adverse/adverseReactionPhoto/";

    @Resource
    private GunsProperties gunsProperties;

    @Autowired
    private IAdverseReactionPhotoService adverseReactionPhotoService;

    /**
     * 跳转到治疗过程中不良反应记录（病人填表）的图片附件首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "adverseReactionPhoto.html";
    }
    
    /**
     * 下载符合条件的不良反应附件列表
     * @throws IOException
     */
    @Permission
    @RequestMapping(value = "/exportAll")
    public ResponseEntity<byte[]> exportAll(@RequestParam(required = false) String name) throws IOException {
        EntityWrapper<AdverseReactionPhoto> adverseReactionEntityWrapper = new EntityWrapper<AdverseReactionPhoto>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);
        String[] colArray={"createtime"};
        Collection<String> cols=Arrays.asList(colArray);
		adverseReactionEntityWrapper.orderDesc(cols);

        List<Map<String, Object>> list=selectPage(adverseReactionEntityWrapper);
        byte[] bytes=ExcelUtils.buildBytes(list,TITLE_2_KEY);
		return renderFile("sxssf.xlsx", bytes);
    }
    
    /**
     * 分页获取不良反应记录列表
     */
    @Permission
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name) {
    	
    	Page<AdverseReactionPhoto> page = new PageFactory<AdverseReactionPhoto>().defaultPage();//BootStrap Table默认的分页参数创建

    	EntityWrapper<AdverseReactionPhoto> adverseReactionEntityWrapper = new EntityWrapper<AdverseReactionPhoto>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);

    	Page<Map<String, Object>> pageResult = adverseReactionPhotoService.selectMapsPage(page,adverseReactionEntityWrapper);
    	List<Map<String, Object>> rows=pageResult.getRecords();

    	PageInfoBT<Map<String, Object>> bt=new PageInfoBT<Map<String, Object>>();
    	bt.setRows(rows);
    	bt.setTotal(pageResult.getTotal());;

    	return bt;
    }
    
    /**
     * 下载符合条件的不良反应附件zip包
     * @throws Exception 
     */
    @Permission
    @RequestMapping(value = "/downloadAll")
    public Tip downloadAll(@RequestParam(required = false) String name) throws Exception {
        EntityWrapper<AdverseReactionPhoto> adverseReactionEntityWrapper = new EntityWrapper<AdverseReactionPhoto>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);

        //性能优化点，分页读，分页写出
        List<AdverseReactionPhoto> photos=adverseReactionPhotoService.selectList(adverseReactionEntityWrapper);

        Set<String> noDulSet=new HashSet<String>();
		for(AdverseReactionPhoto p : photos) {
	        String fileName=p.getPhotoPath();
	        noDulSet.add(fileName);
        }
        
        String fileSavePath = gunsProperties.getFileUploadPath();

        super.getHttpServletResponse().setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        super.getHttpServletResponse().setHeader("Content-Disposition", "attachment;filename=" + name+"_photo.zip");
        //ByteArrayOutputStream bo, ZipOutputStream zos=new ZipOutputStream(bos),ResponseEntity<bos.toByteArray()>不成功，会出现下载的文件解压缩失败
        ZipUtils.zipOut(super.getHttpServletResponse().getOutputStream(),fileSavePath, noDulSet);
		return SUCCESS_TIP;
    }
    
    /**
    *
    * 分页选取
    * 
    * 还需要生产者消费者模式，分页消耗掉
    *
    * @param adverseReactionEntityWrapper
    * @return
    */
   private List<Map<String, Object>> selectPage(EntityWrapper<AdverseReactionPhoto> adverseReactionEntityWrapper){

	   	int range=gunsProperties.getRange();
	   	int offset=0;
	   	Page<AdverseReactionPhoto> page=null;
	   	int total=0;
	   	List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();//这可能的大对象，需要去除
	
	   	do{
	   		page = new Page<>((offset / range + 1), range);
	
	   		Page<Map<String, Object>> pageResult = adverseReactionPhotoService.selectMapsPage(page,adverseReactionEntityWrapper);
	       	total=pageResult.getTotal();
	
	       	offset=offset+pageResult.getRecords().size();
	
	       	list.addAll(pageResult.getRecords());
	   	}while(offset<total);
	
	   	return list;
   }

    /**
     * 下载某一条不良反应的附件
     * @throws Exception
     */
    @Permission
    @RequestMapping(value = "/exportOne/{id}")
    @ResponseBody
    public Tip exportOne(@PathVariable("id") Integer id) throws Exception {

        AdverseReactionPhoto photo=adverseReactionPhotoService.selectById(id);

        if(null==photo) {
        	return new ErrorTip(404,"没有编号为"+id+"的附件！");
        }

        String fileSavePath = gunsProperties.getFileUploadPath();

        super.getHttpServletResponse().setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        super.getHttpServletResponse().setHeader("Content-Disposition", "attachment;filename=" + id+"_photo.zip");
        //ByteArrayOutputStream bo, ZipOutputStream zos=new ZipOutputStream(bos),ResponseEntity<bos.toByteArray()>不成功，会出现下载的文件解压缩失败
        Set<String> noDulSet=new HashSet<String>();
        noDulSet.add(photo.getPhotoPath());
        ZipUtils.zipOut(super.getHttpServletResponse().getOutputStream(),fileSavePath, noDulSet);
		return SUCCESS_TIP;

    }

}
