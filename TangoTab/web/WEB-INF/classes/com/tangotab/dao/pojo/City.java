package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private State state;
	private String cityName;
	private String cityCode;
	private Set zipCodes = new HashSet(0);
	private Integer isActive;
	private Double longitude;
	private Double latitude;
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	
	

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(State state, String cityName, String cityCode) {
		this.state = state;
		this.cityName = cityName;
		this.cityCode = cityCode;
	}

	/** full constructor */
	public City(State state, String cityName, String cityCode, Set zipCodes) {
		this.state = state;
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.zipCodes = zipCodes;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Set getZipCodes() {
		return this.zipCodes;
	}

	public void setZipCodes(Set zipCodes) {
		this.zipCodes = zipCodes;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsActive() {
		return isActive;
	}

}