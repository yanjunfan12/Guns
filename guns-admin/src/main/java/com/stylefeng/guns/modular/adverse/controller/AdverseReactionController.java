package com.stylefeng.guns.modular.adverse.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.common.annotion.Permission;
import com.stylefeng.guns.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionService;
import com.stylefeng.guns.modular.adverse.warpper.AdverseReactionWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * 不良反应记录控制器
 *
 * @author fanyj
 * @Date 2018-01-26 20:06:23
 */
@Controller
@RequestMapping("/adverseReaction")
public class AdverseReactionController extends BaseController {

    private String PHOTO_PREFIX = "/adverse/adverseReactionPhoto/";

    private String PREFIX = "/adverse/adverseReaction/";

    @Autowired
    private IAdverseReactionService adverseReactionService;

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
     * 获取不良反应记录列表
     */
    @Permission
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String patientNumber) {
        EntityWrapper<AdverseReaction> adverseReactionEntityWrapper = new EntityWrapper<AdverseReaction>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);
        if(!StringUtils.isBlank(patientNumber))
        	adverseReactionEntityWrapper.eq("patient_number", patientNumber);

    	List<Map<String, Object>> stringObjectMap = adverseReactionService.selectMaps(adverseReactionEntityWrapper);
        return super.warpObject(new AdverseReactionWarpper(stringObjectMap));
    }

    /**
     * 新增不良反应记录
     */
    @Permission
    @ApiOperation("新增不良反应记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Tip add(@RequestBody AdverseReaction adverseReaction) {
    	if(null==adverseReaction)
    		return new ErrorTip(301,"操作失败，入参为null");

        adverseReactionService.insert(adverseReaction);

        int id=adverseReaction.getId();
        return new ErrorTip(200,id+"");
    }

    /**
     * 修改不良反应记录
     */
    @Permission
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(AdverseReaction adverseReaction) {
        adverseReactionService.updateById(adverseReaction);
        return super.SUCCESS_TIP;
    }

    /**
     * 不良反应记录详情
     */
    @Permission
    @RequestMapping(value = "/detail/{adverseReactionId}")
    @ResponseBody
    public Object detail(@PathVariable("adverseReactionId") Integer adverseReactionId) {
        return adverseReactionService.selectById(adverseReactionId);
    }

    /**
     * 下载符合条件的不良反应列表
     * @throws IOException
     */
    @Permission
    @RequestMapping(value = "/exportAll")
    public ResponseEntity<byte[]> exportAll(@RequestParam(required = false) String name, @RequestParam(required = false) String patientNumber) throws IOException {
        EntityWrapper<AdverseReaction> adverseReactionEntityWrapper = new EntityWrapper<AdverseReaction>();
        if(!StringUtils.isBlank(name))
        	adverseReactionEntityWrapper.like("name", name,SqlLike.RIGHT);
        if(!StringUtils.isBlank(patientNumber))
        	adverseReactionEntityWrapper.eq("patient_number", patientNumber);

    	List<Map<String, Object>> stringObjectMap = adverseReactionService.selectMaps(adverseReactionEntityWrapper);
    	List<Map<String, Object>> list=(List<Map<String, Object>>) super.warpObject(new AdverseReactionWarpper(stringObjectMap));

        byte[] bytes=ExcelUtils.buildBytes(list);
		return renderFile("sxssf.xlsx", bytes);
    }


}
