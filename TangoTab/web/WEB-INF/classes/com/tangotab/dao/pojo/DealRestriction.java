package com.tangotab.dao.pojo;

public class DealRestriction implements java.io.Serializable {

	private Short isActive;
	private Integer restrictionId;
	private String restriction;

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

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

}
