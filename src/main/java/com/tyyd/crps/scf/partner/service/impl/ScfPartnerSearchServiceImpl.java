package com.tyyd.crps.scf.partner.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.crps.scf.partner.dto.PartnerDto;
import com.tyyd.crps.scf.partner.service.ScfPartnerSearchService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;
import com.tyyd.partner.service.PartnerSearchService;

@Service("scfPartnerSearchService")
public class ScfPartnerSearchServiceImpl implements ScfPartnerSearchService {
	
	public static Logger logger = LoggerFactory.getLogger(ScfPartnerSearchServiceImpl.class);

	@Resource
	private PartnerSearchService partnerSearchService;

	/**
	 * 根据指定条件查询合作商列表
	 */
	@Override
	public List<PartnerDto> searchPartnerList(PartnerDto partnerDto) throws BusinessException {
		List<PartnerDto> dataList = null;
		if(partnerDto==null) {
			return dataList;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		List<Long> partnerIdList = partnerDto.getPartnerIdList();
		if (partnerIdList == null) {
			if (partnerDto.getPartnerId() != null) {
				partnerIdList = new ArrayList<Long>();
				partnerIdList.add(partnerDto.getPartnerId());
			}
		}
		
		List<String> partnerNameList = partnerDto.getPartnerNameList();
		if (partnerNameList == null) {
			if (StringUtils.isNotBlank(partnerDto.getPartnerName())) {
				partnerNameList = new ArrayList<String>();
				partnerNameList.add(partnerDto.getPartnerName());
			}
		}
		
		if(partnerDto.getPartnerType()!=null) {
			MapUtils.safeAddToMap(params, "PARTNER_TYPE", partnerDto.getPartnerType());
		}
		
		List<Map<String, Object>> list = partnerSearchService.searchPartnerList(partnerIdList, partnerNameList, params, partnerDto.getStartRow(), partnerDto.getEndRow());
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<PartnerDto>();
			for (Map<String, Object> partner : list) {
				dataList.add(PartnerDto.copyMapToPartnerInfo(partner));
			}
		}
		return dataList;
	}

	/**
	 * 根据指定条件查询合作商列表总记录数
	 */
	@Override
	public int searchPartnerListCount(PartnerDto partnerDto) throws BusinessException {
		if(partnerDto==null) {
			return 0;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		List<Long> partnerIdList = partnerDto.getPartnerIdList();
		if (partnerIdList == null) {
			if (partnerDto.getPartnerId() != null) {
				partnerIdList = new ArrayList<Long>();
				partnerIdList.add(partnerDto.getPartnerId());
			}
		}
		
		List<String> partnerNameList = partnerDto.getPartnerNameList();
		if (partnerNameList == null) {
			if (StringUtils.isNotBlank(partnerDto.getPartnerName())) {
				partnerNameList = new ArrayList<String>();
				partnerNameList.add(partnerDto.getPartnerName());
			}
		}
		
		if(partnerDto.getPartnerType()!=null) {
			MapUtils.safeAddToMap(params, "PARTNER_TYPE", partnerDto.getPartnerType());
		}
		return partnerSearchService.searchPartnerListCount(partnerIdList, partnerNameList, params);
	}
	
	/**
	 * 合作商列表导出
	 */
	@Override
	public List<PartnerDto> searchPartnersExport(PartnerDto partnerDto) throws BusinessException {
		List<PartnerDto> dataList = null;
		if(partnerDto==null) {
			return dataList;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		List<Long> partnerIdList = partnerDto.getPartnerIdList();
		if (partnerIdList == null) {
			if (partnerDto.getPartnerId() != null) {
				partnerIdList = new ArrayList<Long>();
				partnerIdList.add(partnerDto.getPartnerId());
			}
		}
		
		List<String> partnerNameList = partnerDto.getPartnerNameList();
		if (partnerNameList == null) {
			if (StringUtils.isNotBlank(partnerDto.getPartnerName())) {
				partnerNameList = new ArrayList<String>();
				partnerNameList.add(partnerDto.getPartnerName());
			}
		}
		
		if(partnerDto.getPartnerType()!=null) {
			MapUtils.safeAddToMap(params, "PARTNER_TYPE", partnerDto.getPartnerType());
		}
		
		List<Map<String, Object>> list = partnerSearchService.searchPartnersExport(partnerIdList, partnerNameList, params, partnerDto.getLastPartnerId());
		if (list != null && list.size() > 0) {
			dataList = new ArrayList<PartnerDto>();
			for (Map<String, Object> partner : list) {
				dataList.add(PartnerDto.copyMapToPartnerInfo(partner));
			}
		}
		return dataList;
	}
	
	/**
	 * 根据合作商ID查询合作商的基本信息
	 */
	@Override
	public PartnerDto getPartnerInfoById(Long partnerId) throws BusinessException {
		if (partnerId == null) {
			return null;
		}
		return PartnerDto.copyMapToPartnerInfo(partnerSearchService.getPartnerInfoById(partnerId));
	}
	
}