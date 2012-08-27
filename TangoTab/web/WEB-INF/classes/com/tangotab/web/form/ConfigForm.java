package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class ConfigForm extends ValidatorForm {

	private Integer configId;
	private Double minChargeAmt;
	private Double defaultDealCreditValue;
	private Double defaultDiscountAmountOnAccount;
	private Double defaultSetupFee;
	private String discountFromDate;
	private String discountTODate;
	private Integer customizedDealCredit;
	private Integer creditUserDeal;
	private Short promotionCode;

	public Short getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(Short promotionCode) {
		this.promotionCode = promotionCode;
	}

	/**
	 * @return the configId
	 */
	public Integer getConfigId() {
		return configId;
	}

	/**
	 * @param configId
	 *            the configId to set
	 */
	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public Double getMinChargeAmt() {
		return minChargeAmt;
	}

	public void setMinChargeAmt(Double minChargeAmt) {
		this.minChargeAmt = minChargeAmt;
	}

	/**
	 * @return the defaultDealCreditValue
	 */
	public Double getDefaultDealCreditValue() {
		return defaultDealCreditValue;
	}

	/**
	 * @param defaultDealCreditValue
	 *            the defaultDealCreditValue to set
	 */
	public void setDefaultDealCreditValue(Double defaultDealCreditValue) {
		this.defaultDealCreditValue = defaultDealCreditValue;
	}

	/**
	 * @return the defaultDiscountAmountOnAccount
	 */
	public Double getDefaultDiscountAmountOnAccount() {
		return defaultDiscountAmountOnAccount;
	}

	/**
	 * @param defaultDiscountAmountOnAccount
	 *            the defaultDiscountAmountOnAccount to set
	 */
	public void setDefaultDiscountAmountOnAccount(Double defaultDiscountAmountOnAccount) {
		this.defaultDiscountAmountOnAccount = defaultDiscountAmountOnAccount;
	}

	/**
	 * @return the defaultSetupFee
	 */
	public Double getDefaultSetupFee() {
		return defaultSetupFee;
	}

	/**
	 * @param defaultSetupFee
	 *            the defaultSetupFee to set
	 */
	public void setDefaultSetupFee(Double defaultSetupFee) {
		this.defaultSetupFee = defaultSetupFee;
	}

	/**
	 * @return the discountFromDate
	 */
	public String getDiscountFromDate() {
		return discountFromDate;
	}

	/**
	 * @param discountFromDate
	 *            the discountFromDate to set
	 */
	public void setDiscountFromDate(String discountFromDate) {
		this.discountFromDate = discountFromDate;
	}

	/**
	 * @return the discountTODate
	 */
	public String getDiscountTODate() {
		return discountTODate;
	}

	/**
	 * @param discountTODate
	 *            the discountTODate to set
	 */
	public void setDiscountTODate(String discountTODate) {
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
