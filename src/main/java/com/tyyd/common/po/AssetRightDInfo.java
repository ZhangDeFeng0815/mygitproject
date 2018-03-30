/**
 * 资产基本信息
 */
package com.tyyd.common.po;

import java.io.Serializable;
import java.util.Date;

public class AssetRightDInfo extends AssetInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3168126295289207487L;
	private Long assetRightDId = null;
	// 资产ID
	private Long assetId = null;
	private String rightCd = null;
	private String rightName = null;
	private Integer atType = null;
	private Date dateFrom = null;
	private Date dateTo = null;
	private Integer canResale = null;
	private Integer region = null;
	private String contractCd = null;

	public Long getassetRightDId() {
		return assetRightDId;
	}

	public void setassetRightDId(Long assetRightDId) {
		this.assetRightDId = assetRightDId;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getRightCd() {
		return rightCd;
	}

	public void setRightCd(String rightCd) {
		this.rightCd = rightCd;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public Integer getAtType() {
		return atType;
	}

	public void setAtType(Integer atType) {
		this.atType = atType;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getCanResale() {
		return canResale;
	}

	public void setCanResale(Integer canResale) {
		this.canResale = canResale;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getContractCd() {
		return contractCd;
	}

	public void setContractCd(String contractCd) {
		this.contractCd = contractCd;
	}

}
