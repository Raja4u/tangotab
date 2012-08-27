package com.tangotab.dao.pojo;

import java.sql.Timestamp;

public class Support implements java.io.Serializable {

	private Integer supportId;
	private Integer roleId;
	private String subject;
	private String description;
	private String emailId;
	private Timestamp supportDate;
	private Integer status;

	public Support() {

	}

	public Support(Integer roleId, String subject, String description, String emailId) {
		super();
		this.roleId = roleId;
		this.subject = subject;
		this.description = description;
		this.emailId = emailId;

	}

	public Integer getSupportId() {
		return supportId;
	}

	public void setSupportId(Integer supportId) {
		this.supportId = supportId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getSupportDate() {
		return supportDate;
	}

	public void setSupportDate(Timestamp supportDate) {
		this.supportDate = supportDate;
	}

}
