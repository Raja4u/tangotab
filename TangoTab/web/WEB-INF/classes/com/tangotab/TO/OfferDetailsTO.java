package com.tangotab.TO;

import java.util.Date;

public class OfferDetailsTO {
	
	private Date date;
	private Integer publishedCount;
	private Integer availableCount;
	private Integer cityId;
	private String cityName;
		
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getPublishedCount() {
		return publishedCount;
	}
	public void setPublishedCount(Integer publishedCount) {
		this.publishedCount = publishedCount;
	}
	public Integer getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(Integer availableCount) {
		this.availableCount = availableCount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
