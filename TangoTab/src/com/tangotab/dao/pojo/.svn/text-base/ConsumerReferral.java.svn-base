package com.tangotab.dao.pojo;

import java.sql.Timestamp;

/**
 * ConsumerReferral entity. @author MyEclipse Persistence Tools
 */

public class ConsumerReferral implements java.io.Serializable {

	// Fields

	private Integer consumerReferralId;
	private User user;
	private String friendName;
	private String friendEmailId;
	private Timestamp referredOn;
	private Short isFriendRegistered;

	// Constructors

	/** default constructor */
	public ConsumerReferral() {
	}

	/** minimal constructor */
	public ConsumerReferral(User user, String friendEmailId, Timestamp referredOn) {
		this.user = user;
		this.friendEmailId = friendEmailId;
		this.referredOn = referredOn;
	}

	/** full constructor */
	public ConsumerReferral(User user, String friendName, String friendEmailId,
			Timestamp referredOn, Short isFriendRegistered) {
		this.user = user;
		this.friendName = friendName;
		this.friendEmailId = friendEmailId;
		this.referredOn = referredOn;
		this.isFriendRegistered = isFriendRegistered;
	}

	// Property accessors

	public Integer getConsumerReferralId() {
		return this.consumerReferralId;
	}

	public void setConsumerReferralId(Integer consumerReferralId) {
		this.consumerReferralId = consumerReferralId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFriendName() {
		return this.friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendEmailId() {
		return this.friendEmailId;
	}

	public void setFriendEmailId(String friendEmailId) {
		this.friendEmailId = friendEmailId;
	}

	public Timestamp getReferredOn() {
		return this.referredOn;
	}

	public void setReferredOn(Timestamp referredOn) {
		this.referredOn = referredOn;
	}

	public Short getIsFriendRegistered() {
		return this.isFriendRegistered;
	}

	public void setIsFriendRegistered(Short isFriendRegistered) {
		this.isFriendRegistered = isFriendRegistered;
	}

}