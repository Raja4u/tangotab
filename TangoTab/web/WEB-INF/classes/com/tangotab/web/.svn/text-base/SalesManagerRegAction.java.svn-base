package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
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

public class SalesManagerRegAction extends Action {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SalesManagerRegForm mgrForm = (SalesManagerRegForm) form;
		SalesManagerTO managerTO = new SalesManagerTO();
		ActionMessages actionMessages = new ActionMessages();
		try {
			BeanUtils.copyProperties(managerTO, mgrForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			userBo.saveSalesManager(managerTO);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
