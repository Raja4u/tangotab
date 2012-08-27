/**
 * 
 */
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

import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LoginForm;

/**
 * @author user2
 * 
 */
public class VerifyValidationAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String targetAction = new String("failure");
		ActionMessages messages = new ActionMessages();
		try {
			DynaActionForm dynaForm = (DynaActionForm) form;
			String password = (String) dynaForm.get("password");
			String code = (String) dynaForm.get("code");
			String emailid = (String) dynaForm.get("emailId");
			String vtype = (String) dynaForm.get("vtype");
			String roleId = (String) dynaForm.get("roleId");
			if (!password.equals("")) {
				boolean status = com.tangotab.businessImpl.BusinessFactory.getUserBO().verifyValidationCode(emailid, password, roleId,
						code);
				/*	
			
			
			*/

				if (status) {
					targetAction = "success";
					try {
						LoginAction loginAction = new LoginAction();
						LoginForm loginForm = new LoginForm();
						loginForm.setEmailId(emailid);
						loginForm.setPassword(password);
						return loginAction.execute(mapping, loginForm, request, response);
					} catch (Exception e) {

						targetAction = "failure";
						request.setAttribute("code", code);
						request.setAttribute("emailid", emailid);
						request.setAttribute("vtype", vtype);
						request.setAttribute("roleId", roleId);
						request.setAttribute("msg", "Invalid password."
								+ " Please enter the password you chose when you registered.");
						return mapping.findForward(targetAction);
					}
				} else {
					targetAction = "failure";
					request.setAttribute("code", code);
					request.setAttribute("emailid", emailid);
					request.setAttribute("vtype", vtype);
					request.setAttribute("roleId", roleId);
					request.setAttribute("msg", "Invalid password."
							+ " Please enter the password you chose when you registered.");
				}
			} else {
				targetAction = "failure";
				request.setAttribute("code", code);
				request.setAttribute("emailid", emailid);
				request.setAttribute("vtype", vtype);
				request.setAttribute("roleId", roleId);
				request.setAttribute("msg", "Please enter your password.");

			}

		} catch (ApplicationException e) {

			messages.add("message", new ActionMessage("errors.misc",
					"Validation code is NOT verified for the given username and password"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}

		return mapping.findForward(targetAction);
	}
}
