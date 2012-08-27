/**
 * 
 */
package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantCcProfile;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;


public class AdminClientAction extends BaseDispatchAction {

	public static Logger log = LoggerFactory.getLogger(AdminClientAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	/* Display all Hosts in a list */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("Entering retrieve client Action");
		/* default current page is zero */
		int currentPage = 0;
		SortByTO sortByTO=new SortByTO();
		ActionMessages messages = new ActionMessages();
		/* checking for the first time or not */		
		if(request.getParameter("num") == null){
			sortByTO.setDate(TangotabConstants.ASCENDING);
			sortByTO.setName(TangotabConstants.ASCENDING);
		try {
			
			/*calculates total pages and set to request scop
			 * e for display 1 2 3..*/
			int total = (int)com.tangotab.businessImpl.BusinessFactory.getUserBO().countAllRestaurants();
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
			request.setAttribute("num", request.getParameter("num"));
		}
		ArrayList<Restaurant> restaurant = null;
		try {
			restaurant = userBo.getAllRestaurants(currentPage,sortByTO);

			if (restaurant == null || restaurant.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}else {
				/* setting  changed date to UIdate for the field zipcode for display */
				int i = 0;
				for (Restaurant rest : restaurant) {
					restaurant.get(i).getUser().setZipCode(DateConverterUtility.
							convertDBTimeStampToUiDate(restaurant.get(i).getUser().getUserCreateDate()));
					i++;
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
			request.setAttribute("clientdetails", restaurant);
			request.setAttribute("currentPage", currentPage);

		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Admin can update status of BusinessNamaes selected by him*/
	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String Rid[] = request.getParameterValues("restId");
		String Status[] = request.getParameterValues("isActive");
		/* ChangedRestIds contains RestIds whose status has been change */
		String ChangedRestIds[] = request.getParameterValues("flag");
		UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
		ActionMessages messages = new ActionMessages();
		try {
			boolean b = false;
			for (int i = 0; i < Rid.length; i++) {
				/* Identifying and updating status of only changed restaurants.*/
				if (Integer.parseInt(ChangedRestIds[i]) == Integer.parseInt(Rid[i]))
					b = userBo.setRestaurantStatus(Integer.parseInt(Rid[i]), Short
							.parseShort(Status[i]));
			}
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO=com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setRestaurants(commonBO.getAllLocations());
			context.removeAttribute("dropDownList");
			context.setAttribute("dropDownList", dropDownInfo);	
			if (b) {
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Status Updated successfully"));
				saveMessages(request, messages);
			}
			display(mapping, form, request, response);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Display businessnames according to search criteria */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("searchname");
		String hname = request.getParameter("hsearch");
		ActionMessages messages = new ActionMessages();
		ArrayList<Restaurant> restList = null;
		int currentPage = 0;

		try {
			UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
			SortByTO sortByTO=new SortByTO();
			/* test if is for the first time or not. Displays first set of records only if
			 * name entered for first time or page request is empty or searchname changed.*/
			if((request.getParameter("num") == null || hname == null)||(!name.equals(hname) )){
					int total = (int)com.tangotab.businessImpl.BusinessFactory.getUserBO().countRestaurantByName(name);
					int noOfPages = total/TangotabConstants.PAGE_SIZE;
					if(total%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage = 1;
					sortByTO.setDate(TangotabConstants.ASCENDING);
					sortByTO.setName(TangotabConstants.ASCENDING);
					request.setAttribute("num",noOfPages);
				
				}else{
					/* read the requested page no. */
					String page = (String)request.getParameter("page");
					if(page != null)
						currentPage = Integer.parseInt(page);
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
					request.setAttribute("num", request.getParameter("num"));
				}
			if(StringUtils.isEmpty(name))
			{
				sortByTO.setDate(TangotabConstants.ASCENDING);
				sortByTO.setName(TangotabConstants.ASCENDING);
			}
			/* search guests by name and page */
			if (name != null)
				restList = (ArrayList<Restaurant>) userBo.getRestaurantByName(name, currentPage,sortByTO);
			if (restList == null || restList.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}else {
				/* setting  changed date to UIdate for the field zipcode for display */
				int i = 0;
				for (Restaurant rest : restList) {
					restList.get(i).getUser().setZipCode(DateConverterUtility.
							convertDBTimeStampToUiDate(restList.get(i).getUser().getUserCreateDate()));
					i++;
				}
			}
			if(currentPage==0)
			{
				sortByTO.setDate(null);
			}else 	if(currentPage==-1)
			{
				sortByTO.setName(null);
			}
			request.setAttribute("sort",sortByTO);
			request.removeAttribute("clientdetails");
			request.setAttribute("clientdetails", restList);
			request.setAttribute("searchname", name);
			request.setAttribute("currentPage", currentPage);
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Readying selected host details for display and for edit */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// form = new UserForm();
			UserForm clientForm = (UserForm) form;
			String restId = request.getParameter("id");
			UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
			UserTO userto = new UserTO();
			Restaurant rest = userBo.getRestaurantById(Integer.parseInt(restId));
			RestaurantCcProfile ccProfile = userBo.getCcProfile(Integer.parseInt(restId));
			if(ccProfile == null)
				clientForm.setProfileExists(false);
			else
				clientForm.setProfileExists(true);
			
			BeanUtils.copyProperties(userto, rest.getUser());
			BeanUtils.copyProperties(userto, rest);
			BeanUtils.copyProperties(clientForm, userto);
			String alternateEmailIds[] = {};
			String emailArray[]= {};
			String nameArray[] = {};
			if(StringUtils.isNotEmpty(rest.getAlternateHosts())){
				 alternateEmailIds = rest.getAlternateHosts().split(",");
				 emailArray = new String[5];
				 nameArray = new String[5];
			}
			if(alternateEmailIds.length > 0){
				for(int l = 0; l< alternateEmailIds.length; l++){
					String local[] = alternateEmailIds[l].split(":");
					if(local != null && local.length == 1)
						emailArray[l] = local[0];
					else{
					nameArray[l] = local[0];
					emailArray[l] = local[1];
					}
				}	
				userto.setEmailIdArray(emailArray);
				userto.setNameArray(nameArray);
			}
			if(userto.getEmailIdArray()!=null && userto.getEmailIdArray().length > 0)
				fillForm(clientForm, userto);
			/*  hide this emailId for backup while editing host details as the admin can 
			 * change emailId also.*/
			clientForm.setEmailIdDummy(userto.getEmailId()); 
			request.setAttribute("client", rest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("editclient");
	}
	
	private void fillForm(UserForm form2, UserTO locationsInfo){
		for(int i = 0; i<locationsInfo.getEmailIdArray().length; i++ ){
			switch(i){
			case 0: form2.setEmailIdOne(locationsInfo.getEmailIdArray()[i]);
			        form2.setNameOne(locationsInfo.getNameArray()[i]);
			        break;
			case 1: form2.setEmailIdTwo(locationsInfo.getEmailIdArray()[i]);
					form2.setNameTwo(locationsInfo.getNameArray()[i]);
			        break;
			case 2: form2.setEmailIdThree(locationsInfo.getEmailIdArray()[i]);
					form2.setNameThree(locationsInfo.getNameArray()[i]);
					break;
			case 3: form2.setEmailIdFour(locationsInfo.getEmailIdArray()[i]);
					form2.setNameFour(locationsInfo.getNameArray()[i]);
					break;
			case 4: form2.setEmailIdFive(locationsInfo.getEmailIdArray()[i]);
					form2.setNameFive(locationsInfo.getNameArray()[i]);
					break;				
			
			}
		}
		
	}
}
