package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class DealSummaryAction extends Action {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		int dealId =0;
		if(StringUtils.isNumeric(request.getParameter("dealId")) && StringUtils.isNotEmpty(request.getParameter("dealId")))
		 dealId = Integer.valueOf(request.getParameter("dealId"));
		try {
			 String date = request.getParameter("date");
		      DealTO dealInfo = userBo.fetchDealByDealId(dealId, date);

			//  userBo.fetchDealByDealId(dealId);
		      if(StringUtils.isNotEmpty("src"))
		    	  request.setAttribute("refferCode", request.getParameter("src"));
			request.setAttribute("dealInfo", dealInfo);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
}
