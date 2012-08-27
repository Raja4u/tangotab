package com.tangotab.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.ConsumerReservationTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DateForm;

public class ConsumerDealsHistoryAction extends BaseDispatchAction {

	private UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	String byDate = "NO";
	
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 // for differentiating view all and view by date

			byDate = "NO";

			ActionMessages actionMessages = new ActionMessages();
			try {

				HttpSession session = request.getSession();
				UserTO useTO = (UserTO) session.getAttribute("userInfo");
				Integer Uid = useTO.getUserId();
				ArrayList<ConsumerReservationTO> reserved = userBO.getUserDealsHistory(Uid);
				if (reserved == null || reserved.size() == 0) {
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
							"No Records Found"));
					saveMessages(request, actionMessages);
				}
				if (reserved != null && reserved.size() > 0) {
					request.setAttribute("size", reserved.size()); // set size
					// of list
				}
				request.setAttribute("reserved", reserved); // All results are
				
				} catch (ApplicationException e) {
				actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, actionMessages);
			}
			return mapping.findForward(TangotabConstants.SUCCESS);


		
	}
	
	public ActionForward Search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionMessages actionMessages = new ActionMessages();
		ArrayList<ConsumerReservationTO> viewByDate = new ArrayList<ConsumerReservationTO>();

		try {
			HttpSession session = request.getSession();
			ArrayList<ConsumerReservationTO> reserved = null;
			UserTO useTO = (UserTO) session.getAttribute("userInfo");
			Integer Uid = useTO.getUserId();
			reserved = userBO.getUserDealsHistory(Uid);
			
			DateForm df = (DateForm) form;
			Date startDate = null;
			Date endDate = null;
			if (StringUtils.isNotEmpty(df.getStartDate()) ) {
				startDate = DateConverterUtility.convertUiToServiceDate(df.getStartDate());
			}
			if (StringUtils.isNotEmpty(df.getEndDate()) ) {
				endDate = DateConverterUtility.convertUiToServiceDate(df.getEndDate());
			}
            if(reserved != null){
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
						viewByDate.add(crTO);
						// insert deal in to list & put this crTO in to targetList

					}
				} else if (startDate != null && endDate == null) {
					int s = d.compareTo(startDate);
					if (s >= 0) // compare all dates with entered dates
					{
						viewByDate.add(crTO); 
						// insert deal in to list & put this crTO in to targetList
					}
				} else if (startDate == null && endDate != null) {
					int e = d.compareTo(endDate);
					if (e <= 0) 
						// compare all dates with entered dates
					{
						viewByDate.add(crTO); 
						// insert deal in to list & put this crTO in to targetList

					}
				} else if (startDate == null && endDate == null) {
					viewByDate.add(crTO);
				}

			}
            }
			if (viewByDate == null || viewByDate.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"No Records Found"));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("reserved", viewByDate); 
			// view details according to request scope
			if (viewByDate != null && viewByDate.size() > 0) {
				request.setAttribute("size", viewByDate.size()); 
				// set size of list
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(TangotabConstants.SUCCESS); 
		// going to view after search by date
	
			
	}
	public ActionForward getReservationDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String rId = request.getParameter("rid");
		Integer dealId;
		DealTO dealInfo = null;
		if (request.getParameter("did") != null && request.getParameter("did").length() > 0) {
			dealId = Integer.parseInt(request.getParameter("did"));
			dealInfo = userBO.fetchDealByDealId(dealId);
		}
		request.setAttribute("rid", rId);
		request.setAttribute("reserveddeal", dealInfo);
		return mapping.findForward("dealhistory");
	}
	
	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String reservationIds[] = request.getParameterValues("conresId");
		String status[] = request.getParameterValues("status");
		/*  ChangedCustIds contains GuestIds whose status has been change */
		String changedResIds[] = request.getParameterValues("flag"); 
		Boolean b = false;
		ActionMessages messages = new ActionMessages();		
		ArrayList<UserTO> users = null;
		try {
			/* Identifying and updating status of only changed guests.*/
			for (int i = 0; i < reservationIds.length; i++) {
				if(Integer.parseInt(reservationIds[i]) != 0 && Integer.parseInt(changedResIds[i]) != 0)
					b = userBO.updateOfferConfirmationStatus(Integer.parseInt(reservationIds[i]), status[i] );
			}

			if (b) {
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Status Updated successfully"));
				saveMessages(request, messages);
			}
			display(mapping, form, request, response);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Status Not Updated"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.SUCCESS);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
		
	}
	

}
