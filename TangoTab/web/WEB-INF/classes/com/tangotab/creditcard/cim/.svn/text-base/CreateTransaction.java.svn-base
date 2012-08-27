package com.tangotab.creditcard.cim;

import java.math.BigDecimal;

import AuthNet.Rebill.CreateCustomerProfileTransactionResponseType;
import AuthNet.Rebill.OrderExType;
import AuthNet.Rebill.ProfileTransAuthCaptureType;
import AuthNet.Rebill.ProfileTransactionType;
import AuthNet.Rebill.ServiceSoap;

public class CreateTransaction {

	public static CreateCustomerProfileTransactionResponseType createTransaction(long profile_id,
			long payment_profile_id, BigDecimal amount, String invoiceCode) {
		ServiceSoap soap = SoapAPIUtilities.getServiceSoap();
		CreateCustomerProfileTransactionResponseType response = null;

		ProfileTransAuthCaptureType auth_capture = new ProfileTransAuthCaptureType();

		auth_capture.setCustomerProfileId(profile_id);
		auth_capture.setCustomerPaymentProfileId(payment_profile_id);
		auth_capture.setAmount(amount);
		OrderExType order = new OrderExType();
		order.setInvoiceNumber(invoiceCode);
		auth_capture.setOrder(order);

		ProfileTransactionType trans = new ProfileTransactionType();
		trans.setProfileTransAuthCapture(auth_capture);

		response = soap.createCustomerProfileTransaction(SoapAPIUtilities
				.getMerchantAuthentication(), trans, null);

		for (int i = 0; i < response.getMessages().getMessagesTypeMessage().size(); i++) {

		}
	//	String s = response.getDirectResponse();

		//	
		return response;
	}

}