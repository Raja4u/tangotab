package com.tangotab.web;

import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.SearchTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.ConfigBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import com.tangotab.geo.GeoLocationUtility;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.SearchForm;

public class SearchActionForward extends Action {
	private UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		SearchForm searchForm = (SearchForm) form;
		SearchTO serchTO = new SearchTO();
		String ipAddress = request.getRemoteAddr();
		HttpSession session = request.getSession(true);
		UserTO userInfo = (UserTO) session.getAttribute("userInfo");

	

		try {
		
			// if(city.equals(""))
		    // city = GeoLocationUtility.getCityUsingTempAPI(ipAddress);
			/*
			 * Default deals should be only today.
			 * */
			Date today = new Date();
			String UIDate = DateConverterUtility.convertDBTimeStampToUiDate(today);
			today = DateConverterUtility.convertUiToServiceDate(UIDate);
			serchTO.setDealAvailDate(today);
			searchForm.setDealDate(UIDate);
			
			searchForm.setSearch(false);
			String page = (String)request.getParameter("page"); // current page
			String num = request.getParameter("num"); // total no. of pages
			long count = 0;
			int currentPage = 0;
			int noOfPages = 0;
			if(StringUtils.isNotEmpty(page)){
				currentPage = Integer.parseInt(page);
			}if(StringUtils.isNotEmpty(num)){
				noOfPages = Integer.parseInt(num);
			}
			/* If geolocation changes or pref city changes start fresh pagination 
			if(hcityname!= null && searchForm.getCityName()!= null && !hcityname.equals(searchForm.getCityName()))
				currentPage = 0;*/
			/*
			 * display the restaurants order by distance by zipcode or city 
			 * */
			  if(currentPage==0)
	  	        {
	  				CommonBO commonBO=com.tangotab.businessImpl.BusinessFactory.getCommonBO();
	  				ArrayList<RestaurantLocation>	arrayList=null;
	  				if(StringUtils.isNotEmpty(serchTO.getZipCode()))
	  				{
	  					
	  				 arrayList=commonBO.getAllLocations(serchTO.getZipCode());
	  				
	  				}else if(StringUtils.isNotEmpty(serchTO.getCityName()))
	  				{
	  					
	  				 arrayList=commonBO.getAllLocations(serchTO.getCityName());
	  				
	  				}
	  				if(arrayList!=null && arrayList.size()!=0)
	  				{
	  					ServletContext context = servlet.getServletContext();
	  					DropDownTO dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
	  					dropDownInfo.setRestaurants(arrayList);
	  					
	  					context.setAttribute("dropDownList",dropDownInfo);
	  				}
	  	        }
			ArrayList<DealTO> dealsInfo = null;
			/* check if the guest participated any event 
			if (userInfo != null && userInfo.getConsumerEvent()!=null &&
					userInfo.getConsumerEvent().size() > 0 ){
				Iterator<ConsumerEvent> iter = userInfo.getConsumerEvent().iterator();
				while(iter.hasNext() && count == 0){
					serchTO.setEventId(iter.next().getEvents().getEventId());
					count = userBO.countSearchDeals(serchTO);
				}
				
				 if(count == 0)
					 serchTO.setEventId(0);
			}*/
				
			/* check the availability of users prefer city or zip code if logged in */
			boolean isSignUp=false;
			try {
				isSignUp=Boolean.parseBoolean(session.getAttribute("isSignUp").toString());
			}catch (NullPointerException e) {
				// TODO: handle exception
			}
			try {
				/* Pagenation when signs up*/
				if(!isSignUp)
					isSignUp=Boolean.parseBoolean(request.getParameter("isSignUp").toString());
			}catch (NullPointerException e) {
				// TODO: handle exception
			}
			serchTO.setNear(isSignUp);
			if (count == 0 && userInfo != null && userInfo.getRoleId() == 4) {
				try{
				if(StringUtils.isNotEmpty(userInfo.getConsumerPreferCity().getCity().getCityName())){
					serchTO.setCityName(userInfo.getConsumerPreferCity().getCity().getCityName());
					if(serchTO.getCityName().equals("TangoTab Land"))
						serchTO.setCityName(null);
				}
					
				}catch(NullPointerException e){
					serchTO.setCityName(null);
				}
									
				if(StringUtils.isNotEmpty(userInfo.getZipCode()))
					serchTO.setZipCode(userInfo.getZipCode());
				/* Count  no.of deals with in 25miles */
				count = userBO.countSearchDeals(serchTO);
			
			}else if(count == 0){
				/* If there are no deals for prefer city or if not at all logged in then 
			   search with GEO zipCode */
				serchTO.setZipCode("");
				serchTO.setCityName(null);
				String zipcode = GeoLocationUtility.getCity(ipAddress);
				serchTO.setZipCode(zipcode);
				searchForm.setZipCode(zipcode);
				count = userBO.countSearchDeals(serchTO);    /* Count  no.of deals with in 25miles */
			}
			if(count == 0){
			/* If no deals found with  in 25 miles  also then count all active deals */	
				serchTO.setNear(false);
				//serchTO.setCityName("");
				//serchTO.setZipCode("");
				//searchForm.setZipCode(null);
				count = userBO.countSearchDeals(serchTO);
				if(count>0)
					count=1;
			}
			if(count > 0 ){
				/* If it is first time then calculate no of pages and set to first page */
				if(currentPage == 0 ){
					noOfPages = (int)count/TangotabConstants.PAGE_SIZE;
					if(count%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage += 1;
				}
				/* Search all deals */
				dealsInfo = userBO.searchDeals(serchTO, currentPage);
				ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
				ConfigPojo configPojo = configBO.getConfigDetails();
				Integer maxdebit = configPojo.getCreditUserDeal();
				request.setAttribute("maxdebit", maxdebit);
			}else{
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
				"Sorry no deals were found, please broaden your search criteria."));
		        saveMessages(request, actionMessages);
			}
			//searchForm.setCityName(serchTO.getCityName());
			if(StringUtils.isNotEmpty(serchTO.getCityName()) ){
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			ArrayList<CityTO> cityTO = dropDownInfo.getCities();
			for (CityTO cityto : cityTO) {
				if (cityto.getCityName().equalsIgnoreCase(serchTO.getCityName())) {
					searchForm.setCityName(cityto.getCityName());
					break;
				}
				
			}
			} if (serchTO.getZipCode() != null){
				searchForm.setZipCode(serchTO.getZipCode());
			}
			
			searchForm.setEventId(serchTO.getEventId());
			request.setAttribute("dealsInfo", dealsInfo);
			/* set page parameters to request scope for availability of jsp */
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("num", noOfPages);
		}catch(ApplicationException e){
		e.printStackTrace();	
		}
		return mapping.findForward(TangotabConstants.SUCCESS);	
			/*if (userInfo != null && userInfo.getRoleId() == 4
					&& userInfo.getConsumerPreferCity() != null
					&& userInfo.getConsumerPreferCity().getCity().getCityId() != 0) {
				serchTO.setCityName(userInfo.getConsumerPreferCity().getCity().getCityName());
				 If it is first time calculate no. of pages and current page 
				if(currentPage == 0 ){
				   count = userBO.countSearchDeals(serchTO);
				}
				if(count > 0 ){
				   noOfPages = (int)count/TangotabConstants.PAGE_SIZE;
					if(count%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage += 1;
					
				}
				if(count > 0 || currentPage > 0 )
					dealsInfo = userBO.searchDeals(serchTO, currentPage);
			} else if (dealsInfo == null || dealsInfo.size() == 0) {

				serchTO.setCityName(city);
				if(currentPage == 0  ){
				    count = userBO.countSearchDeals(serchTO);
			    }
				if(count > 0 ){
				      noOfPages = (int)count/TangotabConstants.PAGE_SIZE;
					  if(count%TangotabConstants.PAGE_SIZE != 0)
						 noOfPages += 1;
					  currentPage += 1;
					 
				    }
				if(count > 0 || currentPage > 1 )
					dealsInfo = userBO.searchDeals(serchTO, currentPage);
			}

			if (serchTO.getCityName() != null && !serchTO.getCityName().equals("")
					&& (dealsInfo == null || dealsInfo.size() == 0)) {
				serchTO.setCityName("");
				if(currentPage == 0 ){
				   count = userBO.countSearchDeals(serchTO);
				}
				if(count > 0 ){
				   noOfPages = (int)count/TangotabConstants.PAGE_SIZE;
					if(count%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage += 1;
					
				}
				if(count > 0 || currentPage > 1 )
				  dealsInfo = userBO.searchDeals(serchTO, currentPage);
			}
			
			if (dealsInfo == null || dealsInfo.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"Sorry no deals were found, please broaden your search criteria."));
				saveMessages(request, actionMessages);
			} else {
				ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
				ConfigPojo configPojo = configBO.getConfigDetails();
				Integer maxdebit = configPojo.getCreditUserDeal();
				request.setAttribute("maxdebit", maxdebit);
			}
			
			searchForm.setCityName(serchTO.getCityName());
			request.setAttribute("dealsInfo", dealsInfo);
			 set page parameters to request scope for availability of jsp 
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("num", noOfPages);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
	*/	
	
}
}
