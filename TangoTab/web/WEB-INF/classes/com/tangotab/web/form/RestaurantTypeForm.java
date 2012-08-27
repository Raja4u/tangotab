package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class RestaurantTypeForm extends ValidatorForm implements java.io.Serializable {

	private Integer restTypeId;
	private String restTypeName;
	private Integer isActive;

	/**
	 * @return the restTypeId
	 */
	public Integer getRestTypeId() {
		return restTypeId;
	}

	/**
	 * @param restTypeId
	 *            the restTypeId to set
	 */
	public void setRestTypeId(Integer restTypeId) {
		this.restTypeId = restTypeId;
	}

	/**
	 * @return the restTypeName
	 */
	public String getRestTypeName() {
		return restTypeName;
	}

	/**
	 * @param restTypeName
	 *            the restTypeName to set
	 */
	public void setRestTypeName(String restTypeName) {
		this.restTypeName = restTypeName;
	}

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
	 * @return the isActive
	 */

}
