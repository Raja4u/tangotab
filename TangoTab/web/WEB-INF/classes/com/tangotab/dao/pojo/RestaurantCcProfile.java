package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * RestaurantCcProfile entity. @author MyEclipse Persistence Tools
 */
public class RestaurantCcProfile implements java.io.Serializable {
	private Integer restaurantCcProfileId;
	private Restaurant restaurant;
	private Integer ccProfileId;

	private Set<RestaurantPaymentProfile> restaurantPaymentProfile = new HashSet<RestaurantPaymentProfile>(
			0);

	public Integer getRestaurantCcProfileId() {
		return this.restaurantCcProfileId;
	}

	public void setRestaurantCcProfileId(Integer restaurantCcProfileId) {
		this.restaurantCcProfileId = restaurantCcProfileId;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getCcProfileId() {
		return this.ccProfileId;
	}

	public void setCcProfileId(Integer ccProfileId) {
		this.ccProfileId = ccProfileId;
	}

	public RestaurantCcProfile() {
	}

	public void setRestaurantPaymentProfile(Set<RestaurantPaymentProfile> restaurantPaymentProfile) {
		this.restaurantPaymentProfile = restaurantPaymentProfile;
	}

	public Set<RestaurantPaymentProfile> getRestaurantPaymentProfile() {
		return restaurantPaymentProfile;
	}

}
