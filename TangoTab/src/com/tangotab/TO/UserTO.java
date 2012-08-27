package com.tangotab.TO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.tangotab.dao.pojo.ConsumerEvent;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.ConsumerReferral;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.Role;
import com.tangotab.dao.pojo.User;

public class UserTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private User user;
	private Role role;
	private String emailId;
	private String password;
	private Short isActive;
	private String firstname;
	private String lastname;
	private String address;
	private String address1;
	private String gender;
	private int age;
	private String mobilePhone;
	private String homePhone;
	private String zipCode;
	private int countryId;
	private int stateId;
	private int roleId;
	private String cityId;
	private int[] preferencesList;
	private String confirmPassword;
	private String businessName;
	private Integer noOfLocations;
	private Double currentCredits;
	private Integer billingMethodId;
	private Integer restTypeId;
	private Integer billingTypeId;
	private String accountManagerName;
	private String submit;
	private Integer restaurantId;
	private Short isPwdChange;
	private int noOfEnteredLocatios;
	private RestaurantLocation restaurantLocation;
	private Restaurant restaurent;
	private Set restaurantLocations = new HashSet(0);
	private Set<ConsumerEvent> consumerEvent = new HashSet<ConsumerEvent>();
	private Set<ConsumerReferral> consumerReferrals = new HashSet<ConsumerReferral>();
	
	private Integer refferCode;
	private String fax;

	private String srepName;
	private String srepEmail;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private ConsumerPreferCity consumerPreferCity;
	private Timestamp userCreateDate;
	private int eventId;
	private String alternateHosts;
	private String[] emailIdArray;
	private String[] nameArray;
	private Short isAutoDebit;
	private String refferedUrl;
	
	private String businessTitle;    
	
	public String getBusinessTitle() {
		return businessTitle;
	}
	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}	
	public Short getIsAutoDebit() {
		return isAutoDebit;
	}
	public void setIsAutoDebit(Short isAutoDebit) {
		this.isAutoDebit = isAutoDebit;
	}
	public String[] getEmailIdArray() {
		return emailIdArray;
	}
	public void setEmailIdArray(String[] emailIdArray) {
		this.emailIdArray = emailIdArray;
	}
	public String[] getNameArray() {
		return nameArray;
	}
	public void setNameArray(String[] nameArray) {
		this.nameArray = nameArray;
	}
	
	
	public String getAlternateHosts() {
		return alternateHosts;
	}

	public void setAlternateHosts(String alternateHosts) {
		this.alternateHosts = alternateHosts;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getSrepName() {
		return srepName;
	}

	public void setSrepName(String srepName) {
		this.srepName = srepName;
	}

	public String getSrepEmail() {
		return srepEmail;
	}

	public void setSrepEmail(String srepEmail) {
		this.srepEmail = srepEmail;
	}

	public int getNoOfEnteredLocatios() {
		return noOfEnteredLocatios;
	}

	public void setNoOfEnteredLocatios(int noOfEnteredLocatios) {
		this.noOfEnteredLocatios = noOfEnteredLocatios;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Integer getNoOfLocations() {
		return noOfLocations;
	}

	public void setNoOfLocations(Integer noOfLocations) {
		this.noOfLocations = noOfLocations;
	}

	public Double getCurrentCredits() {
		return currentCredits;
	}

	public void setCurrentCredits(Double currentCredits) {
		this.currentCredits = currentCredits;
	}

	public Integer getBillingMethodId() {
		return billingMethodId;
	}

	public void setBillingMethodId(Integer billingMethodId) {
		this.billingMethodId = billingMethodId;
	}

	public Integer getRestTypeId() {
		return restTypeId;
	}

	public void setRestTypeId(Integer restTypeId) {
		this.restTypeId = restTypeId;
	}

	public Integer getBillingTypeId() {
		return billingTypeId;
	}

	public void setBillingTypeId(Integer billingTypeId) {
		this.billingTypeId = billingTypeId;
	}

	public String getAccountManagerName() {
		return accountManagerName;
	}

	public void setAccountManagerName(String accountManagerName) {
		this.accountManagerName = accountManagerName;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int[] getPreferencesList() {
		return preferencesList;
	}

	public void setPreferencesList(int[] preferencesList) {
		this.preferencesList = preferencesList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Short getIsActive() {
		return isActive;
	}

	public void setIsActive(Short isActive) {
		this.isActive = isActive;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public void setRestaurantLocation(RestaurantLocation restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public RestaurantLocation getRestaurantLocation() {
		return restaurantLocation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setRestaurent(Restaurant restaurent) {
		this.restaurent = restaurent;
	}

	public Restaurant getRestaurent() {
		return restaurent;
	}

	public Short getIsPwdChange() {
		return isPwdChange;
	}

	public void setIsPwdChange(Short isPwdChange) {
		this.isPwdChange = isPwdChange;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress1() {
		return address1;
	}

	public Set getRestaurantLocations() {
		return restaurantLocations;
	}

	public void setRestaurantLocations(Set restaurantLocations) {
		this.restaurantLocations = restaurantLocations;
	}

	public void setRefferCode(Integer refferCode) {
		this.refferCode = refferCode;
	}

	public Integer getRefferCode() {
		return refferCode;
	}

	public void setConsumerPreferCity(ConsumerPreferCity consumerPreferCity) {
		this.consumerPreferCity = consumerPreferCity;
	}

	public ConsumerPreferCity getConsumerPreferCity() {
		return consumerPreferCity;
	}

	public void setUserCreateDate(Timestamp userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

	public Timestamp getUserCreateDate() {
		return userCreateDate;
	}

	public Set<ConsumerEvent> getConsumerEvent() {
		return consumerEvent;
	}

	public void setConsumerEvent(Set<ConsumerEvent> eventSet) {
		this.consumerEvent = eventSet;
	}
	
	public Set<ConsumerReferral> getConsumerReferrals() {
		return consumerReferrals;
	}

	public void setConsumerReferrals(Set<ConsumerReferral> consumerReferrals) {
		this.consumerReferrals = consumerReferrals;
	}
	/**
	 * @param refferedUrl the refferedUrl to set
	 */
	public void setRefferedUrl(String refferedUrl) {
		this.refferedUrl = refferedUrl;
	}
	/**
	 * @return the refferedUrl
	 */
	public String getRefferedUrl() {
		return refferedUrl;
	}
	
}
