package com.tyyd.contract.service.impl;

import java.io.File;
import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.common.dao.ContractInAssetDao;
import com.tyyd.common.dao.ContractInDao;
import com.tyyd.common.dao.ContractOutAssetDao;
import com.tyyd.common.dao.ContractOutDao;
import com.tyyd.common.dao.FileDao;
import com.tyyd.contract.service.ContractEditService;
import com.tyyd.framework.core.BusinessException;

@Service("contractEditService")
public class ContractEditServiceImpl implements ContractEditService {
	
	@Resource
	private ContractInAssetDao contractInAssetDao;
	
	@Resource
	private ContractOutAssetDao contractOutAssetDao;
	
	@Resource
	private ContractInDao contractInDao;
	
	@Resource
	private ContractOutDao contractOutDao;
	
	@Resource
	private FileDao fileDao;

	/**
	 * 统计指定资产是否存在收入合同与之关联
	 */
	@Override
	public Integer countContractInByAId(Long assetId) throws BusinessException {
		return contractInAssetDao.countContractInByAId(assetId);
	}

	/**
	 * 统计指定资产是否存在成本合同与之关联
	 */
	@Override
	public Integer countContractOutByAId(Long assetId) throws BusinessException {
		return contractOutAssetDao.countContractOutByAId(assetId);
	}

	/**
	 * 新增获权合同
	 */
	@Override
	public Integer addContractIn(Map<String, Object> contractMap) throws BusinessException {
		// 保存附件信息
		Long attachmentId = saveFileIfIsNec(contractMap, MapUtils.getLong(contractMap, "CREATE_USERID"));
		MapUtils.safeAddToMap(contractMap, "ATTACHMENT_ID", attachmentId);
		return contractInDao.save(contractMap);
	}
	
	private Map<String, Object> getFileParamsMap(String path, String fileName, Long userId) {
		Instant now = Instant.now();
		Map<String, Object> fileMap = new HashMap<String, Object>();
		MapUtils.safeAddToMap(fileMap, "PATH", path);
		MapUtils.safeAddToMap(fileMap, "FILE_NAME", fileName);
		MapUtils.safeAddToMap(fileMap, "CREATE_DATE", Date.from(now));
		MapUtils.safeAddToMap(fileMap, "UPDATE_DATE", Date.from(now));
		MapUtils.safeAddToMap(fileMap, "CREATE_USERID", userId);
		MapUtils.safeAddToMap(fileMap, "UPDATE_USERID", userId);
		return fileMap;
	}

	/**
	 * 修改获权合同
	 */
	@Override
	public Integer editContractIn(Map<String, Object> contractMap) throws BusinessException {
		Long contractId = MapUtils.getLong(contractMap, "CONTRACT_ID", null);
		if (contractId == null) {
			return 0;
		}
		// 1.保存附件信息
		Long userId = MapUtils.getLong(contractMap, "UPDATE_USERID");
		Long attachmentId = MapUtils.getLong(contractMap, "ATTACHMENT_ID", null);// 前端传过来的附件ID
		Long newAttachmentId = saveFileIfIsNec(contractMap, userId);// 附件保存
		if (newAttachmentId != null) {
			attachmentId = newAttachmentId;
		}
		// 2.更新合同信息
		Map<String, Object> oldContractMap = contractInDao.getRecordById(contractId.toString());
		Integer ret = contractInDao.update(getSaveOrUpdateMap(contractId, contractMap, attachmentId, userId, "IN"));
		// 3.原有附件信息是否需要清理
		deleteOldAttachment(contractMap, oldContractMap);
		return ret;
	}
	
	/**
	 * 保存附件，如果必须
	 * @param contractMap
	 * @return
	 */
	private Long saveFileIfIsNec(Map<String, Object> contractMap, Long userId) {
		String path = MapUtils.getString(contractMap, "PATH", null);
		String fileName = MapUtils.getString(contractMap, "FILE_NAME", null);
		Long attachmentId = null;
		if (StringUtils.isNotBlank(path) && StringUtils.isNotBlank(fileName)) {
			Map<String, Object> fileParams = getFileParamsMap(path, fileName, userId);
			fileDao.save(fileParams);
			attachmentId = MapUtils.getLong(fileParams, "FILE_ID", null);
		}
		
		return attachmentId;
	}

	/**
	 * 新增授权合同
	 */
	@Override
	public Integer addContractOut(Map<String, Object> contractMap) throws BusinessException {
		// 保存附件信息
		Long attachmentId = saveFileIfIsNec(contractMap, MapUtils.getLong(contractMap, "CREATE_USERID"));
		MapUtils.safeAddToMap(contractMap, "ATTACHMENT_ID", attachmentId);
		return contractOutDao.save(contractMap);
	}
	
	private Map<String, Object> getSaveOrUpdateMap(Long contractId, Map<String, Object> contractMap, Long attachmentId,
			Long userId, String type) {
		Map<String, Object> updateMap = new HashMap<String, Object>();
		MapUtils.safeAddToMap(updateMap, "CONTRACT_ID", contractId);
		MapUtils.safeAddToMap(updateMap, "PARTNER_ID", MapUtils.getLong(contractMap, "PARTNER_ID"));
		MapUtils.safeAddToMap(updateMap, "PARTNER_NAME", MapUtils.getString(contractMap, "PARTNER_NAME"));
		MapUtils.safeAddToMap(updateMap, "ATTACHMENT_ID", attachmentId == null ? "" : attachmentId);
		MapUtils.safeAddToMap(updateMap, "UPDATE_DATE", Date.from(Instant.now()));
		MapUtils.safeAddToMap(updateMap, "UPDATE_USERID", userId);
		if ("IN".equals(type)) {
			MapUtils.safeAddToMap(updateMap, "COST_P_1000", MapUtils.getInteger(contractMap, "COST_P_1000"));
		}
		return updateMap;
	}

	/**
	 * 修改授权合同
	 */
	@Override
	public Integer editContractOut(Map<String, Object> contractMap) throws BusinessException {
		Long contractId = MapUtils.getLong(contractMap, "CONTRACT_ID", null);
		if (contractId == null) {
			return 0;
		}
		// 1.保存附件信息
		Long userId = MapUtils.getLong(contractMap, "UPDATE_USERID");
		Long attachmentId = MapUtils.getLong(contractMap, "ATTACHMENT_ID", null);// 前端传过来的附件ID
		Long newAttachmentId = saveFileIfIsNec(contractMap, userId);// 附件保存
		if (newAttachmentId != null) {
			attachmentId = newAttachmentId;
		}
		// 2.更新合同信息
		Map<String, Object> oldContractMap = contractOutDao.getRecordById(contractId.toString());// 修改前授权合同信息获取
		Integer ret = contractOutDao.update(getSaveOrUpdateMap(contractId, contractMap, attachmentId, userId, "OUT"));
		// 3.原有附件信息是否需要清理
		deleteOldAttachment(contractMap, oldContractMap);
		return ret;
	}
	
	/**
	 * 删除原有附件
	 */
	private void deleteOldAttachment(Map<String, Object> contractMap, Map<String, Object> oldContractMap) {
		Long oldAttachId =  MapUtils.getLong(contractMap, "ATTACHMENT_ID", null);// 前端传过来的附件ID
		Long dbAttachId = MapUtils.getLong(oldContractMap, "ATTACHMENT_ID", null);// 数据库中原有的附件ID
		if (dbAttachId != null && oldAttachId == null) {// 原来有，现在没了，则需要删除
			Map<String, Object> fileMap = fileDao.getRecordById(dbAttachId.toString());
			fileDao.deleteById(dbAttachId.toString());
			FileUtils.deleteQuietly(new File(MapUtils.getString(fileMap, "PATH")));
		}
	}

}
