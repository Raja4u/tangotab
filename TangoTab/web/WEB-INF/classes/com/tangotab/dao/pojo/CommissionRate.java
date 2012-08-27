package com.tangotab.dao.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CommissionRate entity. @author MyEclipse Persistence Tools
 */

public class CommissionRate implements java.io.Serializable {

	// Fields

	private Integer commissionRateId;
	private Double flatCommissionAmount;
	private Double percentOnNewSale;
	private Double personOnRenewalSale;
	private Timestamp startDate;
	private Timestamp endDate;
	private Set salesCommissions = new HashSet(0);
	private Double commissionManager;

	// Constructors

	/**
	 * @return the commissionManager
	 */
	public Double getCommissionManager() {
		return commissionManager;
	}

	/**
	 * @param commissionManager
	 *            the commissionManager to set
	 */
	public void setCommissionManager(Double commissionManager) {
		this.commissionManager = commissionManager;
	}

	/** default constructor */
	public CommissionRate() {
	}

	/** minimal constructor */
	public CommissionRate(Double flatCommissionAmount, Double percentOnNewSale,
			Double personOnRenewalSale, Timestamp startDate) {
		this.flatCommissionAmount = flatCommissionAmount;
		this.percentOnNewSale = percentOnNewSale;
		this.personOnRenewalSale = personOnRenewalSale;
		this.startDate = startDate;
	}

	/** full constructor */
	public CommissionRate(Double flatCommissionAmount, Double percentOnNewSale,
			Double personOnRenewalSale, Timestamp startDate, Timestamp endDate, Set salesCommissions) {
		this.flatCommissionAmount = flatCommissionAmount;
		this.percentOnNewSale = percentOnNewSale;
		this.personOnRenewalSale = personOnRenewalSale;
		this.startDate = startDate;
		this.endDate = endDate;
		this.salesCommissions = salesCommissions;
	}

	// Property accessors

	public Integer getCommissionRateId() {
		return this.commissionRateId;
	}

	public void setCommissionRateId(Integer commissionRateId) {
		this.commissionRateId = commissionRateId;
	}

	public Double getFlatCommissionAmount() {
		return this.flatCommissionAmount;
	}

	public void setFlatCommissionAmount(Double flatCommissionAmount) {
		this.flatCommissionAmount = flatCommissionAmount;
	}

	public Double getPercentOnNewSale() {
		return this.percentOnNewSale;
	}

	public void setPercentOnNewSale(Double percentOnNewSale) {
		this.percentOnNewSale = percentOnNewSale;
	}

	public Double getPersonOnRenewalSale() {
		return this.personOnRenewalSale;
	}

	public void setPersonOnRenewalSale(Double personOnRenewalSale) {
		this.personOnRenewalSale = personOnRenewalSale;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Set getSalesCommissions() {
		return this.salesCommissions;
	}

	public void setSalesCommissions(Set salesCommissions) {
		this.salesCommissions = salesCommissions;
	}

}