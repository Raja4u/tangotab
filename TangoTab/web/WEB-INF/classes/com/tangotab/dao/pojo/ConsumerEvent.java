package com.tangotab.dao.pojo;

/**
 * ConsumerEvent entity. @author MyEclipse Persistence Tools
 */

public class ConsumerEvent implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer consumerEventId;
	private Events events;
	private User user;

	  
	public Integer getConsumerEventId() {
		return this.consumerEventId;
	}

	public void setConsumerEventId(Integer consumerEventId) {
		this.consumerEventId = consumerEventId;
	}

	public Events getEvents() {
		return this.events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}