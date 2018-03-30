/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: wangdf
 * 创建日期: 2018-3-21
 * 文件说明: 归集表Service
 */
package com.tyyd.common.service;

import java.util.List;

public interface MyAppBaseService {
	/**
	 * 版权资产权利变更后的数据库表同步
	 * 
	 * 1.同步表：
	 * 1）BO_ASSET_RIGHT_T
	 * 2）BO_CONTRACT_IN_ASSET
	 * 
	 * 2.同步逻辑：
	 * 1）先删除表中的数据：BO_ASSET_RIGHT_T、BO_CONTRACT_IN_ASSET
	 * 2）归集数据：
	 *    BO_ASSET_RIGHT_D > BO_ASSET_RIGHT_T、BO_CONTRACT_IN_ASSET
	 */
	public void syncRight(List<String> contractCdList, long assetId, long userId);

	/**
	 * 版权资产成本变更后的数据库表同步
	 * 
	 * 1.同步表：
	 * 1）BO_ASSET
	 * 2）BO_ASSET_PAY_T
	 * 3）BO_CONTRACT_IN_ASSET
	 * 
	 * 2.同步逻辑：
	 * 1）先删除表中的数据：BO_ASSET_PAY_T、BO_CONTRACT_IN_ASSET
	 * 2）归集数据：
	 *    BO_ASSET_PAY_D > BO_ASSET_PAY_T、BO_CONTRACT_IN_ASSET
	 *    BO_ASSET_PAY_T > BO_ASSET的总成本
	 */
	public void syncPay(String contractCd, long assetId, long userId);


	/**
	 * 版权资产收入变更后的数据库表同步
	 * 
	 * 1.同步表：
	 * 1）BO_ASSET
	 * 2）BO_ASSET_PAY_T
	 * 3）BO_CONTRACT_IN_ASSET
	 * 
	 * 2.同步逻辑：
	 * 1）先删除表中的数据：BO_ASSET_INCOME_T、BO_CONTRACT_OUT_ASSET
	 * 2）归集数据：
	 *    BO_ASSET_INCOME_D > BO_ASSET_INCOME_T、BO_CONTRACT_OUT_ASSET
	 *    BO_ASSET_INCOME_T > BO_ASSET的总收入
	 */
	public void syncIncome(String contractCd, long assetId, long userId);
	
}
