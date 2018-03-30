/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: QinTao
 * 创建日期: 2018-3-7
 * 文件说明: 文字版权管理系统 资产库Scf Service
 */
package com.tyyd.crps.scf.asset.service;

import java.util.List;

import com.tyyd.crps.scf.asset.dto.AssetDto;
import com.tyyd.crps.scf.asset.dto.AssetRightDDto;
import com.tyyd.crps.scf.asset.dto.AssetRightTDto;
import com.tyyd.crps.scf.asset.dto.ConfigDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfAssetSearchService {
	/**
	 * 查询资产列表
	 * 
	 * @param assetDto
	 * @return
	 * @throws BusinessException
	 */
	public List<AssetDto> searchAssetList(AssetDto assetDto) throws BusinessException;

	/**
	 * 查询资产列表总记录数
	 * 
	 * @param assetDto
	 * @return
	 * @throws BusinessException
	 */
	public int searchAssetListCount(AssetDto assetDto) throws BusinessException;

	/**
	 * 按条件查询导出资产列表
	 * 
	 * @param partnerNameList
	 * @param params
	 * @param lastPartnerId
	 * @return
	 * @throws BusinessException
	 */
	public List<AssetDto> searchAssetsExport(AssetDto assetDto) throws BusinessException;

	/**
	 * 查询单个资产基本信息
	 * 
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public AssetDto getAssetInfoById(Long assetId) throws BusinessException;

	/**
	 * 查询权利项
	 * 
	 * @param type
	 * @param name
	 * @return
	 * @throws BusinessException
	 */
	public List<ConfigDto> searchConfigs(Integer type, String name) throws BusinessException;

	/**
	 * 根据资产ID查询权利项汇总信息
	 * 
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public List<AssetRightTDto> selectAssetRightTs(Long assetId) throws BusinessException;

	/**
	 * 根据资产ID和其他条件查询权利项详情
	 * 
	 * @param assetId
	 * @param rightCd
	 * @return
	 * @throws BusinessException
	 */
	public List<AssetRightDDto> selectAssetRightDs(Long assetId, String rightCd, String rightName, String contractCd)
			throws BusinessException;

	/**
	 * 根据资产编号获取资产信息
	 * 
	 * @param assetCd
	 * @return
	 */
	public AssetDto getAssetInfoByAssetCd(String assetCd) throws BusinessException;

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
	public List<AssetRightDDto> selectAssetRightDsByAssetIdAndContractCd(Long assetId, String contractCd)
			throws BusinessException;

	/**
	 * 查询单个资产权利明细
	 * 
	 * @param assetRightDId
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public AssetRightDDto getAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException;
}
