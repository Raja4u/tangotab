package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.LandingTO;
import com.tangotab.TO.StateTO;
import com.tangotab.business.AdminBO;
import com.tangotab.business.CommonBO;
import com.tangotab.businessImpl.AdminBOImpl;
import com.tangotab.businessImpl.CommonBOImpl;
import com.tangotab.util.TangotabConstants;

public class AdminManageLandingImagesAction extends BaseAction {

	CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
	AdminBO adminBO= com.tangotab.businessImpl.BusinessFactory.getAdminBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionMessages messages=new ActionMessages();
		ArrayList<LandingTO> landings=null;
		try {
			landings=adminBO.getLandings();
			if(landings == null || landings.size() < 1)
			{
				messages.add("message", new ActionMessage("result.noRecords", "No Rows are exists"));
				saveMessages(request, messages);
			}
			request.setAttribute("landings", landings);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}
}
