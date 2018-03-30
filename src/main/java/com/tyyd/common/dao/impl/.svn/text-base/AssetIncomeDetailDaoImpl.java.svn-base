package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetIncomeDetailDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class AssetIncomeDetailDaoImpl extends BaseDaoImpl implements AssetIncomeDetailDao {

	@Override
	public String getTableName() {
		return "BO_ASSET_INCOME_D_";
	}

	public AssetIncomeDetailDaoImpl() {
		super.setTableCount(50);
	}

	/**
	 * 根据资产ID，获取按收入项、资产ID group by分后的，收入合计值
	 */
	@Override
	public List<Map<String, Object>> selectIncSumOfItemCdByAssetId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.select("selectIncSumOfItemCdByAssetId");
	}

	@Override
	public Integer insertIntoContractOutAsset(Long assetId, Long userId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("USER_ID", userId);
		return dbUtil.insert("insertIntoContractOutAsset");
	}

	@Override
	public List<Map<String, Object>> selectAssetIncomeDs(Long assetId, String incomeItemCd, String contractCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);

		if (StringUtils.isNotBlank(incomeItemCd)) {
			dbUtil.addParamter("INCOME_ITEM_CD", incomeItemCd);
		}
		if (StringUtils.isNotBlank(contractCd)) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
		}

		return dbUtil.select("selectAssetIncomeDs");
	}
}
