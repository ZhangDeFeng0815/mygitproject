package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetPayDetailDao extends BaseDao {

	/**
	 * 根据资产ID和成本项获取成本明细
	 * 
	 * @param assetId
	 * @param payItemCd
	 * @param contractCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetPayDs(Long assetId, String payItemCd, String contractCd);
	
	/**
	 * 根据资产ID，获取按成本项、资产ID group by分后的，收入合计值
	 * @param assetId
	 * @return
	 */
	List<Map<String, Object>> selectPaySumOfItemCdByAssetId(Long assetId);
}
