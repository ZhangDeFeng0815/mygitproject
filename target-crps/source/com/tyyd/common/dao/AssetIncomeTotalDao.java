package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetIncomeTotalDao extends BaseDao {

	/**
	 * 根据资产ID和收入项查找合计项
	 * 
	 * @param assetId：资产ID
	 * @param itemCd：收入项
	 * @return
	 */
	Map<String, Object> getIncTotalByAssIdAndItemCd(Long assetId, String itemCd);

	/**
	 * 更新资产ID、收入CD对应的合计项
	 * 
	 * @param assetId：资产ID
	 * @param itemCd：收入项
	 * @param userId：用户ID
	 * @param detailTblName：明细表名
	 * @return
	 */
	Integer updateIncTotalByAssIdAndItemCd(Long assetId, String itemCd, Long userId, String detailTblName);

	/**
	 * 根据资产ID和收入项CD，查找是否存在符合要求的合计项
	 * 
	 * @param assetId
	 * @param itemCd
	 * @return
	 */
	Integer countIncTotalByAIdAndItemCd(Long assetId, String itemCd);

	/**
	 * 根据资产ID，查找是否存在符合要求的合计项
	 * 
	 * @param assetId
	 * @param itemCd
	 * @return
	 */
	Integer countIncTotalByAId(Long assetId);

	/**
	 * 根据资产ID， 删除资产合计项
	 * 
	 * @param assetId
	 * @return
	 */
	Integer deleteIncTotalByAId(Long assetId);

	/**
	 * 根据资产ID和收入成本项获取收入合计
	 * 
	 * @param assetId
	 * @param incomeItemCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetIncomeTs(Long assetId, String incomeItemCd);
}
