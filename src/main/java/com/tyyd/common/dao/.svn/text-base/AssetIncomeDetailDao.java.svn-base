package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetIncomeDetailDao extends BaseDao {

	/**
	 * 根据资产ID，获取按收入项、资产ID group by分后的，收入合计值
	 * @param assetId
	 * @return
	 */
	List<Map<String, Object>> selectIncSumOfItemCdByAssetId(Long assetId);
	
	/**
	 * 从Detail表归集数据到，合同收入关联表
	 * @param assetId
	 * @param userId
	 * @return
	 */
	Integer insertIntoContractOutAsset(Long assetId, Long userId);
	
	/**
	 * 根据资产ID和收入项获取收入明细
	 * 
	 * @param assetId
	 * @param incomeItemCd
	 * @param contractCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetIncomeDs(Long assetId, String incomeItemCd, String contractCd);
}
