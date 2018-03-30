/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: zhangdf
 * 创建日期: 2018-3-9
 * 文件说明: 版权资产子系统  资产价值管理查询 ServiceImpl
 */
package com.tyyd.value.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.common.dao.AssetIncomeDetailDao;
import com.tyyd.common.dao.AssetIncomeTotalDao;
import com.tyyd.common.dao.AssetPayDetailDao;
import com.tyyd.common.dao.AssetPayTotalDao;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.value.service.AssetValueSearchService;

@Service("assetValueSearchService")
public class AssetValueSearchServiceImpl implements AssetValueSearchService {

	@Resource
	private AssetPayDetailDao assetPayDetailDao;

	@Resource
	private AssetPayTotalDao assetPayTotalDao;

	@Resource
	private AssetIncomeDetailDao assetIncomeDetailDao;

	@Resource
	private AssetIncomeTotalDao assetIncomeTotalDao;

	@Override
	public List<Map<String, Object>> selectAssetPayDs(Long assetId, String payItemCd, String contractCd)
			throws BusinessException {
		return assetPayDetailDao.selectAssetPayDs(assetId, payItemCd, contractCd);
	}

	@Override
	public List<Map<String, Object>> selectAssetPayTs(Long assetId, String payItemCd) throws BusinessException {
		return assetPayTotalDao.selectAssetPayTs(assetId, payItemCd);
	}

	@Override
	public List<Map<String, Object>> selectAssetIncomeDs(Long assetId, String incomeItemCd, String contractCd)
			throws BusinessException {
		return assetIncomeDetailDao.selectAssetIncomeDs(assetId, incomeItemCd, contractCd);
	}

	@Override
	public List<Map<String, Object>> selectAssetIncomeTs(Long assetId, String incomeItemCd) throws BusinessException {
		return assetIncomeTotalDao.selectAssetIncomeTs(assetId, incomeItemCd);
	}

}
