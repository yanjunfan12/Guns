package com.stylefeng.guns.core.base.tips;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回给前台的提示（最终转化为json形式）
 *
 * @author fengshuonan
 * @Date 2017年1月11日 下午11:58:00
 */
@ApiModel(value="结果返回数据对象Tip",description="结果返回数据对象")
public abstract class Tip {

	@ApiModelProperty(value="返回码，200成功，其他失败")
    protected int code;
	@ApiModelProperty(value="返回信息")
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
