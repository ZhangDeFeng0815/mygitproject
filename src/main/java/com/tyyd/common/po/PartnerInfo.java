/**
 * 合作商基本信息
 */
package com.tyyd.common.po;

import java.io.Serializable;

public class PartnerInfo extends PoBaseInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -462656561136498391L;
	// 电合作商ID
	private Long partnerId = null;
	// 合作商名称
	private String partnerName = null;
	// 合作商类型 int 1：机构 2：个人
	private Integer partnerType = null;
	// 是否已删除 int 1：已删除 2：未删除 是否已删除 1:已删除 2:未删除
	private Integer isDeleted = null;
	// 合作商简介 varchar(1024)
	private String memo = "";

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public Integer getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(Integer partnerType) {
		this.partnerType = partnerType;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
