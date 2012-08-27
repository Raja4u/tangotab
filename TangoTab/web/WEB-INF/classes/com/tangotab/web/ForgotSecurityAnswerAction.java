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

import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;

public class ForgotSecurityAnswerAction extends Action {
	private Logger log = LoggerFactory.getLogger(ForgotPasswordAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isDebugEnabled())
			log.debug("start of execute in ForgotPasswordAction");
		ActionMessages messages = new ActionMessages();
		String emailId = request.getParameter("email");
		String random = request.getParameter("rand");
		
		String type = request.getParameter("type");

		if (type != null && (type.equals("matched") || type.equals("resend"))) {
			/*
			 * if the user enters the right answer then redirect to successful page or if the user
			 * requested for resending the mail to inbox
			 */
			boolean status = false;
			String chance = "yes";
			try {
				
				status = com.tangotab.businessImpl.BusinessFactory.getUserBO().forgotPassword(emailId);
				boolean flag = com.tangotab.businessImpl.BusinessFactory.getUserBO().setUserPwdStatus(emailId, (short) 1);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (type.equals("matched"))
				chance = "yes";
			else if (type.equals("resend"))
				chance = "no";
			if (status) {
				request.setAttribute("emailId", emailId);
				request.setAttribute("chance", chance);
				return mapping.findForward("success");
			}

		} else if (type != null && type.equals("next")) {
			/*
			 * if user comes for next question the redirect to security questions page again set
			 * random to another so that the next question wil display in the page
			 */
			User user = (User) (com.tangotab.businessImpl.BusinessFactory.getUserBO().getQuestionsByEmail(emailId, 5));
			if (random.equals("0"))
				random = "1";
			else if (random.equals("1"))
				random = "0";
			messages.add("message", new ActionMessage("result.noRecords",
					"Incorrect answer. Please try again"));
			saveMessages(request, messages);
			request.setAttribute("user", user);
			request.setAttribute("rand", Integer.parseInt(random));
			request.setAttribute("emailId", emailId);
			request.setAttribute("type", type);
			return mapping.findForward("securityquest");
		} else if (type != null && type.equals("failed")) {
			try {
				boolean flag = com.tangotab.businessImpl.BusinessFactory.getUserBO().setUserStatus(emailId, Short.parseShort("0"), 5);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return mapping.findForward("hostblock");
		}

		if (log.isDebugEnabled())
			log.debug("End of execute in ForgotPasswordAction");
		return mapping.findForward("failure");
	}
}
