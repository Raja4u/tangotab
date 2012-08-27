package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealSummaryTO;
import com.tangotab.TO.UserTO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class BillingDealsAction extends BaseAction {


	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionMessages actionMessages = new ActionMessages();
		try {

			HttpSession session = request.getSession();
			UserTO useTO = (UserTO) session.getAttribute("userInfo");
			Integer Rid = useTO.getRestaurantId();

			DealSummaryTO bill = BusinessFactory.getLocationBO().getDealSummary(Rid);
 
			if (bill.getCurrentcredits() <= 0)
				bill.setCurrentcredits(useTO.getCurrentCredits());
			request.setAttribute("bill", bill);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

}
