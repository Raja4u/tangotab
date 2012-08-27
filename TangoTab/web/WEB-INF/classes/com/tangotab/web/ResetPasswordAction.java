package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.web.form.ResetPasswordForm;

public class ResetPasswordAction extends BaseAction {
	private Logger log = LoggerFactory.getLogger(ResetPasswordAction.class);

	@Override
	@SuppressWarnings("unchecked")
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (log.isDebugEnabled())
			log.debug("start of execute in ForgotResetPasswordAction");
		ActionMessages messages = new ActionMessages();
		ResetPasswordForm page = (ResetPasswordForm) form;
		ArrayList<UserTO> users = null;
		HttpSession session = request.getSession();

		if (page.getType() != null) {
			if (page.getType().equalsIgnoreCase("reset_password")) {
				String emailId = page.getEmailId();
				String currentPassword = page.getPassword();
				String newPassword = (String) page.getNewPassword();
				String confirmNewPassword = (String) page.getConfirmPassword();

				if (newPassword.equals(confirmNewPassword)) {
					if (!currentPassword.equals(newPassword)) {
						UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
						/* For host, additional hosts also need to be informed*/
						
						boolean status = false;
						try {
							status = userBo.resetPassword(emailId, currentPassword, newPassword);
							userBo.setUserPwdStatus(emailId, (short) 0);

							if (status) {

								ArrayList<UserTO> usersnew = new ArrayList<UserTO>();
								users = (ArrayList<UserTO>) session.getAttribute("profileUsers");
								if (users != null) {
									for (UserTO user : users) {
										user.setIsPwdChange(Short.parseShort("0"));
										usersnew.add(user);
									}
									session.removeAttribute("profileUsers");
									session.setAttribute("profileUsers", usersnew);
								}
								return mapping.findForward("success");
							} else {
								messages.add("NotValidPassword", new ActionMessage(
										"NotValidPassword"));
								saveMessages(request, messages);
							}
						} catch (ApplicationException e) {
							messages.add("CantSaveRecord", new ActionMessage("CantSaveRecord"));
							saveMessages(request, messages);
						}
					} else {
						messages.add("oldNewPasswordsCantBeSame", new ActionMessage(
								"oldNewPasswordsCantBeSame"));
						saveMessages(request, messages);
					}
				} else {
					messages.add("passwordsShouldBeSame",
							new ActionMessage("passwordsShouldBeSame"));
					saveMessages(request, messages);
				}
			} else if (page.getType().equalsIgnoreCase("forgot_password")) {

			} else {
				messages.add("InvalidRequest", new ActionMessage("InvalidRequest"));
				saveMessages(request, messages);
			}
		} else {
			messages.add("InvalidRequest", new ActionMessage("InvalidRequest"));
			saveMessages(request, messages);
		}

		if (log.isDebugEnabled())
			log.debug("End of execute in ForgotResetPasswordAction");
		return mapping.findForward("failure");
	}
}
