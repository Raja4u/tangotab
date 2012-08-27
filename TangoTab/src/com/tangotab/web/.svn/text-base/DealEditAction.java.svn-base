package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRegForm;

public class DealEditAction extends BaseAction {
	
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		String page;
		String type = request.getParameter("type");
		try {
			int dealId = 0;
			DealRegForm dealRegForm = (DealRegForm) form;
			if (request.getParameter("dealId") != null)
				dealId = Integer.valueOf(request.getParameter("dealId"));
			else if (dealRegForm.getDealTemplateId() != null) {
				dealId = dealRegForm.getDealTemplateId();
			}
			request.setAttribute("dealId", dealId);
			if (type.equalsIgnoreCase(TangotabConstants.UPDATE)) {
				UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
				ArrayList<LocationTO> locationsInfo = locationBO
						.getLocationsByRestaurantId(userInfo.getRestaurantId());
				request.setAttribute("locationsInfo", locationsInfo);
				DealTO dealInfo = new DealTO();
				if (dealId != 0)
					dealInfo = locationBO.getDealByDealId(dealId);
				request.setAttribute("dealInfo", dealInfo);
				page = TangotabConstants.UPDATE;
			} else if (type.equalsIgnoreCase("publish")) {
				locationBO.publishDeal(dealId);
				page = TangotabConstants.PUBLISH;
			} else if (type.equalsIgnoreCase("unpublish")) {
				locationBO.unpublishDeal(dealId);
				page = TangotabConstants.PUBLISH;
			} else {
				page = TangotabConstants.FAILURE;
			}

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			page = TangotabConstants.FAILURE;
		}
		return mapping.findForward(page);
	}

}
