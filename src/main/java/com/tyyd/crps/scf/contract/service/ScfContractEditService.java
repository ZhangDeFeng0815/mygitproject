package com.tyyd.crps.scf.contract.service;

import com.tyyd.crps.scf.contract.service.dto.ContractInDto;
import com.tyyd.crps.scf.contract.service.dto.ContractOutDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfContractEditService {
	
	/**
	 * 统计是否有合同和指定资产有关联
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Integer countContractByAId(Long assetId) throws BusinessException;
	
	/**
	 * 新增获权合同
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public Integer addContractIn(ContractInDto dto) throws BusinessException;
	
	/**
	 * 修改获权合同
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public Integer editContractIn(ContractInDto dto) throws BusinessException;
	
	/**
	 * 新增授权合同
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public Integer addContractOut(ContractOutDto dto) throws BusinessException;
	
	/**
	 * 修改授权合同
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public Integer editContractOut(ContractOutDto dto) throws BusinessException;
}
