package com.tyyd.asset.service.impl;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.asset.service.AssetEditService;
import com.tyyd.common.dao.AssetDao;
import com.tyyd.common.dao.AssetIncomeTotalDao;
import com.tyyd.common.dao.AssetPayDetailDao;
import com.tyyd.common.dao.AssetPayTotalDao;
import com.tyyd.common.dao.AssetRightDDao;
import com.tyyd.common.dao.AssetRightTDao;
import com.tyyd.common.dao.ContractInAssetDao;
import com.tyyd.common.dao.ContractInDao;
import com.tyyd.common.service.impl.MyAppBaseServiceImpl;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.ExceptionUtils;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.core.util.SequenceUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("assetEditService")
public class AssetEditServiceImpl extends MyAppBaseServiceImpl implements AssetEditService {
	private static final String SEQ_BO_ASSET_SKEY = "BO_ASSET";
	private static final String SEQ_BO_ASSET_SUBKEY = "BO_ASSET_CD";
	private static final String BO_ASSET_CD_PREFIX = "ZC";

	public static Logger logger = LoggerFactory.getLogger(AssetEditServiceImpl.class);

	@Resource
	private AssetDao assetDao;

	@Resource
	private AssetIncomeTotalDao assetIncomeTotalDao;

	@Resource
	private AssetPayTotalDao assetPayTotalDao;

	@Resource
	private AssetPayDetailDao assetPayDetailDao;

	@Resource
	private AssetRightTDao assetRightTDao;

	@Resource
	private AssetRightDDao assetRightDDao;

	@Resource
	private ContractInDao contractInDao;

	@Resource
	private ContractInAssetDao contractInAssetDao;

	@Override
	public Integer saveAssetForAdd(Map<String, Object> params) throws BusinessException {
		if (params.containsKey("ASSET_ID")) {
			params.remove("ASSET_ID");
		}
		return assetDao.save(params);
	}

	@Override
	public Integer saveAssetForEdit(Map<String, Object> params) throws BusinessException {
		if (StringUtils.isBlank(MapUtils.getString(params, "ASSET_ID", ""))) {
			return null;
		}
		if (params.containsKey("CREATE_DATE")) {
			params.remove("CREATE_DATE");
		}
		if (params.containsKey("CREATE_USERID")) {
			params.remove("CREATE_USERID");
		}
		return assetDao.update(params);
	}

	@Override
	public Integer deleteAsset(Long assetId) throws BusinessException {
		return deleteSingleAssetInfo(assetId);
	}

	/**
	 * 批量导入资产
	 */
	@Override
	public Map<String, Object> batchImportAsset(Long userId, List<Map<String, Object>> assetMapLsit)
			throws BusinessException {
		Integer successCnt = 0;
		List<String> errorList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		if (assetMapLsit != null && assetMapLsit.size() > 0) {
			for (Map<String, Object> assetMap : assetMapLsit) {
				Map<String, Object> params = new HashMap<String, Object>();
				// 资产的首字母缩写+7位序号，例如ZC0000001（按百万级数量设计）
				String assetCd = BO_ASSET_CD_PREFIX + StringUtils.leftPad(
						String.valueOf(SequenceUtils.getNextValue(SEQ_BO_ASSET_SKEY, SEQ_BO_ASSET_SUBKEY)), 7, "0");
				MapUtils.safeAddToMap(params, "ASSET_CD", assetCd);
				MapUtils.safeAddToMap(params, "WK_NAME", MapUtils.getString(assetMap, "WK_NAME"));
				MapUtils.safeAddToMap(params, "AU_NAME_S", MapUtils.getString(assetMap, "AU_NAME_S"));
				MapUtils.safeAddToMap(params, "AU_NAME_B", MapUtils.getString(assetMap, "AU_NAME_B"));
				MapUtils.safeAddToMap(params, "MEDIA_TYPE_ID", MapUtils.getInteger(assetMap, "MEDIA_TYPE_ID"));
				MapUtils.safeAddToMap(params, "WK_CLASS", MapUtils.getInteger(assetMap, "WK_CLASS", null));
				MapUtils.safeAddToMap(params, "WORD_COUNT", MapUtils.getInteger(assetMap, "WORD_COUNT", null));
				MapUtils.safeAddToMap(params, "ISBN_NUM", MapUtils.getString(assetMap, "ISBN_NUM", null));
				MapUtils.safeAddToMap(params, "CREATE_USERID", userId);
				MapUtils.safeAddToMap(params, "UPDATE_USERID", userId);
				MapUtils.safeAddToMap(params, "CREATE_DATE", Date.from(Instant.now()));
				MapUtils.safeAddToMap(params, "UPDATE_DATE", Date.from(Instant.now()));
				Integer ret = 0;
				sb.delete(0, sb.length());
				sb.append(MapUtils.getString(assetMap, "WK_NAME")).append("_")
						.append(MapUtils.getString(assetMap, "AU_NAME_S")).append("_")
						.append(MapUtils.getString(assetMap, "AU_NAME_B")).append("_")
						.append(MapUtils.getString(assetMap, "MEDIA_TYPE_ID"));
				try {
					ret = assetDao.save(params);
				} catch (Exception e) {
					e.printStackTrace();
					logger.warn("资产表保存失败，错误信息：" + e.getMessage() + ",键值=" + sb.toString());
				}
				if (ret == 0) {// 保存失败
					errorList.add(sb.toString());
					continue;
				}
				successCnt++;
			}
		}

		Map<String, Object> retMap = new HashMap<String, Object>();
		MapUtils.safeAddToMap(retMap, "successCnt", successCnt);
		MapUtils.safeAddToMap(retMap, "errorList", errorList);
		return retMap;
	}

	/**
	 * 判断指定条件的资产是否已经存在
	 */
	@Override
	public Integer assetExistsCheck(String wkName, String auNameS, String auNameB, Integer mediaTypeId)
			throws BusinessException {
		return assetDao.countAssetByVaules(wkName, auNameS, auNameB, mediaTypeId);
	}

	/**
	 * 修改资产信息
	 */
	@Override
	public Integer editAssetInfo(Map<String, Object> assetMap, Long userId) throws BusinessException {
		return assetDao.updateAssetInfo(assetMap, userId);
	}

	/**
	 * 批量删除资产
	 */
	@Override
	public Integer deleteAssetInfos(List<Long> assetIdList, Long userId) throws BusinessException {
		if (assetIdList == null || assetIdList.size() == 0) {
			return 0;
		}
		assetIdList.stream().forEach(assetId -> {
			deleteSingleAssetInfo(assetId);
		});
		return assetIdList.size();
	}

	/**
	 * 删除单个资产
	 */
	private Integer deleteSingleAssetInfo(Long assetId) {
		// 再次校验是否存在收入或者成本项
		Integer cnt = assetPayTotalDao.countPayTotalByAId(assetId) + assetIncomeTotalDao.countIncTotalByAId(assetId);
		Map<String, Object> assetMap = assetDao.getRecordById(assetId.toString());
		if (cnt > 0) {
			throw new BusinessException("该资产存在收入合同、或者成本合同关联，无法删除！资产CD=" + MapUtils.getString(assetMap, "ASSET_CD"));
		}
		// 1.删除资产表
		assetDao.deleteById(assetId.toString());
		return 1;
	}

	@Override
	public Integer deleteAssetRightByContractCd(String contractCd) throws BusinessException {
		// 根据合同编号删除所有权利明细
		assetRightDDao.deleteAssetRightDByContractCd(contractCd);
		// 根据合同编号删除所有权利汇总
		assetRightTDao.deleteAssetRightTByContractCd(contractCd);
		return 1;
	}

	@Override
	public Integer saveAssetRightD(Map<String, Object> params) throws BusinessException {
		if (StringUtils.isBlank(MapUtils.getString(params, "ASSET_ID", ""))) {
			ExceptionUtils.throwAcwsException("资产ID不能为空");
		}
		if (StringUtils.isBlank(MapUtils.getString(params, "CONTRACT_CD", ""))) {
			ExceptionUtils.throwAcwsException("合同编号不能为空");
		}
		Map<String, Object> assetRightD = new HashMap<String, Object>();
		MapUtils.safeAddToMap(assetRightD, "ASSET_RIGHT_D_ID",
				SequenceUtils.getNextValue(SEQ_BO_ASSET_RIGHT_D_SKEY, SEQ_BO_ASSET_RIGHT_D_SUBKEY));
		MapUtils.safeAddToMap(assetRightD, "ASSET_ID", MapUtils.getLong(params, "ASSET_ID"));
		if (StringUtils.isNotBlank(MapUtils.getString(params, "RIGHT_CD", "")))
			MapUtils.safeAddToMap(assetRightD, "RIGHT_CD", MapUtils.getString(params, "RIGHT_CD"));
		if (StringUtils.isNotBlank(MapUtils.getString(params, "DATE_FROM", "")))
			MapUtils.safeAddToMap(assetRightD, "DATE_FROM", MapUtils.getObject(params, "DATE_FROM"));
		if (StringUtils.isNotBlank(MapUtils.getString(params, "DATE_TO", "")))
			MapUtils.safeAddToMap(assetRightD, "DATE_TO", MapUtils.getObject(params, "DATE_TO"));
		if (StringUtils.isNotBlank(MapUtils.getString(params, "AT_TYPE", "")))
			MapUtils.safeAddToMap(assetRightD, "AT_TYPE", MapUtils.getInteger(params, "AT_TYPE"));
		if (StringUtils.isNotBlank(MapUtils.getString(params, "REGION", "")))
			MapUtils.safeAddToMap(assetRightD, "REGION", MapUtils.getInteger(params, "REGION"));
		if (StringUtils.isNotBlank(MapUtils.getString(params, "CAN_RESALE", "")))
			MapUtils.safeAddToMap(assetRightD, "CAN_RESALE", MapUtils.getInteger(params, "CAN_RESALE"));
		MapUtils.safeAddToMap(assetRightD, "CONTRACT_CD", MapUtils.getString(params, "CONTRACT_CD"));
		MapUtils.safeAddToMap(assetRightD, "CREATE_USERID", MapUtils.getObject(params, "CREATE_USERID"));
		MapUtils.safeAddToMap(assetRightD, "UPDATE_USERID", MapUtils.getObject(params, "UPDATE_USERID"));
		return assetRightDDao.save(assetRightD, MapUtils.getLong(params, "ASSET_ID"));
	}

	@Override
	public Integer deleteAssetRightDById(Long assetRightDId, Long assetId) throws BusinessException {
		if (assetRightDId == null || assetId == null) {
			return 0;
		}
		return assetRightDDao.deleteById(String.valueOf(assetRightDId), assetId);
	}

}