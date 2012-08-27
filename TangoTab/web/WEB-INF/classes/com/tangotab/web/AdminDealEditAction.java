package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRegForm;

public class AdminDealEditAction extends BaseAction {
	
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	/* Making deal ready for Edit */
	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		String page;
		String viewdeal = "";
		//String type = request.getParameter("type");
		try {
			if(request.getParameter("viewdeal")!= null)
				viewdeal = request.getParameter("viewdeal");
			int dealId = 0;
			DealRegForm dealRegForm = (DealRegForm) form;
			if (request.getParameter("dealId") != null)
				dealId = Integer.valueOf(request.getParameter("dealId"));
			else if (dealRegForm.getDealTemplateId() != null) {
				dealId = dealRegForm.getDealTemplateId();
			}
			request.setAttribute("dealId", dealId);
			int restId = 0;
			if (StringUtils.isNotEmpty(request.getParameter("restId")) ){
				restId = Integer.valueOf(request.getParameter("restId"));
				request.setAttribute("restId", restId);
			}
			if(!StringUtils.isEmpty(viewdeal) && viewdeal.equals("yes"))
				request.setAttribute("viewdeal", viewdeal);
			DealTO dealInfo = locationBO.getDealByDealId(dealId);
			request.setAttribute("dealInfo", dealInfo);
			page = TangotabConstants.UPDATE;

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			page = TangotabConstants.FAILURE;
		}
		return mapping.findForward(page);
	}

}
