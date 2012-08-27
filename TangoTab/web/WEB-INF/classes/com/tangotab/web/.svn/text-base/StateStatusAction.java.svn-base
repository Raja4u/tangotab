package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.business.AdminBO;
import com.tangotab.business.CommonBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class StateStatusAction extends BaseAction {

	CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
	AdminBO adminBO = com.tangotab.businessImpl.BusinessFactory.getAdminBO();

	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String stateId[] = request.getParameterValues("stateId");
		String isactive[] = request.getParameterValues("isActive");
		/* ChangedStateIds contains StateIds whose status has been change */
		String ChangedStateIds[] = request.getParameterValues("flag");

		try {
			if (request.getParameterValues("stateId") != null) {
				for (int i = 0; i < stateId.length; i++) {
					if(Integer.parseInt(stateId[i]) == Integer.parseInt(ChangedStateIds[i])) 
					 adminBO.setStateStatus(Integer.parseInt(stateId[i]), Integer
							.parseInt(isactive[i]));

				}
			}

		} catch (ApplicationException e) {
			e.printStackTrace();

			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

}
