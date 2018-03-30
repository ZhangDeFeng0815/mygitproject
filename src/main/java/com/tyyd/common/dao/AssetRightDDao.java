package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface AssetRightDDao extends BaseDao {

	/**
	 * 根据资产ID查询版权权利项详情
	 * 
	 * @param assetId
	 * @param rightCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetRightDs(Long assetId, String rightCd, String rightName, String contractCd);

	/**
	 * 根据资产和合同导出权利详情
	 * 
	 * @param assetId
	 * @param contractCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetRightDsByAssetIdAndContractCd(Long assetId, String contractCd);
	
	/**
	 * 根据资产ID，查找对应的权利明细信息
	 * @param assetId
	 * @return
	 */
	List<Map<String, Object>> selectRightDOfRtByRtId(Long assetId);
	
	/**
	 * 根据资产ID，删除所有权利项
	 * @param assetId
	 * @return
	 */
	Integer deleteRightDByAssetId(Long assetId);
	
	/**
	 * 根据合同编号删除资产权利明细
	 * @param contractCd
	 * @return
	 */
	public Integer deleteAssetRightDByContractCd(String contractCd);
	
	/**
	 * 版权权利项详情按照更新时间排序
	 * 
	 * @param assetId
	 * @param rightCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetRightDsOrderByUpdateDate(Long assetId, String rightCd, String contractCd);
}
