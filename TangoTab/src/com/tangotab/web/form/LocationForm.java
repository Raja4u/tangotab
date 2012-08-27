package com.tangotab.web.form;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class LocationForm extends ValidatorForm {

	private static final long serialVersionUID = 1L;
	private Integer restLocationId;
	private String streetNo;
	private String streetName;
	private String cityId;
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
	private String emailId;
	private String mobilePhone;
	private String locationHomePhone;
	private String fax;
	private int[] preferencesList;
	private String businessName;
	private String dealManagerName;
	private FormFile locationImage;
	private String firstname;
	private String address;
	private int[] diningStylePreferences;
	private Integer rating;
	private String existImagePath;
	private FormFile directionImage;
	private Integer preferCityId;
	private String address1;
	private String existedManager = "No";
	private String managerId;
	private String emailIds;
	private String password;
	private String alternateEmailIds;
	private String emailIdOne;
	
	private String emailIdTwo;
	private String emailIdThree;
	private String emailIdFour;
	private String emailIdFive;
	private String nameOne;
	private String nameTwo;
	private String nameThree;
	private String nameFour;
	private String nameFive;
	private String emailIdsArray[]={};
	private String hostAsManager = "No";	
	private Integer restaurantId;
	private String businessTitle;    
	
	public String getBusinessTitle() {
		return businessTitle;
	}
	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}
	
	
	public String getNameOne() {
		return nameOne;
	}

	public void setNameOne(String nameOne) {
		this.nameOne = nameOne;
	}

	public String getNameTwo() {
		return nameTwo;
	}

	public void setNameTwo(String nameTwo) {
		this.nameTwo = nameTwo;
	}

	public String getNameThree() {
		return nameThree;
	}

	public void setNameThree(String nameThree) {
		this.nameThree = nameThree;
	}

	public String getNameFour() {
		return nameFour;
	}

	public void setNameFour(String nameFour) {
		this.nameFour = nameFour;
	}

	public String getNameFive() {
		return nameFive;
	}

	public void setNameFive(String nameFive) {
		this.nameFive = nameFive;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getHostAsManager() {
		return hostAsManager;
	}

	public void setHostAsManager(String hostAsManager) {
		this.hostAsManager = hostAsManager;
	}

	public String[] getEmailIdsArray() {
		return emailIdsArray;
	}

	public void setEmailIdsArray(String[] emailIdsArray) {
		this.emailIdsArray = emailIdsArray;
	}

	public String getEmailIdOne() {
		return emailIdOne;
	}

	public void setEmailIdOne(String emailIdOne) {
		this.emailIdOne = emailIdOne;
	}

	public String getEmailIdTwo() {
		return emailIdTwo;
	}

	public void setEmailIdTwo(String emailIdTwo) {
		this.emailIdTwo = emailIdTwo;
	}

	public String getEmailIdThree() {
		return emailIdThree;
	}

	public void setEmailIdThree(String emailIdThree) {
		this.emailIdThree = emailIdThree;
	}

	public String getEmailIdFour() {
		return emailIdFour;
	}

	public void setEmailIdFour(String emailIdFour) {
		this.emailIdFour = emailIdFour;
	}

	public String getEmailIdFive() {
		return emailIdFive;
	}

	public void setEmailIdFive(String emailIdFive) {
		this.emailIdFive = emailIdFive;
	}

	public String getAlternateEmailIds() {
		return alternateEmailIds;
	}

	public void setAlternateEmailIds(String alternateEmailIds) {
		this.alternateEmailIds = alternateEmailIds;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(String emailIds) {
		this.emailIds = emailIds;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getExistedManager() {
		return existedManager;
	}

	public void setExistedManager(String existedManager) {
		this.existedManager = existedManager;
	}

	private Integer userId;

	public String getExistImagePath() {
		return existImagePath;
	}

	public void setExistImagePath(String existImagePath) {
		this.existImagePath = existImagePath;
	}

	public int[] getDiningStylePreferences() {
		return diningStylePreferences;
	}

	public void setDiningStylePreferences(int[] diningStylePreferences) {
		this.diningStylePreferences = diningStylePreferences;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public FormFile getLocationImage() {
		return locationImage;
	}

	public void setLocationImage(FormFile locationImage) {
		this.locationImage = locationImage;
	}

	public FormFile getDirectionImage() {
		return directionImage;
	}

	public void setDirectionImage(FormFile directionImage) {
		this.directionImage = directionImage;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDealManagerName() {
		return dealManagerName;
	}

	public void setDealManagerName(String dealManagerName) {
		this.dealManagerName = dealManagerName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int[] getPreferencesList() {
		return preferencesList;
	}

	public void setPreferencesList(int[] preferencesList) {
		this.preferencesList = preferencesList;
	}

	public Integer getRestLocationId() {
		return restLocationId;
	}

	public void setRestLocationId(Integer restLocationId) {
		this.restLocationId = restLocationId;
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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getLocationHomePhone() {
		return locationHomePhone;
	}

	public void setLocationHomePhone(String locationHomePhone) {
		this.locationHomePhone = locationHomePhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	// location ratings are added for admin adding purpose here.

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public void setPreferCityId(Integer preferCityId) {
		this.preferCityId = preferCityId;
	}

	public Integer getPreferCityId() {
		return preferCityId;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress1() {
		return address1;
	}

}
