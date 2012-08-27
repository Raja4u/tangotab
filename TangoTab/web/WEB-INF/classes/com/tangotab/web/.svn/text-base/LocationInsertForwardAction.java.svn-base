package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.dao.pojo.RestaurantLocation;

public class LocationInsertForwardAction extends BaseAction {

	
	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		UserBO userDao = BusinessFactory.getUserBO();
		ArrayList<RestaurantLocation> locations = new ArrayList<RestaurantLocation>();
		UserTO user = (UserTO) request.getSession().getAttribute("userInfo");
		
		ArrayList<RestaurantLocation> managers = (ArrayList<RestaurantLocation>) userDao
				.getLocationManagers(user.getRestaurantId());
		for (Object mgr : managers) {
			RestaurantLocation loc = new RestaurantLocation();
			Object[] details = (Object[]) mgr;

			loc.setStateId((Integer) details[0]);
			loc.setWebSite((String) details[1]);
			loc.setDescription((String) details[2]);
			loc.setZipCode((String) details[3]);
			loc.setAddress((String) details[4]);
			locations.add(loc);
		}
		request.setAttribute("managers", locations);
		return mapping.findForward("success");
	}

}
