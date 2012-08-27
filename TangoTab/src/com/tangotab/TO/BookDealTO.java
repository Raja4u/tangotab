package com.tangotab.TO;

public class BookDealTO {
	private int dealId;
	private int userId;
	private int restaurantId;
	private String dealManagerEmailId;
	private String dealManagerName;
	private String dealManagerMoile;
	private String dealName;
	private String businessName;
	private String locationName;
	private String accountManagerEmailId;
	private String accountManagerName;
	private double currentCredits;
	private int billingMethodId;;
	private byte isAutoDebit;

	public String getDealManagerMoile() {
		return dealManagerMoile;
	}

	public void setDealManagerMoile(String dealManagerMoile) {
		this.dealManagerMoile = dealManagerMoile;
	}

	public String getDealManagerName() {
		return dealManagerName;
	}

	public void setDealManagerName(String dealManagerName) {
		this.dealManagerName = dealManagerName;
	}

	public byte getIsAutoDebit() {
		return isAutoDebit;
	}

	public void setIsAutoDebit(byte isAutoDebit) {
		this.isAutoDebit = isAutoDebit;
	}

	public String getAccountManagerEmailId() {
		return accountManagerEmailId;
	}

	public void setAccountManagerEmailId(String accountManagerEmailId) {
		this.accountManagerEmailId = accountManagerEmailId;
	}

	public String getAccountManagerName() {
		return accountManagerName;
	}

	public void setAccountManagerName(String accountManagerName) {
		this.accountManagerName = accountManagerName;
	}

	public double getCurrentCredits() {
		return currentCredits;
	}

	public void setCurrentCredits(double currentCredits) {
		this.currentCredits = currentCredits;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	private String consumerEmailId;
	private String consumerName;
	private String errorMessage;
	private int consumerReservationId;

	public int getConsumerReservationId() {
		return consumerReservationId;
	}

	public void setConsumerReservationId(int consumerReservationId) {
		this.consumerReservationId = consumerReservationId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getDealManagerEmailId() {
		return dealManagerEmailId;
	}

	public void setDealManagerEmailId(String dealManagerEmailId) {
		this.dealManagerEmailId = dealManagerEmailId;
	}

	public String getConsumerEmailId() {
		return consumerEmailId;
	}

	public void setConsumerEmailId(String consumerEmailId) {
		this.consumerEmailId = consumerEmailId;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setBillingMethodId(int billingMethodId) {
		this.billingMethodId = billingMethodId;
	}

	public int getBillingMethodId() {
		return billingMethodId;
	}
}
