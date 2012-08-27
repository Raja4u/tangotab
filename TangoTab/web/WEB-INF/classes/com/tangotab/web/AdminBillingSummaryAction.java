package com.tangotab.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.BillingCcTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DateForm;

public class AdminBillingSummaryAction extends BaseDispatchAction {

	public static Logger log = LoggerFactory.getLogger(AdminBillingSummaryAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	SortByTO sortByTO=new SortByTO();
	
	/*
	 * Display all restaurants according to pagination 
	 * */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("Entering retrieve client Action");

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
		try {
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
			/* get total amount for each restaurnat by restaurant id from billlingCC table */
			for (Restaurant rest : restaurant) {
				Double amount = 0.0;
				ArrayList<BillingCcTO> bills = userBo.getBillingSummary(rest.getRestaurantId());
				for (BillingCcTO bill : bills) {
					/* adding total of all billing cc amounts */
					amount = amount + bill.getDoubleAmount();
				}
				/* as no avalilability of amount i set to dummy field for display*/
				rest.setCurrentCredits(amount); 
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
			request.setAttribute("clientdetails", restaurant);
			request.setAttribute("num", info1[0]);
	    	request.setAttribute("currentPage", currentPage);
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
    /* Used one method for host credit report and host billing report search */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String credit = request.getParameter("credit");
		int currentPage = 0;
		String name = request.getParameter("searchname");
		String hname = request.getParameter("hsearch");
		String num = request.getParameter("num");
		String page = request.getParameter("page");
		
		ActionMessages messages = new ActionMessages();
		ArrayList<Restaurant> restList = null;
		
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
			if (name != null)
				restList = (ArrayList<Restaurant>) userBo.getRestaurantByName(name,currentPage,sortByTO);
			if (restList == null || restList.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}else if (credit == null || credit.length()<1){
				for (Restaurant rest : restList) {
					Double amount = 0.0;
					ArrayList<BillingCcTO> bills = userBo.getBillingSummary(rest.getRestaurantId());
					for (BillingCcTO bill : bills) {
						/* adding total of all billing cc amounts */
						amount = amount + bill.getDoubleAmount();
					}
					/* as no avalilability of amount i set to dummy field for display*/
					rest.setCurrentCredits(amount); 
				}
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
			request.setAttribute("searchname", name);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("num", num);
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(credit!= null && credit.length()>0){
			request.setAttribute("restaurants", restList);
			return mapping.findForward("credits");
		}
		else{
			request.removeAttribute("clientdetails");
			request.setAttribute("clientdetails", restList);
		    return mapping.findForward(TangotabConstants.SUCCESS);
		}
	}

	/*
	 * Display billing details also for the restaruant 
	 * */
	public ActionForward billing(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String purchasedDate = "NO";
		ActionMessages actionMessages = new ActionMessages();
		Double amount = 0.0;
		try {
			int restaurantId = 0;
			if (request.getParameter("restid") != null)
				restaurantId = Integer.parseInt(request.getParameter("restid"));
			ArrayList<BillingCcTO> bill = userBo.getBillingSummary(restaurantId);
			if (bill == null || bill.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"No Records Found"));
				saveMessages(request, actionMessages);
			}
			if (bill != null && bill.size() > 0) {
				request.setAttribute("size", bill.size()); // set size of list
				for (BillingCcTO bil : bill) {
					amount = amount + bil.getDoubleAmount();
				}
			}
			request.setAttribute("bill", bill); // All results are session scoped
			request.setAttribute("purchasedDate", purchasedDate);
			request.setAttribute("restaurantId", restaurantId);
			request.setAttribute("total", amount);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward("editBilling");
	}

	/* display records whose transaction date lies in between dates specified by user*/
	public ActionForward searchBilling(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String restaurantId = request.getParameter("Id");
		String purchasedDate = "YES";
		Double amount = 0.0;
		ActionMessages actionMessages = new ActionMessages();
		ArrayList<BillingCcTO> purchaseDate = new ArrayList<BillingCcTO>();
		try {

			ArrayList<BillingCcTO> bill = null;
			
			if (restaurantId != null)
				bill = userBo.getBillingSummary(Integer.parseInt(restaurantId));
			DateForm df = (DateForm) form;
			Date startDate = null;
			Date endDate = null;
			if (df.getStartDate() != null) {
				startDate = DateConverterUtility.convertUiToServiceDate(df.getStartDate());
			}
			if (df.getStartDate() != null) {
				endDate = DateConverterUtility.convertUiToServiceDate(df.getEndDate());
			}

			Iterator<BillingCcTO> iter = bill.iterator();
			while (iter.hasNext()) {
				BillingCcTO crTO = iter.next();
				Date d = DateConverterUtility.convertUiToServiceDate(crTO.getPurchasedDate());

				if (startDate != null && endDate != null) {
					int s = d.compareTo(startDate);
					int e = d.compareTo(endDate);
					
					if (s >= 0 && e <= 0) 
					{
						
						purchaseDate.add(crTO); 

					}
				} else if (startDate != null && endDate == null) {
					int s = d.compareTo(startDate);
					/* compare all dates with start date */
					if (s >= 0)
					{
					
						purchaseDate.add(crTO); 
					}
				} else if (startDate == null && endDate != null) {
					int e = d.compareTo(endDate);
					/* compare all dates with end date */
					if (e <= 0) 
					{
						/* insert deal in to list & put this crTO in to targetList */
						purchaseDate.add(crTO); 

					}
				} else if (startDate == null && endDate == null) {
					purchaseDate.add(crTO);
				}
			}
			if (purchaseDate == null || purchaseDate.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"No Records Found"));
				saveMessages(request, actionMessages);
			}
			if (purchaseDate != null && purchaseDate.size() > 0) {
				/* set size of list */
				request.setAttribute("size", purchaseDate.size()); 
				for (BillingCcTO bil : purchaseDate) {
					amount = amount + bil.getDoubleAmount();
				}
			}
			request.setAttribute("total", amount);
			/*  view details according to request scope */
			request.setAttribute("purchaseDate", purchaseDate); 
			request.setAttribute("purchasedDate", purchasedDate);
			request.setAttribute("restaurantId", restaurantId);

		} catch (Exception e) {
			
		}
		/*  going to view after search by date */
		return mapping.findForward("searchfound");

	}
	/* Method to view credits of all restaurants */
	public ActionForward credits(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		/* default current page is zero */
		Integer currentPage = 0;
          
		ActionMessages messages = new ActionMessages();
		String num = request.getParameter("num");
		String page = request.getParameter("page");
		String user ="host";
		String searchname = "";
		String info = TangoTabUtility.paginationForGuestAndHost(num,page,user, searchname);
		
		String info1[] = info.split(",");
		currentPage = 	Integer.parseInt(info1[1]);	
		ArrayList<Restaurant>  restaurants = null; 
	    try{
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
	    	
	    	restaurants = userBo.getAllRestaurants(currentPage,sortByTO);
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
	    	request.setAttribute("restaurants", restaurants);
	    	request.setAttribute("num", info1[0]);
	    	request.setAttribute("currentPage", currentPage);
	    	if (restaurants == null || restaurants.size() == 0) {
	    		messages.add("No Records", new ActionMessage(
						"result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
	    }catch (Exception e) {
			 	mapping.findForward("failure");
		}
		return mapping.findForward("credits");
		
	}
	
	
}
