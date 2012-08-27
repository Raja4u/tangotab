package com.tangotab.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public abstract class BaseAction extends Action {
	public static Logger log = Logger.getLogger(BaseAction.class);

	protected boolean isLoginRequired() {
		return true;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Entering BaseAction.execute() " + mapping.getParameter());
		ActionForward forward = null;
		String pageType = mapping.getInput();
		log.debug("Page Type: " + pageType);
 
		if (isLoginRequired()) {
			HttpSession session = request.getSession(false);
			if (session.getAttribute("userInfo") == null) {
				ActionMessages messages = new ActionMessages();
				messages.add("message", new ActionMessage("actionMessage.sessionTimedOut"));
				saveMessages(request, messages);
				log.debug("BaseAction.execute() session Invalid");
				if (pageType != null && (pageType.equals("page") || pageType.contains(".jsp")))
				{
					if(request.getParameter("dealId")!=null)
					{
						session.setAttribute("dealID", request.getParameter("dealId"));
					}
					return mapping.findForward("login");
					
				}

			}
		}

		try {
			forward = performExecute(mapping, form, request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		log.debug("Exiting BaseAction.execute()");
		return forward;
	}

	public abstract ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
