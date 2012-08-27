package com.tangotab.TO;

import java.util.Date;

public class SearchTO {
	private String cityName;
	private String zipCode;
	private int cuisineType;
	private int rating;
	private int diningStyle;
	private String priceStartRate;
	private Double startPrice;
	private Double endPrice;
    private int eventId = 0;
    private Date dealAvailDate;
    private String dealDate;
    private boolean isNear;
    private boolean search;
    
    public int getRestaurantLocId() {
		return restaurantLocId;
	}

	public void setRestaurantLocId(int restaurantLocId) {
		this.restaurantLocId = restaurantLocId;
	}

	private int restaurantLocId;
    private String restauntName;
    
	public String getRestauntName() {
		return restauntName;
	}

	public void setRestauntName(String restauntName) {
		this.restauntName = restauntName;
	}
 

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
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

	public String getPriceStartRate() {
		return priceStartRate;
	}

	public void setPriceStartRate(String priceStartRate) {
		this.priceStartRate = priceStartRate;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public Double getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}

	public void setDealAvailDate(Date dealAvailDate) {
		this.dealAvailDate = dealAvailDate;
	}

	public Date getDealAvailDate() {
		return dealAvailDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getDealDate() {
		return dealDate;
	}

	public boolean isNear() {
		return isNear;
	}

	public void setNear(boolean isNear) {
		this.isNear = isNear;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	
	
	
}
