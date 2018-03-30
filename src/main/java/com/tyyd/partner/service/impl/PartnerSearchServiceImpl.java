package com.tyyd.partner.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.common.dao.PartnerDao;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;
import com.tyyd.partner.service.PartnerSearchService;

@Service("partnerSearchService")
public class PartnerSearchServiceImpl implements PartnerSearchService {
	public static Logger logger = LoggerFactory.getLogger(PartnerSearchServiceImpl.class);
	
	@Resource
	private PartnerDao partnerDao;

	/**
	 * 根据指定条件查询合作商列表
	 */
	@Override
	public List<Map<String, Object>> searchPartnerList(List<Long> partnerIdList, List<String> partnerNameList,
			Map<String, Object> params, String startRow, String endRow) throws BusinessException {
		return partnerDao.selectPartnersByParams(partnerIdList, partnerNameList, params, startRow, endRow);
	}

	/**
	 * 根据指定条件查询合作商列表总记录数
	 */
	@Override
	public int searchPartnerListCount(List<Long> partnerIdList, List<String> partnerNameList,
			Map<String, Object> params) throws BusinessException {
		return partnerDao.selectPartnersCountByParams(partnerIdList, partnerNameList, params);
	}

	/**
	 * 合作商里列表批量导出
	 * 每次1000条
	 */
	@Override
	public List<Map<String, Object>> searchPartnersExport(List<Long> partnerIdList, List<String> partnerNameList,
			Map<String, Object> params, Long lastPartnerId)
			throws BusinessException {
		return partnerDao.selectPartnersExport(partnerIdList, partnerNameList, params, lastPartnerId);
	}
	
	/**
	 * 根据合作商ID查询合作商的基本信息
	 */
	@Override
	public Map<String, Object> getPartnerInfoById(Long partnerId) throws BusinessException {
		if (partnerId == null) {
			return null;
		}
		return partnerDao.getRecordById(String.valueOf(partnerId));
	}
}