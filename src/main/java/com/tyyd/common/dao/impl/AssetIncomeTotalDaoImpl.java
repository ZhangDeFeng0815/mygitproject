package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetIncomeTotalDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class AssetIncomeTotalDaoImpl extends BaseDaoImpl implements AssetIncomeTotalDao {

	@Override
	public String getTableName() {
		return "BO_ASSET_INCOME_T_";
	}
	
	public AssetIncomeTotalDaoImpl() {
		super.setTableCount(10);
	}

	/**
	 * 根据资产ID和收入项查找合计项
	 */
	@Override
	public Map<String, Object> getIncTotalByAssIdAndItemCd(Long assetId, String itemCd) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("INCOME_ITEM_CD", itemCd);
		return dbUtil.selectOne("selectIncList");
	}

	/**
	 * 更新资产ID、收入CD对应的合计项
	 */
	@Override
	public Integer updateIncTotalByAssIdAndItemCd(Long assetId, String itemCd, Long userId, String detailTblName) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("TBLNAME_D", detailTblName);
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("INCOME_ITEM_CD", itemCd);
		dbUtil.addParamter("UPDATE_USERID", userId);
		return dbUtil.update("updateIncTotal");
	}

	/**
	 * 根据资产ID和收入项CD，查找是否存在符合要求的合计项
	 */
	@Override
	public Integer countIncTotalByAIdAndItemCd(Long assetId, String itemCd) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("INCOME_ITEM_CD", itemCd);
		return dbUtil.selectOne("countIncTotalByAIdAndItemCd");
	}

	/**
	 * 根据资产ID，count对应的合计项数
	 */
	@Override
	public Integer countIncTotalByAId(Long assetId) {
		return countIncTotalByAIdAndItemCd(assetId, null);
	}

	/**
	 * 根据资产ID，删除资产收入合计项
	 */
	@Override
	public Integer deleteIncTotalByAId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.delete("deleteIncTotalByAId");
	}

	@Override
	public List<Map<String, Object>> selectAssetIncomeTs(Long assetId, String incomeItemCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);

		if (StringUtils.isNotBlank(incomeItemCd)) {
			dbUtil.addParamter("INCOME_ITEM_CD", incomeItemCd);
		}
		return dbUtil.select("selectAssetIncomeTs");
	}

}
