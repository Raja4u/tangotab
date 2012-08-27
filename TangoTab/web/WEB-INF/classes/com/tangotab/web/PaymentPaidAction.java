package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.ConfigBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.util.TangotabConstants;

public class PaymentPaidAction extends Action{

 
	private Logger log = LoggerFactory.getLogger(PaymentPaidAction.class);
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//System.out.println("reserved from iphone");

		try {
			ConfigBO configBO=com.tangotab.businessImpl.BusinessFactory.getConfigBO();
			ConfigPojo configPojo=	configBO.getConfigDetails();
			UserBO userBO=com.tangotab.businessImpl.BusinessFactory.getUserBO();
			int restId=0;
			log.debug("PaymentfromIphone", restId);
			if(request.getParameter("restId")!=null)
				if(StringUtils.isNumeric(request.getParameter("restId")))
					restId=Integer.parseInt(request.getParameter("restId"));
			userBO.autoDebitTransactions(restId, configPojo);

		} catch (Exception e) {
			log.error("PaymentfromIphone", e.getMessage());
		}

		return mapping.findForward(TangotabConstants.SUCCESS);

	}

}
