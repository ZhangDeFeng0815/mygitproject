/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: Zhangdf
 * 创建日期: 2018-3-15
 * 文件说明: 常量标识枚举类
 */
package com.tyyd.common.codebook;

import java.io.Serializable;

public enum IncomeDItemEnum implements Serializable {
	SHARED_REVENUE("1", "分成收入"), MINIMUM_INC("2", "保底收入"), 
	BUY_OUT_INC("3", "买断收入"), STAGE_INC("4", "分期收入"), OTHER("5", "其他收入");

	private String cd;
	private String name;

	private IncomeDItemEnum(String cd, String name) {
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
