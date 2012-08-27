package com.tangotab.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealTO;
import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.SearchTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.ConfigBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.SearchForm;

public class SearchAction extends Action {
	private UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		SearchForm searchForm = (SearchForm) form;
		SearchTO serchTO = new SearchTO();
 
		try {
			try {
				if(searchForm.getRestauntName()!= null && 
						searchForm.getRestauntName().equals("Restaurant name"))
					searchForm.setRestauntName("");
				if(StringUtils.isNotEmpty(searchForm.getRestauntName())){
					if(searchForm.getRestauntName().contains("amp;"))
						searchForm.setRestauntName(searchForm.getRestauntName().replace("amp;", ""));
				}
				
				if(StringUtils.isNotEmpty(searchForm.getZipCode()) && 
						searchForm.getZipCode().trim().equalsIgnoreCase("Enter Zip Code") )
					searchForm.setZipCode("");
				
				BeanUtils.copyProperties(serchTO, searchForm);
				/* searchto is set so that for registered user , take to search deals page */
				String city = "";
				/*if(StringUtils.isNotEmpty(request.getParameter("zipCode"))){
					serchTO.setZipCode(request.getParameter("zipCode"));
				}*/
				if(StringUtils.isNotEmpty(request.getParameter("cityName"))){
					city = request.getParameter("cityName");
					serchTO.setCityName(city);
				}
				/*
				 * If deal date is empty then set default date as today 
				 * */
				if(StringUtils.isEmpty(searchForm.getDealDate())){
					Date today = new Date();
					String UIDate = DateConverterUtility.convertDBTimeStampToUiDate(today);
					searchForm.setDealDate(UIDate);
					
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
			
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
			/* If it is first time, set search to true */
			if(currentPage == 0)
			{
				searchForm.setSearch(true);
				serchTO.setSearch(true);
			}
				
			request.setAttribute("searchto", serchTO);
			  Date date = DateConverterUtility.convertUiToServiceDate(searchForm.getDealDate());
  	        Calendar cal = Calendar.getInstance();
  	        cal.setTime(date);
  	        serchTO.setDealAvailDate(cal.getTime());
  	        
  	        /*
  	         * search 
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
  					 context.removeAttribute("dropDownList");
  					context.setAttribute("dropDownList",dropDownInfo);
  				}
  				//serchTO.setNear(true);
			count = userBO.countSearchDeals(serchTO);
  	        }else 
  	        {
  	         count=currentPage*10;
  	        }
			
		     
			/* If at all there are any records then only go to fetch records 
			 * otherwise disyplay "no records" message */
			if(count > 0 ){
				/* If it is first time then calculate no of pages and set to first page */
				if(currentPage == 0 ){
					noOfPages = (int)count/TangotabConstants.PAGE_SIZE;
					if(count%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage += 1;
				}
				ArrayList<DealTO> dealsInfo = userBO.searchDeals(serchTO, currentPage);
				if(dealsInfo!=null)
				{
					count=dealsInfo.size();
				}else 
					count=0;
				ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
				ConfigPojo configPojo = configBO.getConfigDetails();
				Integer maxdebit = configPojo.getCreditUserDeal();
				request.setAttribute("maxdebit", maxdebit);
				request.setAttribute("dealsInfo", dealsInfo);
				
			}else{
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
				"Sorry no deals were found, please broaden your search criteria."));
		        saveMessages(request, actionMessages);
			}
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("num", noOfPages);
		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
}
