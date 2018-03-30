package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetDao extends BaseDao {

	/**
	 * 按条件查询资产
	 * 
	 * @param wkNameList
	 * @param rightB
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public List<Map<String, Object>> selectAssetsByParams(List<String> assetCdList, List<String> wkNameList,
			Long rightB, Map<String, Object> params, String startRow, String endRow);

	/**
	 * 查询资产总记录数
	 * 
	 * @param wkNameList
	 * @param rightB
	 * @param params
	 * @return
	 */
	public Integer selectAssetsCountByParams(List<String> assetCdList, List<String> wkNameList, Long rightB,
			Map<String, Object> params);

	/**
	 * 查询资产导出
	 * 
	 * @param wkNameList
	 * @param rightB
	 * @param params
	 * @param lastAssetId
	 * @return
	 */
	public List<Map<String, Object>> selectAssetsExport(List<String> assetCdList, List<String> wkNameList, Long rightB,
			Map<String, Object> params, Long lastAssetId);

	/**
	 * 计算指定条件的资产个数
	 * 
	 * @param wkName：资产名
	 * @param auNameS：作者实名
	 * @param auNameB：作者笔名
	 * @param mediaTypeId：媒体类型
	 * @return
	 */
	public Integer countAssetByVaules(String wkName, String auNameS, String auNameB, Integer mediaTypeId);

	/**
	 * 更新收入合计项
	 * 
	 * @param assetId
	 * @param userId
	 * @param incTblName
	 * @return
	 */
	public Integer updateAssetTotalInc(Long assetId, Long userId, String incTblName);

	/**
	 * 更新成本合计项
	 * 
	 * @param assetId
	 * @param userId
	 * @param payTblName
	 * @return
	 */
	public Integer updateAssetTotalPay(Long assetId, Long userId, String payTblName);

	/**
	 * 根据资产编号获取资产信息
	 * 
	 * @param assetCd
	 * @return
	 */
	public Map<String, Object> selectAssetInfoByAssetCd(String assetCd);

	/**
	 * 更新资产信息
	 * 
	 * @param params
	 * @param userId
	 * @return
	 */
	public Integer updateAssetInfo(Map<String, Object> params, Long userId);

}
