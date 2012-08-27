package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class BillingTypeForm extends ValidatorForm implements java.io.Serializable {

	private Integer billingTypeId;
	private String billingTypeName;
	private Integer isActive;

	/**
	 * @return the isActive
	 */
	public Integer getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the billingTypeId
	 */
	public Integer getBillingTypeId() {
		return billingTypeId;
	}

	/**
	 * @param billingTypeId
	 *            the billingTypeId to set
	 */
	public void setBillingTypeId(Integer billingTypeId) {
		this.billingTypeId = billingTypeId;
	}

	/**
	 * @return the billingTypeName
	 */
	public String getBillingTypeName() {
		return billingTypeName;
	}

	/**
	 * @param billingTypeName
	 *            the billingTypeName to set
	 */
	public void setBillingTypeName(String billingTypeName) {
		this.billingTypeName = billingTypeName;
	}

}
