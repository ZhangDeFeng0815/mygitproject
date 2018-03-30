/**
 * 资产基本信息
 */
package com.tyyd.common.po;

import java.io.Serializable;

public class AssetInfo extends PoBaseInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8052973052442212402L;
	// 资产ID
	private Long assetId = null;
	// 资产编号
	private String assetCd = null;
	// 作品名称
	private String wkName = null;
	// 作者实名
	private String auNameS = null;
	// 作者笔名
	private String auNameB = null;
	// 媒体类型ID 1:电子图书 2:纸质图书 3:有声产品 4:动漫产品 5:影视产品 6:游戏产品 7:演出产品 8:其他（衍生产品）
	private Integer mediaTypeId = null;
	// 作品级别 1:S级 2:A级 3:B级 4:C级
	private Integer wkClass = null;
	// 作品总字数
	private Integer wordCount = null;
	// ISBN号
	private String isbnNum = null;
	// 权利项，以二进制形式标记是否有权利
	private Long rightB = null;
	// 成本合计 单位:分
	private Long totalPay = null;
	// 收入合计 单位:分
	private Long totalIncome = null;

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getAssetCd() {
		return assetCd;
	}

	public void setAssetCd(String assetCd) {
		this.assetCd = assetCd;
	}

	public String getWkName() {
		return wkName;
	}

	public void setWkName(String wkName) {
		this.wkName = wkName;
	}

	public String getAuNameS() {
		return auNameS;
	}

	public void setAuNameS(String auNameS) {
		this.auNameS = auNameS;
	}

	public String getAuNameB() {
		return auNameB;
	}

	public void setAuNameB(String auNameB) {
		this.auNameB = auNameB;
	}

	public Integer getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(Integer mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public Integer getWkClass() {
		return wkClass;
	}

	public void setWkClass(Integer wkClass) {
		this.wkClass = wkClass;
	}

	public Integer getWordCount() {
		return wordCount;
	}

	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}

	public String getIsbnNum() {
		return isbnNum;
	}

	public void setIsbnNum(String isbnNum) {
		this.isbnNum = isbnNum;
	}

	public Long getRightB() {
		return rightB;
	}

	public void setRightB(Long rightB) {
		this.rightB = rightB;
	}

	public Long getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(Long totalPay) {
		this.totalPay = totalPay;
	}

	public Long getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Long totalIncome) {
		this.totalIncome = totalIncome;
	}

}
