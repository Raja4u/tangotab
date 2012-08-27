package com.tangotab.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

public class BaseDispatchAction extends DispatchAction {
	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	public final ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException {
		log.debug("Entering BaseDispatchAction");
		ActionForward forward = null;
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		String pageType = mapping.getInput();
		log.debug("Page Type: " + pageType);

		if (isLoginRequired()) {
			HttpSession session = request.getSession(false);
			if (session.getAttribute("userInfo") == null) {
				ActionMessages messages = new ActionMessages();
				messages.add("message", new ActionMessage("actionMessage.sessionTimedOut"));
				saveMessages(request, messages);
				log.debug("Session Invalid");
				if (pageType != null && (pageType.equals("page") || pageType.contains("jsp")))
					return mapping.findForward("login");
		 
			}
		}

		try {
			uri = request.getSession().getServletContext().getRealPath("/");
			if(methodName != null)
				forward = dispatchMethod(mapping, form, request, response, methodName);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		log.debug("Exiting BaseDispatchAction");
		return forward;
	}

}
