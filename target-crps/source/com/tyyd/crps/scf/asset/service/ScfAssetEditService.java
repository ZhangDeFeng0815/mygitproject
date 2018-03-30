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
import com.tyyd.crps.scf.asset.dto.AssetImportResultDto;
import com.tyyd.crps.scf.asset.dto.AssetRightDDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfAssetEditService {

	/**
	 * 新增保存资产
	 * 
	 * @param asset
	 * @return
	 * @throws BusinessException
	 */
	public Integer saveAssetForAdd(AssetDto asset) throws BusinessException;

	/**
	 * 修改保存资产
	 * 
	 * @param asset
	 * @return
	 * @throws BusinessException
	 */
	public Integer saveAssetForEdit(AssetDto asset) throws BusinessException;

	/**
	 * 删除指定资产
	 * 
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Integer deleteAsset(Long assetId) throws BusinessException;
	
	/**
	 * 批量导入资产
	 * @param listDto：资产列表
	 * @return
	 * @throws BusinessException
	 */
	public AssetImportResultDto batchImportAsset(Long userId, List<AssetDto> listDto) throws BusinessException;
	
	/**
	 * 判断指定条件的资产是否已经存在
	 * @param wkName：资产名称
	 * @param authorS：作者实名
	 * @param authorB：作者笔名
	 * @param mediaTypeId：媒体类型ID
	 * @return
	 * @throws BusinessException
	 */
	public Integer assetExistsCheck(String wkName, String auNameS, String auNameB, Integer mediaTypeId) throws BusinessException;
	
	/**
	 * 修改资产信息
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public Integer editAssetInfo(AssetDto dto, Long userId) throws BusinessException;
	
	/**
	 * 批量删除资产
	 * @param assetIdList
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Integer deleteAssetInfos(List<Long> assetIdList, Long userId) throws BusinessException;
	
	/**
	 * 根据合同编号资产权利明细和汇总
	 * 
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public Integer deleteAssetRightByContractCd(String contractCd) throws BusinessException;
	
	/**
	 * 保存权利明细
	 * 
	 * @param assetRightD
	 * @return
	 * @throws BusinessException
	 */
	public Integer saveAssetRightD(AssetRightDDto assetRightD) throws BusinessException;
	
	/**
	 * 版权资产权利变更后的数据库表同步
	 * @param contractCd
	 * @param assetId
	 * @param userId
	 * @throws BusinessException
	 */
	public void syncRight(List<String> contractCdList, String assetCd, long userId) throws BusinessException;
	
	/**
	 * 根据Id删除指定的单条权利明细
	 * 
	 * @param assetRightDId
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Integer deleteAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException;
}
