/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: zhangdf
 * 创建日期: 2018-3-9
 * 文件说明: 版权资产子系统  资产价值管理修改 ServiceImpl
 */
package com.tyyd.value.service.impl;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.common.dao.AssetDao;
import com.tyyd.common.dao.AssetIncomeDetailDao;
import com.tyyd.common.dao.AssetIncomeTotalDao;
import com.tyyd.common.dao.AssetPayDetailDao;
import com.tyyd.common.dao.AssetPayTotalDao;
import com.tyyd.common.po.AssetIncomeDetail;
import com.tyyd.common.po.AssetPayDetail;
import com.tyyd.common.service.impl.MyAppBaseServiceImpl;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.core.util.SequenceUtils;
import com.tyyd.value.service.AssetValueEditService;

@Service("assetValueEditService")
public class AssetValueEditServiceImpl extends MyAppBaseServiceImpl implements AssetValueEditService {
	
	@Resource
	private AssetIncomeDetailDao assetIncomeDetailDao;
	
	@Resource
	private AssetIncomeTotalDao assetIncomeTotalDao;
	
	@Resource
	private AssetPayDetailDao assetPayDetailDao;
	
	@Resource
	private AssetPayTotalDao assetPayTotalDao;
	
	@Resource
	private AssetDao assetDao;

	@Override
	public Integer saveIncomeDetail(Long userId, AssetIncomeDetail inc, Instant is) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "ASSET_INCOME_D_ID",
				SequenceUtils.getNextValue(SEQ_BO_ASSET_INCOME_D_SKEY, SEQ_BO_ASSET_INCOME_D_SUBKEY));
		MapUtils.safeAddToMap(params, "ASSET_ID", inc.getAssetId());
		MapUtils.safeAddToMap(params, "INCOME_ITEM_CD", inc.getIncomeItemCd());
		MapUtils.safeAddToMap(params, "MONEY", inc.getMoney());
		MapUtils.safeAddToMap(params, "CONTRACT_CD", inc.getContractCd());
		MapUtils.safeAddToMap(params, "CREATE_DATE", Date.from(is));
		MapUtils.safeAddToMap(params, "UPDATE_DATE", Date.from(is));
		MapUtils.safeAddToMap(params, "CREATE_USERID", userId);
		MapUtils.safeAddToMap(params, "UPDATE_USERID", userId);
		return assetIncomeDetailDao.save(params, inc.getAssetId());
	}

	/**
	 * 批量导入收入明细
	 */
	@Override
	public Integer batchSaveIncomeDetail(Long userId, List<AssetIncomeDetail> incList, String contractCd) throws BusinessException {
		if (incList == null || incList.size() == 0) {
			return 0;
		}
		// 1.批量导入明细表
		Instant is = Instant.now();
		Integer ret = incList.size();
		incList.forEach((inc) -> {
			if (inc.getMoney() != null && inc.getMoney().longValue() != 0L) {
				saveIncomeDetail(userId, inc, is);
			}
		});
		// 2.版权资产收入变更后的数据库表同步
		incList.forEach((inc) -> {
			syncIncome(contractCd, inc.getAssetId(), userId);
		});
		return ret;
	}
	
	/**
	 * 保存资产成本明细
	 */
	@Override
	public Integer savePayDetail(Long userId, AssetPayDetail pay, Instant is) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "ASSET_PAY_D_ID",
				SequenceUtils.getNextValue(SEQ_BO_ASSET_PAY_D_SKEY, SEQ_BO_ASSET_PAY_D_SUBKEY));
		MapUtils.safeAddToMap(params, "ASSET_ID", pay.getAssetId());
		MapUtils.safeAddToMap(params, "PAY_ITEM_CD", pay.getPayItemCd());
		MapUtils.safeAddToMap(params, "MONEY", pay.getMoney());
		MapUtils.safeAddToMap(params, "CONTRACT_CD", pay.getContractCd());
		MapUtils.safeAddToMap(params, "CREATE_DATE", Date.from(is));
		MapUtils.safeAddToMap(params, "UPDATE_DATE", Date.from(is));
		MapUtils.safeAddToMap(params, "CREATE_USERID", userId);
		MapUtils.safeAddToMap(params, "UPDATE_USERID", userId);
		return assetPayDetailDao.save(params, pay.getAssetId());
	}

	/**
	 * 批量保存资产成本明细
	 */
	@Override
	public Integer batchSavePayDetail(Long userId, List<AssetPayDetail> payList, String contractCd) throws BusinessException {
		if (payList == null || payList.size() == 0) {
			return 0;
		}
		// 1.批量更新明细表
		Instant is = Instant.now();
		Integer ret = payList.size();
		payList.forEach((pay) -> {
			if (pay.getMoney() != null && pay.getMoney().longValue() != 0L) {
				savePayDetail(userId, pay, is);
			}
		});
		// 2.版权资产成本变更后的数据库表同步
		payList.forEach((pay) -> {
			syncPay(contractCd, pay.getAssetId(), userId);
		});
		return ret;
	}
	
	/**
	 * 统计资产的收入项个数
	 */
	@Override
	public Integer countIncTotalByAId(Long assetId) throws BusinessException {
		return assetIncomeTotalDao.countIncTotalByAId(assetId);
	}

	/**
	 * 统计资产的成本项个数
	 */
	@Override
	public Integer countPayTotalByAId(Long assetId) throws BusinessException {
		return assetPayTotalDao.countPayTotalByAId(assetId);
	}
	
	public static void main(String[] args) {
//		List<AssetIncomeDetail> incList = new ArrayList<AssetIncomeDetail>();
//		for (int i=1;i<=100;i++) {
//			AssetIncomeDetail inc = new AssetIncomeDetail();
//			if (i<30) {
//				inc.setAssetId(10L);
//			} else if (i<70) {
//				inc.setAssetId(20L);
//			} else {
//				inc.setAssetId(30L);
//			}
//			inc.setIncomeItemCd(String.valueOf(i%3));
//			inc.setMoney(Long.valueOf(i));
//			incList.add(inc);
//		}
//		Map<Long, Map<String, Long>> groupMap = incList.stream().collect(Collectors
//				.groupingBy(AssetIncomeDetail::getAssetId, Collectors.groupingBy(AssetIncomeDetail::getIncomeItemCd,
//						Collectors.summingLong(AssetIncomeDetail::getMoney))));
//		groupMap.forEach((k, v) -> {
//			v.forEach((k2, v2) -> {
//				System.out.println("资产ID="+k);
//				System.out.println("收入项CD="+k2);
//				System.out.println("合计值="+v2);
//			});
//		});
//		
//		Map<Long,Map<String,Long>> groupMap2 = incList.stream().collect(Collectors
//				.groupingBy(AssetIncomeDetail::getAssetId, Collectors.groupingBy(AssetIncomeDetail::getIncomeItemCd,
//						Collectors.counting())));
//		groupMap2.forEach((k, v) -> {
//			v.forEach((k2, v2) -> {
//				System.out.println("资产ID="+k);
//				System.out.println("收入项CD="+k2);
//				System.out.println("合计项个数="+v2);
//			});
//		});
	}

}
