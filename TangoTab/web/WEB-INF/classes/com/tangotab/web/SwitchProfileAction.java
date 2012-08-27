package com.tangotab.web;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.BookDealTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class SwitchProfileAction extends Action {
	public static Logger log = LoggerFactory.getLogger(SwitchProfileAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
	DealTO dealInfo = new DealTO();

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		String page = TangotabConstants.LOGIN;
		HttpSession session = request.getSession(true);
		ActionMessages actionMessages = new ActionMessages();
		try {
			ArrayList<UserTO> users = new ArrayList<UserTO>();
			if (session.getAttribute("profileUsers") != null) {
				 
				users = (ArrayList) session.getAttribute("profileUsers");
			}
			UserTO userInfo = null;
			String datafrom = request.getParameter("roleId");
			String role_userid[] = null;
			if (request.getParameter("roleId") != null)
				role_userid = datafrom.split(";");
			int roleId = 0;
			if (role_userid != null && role_userid.length == 2)
				roleId = Integer.parseInt(role_userid[0]);
			else if (users.size() > 0)
				return mapping.findForward("switchProfile");

			if (session.getAttribute("userInfo") != null) {
				userInfo = (UserTO) session.getAttribute("userInfo");
			}

			for (Iterator it = users.listIterator(); it.hasNext();) {
				UserTO userto = (UserTO) it.next();

				if (userto.getRoleId() == roleId) {
					userInfo = userto;
					session.removeAttribute("userInfo");
					session.setAttribute("userInfo", userInfo);
				}

			}

			if (userInfo != null) {
				if (userInfo.getIsActive() == 0) {
					actionMessages.add("InvalidLogin", new ActionMessage("errors.autherized"));
					saveMessages(request, actionMessages);
					return mapping.findForward(page);
				}
				if (session.getAttribute("userInfo") != null) {
					session.removeAttribute("userInfo");
				}
				session.setAttribute("userInfo", userInfo);

				if (userInfo.getIsPwdChange() == 1) {

					return mapping.findForward("resetPassword");
				}
				int dealId = 0;
				String date = "";
				if(StringUtils.isNotEmpty(request.getParameter("dealId")))
				      dealId = Integer.parseInt(request.getParameter("dealId"));
				if(StringUtils.isNotEmpty(request.getParameter("date")))
				      date = request.getParameter("date");

				switch (userInfo.getRoleId()) {
				case TangotabConstants.ADMIN_ROLE:
					page = TangotabConstants.ADMIN;
					break;
				case TangotabConstants.SALES_MANAGER_ROLE:
				case TangotabConstants.SALES_REPRESENTATIVE_ROLE:
					break;
				case TangotabConstants.CONSUMER_ROLE: {
					/* go to deal details page when tried to book the deal */
					if(dealId > 0){
						DealTO dealTo = new DealTO();
						dealTo.setTobeBookedDealId(dealId);
						dealTo.setLoginUserId(userInfo.getUserId());
						
						 if(userInfo.getRoleId() == TangotabConstants.CONSUMER_ROLE)
	                        {
							 if(StringUtils.isNotEmpty(date))
	                          	   dealInfo = userBo.fetchDealByDealId(dealId, date);
	                          	 else
	                          		 dealInfo = userBo.fetchDealByDealId(dealId);
	                        	 /* bypass the deal details page and goto offer confirmation step */
	                        	 String bypass = request.getParameter("bypass");
	                        	 if(( dealId > 0 && StringUtils.isNotEmpty(date)) || StringUtils.isNotEmpty(bypass)){
	                        		 long count = 0;
	                        		 count = userBo.countBookedDeals(userInfo.getUserId(), dealId);
	                                 if(count >= 5){
	                                 	actionMessages.add("No Records", new ActionMessage("result.noRecords",
	                             				"Sorry you have exceeded the maximum number of reservations for today." +
	                             				" If you have reserved an offer by mistake, please check your inbox to ensure that your " +
	                             				"confirmation has not been placed in the junk folder. Furthermore, please let us know ASAP so we may cancel any reservations made in error."));
	                             		       saveMessages(request, actionMessages);
	                             		       return mapping.findForward(TangotabConstants.FAILURE);
	                                 }else {
	                                 	count = userBo.countBookedDealsPerDate(userInfo.getUserId(), dealId, dealInfo.getStartDate());
	                                 	if(count >= 1){
	                                 		
	                                 		actionMessages.add("No Records", new ActionMessage("result.noRecords",
	                                 				"You have already reserved this offer today. If you have not received your reservation confirmation number," +
	                                 				" please check your spam folder or you can retrieve the reservation code from your account profile." +
	                                 				" If you are trying to reserve this great offer for your friends, kindly ask them to join and reserve " +
	                                 				"the offer as it is FREE to join."));
	                                 		     
	                                 		       saveMessages(request, actionMessages);
	                                 		       return mapping.findForward(TangotabConstants.FAILURE);
	                                 	}
	                                 }
	                                
	                     			BookDealTO to = userBo.bookDeal(userInfo.getUserId(), dealId, dealInfo);
	                                 
	                     			request.setAttribute("dealInfo", dealInfo);

	                     		 	session.setAttribute("book_deal_to", to);
	                     			return mapping.findForward("confirmation");
	                        		 
	                        	 }else{
	                        		 session.setAttribute("dealInfo", dealInfo);
	     						     return mapping.findForward("search_deals");
	                        	 }
	                        	 
	                        }
						
					}
					//else if(userInfo.getConsumerReferrals().size() < 1)
					//	page = "consumerRefer"; 
					else if (userInfo.getAddress1() == null || userInfo.getMobilePhone() == null
							|| userInfo.getHomePhone() == null || userInfo.getGender() == null
							|| userInfo.getAge() == 0 || userInfo.getCityId() == null
							|| userInfo.getStateId() == 0 || userInfo.getCountryId() == 0
							|| userInfo.getAddress().isEmpty()
							|| userInfo.getMobilePhone().isEmpty()
							|| userInfo.getHomePhone().isEmpty() || userInfo.getGender().isEmpty()
							|| userInfo.getAge() == 0 || userInfo.getCityId().isEmpty()
							|| userInfo.getStateId() == 0 || userInfo.getCountryId() == 0
							|| userInfo.getConsumerPreferCity() == null
							|| userInfo.getPreferencesList() == null
							|| userInfo.getConsumerPreferCity().getCity().getCityId() == 0) {

						userBo.setUserConsumerStatus(userInfo.getEmailId(), (short) 0,
								TangotabConstants.CONSUMER_ROLE);
						page = "consumerfirst";
					} else
						page = TangotabConstants.CONSUMER;
					/*
					 * This code should be moved to another class after getting deals.jsp
					 */
				}
					break;
				case TangotabConstants.RESTAURANT_OWNER: {
					/* go to edit deal page if deals qty is less(from mail) */
					if(dealId > 0){
					dealInfo = locationBO.getDealByDealId(dealId);
                	session.setAttribute("dealInfo", dealInfo);
                	return mapping.findForward("edit_deal");
					}
					int noOfEnteredLocations = userBo.getNoOfEnteredLocations(userInfo
							.getRestaurantId());
					userInfo.setNoOfEnteredLocatios(noOfEnteredLocations);
					if (userInfo.getQuestion1() == null || userInfo.getQuestion1().isEmpty()) {
						return mapping.findForward("client_question");
					}
					if (userInfo.getBillingMethodId() == 0 && userInfo.getBillingTypeId() == 0) {
						page = TangotabConstants.CLIENT_PROFILE;
					} else if (userInfo.getBillingMethodId() == 1
							&& userInfo.getCurrentCredits() <= 0) {
						page = TangotabConstants.ACOOUNT_RECHAGE;
					} else if (noOfEnteredLocations == 0) {
						page = TangotabConstants.CLIENT_LOCATION;
					} else {
						ArrayList<LocationTO> locationsInfo = locationBO
								.getLocationsByRestaurantId(userInfo.getRestaurantId());
						request.setAttribute("locationsInfo", locationsInfo);
						userInfo.setNoOfEnteredLocatios(noOfEnteredLocations);
						session.removeAttribute("userInfo");
						session.setAttribute("userInfo", userInfo);
						ArrayList<DealTO> dealsInfo = locationBO.getDeals(userInfo.getUserId(),
								userInfo.getRoleId(), userInfo.getRestaurantId());
						if (dealsInfo == null || dealsInfo.size() == 0) {
							
							page = TangotabConstants.DEAL_CREATE;
						} else {
							request.setAttribute("dealsInfo", dealsInfo);
							page = TangotabConstants.RESTARRANT;
						}

					}
				}
					break;
				case TangotabConstants.RESTAURANT_STORE_MANAGER:
					session.removeAttribute("userInfo");
					session.setAttribute("userInfo", userInfo);
					ArrayList<DealTO> dealsInfo = locationBO.getDeals(userInfo.getUserId(),
							userInfo.getRoleId(), userInfo.getRestaurantId());
					if (dealsInfo == null || dealsInfo.size() == 0) {
						actionMessages.add("No Records", new ActionMessage("result.noRecords",
								"No Records Found"));
						saveMessages(request, actionMessages);
					}
					request.setAttribute("dealsInfo", dealsInfo);
					/* go to edit deal page if deals qty is less(from mail) */
					if(dealId > 0){
					dealInfo = locationBO.getDealByDealId(dealId);
                	session.setAttribute("dealInfo", dealInfo);
                	return mapping.findForward("edit_deal");
					}
					page = TangotabConstants.RESTARRANT;
					break;
				}
			} else {
				actionMessages.add("InvalidLogin", new ActionMessage("errors.invalidLogin",
						"User Name/Password"));
				saveMessages(request, actionMessages);
				return mapping.findForward(page);
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(page);
		}

		return mapping.findForward(page);

	}

}