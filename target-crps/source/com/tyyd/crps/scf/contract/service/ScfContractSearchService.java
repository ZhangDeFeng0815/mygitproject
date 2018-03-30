/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理系统
 * 创建者: QinTao
 * 创建日期: 2018-3-7
 * 文件说明: 文字版权管理系统 资产库Scf Service
 */
package com.tyyd.crps.scf.contract.service;

import java.util.List;

import com.tyyd.crps.scf.contract.service.dto.ContractInDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfContractSearchService {

	/**
	 * 根据合同编号查询获权合同信息
	 * 
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public ContractInDto getContractInInfoByContractCd(String contractCd) throws BusinessException;
	
	/**
	 * 收入（授权）合同编号是否存在
	 * @param contractCd：合同编号
	 * @return
	 * @throws BusinessException
	 */
	public Integer existsContractOutInfoByContractCd(String contractCd) throws BusinessException;
	
	/**
	 * 成本（获权）合同编号是否存在
	 * @param contractCd：合同编号
	 * @return
	 * @throws BusinessException
	 */
	public Integer existsContractInInfoByContractCd(String contractCd) throws BusinessException;
	
	/**
	 * 授权合同查询列表
	 * @param params
	 * @return
	 */
	public List<ContractInDto> selectContractInList(ContractInDto dto, String startRow, String endRow) throws BusinessException;
	
	/**
	 * 授权合同查询列表计数
	 * @param params
	 * @return
	 */
	public Integer selectContractInListCount(ContractInDto dto) throws BusinessException;
	
	/**
	 * 根据合同编号查询获权合同信息（包含附件信息）
	 * 
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public ContractInDto selectContractInByCdWithFile(String contractCd) throws BusinessException;
	
}
