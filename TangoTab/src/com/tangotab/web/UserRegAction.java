package com.tangotab.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
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
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;

public class UserRegAction extends Action {
	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	ActionMessages actionMessages = new ActionMessages();

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String regType = request.getParameter((mapping.getParameter()));
		String page;
		UserForm userForm = (UserForm) form;
		User user = new User();
		ActionMessages messages = new ActionMessages();
		int roleId = 1;
		if (regType.equalsIgnoreCase(TangotabConstants.CONSUMER)) {
			roleId = TangotabConstants.CONSUMER_ROLE;
		} else
			roleId = TangotabConstants.RESTAURANT_OWNER;

		if (userBo.checkUserAvailability(userForm.getEmailId(), roleId)) {
			messages.add("message", new ActionMessage("errors.emailexist", "Email already exists"));
			saveMessages(request, messages);
			if (regType.equalsIgnoreCase(TangotabConstants.CONSUMER)) {
				return mapping.findForward(TangotabConstants.CON_FAILURE);
			} else {
				return mapping.findForward(TangotabConstants.CLIENT_FAILURE);
			}
		}
		try {
			BeanUtils.copyProperties(user, userForm);
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		if (regType.equalsIgnoreCase(TangotabConstants.CONSUMER)) {
			try {
				log.debug("refferedurl1", user.getRefferedUrl());
				/* If any problem occurs while saving the user, then return to failure */
				try{
					if(!StringUtils.isNotEmpty(user.getRefferedUrl())){
					/* Getting ErrorUrl From cookies and saving as source while registration  */
					Cookie[] ck=request.getCookies();
					for(int i=0;i<ck.length;i++)
					{
						if(ck[i].getName().equals("ErrorUrl"))
					   		user.setRefferedUrl(ck[i].getValue());
						log.debug("refferedurloop", user.getRefferedUrl());
					}
					
					}
				ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
				consumerPreferCity.setUser(user);
				City city = new City();
				city.setCityId(userForm.getPreferCity());
				consumerPreferCity.setCity(city);
				if(userForm.getPreferCity()==0)
					user.setConsumerPreferCity(null);
				else
				user.setConsumerPreferCity(consumerPreferCity);
				String validcode = "";
			   user.setSignup_from((short)0);
			   if(StringUtils.isNotEmpty(user.getRefferedUrl())){
			   user.setRefferedUrl(user.getRefferedUrl().replace(TangoTabUtility.getTangoTabResourceBundle()
						.getString(TangotabConstants.TANGO_TAB_WEB_SITE_HOME), "")); 
			   user.setRefferedUrl(user.getRefferedUrl().replace("http://tangotab.com/", "")); 
			   user.setRefferedUrl(user.getRefferedUrl().replace(request.getContextPath(), "")); 
			   user.setRefferedUrl(user.getRefferedUrl().replace("jsp/", ""));  

			   user.setRefferedUrl(user.getRefferedUrl().replace("mobile/", ""));
			   user.setRefferedUrl(user.getRefferedUrl().replace("#", ""));
			   user.setRefferedUrl(user.getRefferedUrl().replace("/", "-"));
			   user.setRefferedUrl(user.getRefferedUrl().replace("?", "-"));
			   if(user.getRefferedUrl().lastIndexOf('-')==(user.getRefferedUrl().length()-1)){
                   user.setRefferedUrl(user.getRefferedUrl().substring(0, (user.getRefferedUrl().length()-1)));
              }

			  }
			   /* logic to get source from dealsummary link where it is set in cookie */
			   if((userForm.getRefferCode() == null || userForm.getRefferCode() == 0) && StringUtils.isEmpty(userForm.getRefferedUrl())){
				   String dealSummarySource = request.getParameter("dealsource");
				   if(StringUtils.isNotEmpty(dealSummarySource))
					   user.setRefferedUrl(dealSummarySource);
				   
			   }
			   
			   log.debug("refferedurl", user.getRefferedUrl());
			   user =	userBo.saveConsumer(user);
			}catch(Exception e){
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.CON_FAILURE);
			}
			/* After successfull saving, if any problem , then send to searchdeals page */
			
			/* check whether the registration is from mobile page */
			   String device = request.getParameter("device");
			   if(StringUtils.isNotEmpty(device)){
				   if(device.equalsIgnoreCase("iPhone") || device.equalsIgnoreCase("iPad") || device.equalsIgnoreCase("iPod") ){
					   request.setAttribute("device", device);
					   return mapping.findForward("itunes_page");
				   }
				   else
					   return mapping.findForward("itunes_page"); 
			   }
			UserTO userInfo=new UserTO();
			if(user.getUserId()!=0)
			{
				HttpSession session = request.getSession(true);
				BeanUtils.copyProperties(userInfo, user);
				BeanUtils.copyProperties(userInfo, user.getRole());
				session.setAttribute("userInfo", userInfo);
				/* This is for sharing any friend */
				String share = request.getParameter("share");
				if(StringUtils.isNotEmpty(share) && share.equals("true") && userInfo.getRoleId() == TangotabConstants.CONSUMER_ROLE){
					return mapping.findForward(TangotabConstants.FRIEND);
				}
				if(session.getAttribute("dealID")!=null)
				{
					Integer dealId = 0;
					String date = "";
				dealId=(Integer) (Object)session.getAttribute("dealID");
				date = (String) session.getAttribute("date");
			 
				session.removeAttribute("dealID");
				
				if (null != dealId && dealId != 0) {
					DealTO dealTo = new DealTO();
					dealTo.setTobeBookedDealId(dealId);
					dealTo.setLoginUserId(userInfo.getUserId());
											
					  LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
					DealTO dealInfo = new DealTO();
					
                    if(userInfo.getRoleId() == TangotabConstants.CONSUMER_ROLE)
                    {
                    	if(StringUtils.isNotEmpty(date))
                       	   dealInfo = userBo.fetchDealByDealId(dealId, date);
                       	 else
                       		 dealInfo = userBo.fetchDealByDealId(dealId);

               		 long count = 0;
               		 count = userBo.countBookedDeals(userInfo.getUserId(), dealId);
               		 /* If  limit is exceeded, then dont book the offer, just show offer details page */
                        if(count >= 5){
                        	actionMessages.add("No Records", new ActionMessage("result.noRecords",
                    				"Sorry you have exceeded the maximum number of reservations for today." +
                    				" If you have reserved an offer by mistake, please check your inbox to ensure that your " +
                    				"confirmation has not been placed in the junk folder. Furthermore, please let us know ASAP so we may cancel any reservations made in error."));
                    		       saveMessages(request, actionMessages);
                    		       request.setAttribute("dealInfo", dealInfo);
                    		       return mapping.findForward("search_deals");
                        }else {
                        	count = userBo.countBookedDealsPerDate(userInfo.getUserId(), dealId, dealInfo.getStartDate());
                        	if(count >= 1){
                        		
                        		actionMessages.add("No Records", new ActionMessage("result.noRecords",
                        				"You have already reserved this offer today. If you have not received your reservation confirmation number," +
                        				" please check your spam folder or you can retrieve the reservation code from your account profile." +
                        				" If you are trying to reserve this great offer for your friends, kindly ask them to join and reserve " +
                        				"the offer as it is FREE to join."));
                        		     
                        		       saveMessages(request, actionMessages);
                        		       request.setAttribute("dealInfo", dealInfo);
                        		       return mapping.findForward("search_deals");
                        	}
                        }
                        /* set the url to share in fb and twitter */
                       if(StringUtils.isNotEmpty(request.getParameter("compressedURL")))
                    	   dealInfo.setCompressedURL(request.getParameter("compressedURL"));
            			BookDealTO to = userBo.bookDeal(userInfo.getUserId(), dealId, dealInfo);
                        
            			request.setAttribute("dealInfo", dealInfo);

            		 	session.setAttribute("book_deal_to", to);
            			return mapping.findForward("confirmation");
               		                     	
                    }
                    else if(userInfo.getRoleId() == TangotabConstants.RESTAURANT_OWNER ||
                    		userInfo.getRoleId() == TangotabConstants.RESTAURANT_STORE_MANAGER){
                    	dealInfo = locationBO.getDealByDealId(dealId);
                    	session.setAttribute("dealInfo", dealInfo);
                    	return mapping.findForward("edit_deal");
                    }
                    	
				} 
				}
				
				/* If new User Signs up */
				session.setAttribute("isSignUp", true);
				/* If the new User sings up from Landing page then set imagePath url in session*/
				String imagePath="";
				if(user.getRefferedUrl() != null && user.getRefferedUrl() != "")
				{
					imagePath = userBo.getLandingBySource(user.getRefferedUrl()).getUrl();
				}
				else if(user.getRefferCode() > 0)
				{
					imagePath = userBo.getLandingByRefferCode(user.getRefferCode()).getUrl();
				}
				if(imagePath != null && imagePath != "")
					session.setAttribute("imagePath", imagePath); 
			  //System.out.print("imagepath: "+imagePath);
			}
				/*Iterator<UserValidationCode> usercode = user.getUserValidationCodes().iterator();
				while (usercode.hasNext()) {
					UserValidationCode code = usercode.next();
					validcode = code.getValidationCode();
				}
				request.setAttribute("code", validcode);
				request.setAttribute("firstname", user.getFirstname());
				request.setAttribute("emailId", user.getEmailId());
				request.setAttribute("password", user.getPassword());*/
				page = TangotabConstants.CON_SUCCESS;
								
				/* IF the registration from landing page
				HttpSession se=request.getSession(true);
				if( ( user.getRefferedUrl().indexOf(TangotabConstants.CACTUS1) !=-1) || ( user.getRefferCode() == 1060 ) )
				{

					se.setAttribute("imagePath", "http://www.searchcactus.com/tpixl.asp?offer=1077505");
				}
				if( ( user.getRefferedUrl().indexOf("cotterweb1") !=-1) || ( user.getRefferCode() == 1061 ) )
				{
					se.setAttribute("imagePath", "https://partners.cotterweb.net/track_lead/11257/OPTIONAL_INFORMATION");
				} */

				
			} catch (Exception e) {
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.CON_SUCCESS);
			}
		} else {
			try {
				int consumerId = userBo.saveRestaurantClient(user);
				page = TangotabConstants.CLIENT_SUCCESS;
				request.setAttribute("roleId", roleId);
				UserTO userTO = userBo.getUserByUserId(consumerId);
				HttpSession session = request.getSession(true);
				session.setAttribute("userInfo", userTO);
				request.setAttribute("userInfo", userTO);
			} catch (ApplicationException e) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.CLIENT_FAILURE);
			}
		}
		return mapping.findForward(page);
	}
}