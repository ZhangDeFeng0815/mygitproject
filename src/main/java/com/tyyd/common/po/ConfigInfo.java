/**
 * 资产基本信息
 */
package com.tyyd.common.po;

import java.io.Serializable;

public class ConfigInfo extends PoBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2210547371804859781L;
	private Long configId = null;
	// 类型 1：版权权利项 2：版权成本项 3：版权收入项
	private Integer type = null;
	private String cd = null;
	private String name = null;
	private Integer is_deleted = null;
	private Integer seqno = null;
	private String memo = null;

	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
