package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class ClientDealCreationForWardAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
		try {
 
			ArrayList<LocationTO> locationsInfo = locationBO.getLocationsByRestaurantId(userInfo
					.getRestaurantId());
			if (userInfo.getRoleId() == 5) {
				if (userInfo.getBillingMethodId() == 1 && userInfo.getCurrentCredits() == 0) {
					return mapping.findForward("nocredits");
				} else if (userInfo.getNoOfEnteredLocatios() == 0) {
					return mapping.findForward("nolocations");
				}

				request.setAttribute("locationsInfo", locationsInfo);
			} else

			if (userInfo.getRoleId() == 6) {

				ArrayList<LocationTO> locationsInfo1 = new ArrayList<LocationTO>();
				locationsInfo = locationBO.getLocationsByRestaurantId(userInfo
						.getRestaurantLocation().getRestaurant().getRestaurantId());
				if(locationsInfo.size()==1)
				{
					for (LocationTO locations : locationsInfo) {
						if(locations.getIsActive()==TangotabConstants.ACTIVE)
						{
							LocationTO locationTO = new LocationTO();
							if (userInfo.getUserId().equals(locations.getUserId())) {

								locationTO = locations;
								locationsInfo1.add(locationTO);
							}
							
						}else 
						{
							request.setAttribute("locationsInfo", locationsInfo);
							return mapping.findForward("nolocations");
						} 
					}
				}else
				{
					
				
				for (LocationTO locations : locationsInfo) {
					LocationTO locationTO = new LocationTO();
					if (userInfo.getUserId().equals(locations.getUserId())) {

						locationTO = locations;
						locationsInfo1.add(locationTO);
					}

				}

				}
				locationsInfo = locationsInfo1;
				request.setAttribute("locationsInfo", locationsInfo);
			}

			request.setAttribute("locationsInfoSize", locationsInfo.size());

			

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);

		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
