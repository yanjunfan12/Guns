package com.stylefeng.guns.modular.adverse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.common.annotion.Permission;
import com.stylefeng.guns.common.constant.factory.PageFactory;
import com.stylefeng.guns.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.page.PageInfoBT;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionService;
import com.stylefeng.guns.modular.adverse.warpper.AdverseReactionWarpper;

/**
 * 不良反应记录控制器
 *
 * @author fanyj
 * @Date 2018-01-26 20:06:23
 */
@Validated
@Controller
@RequestMapping("/adverseReaction")
public class AdverseReactionController extends BaseController {
	
	/**
	 *  Excel表头中文到数据库字段名的映射
	 */
	public static final Map<String,String> TITLE_2_KEY=new LinkedHashMap<String,String>();
	static {
		TITLE_2_KEY.put("主键id", "id");
		TITLE_2_KEY.put("住院号", "patientNumber");
		TITLE_2_KEY.put("姓名", "name");
		TITLE_2_KEY.put("分类", "categoryName");
		TITLE_2_KEY.put("放疗次数 ", "radiotherapyCount");
		TITLE_2_KEY.put("化疗次数", "chemotherapyCount");
		TITLE_2_KEY.put("体重", "weight");
		TITLE_2_KEY.put("目前饮食", "dietaryStatusName");
		TITLE_2_KEY.put("乏力", "weakStatusName");
		TITLE_2_KEY.put("恶心", "nauseaStatusName");
		TITLE_2_KEY.put("呕吐", "vomitStatusName");
		TITLE_2_KEY.put("腹泻", "diarrheaStatusName");
		TITLE_2_KEY.put("便秘", "constipationStatusName");
		TITLE_2_KEY.put("肌肉关节痛", "muscleJointPainStatusName");
		TITLE_2_KEY.put("神经系统", "nervousSystemStatusName");
		TITLE_2_KEY.put("脱发", "alopeciaStatusName");
		TITLE_2_KEY.put("发热", "feverStatusName");
		TITLE_2_KEY.put("咳嗽", "coughStatusName");
		TITLE_2_KEY.put("放射性皮肤损伤", "skinStatusName");
		TITLE_2_KEY.put("打嗝", "hiccupStatusName");
		TITLE_2_KEY.put("口腔黏膜炎", "oralMucositisStatusName");
		TITLE_2_KEY.put("声嘶 ", "hoarsenessStatusName");
		TITLE_2_KEY.put("听力损伤", "hearingStatusName");
		TITLE_2_KEY.put("头晕 ", "dizzyStatusName");
		TITLE_2_KEY.put("头痛  ", "headacheStatusName");
		TITLE_2_KEY.put("肺炎", "pneumoniaStatusName");
		TITLE_2_KEY.put("进食痛", "esophagitisStatusName");
		TITLE_2_KEY.put("其他症状", "otherStatusesDesc");
		TITLE_2_KEY.put("填表人", "createUser");
		TITLE_2_KEY.put("更新人", "updateUser");
		TITLE_2_KEY.put("填表日期", "createtime");
		TITLE_2_KEY.put("修改日期", "updatetime");

	}

	private Log log = LogFactory.getLog(AdverseReactionController.class);

    private String PHOTO_PREFIX = "/adverse/adverseReactionPhoto/";

    private String PREFIX = "/adverse/adverseReaction/";

    @Autowired
    private IAdverseReactionService adverseReactionService;

    @Resource
    private GunsProperties gunsProperties;

    /**
     * 跳转到不良反应记录首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "adverseReaction.html";
    }

    /**
     * 跳转到添加不良反应记录
     */
    @RequestMapping("/adverseReaction_add")
    public String adverseReactionAdd() {
        return PREFIX + "adverseReaction_add.html";
    }
    
    /**
     * 跳转到分类不良反应记录
     */
    @RequestMapping("/adverseReaction_category/{adverseReactionId}")
    public String adverseReactionCategory(@PathVariable Integer adverseReactionId, Model model) {
        AdverseReaction adverseReaction = adverseReactionService.selectById(adverseReactionId);
        model.addAttribute("item",adverseReaction);
        LogObjectHolder.me().set(adverseReaction);
    	return PREFIX + "adverseReaction_category.html";
    }

    /**
     * 跳转到修改不良反应记录
     */
    @RequestMapping("/adverseReaction_update/{adverseReactionId}")
    public String adverseReactionUpdate(@PathVariable Integer adverseReactionId, Model model) {
        AdverseReaction adverseReaction = adverseReactionService.selectById(adverseReactionId);
        model.addAttribute("item",adverseReaction);
        LogObjectHolder.me().set(adverseReaction);
        return PREFIX + "adverseReaction_edit.html";
    }

    /**
     * 跳转到给某一条不良反应添加附件
     */
    @RequestMapping("/adverseReaction_upload/{adverseReactionId}")
    public String adverseReactionUpload(@PathVariable Integer adverseReactionId, Model model) {
        AdverseReaction adverseReaction = adverseReactionService.selectById(adverseReactionId);
        model.addAttribute("item",adverseReaction);
        LogObjectHolder.me().set(adverseReaction);
        return PHOTO_PREFIX + "adverseReactionPhoto_add.html";
    }

    /**
     * 分页获取不良反应记录列表
     */
    @Permission
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name
    		, @RequestParam(required = false) String patientNumber
    		, @RequestParam(required = false) Integer category) {
       
    	log.warn("name="+name
    			+",patientNumber="+patientNumber
    			+",category="+category);
    	
    	Page<AdverseReaction> page = new PageFactory<AdverseReaction>().defaultPage();//BootStrap Table默认的分页参数创建

    	EntityWrapper<AdverseReaction> adverseReactionEntityWrapper = new EntityWrapper<AdverseReaction>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);
        if(!StringUtils.isBlank(patientNumber))
        	adverseReactionEntityWrapper.eq("patient_number", patientNumber);
        if(null!=category)
        	adverseReactionEntityWrapper.eq("category", category);

    	Page<Map<String, Object>> pageResult = adverseReactionService.selectMapsPage(page,adverseReactionEntityWrapper);
    	List<Map<String, Object>> rows=(List<Map<String, Object>>) super.warpObject(new AdverseReactionWarpper(pageResult.getRecords()));

    	PageInfoBT<Map<String, Object>> bt=new PageInfoBT<Map<String, Object>>();
    	bt.setRows(rows);
    	bt.setTotal(pageResult.getTotal());;

    	return bt;
    }

    /**
     * 修改不良反应记录
     */
    @Permission
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(
    		@Valid
    		@NotNull(message="不良反应记录入参不能为null")
    		AdverseReaction adverseReaction) {

        boolean flag=adverseReactionService.updateById(adverseReaction);
        if(flag)
        	return super.SUCCESS_TIP;
        else{
        	return new ErrorTip(404,"修改不良反应记录失败，ID="+adverseReaction.getId());
        }
    }
    
    /**
     * 分类不良反应记录
     */
    @Permission
    @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Tip category(
    		@NotNull(message="主键id入参不能为null")
    		@PathVariable("id") Integer id,
    		@NotNull(message="分类入参不能为null")
    		@RequestParam("category") Integer category) {

    	AdverseReaction adverseReaction=new AdverseReaction();
    	adverseReaction.setId(id);
    	adverseReaction.setCategory(category);
		boolean flag=adverseReactionService.updateById(adverseReaction);
        if(flag)
        	return super.SUCCESS_TIP;
        else{
        	return new ErrorTip(404,"分类不良反应记录失败，ID="+id);
        }
    }

    /**
     * 不良反应记录详情
     */
    @Permission
    @RequestMapping(value = "/detail/{adverseReactionId}")
    @ResponseBody
    public Object detail(
    		@NotNull(message="不良反应记录ID入参不能为null")
    		@PathVariable("adverseReactionId") Integer adverseReactionId) {
        return adverseReactionService.selectById(adverseReactionId);
    }

    /**
     * 下载符合条件的不良反应列表
     * @throws IOException
     */
    @Permission
    @RequestMapping(value = "/exportAll")
    public ResponseEntity<byte[]> exportAll(@RequestParam(required = false) String name
    		, @RequestParam(required = false) String patientNumber
    		, @RequestParam(required = false) Integer category) throws IOException {
        EntityWrapper<AdverseReaction> adverseReactionEntityWrapper = new EntityWrapper<AdverseReaction>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);
        if(!StringUtils.isBlank(patientNumber))
        	adverseReactionEntityWrapper.eq("patient_number", patientNumber);
        if(null!=category)
        	adverseReactionEntityWrapper.eq("category", category);
        
        String[] colArray={"createtime"};
        Collection<String> cols=Arrays.asList(colArray);
		adverseReactionEntityWrapper.orderDesc(cols);

        List<Map<String, Object>> list=selectPage(adverseReactionEntityWrapper);
        byte[] bytes=ExcelUtils.buildBytes(list,TITLE_2_KEY);
		return renderFile("sxssf.xlsx", bytes);
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
    private List<Map<String, Object>> selectPage(EntityWrapper<AdverseReaction> adverseReactionEntityWrapper){

    	int range=gunsProperties.getRange();
    	int offset=0;
    	Page<AdverseReaction> page=null;
    	int total=0;
    	List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();//这可能的大对象，需要去除

    	do{
    		page = new Page<>((offset / range + 1), range);

    		Page<Map<String, Object>> pageResult = adverseReactionService.selectMapsPage(page,adverseReactionEntityWrapper);
        	total=pageResult.getTotal();

        	offset=offset+pageResult.getRecords().size();

        	log.info("offset="+offset+",total="+total);

        	List<Map<String, Object>> tmp=(List<Map<String, Object>>) super.warpObject(new AdverseReactionWarpper(pageResult.getRecords()));
        	list.addAll(tmp);
    	}while(offset<total);

    	return list;
    }


}
