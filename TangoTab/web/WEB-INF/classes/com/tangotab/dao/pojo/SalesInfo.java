package com.tangotab.dao.pojo;

import java.util.Date;

public class SalesInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer salesInfoId;
	private Date hireDate;
	private Date terminationDate;
	private SalesRepresentInfo salesRepresentInfos;
	private SalesManagerInfo salesManagerInfos;
	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getSalesInfoId() {
		return salesInfoId;
	}

	public void setSalesInfoId(Integer salesInfoId) {
		this.salesInfoId = salesInfoId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public SalesRepresentInfo getSalesRepresentInfos() {
		return salesRepresentInfos;
	}

	public void setSalesRepresentInfos(SalesRepresentInfo salesRepresentInfos) {
		this.salesRepresentInfos = salesRepresentInfos;
	}

	public SalesManagerInfo getSalesManagerInfos() {
		return salesManagerInfos;
	}

	public void setSalesManagerInfos(SalesManagerInfo salesManagerInfos) {
		this.salesManagerInfos = salesManagerInfos;
	}
}