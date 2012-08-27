package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.web.form.SalesForm;

public class SalesRegAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String targetAction = new String("failure");

		SalesForm sales = (SalesForm) form;
		try {

			boolean status = true;// bo.sa.saveSales(sales);

			if (status) {
				targetAction = new String("success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(targetAction);
	}

}
