/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: Zhangdf
 * 创建日期: 2018-3-15
 * 文件说明: 常量标识枚举类
 */
package com.tyyd.common.codebook;

import java.io.Serializable;

public enum PayDItemEnum implements Serializable {
	REMUNERATION("1", "不含税成本（稿酬）"), VALUE_ADDED_TAX("2", "增值税"), 
	ADDITIONAL_TAX("3", "附加税"), INCOME_TAX("4", "个税"), OTHER("5", "其他成本");

	private String cd;
	private String name;

	private PayDItemEnum(String cd, String name) {
		this.name = name;
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

}
