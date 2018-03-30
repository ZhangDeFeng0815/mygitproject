package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetPayDetailDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class AssetPayDetailDaoImpl extends BaseDaoImpl implements AssetPayDetailDao {

	@Override
	public String getTableName() {
		return "BO_ASSET_PAY_D_";
	}

	public AssetPayDetailDaoImpl() {
		super.setTableCount(50);
	}

	@Override
	public List<Map<String, Object>> selectAssetPayDs(Long assetId, String payItemCd, String contractCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);

		if (StringUtils.isNotBlank(payItemCd)) {
			dbUtil.addParamter("PAY_ITEM_CD", payItemCd);
		}
		if (StringUtils.isNotBlank(contractCd)) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
		}

		return dbUtil.select("selectAssetPayDs");
	}

	/**
	 * 根据资产ID，获取按成本项、资产ID group by分后的，收入合计值
	 */
	@Override
	public List<Map<String, Object>> selectPaySumOfItemCdByAssetId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.select("selectPaySumOfItemCdByAssetId");
	}
}
