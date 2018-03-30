package com.tyyd.crps.scf.contract.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tyyd.contract.service.ContractEditService;
import com.tyyd.crps.scf.contract.service.ScfContractEditService;
import com.tyyd.crps.scf.contract.service.dto.ContractInDto;
import com.tyyd.crps.scf.contract.service.dto.ContractOutDto;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("scfContractEditService")
public class ScfContractEditServiceImpl implements ScfContractEditService {
	
	private static Logger logger = LoggerFactory.getLogger(ScfContractEditServiceImpl.class);
	
	@Resource
	private ContractEditService contractEditService;

	@Override
	public Integer countContractByAId(Long assetId) throws BusinessException {
		logger.info("ScfContractEditServiceImpl.countContractByAId.Start");
		Integer ret = contractEditService.countContractInByAId(assetId) + 
				contractEditService.countContractOutByAId(assetId);
		logger.info("ScfContractEditServiceImpl.countContractByAId.End");
		return ret;
	}
	
	/**
	 * 新增获权合同
	 */
	@Override
	public Integer addContractIn(ContractInDto dto) throws BusinessException {
		Map<String, Object> contractMap = ContractInDto.copyContractInDtoToMap(dto);
		return contractEditService.addContractIn(contractMap);
	}

	/**
	 * 修改获权合同
	 */
	@Override
	public Integer editContractIn(ContractInDto dto) throws BusinessException {
		logger.info("ScfContractEditServiceImpl.editContractIn.Start");
		Map<String, Object> contractMap = ContractInDto.copyContractInDtoToMap(dto);
		Integer ret = contractEditService.editContractIn(contractMap);
		logger.info("ScfContractEditServiceImpl.editContractIn.End");
		return ret;
	}

	/**
	 * 新增授权合同
	 */
	@Override
	public Integer addContractOut(ContractOutDto dto) throws BusinessException {
		Map<String, Object> contractMap = ContractOutDto.copyContractOutDtoToMap(dto);
		return contractEditService.addContractOut(contractMap);
	}

	/**
	 * 修改授权合同
	 */
	@Override
	public Integer editContractOut(ContractOutDto dto) throws BusinessException {
		Map<String, Object> contractMap = ContractOutDto.copyContractOutDtoToMap(dto);
		Integer ret = contractEditService.editContractOut(contractMap);
		return ret;
	}

}
