package com.tyyd.crps.scf.value.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.common.po.AssetIncomeDetail;
import com.tyyd.common.po.AssetPayDetail;
import com.tyyd.crps.scf.value.dto.AssetIncomeDetailDto;
import com.tyyd.crps.scf.value.dto.AssetPayDetailDto;
import com.tyyd.crps.scf.value.service.ScfAssetValueEditService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;
import com.tyyd.value.service.AssetValueEditService;

@Service("scfAssetValueEditService")
public class ScfAssetValueEditServiceImpl implements ScfAssetValueEditService {

	private static Logger logger = LoggerFactory.getLogger(ScfAssetValueEditServiceImpl.class);
	
	@Resource
	private AssetValueEditService assetValueEditService;

	/**
	 * 批量保存资产收入
	 */
	@Override
	public Integer batchSaveIncomeDetail(Long userId, List<AssetIncomeDetailDto> incList, 
			String contractCd) throws BusinessException {
		logger.info("scfAssetValueEditService.batchSaveIncomeDetail.Start");
		if (incList == null || incList.size() == 0) {
			return 0;
		}
		List<AssetIncomeDetail> dataList = incList.stream().map(dto -> (AssetIncomeDetail) dto)
				.collect(Collectors.toList());
		Integer ret = assetValueEditService.batchSaveIncomeDetail(userId, dataList, contractCd);
		logger.info("scfAssetValueEditService.batchSaveIncomeDetail.End");
		return ret;
	}

	/**
	 * 批量保存资产成本
	 */
	@Override
	public Integer batchSavePayDetail(Long userId, List<AssetPayDetailDto> payList, String contractCd)
			throws BusinessException {
		logger.info("scfAssetValueEditService.batchSavePayDetail.Start");
		if (payList == null || payList.size() == 0) {
			return 0;
		}
		List<AssetPayDetail> dataList = payList.stream().map(dto -> (AssetPayDetail) dto)
				.collect(Collectors.toList());
		Integer ret = assetValueEditService.batchSavePayDetail(userId, dataList, contractCd);
		logger.info("scfAssetValueEditService.batchSavePayDetail.End");
		return ret;
	}

	/**
	 * 统计资产的收入、成本项个数
	 */
	@Override
	public Integer countTotalItemByAId(Long assetId) throws BusinessException {
		logger.info("scfAssetValueEditService.countTotalItemByAId.Start");
		Integer ret = assetValueEditService.countIncTotalByAId(assetId)
				+ assetValueEditService.countPayTotalByAId(assetId);
		logger.info("scfAssetValueEditService.countTotalItemByAId.End");
		return ret;
	}
}
