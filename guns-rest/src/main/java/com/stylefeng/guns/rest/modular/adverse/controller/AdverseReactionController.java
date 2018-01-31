package com.stylefeng.guns.rest.modular.adverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.rest.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.rest.modular.adverse.service.IAdverseReactionService;

import io.swagger.annotations.ApiOperation;

/**
 * 不良反应记录控制器
 *
 * @author fengshuonan
 * @Date 2018-01-31 22:35:38
 */
@RestController
@RequestMapping("/adverseReaction")
public class AdverseReactionController extends BaseController {

    @Autowired
    private IAdverseReactionService adverseReactionService;

    /**
     * 新增不良反应记录
     */
    @ApiOperation("新增不良反应记录")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Tip add(@RequestBody AdverseReaction adverseReaction) {
    	if(null==adverseReaction)
    		return new ErrorTip(301,"操作失败，入参为null");

        adverseReactionService.insert(adverseReaction);

        int id=adverseReaction.getId();
        return new ErrorTip(200,id+"");
    }

}
