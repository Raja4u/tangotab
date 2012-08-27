package com.tangotab.creditcard.cim;

import AuthNet.Rebill.ArrayOfCustomerAddressType;
import AuthNet.Rebill.ArrayOfCustomerPaymentProfileType;
import AuthNet.Rebill.CreditCardType;
import AuthNet.Rebill.CustomerAddressExType;
import AuthNet.Rebill.CustomerAddressType;
import AuthNet.Rebill.CustomerPaymentProfileType;
import AuthNet.Rebill.CustomerProfileMaskedType;
import AuthNet.Rebill.CustomerProfileType;
import AuthNet.Rebill.GetCustomerProfileResponseType;
import AuthNet.Rebill.PaymentType;
import AuthNet.Rebill.ServiceSoap;
import AuthNet.Rebill.UpdateCustomerProfileResponseType;

public class UpdateProfilesTest {
	public static void main(String args[]) {

		int profile_id = 3454601;

		if (args.length > 0) {
			try {
				profile_id = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {

			}
		}
		if (profile_id <= 0) {

			System.exit(0);
		}

		ServiceSoap soap = SoapAPIUtilities.getServiceSoap();

		// updated add

		CreditCardType new_card = new CreditCardType();
		new_card.setCardNumber("4007000000027");

		new_card.setCardCode("232");

		try {
			javax.xml.datatype.XMLGregorianCalendar cal = javax.xml.datatype.DatatypeFactory
					.newInstance().newXMLGregorianCalendar();
			cal.setMonth(11);
			cal.setYear(2011);
			new_card.setExpirationDate(cal);

		} catch (javax.xml.datatype.DatatypeConfigurationException dce) {

		}
		PaymentType new_payment = new PaymentType();
		new_payment.setCreditCard(new_card);

		CustomerPaymentProfileType new_payment_profile = new CustomerPaymentProfileType();
		new_payment_profile.setPayment(new_payment);

		CustomerProfileType m_new_cust = new CustomerProfileType();
		m_new_cust.setEmail("p.rathnakarreddy@gmail.com");
		m_new_cust.setDescription(" " + Long.toString(System.currentTimeMillis()));
		m_new_cust.setMerchantCustomerId("Restaurant ID");
		ArrayOfCustomerAddressType arrayOfCustomerAddressType = new ArrayOfCustomerAddressType();

		CustomerAddressType customerAddressType = new CustomerAddressExType();
		customerAddressType.setAddress("2-6-141 ,shaymlal building ");
		customerAddressType.setCountry("USA");
		customerAddressType.setCity("Begampet");
		customerAddressType.setFirstName("Rathnakar");
		customerAddressType.setLastName("Reddy");
		customerAddressType.setCompany("Techgene Software Solutions");
		customerAddressType.setFaxNumber("");
		customerAddressType.setState("AP");
		customerAddressType.setZip("506001");

		arrayOfCustomerAddressType.getCustomerAddressType().add(customerAddressType);
		m_new_cust.setShipToList(arrayOfCustomerAddressType);
		ArrayOfCustomerPaymentProfileType arrayOfCustomerPaymentProfileType = new ArrayOfCustomerPaymentProfileType();
		new_payment_profile.setBillTo(customerAddressType);

		arrayOfCustomerPaymentProfileType.getCustomerPaymentProfileType().add(new_payment_profile);

		m_new_cust.setPaymentProfiles(arrayOfCustomerPaymentProfileType);

		m_new_cust.setShipToList(arrayOfCustomerAddressType);

		// end

		GetCustomerProfileResponseType response_type = soap.getCustomerProfile(SoapAPIUtilities
				.getMerchantAuthentication(), profile_id);
		CustomerProfileMaskedType profile = response_type.getProfile();
		if (profile == null) {

		} else {

			// Change the description to be the current time
			//

			profile.setDescription(Long.toString(System.currentTimeMillis()));
			UpdateCustomerProfileResponseType response = soap.updateCustomerProfile(
					SoapAPIUtilities.getMerchantAuthentication(), profile);

			for (int i = 0; i < response.getMessages().getMessagesTypeMessage().size(); i++) {

			}
		}

	}
}