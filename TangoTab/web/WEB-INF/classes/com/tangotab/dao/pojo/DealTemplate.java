package com.tangotab.dao.pojo;

/**
 * DealTemplate entity. @author MyEclipse Persistence Tools
 */

public class DealTemplate implements java.io.Serializable {

	// Fields

	private Integer dealTemplateId;
	private String dealTemplateName;
	private String dealTemplateDescription;
	private String dealTemplateRestrictions;
	private String dealTemplateImgPath;
	private Short isActive;
	private Double defaultCreditValue;

	// Constructors

	/** default constructor */
	public DealTemplate() {
	}

	/** full constructor */
	public DealTemplate(String dealTemplateName, String dealTemplateDescription,
			String dealTemplateRestrictions, String dealTemplateImgPath, Short isActive,
			Double defaultCreditValue) {
		this.dealTemplateName = dealTemplateName;
		this.dealTemplateDescription = dealTemplateDescription;
		this.dealTemplateRestrictions = dealTemplateRestrictions;
		this.dealTemplateImgPath = dealTemplateImgPath;
		this.isActive = isActive;
		this.defaultCreditValue = defaultCreditValue;
	}

	// Property accessors

	public Integer getDealTemplateId() {
		return this.dealTemplateId;
	}

	public void setDealTemplateId(Integer dealTemplateId) {
		this.dealTemplateId = dealTemplateId;
	}

	public String getDealTemplateName() {
		return this.dealTemplateName;
	}

	public void setDealTemplateName(String dealTemplateName) {
		this.dealTemplateName = dealTemplateName;
	}

	public String getDealTemplateDescription() {
		return this.dealTemplateDescription;
	}

	public void setDealTemplateDescription(String dealTemplateDescription) {
		this.dealTemplateDescription = dealTemplateDescription;
	}

	public String getDealTemplateRestrictions() {
		return this.dealTemplateRestrictions;
	}

	public void setDealTemplateRestrictions(String dealTemplateRestrictions) {
		this.dealTemplateRestrictions = dealTemplateRestrictions;
	}

	public Short getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;

	}

	public Double getDefaultCreditValue() {
		return this.defaultCreditValue;
	}

	public void setDefaultCreditValue(Double defaultCreditValue) {
		this.defaultCreditValue = defaultCreditValue;
	}

	public String getDealTemplateImgPath() {
		return dealTemplateImgPath;
	}

	public void setDealTemplateImgPath(String dealTemplateImgPath) {
		this.dealTemplateImgPath = dealTemplateImgPath;
	}
}