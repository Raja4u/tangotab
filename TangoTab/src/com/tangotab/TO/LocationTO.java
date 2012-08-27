package com.tangotab.TO;

public class LocationTO {
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
	private Integer rating;
	private Integer restaurantId;
	private String address;
	private Integer userId;
	private String firstname;
	private int[] diningStylePreferences;
	private Integer preferCityId;
	private String address1;
	private String password;
	private String alternateEmailIds;
	private String[] emailIdArray;
	private String[] nameArray;
	
    private String hostAsManager = "No";
   // private UserTO userTo;
    private RestaurantTO restaurantTO;
    private String businessTitle;    
	
	public String getBusinessTitle() {
		return businessTitle;
	}
	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}
	
	public String[] getNameArray() {
		return nameArray;
	}

	public void setNameArray(String[] nameArray) {
		this.nameArray = nameArray;
	}

	public RestaurantTO getRestaurantTO() {
		return restaurantTO;
	}

	public void setRestaurantTO(RestaurantTO restaurantTO) {
		this.restaurantTO = restaurantTO;
	}

	/*public UserTO getUserTo() {
		return userTo;
	}

	public void setUserTo(UserTO userTo) {
		this.userTo = userTo;
	}*/

	public String getHostAsManager() {
		return hostAsManager;
	}

	public void setHostAsManager(String hostAsManager) {
		this.hostAsManager = hostAsManager;
	}
	

	public String[] getEmailIdArray() {
		return emailIdArray;
	}

	public void setEmailIdArray(String[] emailIdArray) {
		this.emailIdArray = emailIdArray;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
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

	public int[] getPreferencesList() {
		return preferencesList;
	}

	public void setPreferencesList(int[] preferencesList) {
		this.preferencesList = preferencesList;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
