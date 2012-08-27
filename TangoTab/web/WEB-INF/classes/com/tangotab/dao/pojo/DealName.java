package com.tangotab.dao.pojo;

import java.util.HashSet;
import java.util.Set;

public class DealName implements java.io.Serializable {

	private Short isActive;
	private Integer nameId;
	private String name;
	private Set dealDescriptions = new HashSet(0);

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getDealDescriptions() {
		return this.dealDescriptions;
	}

	public void setDealDescriptions(Set dealDescriptions) {
		this.dealDescriptions = dealDescriptions;
	}

}
