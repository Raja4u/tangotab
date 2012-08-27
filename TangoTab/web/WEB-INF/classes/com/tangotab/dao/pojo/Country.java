package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Country entity. @author MyEclipse Persistence Tools
 */

public class Country implements java.io.Serializable {

	// Fields

	private Integer countryId;
	private String countryName;
	private String countryCode;
	private Set<State> states = new HashSet<State>(0);

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** minimal constructor */
	public Country(String countryName, String countryCode) {
		this.countryName = countryName;
		this.countryCode = countryCode;
	}

	/** full constructor */
	public Country(String countryName, String countryCode, Set states) {
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.setStates(states);
	}

	// Property accessors

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	public Set<State> getStates() {
		return states;
	}

}