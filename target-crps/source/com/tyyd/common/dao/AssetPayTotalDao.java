package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetPayTotalDao extends BaseDao {

	/**
	 * 更新资产ID、成本CD对应的合计项
	 * @param assetId：资产ID
	 * @param itemCd：收入项
	 * @param userId：用户ID
	 * @param detailTblName：明细表名
	 * @return
	 */
	Integer updatePayTotalByAssIdAndItemCd(Long assetId, String itemCd, Long userId, String detailTblName);

	/**
	 * 根据资产ID和成本项CD，查找是否存在符合要求的合计项
	 * @param assetId
	 * @param itemCd
	 * @return
	 */
	Integer countPayTotalByAIdAndItemCd(Long assetId, String itemCd);
	
	/**
	 * 根据资产ID，查找是否存在符合要求的合计项
	 * @param assetId
	 * @param itemCd
	 * @return
	 */
	Integer countPayTotalByAId(Long assetId);
	
	/**
	 * 根据资产ID， 删除资产合计项
	 * @param assetId
	 * @return
	 */
	Integer deletePayTotalByAId(Long assetId);
	
	/**
	 * 根据资产ID和成本项获取成本合计
	 * 
	 * @param assetId
	 * @param payItemCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetPayTs(Long assetId, String payItemCd);
}
