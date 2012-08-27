package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * State entity. @author MyEclipse Persistence Tools
 */

public class State implements java.io.Serializable {

	// Fields

	private Integer stateId;
	private Country country;
	private String stateName;
	private String stateCode;
	private Set cities = new HashSet(0);
	private Integer isActive;

	// Constructors

	/** default constructor */
	public State() {
	}

	/** minimal constructor */
	public State(Country country, String stateName, String stateCode) {
		this.country = country;
		this.stateName = stateName;
		this.stateCode = stateCode;
	}

	/** full constructor */
	public State(Country country, String stateName, String stateCode, Set cities) {
		this.country = country;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.cities = cities;
	}

	// Property accessors

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsActive() {
		return isActive;
	}

}