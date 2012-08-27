package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

public class Restaurant implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer restaurantId;
	private Integer billingMethodId;
	private User user;
	private Integer restTypeId;
	private Integer billingTypeId;
	private String businessName;
	private Integer noOfLocations;
	private Double currentCredits;
	private Short isActivated;
	private RestaurantCcProfile restaurantCcProfiles;
	private String alternateHosts;

	public String getAlternateHosts() {
		return alternateHosts;
	}

	public void setAlternateHosts(String alternateHosts) {
		this.alternateHosts = alternateHosts;
	}

	public RestaurantCcProfile getRestaurantCcProfiles() {
		return restaurantCcProfiles;
	}

	public void setRestaurantCcProfiles(RestaurantCcProfile restaurantCcProfiles) {
		this.restaurantCcProfiles = restaurantCcProfiles;
	}

	private String srepName;
	private String srepEmail;

	public String getSrepName() {
		return srepName;
	}

	public void setSrepName(String srepName) {
		this.srepName = srepName;
	}

	public String getSrepEmail() {
		return srepEmail;
	}

	public void setSrepEmail(String srepEmail) {
		this.srepEmail = srepEmail;
	}

	private Short isAutoDebit;
	private Set<RestaurantLocation> restaurantLocations = new HashSet<RestaurantLocation>();

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getRestTypeId() {
		return restTypeId;
	}

	public void setRestTypeId(Integer restTypeId) {
		this.restTypeId = restTypeId;
	}

	public Integer getBillingMethodId() {
		return billingMethodId;
	}

	public void setBillingMethodId(Integer billingMethodId) {
		this.billingMethodId = billingMethodId;
	}

	public Integer getBillingTypeId() {
		return billingTypeId;
	}

	public void setBillingTypeId(Integer billingTypeId) {
		this.billingTypeId = billingTypeId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Integer getNoOfLocations() {
		return noOfLocations;
	}

	public void setNoOfLocations(Integer noOfLocations) {
		this.noOfLocations = noOfLocations;
	}

	public Double getCurrentCredits() {
		return currentCredits;
	}

	public void setCurrentCredits(Double currentCredits) {
		this.currentCredits = currentCredits;
	}

	public Short getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Short isActivated) {
		this.isActivated = isActivated;
	}

	public Set<RestaurantLocation> getRestaurantLocations() {
		return restaurantLocations;
	}

	public void setRestaurantLocations(Set<RestaurantLocation> restaurantLocations) {
		this.restaurantLocations = restaurantLocations;
	}

	public void setIsAutoDebit(Short isAutoDebit) {
		this.isAutoDebit = isAutoDebit;
	}

	public Short getIsAutoDebit() {
		return isAutoDebit;
	}

}