package com.tangotab.dao.pojo;

/**
 * RestaurantPaymentProfile entity. @author MyEclipse Persistence Tools
 */
public class RestaurantPaymentProfile implements java.io.Serializable {

	private Integer paymentProfileId;
	private RestaurantCcProfile restaurantCcProfile;
	private Integer ccPaymentId;
	// private Integer ccProfileId;
	private Integer ccprofileId;

	public RestaurantPaymentProfile() {

	}

	public Integer getPaymentProfileId() {
		return paymentProfileId;
	}

	public void setPaymentProfileId(Integer paymentProfileId) {
		this.paymentProfileId = paymentProfileId;
	}

	public RestaurantCcProfile getRestaurantCcProfile() {
		return restaurantCcProfile;
	}

	public void setRestaurantCcProfile(RestaurantCcProfile restaurantCcProfile) {
		this.restaurantCcProfile = restaurantCcProfile;
	}

	public Integer getCcPaymentId() {
		return ccPaymentId;
	}

	public void setCcPaymentId(Integer ccPaymentId) {
		this.ccPaymentId = ccPaymentId;
	}

	public void setCcprofileId(Integer ccprofileId) {
		this.ccprofileId = ccprofileId;
	}

	public Integer getCcprofileId() {
		return ccprofileId;
	}

}
