package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.business.AdminBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class ImagesFetchAction extends BaseAction {
	private AdminBO adminBo = com.tangotab.businessImpl.BusinessFactory.getAdminBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		try {
			String dealName = request.getParameter("dealName");

			request.setAttribute("images", adminBo.getImages(dealName));
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
