package com.tangotab.web.form;

import org.apache.struts.action.ActionForm;

public class SearchForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String cityName;
	private String zipCode;
	private int cuisineType;
	private int rating;
	private int diningStyle;
	private String priceStartRate;
	private double strtPrice;
	private double endPrice;
	private boolean search;
	private int eventId;
	private int restaurantLocId;
	 private String dealDate;
	private String restauntName;
	public String getRestauntName() {
		return restauntName;
	}

	public void setRestauntName(String restauntName) {
		this.restauntName = restauntName;
	}

	public int getRestaurantLocId() {
		return restaurantLocId;
	}

	public void setRestaurantLocId(int restaurantLocId) {
		this.restaurantLocId = restaurantLocId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	/* search variable is used for pagination to differ two searches in search deals */
	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}
 

	public String getPriceStartRate() {
		return priceStartRate;
	}

	public double getStrtPrice() {
		return strtPrice;
	}

	public void setStrtPrice(double strtPrice) {
		this.strtPrice = strtPrice;
	}

	public double getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(double endPrice) {
		this.endPrice = endPrice;
	}

	public void setPriceStartRate(String priceStartRate) {
		this.priceStartRate = priceStartRate;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(int cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getDiningStyle() {
		return diningStyle;
	}

	public void setDiningStyle(int diningStyle) {
		this.diningStyle = diningStyle;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getDealDate() {
		return dealDate;
	}
}
