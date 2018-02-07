package com.stylefeng.guns.modular.adverse.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.annotion.Permission;
import com.stylefeng.guns.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.common.persistence.model.AdverseReactionPhoto;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionPhotoService;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionService;

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

    private String PREFIX = "/adverse/adverseReactionPhoto/";

    @Resource
    private GunsProperties gunsProperties;

    @Autowired
    private IAdverseReactionPhotoService adverseReactionPhotoService;

    @Autowired
    private IAdverseReactionService adverseReactionService;

    /**
     * 跳转到治疗过程中不良反应记录（病人填表）的图片附件首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "adverseReactionPhoto.html";
    }

    /**
     * 下载某一条不良反应的附件
     * @throws Exception
     */
    @Permission
    @RequestMapping(value = "/exportOne/{adverseReactionId}")
    @ResponseBody
    public Tip exportOne(@PathVariable("adverseReactionId") Integer adverseReactionId) throws Exception {

    	Tip t=validate(adverseReactionId);
    	if(null!=t) {
    		return t;
    	}

    	EntityWrapper<AdverseReactionPhoto> adverseReactionEntityWrapper = new EntityWrapper<AdverseReactionPhoto>();
        adverseReactionEntityWrapper.eq("adverse_reaction_id", adverseReactionId);
        List<AdverseReactionPhoto> photos=adverseReactionPhotoService.selectList(adverseReactionEntityWrapper);

        if(photos.isEmpty()) {
        	return new ErrorTip(404,adverseReactionId+"没有附件！");
        }

        String fileSavePath = gunsProperties.getFileUploadPath();

        super.getHttpServletResponse().setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        super.getHttpServletResponse().setHeader("Content-Disposition", "attachment;filename=" + adverseReactionId+"_photo.zip");
        //ByteArrayOutputStream bo, ZipOutputStream zos=new ZipOutputStream(bos),ResponseEntity<bos.toByteArray()>不成功，会出现下载的文件解压缩失败
        ZipUtils.zipOut(super.getHttpServletResponse().getOutputStream(),fileSavePath, photos);
		return SUCCESS_TIP;

    }

    /**
     * @param adverseReactionId
     * @return 返回null则验证成功，否则失败
     */
    private Tip validate(Integer adverseReactionId){
    	Wrapper<AdverseReaction> wrapper= new EntityWrapper<AdverseReaction>();
    	wrapper.eq("id", adverseReactionId);
		int count=adverseReactionService.selectCount(wrapper);
		if(count<1) {
			return new ErrorTip(404,"没有此不良反应记录ID="+adverseReactionId);
		}

		return null;
    }
}
