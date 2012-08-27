package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.util.TangotabConstants;

public class ProfileEditAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
	public static Logger log = LoggerFactory.getLogger(ProfileEditAction.class);

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		UserTO sessionUser = (UserTO) request.getSession().getAttribute("userInfo");
		if (sessionUser.getRoleId() == TangotabConstants.CONSUMER_ROLE) {
			return mapping.findForward(TangotabConstants.CONSUMER);
		} else {
			int noOfEnteredLocations = sessionUser.getNoOfEnteredLocatios();
			if (noOfEnteredLocations == 0) {
				return mapping.findForward(TangotabConstants.CLIENT_LOCATION);
			} else {
				ArrayList<LocationTO> locationsInfo = locationBO
						.getLocationsByRestaurantId(sessionUser.getRestaurantId());
				request.setAttribute("locationsInfo", locationsInfo);
				ArrayList<DealTO> dealsInfo = locationBO.getDeals(sessionUser.getUserId(),
						sessionUser.getRoleId(), sessionUser.getRestaurantId());
				if (dealsInfo == null || dealsInfo.size() == 0) {
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
							"No Records Found"));
					saveMessages(request, actionMessages);
				}
				request.setAttribute("dealsInfo", dealsInfo);
				return mapping.findForward(TangotabConstants.RESTARRANT);
			}
		}
	}

}
