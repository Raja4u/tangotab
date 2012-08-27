package com.tangotab.web.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class CharityForm extends ValidatorForm {
	
	private Date charityTime;
	private Integer totalCount;
	public Date getCharityTime() {
		return charityTime;
	}
	public void setCharityTime(Date charityTime) {
		this.charityTime = charityTime;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
