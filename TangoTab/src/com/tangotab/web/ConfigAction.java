package com.tangotab.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import AuthNet.Rebill.CustomerPaymentProfileMaskedType;

import com.tangotab.TO.BillingCcTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.ConfigBO;
import com.tangotab.business.UserBO;
import com.tangotab.creditcard.cim.GetPaymentProfiles;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.web.form.ConfigForm;
import com.tangotab.web.form.CreditCardInfo;

public class ConfigAction extends BaseDispatchAction {

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = "";

		ConfigForm configForm = (ConfigForm) form;
		ConfigPojo config = new ConfigPojo();
		ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
		try {
			config = configBO.getConfigDetails();

			BeanUtils.copyProperties(configForm, config);
			configForm.setDiscountFromDate(DateConverterUtility.convertDBTimeStampToUiDate(config
					.getDiscountFromDate()));
			configForm.setDiscountTODate(DateConverterUtility.convertDBTimeStampToUiDate(config
					.getDiscountTODate()));
				request.setAttribute("config", configForm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		result = "gotConfig";
		return mapping.findForward(result);
	}

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String result = "";
		ConfigForm configForm = (ConfigForm) form;
		ConfigPojo config = new ConfigPojo();
		try {
			configForm.setConfigId(1);

			String mincharge = request.getParameter("minChargeAmt");
			config.setMinChargeAmt(Double.parseDouble(mincharge.trim()));

			String defcredit = request.getParameter("defaultDealCreditValue");
			config.setDefaultDealCreditValue(Double.parseDouble(defcredit.trim()));

			String discamount = request.getParameter("defaultDiscountAmountOnAccount");
			config.setDefaultDiscountAmountOnAccount(Double.parseDouble(discamount.trim()));

			String deffee = request.getParameter("defaultSetupFee");
			config.setDefaultSetupFee(Double.parseDouble(deffee.trim()));

			config.setDiscountFromDate(new java.sql.Timestamp(DateConverterUtility
					.convertUiToServiceDate(configForm.getDiscountFromDate()).getTime()));
			config.setDiscountTODate(new java.sql.Timestamp((DateConverterUtility
					.convertUiToServiceDate(configForm.getDiscountTODate()).getTime())));
			config.setCreditUserDeal(configForm.getCreditUserDeal());
			config.setCustomizedDealCredit(configForm.getCustomizedDealCredit());
			config.setPromotionCode(configForm.getPromotionCode());
			config.setConfigId(1);
			ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
			configBO.updateConfig(config);

			BeanUtils.copyProperties(configForm, config);
			configForm.setDiscountFromDate(DateConverterUtility.convertDBTimeStampToUiDate(config
					.getDiscountFromDate()));
			configForm.setDiscountTODate(DateConverterUtility.convertDBTimeStampToUiDate(config
					.getDiscountTODate()));
			request.setAttribute("config", configForm);

			ActionMessages actionMessages = new ActionMessages();
			actionMessages.add("No Records", new ActionMessage("result.noRecords",
					"Successfully Updated ."));
			saveMessages(request, actionMessages);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		result = "gotConfig";
		return mapping.findForward(result);
	}

	public ActionForward calulate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result1 = "";

		ConfigForm configForm = new ConfigForm();
		ConfigPojo config = new ConfigPojo();
		ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
		UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();
		try {
			config = configBO.getConfigDetails();

			Date discountFromDate = config.getDiscountFromDate();
			Date discountToDate = config.getDiscountTODate();

			Date cuTimestamp = new Timestamp(new java.util.Date().getTime());
			
			Date endDate = discountToDate = config.getDiscountTODate();
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(endDate);
			cal2.add(Calendar.HOUR, 24);
			endDate = cal2.getTime();

			if (!(cuTimestamp.before(endDate) && cuTimestamp.after(discountFromDate))) {
				config.setDefaultDiscountAmountOnAccount(0.0);
			}
			BeanUtils.copyProperties(configForm, config);
			configForm.setDiscountFromDate(DateConverterUtility.convertDBTimeStampToUiDate(config
					.getDiscountFromDate()));
			configForm.setDiscountTODate(DateConverterUtility.convertDBTimeStampToUiDate(config
					.getDiscountTODate()));
			HttpSession session = request.getSession(true);
			session.setAttribute("configdisplay", configForm);
			UserTO useTO = (UserTO) session.getAttribute("userInfo");
			Integer Rid = useTO.getRestaurantId();
			ArrayList<BillingCcTO> bill = userBO.getBillingSummary(Rid);

			// new added code
			if (useTO.getRestaurent().getRestaurantCcProfiles() != null) {
				ArrayList<CreditCardInfo> arrayList = new ArrayList<CreditCardInfo>();
				GetPaymentProfiles getPaymentProfiles = new GetPaymentProfiles();
				List<CustomerPaymentProfileMaskedType> list = getPaymentProfiles
						.getPaymentProfiles(useTO.getRestaurent().getRestaurantCcProfiles()
								.getCcProfileId());
				for (CustomerPaymentProfileMaskedType paymentProfile : list) {
					CreditCardInfo cardInfo = new CreditCardInfo();

					cardInfo
							.setPaymentProfileId((int) paymentProfile.getCustomerPaymentProfileId());
					cardInfo.setCardNumber(paymentProfile.getPayment().getCreditCard()
							.getCardNumber());
					arrayList.add(cardInfo);

				}
				request.setAttribute("profiles", arrayList);
			}

			if (bill == null || bill.size() == 0) {
				request.setAttribute("records", "no");
			} else {
				request.setAttribute("records", "yes");
			}

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String loginID = "5FatD25E";
		String description = "Sample Transaction";
		String testMode = "false";
		Date myDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String invoice = dateFormat.format(myDate);
		Random generator = new Random();
		int sequence = generator.nextInt(1000);
		long timeStamp = System.currentTimeMillis() / 1000;
		KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
		request.setAttribute("loginId", loginID);
		request.setAttribute("description", description);
		request.setAttribute("invoice", invoice);
		request.setAttribute("sequence", sequence);
		request.setAttribute("timestamp", timeStamp);
		request.setAttribute("request", testMode);
		result1 = "calulate";
		return mapping.findForward(result1);
	}

}
