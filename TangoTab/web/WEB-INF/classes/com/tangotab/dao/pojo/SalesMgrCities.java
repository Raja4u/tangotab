package com.tangotab.dao.pojo;

// default package

/**
 * SalesMgrCities entity. @author MyEclipse Persistence Tools
 */

public class SalesMgrCities implements java.io.Serializable {

	// Fields

	private Integer salesMgrCityId;
	private SalesManagerInfo salesManagerInfo;
	private City city;

	// Constructors

	/** default constructor */
	public SalesMgrCities() {
	}

	/** full constructor */
	public SalesMgrCities(SalesManagerInfo salesManagerInfo, City city) {
		this.salesManagerInfo = salesManagerInfo;
		this.city = city;
	}

	// Property accessors

	public Integer getSalesMgrCityId() {
		return this.salesMgrCityId;
	}

	public void setSalesMgrCityId(Integer salesMgrCityId) {
		this.salesMgrCityId = salesMgrCityId;
	}

	public SalesManagerInfo getSalesManagerInfo() {
		return this.salesManagerInfo;
	}

	public void setSalesManagerInfo(SalesManagerInfo salesManagerInfo) {
		this.salesManagerInfo = salesManagerInfo;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}