/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: qintao
 * 创建日期: 2018-3-5
 * 文件说明: 合作商子系统  合作商编辑 Service
 */
package com.tyyd.asset.service;

import java.util.List;
import java.util.Map;

import com.tyyd.common.service.MyAppBaseService;
import com.tyyd.framework.core.BusinessException;

public interface AssetEditService extends MyAppBaseService {

	/**
	 * 新增保存资产
	 * 
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public Integer saveAssetForAdd(Map<String, Object> params) throws BusinessException;

	/**
	 * 修改保存资产
	 * 
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public Integer saveAssetForEdit(Map<String, Object> params) throws BusinessException;

	/**
	 * 删除指定资产
	 * 
	 * @param partnerId
	 * @return
	 * @throws BusinessException
	 */
	public Integer deleteAsset(Long assetId) throws BusinessException;

	/**
	 * 批量导入资产
	 * 
	 * @param assetMapLsit
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> batchImportAsset(Long userId, List<Map<String, Object>> assetMapLsit)
			throws BusinessException;

	/**
	 * 判断指定条件的资产是否已经存在
	 * 
	 * @param wkName：资产名称
	 * @param authorS：作者实名
	 * @param authorB：作者笔名
	 * @param mediaTypeId：媒体类型ID
	 * @return
	 * @throws BusinessException
	 */
	public Integer assetExistsCheck(String wkName, String auNameS, String auNameB, Integer mediaTypeId)
			throws BusinessException;

	/**
	 * 修改资产信息
	 * 
	 * @param assetMap
	 * @return
	 * @throws BusinessException
	 */
	public Integer editAssetInfo(Map<String, Object> assetMap, Long userId) throws BusinessException;

	/**
	 * 批量删除资产
	 * 
	 * @param asserIdList
	 * @param userId
	 * @return
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
	 * 根据Id删除指定的单条权利明细
	 * 
	 * @param assetRightDId
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Integer deleteAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException;

	/**
	 * 保存权利明细
	 * 
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public Integer saveAssetRightD(Map<String, Object> params) throws BusinessException;
}
