package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class SalesManagerRegForm extends ValidatorForm {
	private static final long serialVersionUID = 1L;
	private String homePhone;
	private String emailId;
	private String hireDate;
	private String terminationDate;
	private String firstname;
	private String lastname;
	private String address;
	private String mobilePhone;
	private String[] totalCities;
	private String[] cities;
	private int assignedManager;
	private String[] zipCodes;
	private int cityId;
	private int salesManId;
	private int salesInfoId;
	private int userId;
	private int salesRepUserId;
	private int salasMgrUserId;
	private int[] activeId;
	private int[] salesId;

	public int[] getSalesId() {
		return salesId;
	}

	public void setSalesId(int[] salesId) {
		this.salesId = salesId;
	}

	public int[] getActiveId() {
		return activeId;
	}

	public void setActiveId(int[] activeId) {
		this.activeId = activeId;
	}

	public int getSalasMgrUserId() {
		return salasMgrUserId;
	}

	public void setSalasMgrUserId(int salasMgrUserId) {
		this.salasMgrUserId = salasMgrUserId;
	}

	public int getSalesInfoId() {
		return salesInfoId;
	}

	public void setSalesInfoId(int salesInfoId) {
		this.salesInfoId = salesInfoId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSalesRepUserId() {
		return salesRepUserId;
	}

	public void setSalesRepUserId(int salesRepUserId) {
		this.salesRepUserId = salesRepUserId;
	}

	public int getSalesManId() {
		return salesManId;
	}

	public void setSalesManId(int salesManId) {
		this.salesManId = salesManId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getAssignedManager() {
		return assignedManager;
	}

	public void setAssignedManager(int assignedManager) {
		this.assignedManager = assignedManager;
	}

	public String[] getZipCodes() {
		return zipCodes;
	}

	public void setZipCodes(String[] zipCodes) {
		this.zipCodes = zipCodes;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String[] getTotalCities() {
		return totalCities;
	}

	public void setTotalCities(String[] totalCities) {
		this.totalCities = totalCities;
	}

	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}
}
