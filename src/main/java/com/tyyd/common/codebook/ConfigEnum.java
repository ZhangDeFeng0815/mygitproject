/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: Zhangdf
 * 创建日期: 2018-3-15
 * 文件说明: 常量标识枚举类
 */
package com.tyyd.common.codebook;

import java.io.Serializable;

public enum ConfigEnum implements Serializable {
	RIGHT(1, "版权权利项"), PAY(2, "版权成本项"), 
	INCOME(3, "版权收入项");

	private Integer type;
	private String name;

	private ConfigEnum(Integer type, String name) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
