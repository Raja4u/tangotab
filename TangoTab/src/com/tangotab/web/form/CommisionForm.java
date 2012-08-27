package com.tangotab.web.form;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts.validator.ValidatorForm;

public class CommisionForm extends ValidatorForm {
	private Integer commissionRateId;
	private Double flatCommissionAmount;
	private Double percentOnNewSale;
	private Double personOnRenewalSale;
	private Timestamp startDate;
	private Timestamp endDate;
	private Set salesCommissions = new HashSet(0);

	/**
	 * @return the commissionRateId
	 */
	public Integer getCommissionRateId() {
		return commissionRateId;
	}

	/**
	 * @param commissionRateId
	 *            the commissionRateId to set
	 */
	public void setCommissionRateId(Integer commissionRateId) {
		this.commissionRateId = commissionRateId;
	}

	/**
	 * @return the flatCommissionAmount
	 */
	public Double getFlatCommissionAmount() {
		return flatCommissionAmount;
	}

	/**
	 * @param flatCommissionAmount
	 *            the flatCommissionAmount to set
	 */
	public void setFlatCommissionAmount(Double flatCommissionAmount) {
		this.flatCommissionAmount = flatCommissionAmount;
	}

	/**
	 * @return the percentOnNewSale
	 */
	public Double getPercentOnNewSale() {
		return percentOnNewSale;
	}

	/**
	 * @param percentOnNewSale
	 *            the percentOnNewSale to set
	 */
	public void setPercentOnNewSale(Double percentOnNewSale) {
		this.percentOnNewSale = percentOnNewSale;
	}

	/**
	 * @return the personOnRenewalSale
	 */
	public Double getPersonOnRenewalSale() {
		return personOnRenewalSale;
	}

	/**
	 * @param personOnRenewalSale
	 *            the personOnRenewalSale to set
	 */
	public void setPersonOnRenewalSale(Double personOnRenewalSale) {
		this.personOnRenewalSale = personOnRenewalSale;
	}

	/**
	 * @return the endDate
	 */
	public Timestamp getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the salesCommissions
	 */
	public Set getSalesCommissions() {
		return salesCommissions;
	}

	/**
	 * @param salesCommissions
	 *            the salesCommissions to set
	 */
	public void setSalesCommissions(Set salesCommissions) {
		this.salesCommissions = salesCommissions;
	}

}
