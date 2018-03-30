/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: qintao
 * 创建日期: 2018-3-5
 * 文件说明: 版权资产子系统  资产查询 Service
 */
package com.tyyd.asset.service;

import java.util.List;
import java.util.Map;

import com.tyyd.common.po.ConfigInfo;
import com.tyyd.framework.core.BusinessException;

public interface AssetSearchService {

	/**
	 * 查询资产列表
	 * 
	 * @param wkNameList
	 * @param rightBList
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> searchAssetList(List<String> assetCdList, List<String> wkNameList,
			List<ConfigInfo> rightBList, Map<String, Object> params, String startRow, String endRow)
			throws BusinessException;

	/**
	 * 查询资产列表总记录数
	 * 
	 * @param wkNameList
	 * @param rightBList
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public int searchAssetListCount(List<String> assetCdList, List<String> wkNameList, List<ConfigInfo> rightBList,
			Map<String, Object> params) throws BusinessException;

	/**
	 * 按条件查询导出资产列表
	 * 
	 * @param wkNameList
	 * @param rightBList
	 * @param params
	 * @param lastAssetId
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> searchAssetsExport(List<String> assetCdList, List<String> wkNameList, List<ConfigInfo> rightBList,
			Map<String, Object> params, Long lastAssetId) throws BusinessException;

	/**
	 * 查询单个资产基本信息
	 * 
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getAssetInfoById(Long assetId) throws BusinessException;

	/**
	 * 查询配置
	 * 
	 * @param type
	 * @param name
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> searchConfigs(Integer type, String name) throws BusinessException;

	/**
	 * 根据资产ID查询权利项汇总
	 * 
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> selectAssetRightTs(Long assetId) throws BusinessException;

	/**
	 * 根据资产ID查询权利项详情
	 * 
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> selectAssetRightDs(Long assetId, String rightCd, String rightName, String contractCd) throws BusinessException;

	/**
	 * 根据资产编号获取资产信息
	 * 
	 * @param assetCd
	 * @return
	 */
	public Map<String, Object> getAssetInfoByAssetCd(String assetCd) throws BusinessException;

	/**
	 * 根据合同编号查询资产ID
	 * 
	 * @param contractCd
	 * @return
	 */
	public List<Long> selectAssetIdsByContractCd(String contractCd);

	/**
	 * 根据资产和合同导出权利详情
	 * 
	 * @param assetId
	 * @param contractCd
	 * @return
	 */
	public List<Map<String, Object>> selectAssetRightDsByAssetIdAndContractCd(Long assetId, String contractCd)
			throws BusinessException;
	
	/**
	 * 查询单个资产权利明细
	 * @param assetRightDId
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException;
}
