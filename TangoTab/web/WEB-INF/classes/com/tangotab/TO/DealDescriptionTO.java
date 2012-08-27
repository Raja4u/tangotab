package com.tangotab.TO;

public class DealDescriptionTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer descriptionId;
	private String description;

	/** full constructor */

	public Integer getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(Integer descriptionId) {
		this.descriptionId = descriptionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
