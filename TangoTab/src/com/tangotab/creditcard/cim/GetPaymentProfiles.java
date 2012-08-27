package com.tangotab.creditcard.cim;

import java.util.List;

import AuthNet.Rebill.CustomerPaymentProfileMaskedType;
import AuthNet.Rebill.CustomerProfileMaskedType;
import AuthNet.Rebill.GetCustomerPaymentProfileResponseType;
import AuthNet.Rebill.GetCustomerProfileResponseType;
import AuthNet.Rebill.ServiceSoap;

public class GetPaymentProfiles {
	ServiceSoap soap = SoapAPIUtilities.getServiceSoap();

	public List<CustomerPaymentProfileMaskedType> getPaymentProfiles(int profile_id) {
		GetCustomerProfileResponseType response_type = soap.getCustomerProfile(SoapAPIUtilities
				.getMerchantAuthentication(), (long) profile_id);
		CustomerProfileMaskedType profile = response_type.getProfile();
		if(profile!=null)
		return profile.getPaymentProfiles().getCustomerPaymentProfileMaskedType();
		else 
			return null;
	}

	public GetCustomerPaymentProfileResponseType getPaymentProfilebyProfileId(
			int customerProfileId, int customerPaymentProfileId) {

		GetCustomerPaymentProfileResponseType customerPaymentProfileResponseType = soap
				.getCustomerPaymentProfile(SoapAPIUtilities.getMerchantAuthentication(),
						(long) customerProfileId, (long) customerPaymentProfileId);

		return customerPaymentProfileResponseType;
	}

}