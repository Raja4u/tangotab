package com.tangotab.TO;

import java.math.BigInteger;


public class RevenueReportTO {

	private String city_id;
	private String state;
	private Object amountCharged;
	private Object accuredCredits;
	private Integer publishedDeals;
	private Object revenue;
	private String BUSINESS_NAME;
	private Double CURRENT_CREDITS;
	private Integer noOfDealsReserved;
	
	public Double getCURRENT_CREDITS() {
		return CURRENT_CREDITS;
	}
	public String getBUSINESS_NAME() {
		return BUSINESS_NAME;
	}
	public void setBUSINESS_NAME(String business_name) {
		BUSINESS_NAME = business_name;
	}
	public void setCURRENT_CREDITS(Double current_credits) {
		CURRENT_CREDITS = current_credits;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getAmountCharged() {
		return amountCharged;
	}
	public void setAmountCharged(Object amountCharged) {
		
			this.amountCharged = amountCharged;
	}
	public Object getAccuredCredits() {
		return accuredCredits;
	}
	public void setAccuredCredits(Object accuredCredits) {
		this.accuredCredits = accuredCredits;
	}
	public Integer getPublishedDeals() {
		return publishedDeals;
	}
	public void setPublishedDeals(Integer publishedDeals) {
		this.publishedDeals = publishedDeals;
	}
	public Integer getNoOfDealsReserved() {
		return noOfDealsReserved;
	}
	public void setNoOfDealsReserved(Integer noOfDealsReserved) {
		this.noOfDealsReserved = noOfDealsReserved;
	}
	public Object getRevenue() {
		return revenue;
	}
	public void setRevenue(Object revenue) {
		this.revenue = revenue;
	}
		
}
