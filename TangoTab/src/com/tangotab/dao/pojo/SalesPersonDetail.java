package com.tangotab.dao.pojo;

import java.sql.Timestamp;

/**
 * SalesPersonDetail entity. @author MyEclipse Persistence Tools
 */

public class SalesPersonDetail implements java.io.Serializable {

	// Fields

	private Integer salesPersonDetailsId;
	private User user;
	private Timestamp joinDate;
	private Timestamp endDate;
	private String positionType;
	private String areaAssigned;
	private String trackCode;

	// Constructors

	/** default constructor */
	public SalesPersonDetail() {
	}

	/** minimal constructor */
	public SalesPersonDetail(Integer salesPersonDetailsId, User user, Timestamp joinDate,
			String trackCode) {
		this.salesPersonDetailsId = salesPersonDetailsId;
		this.user = user;
		this.joinDate = joinDate;
		this.trackCode = trackCode;
	}

	/** full constructor */
	public SalesPersonDetail(Integer salesPersonDetailsId, User user, Timestamp joinDate,
			Timestamp endDate, String positionType, String areaAssigned, String trackCode) {
		this.salesPersonDetailsId = salesPersonDetailsId;
		this.user = user;
		this.joinDate = joinDate;
		this.endDate = endDate;
		this.positionType = positionType;
		this.areaAssigned = areaAssigned;
		this.trackCode = trackCode;
	}

	// Property accessors

	public Integer getSalesPersonDetailsId() {
		return this.salesPersonDetailsId;
	}

	public void setSalesPersonDetailsId(Integer salesPersonDetailsId) {
		this.salesPersonDetailsId = salesPersonDetailsId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getPositionType() {
		return this.positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getAreaAssigned() {
		return this.areaAssigned;
	}

	public void setAreaAssigned(String areaAssigned) {
		this.areaAssigned = areaAssigned;
	}

	public String getTrackCode() {
		return this.trackCode;
	}

	public void setTrackCode(String trackCode) {
		this.trackCode = trackCode;
	}

}