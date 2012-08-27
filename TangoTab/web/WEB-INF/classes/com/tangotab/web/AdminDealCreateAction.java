package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRegForm;

public class AdminDealCreateAction extends BaseDispatchAction {

	public static Logger log = LoggerFactory.getLogger(AdminDealCreateAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	private LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
	SortByTO sortByTO=new SortByTO();

	/* Display all Restaurants before going for create deal */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("Entering retrieve client Action");

		DealRegForm dealForm = (DealRegForm) form;
		ActionMessages messages = new ActionMessages();
		int currentPage = 0;
		String num = request.getParameter("num");
		String page = request.getParameter("page");
		String user ="host";
		String searchname = "";
		String info = TangoTabUtility.paginationForGuestAndHost(num, page, user, searchname);
		
		String info1[] = info.split(",");
		currentPage = 	Integer.parseInt(info1[1]);	
	

		ArrayList<Restaurant> restaurant = null;
		String viewDeals="no";
		try {
			if(request.getParameter("viewDeals")!=null)
			{
				viewDeals=request.getParameter("viewDeals");
			}
			if(dealForm.getDealPage()!= null){
				viewDeals = dealForm.getDealPage();
				messages.add("No Records",
						new ActionMessage("result.noRecords", "Deal Updated Susccessfully"));
				saveMessages(request, messages);
			}
			
			request.setAttribute("viewDeals", viewDeals);
		
			if(request.getParameter("num") == null){
				sortByTO.setDate(TangotabConstants.ASCENDING);
				sortByTO.setName(TangotabConstants.ASCENDING);
			}else 
				{if(currentPage==0)
				{ 
					if(request.getParameter("name").equals(TangotabConstants.ASCENDING))
						sortByTO.setName(TangotabConstants.DECENDING);
					else
						sortByTO.setName(TangotabConstants.ASCENDING); 
				}else if(currentPage==-1)
				{
					if(request.getParameter("date").equals(TangotabConstants.ASCENDING))
						sortByTO.setDate(TangotabConstants.DECENDING);
					else
						sortByTO.setDate(TangotabConstants.ASCENDING); 					
				}else 
				{
					sortByTO.setDate(request.getParameter("date"));
					sortByTO.setName(request.getParameter("name"));
				}
					
			}
			restaurant = userBo.getAllRestaurants(currentPage,sortByTO);

			if (restaurant == null || restaurant.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
			
			if(currentPage==0)
			{
				currentPage=1;
				sortByTO.setDate(null);
			}else 	if(currentPage==-1)
			{
				currentPage=1;
				sortByTO.setName(null);
			}
		
			request.setAttribute("sort",sortByTO);
			request.setAttribute("restDeals", restaurant);
			request.setAttribute("num", info1[0]);
	    	request.setAttribute("currentPage", currentPage);
	   			
			if (restaurant == null || restaurant.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Functionality to search a restaurant */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		
		int currentPage = 0;
		String name = request.getParameter("searchname");
		String hname = request.getParameter("hsearch");
		String num = request.getParameter("num");
		String page = request.getParameter("page");
		
		ActionMessages messages = new ActionMessages();
		ArrayList<Restaurant> restList = null;
		String viewDeals="no";
		if(request.getParameter("viewDeals")!=null)
		{
			viewDeals=request.getParameter("viewDeals");
		}
		request.setAttribute("viewDeals", viewDeals);
		String user ="host";
		/* calculate pagination only for first time , or only when the search criteria changes */
		if((request.getParameter("num") == null || hname == null)||(!name.equals(hname) )){
			num = null;
			String info = TangoTabUtility.paginationForGuestAndHost(num, page, user, name);
			String info1[] = info.split(",");
			currentPage = 	Integer.parseInt(info1[1]);
			num = info1[0];
		}else 	if(request.getParameter("page") != null) {
			/* otherwise set the current page to requested page */
			currentPage = Integer.parseInt(page);
		}
		
		try {
			if(request.getParameter("num") == null){
				sortByTO.setDate(TangotabConstants.ASCENDING);
				sortByTO.setName(TangotabConstants.ASCENDING);
			}else{
				if(currentPage==0)
				{ 
					if(request.getParameter("name").equals(TangotabConstants.ASCENDING))
						sortByTO.setName(TangotabConstants.DECENDING);
					else
						sortByTO.setName(TangotabConstants.ASCENDING); 
				}else if(currentPage==-1)
				{
					if(request.getParameter("date").equals(TangotabConstants.ASCENDING))
						sortByTO.setDate(TangotabConstants.DECENDING);
					else
						sortByTO.setDate(TangotabConstants.ASCENDING); 					
				}else 
				{
					sortByTO.setDate(request.getParameter("date"));
					sortByTO.setName(request.getParameter("name"));
				}
					
			}
			if (name != null)
				restList = (ArrayList<Restaurant>) userBo.getRestaurantByName(name,currentPage,sortByTO);
			
			if(currentPage==0)
			{
				currentPage=1;
				sortByTO.setDate(null);
			}else 	if(currentPage==-1)
			{
				currentPage=1;
				sortByTO.setName(null);
			}
		
			request.setAttribute("sort",sortByTO);
			request.setAttribute("searchname", name);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("num", num);
			request.removeAttribute("restDeals");
			request.setAttribute("restDeals", restList);
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Go for create Deal page after selecting a particular business name */
	public ActionForward creation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		ActionMessages messages = new ActionMessages();
		ArrayList<RestaurantLocation> location = null;
		int RestaurantId = 0;
		try {
			if (request.getParameter("restId") == null) {
				RestaurantId = Integer.parseInt(request.getParameter("restid"));
			}
			location = locationBo.getRestaurantLocations(RestaurantId);

			if (location == null || location.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
			request.setAttribute("restId", RestaurantId);
			HttpSession httpSession =request.getSession();
			httpSession.setAttribute("location", location);
			request.setAttribute("location", location);

		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("createDeal");
	}

	/* Deal Id for publish and UnPublish */
	public ActionForward viewDeals(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		ActionMessages actionMessages = new ActionMessages();
		UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
		String location = (String) request.getParameter("locationId");
		String rest = (String) request.getParameter("restid");
		Integer locationId = 0;
		Integer restId = 0;
		if (StringUtils.isNotEmpty(location))
			locationId = Integer.valueOf(location);
		if (StringUtils.isNotEmpty(rest))
			restId = Integer.valueOf(rest);
		
		Integer dealId=0;
		if (StringUtils.isNotEmpty((String) request.getParameter("dealId")))
			dealId = Integer.valueOf((String) request.getParameter("dealId"));
		
		try {
			
			if(dealId!=0)
			{
				String type = request.getParameter("type");
				if (type!=null && type.equalsIgnoreCase("publish")) {
					locationBo.publishDeal(dealId);
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
					"Successfully Published."));
				} else if (type!=null && type.equalsIgnoreCase("unpublish"))
				{
					locationBo.unpublishDeal(dealId);
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
				"Successfully Unpublished."));
				}
		saveMessages(request, actionMessages);
			}
			
			request.setAttribute("restId", restId);
			ArrayList<LocationTO> locationsInfo = locationBo.getLocationsByRestaurantId(restId);
			request.setAttribute("locationsInfo", locationsInfo);

			request.setAttribute("locationsInfoSize", locationsInfo.size());
			ArrayList<DealTO> dealsInfo = null;
			if (locationId == null || locationId == 0) {
					dealsInfo = locationBo.getDeals(userInfo.getUserId(), TangotabConstants.RESTAURANT_OWNER,
							restId);
			}else 
			{
					dealsInfo = locationBo.getDealsForLocation(userInfo.getUserId(), userInfo
							.getRoleId(), restId, locationId);
			}
				request.setAttribute("location", locationId);
		 
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
		return mapping.findForward("viewDeal");
	}
}
