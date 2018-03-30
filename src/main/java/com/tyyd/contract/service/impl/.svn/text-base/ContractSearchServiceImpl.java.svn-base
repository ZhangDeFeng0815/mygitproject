package com.tyyd.contract.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.common.dao.ContractInDao;
import com.tyyd.common.dao.ContractOutDao;
import com.tyyd.contract.service.ContractSearchService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("contractSearchService")
public class ContractSearchServiceImpl implements ContractSearchService {
	public static Logger logger = LoggerFactory.getLogger(ContractSearchServiceImpl.class);

	@Resource
	private ContractInDao contractInDao;
	
	@Resource
	private ContractOutDao contractOutDao;

	@Override
	public Map<String, Object> getContractInInfoByContractCd(String contractCd) throws BusinessException {
		return contractInDao.selectContractInInfoByContractCd(contractCd);
	}

	/**
	 * 查找指定类型的合同是否存在
	 */
	@Override
	public Integer existsContractInfoByContractCd(String contractCd, String type) throws BusinessException {
		Map<String, Object> cMap = null;
		if ("OUT".equals(type)) {
			cMap = contractOutDao.selectOutInfoByContractCd(contractCd);
		} else if ("IN".equals(type)) {
			cMap = contractInDao.selectContractInInfoByContractCd(contractCd);
		}
		return cMap != null && cMap.size() > 0 ? 1 : 0;
	}

	/**
	 * 授权合同查询列表
	 */
	@Override
	public List<Map<String, Object>> selectContractInList(Map<String, Object> params, String startRow, String endRow)
			throws BusinessException {
		return contractInDao.selectContractList(params, startRow, endRow);
	}

	/**
	 * 授权合同查询列表计数
	 */
	@Override
	public Integer selectContractInListCount(Map<String, Object> params) throws BusinessException {
		return contractInDao.selectContractListCount(params);
	}

	@Override
	public Map<String, Object> selectContractInByCdWithFile(String contractCd) throws BusinessException {
		return contractInDao.selectContractInByCdWithFile(contractCd);
	}

	/**
	 * 根据合同编号查询授权合同信息
	 */
	@Override
	public Map<String, Object> selectContractOutByCdWithFile(String contractCd) throws BusinessException {
		return contractOutDao.selectContractOutByCdWithFile(contractCd);
	}

	/**
	 * 授权合同查询列表
	 */
	@Override
	public List<Map<String, Object>> selectContractOutList(Map<String, Object> params, String startRow, String endRow)
			throws BusinessException {
		return contractOutDao.selectContractList(params, startRow, endRow);
	}

	/**
	 * 授权合同查询列表记录条数
	 */
	@Override
	public Integer selectContractOutListCount(Map<String, Object> params) throws BusinessException {
		return contractOutDao.selectContractListCount(params);
	}

}