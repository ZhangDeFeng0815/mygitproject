package com.tyyd.common.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.ContractInAssetDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;
import com.tyyd.framework.core.util.MapUtils;

@Repository
public class ContractInAssetDaoImpl extends BaseDaoImpl implements ContractInAssetDao {

	/**
	 * 指定表名 一张表对应一个Dao
	 */
	@Override
	public String getTableName() {
		return "BO_CONTRACT_IN_ASSET";
	}

	@Override
	public Integer deleteByAssetIdAndContractId(String contractCd, long assetId) {
		if (StringUtils.isBlank(contractCd)) {
			return 0;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("CONTRACT_CD", contractCd);
		return dbUtil.delete("deleteByAssetIdAndContractId");
	}

	@Override
	public List<Long> selectAssetIdsByContractCd(String contractCd) {
		if (StringUtils.isBlank(contractCd)) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("CONTRACT_CD", contractCd);
		List<Map<String, Object>> dataList = dbUtil.select("searchAssetIdsByContractCd");
		if (dataList != null && dataList.size() > 0) {
			List<Long> assetIdList = new ArrayList<Long>();
			for (Map<String, Object> map : dataList) {
				assetIdList.add(MapUtils.getLong(map, "ASSET_ID"));
			}
			return assetIdList;
		}
		return null;
	}
	
	/**
	 * 统计指定资产是否存在收入合同与之关联
	 */
	@Override
	public Integer countContractInByAId(Long assetId) {
		if (assetId == null) {
			return 0;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.selectOne("countContractInByAId");
	}
}
