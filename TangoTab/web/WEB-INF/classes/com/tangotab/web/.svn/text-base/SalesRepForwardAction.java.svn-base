package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class SalesRepForwardAction extends BaseAction {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		String type = request.getParameter("type");
		if (StringUtils.isEmpty(type)) {
			try {
				request.setAttribute("manageList", userBo.getSalesManagerList());
			} catch (ApplicationException e) {
				actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, actionMessages);
			}
			request.setCharacterEncoding("UTF8");
			return mapping.findForward(TangotabConstants.SUCCESS);
		} else if (type.equals("edit")) {
			try {
				int salesRepId = Integer.valueOf(request.getParameter("userId"));
				request.setAttribute("repInfo", userBo.getSalesRepInfoById(salesRepId));
				request.setAttribute("manageList", userBo.getSalesManagerList());
			} catch (ApplicationException e) {
				actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, actionMessages);
			}
			return mapping.findForward(TangotabConstants.SENT);
		} else {
			String id = request.getParameter("userId");
			int salesMgrId = Integer.valueOf(id);
			request.setAttribute("mgrInfo", userBo.getSalesManagerInfoById(salesMgrId));
			return mapping.findForward(TangotabConstants.mgr);
		}
	}

}
