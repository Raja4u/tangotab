package com.tangotab.web;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import AuthNet.Rebill.CreateCustomerProfileTransactionResponseType;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.creditcard.cim.CreateTransaction;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CreditCardInfo;

public class CcTransaction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NumberFormat nf = new DecimalFormat("#0.00");
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


			String invoiceCode = TangoTabUtility.generateRandomCode();
			int profileId = userInfo.getRestaurent().getRestaurantCcProfiles().getCcProfileId();
			int paymentProfileId = creditcard.getPaymentProfileId();
			BigDecimal amount = new BigDecimal(creditcard.getAmount());
			CreateCustomerProfileTransactionResponseType responseType = CreateTransaction
					.createTransaction((long) profileId, (long) paymentProfileId, amount,
							invoiceCode);
				if (responseType != null) {
				if (responseType.getResultCode().value().equals("Ok")) {

					String s[] = responseType.getDirectResponse().split(",");
					responseText = s[3];

					BillingCc billingCc = new BillingCc();
					billingCc.setAmount(creditcard.getAmount());
					billingCc.setPurchasedBy(userInfo.getEmailId());
					billingCc.setQty(creditcard.getQty());
					billingCc.setRestId(userInfo.getRestaurantId());

					billingCc.setX_trans_id(s[6]);
					billingCc.setX_response_reason_code(1);
					billingCc.setX_response_reason_text(s[3]);
					billingCc.setIsAutoDebit(creditcard.getIsAutoDebit());

					billingCc.setX_account_number((creditcard.getCardNumber()));

					userBo.saveRechargeInfo(billingCc, userInfo.getFirstname(), userInfo
							.getEmailId());
					userInfo = (UserTO) request.getSession().getAttribute("userInfo");

					userInfo.setCurrentCredits(Double.valueOf(creditcard.getQty()));
					userInfo.getRestaurent().setCurrentCredits(Double.valueOf(creditcard.getQty()));
					userInfo.getRestaurent().setIsAutoDebit(billingCc.getIsAutoDebit());

					HttpSession session = request.getSession();
					session.removeAttribute("userInfo");

					session.setAttribute("userInfo", userInfo);

					request.getSession().getAttribute("userInfo");
					request.setAttribute("responsetext", s[3]);
					request.setAttribute("transid", s[6]);
 					request.setAttribute("amount", ""
							+ nf.format(Double.parseDouble(creditcard.getAmount())));
					request.setAttribute("isAutoDebit", creditcard.getIsAutoDebit());
					request.setAttribute("qty", creditcard.getQty());
					request.setAttribute("startdate", startdate);
					request.setAttribute("enteredlocations", userInfo.getNoOfEnteredLocatios());
					page = TangotabConstants.SUCCESS;
				}
				for (int i = 0; i < responseType.getMessages().getMessagesTypeMessage().size(); i++) {
					responseText = responseType.getMessages().getMessagesTypeMessage().get(i)
							.getText();

				}

			}

			messages.add("message", new ActionMessage("errors.emailexist", responseText));
			saveMessages(request, messages);
		} catch (Exception e) {
			return mapping.findForward(TangotabConstants.CON_FAILURE);
		}
		return mapping.findForward(page);
	}

}
