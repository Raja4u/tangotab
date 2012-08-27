package com.tangotab.dao.pojo;

/**
 * DiningStyle entity. @author MyEclipse Persistence Tools
 */

public class DiningStyle implements java.io.Serializable {

	// Fields

	private Integer diningStyleId;
	private String diningStyleName;
	private Integer isActive;

	// Constructors

	/**
	 * @return the isActive
	 */
	public Integer getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	/** default constructor */
	public DiningStyle() {
	}

	/** full constructor */
	public DiningStyle(String diningStyleName) {
		this.diningStyleName = diningStyleName;
	}

	// Property accessors

	public Integer getDiningStyleId() {
		return this.diningStyleId;
	}

	public void setDiningStyleId(Integer diningStyleId) {
		this.diningStyleId = diningStyleId;
	}

	public String getDiningStyleName() {
		return this.diningStyleName;
	}

	public void setDiningStyleName(String diningStyleName) {
		this.diningStyleName = diningStyleName;
	}

}