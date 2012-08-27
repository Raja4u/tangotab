package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.UserTO;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;

public class FriendForwardLoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String dealId = request.getParameter("dealId");

		HttpSession session = request.getSession(true);
		UserTO userInfo = (UserTO) session.getAttribute("userInfo");
		if (userInfo != null) {
			request.setAttribute("dealId", dealId);
			
			return mapping.findForward(TangotabConstants.FRIEND);
		}
		String path = request.getQueryString();
		String emailId = request.getParameter("emailId");
		/* accept if user enter in url emailId or directly the mailaddress */
		if(StringUtils.isEmpty(emailId) && StringUtils.isNotEmpty(path) && TangoTabUtility.isEmailId(path)){
				emailId = path;
		}
		/* the login.jsp captures this share field so they are redirected to share page later */
		request.setAttribute("share","true"); 
		if(StringUtils.isNotEmpty(emailId))
		{
			request.setAttribute("emailId",emailId);
			return mapping.findForward("nologin");
		}
		request.setAttribute("dealId", dealId);
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
