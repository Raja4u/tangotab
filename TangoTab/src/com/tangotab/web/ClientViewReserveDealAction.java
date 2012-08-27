package com.tangotab.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.ConsumerReservationTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;

public class ClientViewReserveDealAction extends BaseAction {

	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String byDate = "NO"; // for differentiating view all and view by date

		if (mapping.getPath().equals("/jsp/viewReservations")) {
			byDate = "NO"; // mapping to view all
			ArrayList<ConsumerReservationTO> reserved = null;
			ActionMessages actionMessages = new ActionMessages();
			try {

				HttpSession session = request.getSession();
				UserTO useTO = (UserTO) session.getAttribute("userInfo");
				Integer Rid = useTO.getRestaurantId();
				/* value comes only up on selecting drop down*/
				String locationId = request.getParameter("restLocationId");
				Integer locId = 0;
				UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
				ArrayList<LocationTO> locationsInfo = new ArrayList<LocationTO>();
				if (userInfo.getRoleId() == 5) {
					locationsInfo = locationBO.getLocationsByRestaurantId(Rid);
					session.setAttribute("locationsInfo", locationsInfo);
				}
				if (userInfo.getRoleId() == 6) {
                    Rid = userInfo
					.getRestaurantLocation().getRestaurant().getRestaurantId();
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
					session.setAttribute("locationsInfo", locationsInfo);
				}

				request.setAttribute("locationsInfoSize", locationsInfo.size());

				if (locationId == null || Integer.parseInt(locationId) == 0)
                  /* if dealmanager then fetch reservations only for his locations */
					if (userInfo.getRoleId() == 6) {
						reserved = new ArrayList<ConsumerReservationTO>();
						ArrayList<ConsumerReservationTO> reserv = new ArrayList<ConsumerReservationTO>();
						for (LocationTO locations : locationsInfo) {

							reserv  = locationBO.getConsumerReservationsByDeal(Rid,
									locations.getRestLocationId());
							reserved.addAll(reserv);
						}

					} else
						/* if host fetch reservations for all locations */
						reserved = locationBO.getConsumerReservationsByDeal(Rid);
				else {
					/* if a particular location is selected fetch for only tat location */
					locId = Integer.parseInt(locationId);
					reserved = locationBO.getConsumerReservationsByDeal(Rid, locId);
					
				}
				request.setAttribute("locId", locId);
				// reserved = locationBO.getCRbylocid;
				if (reserved == null || reserved.size() == 0) {
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
							"No Records Found"));
					saveMessages(request, actionMessages);
				}
				if (reserved != null && reserved.size() > 0) {
					request.setAttribute("size", reserved.size()); // set size
					// of list
				}
				session.setAttribute("reserved", reserved); // set list as
				// session scope
				request.setAttribute("byDate", byDate);

			} catch (ApplicationException e) {
				actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, actionMessages);
			}
			return mapping.findForward(TangotabConstants.SUCCESS);

		} else if (mapping.getPath().equals("/jsp/viewByDate")) {
			byDate = "YES"; // to view by date
			ActionMessages actionMessages = new ActionMessages();
			ArrayList<ConsumerReservationTO> viewByDate = new ArrayList<ConsumerReservationTO>();
			try {
				HttpSession session = request.getSession();
				ArrayList<ConsumerReservationTO> reserved = null;
				reserved = (ArrayList) session.getAttribute("reserved"); 
				// getting data from session scoped deals
				String locationId = request.getParameter("restLocationId"); // (all)
				String sd = request.getParameter("startDate");
				String ed = request.getParameter("endDate");

				Date startDate = null;
				Date endDate = null;
				if (sd != null) {
					startDate = DateConverterUtility.convertUiToServiceDate(sd);
				}
				if (ed != null) {
					endDate = DateConverterUtility.convertUiToServiceDate(ed);
				}

				Iterator<ConsumerReservationTO> iter = reserved.iterator();
				while (iter.hasNext()) {
					ConsumerReservationTO crTO = iter.next();
					Date d = DateConverterUtility.convertUiToServiceDate(crTO
							.getReservedTimestamp());

					if (startDate != null && endDate != null) {
						int s = d.compareTo(startDate);
						int e = d.compareTo(endDate);

						if (s >= 0 && e <= 0) // compare all dates with entered
						// dates
						{
							viewByDate.add(crTO); // insert deal in to list &
							// put this crTO in to
							// targetList

						}
					} else if (startDate != null && endDate == null) {
						int s = d.compareTo(startDate);
						if (s >= 0) // compare all dates with entered dates
						{
							viewByDate.add(crTO); // insert deal in to list &
							// put this crTO in to
							// targetList
						}
					} else if (startDate == null && endDate != null) {
						int e = d.compareTo(endDate);
						if (e <= 0) // compare all dates with entered dates
						{
							viewByDate.add(crTO); // insert deal in to list &
							// put this crTO in to
							// targetList

						}
					} else if (startDate == null && endDate == null) {
						viewByDate.add(crTO);
					}

				}
				if (viewByDate == null || viewByDate.size() == 0) {
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
							"No Records Found"));
					saveMessages(request, actionMessages);
				}
				request.setAttribute("viewByDate", viewByDate);
				request.setAttribute("locId", Integer.parseInt(locationId));// view details
				request.setAttribute("sd", sd);
				request.setAttribute("ed", ed);// according to

				request.setAttribute("byDate", byDate);
				if (viewByDate != null && viewByDate.size() > 0) {
					request.setAttribute("size", viewByDate.size());
				}

			} catch (Exception e) {

			}

			return mapping.findForward("searchfound");
		} else
			return mapping.findForward(TangotabConstants.SUCCESS);

	}
}
