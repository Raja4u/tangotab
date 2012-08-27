package com.tangotab.dao.pojo;

// default package

/**
 * RestaurantLocationPreference entity. @author MyEclipse Persistence Tools
 */

public class RestaurantLocationPreference implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer restaurantLocationPreferenceId;
	private CuisineType cuisineTypeId;
	private RestaurantLocation restaurantLocation;

	public Integer getRestaurantLocationPreferenceId() {
		return restaurantLocationPreferenceId;
	}

	public void setRestaurantLocationPreferenceId(Integer restaurantLocationPreferenceId) {
		this.restaurantLocationPreferenceId = restaurantLocationPreferenceId;
	}

	public CuisineType getCuisineTypeId() {
		return cuisineTypeId;
	}

	public void setCuisineTypeId(CuisineType cuisineTypeId) {
		this.cuisineTypeId = cuisineTypeId;
	}

	public RestaurantLocation getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

}