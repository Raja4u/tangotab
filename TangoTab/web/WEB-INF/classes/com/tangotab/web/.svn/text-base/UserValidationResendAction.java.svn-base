package com.tangotab.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.dao.pojo.User;

public class UserValidationResendAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		User user = new User();
		ActionMessages messages = new ActionMessages();
		String toemail = request.getParameter("toemail");
		if (toemail == null || (toemail != null && toemail.length() < 1)) {
			request.setAttribute("code", "code");
			messages.add("message", new ActionMessage("result.noRecords", "Please try again."));
			saveMessages(request, messages);
			return mapping.findForward("failure");
		}
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = toemail;
		// Make the comparison case-insensitive.
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {

			String emailId = request.getParameter("emailId");
			String firstname = request.getParameter("firstname");
			String password = request.getParameter("password");
			String code = request.getParameter("code");
			user.setEmailId(emailId);
			user.setPassword(password);
			user.setFirstname(firstname);
			boolean status = false;
			status = com.tangotab.businessImpl.BusinessFactory.getUserBO().resendValidationEmail(user, toemail, code);
			if (status) {
				/* set to differ the text in success page */
				request.setAttribute("resent", "resent");
				return mapping.findForward("success");
			}
		}
		request.setAttribute("code", "code");
		messages.add("message", new ActionMessage("result.noRecords",
				"Please enter valid email id."));
		saveMessages(request, messages);
		return mapping.findForward("failure");

	}

}
