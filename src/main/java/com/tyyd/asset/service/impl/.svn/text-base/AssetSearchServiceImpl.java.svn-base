package com.tyyd.asset.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.asset.service.AssetSearchService;
import com.tyyd.common.dao.AssetDao;
import com.tyyd.common.dao.AssetRightDDao;
import com.tyyd.common.dao.AssetRightTDao;
import com.tyyd.common.dao.ConfigDao;
import com.tyyd.common.dao.ContractInAssetDao;
import com.tyyd.common.po.ConfigInfo;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("assetSearchService")
public class AssetSearchServiceImpl implements AssetSearchService {
	public static Logger logger = LoggerFactory.getLogger(AssetSearchServiceImpl.class);

	@Resource
	private AssetDao assetDao;

	@Resource
	private ConfigDao configDao;

	@Resource
	private AssetRightTDao assetRightTDao;

	@Resource
	private AssetRightDDao assetRightDDao;

	@Resource
	private ContractInAssetDao contractInAssetDao;

	@Override
	public List<Map<String, Object>> searchAssetList(List<String> assetCdList, List<String> wkNameList,
			List<ConfigInfo> rightBList, Map<String, Object> params, String startRow, String endRow)
			throws BusinessException {
		// 1:版权权利项
		Long reihtB = null;
		if (rightBList != null && rightBList.size() > 0) {
			reihtB = configDao.changConfigsToLong(rightBList, 1);
		}
		return assetDao.selectAssetsByParams(assetCdList, wkNameList, reihtB, params, startRow, endRow);
	}

	@Override
	public int searchAssetListCount(List<String> assetCdList, List<String> wkNameList, List<ConfigInfo> rightBList,
			Map<String, Object> params) throws BusinessException {
		// 1:版权权利项
		Long reihtB = null;
		if (rightBList != null && rightBList.size() > 0) {
			reihtB = configDao.changConfigsToLong(rightBList, 1);
		}
		return assetDao.selectAssetsCountByParams(assetCdList, wkNameList, reihtB, params);
	}

	@Override
	public List<Map<String, Object>> searchAssetsExport(List<String> assetCdList, List<String> wkNameList, List<ConfigInfo> rightBList,
			Map<String, Object> params, Long lastAssetId) throws BusinessException {

		// 1:版权权利项
		Long reihtB = null;
		if (rightBList != null && rightBList.size() > 0) {
			reihtB = configDao.changConfigsToLong(rightBList, 1);
		}
		return assetDao.selectAssetsExport(assetCdList, wkNameList, reihtB, params, lastAssetId);
	}

	@Override
	public Map<String, Object> getAssetInfoById(Long assetId) throws BusinessException {
		if (assetId == null) {
			return null;
		}
		return assetDao.getRecordById(String.valueOf(assetId));
	}

	@Override
	public List<Map<String, Object>> searchConfigs(Integer type, String name) throws BusinessException {
		return configDao.selectConfigsByParams(type, name);
	}

	@Override
	public List<Map<String, Object>> selectAssetRightTs(Long assetId) throws BusinessException {
		return assetRightTDao.selectAssetRightTs(assetId, null);
	}

	@Override
	public List<Map<String, Object>> selectAssetRightDs(Long assetId, String rightCd, String rightName, String contractCd) throws BusinessException {
		return assetRightDDao.selectAssetRightDs(assetId, rightCd, rightName, contractCd);
	}

	@Override
	public Map<String, Object> getAssetInfoByAssetCd(String assetCd) throws BusinessException {
		return assetDao.selectAssetInfoByAssetCd(assetCd);
	}

	@Override
	public List<Long> selectAssetIdsByContractCd(String contractCd) {
		return contractInAssetDao.selectAssetIdsByContractCd(contractCd);
	}

	@Override
	public List<Map<String, Object>> selectAssetRightDsByAssetIdAndContractCd(Long assetId, String contractCd)
			throws BusinessException {
		return assetRightDDao.selectAssetRightDsByAssetIdAndContractCd(assetId, contractCd);
	}

	@Override
	public Map<String, Object> getAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException {
		if (assetRightDId == null || assetId == null) {
			return null;
		}
		return assetRightDDao.getRecordById(String.valueOf(assetRightDId), assetId);
	}

}