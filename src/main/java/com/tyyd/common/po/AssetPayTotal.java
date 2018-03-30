package com.tyyd.common.po;

import java.io.Serializable;

public class AssetPayTotal extends PoBaseInfo implements Serializable {

	private static final long serialVersionUID = 3608866740528456502L;
	
	// ASSET_PAY_D_ID 版权资产成本分类合计ID
	private Long id = null;
	// ASSET_ID:版权资产ID
	private Long assetId = null;
	// PAY_ITEM_CD : 成本项CD
	private String payItemCd = null;
	// MONEY : 金额(分)
	private Long money = null;
	// CONTRACT_CD : 合同编号
	private String contractCd = null;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getPayItemCd() {
		return payItemCd;
	}
	public void setPayItemCd(String payItemCd) {
		this.payItemCd = payItemCd;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	public String getContractCd() {
		return contractCd;
	}
	public void setContractCd(String contractCd) {
		this.contractCd = contractCd;
	}
}
