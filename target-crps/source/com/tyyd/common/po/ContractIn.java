/**
 * 获权合同表
 */
package com.tyyd.common.po;

import java.io.Serializable;

public class ContractIn extends PoBaseInfo implements Serializable {

	private static final long serialVersionUID = -5663203754896427761L;
	
	// CONTRACT_ID：合同ID
	private Long contractId = null;
	// CONTRACT_CD：合同编号
	private String contractCd = null;
	// PARTNER_ID：合作商ID
	private Long partnerId = null;
	// PARTNER_NAME：合作商名称
	private String partnerName = null;
	// COST_P_1000：千字稿酬
	private Integer costP = null;
	// IS_DELETED：是否已删除
	private Integer isDeleted = null;
	// ATTACHMENT_ID：附件
	private Long attachmentId = null;
	
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getContractCd() {
		return contractCd;
	}
	public void setContractCd(String contractCd) {
		this.contractCd = contractCd;
	}
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
	public Integer getCostP() {
		return costP;
	}
	public void setCostP(Integer costP) {
		this.costP = costP;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Long getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}
}
