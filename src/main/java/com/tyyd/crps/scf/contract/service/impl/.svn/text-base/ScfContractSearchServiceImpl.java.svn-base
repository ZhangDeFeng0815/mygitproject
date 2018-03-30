package com.tyyd.crps.scf.contract.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.contract.service.ContractSearchService;
import com.tyyd.crps.scf.contract.service.ScfContractSearchService;
import com.tyyd.crps.scf.contract.service.dto.ContractInDto;
import com.tyyd.crps.scf.contract.service.dto.ContractOutDto;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("scfContractSearchService")
public class ScfContractSearchServiceImpl implements ScfContractSearchService {

	public static Logger logger = LoggerFactory.getLogger(ScfContractSearchServiceImpl.class);

	@Resource
	private ContractSearchService contractSearchService;
	
	@Override
	public ContractInDto getContractInInfoByContractCd(String contractCd) throws BusinessException {
		if (StringUtils.isBlank(contractCd)) {
			return null;
		}
		return ContractInDto.copyMapToContractInDto(contractSearchService.getContractInInfoByContractCd(contractCd));
	}

	/**
	 * 收入合同编号是否存在
	 */
	@Override
	public Integer existsContractOutInfoByContractCd(String contractCd) throws BusinessException {
		logger.info("ScfContractSearchServiceImpl.existsContractOutInfoByContractCd.Start");
		Integer ret = contractSearchService.existsContractInfoByContractCd(contractCd, "OUT");
		logger.info("ScfContractSearchServiceImpl.existsContractOutInfoByContractCd.Start");
		return ret;
	}

	/**
	 * 成本（获权）合同编号是否存在
	 */
	@Override
	public Integer existsContractInInfoByContractCd(String contractCd) throws BusinessException {
		logger.info("ScfContractSearchServiceImpl.existsContractInInfoByContractCd.Start");
		Integer ret = contractSearchService.existsContractInfoByContractCd(contractCd, "IN");
		logger.info("ScfContractSearchServiceImpl.existsContractInInfoByContractCd.Start");
		return ret;
	}

	/**
	 * 授权合同查询列表
	 */
	@Override
	public List<ContractInDto> selectContractInList(ContractInDto dto, String startRow, String endRow)
			throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "CONTRACT_CD", dto.getContractCd());
		MapUtils.safeAddToMap(params, "PARTNER_NAME", dto.getPartnerName());
		List<Map<String, Object>> dataList = contractSearchService.selectContractInList(params, startRow, endRow);
		if (dataList == null || dataList.size() == 0) {
			return null;
		}
		List<ContractInDto> dtoList = dataList.stream().map(dataMap->{
			ContractInDto newDto = ContractInDto.copyMapToContractInDto(dataMap);
			Integer costP = newDto.getCostP();
			String costpStr = null;
			if (costP != null) {
				BigDecimal costpDec = (new BigDecimal(costP)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
				costpStr = new DecimalFormat(",###.##").format(costpDec);
			}
			newDto.setCostpStr(costpStr);
			return newDto;
		}).collect(Collectors.toList());
		return dtoList;
	}

	/**
	 * 授权合同查询列表计数
	 */
	@Override
	public Integer selectContractInListCount(ContractInDto dto) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "CONTRACT_CD", dto.getContractCd());
		MapUtils.safeAddToMap(params, "PARTNER_NAME", dto.getPartnerName());
		return contractSearchService.selectContractInListCount(params);
	}

	/**
	 * 根据合同编号查询获权合同信息（包含附件信息）
	 */
	@Override
	public ContractInDto selectContractInByCdWithFile(String contractCd) throws BusinessException {
		return ContractInDto.copyMapToContractInDto(contractSearchService.selectContractInByCdWithFile(contractCd));
	}

	/**
	 * 授权合同查询列表
	 */
	@Override
	public List<ContractOutDto> selectContractOutList(ContractOutDto dto, String startRow, String endRow)
			throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "CONTRACT_CD", dto.getContractCd());
		MapUtils.safeAddToMap(params, "PARTNER_NAME", dto.getPartnerName());
		List<Map<String, Object>> dataList = contractSearchService.selectContractOutList(params, startRow, endRow);
		if (dataList == null || dataList.size() == 0) {
			return null;
		}
		List<ContractOutDto> dtoList = dataList.stream().map(dataMap->{
			ContractOutDto newDto = ContractOutDto.copyMapToContractOutDto(dataMap);
			return newDto;
		}).collect(Collectors.toList());
		return dtoList;
	}

	/**
	 * 授权合同查询列表计数
	 */
	@Override
	public Integer selectContractOutListCount(ContractOutDto dto) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "CONTRACT_CD", dto.getContractCd());
		MapUtils.safeAddToMap(params, "PARTNER_NAME", dto.getPartnerName());
		return contractSearchService.selectContractOutListCount(params);
	}

	/**
	 * 根据合同编号查询授权合同信息（包含附件信息）
	 */
	@Override
	public ContractOutDto selectContractOutByCdWithFile(String contractCd) throws BusinessException {
		return ContractOutDto.copyMapToContractOutDto(contractSearchService.selectContractOutByCdWithFile(contractCd));
	}

}