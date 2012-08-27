package com.tangotab.dao.pojo;

import java.security.Timestamp;

public class ExternalReferral implements java.io.Serializable {
	private Integer referralId;
	private  String referralEmailId;
	private String referralName;
	private String friendEmailId;
	private Timestamp referredOn;
	
	public String getReferralName() {
		return referralName;
	}
	public void setReferralName(String referralName) {
		this.referralName = referralName;
	}
	public Integer getReferralId() {
		return referralId;
	}
	public void setReferralId(Integer referralId) {
		this.referralId = referralId;
	}
	public String getReferralEmailId() {
		return referralEmailId;
	}
	public void setReferralEmailId(String referralEmailId) {
		this.referralEmailId = referralEmailId;
	}
	public String getFriendEmailId() {
		return friendEmailId;
	}
	public void setFriendEmailId(String friendEmailId) {
		this.friendEmailId = friendEmailId;
	}
	public Timestamp getReferredOn() {
		return referredOn;
	}
	public void setReferredOn(Timestamp referredOn) {
		this.referredOn = referredOn;
	}

	
}
