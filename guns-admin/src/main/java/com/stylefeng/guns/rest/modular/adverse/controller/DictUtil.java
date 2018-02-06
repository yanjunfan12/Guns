package com.stylefeng.guns.rest.modular.adverse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.common.constant.cache.Cache;
import com.stylefeng.guns.common.constant.cache.CacheKey;
import com.stylefeng.guns.common.persistence.dao.DictMapper;
import com.stylefeng.guns.common.persistence.model.Dict;
import com.stylefeng.guns.core.util.SpringContextHolder;

@Component
@DependsOn("springContextHolder")
public class DictUtil {

	private DictMapper dictMapper = SpringContextHolder.getBean(DictMapper.class);

	private Log log = LogFactory.getLog(DictUtil.class);

    public static DictUtil me() {
        return SpringContextHolder.getBean("dictUtil");
    }

	/**
	 *
	 * 根据父节点名称parentName，找出其所有字典（字典编号为主键，字典为内容的Map）
	 *
	 * @param parentName 父节点名称,trim后有效。
	 * @return
	 */
	 @Cacheable(value = Cache.DICT, key = "'" + CacheKey.DICT_PNAME + "'+#parentName")
	 public Map<Integer,Dict> getDictsOfParent(String parentName){
		log.info("根据父节点名称parentName，找出其所有字典（字典编号为主键，字典为内容的Map）,parentName="+parentName);
		Map<Integer,Dict> results=new HashMap<Integer,Dict>();
		if(StringUtils.isBlank(parentName)) {
			return results;
		}

		parentName=parentName.trim();

		Dict temp = new Dict();
		temp.setName(parentName);
		temp.setPid(0);//一级字典的父节点为根
		Dict dict = dictMapper.selectOne(temp);
		if (null!=dict) {
		    Wrapper<Dict> wrapper = new EntityWrapper<>();
		    wrapper = wrapper.eq("pid", dict.getId());
		    List<Dict> dicts = dictMapper.selectList(wrapper);
		    for(Dict d:dicts) {
		    	int num=d.getNum();//字典编号
		    	String nameTrim=null!=d.getName()?d.getName().trim():null;
		    	d.setName(nameTrim);
		    	results.put(num, d);
		    }
		}else {
			log.warn(parentName+"没有数据字典");
		}

		return results;
	 }
}
