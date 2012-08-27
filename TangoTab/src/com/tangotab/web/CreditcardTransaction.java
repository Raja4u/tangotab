package com.tangotab.web;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.dao.pojo.RestaurantCC;
import com.tangotab.util.CreditCardDebit;
import com.tangotab.util.TangoTabPasswordEncrypt;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CreditCardInfo;
import net.authorize.aim.Result;
import net.authorize.aim.Transaction;

public class CreditcardTransaction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NumberFormat nf = new DecimalFormat("#0.00");
		Result<Transaction> result = null;
		boolean paymentmethod = true;
		String responseText = "";
		String page = TangotabConstants.FAILURE;
		ActionMessages messages = new ActionMessages();
		try {
			UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
			CreditCardInfo creditcard = (CreditCardInfo) form;
			creditcard.setRestId(userInfo.getRestaurantId());
			Date d = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String startdate = sf.format(d);

			// creditcard.setAmount("1");

			result = CreditCardDebit.advancepaymentMethod(creditcard.getEmail(), creditcard
					.getFirstName(), creditcard.getLastName(), creditcard.getCardNumber()
					.toString(), creditcard.getCardType(), creditcard.getCardName(), creditcard
					.getVerificationCode().toString(), creditcard.getExpiryYear(), creditcard
					.getExpiryMonth(), creditcard.getExpiryYear() + "-"
					+ creditcard.getExpiryMonth(), creditcard.getAmount(), startdate, creditcard
					.getCity(), creditcard.getState(), creditcard.getAddress1(), creditcard
					.getAddress2(), creditcard.getZip(), creditcard.getCountry());
			request.setAttribute("autid", result.getTarget());
			RestaurantCC restaurantCC = new RestaurantCC();
			BeanUtils.copyProperties(restaurantCC, creditcard);
			if (result.isApproved()) {

				if (creditcard.getIsAutoDebit() == 1) {
					restaurantCC.setCardNumber(TangoTabPasswordEncrypt
							.getPasswordEncrypt(restaurantCC.getCardNumber()));
					restaurantCC.setExpiryMonth(TangoTabPasswordEncrypt
							.getPasswordEncrypt(restaurantCC.getExpiryMonth()));
					restaurantCC.setExpiryYear(TangoTabPasswordEncrypt
							.getPasswordEncrypt(restaurantCC.getExpiryYear()));
					restaurantCC.setVerificationCode(TangoTabPasswordEncrypt
							.getPasswordEncrypt(restaurantCC.getVerificationCode()));
					restaurantCC.setCardType(TangoTabPasswordEncrypt
							.getPasswordEncrypt(restaurantCC.getCardType()));
					RestaurantCC restaurantCC2 = userBo.getRestaurantCC(userInfo.getRestaurantId());
					if (restaurantCC2 != null)
						restaurantCC.setRestCcId(restaurantCC2.getRestCcId());

					userBo.saveCreditcard(restaurantCC);

				}
				BillingCc billingCc = new BillingCc();
				billingCc.setAmount(creditcard.getAmount());
				billingCc.setPurchasedBy(userInfo.getEmailId());
				billingCc.setQty(creditcard.getQty());
				billingCc.setRestId(userInfo.getRestaurantId());
				billingCc.setX_trans_id(result.getTarget().getTransactionId());
				billingCc.setX_response_reason_code(result.getResponseCode().getCode());
				billingCc.setX_response_reason_text(result.getResponseText());
				billingCc.setIsAutoDebit(creditcard.getIsAutoDebit());

				billingCc.setX_account_number((creditcard.getCardNumber()).substring((creditcard
						.getCardNumber().length() - 4), creditcard.getCardNumber().length()));

				userBo.saveRechargeInfo(billingCc, userInfo.getFirstname(), userInfo.getEmailId());
				userInfo = (UserTO) request.getSession().getAttribute("userInfo");

				userInfo.setCurrentCredits(Double.valueOf(creditcard.getQty()));
				userInfo.getRestaurent().setCurrentCredits(Double.valueOf(creditcard.getQty()));
				userInfo.getRestaurent().setIsAutoDebit(billingCc.getIsAutoDebit());

				HttpSession session = request.getSession();
				session.removeAttribute("userInfo");

				session.setAttribute("userInfo", userInfo);

				request.getSession().getAttribute("userInfo");
				request.setAttribute("responsetext", result.getResponseText());
				request.setAttribute("transid", result.getTarget().getTransactionId());
				request.setAttribute("autid", result.getTarget().getAuthorizationCode());
				request.setAttribute("amount", ""
						+ nf.format(Double.parseDouble(creditcard.getAmount())));
				request.setAttribute("isAutoDebit", creditcard.getIsAutoDebit());
				request.setAttribute("qty", creditcard.getQty());
				request.setAttribute("startdate", startdate);
				request.setAttribute("enteredlocations", userInfo.getNoOfEnteredLocatios());
				page = TangotabConstants.SUCCESS;
			} else if (result.isDeclined()) {

					responseText = result.getResponseText();
				request.setAttribute("amount", ""
						+ nf.format(Double.parseDouble(creditcard.getAmount())));
				request.setAttribute("qty", creditcard.getQty());
				request.setAttribute("isAutoDebit", creditcard.getIsAutoDebit());
				paymentmethod = false;
				page = TangotabConstants.FAILURE;
			} else {

			
				responseText = result.getResponseText();
				request.setAttribute("amount", ""
						+ nf.format(Double.parseDouble(creditcard.getAmount())));
				request.setAttribute("isAutoDebit", creditcard.getIsAutoDebit());
				request.setAttribute("qty", creditcard.getQty());
				paymentmethod = false;
				page = TangotabConstants.FAILURE;
			}
			messages.add("message", new ActionMessage("errors.emailexist", responseText));
			saveMessages(request, messages);
		} catch (Exception e) {
			return mapping.findForward(TangotabConstants.CON_FAILURE);
		}
		return mapping.findForward(page);
	}

}
