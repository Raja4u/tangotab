package com.tangotab.creditcard.cim;

/*
 * Before working with this sample code, please be sure to read the accompanying Readme.txt file.
 * It contains important information regarding the appropriate use of and conditions for this sample
 * code. Also, please pay particular attention to the comments included in each individual code file,
 * as they will assist you in the unique and correct implementation of this code on your specific platform.
 *
 * Copyright 2008 Authorize.Net Corp.
 */

//import java.net.MalformedURLException;
//import java.net.URL;
import AuthNet.Rebill.ArrayOfCustomerAddressType;
import AuthNet.Rebill.ArrayOfCustomerPaymentProfileType;
import AuthNet.Rebill.CreateCustomerPaymentProfileResponseType;
import AuthNet.Rebill.CreateCustomerProfileResponseType;
import AuthNet.Rebill.CreditCardType;
import AuthNet.Rebill.CustomerAddressExType;
import AuthNet.Rebill.CustomerAddressType;
import AuthNet.Rebill.CustomerPaymentProfileType;
import AuthNet.Rebill.CustomerProfileType;
import AuthNet.Rebill.PaymentType;
import AuthNet.Rebill.ServiceSoap;
import AuthNet.Rebill.ValidationModeEnum;

import com.tangotab.web.form.CreditCardInfo;

public class CreateProfiles {

	public CreateCustomerProfileResponseType createNewProfile(CreditCardInfo creditCardInfo) {
		ServiceSoap soap = SoapAPIUtilities.getServiceSoap();
		PaymentType new_payment = new PaymentType();

		/*
		 * bank account create BankAccountType new_bank = new BankAccountType();
		 * new_bank.setAccountNumber("4111111");
		 */
		CustomerProfileType m_new_cust = new CustomerProfileType();
		m_new_cust.setEmail(creditCardInfo.getEmail());
		// add to restarant email id
		m_new_cust.setDescription(" " + creditCardInfo.getRestName());
		m_new_cust.setMerchantCustomerId(Integer.toString(creditCardInfo.getRestId()));
		// m_new_cust.setDescription(" " + Long.toString(System.currentTimeMillis()));

		CreditCardType new_card = new CreditCardType();
		new_card.setCardNumber(creditCardInfo.getCardNumber());

		new_card.setCardCode(creditCardInfo.getVerificationCode());

		try {
			javax.xml.datatype.XMLGregorianCalendar cal = javax.xml.datatype.DatatypeFactory
					.newInstance().newXMLGregorianCalendar();
			cal.setMonth(Integer.parseInt(creditCardInfo.getExpiryMonth()));
			cal.setYear(Integer.parseInt(creditCardInfo.getExpiryYear()));
			new_card.setExpirationDate(cal);
			//	 
		} catch (javax.xml.datatype.DatatypeConfigurationException dce) {
			//	
		}

		new_payment.setCreditCard(new_card);

		CustomerPaymentProfileType new_payment_profile = new CustomerPaymentProfileType();
		new_payment_profile.setPayment(new_payment);

		ArrayOfCustomerAddressType arrayOfCustomerAddressType = new ArrayOfCustomerAddressType();

		CustomerAddressType customerAddressType = constructCustomerAddress(creditCardInfo);

		arrayOfCustomerAddressType.getCustomerAddressType().add(customerAddressType);
		m_new_cust.setShipToList(arrayOfCustomerAddressType);
		ArrayOfCustomerPaymentProfileType arrayOfCustomerPaymentProfileType = new ArrayOfCustomerPaymentProfileType();
		new_payment_profile.setBillTo(customerAddressType);

		arrayOfCustomerPaymentProfileType.getCustomerPaymentProfileType().add(new_payment_profile);

		m_new_cust.setPaymentProfiles(arrayOfCustomerPaymentProfileType);

		m_new_cust.setShipToList(arrayOfCustomerAddressType);
		// createCustomerProfile.setProfile(m_new_cust);

		CreateCustomerProfileResponseType response = soap.createCustomerProfile(SoapAPIUtilities
				.getMerchantAuthentication(), m_new_cust, ValidationModeEnum.LIVE_MODE);

		return response;
	}

	private CustomerAddressType constructCustomerAddress(CreditCardInfo creditCardInfo) {
		CustomerAddressType customerAddressType = new CustomerAddressExType();

		customerAddressType.setFirstName(creditCardInfo.getFirstName());
		customerAddressType.setLastName(creditCardInfo.getLastName());
		customerAddressType.setCompany("");
		customerAddressType.setAddress(creditCardInfo.getAddress1());
		customerAddressType.setCity(creditCardInfo.getCity());
		customerAddressType.setState(creditCardInfo.getState());
		customerAddressType.setCountry(creditCardInfo.getCountry());
		customerAddressType.setPhoneNumber(creditCardInfo.getPhone());
		customerAddressType.setFaxNumber(creditCardInfo.getFax());
		customerAddressType.setZip(creditCardInfo.getZip());
		return customerAddressType;
	}

	public CreditCardInfo constructCustAddressToCreditAddress(
			CustomerAddressType customerAddressType) {
		CreditCardInfo creditCardInfo = new CreditCardInfo();
		creditCardInfo.setAddress1(customerAddressType.getAddress());

		creditCardInfo.setFirstName(customerAddressType.getFirstName());
		creditCardInfo.setLastName(customerAddressType.getLastName());
		creditCardInfo.setCity(customerAddressType.getCity());

		creditCardInfo.setState(customerAddressType.getState());
		creditCardInfo.setCountry(customerAddressType.getCountry());
		creditCardInfo.setZip(customerAddressType.getZip());
		creditCardInfo.setPhone(customerAddressType.getPhoneNumber());
		creditCardInfo.setFax(customerAddressType.getFaxNumber());
		return creditCardInfo;
	}

	public CreateCustomerPaymentProfileResponseType addProfile(int profileId,
			CreditCardInfo creditCardInfo) {
		ServiceSoap soap = SoapAPIUtilities.getServiceSoap();
		PaymentType new_payment = new PaymentType();
		CreditCardType new_card = new CreditCardType();
		new_card.setCardNumber(creditCardInfo.getCardNumber());

		new_card.setCardCode(creditCardInfo.getVerificationCode());

		try {
			javax.xml.datatype.XMLGregorianCalendar cal = javax.xml.datatype.DatatypeFactory
					.newInstance().newXMLGregorianCalendar();
			cal.setMonth(Integer.parseInt(creditCardInfo.getExpiryMonth()));
			cal.setYear(Integer.parseInt(creditCardInfo.getExpiryYear()));
			new_card.setExpirationDate(cal);
			//	 
		} catch (javax.xml.datatype.DatatypeConfigurationException dce) {
			//	
		}

		new_payment.setCreditCard(new_card);

		CustomerPaymentProfileType new_payment_profile = new CustomerPaymentProfileType();
		new_payment_profile.setPayment(new_payment);

		CustomerAddressType customerAddressType = constructCustomerAddress(creditCardInfo);

		ArrayOfCustomerPaymentProfileType arrayOfCustomerPaymentProfileType = new ArrayOfCustomerPaymentProfileType();
		new_payment_profile.setBillTo(customerAddressType);

		arrayOfCustomerPaymentProfileType.getCustomerPaymentProfileType().add(new_payment_profile);

		CreateCustomerPaymentProfileResponseType response = soap.createCustomerPaymentProfile(
				SoapAPIUtilities.getMerchantAuthentication(), profileId, new_payment_profile,
				ValidationModeEnum.LIVE_MODE);

		soap.createCustomerShippingAddress(SoapAPIUtilities.getMerchantAuthentication(), profileId,
				customerAddressType);

		if (response != null) {
			{

			}
		}

		return response;
	}

}
