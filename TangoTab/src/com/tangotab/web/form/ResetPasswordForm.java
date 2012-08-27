package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

public class ResetPasswordForm extends ValidatorForm implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6514511015632794480L;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private String emailId;
	private String password;
	private String newPassword;
	private String confirmPassword;
}
