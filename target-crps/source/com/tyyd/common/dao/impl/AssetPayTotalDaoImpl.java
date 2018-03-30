package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetPayTotalDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class AssetPayTotalDaoImpl extends BaseDaoImpl implements AssetPayTotalDao {

	@Override
	public String getTableName() {
		return "BO_ASSET_PAY_T_";
	}
	
	public AssetPayTotalDaoImpl() {
		super.setTableCount(10);
	}

	/**
	 * 根据资产ID和成本项CD，查找是否存在符合要求的合计项
	 */
	@Override
	public Integer countPayTotalByAIdAndItemCd(Long assetId, String itemCd) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("PAY_ITEM_CD", itemCd);
		return dbUtil.selectOne("countPayTotalByAIdAndItemCd");
	}

	/**
	 * 根据资产ID和成本项CD，查找是否存在符合要求的合计项
	 */
	@Override
	public Integer updatePayTotalByAssIdAndItemCd(Long assetId, String itemCd, Long userId, String detailTblName) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("TBLNAME_D", detailTblName);
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("PAY_ITEM_CD", itemCd);
		dbUtil.addParamter("UPDATE_USERID", userId);
		return dbUtil.update("updatePayTotal");
	}

	/**
	 * 根据资产ID，查找是否存在符合要求的合计项
	 */
	@Override
	public Integer countPayTotalByAId(Long assetId) {
		return countPayTotalByAIdAndItemCd(assetId, null);
	}

	/**
	 * 根据资产ID，删除合计项
	 */
	@Override
	public Integer deletePayTotalByAId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.delete("deletePayTotalByAId");
	}

	@Override
	public List<Map<String, Object>> selectAssetPayTs(Long assetId, String payItemCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);

		if (StringUtils.isNotBlank(payItemCd)) {
			dbUtil.addParamter("PAY_ITEM_CD", payItemCd);
		}
		return dbUtil.select("selectAssetPayTs");
	}

}
