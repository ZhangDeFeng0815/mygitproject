package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetRightTDao extends BaseDao {

	/**
	 * 根据资产ID查询汇总权利项
	 * 
	 * @param assetId
	 * @param rightCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetRightTs(Long assetId, String rightCd);

	/**
	 * 根据资产ID，查找对应的权利信息
	 * 
	 * @param assetId
	 * @return
	 */
	List<Map<String, Object>> selectAllRightsOfAssetByAssetId(Long assetId);
	
	/**
	 * 根据合同编号删除资产权利汇总
	 * @param contractCd
	 * @return
	 */
	public Integer deleteAssetRightTByContractCd(String contractCd);

	/**
	 * 根据资产ID，删除归集表的所有权利汇总
	 * 
	 * @param assetId
	 * @return
	 */
	Integer deleteRightTByAssetId(Long assetId);
}
