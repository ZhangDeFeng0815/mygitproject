package com.tyyd.crps.scf.value.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.crps.scf.value.dto.AssetIncomeDetailDto;
import com.tyyd.crps.scf.value.dto.AssetIncomeTotalDto;
import com.tyyd.crps.scf.value.dto.AssetPayDetailDto;
import com.tyyd.crps.scf.value.dto.AssetPayTotalDto;
import com.tyyd.crps.scf.value.service.ScfAssetValueSearchService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.value.service.AssetValueSearchService;

@Service("scfAssetValueSearchService")
public class ScfAssetValueSearchServiceImpl implements ScfAssetValueSearchService {

	@Resource
	private AssetValueSearchService assetValueSearchService;

	@Override
	public List<AssetPayDetailDto> selectAssetPayDs(Long assetId, String payItemCd, String contractCd)
			throws BusinessException {
		List<AssetPayDetailDto> dataList = null;
		List<Map<String, Object>> list = assetValueSearchService.selectAssetPayDs(assetId, payItemCd, contractCd);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetPayDetailDto>();
			for (Map<String, Object> assetPay : list) {
				dataList.add(AssetPayDetailDto.copyMapToAssetPayDInfo(assetPay));
			}
		}
		return dataList;
	}

	@Override
	public List<AssetPayTotalDto> selectAssetPayTs(Long assetId, String payItemCd) throws BusinessException {
		List<AssetPayTotalDto> dataList = null;
		List<Map<String, Object>> list = assetValueSearchService.selectAssetPayTs(assetId, payItemCd);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetPayTotalDto>();
			for (Map<String, Object> assetPay : list) {
				dataList.add(AssetPayTotalDto.copyMapToAssetPayTInfo(assetPay));
			}
		}
		return dataList;
	}

	@Override
	public List<AssetIncomeDetailDto> selectAssetIncomeDs(Long assetId, String incomeItemCd, String contractCd)
			throws BusinessException {
		List<AssetIncomeDetailDto> dataList = null;
		List<Map<String, Object>> list = assetValueSearchService.selectAssetIncomeDs(assetId, incomeItemCd, contractCd);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetIncomeDetailDto>();
			for (Map<String, Object> assetIncome : list) {
				dataList.add(AssetIncomeDetailDto.copyMapToAssetIncomeDInfo(assetIncome));
			}
		}
		return dataList;
	}

	@Override
	public List<AssetIncomeTotalDto> selectAssetIncomeTs(Long assetId, String incomeItemCd) throws BusinessException {
		List<AssetIncomeTotalDto> dataList = null;
		List<Map<String, Object>> list = assetValueSearchService.selectAssetIncomeTs(assetId, incomeItemCd);
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<AssetIncomeTotalDto>();
			for (Map<String, Object> assetIncome : list) {
				dataList.add(AssetIncomeTotalDto.copyMapToAssetIncomeTInfo(assetIncome));
			}
		}
		return dataList;
	}

}