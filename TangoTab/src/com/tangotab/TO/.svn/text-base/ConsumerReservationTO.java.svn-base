package com.tangotab.TO;

import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.User;

public class ConsumerReservationTO implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer conResId;
	private User user;
	private RestaurantDeal restaurantDeal;
	private String reservedTimestamp;
	private Short isConsumerShownUp;
	private String bookedTimestamp;
	private String source;
	private String businessName;
	private boolean expired;
	
	
  	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	
  	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	/** default constructor */
	public ConsumerReservationTO() {
		this.user = new User();
		this.restaurantDeal = new RestaurantDeal();
		
	}

	/** minimal constructor */
	public ConsumerReservationTO(User user, RestaurantDeal restaurantDeal, String reservedTimestamp) {
		this.user = user;
		this.restaurantDeal = restaurantDeal;
		this.reservedTimestamp = reservedTimestamp;
	}

	/** full constructor */
	public ConsumerReservationTO(User user, RestaurantDeal restaurantDeal,
			String reservedTimestamp, Short isConsumerShownUp) {
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

	public String getReservedTimestamp() {
		return this.reservedTimestamp;
	}

	public void setReservedTimestamp(String reservedTimestamp) {
		this.reservedTimestamp = reservedTimestamp;
	}

	public Short getIsConsumerShownUp() {
		return this.isConsumerShownUp;
	}

	public void setIsConsumerShownUp(Short isConsumerShownUp) {
		this.isConsumerShownUp = isConsumerShownUp;
	}

	public String getBookedTimestamp() {
		return this.bookedTimestamp;
	}

	public void setBookedTimestamp(String bookedTimestamp) {
		this.bookedTimestamp = bookedTimestamp;
	}

}