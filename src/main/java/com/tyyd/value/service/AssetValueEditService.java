/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: zhangdf
 * 创建日期: 2018-3-9
 * 文件说明: 版权资产子系统  资产价值管理修改 Service
 */
package com.tyyd.value.service;

import java.time.Instant;
import java.util.List;

import com.tyyd.common.po.AssetIncomeDetail;
import com.tyyd.common.po.AssetPayDetail;
import com.tyyd.framework.core.BusinessException;

public interface AssetValueEditService {

	/**
	 * 保存资产收入明细
	 * @param userId：操作人
	 * @param inc：收入项
	 * @return：成功个数
	 * @throws BusinessException
	 */
	Integer saveIncomeDetail(Long userId, AssetIncomeDetail inc, Instant is) throws BusinessException;

	/**
	 * 批量新增收入明细
	 * @param userId：操作人
	 * @param incList：收入项List
	 * @param contractCd：合同编号
	 * @return：成功个数
	 * @throws BusinessException
	 */
	Integer batchSaveIncomeDetail(Long userId, List<AssetIncomeDetail> incList, String contractCd) throws BusinessException;
	
	/**
	 * 保存资产成本明细
	 * @param userId
	 * @param pay
	 * @return
	 * @throws BusinessException
	 */
	Integer savePayDetail(Long userId, AssetPayDetail pay, Instant is) throws BusinessException;
	
	/**
	 * 批量保存资产成本明细
	 * @param userId
	 * @param payList
	 * @return
	 * @throws BusinessException
	 */
	Integer batchSavePayDetail(Long userId, List<AssetPayDetail> payList, String contractCd) throws BusinessException;
	
	/**
	 * 统计资产的收入项个数
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	Integer countIncTotalByAId(Long assetId) throws BusinessException;
	
	/**
	 * 统计资产的成本项个数
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	Integer countPayTotalByAId(Long assetId) throws BusinessException;
}
