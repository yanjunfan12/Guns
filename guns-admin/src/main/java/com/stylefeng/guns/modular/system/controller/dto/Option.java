package com.stylefeng.guns.modular.system.controller.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * 下拉框select对应结果option
 *
 * {
      "id": 1,
      "text": "Option 1"
    }
 *
 * @author fanyj
 *
 */
@ApiModel(value="结果返回数据对象Tip",description="结果返回数据对象")
public class Option  implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="下拉框select选项Option的ID",required=true)
	private int id;
	@ApiModelProperty(value="下拉框select选项Option的文本",required=true)
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


}
