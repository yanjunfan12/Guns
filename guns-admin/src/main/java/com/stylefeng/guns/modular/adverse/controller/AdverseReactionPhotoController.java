package com.stylefeng.guns.modular.adverse.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.persistence.model.AdverseReactionPhoto;
import com.stylefeng.guns.config.properties.GunsProperties;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionPhotoService;

import io.swagger.annotations.ApiOperation;

/**
 * 治疗过程中不良反应记录（病人填表）的图片附件控制器
 *
 * @author fengshuonan
 * @Date 2018-01-27 21:06:51
 */
@Controller
@RequestMapping("/adverseReactionPhoto")
public class AdverseReactionPhotoController extends BaseController {

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
     * 获取指定治疗过程中不良反应记录（病人填表）id的图片附件列表
     */
    @RequestMapping(value = "/list/{adverseReactionId}")
    @ResponseBody
    public Object list(@PathVariable("adverseReactionId") Integer adverseReactionId) {
        EntityWrapper<AdverseReactionPhoto> adverseReactionEntityWrapper = new EntityWrapper<AdverseReactionPhoto>();
        adverseReactionEntityWrapper.eq("adverseReactionId", adverseReactionId);
        return adverseReactionPhotoService.selectList(adverseReactionEntityWrapper);
    }

    /**
     * 治疗过程中不良反应记录（病人填表）的图片附件详情
     */
    @RequestMapping(value = "/detail/{adverseReactionPhotoId}")
    @ResponseBody
    public Object detail(@PathVariable("adverseReactionPhotoId") Integer adverseReactionPhotoId) {
        return adverseReactionPhotoService.selectById(adverseReactionPhotoId);
    }

    /**
     * 上传图片附件，并新增图片附件记录
     */
    @ApiOperation("上传图片附件，并新增图片附件记录")
    @RequestMapping(method = RequestMethod.POST, path = "/upload/{adverseReactionId}")
    @ResponseBody
    public Tip upload(@RequestPart("file") MultipartFile file,@PathVariable("adverseReactionId") Integer adverseReactionId) {
        String pictureName = adverseReactionId+"_"+UUID.randomUUID().toString() + ".jpg";
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();
            file.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            throw new GunsException(BizExceptionEnum.UPLOAD_ERROR);
        }
        AdverseReactionPhoto adverseReactionPhoto=new AdverseReactionPhoto();
        adverseReactionPhoto.setAdverseReactionId(adverseReactionId);
        adverseReactionPhoto.setPhotoPath(pictureName);
        adverseReactionPhotoService.insert(adverseReactionPhoto);
        int id=adverseReactionPhoto.getId();
        return new ErrorTip(200,id+"");
    }
}
