package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LocationForm;

public class LocationUpdateForwardAction extends BaseAction {

	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
		LocationForm form2 = (LocationForm) form;
		UserBO userDao = BusinessFactory.getUserBO();
		int licationId = 0;
		if (userInfo.getRoleId() == 6) {
			userInfo.setBusinessName(userInfo.getRestaurantLocation().getRestaurant()
					.getBusinessName());
		}
		if (request.getParameter("locationId") != null)
			licationId = Integer.parseInt(request.getParameter("locationId"));
		else if (form2.getRestLocationId() != null) {
			licationId = form2.getRestLocationId();
		}

		try {
			LocationTO locationsInfo = locationBO.fetchLocationByLocationId(licationId);
			BeanUtils.copyProperties(form2, locationsInfo);
			if(locationsInfo.getEmailId().equals(userInfo.getEmailId()))
				 form2.setHostAsManager("Yes");
			if( locationsInfo.getEmailIdArray() != null && locationsInfo.getEmailIdArray().length > 0 ){
				fillForm(form2, locationsInfo);
							
			}
			form2.setManagerId(locationsInfo.getUserId().toString());
			request.setAttribute("locationsInfo", locationsInfo);
			request.setAttribute("userInfo", userInfo);

			ArrayList<RestaurantLocation> locations = new ArrayList<RestaurantLocation>();
			ArrayList<RestaurantLocation> managers = (ArrayList<RestaurantLocation>) userDao
					.getLocationManagers(userInfo.getRestaurantId());
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

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
	
	private void fillForm(LocationForm form2, LocationTO locationsInfo){
		for(int i = 0; i<locationsInfo.getEmailIdArray().length; i++ ){
			switch(i){
			case 0: form2.setEmailIdOne(locationsInfo.getEmailIdArray()[i]);
			        form2.setNameOne(locationsInfo.getNameArray()[i]);
			        break;
			case 1: form2.setEmailIdTwo(locationsInfo.getEmailIdArray()[i]);
					form2.setNameTwo(locationsInfo.getNameArray()[i]);
			        break;
			case 2: form2.setEmailIdThree(locationsInfo.getEmailIdArray()[i]);
					form2.setNameThree(locationsInfo.getNameArray()[i]);
					break;
			case 3: form2.setEmailIdFour(locationsInfo.getEmailIdArray()[i]);
					form2.setNameFour(locationsInfo.getNameArray()[i]);
					break;
			case 4: form2.setEmailIdFive(locationsInfo.getEmailIdArray()[i]);
					form2.setNameFive(locationsInfo.getNameArray()[i]);
					break;				
			
			}
		}
		
	}

}
