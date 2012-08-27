package com.tangotab.dao.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RestaurantDeal entity. @author MyEclipse Persistence Tools
 */

public class RestaurantDeal implements java.io.Serializable {

	// Fields
	private Integer dealTemplateId;
	private String dealTemplateName;
	private String dealTemplateDescription;
	private String dealTemplateRestrictions;
	private Double defaultCreditValue;
	private RestaurantLocation restaurantLocation;
	private String restDealImagePath;
	private Double restDealCreditValue;
	private Short restDealPublishStatus;
	private Timestamp restDealPublishedDate;
	private Timestamp restDealCreateDate; // this is for customdeal approved date
	private String availableWeekDays;
	private Integer availableDealsQty;
	private Integer usedDealsQty;
	private Date restDealStartDate;
	private Date restDealEndDate;
	private Short isRecurring;
	private String availableStartTime;
	private String availableEndTime;
	private Short rewardPoints;
	private Short isActive;
	private Set consumerReservations = new HashSet(0);
	private Short customDeal;
	private Set<RestaurantDealHistory> dealHistory = new HashSet(0);
	private RestaurantDealHistory restaurantDealHistory;
	private DealEvent dealEvent;
	

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

	public Double getDefaultCreditValue() {
		return defaultCreditValue;
	}

	public void setDefaultCreditValue(Double defaultCreditValue) {
		this.defaultCreditValue = defaultCreditValue;
	}

	public RestaurantLocation getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
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

	public Timestamp getRestDealPublishedDate() {
		return restDealPublishedDate;
	}

	public void setRestDealPublishedDate(Timestamp restDealPublishedDate) {
		this.restDealPublishedDate = restDealPublishedDate;
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

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public Set getConsumerReservations() {
		return consumerReservations;
	}

	public void setConsumerReservations(Set consumerReservations) {
		this.consumerReservations = consumerReservations;
	}

	public void setCustomDeal(Short customDeal) {
		this.customDeal = customDeal;
	}

	public Short getCustomDeal() {
		return customDeal;
	}

	public void setRestDealCreateDate(Timestamp restDealCreateDate) {
		this.restDealCreateDate = restDealCreateDate;
	}

	public Timestamp getRestDealCreateDate() {
		return restDealCreateDate;
	}

	public void setDealHistory(Set<RestaurantDealHistory> dealHistory) {
		this.dealHistory = dealHistory;
	}

	public Set<RestaurantDealHistory> getDealHistory() {
		return dealHistory;
	}

	public void setRestaurantDealHistory(RestaurantDealHistory restaurantDealHistory) {
		this.restaurantDealHistory = restaurantDealHistory;
	}

	public RestaurantDealHistory getRestaurantDealHistory() {
		return restaurantDealHistory;
	}

	public void setDealEvent(DealEvent dealEvent) {
		this.dealEvent = dealEvent;
	}

	public DealEvent getDealEvent() {
		return dealEvent;
	}

}