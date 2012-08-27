package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.HomeSignUp;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.HomeSignUpForm;

public class HomeSignUpAction extends Action {
	private Logger log = LoggerFactory.getLogger(LoginAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	 

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("start of Home Sign Up");
		}
		String page = TangotabConstants.SUCCESS;
 
		ActionMessages actionMessages = new ActionMessages();
		try {
			HomeSignUpForm homeSignUpForm=(HomeSignUpForm)form;
			 HomeSignUp homeSignUp=new HomeSignUp();
			 
				homeSignUp.setEmailId(homeSignUpForm.getEmailId());
				homeSignUp.setPreferCity(homeSignUpForm.getPreferCity());
				java.sql.Timestamp timestamp= new java.sql.Timestamp(new java.util.Date().getTime());
			 
				homeSignUp.setSignupDate(timestamp);
			 
	if(homeSignUpForm.getEmailId()!=null && !userBo.checkUserAvailability(homeSignUpForm.getEmailId(), 4) 
			&& !userBo.checkUserAvailability(homeSignUpForm.getEmailId(), 5)   && !userBo.checkUserAvailability(homeSignUpForm.getEmailId(), 6) )
			userBo.saveHomeUser(homeSignUp);
			
			 
		} catch (ApplicationException e) {
			e.printStackTrace();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(page);
		}

		return mapping.findForward(page);

	}

 
}
