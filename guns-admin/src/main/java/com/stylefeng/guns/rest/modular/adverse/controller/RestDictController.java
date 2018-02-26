package com.stylefeng.guns.rest.modular.adverse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.persistence.model.Dict;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.controller.dto.Option;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 字典控制器
 *
 * @author fanyj
 * @Date 2018年2月6日 12:55:31
 */
@Validated
@Controller
@RequestMapping("/rest/dict")
public class RestDictController extends BaseController {

	private Log log = LogFactory.getLog(RestDictController.class);

    @Resource
    DictUtil dictUtil;

    /**
     *
     * 获得parentName下拉框select option的数据字典
     *
     * @param parentName
     * @return
     */
    @ApiOperation("根据父节点字典名称，获得下拉框select option的数据字典")
    @RequestMapping(method = RequestMethod.GET,value = "/selectOptions")
    @ResponseBody
    public List<Option> dict4Select2(
    		@ApiParam(value = "父节点字典名称", required = true)
    		@RequestParam
    		String parentName) {

    	log.debug("获得parentName下拉框select2的数据字典,parentName="+parentName);

    	List<Option> results=new ArrayList<Option>();

    	Map<Integer,Dict> map = DictUtil.me().getDictsOfParent(parentName);
        if (!map.isEmpty()) {
            for(int num:map.keySet()) {
            	Option o=new Option();
            	o.setId(num);//字典编号
            	o.setText(map.get(num).getName());//字典中文值
            	results.add(o);
            }
        }else {
        	log.warn(parentName+"没有数据字典");
        }

        return results;
    }

}
