package com.tangotab.TO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.tangotab.dao.pojo.DealEvent;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.util.DecimalFormatUtility;

public class DealTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer dealTemplateId;
	private String dealTemplateName;
	private String dealTemplateDescription;
	private String dealTemplateRestrictions;
	private Double defaultCreditValue;
	private String restDealImagePath;
	private Double restDealCreditValue;
	private Short restDealPublishStatus;
	private String availableWeekDays;
	private Integer availableDealsQty;
	private Integer usedDealsQty;
	private String startDate;
	private String dealEndDate;
	private java.util.Date startDateForSearch;
	private java.util.Date dealEndDateForSearch;
	private Short isRecurring;
	private String availableStartTime;
	private String availableEndTime;
	private Short rewardPoints;
	private Short isActive;
	private int[] weekDays;
	private Integer restLocationId;
	private int sunday;
	private int monday;
	private int tuesday;
	private int wednesday;
	private int thursday;
	private int friday;
	private int staturday;
	private String address;
	private String diningStyleString;
	private String cuisineTypeString;
	private String cellPhone;
	private String website;
	private String price;
	private int loginUserId;
	private int tobeBookedDealId;
	private int remainingDeals;
	private String customDealTemplateName;
	private String locationRestName;
	private String description;
	private String locationRestImgPath;
	private Short customDeal;
	private String day;
	private String locationName;
	private String dealTemplateImgPath;
	private int billingMethodId;
	private double currentCredits;
	private RestaurantDeal restaurantDeal;

	private String address1;
	private String state;
	private String city;
	private String zipcode;
	private String prefercity;
	
	private int dealEventId;
	private EventsTO event;
	private DealEvent dealEvent;
	private int eventId;
	private Date restDealStartDate;
	private Date dealStartDate;
	private Date restDealEndDate;
	private String hostAddress;
	private String hostMobileNumber;
	private String alternateEmailIds;
	private String restDealPublishedDate;
	private String restDealCreateDate; 
	private String alternateHosts;
	private String compressedURL;
	private String CITY_NAME;
	private boolean expired;
	
	public String getAlternateHosts() {
		return alternateHosts;
	}

	public void setAlternateHosts(String alternateHosts) {
		this.alternateHosts = alternateHosts;
	}

	public String getRestDealPublishedDate() {
		return restDealPublishedDate;
	}

	public void setRestDealPublishedDate(String restDealPublishedDate) {
		this.restDealPublishedDate = restDealPublishedDate;
	}

	public String getRestDealCreateDate() {
		return restDealCreateDate;
	}

	public void setRestDealCreateDate(String restDealCreateDate) {
		this.restDealCreateDate = restDealCreateDate;
	}

	public String getAlternateEmailIds() {
		return alternateEmailIds;
	}

	public void setAlternateEmailIds(String alternateEmailIds) {
		this.alternateEmailIds = alternateEmailIds;
	}
	  public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public String getHostMobileNumber() {
		return hostMobileNumber;
	}

	public void setHostMobileNumber(String hostMobileNumber) {
		this.hostMobileNumber = hostMobileNumber;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLocationphone() {
		return locationphone;
	}

	public void setLocationphone(String locationphone) {
		this.locationphone = locationphone;
	}

	private double diningStyleId;
	private double distance;
	  private ArrayList<WeekDate> weakDate;
		private String firstname;
		private String locationphone;
		private String locationEmailId;
		
	 
	public String getLocationEmailId() {
			return locationEmailId;
		}

		public void setLocationEmailId(String locationEmailId) {
			this.locationEmailId = locationEmailId;
		}

	public void setDealStartDate(Date dealStartDate) {
		this.dealStartDate = dealStartDate;
	}

	public Date getDealStartDate() {
		return dealStartDate;
	}
	public double getDiningStyleId() {
		return diningStyleId;
	}

	public void setDiningStyleId(double diningStyleId) {
		this.diningStyleId = diningStyleId;
	}

	public double getPriceEndRate() {
		return priceEndRate;
	}

	public void setPriceEndRate(double priceEndRate) {
		this.priceEndRate = priceEndRate;
	}

	private double priceEndRate;
	
	public Date getRestDealStartDate() {
		return restDealStartDate;
	}

	public void setRestDealStartDate(Date restDealStartDate) {
		this.restDealStartDate = restDealStartDate;
	}

	public Date getRestDealEndDate() {
		return restDealEndDate;
	}

	public void setRestDealEndDate(Date restDealEndDate) {
		this.restDealEndDate = restDealEndDate;
	}

	private Date dealDateWithTime;
	
	public Date getDealDateWithTime() {
		return dealDateWithTime;
	}

	public void setDealDateWithTime(Date dealDateWithTime) {
		this.dealDateWithTime = dealDateWithTime;
	}
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public DealEvent getDealEvent() {
		return dealEvent;
	}

	public void setDealEvent(DealEvent dealEvent) {
		this.dealEvent = dealEvent;
	}

	private Events events;

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
	public int getDealEventId() {
		return dealEventId;
	}

	public void setDealEventId(int dealEventId) {
		this.dealEventId = dealEventId;
	}

	public EventsTO getEvent() {
		return event;
	}

	public void setEventTO(EventsTO event) {
		this.event = event;
	}

	public String getPrefercity() {
		return prefercity;
	}

	public void setPrefercity(String prefercity) {
		this.prefercity = prefercity;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBillingMethodId() {
		return billingMethodId;
	}

	public void setBillingMethodId(int billingMethodId) {
		this.billingMethodId = billingMethodId;
	}

	public double getCurrentCredits() {
		return currentCredits;
	}

	public void setCurrentCredits(double currentCredits) {
		this.currentCredits = currentCredits;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLocationRestImgPath() {
		return locationRestImgPath;
	}

	public void setLocationRestImgPath(String locationRestImgPath) {
		this.locationRestImgPath = locationRestImgPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocationRestName() {
		return locationRestName;
	}

	public void setLocationRestName(String locationRestName) {
		this.locationRestName = locationRestName;
	}

	public String getCustomDealTemplateName() {
		return customDealTemplateName;
	}

	public void setCustomDealTemplateName(String customDealTemplateName) {
		this.customDealTemplateName = customDealTemplateName;
	}

	/**
	 * @return the startDateForSearch
	 */
	public java.util.Date getStartDateForSearch() {
		return startDateForSearch;
	}

	/**
	 * @param startDateForSearch
	 *            the startDateForSearch to set
	 */
	public void setStartDateForSearch(java.util.Date startDateForSearch) {
		this.startDateForSearch = startDateForSearch;
	}

	/**
	 * @return the dealEndDateForSearch
	 */
	public java.util.Date getDealEndDateForSearch() {
		return dealEndDateForSearch;
	}

	/**
	 * @param dealEndDateForSearch
	 *            the dealEndDateForSearch to set
	 */
	public void setDealEndDateForSearch(java.util.Date dealEndDateForSearch) {
		this.dealEndDateForSearch = dealEndDateForSearch;
	}

	public int getRemainingDeals() {
		return remainingDeals;
	}

	public void setRemainingDeals(int remainingDeals) {
		this.remainingDeals = remainingDeals;
	}

	public int getSunday() {
		return sunday;
	}

	public void setSunday(int sunday) {
		this.sunday = sunday;
	}

	public int getMonday() {
		return monday;
	}

	public void setMonday(int monday) {
		this.monday = monday;
	}

	public int getTuesday() {
		return tuesday;
	}

	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}

	public int getWednesday() {
		return wednesday;
	}

	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}

	public int getThursday() {
		return thursday;
	}

	public void setThursday(int thursday) {
		this.thursday = thursday;
	}

	public int getFriday() {
		return friday;
	}

	public void setFriday(int friday) {
		this.friday = friday;
	}

	public int getStaturday() {
		return staturday;
	}

	public void setStaturday(int staturday) {
		this.staturday = staturday;
	}

	public int getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(int loginUserId) {
		this.loginUserId = loginUserId;
	}

	public int getTobeBookedDealId() {
		return tobeBookedDealId;
	}

	public void setTobeBookedDealId(int tobeBookedDealId) {
		this.tobeBookedDealId = tobeBookedDealId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getDiningStyleString() {
		return diningStyleString;
	}

	public void setDiningStyleString(String diningStyleString) {
		this.diningStyleString = diningStyleString;
	}

	public String getCuisineTypeString() {
		return cuisineTypeString;
	}

	public void setCuisineTypeString(String cuisineTypeString) {
		this.cuisineTypeString = cuisineTypeString;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRestLocationId() {
		return restLocationId;
	}

	public void setRestLocationId(Integer restLocationId) {
		this.restLocationId = restLocationId;
	}

	public int[] getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(int[] weekDays) {
		this.weekDays = weekDays;
	}

	public Integer getDealTemplateId() {
		return dealTemplateId;
	}

	public void setDealTemplateId(Integer dealTemplateId) {
		this.dealTemplateId = dealTemplateId;
	}

	public String getDealTemplateName() {
		return dealTemplateName;
	}

	public void setDealTemplateName(String dealTemplateName) {
		this.dealTemplateName = dealTemplateName;
	}

	public String getDealTemplateDescription() {
		return dealTemplateDescription;
	}

	public void setDealTemplateDescription(String dealTemplateDescription) {
		this.dealTemplateDescription = dealTemplateDescription;
	}

	public String getDealTemplateRestrictions() {
		return dealTemplateRestrictions;
	}

	public void setDealTemplateRestrictions(String dealTemplateRestrictions) {
		this.dealTemplateRestrictions = dealTemplateRestrictions;
	}

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public Double getDefaultCreditValue() {
		return defaultCreditValue;
	}

	public void setDefaultCreditValue(Double defaultCreditValue) {
		this.defaultCreditValue = defaultCreditValue;
	}

	public String getRestDealImagePath() {
		return restDealImagePath;
	}

	public void setRestDealImagePath(String restDealImagePath) {
		this.restDealImagePath = restDealImagePath;
	}

	public Double getRestDealCreditValue() {
		return restDealCreditValue;
	}

	public void setRestDealCreditValue(Double restDealCreditValue) {
		this.restDealCreditValue = restDealCreditValue;
	}

	public Short getRestDealPublishStatus() {
		return restDealPublishStatus;
	}

	public void setRestDealPublishStatus(Short restDealPublishStatus) {
		this.restDealPublishStatus = restDealPublishStatus;
	}

	public String getAvailableWeekDays() {
		return availableWeekDays;
	}

	public void setAvailableWeekDays(String availableWeekDays) {
		this.availableWeekDays = availableWeekDays;
	}

	public Integer getAvailableDealsQty() {
		return availableDealsQty;
	}

	public void setAvailableDealsQty(Integer availableDealsQty) {
		this.availableDealsQty = availableDealsQty;
	}

	public Integer getUsedDealsQty() {
		return usedDealsQty;
	}

	public void setUsedDealsQty(Integer usedDealsQty) {
		this.usedDealsQty = usedDealsQty;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDealEndDate() {
		return dealEndDate;
	}

	public void setDealEndDate(String dealEndDate) {
		this.dealEndDate = dealEndDate;
	}

	public Short getIsRecurring() {
		return isRecurring;
	}

	public void setIsRecurring(Short isRecurring) {
		this.isRecurring = isRecurring;
	}

	public String getAvailableStartTime() {
		return availableStartTime;
	}

	public void setAvailableStartTime(String availableStartTime) {
		this.availableStartTime = availableStartTime;
	}

	public String getAvailableEndTime() {
		return availableEndTime;
	}

	public void setAvailableEndTime(String availableEndTime) {
		this.availableEndTime = availableEndTime;
	}

	public Short getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Short rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public void setCustomDeal(Short customDeal) {
		this.customDeal = customDeal;
	}

	public Short getCustomDeal() {
		return customDeal;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getDealTemplateImgPath() {
		return dealTemplateImgPath;
	}

	public void setDealTemplateImgPath(String dealTemplateImgPath) {
		this.dealTemplateImgPath = dealTemplateImgPath;
	}

	public void setRestaurantDeal(RestaurantDeal restaurantDeal) {
		this.restaurantDeal = restaurantDeal;
	}

	public RestaurantDeal getRestaurantDeal() {
		return restaurantDeal;
	}

	public void setWeakDate(ArrayList<WeekDate> weakDate) {
		this.weakDate = weakDate;
	}

	public ArrayList<WeekDate> getWeakDate() {
		return weakDate;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return DecimalFormatUtility.getDecimalFormat(distance);
	}

	/** 
	 * Setters and getters for compressedURL
	 */
	public String getCompressedURL() {
		return compressedURL;
	}

	public void setCompressedURL(String compressedURL) {
		this.compressedURL = compressedURL;
	}

	public String getCITY_NAME() {
		return CITY_NAME;
	}

	public void setCITY_NAME(String city_name) {
		this.CITY_NAME = city_name;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

		
	
	

}
