package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * ZipCode entity. @author MyEclipse Persistence Tools
 */

public class ZipCode implements java.io.Serializable {

	// Fields

	private String zipCode;
	private City city;
	private String areaCode;
	private Set salesZipCodes = new HashSet(0);

	// Constructors

	/** default constructor */
	public ZipCode() {
	}

	/** minimal constructor */
	public ZipCode(String zipCode, City city) {
		this.zipCode = zipCode;
		this.city = city;
	}

	/** full constructor */
	public ZipCode(String zipCode, City city, String areaCode, Set salesZipCodes) {
		this.zipCode = zipCode;
		this.city = city;
		this.areaCode = areaCode;
		this.salesZipCodes = salesZipCodes;
	}

	// Property accessors

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Set getSalesZipCodes() {
		return this.salesZipCodes;
	}

	public void setSalesZipCodes(Set salesZipCodes) {
		this.salesZipCodes = salesZipCodes;
	}

}