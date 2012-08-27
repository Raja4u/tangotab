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

public class AdminDealsForwardAction extends BaseAction {

	LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
		String success=TangotabConstants.SUCCESS;
		String type = request.getParameter("type");
		int dealId = 0;
		try {
			if (type != null && type.equals("approve")) {
				dealId = Integer.parseInt(request.getParameter("dealId"));
				locationBO.setCustomDealStatus(dealId, TangotabConstants.ACTIVE);
				success="approved";
			}
			ArrayList<DealTO> dealsInfo = null;

			String location = (String) request.getParameter("restLocationId");
			Integer locationId = 0;
			if (StringUtils.isNotEmpty(location))
				locationId = Integer.valueOf(location);
			
			int currentPage = 0;
				
			String dealType = new String();
			if(userInfo.getRoleId() ==1)
				dealType = "inactive";
			if(userInfo.getRoleId() ==5 || userInfo.getRoleId() ==6)
				dealType = "all";
				
			if (userInfo.getRoleId() ==1 ) {
				
				String byloc = request.getParameter("byloc");
				String locname = request.getParameter("searchname");
				String hname = request.getParameter("hsearch");
				
				/* if without search or search name is empty */
				if(StringUtils.isEmpty(byloc) || StringUtils.isEmpty(locname)){
				/* checking for the first time or not */		
				if(request.getParameter("num") == null || request.getParameter("page") == null ){
				try {
					/*calculates total pages and set to request scope for display 1 2 3..*/
					int total = (int)locationBO.countDealsForLocation(userInfo.getUserId(),
							userInfo.getRoleId(), userInfo.getRestaurantId(), locationId, dealType).longValue();
					int noOfPages = total/TangotabConstants.PAGE_SIZE;
					if(total%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage = 1;
					request.setAttribute("num",noOfPages);
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else{
					/* read the requested page no, if it not first time */
					String page = (String)request.getParameter("page");
					if(page != null)
						currentPage = Integer.parseInt(page);
					request.setAttribute("num", request.getParameter("num"));
				}
				if (userInfo != null)
					dealsInfo = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
							.getRoleId(), userInfo.getRestaurantId(), locationId, dealType, currentPage);
			
				/* if search by location name then come here */
				}else{
					/* start fresh pagination if no pagination before or no page num. came or 
					 * search name changes or searching for first time */
					if(request.getParameter("num") == null || request.getParameter("page") == null 
							|| hname == null ||(!locname.equals(hname)) ){
						try {
							/* calculates total pages and set to request scope for display 1 2 3..*/
							int total = (int)locationBO.countDealsForLocation(userInfo.getUserId(),
									userInfo.getRoleId(), userInfo.getRestaurantId(), locationId, dealType, locname).longValue();
							int noOfPages = total/TangotabConstants.PAGE_SIZE;
							if(total%TangotabConstants.PAGE_SIZE != 0)
								noOfPages += 1;
							currentPage = 1;
							request.setAttribute("num",noOfPages);
						} catch (ApplicationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else{
							/* read the requested page no, if it not first time */
							String page = (String)request.getParameter("page");
							if(page != null)
								currentPage = Integer.parseInt(page);
							request.setAttribute("num", request.getParameter("num"));
						}
						if (userInfo != null)
							dealsInfo = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
									.getRoleId(), userInfo.getRestaurantId(), locationId, dealType, currentPage, locname);
					
					
				}
				
					request.setAttribute("location", locationId);
				
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("searchname", locname);
			}
			if (userInfo!=null && userInfo.getRoleId() == 5) {
				
				ArrayList<LocationTO> locationsInfo = locationBO
						.getLocationsByRestaurantId(userInfo.getRestaurantId());
				request.setAttribute("locationsInfo", locationsInfo);
				request.setAttribute("locationsInfoSize", locationsInfo.size());
				
				dealsInfo = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
						.getRoleId(), userInfo.getRestaurantId(), locationId, dealType);
				request.setAttribute("location", locationId);
				
			} else if (userInfo!=null && userInfo.getRoleId() == 6) {
				
				ArrayList<LocationTO> locationsInfo = locationBO
						.getLocationsByRestaurantId(userInfo.getRestaurantId());
				ArrayList<LocationTO> locationsInfo1 = new ArrayList<LocationTO>();
				/* get all locations first for the restaurant */
				locationsInfo = locationBO.getLocationsByRestaurantId(userInfo
						.getRestaurantLocation().getRestaurant().getRestaurantId());

				/* put locations which are assigned to dealmanager logged in */
				for (LocationTO locations : locationsInfo) {
					LocationTO locationTO = new LocationTO();
					if (userInfo.getUserId().equals(locations.getUserId())) {

						locationTO = locations;
						locationsInfo1.add(locationTO);
					}
				}
				locationsInfo = locationsInfo1;
				/* display only locations which are assigned to him */
				request.setAttribute("locationsInfo", locationsInfo);
				request.setAttribute("locationsInfoSize", locationsInfo.size());

				/* If no location is selected, get all deals from all his assigned locations */
				if (locationId == null || locationId == 0) {
					
					dealsInfo = new ArrayList<DealTO>();
					ArrayList<DealTO> dealsInfos = new ArrayList<DealTO>();
					for (LocationTO locations : locationsInfo) {

						dealsInfos = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
								.getRoleId(), userInfo.getRestaurantId(), locations
								.getRestLocationId(), "all");

						dealsInfo.addAll(dealsInfos);
					}
				} 
				/* otherwise get deals for selected location */
				else {
					dealsInfo = locationBO.getDealsForLocation(userInfo.getUserId(), userInfo
							.getRoleId(), userInfo.getRestaurantId(), locationId, "all");
					request.setAttribute("location", locationId);
				}

			}

			if (dealsInfo == null || dealsInfo.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"No Records Found"));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("userInfo", userInfo);
			request.setAttribute("dealsInfo", dealsInfo);

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}

		return mapping.findForward(success);

	}
}
