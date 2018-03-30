/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: wangdf
 * 创建日期: 2018-3-21
 * 文件说明: 归集表Service
 */
package com.tyyd.common.service.impl;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.tyyd.common.dao.AssetDao;
import com.tyyd.common.dao.AssetIncomeDetailDao;
import com.tyyd.common.dao.AssetIncomeTotalDao;
import com.tyyd.common.dao.AssetPayDetailDao;
import com.tyyd.common.dao.AssetPayTotalDao;
import com.tyyd.common.dao.AssetRightDDao;
import com.tyyd.common.dao.AssetRightTDao;
import com.tyyd.common.dao.ContractInAssetDao;
import com.tyyd.common.dao.ContractOutAssetDao;
import com.tyyd.common.service.MyAppBaseService;
import com.tyyd.framework.core.util.ExceptionUtils;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.core.util.SequenceUtils;

public abstract class MyAppBaseServiceImpl implements MyAppBaseService {

	protected static final String SEQ_BO_ASSET_INCOME_T_SKEY = "BO_ASSET_INCOME_T";
	protected static final String SEQ_BO_ASSET_INCOME_T_SUBKEY = "ASSET_INCOME_T_ID";
	protected static final String SEQ_BO_ASSET_INCOME_D_SKEY = "BO_ASSET_INCOME_D";
	protected static final String SEQ_BO_ASSET_INCOME_D_SUBKEY = "ASSET_INCOME_D_ID";
	protected static final String SEQ_BO_ASSET_RIGHT_D_SKEY = "BO_ASSET_RIGHT_D";
	protected static final String SEQ_BO_ASSET_RIGHT_D_SUBKEY = "ASSET_RIGHT_D_ID";
	protected static final String SEQ_BO_ASSET_RIGHT_T_SKEY = "BO_ASSET_RIGHT_T";
	protected static final String SEQ_BO_ASSET_RIGHT_T_SUBKEY = "ASSET_RIGHT_T_ID";
	protected static final String SEQ_BO_ASSET_PAY_T_SKEY = "BO_ASSET_PAY_T";
	protected static final String SEQ_BO_ASSET_PAY_T_SUBKEY = "ASSET_PAY_T_ID";
	protected static final String SEQ_BO_ASSET_PAY_D_SKEY = "BO_ASSET_PAY_D";
	protected static final String SEQ_BO_ASSET_PAY_D_SUBKEY = "ASSET_PAY_D_ID";

	@Resource
	private ContractInAssetDao contractInAssetDao;

	@Resource
	private AssetPayDetailDao assetPayDetailDao;

	@Resource
	private AssetPayTotalDao assetPayTotalDao;

	@Resource
	private AssetRightDDao assetRightDDao;

	@Resource
	private AssetIncomeTotalDao assetIncomeTotalDao;

	@Resource
	private AssetIncomeDetailDao assetIncomeDetailDao;

	@Resource
	private AssetRightTDao assetRightTDao;

	@Resource
	private AssetDao assetDao;

	@Resource
	private ContractOutAssetDao contractOutAssetDao;

	/**
	 * 版权资产权利变更后的数据库表同步
	 * 
	 * 1.同步表： 1）BO_ASSET_RIGHT_T 2）BO_CONTRACT_IN_ASSET
	 * 
	 * 2.同步逻辑： 1）先删除表中的数据：BO_ASSET_RIGHT_T、BO_CONTRACT_IN_ASSET 2）归集数据：
	 * BO_ASSET_RIGHT_D > BO_ASSET_RIGHT_T BO_ASSET_PAY_D + BO_ASSET_RIGHT_D>
	 * BO_CONTRACT_IN_ASSET
	 * 
	 * 3.注意点： 1）一个资产调用一次
	 */
	public void syncRight(List<String> contractCdList, long assetId, long userId) {
		assertSyncParam(contractCdList, assetId, userId);
		/*
		 * 1.归集:BO_ASSET_RIGHT_T
		 */
		sumAssetRightT(assetId, userId);

		/*
		 * 2.归集：BO_CONTRACT_IN_ASSET
		 */
		for (String contractCd : contractCdList) {
			syncContractInAsset(contractCd, assetId, userId);
		}
	}

	/**
	 * 版权资产成本变更后的数据库表同步
	 * 
	 * 1.同步表： 1）BO_ASSET 2）BO_ASSET_PAY_T 3）BO_CONTRACT_IN_ASSET
	 * 
	 * 2.同步逻辑： 1）先删除表中的数据：BO_ASSET_PAY_T、BO_CONTRACT_IN_ASSET 2）归集数据： BO_ASSET_PAY_D
	 * > BO_ASSET_PAY_T BO_ASSET_PAY_D + BO_ASSET_RIGHT_D> BO_CONTRACT_IN_ASSET
	 * BO_ASSET_PAY_T > BO_ASSET的总成本
	 * 
	 * 3.注意点： 1）一个资产调用一次
	 */
	public void syncPay(String contractCd, long assetId, long userId) {
		List<String> contractCdList = new ArrayList<String>();
		if (StringUtils.isNotBlank(contractCd)) {
			contractCdList.add(contractCd);
		}
		assertSyncParam(contractCdList, assetId, userId);
		/*
		 * 1.归集:BO_ASSET_PAY_T
		 */
		sumAssetPayT(assetId, userId);

		/*
		 * 2.归集:BO_ASSET
		 */
		sumAssetPay(assetId, userId);

		/*
		 * 3.归集：BO_CONTRACT_IN_ASSET
		 */
		syncContractInAsset(contractCd, assetId, userId);
	}

	/**
	 * 版权资产收入变更后的数据库表同步
	 * 
	 * 1.同步表： 1）BO_ASSET 2）BO_ASSET_INCOME_T 3）BO_CONTRACT_IN_ASSET
	 * 
	 * 2.同步逻辑： 1）先删除表中的数据：BO_ASSET_INCOME_T、BO_CONTRACT_OUT_ASSET 2）归集数据：
	 * BO_ASSET_INCOME_D > BO_ASSET_INCOME_T、BO_CONTRACT_OUT_ASSET BO_ASSET_INCOME_T
	 * > BO_ASSET的总收入
	 * 
	 * 3.注意点： 1）一个资产调用一次
	 */
	public void syncIncome(String contractCd, long assetId, long userId) {
		/*
		 * 1.归集:BO_ASSET_INCOME_T
		 */
		sumAssetIncomeT(contractCd, assetId, userId);

		/*
		 * 2.归集:BO_ASSET
		 */
		sumAssetIncome(assetId, userId);

		/*
		 * 3.归集：BO_CONTRACT_OUT_ASSET
		 */
		syncContractOutAsset(assetId, userId);
	}

	private void assertSyncParam(List<String> contractCdList, long assetId, long userId) {
		if (contractCdList == null || contractCdList.size() < 1 || assetId < 0) {
			ExceptionUtils.throwAcwsException("版权资产数据归集是参数没有指定!");
		}
	}

	/**
	 * 同步：BO_CONTRACT_IN_ASSET
	 * 
	 * 1.同步表：BO_CONTRACT_IN_ASSET 2.同步逻辑：
	 * 
	 * @param contractCd
	 * @param assetId
	 */
	private void syncContractInAsset(String contractCd, long assetId, long userId) {
		// 1)删除：BO_CONTRACT_IN_ASSET中的数据
		if (StringUtils.isBlank(contractCd)) {
			return;
		}
		contractInAssetDao.deleteByAssetIdAndContractId(contractCd, assetId);

		// 2)归集：BO_ASSET_PAY_D + BO_ASSET_RIGHT_D> BO_CONTRACT_IN_ASSET
		List<Map<String, Object>> assetRightDList = assetRightDDao.selectAssetRightDsByAssetIdAndContractCd(assetId,
				contractCd);
		List<Map<String, Object>> assetPayDList = assetPayDetailDao.selectAssetPayDs(assetId, null, contractCd);
		if ((assetRightDList != null && assetRightDList.size() > 0)
				|| (assetPayDList != null && assetPayDList.size() > 0)) {
			Map<String, Object> params = new HashMap<>();
			MapUtils.safeAddToMap(params, "ASSET_ID", assetId);
			MapUtils.safeAddToMap(params, "CONTRACT_CD", contractCd);
			MapUtils.safeAddToMap(params, "CREATE_USERID", userId);
			MapUtils.safeAddToMap(params, "UPDATE_USERID", userId);
			contractInAssetDao.save(params);
		}
	}

	/**
	 * 同步：BO_CONTRACT_OUT_ASSET
	 * 
	 * 1.同步表：BO_CONTRACT_OUT_ASSET 2.同步逻辑：
	 * 
	 * @param contractCd
	 * @param assetId
	 */
	private void syncContractOutAsset(long assetId, long userId) {
		// 1)删除：BO_CONTRACT_OUT_ASSET中的数据
		contractOutAssetDao.deleteByAssetId(assetId);
		// 2)归集：BO_ASSET_INCOME_D > BO_CONTRACT_OUT_ASSET
		assetIncomeDetailDao.insertIntoContractOutAsset(assetId, userId);
	}

	/**
	 * 归集BO_ASSET_RIGHT_T中的数据
	 * 
	 * @param contractCd
	 * @param assetId
	 */
	private void sumAssetRightT(long assetId, long userId) {
		// 1)删除BO_ASSET_RIGHT_T中的数据
		assetRightTDao.deleteRightTByAssetId(assetId);
		// 2)归集：BO_ASSET_RIGHT_D > BO_ASSET_RIGHT_T
		List<Map<String, Object>> assetRightDList = assetRightDDao.selectAssetRightDsOrderByUpdateDate(assetId, null,
				null);
		if (assetRightDList == null || assetRightDList.size() < 1) {
			return;
		}
		Map<String, Object> rightCdMap = new HashMap<String, Object>();
		for (Map<String, Object> assetRightD : assetRightDList) {
			if (!rightCdMap.containsKey(MapUtils.getString(assetRightD, "RIGHT_CD", ""))) {
				MapUtils.safeAddToMap(rightCdMap, MapUtils.getString(assetRightD, "RIGHT_CD", ""),
						MapUtils.getString(assetRightD, "RIGHT_CD", ""));
			}
		}
		for (String rightCd : rightCdMap.keySet()) {
			List<Map<String, Object>> assetRightDUpdateDateList = assetRightDDao
					.selectAssetRightDsOrderByUpdateDate(assetId, rightCd, null);
			if (assetRightDUpdateDateList != null && assetRightDUpdateDateList.size() > 0) {
				Map<String, Object> params = assetRightDUpdateDateList.get(0);
				if (params.containsKey("ASSET_RIGHT_D_ID")) {
					params.remove("ASSET_RIGHT_D_ID");
				}
				if (params.containsKey("UPDATE_DATE")) {
					params.remove("UPDATE_DATE");
				}
				MapUtils.safeAddToMap(params, "ASSET_RIGHT_T_ID",
						SequenceUtils.getNextValue(SEQ_BO_ASSET_RIGHT_T_SKEY, SEQ_BO_ASSET_RIGHT_T_SUBKEY));
				MapUtils.safeAddToMap(params, "CREATE_USERID", userId);
				MapUtils.safeAddToMap(params, "UPDATE_USERID", userId);
				assetRightTDao.save(params, assetId);
			}
		}
	}

	/**
	 * 归集BO_ASSET_PAY_T中的数据
	 * 
	 * @param assetId
	 */
	private void sumAssetPayT(long assetId, long userId) {
		// 1)删除：BO_ASSET_PAY_T中的数据
		assetPayTotalDao.deletePayTotalByAId(assetId);
		// 2)归集：BO_ASSET_PAY_D > BO_ASSET_PAY_T
		List<Map<String, Object>> detailSumList = assetPayDetailDao.selectPaySumOfItemCdByAssetId(assetId);
		if (detailSumList == null || detailSumList.size() == 0) {
			return;
		}
		detailSumList.forEach(sumMap -> {
			Map<String, Object> addParams = new HashMap<String, Object>();
			MapUtils.safeAddToMap(addParams, "ASSET_PAY_T_ID",
					SequenceUtils.getNextValue(SEQ_BO_ASSET_PAY_T_SKEY, SEQ_BO_ASSET_PAY_T_SUBKEY));// 生成seq
			MapUtils.safeAddToMap(addParams, "ASSET_ID", assetId);// 版权资产ID
			MapUtils.safeAddToMap(addParams, "PAY_ITEM_CD", MapUtils.getString(sumMap, "PAY_ITEM_CD"));// 成本项CD
			MapUtils.safeAddToMap(addParams, "MONEY", MapUtils.getLong(sumMap, "MONEY", 0L));// 金额
			MapUtils.safeAddToMap(addParams, "CREATE_USERID", userId);
			MapUtils.safeAddToMap(addParams, "UPDATE_USERID", userId);
			MapUtils.safeAddToMap(addParams, "CREATE_DATE", Date.from(Instant.now()));
			MapUtils.safeAddToMap(addParams, "UPDATE_DATE", Date.from(Instant.now()));
			assetPayTotalDao.save(addParams, assetId);
		});
	}

	/**
	 * 归集BO_ASSET_INCOME_T中的数据
	 * 
	 * @param contractCd
	 * @param assetId
	 */
	private void sumAssetIncomeT(String contractCd, long assetId, long userId) {
		// 1)删除：BO_ASSET_INCOME_T中的数据
		assetIncomeTotalDao.deleteIncTotalByAId(assetId);
		// 2)归集：BO_ASSET_INCOME_D > BO_ASSET_INCOME_T
		List<Map<String, Object>> detailSumList = assetIncomeDetailDao.selectIncSumOfItemCdByAssetId(assetId);
		if (detailSumList == null || detailSumList.size() == 0) {
			return;
		}
		detailSumList.forEach(sumMap -> {
			Map<String, Object> addParams = new HashMap<String, Object>();
			MapUtils.safeAddToMap(addParams, "ASSET_INCOME_T_ID",
					SequenceUtils.getNextValue(SEQ_BO_ASSET_INCOME_T_SKEY, SEQ_BO_ASSET_INCOME_T_SUBKEY));// 生成seq
			MapUtils.safeAddToMap(addParams, "ASSET_ID", assetId);// 版权资产ID
			MapUtils.safeAddToMap(addParams, "INCOME_ITEM_CD", MapUtils.getString(sumMap, "INCOME_ITEM_CD"));// 收入项CD
			MapUtils.safeAddToMap(addParams, "MONEY", MapUtils.getLong(sumMap, "MONEY", 0L));// 金额
			MapUtils.safeAddToMap(addParams, "CREATE_USERID", userId);
			MapUtils.safeAddToMap(addParams, "UPDATE_USERID", userId);
			MapUtils.safeAddToMap(addParams, "CREATE_DATE", Date.from(Instant.now()));
			MapUtils.safeAddToMap(addParams, "UPDATE_DATE", Date.from(Instant.now()));
			assetIncomeTotalDao.save(addParams, assetId);
		});
	}

	/**
	 * 归集BO_ASSET中的总成本数据
	 * 
	 * @param contractCd
	 * @param assetId
	 */
	private void sumAssetPay(long assetId, long userId) {
		// 归集：BO_ASSET的TOTAL_PAY
		assetDao.updateAssetTotalPay(assetId, userId, assetPayTotalDao.getMultiTableName(assetId));
	}

	/**
	 * 归集BO_ASSET中的总收入数据
	 * 
	 * @param contractCd
	 * @param assetId
	 */
	private void sumAssetIncome(long assetId, long userId) {
		// 归集：BO_ASSET的TOTAL_INCOME
		assetDao.updateAssetTotalInc(assetId, userId, assetIncomeTotalDao.getMultiTableName(assetId));
	}
}
