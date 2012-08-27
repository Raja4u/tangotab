package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.StateTO;
import com.tangotab.business.CommonBO;
import com.tangotab.util.TangotabConstants;

public class AdminManageCityAction extends BaseAction {

	CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer stateId = 0;

		try {
			ArrayList<StateTO> arrayList = commonBO.getStates("all");
			request.setAttribute("stateDate", arrayList);
			String state = (String) request.getParameter("stateId");
			if (StringUtils.isNotEmpty(state))
				stateId = Integer.valueOf(state);
			ArrayList<CityTO> cityList = null;
			if (stateId == null || stateId == 0) {
				cityList = commonBO.getCitiesForAdmin();
				request.setAttribute("cityList", cityList);
			} else {
				cityList = commonBO.getCitiesByStateForAdmin(stateId);
				request.setAttribute("cityList", cityList);
				request.setAttribute("state", stateId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward(TangotabConstants.SUCCESS);

	}
}
