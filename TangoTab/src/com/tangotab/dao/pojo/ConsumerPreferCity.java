package com.tangotab.dao.pojo;

/**
 * ConsumerPreference entity. @author MyEclipse Persistence Tools
 */

public class ConsumerPreferCity implements java.io.Serializable {

	// Fields

	private Integer consumerPreferId;
	private User user;

	private City city;

	public Integer getConsumerPreferId() {
		return consumerPreferId;
	}

	public void setConsumerPreferId(Integer consumerPreferId) {
		this.consumerPreferId = consumerPreferId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public City getCity() {
		return city;
	}

}