package com.stylefeng.guns.modular.adverse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.persistence.model.AdverseReaction;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.modular.adverse.service.IAdverseReactionService;
import com.stylefeng.guns.modular.adverse.warpper.AdverseReactionWarpper;

/**
 * 不良反应记录控制器
 *
 * @author fengshuonan
 * @Date 2018-01-26 20:06:23
 */
@Controller
@RequestMapping("/adverseReaction")
public class AdverseReactionController extends BaseController {

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
     * 获取不良反应记录列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> stringObjectMap = adverseReactionService.selectMaps(null);
        return super.warpObject(new AdverseReactionWarpper(stringObjectMap));
    }

    /**
     * 新增不良反应记录
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(AdverseReaction adverseReaction) {
        adverseReactionService.insert(adverseReaction);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除不良反应记录
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer adverseReactionId) {
        adverseReactionService.deleteById(adverseReactionId);
        return SUCCESS_TIP;
    }

    /**
     * 修改不良反应记录
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(AdverseReaction adverseReaction) {
        adverseReactionService.updateById(adverseReaction);
        return super.SUCCESS_TIP;
    }

    /**
     * 不良反应记录详情
     */
    @RequestMapping(value = "/detail/{adverseReactionId}")
    @ResponseBody
    public Object detail(@PathVariable("adverseReactionId") Integer adverseReactionId) {
        return adverseReactionService.selectById(adverseReactionId);
    }
}
