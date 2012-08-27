package com.tangotab.dao.pojo;

import java.sql.Timestamp;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */

public class ConfigPojo implements java.io.Serializable {

	// Fields

	private Integer configId;
	private Double minChargeAmt;
	private Double defaultDealCreditValue;
	private Double defaultDiscountAmountOnAccount;
	private Double defaultSetupFee;
	private Timestamp discountFromDate;
	private Timestamp discountTODate;
	private Integer customizedDealCredit;
	private Integer creditUserDeal;
	private Short promotionCode;

	public Short getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(Short promotionCode) {
		this.promotionCode = promotionCode;
	}

	// Constructors

	/** default constructor */
	public ConfigPojo() {
	}

	/** full constructor */
	public ConfigPojo(Integer oneUnit, Double defaultDealCreditValue,
			Double defaultDiscountAmountOnAccount, Double defaultSetupFee,
			Timestamp discountFromDate, Timestamp discountToDate, Integer customizedDealCredit,
			Integer creditUserDeal, Short promotionCode) {
		this.minChargeAmt = minChargeAmt;
		this.defaultDealCreditValue = defaultDealCreditValue;
		this.defaultDiscountAmountOnAccount = defaultDiscountAmountOnAccount;
		this.defaultSetupFee = defaultSetupFee;
		this.discountFromDate = discountFromDate;
		this.discountTODate = discountToDate;
		this.customizedDealCredit = customizedDealCredit;
		this.creditUserDeal = creditUserDeal;
		this.promotionCode = promotionCode;
	}

	// Property accessors

	public Integer getConfigId() {
		return this.configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public Double getDefaultDealCreditValue() {
		return this.defaultDealCreditValue;
	}

	public void setDefaultDealCreditValue(Double defaultDealCreditValue) {
		this.defaultDealCreditValue = defaultDealCreditValue;
	}

	public Double getDefaultDiscountAmountOnAccount() {
		return this.defaultDiscountAmountOnAccount;
	}

	public void setDefaultDiscountAmountOnAccount(Double defaultDiscountAmountOnAccount) {
		this.defaultDiscountAmountOnAccount = defaultDiscountAmountOnAccount;
	}

	public Double getDefaultSetupFee() {
		return this.defaultSetupFee;
	}

	public void setDefaultSetupFee(Double defaultSetupFee) {
		this.defaultSetupFee = defaultSetupFee;
	}

	/**
	 * @return the minChargeAmt
	 */
	public Double getMinChargeAmt() {
		return minChargeAmt;
	}

	public void setMinChargeAmt(Double minChargeAmt) {
		this.minChargeAmt = minChargeAmt;
	}

	/**
	 * @return the discountFromDate
	 */
	public Timestamp getDiscountFromDate() {
		return discountFromDate;
	}

	/**
	 * @param discountFromDate
	 *            the discountFromDate to set
	 */
	public void setDiscountFromDate(Timestamp discountFromDate) {
		this.discountFromDate = discountFromDate;
	}

	/**
	 * @return the discountTODate
	 */
	public Timestamp getDiscountTODate() {
		return discountTODate;
	}

	/**
	 * @param discountTODate
	 *            the discountTODate to set
	 */
	public void setDiscountTODate(Timestamp discountTODate) {
		this.discountTODate = discountTODate;
	}

	/**
	 * @return the customizedDealCredit
	 */
	public Integer getCustomizedDealCredit() {
		return customizedDealCredit;
	}

	/**
	 * @param customizedDealCredit
	 *            the customizedDealCredit to set
	 */
	public void setCustomizedDealCredit(Integer customizedDealCredit) {
		this.customizedDealCredit = customizedDealCredit;
	}

	/**
	 * @return the creditUserDeal
	 */
	public Integer getCreditUserDeal() {
		return creditUserDeal;
	}

	/**
	 * @param creditUserDeal
	 *            the creditUserDeal to set
	 */
	public void setCreditUserDeal(Integer creditUserDeal) {
		this.creditUserDeal = creditUserDeal;
	}

}