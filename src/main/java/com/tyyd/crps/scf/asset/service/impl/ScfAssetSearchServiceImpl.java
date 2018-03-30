package com.tyyd.crps.scf.asset.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.asset.service.AssetSearchService;
import com.tyyd.crps.scf.asset.dto.AssetDto;
import com.tyyd.crps.scf.asset.dto.AssetRightDDto;
import com.tyyd.crps.scf.asset.dto.AssetRightTDto;
import com.tyyd.crps.scf.asset.dto.ConfigDto;
import com.tyyd.crps.scf.asset.service.ScfAssetSearchService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("scfAssetSearchService")
public class ScfAssetSearchServiceImpl implements ScfAssetSearchService {

	public static Logger logger = LoggerFactory.getLogger(ScfAssetSearchServiceImpl.class);

	@Resource
	private AssetSearchService assetSearchService;

	private Map<String, Object> getSearchParamsMap(AssetDto assetDto) {
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(assetDto.getAssetCd())) {
			MapUtils.safeAddToMap(params, "ASSET_CD", assetDto.getAssetCd());
		}

		if (StringUtils.isNotBlank(assetDto.getAuNameS())) {
			MapUtils.safeAddToMap(params, "AU_NAME_S", assetDto.getAuNameS());
		}

		if (StringUtils.isNotBlank(assetDto.getAuNameB())) {
			MapUtils.safeAddToMap(params, "AU_NAME_B", assetDto.getAuNameB());
		}

		if (assetDto.getMediaTypeId() != null) {
			MapUtils.safeAddToMap(params, "MEDIA_TYPE_ID", assetDto.getMediaTypeId());
		}

		if (StringUtils.isNotBlank(assetDto.getStartCreateDate())) {
			MapUtils.safeAddToMap(params, "START_CREATE_DATE", assetDto.getStartCreateDate());
		}

		if (StringUtils.isNotBlank(assetDto.getEndCreateDate())) {
			MapUtils.safeAddToMap(params, "END_CREATE_DATE", assetDto.getEndCreateDate());
		}
		return params;

	}

	@Override
	public List<AssetDto> searchAssetList(AssetDto assetDto) throws BusinessException {
		List<AssetDto> dataList = null;
		if (assetDto == null) {
			return dataList;
		}

		List<String> assetCdList = assetDto.getAssetCdList();
		if (assetCdList == null) {
			if (StringUtils.isNotBlank(assetDto.getAssetCd())) {
				assetCdList = new ArrayList<String>();
				assetCdList.add(assetDto.getAssetCd());
				assetDto.setAssetCd(null);
			}
		}

		List<String> wkNameList = assetDto.getWkNameList();
		if (wkNameList == null) {
			if (StringUtils.isNotBlank(assetDto.getWkName())) {
				wkNameList = new ArrayList<String>();
				wkNameList.add(assetDto.getWkName());
				assetDto.setWkName(null);
			}
		}

		List<Map<String, Object>> list = assetSearchService.searchAssetList(assetCdList, wkNameList,
				assetDto.getRightBlist(), getSearchParamsMap(assetDto), assetDto.getStartRow(), assetDto.getEndRow());
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetDto>();
			for (Map<String, Object> asset : list) {
				dataList.add(AssetDto.copyMapToAssetInfo(asset));
			}
		}
		return dataList;
	}

	@Override
	public int searchAssetListCount(AssetDto assetDto) throws BusinessException {
		if (assetDto == null) {
			return 0;
		}

		List<String> assetCdList = assetDto.getWkNameList();
		if (assetCdList == null) {
			if (StringUtils.isNotBlank(assetDto.getAssetCd())) {
				assetCdList = new ArrayList<String>();
				assetCdList.add(assetDto.getAssetCd());
				assetDto.setAssetCd(null);
			}
		}

		List<String> wkNameList = assetDto.getWkNameList();
		if (wkNameList == null) {
			if (StringUtils.isNotBlank(assetDto.getWkName())) {
				wkNameList = new ArrayList<String>();
				wkNameList.add(assetDto.getWkName());
				assetDto.setWkName(null);
			}
		}

		return assetSearchService.searchAssetListCount(assetCdList, wkNameList, assetDto.getRightBlist(),
				getSearchParamsMap(assetDto));
	}

	@Override
	public List<AssetDto> searchAssetsExport(AssetDto assetDto) throws BusinessException {
		List<AssetDto> dataList = null;
		if (assetDto == null) {
			return dataList;
		}

		List<String> assetCdList = assetDto.getAssetCdList();
		if (assetCdList == null) {
			if (StringUtils.isNotBlank(assetDto.getAssetCd())) {
				assetCdList = new ArrayList<String>();
				assetCdList.add(assetDto.getAssetCd());
			}
		}
		
		List<String> wkNameList = assetDto.getWkNameList();
		if (wkNameList == null) {
			if (StringUtils.isNotBlank(assetDto.getWkName())) {
				wkNameList = new ArrayList<String>();
				wkNameList.add(assetDto.getWkName());
			}
		}

		List<Map<String, Object>> list = assetSearchService.searchAssetsExport(assetCdList, wkNameList, assetDto.getRightBlist(),
				getSearchParamsMap(assetDto), assetDto.getLastAssetId());
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetDto>();
			for (Map<String, Object> asset : list) {
				dataList.add(AssetDto.copyMapToAssetInfo(asset));
			}
		}
		return dataList;
	}

	@Override
	public AssetDto getAssetInfoById(Long assetId) throws BusinessException {
		if (assetId == null) {
			return null;
		}
		return AssetDto.copyMapToAssetInfo(assetSearchService.getAssetInfoById(assetId));
	}

	@Override
	public List<ConfigDto> searchConfigs(Integer type, String name) throws BusinessException {
		List<ConfigDto> dataList = null;
		if (type == null) {
			return dataList;
		}
		List<Map<String, Object>> list = assetSearchService.searchConfigs(type, name);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<ConfigDto>();
			for (Map<String, Object> config : list) {
				dataList.add(ConfigDto.copyMapToConfigInfo(config));
			}
		}
		return dataList;
	}

	@Override
	public List<AssetRightTDto> selectAssetRightTs(Long assetId) throws BusinessException {
		List<AssetRightTDto> dataList = null;
		if (assetId == null) {
			return dataList;
		}
		List<Map<String, Object>> list = assetSearchService.selectAssetRightTs(assetId);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetRightTDto>();
			for (Map<String, Object> assetRightT : list) {
				dataList.add(AssetRightTDto.copyMapToAssetRightTInfo(assetRightT));
			}
		}
		return dataList;
	}

	@Override
	public List<AssetRightDDto> selectAssetRightDs(Long assetId, String rightCd, String rightName, String contractCd)
			throws BusinessException {
		List<AssetRightDDto> dataList = null;
		if (assetId == null) {
			return dataList;
		}
		List<Map<String, Object>> list = assetSearchService.selectAssetRightDs(assetId, rightCd, rightName, contractCd);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetRightDDto>();
			for (Map<String, Object> assetRightD : list) {
				dataList.add(AssetRightDDto.copyMapToAssetRightDInfo(assetRightD));
			}
		}
		return dataList;
	}

	@Override
	public AssetDto getAssetInfoByAssetCd(String assetCd) throws BusinessException {
		if (StringUtils.isBlank(assetCd)) {
			return null;
		}
		return AssetDto.copyMapToAssetInfo(assetSearchService.getAssetInfoByAssetCd(assetCd));
	}

	@Override
	public List<Long> selectAssetIdsByContractCd(String contractCd) {
		return assetSearchService.selectAssetIdsByContractCd(contractCd);
	}

	@Override
	public List<AssetRightDDto> selectAssetRightDsByAssetIdAndContractCd(Long assetId, String contractCd)
			throws BusinessException {
		List<AssetRightDDto> dataList = null;
		if (assetId == null || StringUtils.isBlank(contractCd)) {
			return dataList;
		}
		List<Map<String, Object>> list = assetSearchService.selectAssetRightDsByAssetIdAndContractCd(assetId,
				contractCd);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetRightDDto>();
			for (Map<String, Object> assetRightDMap : list) {
				AssetRightDDto assetRightD = new AssetRightDDto();
				assetRightD = AssetRightDDto.copyMapToAssetRightDInfo(assetRightDMap);
				assetRightD.setAssetCd(MapUtils.getString(assetRightDMap, "ASSET_CD"));
				assetRightD.setWkName(MapUtils.getString(assetRightDMap, "WK_NAME"));
				assetRightD.setAuNameS(MapUtils.getString(assetRightDMap, "AU_NAME_S"));
				assetRightD.setAuNameB(MapUtils.getString(assetRightDMap, "AU_NAME_B"));
				assetRightD.setMediaTypeId(MapUtils.getInteger(assetRightDMap, "MEDIA_TYPE_ID"));
				dataList.add(assetRightD);
			}
		}
		return dataList;
	}

	@Override
	public AssetRightDDto getAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException {
		return AssetRightDDto.copyMapToAssetRightDInfo(assetSearchService.getAssetRightDById(assetRightDId, assetId));
	}

}