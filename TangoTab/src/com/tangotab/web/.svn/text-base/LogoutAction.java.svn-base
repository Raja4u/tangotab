package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.util.TangotabConstants;

public class LogoutAction extends Action {
	private Logger log = LoggerFactory.getLogger(LogoutAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (log.isDebugEnabled())
			log.debug("start of execute in LogoutAction");
		request.getSession().invalidate();
		if (log.isDebugEnabled())
			log.debug("End of execute in LogoutAction");
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
}
