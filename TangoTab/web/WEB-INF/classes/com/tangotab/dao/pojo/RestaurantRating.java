package com.tangotab.dao.pojo;

/**
 * RestaurantRating entity. @author MyEclipse Persistence Tools
 */

public class RestaurantRating implements java.io.Serializable {

	// Fields

	private Integer restRatingsId;
	private User user;
	private RestaurantLocation restaurantLocation;
	private Double userRating;
	private String userComments;

	// Constructors

	/** default constructor */
	public RestaurantRating() {
	}

	/** full constructor */
	public RestaurantRating(User user, RestaurantLocation restaurantLocation, Double userRating,
			String userComments) {
		this.user = user;
		this.restaurantLocation = restaurantLocation;
		this.userRating = userRating;
		this.userComments = userComments;
	}

	// Property accessors

	public Integer getRestRatingsId() {
		return this.restRatingsId;
	}

	public void setRestRatingsId(Integer restRatingsId) {
		this.restRatingsId = restRatingsId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RestaurantLocation getRestaurantLocation() {
		return this.restaurantLocation;
	}

	public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public Double getUserRating() {
		return this.userRating;
	}

	public void setUserRating(Double userRating) {
		this.userRating = userRating;
	}

	public String getUserComments() {
		return this.userComments;
	}

	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}

}