package com.tyyd.common.po;

import java.io.Serializable;
import java.util.Date;

public class PoBaseInfo implements Serializable {
	private static final long serialVersionUID = 6118676948784458958L;

	// CREATE_DATE 创建时间
	private Date createDate = null;
	// UPDATE_DATE 更新时间
	private Date updateDate = null;
	// CREATE_USERID 创建人
	private Long createUserId = null;
	// UPDATE_USERID 更新人
	private Long updateUserId = null;

	private String createUserName = null;
	
	private String updateUserName = null;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

}
