package com.tangotab.web;

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

import com.tangotab.exception.ApplicationException;

public class ForgotPasswordAction extends Action {
	private Logger log = LoggerFactory.getLogger(ForgotPasswordAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isDebugEnabled())
			log.debug("start of execute in ForgotPasswordAction");
		ActionMessages messages = new ActionMessages();
		DynaActionForm page = (DynaActionForm) form;

		String emailId = (String) page.get("emailId");
		if (emailId != null && emailId.trim().length() > 0) {
			try {
				boolean status = com.tangotab.businessImpl.BusinessFactory.getUserBO().forgotPassword(emailId);
				com.tangotab.businessImpl.BusinessFactory.getUserBO().setUserPwdStatus(emailId, (short) 1);
				if (status) {
					return mapping.findForward("success");
				} else {
					messages.add("InvalidEmail", new ActionMessage("InvalidEmail"));
					saveMessages(request, messages);
				}
			} catch (ApplicationException e) {
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
