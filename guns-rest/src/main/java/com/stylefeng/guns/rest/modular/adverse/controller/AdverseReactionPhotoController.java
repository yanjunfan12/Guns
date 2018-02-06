package com.stylefeng.guns.rest.modular.adverse.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
    @ApiOperation("上传一个图片附件，并新增图片附件记录")
    @RequestMapping(method = RequestMethod.POST, path = "/upload/{adverseReactionId}")
    public Tip upload(@RequestPart(required = true) MultipartFile file,@PathVariable("adverseReactionId") Integer adverseReactionId) {
        int id=processOne(file, adverseReactionId);
        return new ErrorTip(200,id+"");
    }

    private int processOne(MultipartFile file, Integer adverseReactionId) {
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

        return id;
    }

    /**
     * 上传图片附件，并新增图片附件记录
     *
     *
     */
    // E:\>curl -X POST "http://localhost/adverseReactionPhoto/uploads/2" -H  "accept: */*" -H  "Content-Type: multipart/form-data" -F "files=@IMG_6119.JPG;type=image/jpeg"  -F "files=@IMG_6119.JPG;type=image/jpeg"
    //{
    //        "code":200,
    //        "message":"62,63,"
    //}
    @ApiOperation("上传多个图片附件，并新增图片附件记录")
    @ApiImplicitParams({
//    	  @ApiImplicitParam(name="files",value="文件列表", dataTypeClass=MultipartFile[].class,paramType = "form",allowMultiple=true,required=true),
    	  //无效，是array [string] 	(formData)，而不是array [file](formData)
    	  @ApiImplicitParam(name="adverseReactionId",value="不良反应记录ID",dataType="int", paramType = "path",example="56")})
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/uploads/{adverseReactionId}")
    public Tip uploads(@ApiParam(value = "文件列表", allowMultiple = true, required = true)@RequestPart(required = true) MultipartFile[] files,@PathVariable("adverseReactionId") Integer adverseReactionId) {
    	String ids="";
    	if(null==files||0==files.length) {
    		return new ErrorTip(501,"文件列表为空"+files);
    	}
    	for(MultipartFile file:files) {
    		int id=processOne(file, adverseReactionId);
    		ids+=id+",";
    	}

        return new ErrorTip(200,ids);
    }
}
