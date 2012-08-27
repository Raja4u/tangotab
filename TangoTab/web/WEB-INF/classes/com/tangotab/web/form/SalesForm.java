/**
 * 
 */
package com.tangotab.web.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * @author user1
 * 
 */
public class SalesForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long salesPersonId;
	private String firstName;
	private String lastName;
	private String homeAddress;
	private String homePhone;
	private String mobileNo;
	private String emailId;
	private int uniqueId;
	private String positionType;
	private String salesManagerAssigned;
	private String zipCodeAssigned;
	private String areaAssigned;
	private String hireDate;
	private String terminationDate;

	/**
	 * @return the salesPersonId
	 */
	public long getSalesPersonId() {
		return salesPersonId;
	}

	/**
	 * @param salesPersonId
	 *            the salesPersonId to set
	 */
	public void setSalesPersonId(long salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress
	 *            the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the uniqueId
	 */
	public int getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId
	 *            the uniqueId to set
	 */
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return the positionType
	 */
	public String getPositionType() {
		return positionType;
	}

	/**
	 * @param positionType
	 *            the positionType to set
	 */
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	/**
	 * @return the salesManagerAssigned
	 */
	public String getSalesManagerAssigned() {
		return salesManagerAssigned;
	}

	/**
	 * @param salesManagerAssigned
	 *            the salesManagerAssigned to set
	 */
	public void setSalesManagerAssigned(String salesManagerAssigned) {
		this.salesManagerAssigned = salesManagerAssigned;
	}

	/**
	 * @return the zipCodeAssigned
	 */
	public String getZipCodeAssigned() {
		return zipCodeAssigned;
	}

	/**
	 * @param zipCodeAssigned
	 *            the zipCodeAssigned to set
	 */
	public void setZipCodeAssigned(String zipCodeAssigned) {
		this.zipCodeAssigned = zipCodeAssigned;
	}

	/**
	 * @return the areaAssigned
	 */
	public String getAreaAssigned() {
		return areaAssigned;
	}

	/**
	 * @param areaAssigned
	 *            the areaAssigned to set
	 */
	public void setAreaAssigned(String areaAssigned) {
		this.areaAssigned = areaAssigned;
	}

	/**
	 * @return the hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return the terminationDate
	 */
	public String getTerminationDate() {
		return terminationDate;
	}

	/**
	 * @param terminationDate
	 *            the terminationDate to set
	 */
	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}

}
