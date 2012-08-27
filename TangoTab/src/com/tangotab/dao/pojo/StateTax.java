package com.tangotab.dao.pojo;

/**
 * StateTax entity. @author MyEclipse Persistence Tools
 */

public class StateTax implements java.io.Serializable {

	// Fields

	private Integer stateTaxId;
	private Short salesTaxPercent;
	private Integer stateId;
	private Short isActive;
	private String description;

	// Constructors

	/** default constructor */
	public StateTax() {
	}

	/** full constructor */
	public StateTax(Integer stateTaxId, Short salesTaxPercent, Integer stateId, Short isActive,
			String description) {
		this.stateTaxId = stateTaxId;
		this.salesTaxPercent = salesTaxPercent;
		this.stateId = stateId;
		this.isActive = isActive;
		this.description = description;
	}

	// Property accessors

	public Integer getStateTaxId() {
		return this.stateTaxId;
	}

	public void setStateTaxId(Integer stateTaxId) {
		this.stateTaxId = stateTaxId;
	}

	public Short getSalesTaxPercent() {
		return this.salesTaxPercent;
	}

	public void setSalesTaxPercent(Short salesTaxPercent) {
		this.salesTaxPercent = salesTaxPercent;
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Short getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}