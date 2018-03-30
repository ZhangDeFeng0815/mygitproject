/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: Zhangdf
 * 创建日期: 2018-3-9
 * 文件说明: 文字版权管理系统 资产价值Scf Service
 */
package com.tyyd.crps.scf.value.service;

import java.util.List;

import com.tyyd.crps.scf.value.dto.AssetIncomeDetailDto;
import com.tyyd.crps.scf.value.dto.AssetPayDetailDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfAssetValueEditService {

	/**
	 * 批量保存资产收入
	 * @param userId：操作人
	 * @param incList ： 收入明细项List
	 * @param contractCd ： 合同编号
	 * @return：保存成功记录数
	 * @throws BusinessException
	 */
	Integer batchSaveIncomeDetail(Long userId, List<AssetIncomeDetailDto> incList, String contractCd) throws BusinessException;
	
	/**
	 * 批量保存资产成本
	 * @param userId：操作人
	 * @param payList：成本明细项List
	 * @param contractCd ： 合同编号
	 * @return：保存成功记录数
	 * @throws BusinessException
	 */
	Integer batchSavePayDetail(Long userId, List<AssetPayDetailDto> payList, String contractCd) throws BusinessException;
	
	/**
	 * 统计资产的收入、成本项个数
	 * @return
	 * @throws BusinessException
	 */
	Integer countTotalItemByAId(Long assetId) throws BusinessException;
}
