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

import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class ClientViewDealForwardAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
		String location = (String) request.getParameter("restLocationId");
		Integer locationId = 0;
		if (StringUtils.isNotEmpty(location))
			locationId = Integer.valueOf(location);
		try {
			ArrayList<LocationTO> locationsInfo = locationBO.getLocationsByRestaurantId(userInfo
					.getRestaurantId());
			request.setAttribute("locationsInfo", locationsInfo);

			if (userInfo.getRoleId() == 6) {

				ArrayList<LocationTO> locationsInfo1 = new ArrayList<LocationTO>();
				locationsInfo = locationBO.getLocationsByRestaurantId(userInfo
						.getRestaurantLocation().getRestaurant().getRestaurantId());

				for (LocationTO locations : locationsInfo) {
					LocationTO locationTO = new LocationTO();
					if (userInfo.getUserId().equals(locations.getUserId())) {

						locationTO = locations;
						locationsInfo1.add(locationTO);
					}

				}
				locationsInfo = locationsInfo1;
				request.setAttribute("locationsInfo", locationsInfo);
			}

			request.setAttribute("locationsInfoSize", locationsInfo.size());

			ArrayList<DealTO> dealsInfo = null;
			if (locationId == null || locationId == 0) {
				if (userInfo.getRoleId() == 6) {
					dealsInfo = new ArrayList<DealTO>();
					ArrayList<DealTO> dealsInfos = new ArrayList<DealTO>();
					for (LocationTO locations : locationsInfo) {

						dealsInfos = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
								.getRoleId(), userInfo.getRestaurantId(), locations
								.getRestLocationId());
						dealsInfo.addAll(dealsInfos);
					}


				} else
					dealsInfo = locationBO.getDeals(userInfo.getUserId(), userInfo.getRoleId(),
							userInfo.getRestaurantId());
			} else {
				dealsInfo = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
						.getRoleId(), userInfo.getRestaurantId(), locationId);
				request.setAttribute("location", locationId);
			}
			if (dealsInfo == null || dealsInfo.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"There are no deals. Please create a new deal."));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("dealsInfo", dealsInfo);

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
