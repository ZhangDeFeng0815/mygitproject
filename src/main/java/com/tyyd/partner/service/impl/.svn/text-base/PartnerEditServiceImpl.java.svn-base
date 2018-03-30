package com.tyyd.partner.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.common.dao.PartnerDao;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;
import com.tyyd.partner.service.PartnerEditService;

@Service("partnerEditService")
public class PartnerEditServiceImpl implements PartnerEditService {
	public static Logger logger = LoggerFactory.getLogger(PartnerEditServiceImpl.class);
	
	@Resource
	private PartnerDao partnerDao;

	/**
	 * 新增、修改保存合作商
	 */
	@Override
	public Integer savePartner(Map<String, Object> params) throws BusinessException {
		//合作商新增、修改默认未删除
		MapUtils.safeAddToMap(params, "IS_DELETED", 2);
		return partnerDao.saveOrUpdate(params);
	}

	/**
	 * 删除指定合作商
	 */
	@Override
	public Integer deletePartner(Long partnerId) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "PARTNER_ID", partnerId);
		MapUtils.safeAddToMap(params, "IS_DELETED", 1);
		return partnerDao.update(params);
	}

	
}