package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class BillingMethodForm extends ValidatorForm implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer billingMethodId;
	private String billingMethodName;
	private Integer isActive;

	public Integer getBillingMethodId() {
		return billingMethodId;
	}

	public void setBillingMethodId(Integer billingMethodId) {
		this.billingMethodId = billingMethodId;
	}

	public String getBillingMethodName() {
		return billingMethodName;
	}

	public void setBillingMethodName(String billingMethodName) {
		this.billingMethodName = billingMethodName;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsActive() {
		return isActive;
	}

}