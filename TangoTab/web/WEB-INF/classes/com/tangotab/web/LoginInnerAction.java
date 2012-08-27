package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class LoginInnerAction extends Action {
	private Logger log = LoggerFactory.getLogger(LoginAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		String page = "innerlogin";
		HttpSession session = request.getSession(true);
		ActionMessages actionMessages = new ActionMessages();
		try {
			LoginForm user = (LoginForm) form;
			String userName = user.getEmailId();
			String password = user.getPassword();
			ArrayList<UserTO> users = userBo.getProfiles(userName, password);
			if (null != users && users.size() == 1) {
				UserTO userInfo = users.get(0);
				if(userInfo.getRoleId()==TangotabConstants.RESTAURANT_OWNER )
				{
					if(userInfo.getRestaurent().getIsActivated()!=TangotabConstants.ACTIVE)
					{
					actionMessages.add("InvalidLogin", new ActionMessage("errors.suspend",
					"Your account is suspended,please contact TangoTab Administrator."));
			saveMessages(request, actionMessages);
			return mapping.findForward(page);
					}
				}else if(userInfo.getRoleId()==TangotabConstants.RESTAURANT_STORE_MANAGER )
				{
					if(userInfo.getRestaurantLocation().getRestaurant().getIsActivated()!=TangotabConstants.ACTIVE)
					{
					actionMessages.add("InvalidLogin", new ActionMessage("errors.suspend",
					"Your account is suspended,please contact TangoTab Administrator."));
			saveMessages(request, actionMessages);
			return mapping.findForward(page);
					}
				 
				}
				if (userInfo != null) {
					if (userInfo.getIsActive() == 0) {
						actionMessages.add("InvalidLogin", new ActionMessage("errors.autherized"));
						saveMessages(request, actionMessages);
						return mapping.findForward(page);
					}
					Integer dealId = user.getDealId();
					session.removeAttribute("profileUsers");

					session.setAttribute("userInfo", userInfo);

					if (null != dealId && dealId != 0) {
						DealTO dealTo = new DealTO();
						dealTo.setTobeBookedDealId(dealId);
						dealTo.setLoginUserId(userInfo.getUserId());
						DealTO dealInfo = userBo.fetchDealByDealId(dealId);
						
						BookDealTO to = userBo.bookDeal(userInfo.getUserId(), dealId, dealInfo);

						actionMessages.add("bookdeal",
								new ActionMessage("Deal Booked Successfully"));
						saveMessages(request, actionMessages);

						session.setAttribute("book_deal_to", to);

						return mapping.findForward("search_deals");
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
						if(userInfo.getConsumerReferrals().size() < 1)
							page = "consumerRefer";
						else if (userInfo.getIsPwdChange() == 2) {
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
						int noOfEnteredLocations = userBo.getNoOfEnteredLocations(userInfo
								.getRestaurantId());
						userInfo.setNoOfEnteredLocatios(noOfEnteredLocations);
						if (userInfo.getBillingMethodId() == 1 && userInfo.getCurrentCredits() <= 0) {
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
			} else if (null != users && users.size() > 1) {
				session.removeAttribute("userInfo");
				session.setAttribute("profileUsers", users);
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

}
