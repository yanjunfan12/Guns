package com.stylefeng.guns.rest.modular.adverse.controller;

import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.common.persistence.model.Dict;
import com.stylefeng.guns.core.util.SpringContextHolder;


public class OptionValidatorClass implements ConstraintValidator<OptionValidator, Object> {
	private DictUtil dictUtil = SpringContextHolder.getBean(DictUtil.class);

	private Log log = LogFactory.getLog(OptionValidatorClass.class);

	String message;
    String parentName;
    @Override
    public void initialize(OptionValidator op) {
        this.message = op.message();
        this.parentName = op.parentName();
    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(null==value) {
        	String msg=parentName+message;
        	log.warn(msg);
        	return false;
        }

    	Integer num=(Integer)value;

        Map<Integer,Dict> options=dictUtil.getDictsOfParent(parentName);
        boolean flag=options.containsKey(num);
        if(!flag) {
        	String msg=parentName+"选项只能取"+JSON.toJSONString(options.keySet());
        	log.warn(msg);
        }

        return flag;
    }
}
