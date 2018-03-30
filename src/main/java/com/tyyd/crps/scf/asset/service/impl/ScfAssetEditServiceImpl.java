package com.tyyd.crps.scf.asset.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.asset.service.AssetEditService;
import com.tyyd.asset.service.AssetSearchService;
import com.tyyd.crps.scf.asset.dto.AssetDto;
import com.tyyd.crps.scf.asset.dto.AssetImportResultDto;
import com.tyyd.crps.scf.asset.dto.AssetRightDDto;
import com.tyyd.crps.scf.asset.service.ScfAssetEditService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("scfAssetEditService")
public class ScfAssetEditServiceImpl implements ScfAssetEditService {

	public static Logger logger = LoggerFactory.getLogger(ScfAssetEditServiceImpl.class);

	@Resource
	private AssetEditService assetEditService;
	
	@Resource
	private AssetSearchService assetSearchService;

	@Override
	public Integer saveAssetForAdd(AssetDto asset) throws BusinessException {
		Map<String, Object> params = AssetDto.copyAssetInfoToMap(asset);
		if (params.containsKey("ASSET_ID")) {
			params.remove("ASSET_ID");
		}
		return assetEditService.saveAssetForAdd(params);
	}

	@Override
	public Integer saveAssetForEdit(AssetDto asset) throws BusinessException {
		Map<String, Object> params = AssetDto.copyAssetInfoToMap(asset);
		if (StringUtils.isBlank(MapUtils.getString(params, "ASSET_ID", ""))) {
			return 0;
		}
		if (params.containsKey("CREATE_DATE")) {
			params.remove("CREATE_DATE");
		}
		if (params.containsKey("CREATE_USERID")) {
			params.remove("CREATE_USERID");
		}
		return assetEditService.saveAssetForEdit(params);
	}

	@Override
	public Integer deleteAsset(Long assetId) throws BusinessException {
		return assetEditService.deleteAsset(assetId);
	}

	/**
	 * 批量导入资产
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AssetImportResultDto batchImportAsset(Long userId, List<AssetDto> listDto) throws BusinessException {
		logger.info("ScfAssetEditServiceImpl.batchImportAsset.Start");
		AssetImportResultDto dto = null;
		List<Map<String, Object>> assetMapLsit = listDto.stream().map(aDto-> {
			return AssetDto.copyAssetInfoToMap(aDto);
		}).collect(Collectors.toList());
		Map<String, Object> retMap = assetEditService.batchImportAsset(userId, assetMapLsit);
		dto = new AssetImportResultDto();
		dto.setSuccessCnt(MapUtils.getInteger(retMap, "successCnt", 0));
		dto.setErrorList((List<String>) MapUtils.getObject(retMap, "errorList"));
		logger.info("ScfAssetEditServiceImpl.batchImportAsset.End");
		return dto;
	}

	/**
	 * 判断指定条件的资产是否已经存在
	 */
	@Override
	public Integer assetExistsCheck(String wkName, String auNameS, String auNameB, Integer mediaTypeId)
			throws BusinessException {
		logger.info("ScfAssetEditServiceImpl.assetExistsCheck.Start");
		Integer ret = assetEditService.assetExistsCheck(wkName, auNameS, auNameB, mediaTypeId);
		logger.info("ScfAssetEditServiceImpl.assetExistsCheck.End");
		return ret;
	}

	/**
	 * 修改资产信息
	 */
	@Override
	public Integer editAssetInfo(AssetDto dto, Long userId) throws BusinessException {
		logger.info("ScfAssetEditServiceImpl.editAssetInfo.Start");
		Map<String, Object> assetMap = new HashMap<String, Object>();
		MapUtils.safeAddToMap(assetMap, "WK_CLASS", dto.getWkClass());
		MapUtils.safeAddToMap(assetMap, "WORD_COUNT", dto.getWordCount());
		MapUtils.safeAddToMap(assetMap, "ISBN_NUM", dto.getIsbnNum());
		MapUtils.safeAddToMap(assetMap, "ASSET_ID", dto.getAssetId());
		Integer ret = assetEditService.editAssetInfo(assetMap, userId);
		logger.info("ScfAssetEditServiceImpl.editAssetInfo.End");
		return ret;
	}

	/**
	 * 批量删除资产
	 */
	@Override
	public Integer deleteAssetInfos(List<Long> assetIdList, Long userId) throws BusinessException {
		logger.info("ScfAssetEditServiceImpl.deleteAssetInfos.Start");
		Integer ret = assetEditService.deleteAssetInfos(assetIdList, userId);
		logger.info("ScfAssetEditServiceImpl.deleteAssetInfos.End");
		return ret;
	}

	@Override
	public Integer deleteAssetRightByContractCd(String contractCd) throws BusinessException {
		return assetEditService.deleteAssetRightByContractCd(contractCd);
	}

	@Override
	public Integer saveAssetRightD(AssetRightDDto assetRightD) throws BusinessException {
		if(StringUtils.isBlank(assetRightD.getAssetCd())) {
			return 0;
		}
		Map<String, Object> assetInfo = assetSearchService.getAssetInfoByAssetCd(assetRightD.getAssetCd());
		if (assetInfo == null || assetInfo.size() < 1) {
			return 0;
		}
		Map<String, Object> assetRightDMap = new HashMap<String, Object>();
		long assetId = MapUtils.getLongValue(assetInfo, "ASSET_ID");
		MapUtils.safeAddToMap(assetRightDMap, "ASSET_ID", assetId);
		MapUtils.safeAddToMap(assetRightDMap, "CONTRACT_CD", assetRightD.getContractCd());
		MapUtils.safeAddToMap(assetRightDMap, "RIGHT_CD", assetRightD.getRightCd());
		MapUtils.safeAddToMap(assetRightDMap, "DATE_FROM", assetRightD.getDateFrom());
		MapUtils.safeAddToMap(assetRightDMap, "DATE_TO", assetRightD.getDateTo());
		MapUtils.safeAddToMap(assetRightDMap, "AT_TYPE", assetRightD.getAtType());
		MapUtils.safeAddToMap(assetRightDMap, "REGION", assetRightD.getRegion());
		MapUtils.safeAddToMap(assetRightDMap, "CAN_RESALE", assetRightD.getCanResale());
		MapUtils.safeAddToMap(assetRightDMap, "CREATE_USERID", assetRightD.getUpdateUserId());
		MapUtils.safeAddToMap(assetRightDMap, "UPDATE_USERID", assetRightD.getCreateUserId());
		return assetEditService.saveAssetRightD(assetRightDMap);
	}

	@Override
	public void syncRight(List<String> contractCdList, String assetCd, long userId) throws BusinessException {
		if (contractCdList == null || contractCdList.size() < 1) {
			return;
		}
		Map<String, Object> assetInfo = assetSearchService.getAssetInfoByAssetCd(assetCd);
		if (assetInfo == null || assetInfo.size() < 1) {
			return;
		}
		long assetId = MapUtils.getLongValue(assetInfo, "ASSET_ID");
		assetEditService.syncRight(contractCdList, assetId, userId);
	}

	@Override
	public Integer deleteAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException {
		return assetEditService.deleteAssetRightDById(assetRightDId, assetId);
	}

}