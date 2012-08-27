package com.tangotab.dao.pojo;

import java.sql.Timestamp;

/**
 * RestaurantDiscount entity. @author MyEclipse Persistence Tools
 */

public class RestaurantDiscount implements java.io.Serializable {

	// Fields

	private Integer restDiscountId;
	private Double discountAmount;
	private Timestamp startDate;
	private Timestamp endDate;
	private String referredBy;
	private String reasonForDiscount;
	private Short isActive;
	private Integer restLocationId;

	// Constructors

	/** default constructor */
	public RestaurantDiscount() {
	}

	/** minimal constructor */
	public RestaurantDiscount(Double discountAmount, Timestamp startDate, String referredBy,
			Short isActive, Integer restLocationId) {
		this.discountAmount = discountAmount;
		this.startDate = startDate;
		this.referredBy = referredBy;
		this.isActive = isActive;
		this.restLocationId = restLocationId;
	}

	/** full constructor */
	public RestaurantDiscount(Double discountAmount, Timestamp startDate, Timestamp endDate,
			String referredBy, String reasonForDiscount, Short isActive, Integer restLocationId) {
		this.discountAmount = discountAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.referredBy = referredBy;
		this.reasonForDiscount = reasonForDiscount;
		this.isActive = isActive;
		this.restLocationId = restLocationId;
	}

	// Property accessors

	public Integer getRestDiscountId() {
		return this.restDiscountId;
	}

	public void setRestDiscountId(Integer restDiscountId) {
		this.restDiscountId = restDiscountId;
	}

	public Double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getReferredBy() {
		return this.referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getReasonForDiscount() {
		return this.reasonForDiscount;
	}

	public void setReasonForDiscount(String reasonForDiscount) {
		this.reasonForDiscount = reasonForDiscount;
	}

	public Short getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public Integer getRestLocationId() {
		return this.restLocationId;
	}

	public void setRestLocationId(Integer restLocationId) {
		this.restLocationId = restLocationId;
	}

}