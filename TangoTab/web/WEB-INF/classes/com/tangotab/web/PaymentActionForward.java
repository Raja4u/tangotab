package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import AuthNet.Rebill.GetCustomerPaymentProfileResponseType;

import com.tangotab.TO.UserTO;
import com.tangotab.creditcard.cim.CreateProfiles;
import com.tangotab.creditcard.cim.GetPaymentProfiles;
import com.tangotab.util.AmountConvertion;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CreditCardInfo;

public class PaymentActionForward extends BaseAction {
	
	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		try {

			request.setAttribute("amount", AmountConvertion.convertUSAmount(request
					.getParameter("totaldue")));
			
			request.setAttribute("qty", request.getParameter("unit1"));
			request.setAttribute("isAutoDebit", request.getParameter("isAutoDebit"));
			// new added code
			if (request.getParameter("paymentProfileId") != null) {
				request.setAttribute("paymentProfileId", Integer.parseInt(request
						.getParameter("paymentProfileId")));

				HttpSession session = request.getSession(true);
				UserTO userTO = (UserTO) session.getAttribute("userInfo");
				if (userTO.getRestaurent().getRestaurantCcProfiles() != null
						&& userTO.getRestaurent().getRestaurantCcProfiles().getCcProfileId() != 0
						&& Integer.parseInt(request.getParameter("paymentProfileId")) != 0) {

					GetPaymentProfiles getPaymentProfiles = new GetPaymentProfiles();
					GetCustomerPaymentProfileResponseType customerPaymentProfileResponseType = getPaymentProfiles
							.getPaymentProfilebyProfileId(userTO.getRestaurent()
									.getRestaurantCcProfiles().getCcProfileId(), Integer
									.parseInt(request.getParameter("paymentProfileId")));

					CreateProfiles createProfiles = new CreateProfiles();
					CreditCardInfo creditCardInfo = createProfiles
							.constructCustAddressToCreditAddress(customerPaymentProfileResponseType
									.getPaymentProfile().getBillTo());
					creditCardInfo.setCardNumber(customerPaymentProfileResponseType
							.getPaymentProfile().getPayment().getCreditCard().getCardNumber());
					creditCardInfo.setExpiryMonth(customerPaymentProfileResponseType
							.getPaymentProfile().getPayment().getCreditCard().getExpirationDate());
					request.setAttribute("creditCardInfo", creditCardInfo);
					return mapping.findForward("already");
				}

			}
			// end added code

		} catch (Exception e) {
			e.printStackTrace();

			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
