/**
 * 获权合同资产关联表
 */
package com.tyyd.common.po;

import java.io.Serializable;

public class ContractInAsset extends PoBaseInfo implements Serializable {

	private static final long serialVersionUID = -1578360065320447584L;
	
	// CONTRACT_ASSET_ID：合同资产关联ID
	private Long contractAssetId = null;
	
	// CONTRACT_ID：合同ID
	private Long contractId = null;
	
	// ASSET_ID：版权资产ID
	private Long assetId = null;

	public Long getContractAssetId() {
		return contractAssetId;
	}

	public void setContractAssetId(Long contractAssetId) {
		this.contractAssetId = contractAssetId;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
}
