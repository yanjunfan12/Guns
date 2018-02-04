package com.stylefeng.guns.modular.system.controller;

import java.io.Serializable;

/**
 *
 * 下拉框select2对于结果option
 *
 * {
      "id": 1,
      "text": "Option 1"
    }
 *
 * @author fanyj
 *
 */
public class Option  implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int id;
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
