package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;
import org.json.JSONException;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.UserBOImpl;
import com.tangotab.dao.pojo.Role;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;


public class WelcomeTangoTabAction extends Action {
	
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		String emailId = request.getParameter("email");
		 HttpSession session = request.getSession(true);
		
		String signedRequest =request.getParameter("signedRequest");
		  //signedRequest =  "JSH_AAfbeMK1XlnvtJFy4j31xVEhkGd5DEvUTj3oxZY.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImNvZGUiOiIyLkFRQmJaSTdoR3FDVUF4cU4uMzYwMC4xMzQyNzEwMDAwLjEtMTAwMDAyMjY3MDAyNzU3fHRKeGV3YlN3RGt0aThYRW90VUZRUXV0UjdxRSIsImlzc3VlZF9hdCI6MTM0MjcwMjk4MiwidXNlcl9pZCI6IjEwMDAwMjI2NzAwMjc1NyJ9";
		 try {  
	     String payload = signedRequest.split("[.]", 2)[1];
	     payload = payload.replace("-", "+").replace("_", "/").trim();
	     payload = new String(Base64.decodeBase64(payload.getBytes()));
	     JSONObject payloadObject;
		
		 payloadObject = new JSONObject(payload);
	    
         JSONObject payloadObject1 = new JSONObject(payloadObject.get("registration").toString());//Retrieve oauth token
         emailId = (payloadObject1.get("email").toString());
        // userForm.setZipCode(payloadObject1.get("zipcode").toString());
        // userForm.setPassword(TangoTabUtility.generateRandomCode());
         String fullname=payloadObject1.get("name").toString();
         String name[]=fullname.split(" ");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	     if(userBo.checkUserAvailability(emailId, 4))
	     {
	    	 //login user
	    	 try{
	    	 ArrayList<User> users=userBo.getUserById(emailId);
	    		    	
	    	 UserTO userInfo=new UserTO();
	    	 for(User cuser:users){
					if(cuser.getRole().getRoleId() == TangotabConstants.CONSUMER_ROLE){
						 BeanUtils.copyProperties(userInfo, cuser);
						 BeanUtils.copyProperties(userInfo, cuser.getRole());
					}
	    	 }
	    	 session.setAttribute("userInfo", userInfo);
	    	 }catch (Exception e) {
				// TODO: handle exception
			}
	    	  return mapping.findForward(TangotabConstants.SUCCESS);
	     } 
	     else	{	
	    	 // registration process	    	 
	    	 
	    	 User user = new User();
	    	 
	    	 try {
	    		 // Getting data from JSONObject
				user.setEmailId(emailId);
				user.setPassword(TangoTabUtility.generateRandomCode());
				user.setRoleId(TangotabConstants.CONSUMER_ROLE);
				user.setFirstname(request.getParameter("fullname"));
				user.setGender(request.getParameter("gen"));
				user.setConsumerPreferCity(null);
				
				user=	userBo.saveConsumer(user);
				UserTO userInfo=new UserTO();
				BeanUtils.copyProperties(userInfo, user);
				BeanUtils.copyProperties(userInfo, user.getRole());
				session.setAttribute("userInfo", userInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
		     return mapping.findForward(TangotabConstants.SUCCESS);
	}
	}

}
