package com.tangotab.web;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.dao.pojo.User;

public class ForgotPasswordRedirectAction extends Action {
	private Logger log = LoggerFactory.getLogger(ForgotPasswordAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isDebugEnabled())
			log.debug("start of execute in ForgotPasswordAction");
		ActionMessages messages = new ActionMessages();
		DynaActionForm page = (DynaActionForm) form;
		ArrayList<String> roles = null;
		roles = new ArrayList<String>();
		User user = new User();

		String emailId = (String) page.get("emailId");
		if (emailId != null && emailId.trim().length() > 0) {
			try {
				roles = com.tangotab.businessImpl.BusinessFactory.getUserBO().getRolesByEmail(emailId); // getting roleids for that
																	// emailId
				if (roles.size() > 0) {
					for (Object s : roles) {
						if (s.toString().equals("5")) // test if one of his role is Host then
														// redirect to security page
						{
							/* get security questions for tat emailId and roleId */
							user = (User) (com.tangotab.businessImpl.BusinessFactory.getUserBO().getQuestionsByEmail(emailId, 5));
							Random rand = new Random();
							int num = rand.nextInt(2);

							request.setAttribute("user", user);
							request.setAttribute("rand", num);
							request.setAttribute("emailId", emailId);
							return mapping.findForward("securityquest");
						}
					}
					/* for all others assign a new password */
					boolean status = com.tangotab.businessImpl.BusinessFactory.getUserBO().forgotPassword(emailId);
					boolean flag = com.tangotab.businessImpl.BusinessFactory.getUserBO().setUserPwdStatus(emailId, (short) 1);
					if (status) {
						String chance = "yes";
						request.setAttribute("chance", chance);
						request.setAttribute("emailId", emailId);
						return mapping.findForward("success");
					}
				} else {
					messages.add("InvalidEmail", new ActionMessage("InvalidEmail"));
					saveMessages(request, messages);
				}
			} catch (Exception e) {
				messages.add("EMAIL001", new ActionMessage("EMAIL001"));
				saveMessages(request, messages);
			}
		} else {
			messages.add("InvalidEmail2", new ActionMessage("InvalidEmail2"));
			saveMessages(request, messages);
		}

		if (log.isDebugEnabled())
			log.debug("End of execute in ForgotPasswordAction");
		return mapping.findForward("failure");
	}
}
