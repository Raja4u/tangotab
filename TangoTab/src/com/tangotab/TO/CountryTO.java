package com.tangotab.TO;

import java.util.HashSet;
import java.util.Set;

import com.tangotab.dao.pojo.State;

public class CountryTO {
	private Integer countryId;
	private String countryName;
	private String countryCode;
	private Set<State> states = new HashSet<State>(0);

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
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
