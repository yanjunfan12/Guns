package com.stylefeng.guns.rest.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 测试用的
 *
 * @author fengshuonan
 * @date 2017-08-25 16:47
 */
@ApiModel(value="请求数据对象SimpleObject",description="请求数据对象")
public class SimpleObject {

	@ApiModelProperty(value="用户",required=true)
    private String user;

	@ApiModelProperty(value="名称",required=true)
    private String name;

	@ApiModelProperty(value="建议",required=true)
    private String tips;

	@ApiModelProperty(value="年龄",required=true)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
