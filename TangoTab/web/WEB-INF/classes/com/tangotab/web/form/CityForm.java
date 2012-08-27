package com.tangotab.web.form;

import org.apache.struts.action.ActionForm;

public class CityForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer cityId;
	private Integer stateId;
	private String cityName;
	private String cityCode;
	private Integer isActive;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getStateId() {
		return stateId;
	}

}
