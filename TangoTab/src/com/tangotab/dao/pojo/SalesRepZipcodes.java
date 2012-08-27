package com.tangotab.dao.pojo;

public class SalesRepZipcodes implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer salesRepZipCode;
	private SalesRepresentInfo salesRepresentInfo;
	private ZipCode zipCode;

	public Integer getSalesRepZipCode() {
		return salesRepZipCode;
	}

	public void setSalesRepZipCode(Integer salesRepZipCode) {
		this.salesRepZipCode = salesRepZipCode;
	}

	public SalesRepresentInfo getSalesRepresentInfo() {
		return salesRepresentInfo;
	}

	public void setSalesRepresentInfo(SalesRepresentInfo salesRepresentInfo) {
		this.salesRepresentInfo = salesRepresentInfo;
	}

	public ZipCode getZipCode() {
		return zipCode;
	}

	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}

}