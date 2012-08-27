package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.SalesManagerTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.web.form.SalesManagerRegForm;

public class SalesUpdateAction extends BaseAction {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		SalesManagerRegForm salesForm = (SalesManagerRegForm) form;
		SalesManagerTO managerTO = new SalesManagerTO();
		String page = "";
		try {
			BeanUtils.copyProperties(managerTO, salesForm);
		} catch (Exception e) {
		}
		String type = request.getParameter("type");
		if (StringUtils.isNotEmpty(type)) {
			if (type.equals("represent")) {
				try {
					userBo.updateSalesRepInfo(managerTO);
				} catch (ApplicationException e) {
					actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
							new ActionMessage(e.getCode()));
					saveMessages(request, actionMessages);
				}
				page = "represent";
			} else {
				try {
					userBo.updateSalesMgrInfo(managerTO);
				} catch (ApplicationException e) {
					actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
							new ActionMessage(e.getCode()));
					saveMessages(request, actionMessages);
				}
				page = "manager";
			}
		}
		request.setCharacterEncoding("UTF8");
		return mapping.findForward(page);
	}

}
