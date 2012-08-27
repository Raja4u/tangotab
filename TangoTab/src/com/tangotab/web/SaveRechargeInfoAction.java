package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.PaymentTO;
import com.tangotab.web.form.PaymentForm;

public class SaveRechargeInfoAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PaymentForm paymentForm = (PaymentForm) form;
		PaymentTO paymentTO = new PaymentTO();
		try {
			BeanUtils.copyProperties(paymentTO, paymentForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward("success");
	}

}
