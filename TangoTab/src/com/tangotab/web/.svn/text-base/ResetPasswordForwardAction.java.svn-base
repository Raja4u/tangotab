package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.util.TangoTabPasswordEncrypt;
import com.tangotab.web.form.ResetPasswordForm;

public class ResetPasswordForwardAction extends BaseAction {
	private Logger log = LoggerFactory.getLogger(ResetPasswordAction.class);

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isDebugEnabled())
			log.debug("start of execute in ForgotResetPasswordAction");

		int userId = 0;
		ResetPasswordForm passwordForm = (ResetPasswordForm) form;
		if (request.getParameter("userId") != null) {
			try {
				userId = Integer.parseInt(request.getParameter("userId"));
				UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();
				UserTO user = userBO.getUserByUserId(userId);
				passwordForm.setEmailId(user.getEmailId());
				passwordForm.setPassword(TangoTabPasswordEncrypt.getPasswordDecrypt(user
						.getPassword()));
				request.setAttribute("ResetPasswordForm", passwordForm);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (log.isDebugEnabled())
			log.debug("End of execute in ForgotResetPasswordAction");
		return mapping.findForward("success");
	}
}
