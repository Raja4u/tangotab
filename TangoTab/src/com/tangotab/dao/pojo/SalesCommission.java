package com.tangotab.dao.pojo;

/**
 * SalesCommission entity. @author MyEclipse Persistence Tools
 */

public class SalesCommission implements java.io.Serializable {

	// Fields

	private Integer salesCommissionId;
	private CommissionRate commissionRate;
	private Integer salesPersonId;
	private Short isNewSale;
	private Short isRenewalSale;
	private Double flatCommissionRate;

	// Constructors

	/** default constructor */
	public SalesCommission() {
	}

	/** full constructor */
	public SalesCommission(Integer salesCommissionId, CommissionRate commissionRate,
			Integer salesPersonId, Short isNewSale, Short isRenewalSale, Double flatCommissionRate) {
		this.salesCommissionId = salesCommissionId;
		this.commissionRate = commissionRate;
		this.salesPersonId = salesPersonId;
		this.isNewSale = isNewSale;
		this.isRenewalSale = isRenewalSale;
		this.flatCommissionRate = flatCommissionRate;
	}

	// Property accessors

	public Integer getSalesCommissionId() {
		return this.salesCommissionId;
	}

	public void setSalesCommissionId(Integer salesCommissionId) {
		this.salesCommissionId = salesCommissionId;
	}

	public CommissionRate getCommissionRate() {
		return this.commissionRate;
	}

	public void setCommissionRate(CommissionRate commissionRate) {
		this.commissionRate = commissionRate;
	}

	public Integer getSalesPersonId() {
		return this.salesPersonId;
	}

	public void setSalesPersonId(Integer salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	public Short getIsNewSale() {
		return this.isNewSale;
	}

	public void setIsNewSale(Short isNewSale) {
		this.isNewSale = isNewSale;
	}

	public Short getIsRenewalSale() {
		return this.isRenewalSale;
	}

	public void setIsRenewalSale(Short isRenewalSale) {
		this.isRenewalSale = isRenewalSale;
	}

	public Double getFlatCommissionRate() {
		return this.flatCommissionRate;
	}

	public void setFlatCommissionRate(Double flatCommissionRate) {
		this.flatCommissionRate = flatCommissionRate;
	}

}