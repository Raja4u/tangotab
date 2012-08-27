package com.tangotab.TO;

public class BillingCcTO {

	private int billingCcId;
	private int restaurantId;

	private String purchasedDate;
	private String purchasedBy;
	private int isAutoDebit;
	private int noOfUnits;
	private int isPrivacyAccepted;
	private int transRespCode;
	private String transRespDesc;
	private String transNumber;
	private String accNo;
	private String amount;
	private int restId;
	private Double doubleAmount;

	public Double getDoubleAmount() {
		return doubleAmount;
	}

	public void setDoubleAmount(Double doubleAmount) {
		this.doubleAmount = doubleAmount;
	}

	public int getBillingCcId() {
		return billingCcId;
	}

	public void setBillingCcId(int billingCcId) {
		this.billingCcId = billingCcId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public String getPurchasedBy() {
		return purchasedBy;
	}

	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}

	public int getIsAutoDebit() {
		return isAutoDebit;
	}

	public void setIsAutoDebit(int isAutoDebit) {
		this.isAutoDebit = isAutoDebit;
	}

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

	public int getIsPrivacyAccepted() {
		return isPrivacyAccepted;
	}

	public void setIsPrivacyAccepted(int isPrivacyAccepted) {
		this.isPrivacyAccepted = isPrivacyAccepted;
	}

	public int getTransRespCode() {
		return transRespCode;
	}

	public void setTransRespCode(int transRespCode) {
		this.transRespCode = transRespCode;
	}

	public String getTransRespDesc() {
		return transRespDesc;
	}

	public void setTransRespDesc(String transRespDesc) {
		this.transRespDesc = transRespDesc;
	}

	public String getTransNumber() {
		return transNumber;
	}

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

}
