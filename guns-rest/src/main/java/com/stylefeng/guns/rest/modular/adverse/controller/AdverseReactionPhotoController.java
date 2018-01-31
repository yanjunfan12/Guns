package com.stylefeng.guns.rest.modular.adverse.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.common.persistence.model.AdverseReactionPhoto;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.adverse.service.IAdverseReactionPhotoService;

import io.swagger.annotations.ApiOperation;

/**
 * 不良反应记录控制器
 *
 * @author fengshuonan
 * @Date 2018-01-31 22:35:51
 */
@RestController
@RequestMapping("/adverseReactionPhoto")
public class AdverseReactionPhotoController extends BaseController {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private IAdverseReactionPhotoService adverseReactionPhotoService;

    /**
     * 上传图片附件，并新增图片附件记录
     */
    @ApiOperation("上传图片附件，并新增图片附件记录")
    @RequestMapping(method = RequestMethod.POST, path = "/upload/{adverseReactionId}")
    public Tip upload(@RequestPart("file") MultipartFile file,@PathVariable("adverseReactionId") Integer adverseReactionId) {
        String pictureName = adverseReactionId+"_"+UUID.randomUUID().toString() + "_" +  file.getOriginalFilename() + ".jpg";
        try {
            String fileSavePath = jwtProperties.getFileUploadPath();
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
