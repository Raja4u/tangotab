package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

public class RestaurantLocation implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer restLocationId;
	private User user;
	private Restaurant restaurant;
	private String streetNo;
	private String streetName;
	private City city;
	private Integer stateId;
	private Integer countryId;
	private String zipCode;
	private String directionImgPath;
	private String locationRestName;
	private String locationRestImgPath;
	private Short isActive;
	private String cuisineTypeIds;
	private String diningStyleIds;
	private Double priceStartRate;
	private Double priceEndRate;
	private String webSite;
	private String description;
	private Integer rating;
	private String cityId;
	private String address;
	private String address1;
	private String locationHomePhone;
	private Double longitude ;
	private Double latitude ;
	private String alternateEmailIds;
	private Double distance; 
	

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getAlternateEmailIds() {
		return alternateEmailIds;
	}

	public void setAlternateEmailIds(String alternateEmailIds) {
		this.alternateEmailIds = alternateEmailIds;
	}

	public String getLocationHomePhone() {
		return locationHomePhone;
	}

	public void setLocationHomePhone(String locationHomePhone) {
		this.locationHomePhone = locationHomePhone;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	private Set<RestaurantRating> restaurantRatings = new HashSet<RestaurantRating>(0);
	private Set<SalesLocation> salesLocations = new HashSet<SalesLocation>(0);
	private Set<RestaurantDeal> restaurantDeals = new HashSet<RestaurantDeal>(0);
	private Set<RestaurantLocationPreference> locationPreferences = new HashSet<RestaurantLocationPreference>(
			0);
	private Set<RestaurantDinnigPreferences> diningPreferences = new HashSet<RestaurantDinnigPreferences>(
			0);

	public Set<RestaurantDinnigPreferences> getDiningPreferences() {
		return diningPreferences;
	}

	public void setDiningPreferences(Set<RestaurantDinnigPreferences> diningPreferences) {
		this.diningPreferences = diningPreferences;
	}

	public Set<RestaurantLocationPreference> getLocationPreferences() {
		return locationPreferences;
	}

	public void setLocationPreferences(Set<RestaurantLocationPreference> locationPreferences) {
		this.locationPreferences = locationPreferences;
	}

	public Integer getRestLocationId() {
		return restLocationId;
	}

	public void setRestLocationId(Integer restLocationId) {
		this.restLocationId = restLocationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDirectionImgPath() {
		return directionImgPath;
	}

	public void setDirectionImgPath(String directionImgPath) {
		this.directionImgPath = directionImgPath;
	}

	public String getLocationRestName() {
		return locationRestName;
	}

	public void setLocationRestName(String locationRestName) {
		this.locationRestName = locationRestName;
	}

	public String getLocationRestImgPath() {
		return locationRestImgPath;
	}

	public void setLocationRestImgPath(String locationRestImgPath) {
		this.locationRestImgPath = locationRestImgPath;
	}

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public String getCuisineTypeIds() {
		return cuisineTypeIds;
	}

	public void setCuisineTypeIds(String cuisineTypeIds) {
		this.cuisineTypeIds = cuisineTypeIds;
	}

	public String getDiningStyleIds() {
		return diningStyleIds;
	}

	public void setDiningStyleIds(String diningStyleIds) {
		this.diningStyleIds = diningStyleIds;
	}

	public Double getPriceStartRate() {
		return priceStartRate;
	}

	public void setPriceStartRate(Double priceStartRate) {
		this.priceStartRate = priceStartRate;
	}

	public Double getPriceEndRate() {
		return priceEndRate;
	}

	public void setPriceEndRate(Double priceEndRate) {
		this.priceEndRate = priceEndRate;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<RestaurantRating> getRestaurantRatings() {
		return restaurantRatings;
	}

	public void setRestaurantRatings(Set<RestaurantRating> restaurantRatings) {
		this.restaurantRatings = restaurantRatings;
	}

	public Set<SalesLocation> getSalesLocations() {
		return salesLocations;
	}

	public void setSalesLocations(Set<SalesLocation> salesLocations) {
		this.salesLocations = salesLocations;
	}

	public Set<RestaurantDeal> getRestaurantDeals() {
		return restaurantDeals;
	}

	public void setRestaurantDeals(Set<RestaurantDeal> restaurantDeals) {
		this.restaurantDeals = restaurantDeals;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress1() {
		return address1;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

}