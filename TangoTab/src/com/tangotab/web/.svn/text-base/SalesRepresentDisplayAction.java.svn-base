package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.SalesManagerTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.SalesManagerRegForm;

public class SalesRepresentDisplayAction extends BaseAction {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		SalesManagerRegForm salesForm = (SalesManagerRegForm) form;
		String searchParameter = request.getParameter("search");
		String update = request.getParameter("update");
		if (StringUtils.isNotEmpty(update)) {
			userBo.updateUserActiveStatus(salesForm.getSalesId(), salesForm.getActiveId());
		}
		ArrayList<SalesManagerTO> salesRepInfo = null;
		try {
			salesRepInfo = userBo.fetchSalesRepInfo(searchParameter);
			if (salesRepInfo.size() == 0) {
				actionMessages.add("No records", new ActionMessage("mgr.noData"));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("repInfo", salesRepInfo);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
