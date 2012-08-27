package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class DateForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private Integer restLocationId;
	private Integer restaurantId;

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getRestLocationId() {
		return restLocationId;
	}

	public void setRestLocationId(Integer restLocationId) {
		this.restLocationId = restLocationId;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
