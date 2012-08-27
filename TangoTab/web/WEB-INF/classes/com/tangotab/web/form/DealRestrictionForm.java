package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class DealRestrictionForm extends ValidatorForm implements java.io.Serializable {

	private Integer restrictionId;
	private String restriction;
	private Short isActive;

	public Integer getRestrictionId() {
		return restrictionId;
	}

	public void setRestrictionId(Integer restrictionId) {
		this.restrictionId = restrictionId;
	}

	public String getRestriction() {
		return restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

}
