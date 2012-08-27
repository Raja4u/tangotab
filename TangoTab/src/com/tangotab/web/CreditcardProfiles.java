package com.tangotab.web;

import java.math.BigDecimal;
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

import AuthNet.Rebill.CreateCustomerPaymentProfileResponseType;
import AuthNet.Rebill.CreateCustomerProfileResponseType;
import AuthNet.Rebill.CreateCustomerProfileTransactionResponseType;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.creditcard.cim.CreateProfiles;
import com.tangotab.creditcard.cim.CreateTransaction;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.dao.pojo.RestaurantCC;
import com.tangotab.dao.pojo.RestaurantCcProfile;
import com.tangotab.dao.pojo.RestaurantPaymentProfile;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CreditCardInfo;

public class CreditcardProfiles extends BaseAction {
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
			CreditCardInfo creditCardInfo = (CreditCardInfo) form;
			creditCardInfo.setRestId(userInfo.getRestaurantId());
			creditCardInfo.setEmail(userInfo.getEmailId());
			creditCardInfo.setRestName(userInfo.getRestaurent().getBusinessName());
			HttpSession session = request.getSession();
			Date d = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String startdate = sf.format(d);
			BigDecimal amount = new BigDecimal(creditCardInfo.getAmount());
			userInfo = (UserTO) request.getSession().getAttribute("userInfo");

			long paymentProfileId = 0;

			RestaurantCC restaurantCC = new RestaurantCC();
			BeanUtils.copyProperties(restaurantCC, creditCardInfo);
			CreateProfiles createProfiles = new CreateProfiles();
			if (userInfo.getRestaurent().getRestaurantCcProfiles() == null) {
				CreateCustomerProfileResponseType responseType = createProfiles
						.createNewProfile(creditCardInfo);

				if (responseType != null) {
					if (responseType.getResultCode().value().equals("Ok")) {
						long new_cust_id = responseType.getCustomerProfileId();
						if (responseType.getCustomerPaymentProfileIdList() != null) {
							for (long paymentProfileId2 : responseType
									.getCustomerPaymentProfileIdList().getLong()) {
								paymentProfileId = paymentProfileId2;

								if (paymentProfileId > 0) {
									String invoiceCode = TangoTabUtility.generateRandomCode();

									RestaurantCcProfile restaurantCcProfile = new RestaurantCcProfile();

									RestaurantPaymentProfile paymentProfile = new RestaurantPaymentProfile();

									restaurantCcProfile.setCcProfileId((int) new_cust_id);
									restaurantCcProfile.setRestaurant(userInfo.getRestaurent());

									int id = userBo.saveCcProfile(restaurantCcProfile);
									restaurantCcProfile.setRestaurantCcProfileId(id);
									paymentProfile.setRestaurantCcProfile(restaurantCcProfile);
									paymentProfile.setCcprofileId(id);
									paymentProfile.setCcPaymentId((int) paymentProfileId);
									userBo.savePaymentProfile(paymentProfile);
									userInfo.getRestaurent().setRestaurantCcProfiles(
											restaurantCcProfile);
									session.removeAttribute("userInfo");

									session.setAttribute("userInfo", userInfo);
									userInfo = (UserTO) request.getSession().getAttribute(
											"userInfo");
								}
							}
						}

					}

					for (int i = 0; i < responseType.getMessages().getMessagesTypeMessage().size(); i++) {
						responseText = responseType.getMessages().getMessagesTypeMessage().get(i)
								.getText();
					}
				}

			} else if (userInfo.getRestaurent().getRestaurantCcProfiles() != null
					&& userInfo.getRestaurent().getRestaurantCcProfiles().getCcProfileId() > 0) {
				CreateCustomerPaymentProfileResponseType responseType = createProfiles.addProfile(
						userInfo.getRestaurent().getRestaurantCcProfiles().getCcProfileId(),
						creditCardInfo);

				if (responseType.getResultCode().value().equals("Ok")) {
					paymentProfileId = responseType.getCustomerPaymentProfileId();
					RestaurantPaymentProfile paymentProfile = new RestaurantPaymentProfile();
					paymentProfile.setRestaurantCcProfile(userInfo.getRestaurent()
							.getRestaurantCcProfiles());
					paymentProfile.setCcprofileId(userInfo.getRestaurent()
							.getRestaurantCcProfiles().getCcProfileId());
					paymentProfile.setCcPaymentId((int) paymentProfileId);
					userBo.savePaymentProfile(paymentProfile);
					for (int i = 0; i < responseType.getMessages().getMessagesTypeMessage().size(); i++) {
						responseText = responseType.getMessages().getMessagesTypeMessage().get(i)
								.getText();
					}
				} else {
					for (int i = 0; i < responseType.getMessages().getMessagesTypeMessage().size(); i++) {

						responseText = responseType.getMessages().getMessagesTypeMessage().get(i)
								.getText();

					}
				}
			}

			CreateCustomerProfileTransactionResponseType transresponseType = null;
			if (userInfo.getRestaurent().getRestaurantCcProfiles() != null && paymentProfileId != 0) {
				String invoiceCode = TangoTabUtility.generateRandomCode();
				transresponseType = CreateTransaction.createTransaction((long) userInfo
						.getRestaurent().getRestaurantCcProfiles().getCcProfileId(),
						(long) paymentProfileId, amount, invoiceCode);
			}
			if (transresponseType != null) {
				if (transresponseType.getResultCode().value().equals("Ok")) {

					String s[] = transresponseType.getDirectResponse().split(",");
					responseText = s[3];

					BillingCc billingCc = new BillingCc();
					billingCc.setAmount(creditCardInfo.getAmount());
					billingCc.setPurchasedBy(userInfo.getEmailId());
					billingCc.setQty(creditCardInfo.getQty());
					billingCc.setRestId(userInfo.getRestaurantId());

					billingCc.setX_trans_id(s[6]);
					billingCc.setX_response_reason_code(1);
					billingCc.setX_response_reason_text(s[3]);
					billingCc.setIsAutoDebit(creditCardInfo.getIsAutoDebit());

					if (creditCardInfo.getCardNumber().length() > 9) {
						billingCc.setX_account_number("xxxx"
								+ (creditCardInfo.getCardNumber()).substring((creditCardInfo
										.getCardNumber().length() - 4), creditCardInfo
										.getCardNumber().length()));

					}
					// billingCc.setX_account_number(creditCardInfo.getCardNumber());

					userBo.saveRechargeInfo(billingCc, userInfo.getFirstname(), userInfo
							.getEmailId());

					userInfo.setCurrentCredits(Double.valueOf(creditCardInfo.getQty()));
					userInfo.getRestaurent().setCurrentCredits(
							Double.valueOf(creditCardInfo.getQty()));
					userInfo.getRestaurent().setIsAutoDebit(billingCc.getIsAutoDebit());

					session.removeAttribute("userInfo");

					session.setAttribute("userInfo", userInfo);

					request.getSession().getAttribute("userInfo");
					request.setAttribute("responsetext", s[3]);
					request.setAttribute("transid", s[6]);

					request.setAttribute("amount", ""
							+ nf.format(Double.parseDouble(creditCardInfo.getAmount())));
					request.setAttribute("isAutoDebit", creditCardInfo.getIsAutoDebit());
					request.setAttribute("qty", creditCardInfo.getQty());
					request.setAttribute("startdate", startdate);
					request.setAttribute("enteredlocations", userInfo.getNoOfEnteredLocatios());
					page = TangotabConstants.SUCCESS;
				}
				for (int i = 0; i < transresponseType.getMessages().getMessagesTypeMessage().size(); i++) {
					responseText = transresponseType.getMessages().getMessagesTypeMessage().get(i)
							.getText();
				}

			}

			request.setAttribute("amount", ""
					+ nf.format(Double.parseDouble(creditCardInfo.getAmount())));
			request.setAttribute("paymentProfileId", creditCardInfo.getPaymentProfileId());
			request.setAttribute("qty", creditCardInfo.getQty());
			request.setAttribute("isAutoDebit", creditCardInfo.getIsAutoDebit());

			messages.add("message", new ActionMessage("errors.emailexist", responseText));
			saveMessages(request, messages);
		} catch (Exception e) {
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(page);
	}

}
