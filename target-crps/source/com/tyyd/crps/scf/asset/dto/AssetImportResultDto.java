package com.tyyd.crps.scf.asset.dto;

import java.io.Serializable;
import java.util.List;

public class AssetImportResultDto implements Serializable {

	private static final long serialVersionUID = 4590347643677931812L;
	
	private Integer successCnt = null;
	// 作品名称_作者实名_作者署名_媒体类型ID
	private List<String> errorList = null;// 导入时发生异常的数据集合
	
	public Integer getSuccessCnt() {
		return successCnt;
	}
	public void setSuccessCnt(Integer successCnt) {
		this.successCnt = successCnt;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
}
