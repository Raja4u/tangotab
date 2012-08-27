package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.StateTO;
import com.tangotab.business.CommonBO;
import com.tangotab.util.TangotabConstants;

public class StateForwardAction extends BaseAction {

	CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		try {
			ArrayList<StateTO> arrayList = commonBO.getStates("All");
			request.setAttribute("stateList", arrayList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward(TangotabConstants.SUCCESS);

	}
}
