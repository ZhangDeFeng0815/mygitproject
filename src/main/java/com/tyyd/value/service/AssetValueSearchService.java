/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: zhangdf
 * 创建日期: 2018-3-9
 * 文件说明: 版权资产子系统  资产价值管理查询 Service
 */
package com.tyyd.value.service;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.BusinessException;

public interface AssetValueSearchService {
	/**
	 * 根据资产ID查询成本明细
	 * 
	 * @param assetId
	 * @param payItemCd
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> selectAssetPayDs(Long assetId, String payItemCd, String contractCd)
			throws BusinessException;

	/**
	 * 根据资产ID查询成本合计
	 * 
	 * @param assetId
	 * @param payItemCd
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> selectAssetPayTs(Long assetId, String payItemCd) throws BusinessException;
	
	/**
	 * 根据资产ID查询收入明细
	 * 
	 * @param assetId
	 * @param incomeItemCd
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> selectAssetIncomeDs(Long assetId, String incomeItemCd, String contractCd)
			throws BusinessException;

	/**
	 * 根据资产ID查询收入合计
	 * 
	 * @param assetId
	 * @param incomeItemCd
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> selectAssetIncomeTs(Long assetId, String incomeItemCd) throws BusinessException;
}
