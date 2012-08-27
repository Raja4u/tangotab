package com.tangotab.creditcard.cim;

import AuthNet.Rebill.DeleteCustomerProfileResponseType;
import AuthNet.Rebill.ServiceSoap;

public class DeleteProfilesTest {
	public static void main(String args[]) {

		int profile_id = 3449624;

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
		DeleteCustomerProfileResponseType response = soap.deleteCustomerProfile(SoapAPIUtilities
				.getMerchantAuthentication(), profile_id);

		for (int i = 0; i < response.getMessages().getMessagesTypeMessage().size(); i++) {

		}

	}
}