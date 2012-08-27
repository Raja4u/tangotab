package com.tangotab.web;

import java.util.Iterator;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.DealTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.User;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;

public class FaceRegAction extends Action {
	public static Logger log = LoggerFactory.getLogger(FaceRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String regType = TangotabConstants.CONSUMER;
		String page=TangotabConstants.CON_SUCCESS;
		
		UserForm userForm = (UserForm) form;
		User user = new User();
		ActionMessages messages = new ActionMessages();
		int roleId = 1;
		 
			roleId = TangotabConstants.CONSUMER_ROLE;
		 /*
		  * 
		  * facebook code added
		  */
			 Cookie cookie[] = request.getCookies();
			 if(cookie != null && cookie.length > 1){
				 for(Cookie cook: cookie){
				 if(cook.getName().equals("landing")){
					 try{
					 if(StringUtils.isNotEmpty(cook.getValue()))
						 userForm.setRefferCode(Integer.parseInt(cook.getValue()));
					 }catch(NumberFormatException nfe){
						 nfe.printStackTrace();
					 }
				 }
				 }
			 }
			 String signedRequest =request.getParameter("signed_request");// "iqIlIl5PcRTC4CNLdwnBUsBuEe3-ukuSjxIZ0wD_4DQ.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjEzMjkzOTAwMDAsImlzc3VlZF9hdCI6MTMyOTM4NDU1NSwib2F1dGhfdG9rZW4iOiJBQUFCbmtEMGl1YWdCQVA1a0d1QjJyTlRlVWJscVdlSURSSmlMVDQ4WVl3djhXZ1pDNnhkSEhmSFFNWkNMOEdyUVdycVpDNDFVUDlGWUhCNlR5SVlsaWRPM0daQjZxWXdrVnpNQWlsWE5YcUxZMTV3VEJ4Zm4iLCJyZWdpc3RyYXRpb24iOnsibmFtZSI6IlJhdGhuYWthciBSZWRkeSBQIiwiZW1haWwiOiJwLnJhdGhuYWthcnJlZGR5XHUwMDQwZ21haWwuY29tIn0sInJlZ2lzdHJhdGlvbl9tZXRhZGF0YSI6eyJmaWVsZHMiOiJuYW1lLGVtYWlsIn0sInVzZXIiOnsiY291bnRyeSI6ImluIiwibG9jYWxlIjoiZW5fVVMifSwidXNlcl9pZCI6IjEzNTc4Njk2NjIifQ";
		     String payload = signedRequest.split("[.]", 2)[1];
		     payload = payload.replace("-", "+").replace("_", "/").trim();
		       payload = new String(Base64.decodeBase64(payload.getBytes()));
	 	     try 
		     {
		         JSONObject payloadObject = new JSONObject(payload);

		         JSONObject payloadObject1 = new JSONObject(payloadObject.get("registration").toString());//Retrieve oauth token
		         userForm.setEmailId(payloadObject1.get("email").toString());
		         userForm.setZipCode(payloadObject1.get("zipcode").toString());
		         userForm.setPassword(TangoTabUtility.generateRandomCode());
		         String fullname=payloadObject1.get("name").toString();
		         String name[]=fullname.split(" ");
		         if(name!=null && name.length>1)
		         {
		        	 userForm.setFirstname(name[0]);
		        	 if(name.length>=2)
		        	 {
		        		 userForm.setLastname(fullname.substring(fullname.indexOf(" "),fullname.length()));
		        	 }else 
		        	 userForm.setLastname("");
		        	 
		         }else 
		         {
		        	 userForm.setFirstname(fullname.toString());
		        	 userForm.setLastname("");
		         }
		    
		     } 
		     catch (JSONException e) 
		     {
		         e.printStackTrace();
		     
		     }
		     /*
		      * 
		      * ended
		      */
		if (userBo.checkUserAvailability(userForm.getEmailId(), roleId)) {
			messages.add("message", new ActionMessage("errors.emailexist", "Email already exists"));
			saveMessages(request, messages);
			 
				return mapping.findForward(TangotabConstants.CON_FAILURE);
			 
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
				ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
				consumerPreferCity.setUser(user);
				City city = new City();
				city.setCityId(userForm.getPreferCity());
				consumerPreferCity.setCity(city);
				user.setConsumerPreferCity(null);
				String validcode = "";
				/*  source 2 -- for Face book */
				user.setSignup_from((short)2);
				
				user=	userBo.saveConsumer(user);
				
				UserTO userInfo=new UserTO();
				if(user.getUserId()!=0)
				{
					HttpSession session = request.getSession(true);
					BeanUtils.copyProperties(userInfo, user);
					BeanUtils.copyProperties(userInfo, user.getRole());
					session.setAttribute("userInfo", userInfo);
					if(session.getAttribute("dealID")!=null)
					{
						Integer dealId = 0;
					dealId=(Integer) (Object)session.getAttribute("dealID");
				 
					session.removeAttribute("dealID");
					
					if (null != dealId && dealId != 0) {
						DealTO dealTo = new DealTO();
						dealTo.setTobeBookedDealId(dealId);
						dealTo.setLoginUserId(userInfo.getUserId());
												
						  LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
						DealTO dealInfo = new DealTO();
						
	                    if(userInfo.getRoleId() == TangotabConstants.CONSUMER_ROLE)
	                    {
	                    	 dealInfo = userBo.fetchDealByDealId(dealId);
	                    	 session.setAttribute("dealInfo", dealInfo);
						    return mapping.findForward("search_deals");
	                    }
	                    else if(userInfo.getRoleId() == TangotabConstants.RESTAURANT_OWNER ||
	                    		userInfo.getRoleId() == TangotabConstants.RESTAURANT_STORE_MANAGER){
	                    	dealInfo = locationBO.getDealByDealId(dealId);
	                    	session.setAttribute("dealInfo", dealInfo);
	                    	return mapping.findForward("edit_deal");
	                    }
	                    	
					} 
					}
				}
			} catch (Exception e) {
//				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.CON_FAILURE);
			}
		}  
		return mapping.findForward(page);
	}
}