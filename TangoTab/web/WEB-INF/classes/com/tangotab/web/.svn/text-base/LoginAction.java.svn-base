package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
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
import com.tangotab.web.form.LoginForm;

public class LoginAction extends Action {
	private Logger log = LoggerFactory.getLogger(LoginAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
	public static String COOKIE_NAME = "COOKIE_REMEMBER_ME";
	public static final int COOKIE_REMOVE = 0;
	public static final int COOKIE_ONEHOUR = 3600000;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		String page = TangotabConstants.LOGIN;
		HttpSession session = request.getSession(true);
		ActionMessages actionMessages = new ActionMessages();
		try {
			LoginForm user = (LoginForm) form;
			String userName = user.getEmailId();
			String password = user.getPassword();
			ArrayList<UserTO> users = userBo.getProfiles(userName, password);
			if (null != users && users.size() > 0) {
				COOKIE_NAME = "tangotabid::" + user.getEmailId().toString();
				if (user.getRememberme() != null) {

					Cookie cookie = new Cookie(COOKIE_NAME, user.getPassword().toString());
					cookie.setValue(user.getPassword().toString());
										
					/* adding prefcity(id) and zip code for automatic redirection */
					for(UserTO checkUser:users){
						if(checkUser.getRole().getRoleId() == TangotabConstants.CONSUMER_ROLE){
							String preferCityId = "";
							String zipCode = "";
							if(checkUser.getConsumerPreferCity() != null &&
							   checkUser.getConsumerPreferCity().getCity() != null && 
							   checkUser.getConsumerPreferCity().getCity().getCityName() != null)
							    preferCityId = checkUser.getConsumerPreferCity().getCity().getCityName();
							if(checkUser.getZipCode() != null)
								zipCode = checkUser.getZipCode();
							cookie.setValue(user.getPassword().toString()+","+preferCityId+","+zipCode);
							
						}
					}
					cookie.setMaxAge(COOKIE_ONEHOUR);
					cookie.setPath("/");
					response.addCookie(cookie);
					isCookieSet(request, user.getEmailId());
					// Must clean cookie
				}

			}

			if (null != users && users.size() == 1) {
				UserTO userInfo = users.get(0);

					if(userInfo.getRoleId()==TangotabConstants.RESTAURANT_OWNER )
					{
						int noOfEnteredLocations = userBo.getNoOfEnteredLocations(userInfo
								.getRestaurantId());
						userInfo.setNoOfEnteredLocatios(noOfEnteredLocations);
						if(userInfo.getRestaurent().getIsActivated()!=TangotabConstants.ACTIVE)
						{
						actionMessages.add("InvalidLogin", new ActionMessage("errors.suspend",
						"Your account is suspended,please contact TangoTab Administrator."));
				saveMessages(request, actionMessages);
				return mapping.findForward(page);
						}
					}else if(userInfo.getRoleId()==TangotabConstants.RESTAURANT_STORE_MANAGER )
					{
						/*if(userInfo.getRestaurantLocation().getRestaurant().getIsActivated()!=TangotabConstants.ACTIVE)
						{
						actionMessages.add("InvalidLogin", new ActionMessage("errors.suspend",
						"Your account is suspended, please contact TangoTab Administrator."));
				saveMessages(request, actionMessages);
				return mapping.findForward(page);
						}*/
					 
					}
				if (userInfo != null) {
					if (userInfo.getIsActive() == 0) {
						actionMessages.add("InvalidLogin", new ActionMessage("errors.autherized"));
						saveMessages(request, actionMessages);
						return mapping.findForward(page);
					}
					Integer dealId = user.getDealId();
					String date = user.getDate();
					if(user.getDealId()==0)
					{
					//	session.setAttribute("dealID", 363);
						if(session.getAttribute("dealID")!=null)
						{
						dealId=(Integer) (Object)session.getAttribute("dealID");
						date = (String) session.getAttribute("date");
						user.setDealId(dealId);
						session.removeAttribute("dealID");
						}
					}
					session.removeAttribute("profileUsers");

					session.setAttribute("userInfo", userInfo);
                   
					/* This is for forwarding deal to a friend or just sharing any friend */
					String share = request.getParameter("share");
					if(StringUtils.isNotEmpty(share) && share.equals("true") && userInfo.getRoleId() == TangotabConstants.CONSUMER_ROLE){
						request.setAttribute("dealId", dealId);
						return mapping.findForward(TangotabConstants.FRIEND);
					}
					if (null != dealId && dealId != 0) {
						
						DealTO dealTo = new DealTO();
						dealTo.setTobeBookedDealId(dealId);
						dealTo.setLoginUserId(userInfo.getUserId());
												
						actionMessages.add("bookdeal",
								new ActionMessage("Deal Displaying Successfully"));
						saveMessages(request, actionMessages);
						DealTO dealInfo = new DealTO();
						
                        if(userInfo.getRoleId() == TangotabConstants.CONSUMER_ROLE)
                        {
                        	 if(StringUtils.isNotEmpty(date))
                          	   dealInfo = userBo.fetchDealByDealId(dealId, date);
                          	 else
                          		 dealInfo = userBo.fetchDealByDealId(dealId);
                        	 /* bypass the deal details page and goto offer confirmation step */
                        	 String bypass = request.getParameter("bypass");
                        	 if((dealId!=null && dealId > 0 && StringUtils.isNotEmpty(date)) || StringUtils.isNotEmpty(bypass)){
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
                                 /* set the url to share in fb and twitter */
                                 if(StringUtils.isNotEmpty(request.getParameter("compressedURL")))
                              	   dealInfo.setCompressedURL(request.getParameter("compressedURL"));
                     			BookDealTO to = userBo.bookDeal(userInfo.getUserId(), dealId, dealInfo);
                                 
                     			request.setAttribute("dealInfo", dealInfo);

                     		 	session.setAttribute("book_deal_to", to);
                     			return mapping.findForward("confirmation");
                        		 
                        	 }else{
                        		 session.setAttribute("dealInfo", dealInfo);
     						     return mapping.findForward("search_deals");
                        	 }
                        	 
                        }
                        else if(userInfo.getRoleId() == TangotabConstants.RESTAURANT_OWNER ||
                        		userInfo.getRoleId() == TangotabConstants.RESTAURANT_STORE_MANAGER){
                        	dealInfo = locationBO.getDealByDealId(dealId);
                        	session.setAttribute("dealInfo", dealInfo);
                        	return mapping.findForward("edit_deal");
                        }
                        	
					} else if (userInfo.getIsPwdChange() == 1) {

						return mapping.findForward("resetPassword");
					}

					switch (userInfo.getRoleId()) {
					case TangotabConstants.ADMIN_ROLE:
						page = TangotabConstants.ADMIN;
						break;
					case TangotabConstants.SALES_MANAGER_ROLE:
					case TangotabConstants.SALES_REPRESENTATIVE_ROLE:
						break;
					case TangotabConstants.CONSUMER_ROLE: {
					/*	if(userInfo.getConsumerReferrals().size() < 1)
							page = "consumerRefer";
						
						else if (userInfo.getAddress1() == null || userInfo.getMobilePhone() == null
								|| userInfo.getHomePhone() == null || userInfo.getGender() == null
								|| userInfo.getAge() == 0 || userInfo.getCityId() == null
								|| userInfo.getStateId() == 0 || userInfo.getCountryId() == 0
								|| userInfo.getAddress().isEmpty()
								|| userInfo.getMobilePhone().isEmpty()
								|| userInfo.getHomePhone().isEmpty()
								|| userInfo.getGender().isEmpty() || userInfo.getAge() == 0
								|| userInfo.getCityId().isEmpty() || userInfo.getStateId() == 0
								|| userInfo.getCountryId() == 0
								|| userInfo.getConsumerPreferCity() == null
								|| userInfo.getPreferencesList() == null
								|| userInfo.getConsumerPreferCity().getCity().getCityId() == 0) {

							userBo.setUserConsumerStatus(userInfo.getEmailId(), (short) 0,
									TangotabConstants.CONSUMER_ROLE);
							// if user cann't fill total profile
						//	page = "consumerfirst";
							page = TangotabConstants.CONSUMER;
						} else  */
							page = TangotabConstants.CONSUMER;
						/*
						 * This code should be moved to another class after getting deals.jsp
						 */
					}
						break;
					case TangotabConstants.RESTAURANT_OWNER: {
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
						page = TangotabConstants.RESTARRANT;
						break;
					}
				} else {
					actionMessages.add("InvalidLogin", new ActionMessage("errors.invalidLogin",
							"User Name/Password"));
					saveMessages(request, actionMessages);
					return mapping.findForward(page);
				}
			} /* Will go to switch profile page */ 
			else if (null != users && users.size() > 1) {
				session.removeAttribute("userInfo");
				session.setAttribute("profileUsers", users);
				if (user.getDealId() != 0)
					request.setAttribute("dealId", Integer.valueOf(user.getDealId()));
				if(StringUtils.isNotEmpty(user.getDate()))
					request.setAttribute("date", user.getDate());
				if(StringUtils.isNotEmpty(request.getParameter("bypass")))
					request.setAttribute("bypass", request.getParameter("bypass"));
				
				return mapping.findForward("switchProfile");
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

	private boolean isCookieSet(HttpServletRequest request, String cookie_name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookie_name)) {
					return true;
				}
			}
		}
		return false;
	}
}
