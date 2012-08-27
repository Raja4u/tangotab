package com.tangotab.dao.pojo;

import java.sql.Timestamp;

/**
 * ConsumerReservation entity. @author MyEclipse Persistence Tools
 */

public class ConsumerReservation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer conResId;
	private User user;
	private RestaurantDeal restaurantDeal;
	private Timestamp reservedTimestamp;
	private Timestamp bookedTimestamp;
	private Short isConsumerShownUp;
	private String source;

  	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	// Constructors

	/** default constructor */
	public ConsumerReservation() {
	}

	/** minimal constructor */
	public ConsumerReservation(User user, RestaurantDeal restaurantDeal, Timestamp reservedTimestamp) {
		this.user = user;
		this.restaurantDeal = restaurantDeal;
		this.reservedTimestamp = reservedTimestamp;
	}

	/** full constructor */
	public ConsumerReservation(User user, RestaurantDeal restaurantDeal,
			Timestamp reservedTimestamp, Short isConsumerShownUp) {
		this.user = user;
		this.restaurantDeal = restaurantDeal;
		this.reservedTimestamp = reservedTimestamp;
		this.isConsumerShownUp = isConsumerShownUp;
	}

	// Property accessors

	public Integer getConResId() {
		return this.conResId;
	}

	public void setConResId(Integer conResId) {
		this.conResId = conResId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RestaurantDeal getRestaurantDeal() {
		return this.restaurantDeal;
	}

	public void setRestaurantDeal(RestaurantDeal restaurantDeal) {
		this.restaurantDeal = restaurantDeal;
	}

	public Timestamp getReservedTimestamp() {
		return this.reservedTimestamp;
	}

	public void setReservedTimestamp(Timestamp reservedTimestamp) {
		this.reservedTimestamp = reservedTimestamp;
	}

	public Short getIsConsumerShownUp() {
		return this.isConsumerShownUp;
	}

	public void setIsConsumerShownUp(Short isConsumerShownUp) {
		this.isConsumerShownUp = isConsumerShownUp;
	}

	public Timestamp getBookedTimestamp() {
		return this.bookedTimestamp;
	}

	public void setBookedTimestamp(Timestamp bookedTimestamp) {
		this.bookedTimestamp = bookedTimestamp;
	}

}