package com.tangotab.TO;


public class SupportTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer supportId;
	private Integer roleId;
	private String rolename;
	private String subject;
	private String description;
	private String emailId;
	private String supportDate;
	private Integer status;

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

	public String getSupportDate() {
		return supportDate;
	}

	public void setSupportDate(String supportDate) {
		this.supportDate = supportDate;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
