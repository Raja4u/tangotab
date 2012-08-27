package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

public class BillingType implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer billingTypeId;
	private String billingTypeName;
	private Integer isActive;
	private Set<Restaurant> restaurants = new HashSet<Restaurant>(0);

	/**
	 * @return the isActive
	 */
	public BillingType() {

	}

	public BillingType(String bt) {
		new BillingType().setBillingTypeName(bt);
		// return bt;
	}

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

	public void setBillingTypeId(Integer billingTypeId) {
		this.billingTypeId = billingTypeId;
	}

	public String getBillingTypeName() {
		return billingTypeName;
	}

	public void setBillingTypeName(String billingTypeName) {
		this.billingTypeName = billingTypeName;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}