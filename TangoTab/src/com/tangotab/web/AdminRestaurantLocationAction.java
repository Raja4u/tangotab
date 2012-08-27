/**
 * 
 */
package com.tangotab.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LocationForm;


public class AdminRestaurantLocationAction extends BaseDispatchAction {

	public static Logger log = LoggerFactory.getLogger(AdminRestaurantLocationAction.class);
	
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
		log.debug("Entering retrieve location Action");
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		ActionMessages messages = new ActionMessages();
		SortByTO sortByTO=new SortByTO();
		int currentPage = 0;
		/* checking for the first time or not */		
		if(request.getParameter("num") == null){
		try {
			sortByTO.setDate(TangotabConstants.ASCENDING);
			sortByTO.setName(TangotabConstants.ASCENDING);
			/*calculates total pages and set to request scope for display 1 2 3..*/
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
		
		ArrayList<Restaurant> location = null;
		try {
			location = userBo.getAllRestaurants(currentPage,sortByTO);

			if (location == null || location.size() == 0) {

				request.setAttribute("size", location.size());
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else {
				/* setting no of locations to present locations and change date
				 * to UIdate for display */
				int i = 0;
				for (Restaurant rest : location) {
					int nooflocs = 0;
					if(rest.getRestaurantLocations() != null)
						nooflocs = rest.getRestaurantLocations().size();
					//nooflocs = locationBo.getNoOfLocations(rest.getRestaurantId());
					location.get(i).setNoOfLocations(nooflocs);
					location.get(i).getUser().setZipCode(DateConverterUtility.
							convertDBTimeStampToUiDate(location.get(i).getUser().getUserCreateDate()));
					i++;
				}
			}
			if(currentPage==0)
			{		currentPage=1;
				sortByTO.setDate(null);
			}else 	if(currentPage==-1)
			{
				currentPage=1;
				sortByTO.setName(null);
			}
			request.setAttribute("sort",sortByTO);
			request.setAttribute("adminLocation", location);
			request.setAttribute("currentPage", currentPage);
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
	
	/* Display businessnames according to search criteria */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		 LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
		String name = request.getParameter("searchname");
		String hname = request.getParameter("hsearch");
		ActionMessages messages = new ActionMessages();
		ArrayList<Restaurant> restList = null;
		SortByTO sortByTO=new SortByTO();
		int currentPage = 0;

		try {
			/* test if is for the first time or not. Displays first set of records only if
			 * name entered for first time or page request is empty or searchname changed.*/
			if((request.getParameter("num") == null || hname == null)||(!name.equals(hname) )){
					int total = (int)userBo.countRestaurantByName(name);
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
				/* setting no of locations to present locations  and change date
				 * to UIdate for display */
				int i = 0;
				for (Restaurant rest : restList) {
					int nooflocs = 0;
					//if(rest.getRestaurantLocations() != null)
					//	nooflocs = rest.getRestaurantLocations().size();
					nooflocs = locationBo.getNoOfLocations(rest.getRestaurantId());
					restList.get(i).setNoOfLocations(nooflocs);
					/* set date to zipcode field only for display purpose */
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
			request.removeAttribute("adminLocation");
			request.setAttribute("adminLocation", restList);
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


	public ActionForward updateStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		{
			String methodName = request.getParameter(mapping.getParameter());
			log.debug("Method Name: " + methodName);
			String Lid[] = request.getParameterValues("restLocationId");
			String Status[] = request.getParameterValues("isActive");
			String ChangedLocIds[] = request.getParameterValues("flag"); // indicator whether status
																			// has been changed or
																			// not
			LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
			ActionMessages messages = new ActionMessages();
			ArrayList<RestaurantLocation> list = null;
			try {
				for (int i = 0; i < Lid.length; i++) {
					if (Integer.parseInt(ChangedLocIds[i]) == Integer.parseInt(Lid[i])) {
						@SuppressWarnings("unused")
						boolean status = locationBo.setLocationStatus(Integer.parseInt(Lid[i]),
								Short.parseShort(Status[i]));
					}
				}
				setLocations();
				int restaurantId = 0;
				if (request.getParameter("restid") != null)
					restaurantId = Integer.parseInt(request.getParameter("restid"));
				list = locationBo.getRestaurantLocations(restaurantId);
				request.setAttribute("size", list.size());
				request.setAttribute("restList", list);
				request.setAttribute("restid", restaurantId);
			} catch (Exception e) {
				messages.add("message", new ActionMessage("msg.failure",
						"Update status is not successful"));
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.FAILURE);
			}
			messages
					.add("message", new ActionMessage("msg.success", "Update status is successful"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.SUCCESS);
		}
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		 LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		ActionMessages messages = new ActionMessages();
		try {
			int restaurantId = 0;
			int noOfLoc = 0;
			String businessname = null;
			if (request.getParameter("businessName") != null)
				businessname = request.getParameter("businessName");
			if (request.getParameter("restid") != null)
				restaurantId = Integer.parseInt(request.getParameter("restid"));
			if (request.getParameter("no") != null)
				noOfLoc = Integer.parseInt(request.getParameter("no"));
			ArrayList<RestaurantLocation> list = locationBo.getRestaurantLocations(restaurantId);
			/*  acts like a flag to enable or disable NEW Location button */
			request.setAttribute("add", "yes");
			if (list == null || list.size() == 0) {
				request.setAttribute("size", list.size());
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else if (list.get(0).getRestaurant().getNoOfLocations() == list.size())
				request.setAttribute("add", "no");

			request.setAttribute("restList", list);
			request.setAttribute("restid", restaurantId);
			request.setAttribute("businessName", businessname);

		} catch (ApplicationException e) {

			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Insert a location */
	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		UserBO userDao = BusinessFactory.getUserBO();
		LocationForm lform = (LocationForm) form;
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		HttpSession session = request.getSession();
		try {
			int restaurantId = 0;
			if (request.getParameter("restid") != null) {
				restaurantId = Integer.parseInt(request.getParameter("restid"));

			}

			String businessName = null;
			if (request.getParameter("businessName") != null) {
				businessName = request.getParameter("businessName");
				lform.setBusinessName(businessName);
			}

			session.setAttribute("businessname", businessName);
			session.setAttribute("restid", restaurantId);

			ArrayList<RestaurantLocation> locations = new ArrayList<RestaurantLocation>();
			ArrayList<RestaurantLocation> managers = (ArrayList<RestaurantLocation>) userDao
					.getLocationManagers(restaurantId);
				Restaurant restaurant=(Restaurant)userDao.getRestaurantById(restaurantId);
				session.setAttribute("rest", restaurant);
			for (Object mgr : managers) {
				RestaurantLocation loc = new RestaurantLocation();
				Object[] details = (Object[]) mgr;

				loc.setStateId((Integer) details[0]);
				loc.setWebSite((String) details[1]);
				loc.setDescription((String) details[2]);
				loc.setZipCode((String) details[3]);
				loc.setAddress((String) details[4]);
				locations.add(loc);
			}
			session.setAttribute("managers", locations);

		} catch (Exception e) {
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("insert");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		 LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
		ActionMessages messages = new ActionMessages();
		LocationForm locationForm = (LocationForm) form;
		LocationTO locationTO = new LocationTO();
		UserTO user = new UserTO();
		String userId = new String();
		HttpSession session = request.getSession();
		session.removeAttribute("managers");
		Restaurant rest = (Restaurant)session.getAttribute("rest");
		userId = locationForm.getManagerId();
		if (userId != null && userId.length() > 0)
			userId = userId.trim();
		/* If dealmanager mailid matches with host emailId then setting host as manager true to 
		 * stop emails and not to generate new passwords */
		if(rest.getUser().getEmailId().equals(locationForm.getEmailId()))
			locationForm.setHostAsManager("Yes");
		
		if(locationForm.getHostAsManager().equals("No"))
		 if (userId == null || (userId != null && userId.length() < 1)) {

			if (userBo.checkUserAvailability(locationForm.getEmailId(),
					TangotabConstants.RESTAURANT_STORE_MANAGER)) {
				messages.add("message", new ActionMessage("errors.emailexist",
						"Email Id already exists"));
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.FAILURE);
			}
		}
		try {
			try {
				BeanUtils.copyProperties(locationTO, locationForm);
				if(locationForm.getHostAsManager().equals("Yes") && rest != null){					 
					locationTO.setUserId(userBo.getUserIdByMailId(locationForm.getEmailId())); 
					locationTO.setPassword(rest.getUser().getPassword());   
					//locationTO.setZipCode(rest.getUserBO().getZipCode());
					//locationTO.setStateId(rest.getUserBO().getStateId());
					//locationTO.setCityId(rest.getUserBO().getCityId());
					//locationTO.setCountryId(rest.getUserBO().getCountryId());
				}

			} catch (Exception e) {
			}
			locationTO.setAlternateEmailIds( TangoTabUtility.makeAlternateEmailsList(locationForm));
			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/client/";
			int restaurantId = 0;
			if (request.getParameter("restid") != null)
				restaurantId = Integer.parseInt(request.getParameter("restid"));
			if (userId != null && userId.length() > 0)
				locationTO.setUserId(Integer.parseInt(userId));
			locationTO.setLocationRestImgPath(ImageSaveUtility.saveFile(directionImgRealPath,
					locationForm.getLocationImage(), "restLocation"));
			
			locationTO.setRestaurantId(restaurantId);
			locationTO.setIsActive((short) 1);
			locationBo.saveAdminLocation(locationTO);
			saveImageInWebApps(locationTO.getRestaurantId() + "_", locationForm.getLocationImage());
			setLocations();
		} catch (ApplicationException e) {
			e.printStackTrace();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		messages
				.add("message", new ActionMessage("msg.success", "creation location is successful"));
		saveMessages(request, messages);
		/* Removing session values which are set in insert method.*/
		session.removeAttribute("restid"); 
		session.removeAttribute("managers");
		session.removeAttribute("businessname");
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
		UserBO userDao = BusinessFactory.getUserBO();
		UserTO user = new UserTO();
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		LocationForm locationForm = (LocationForm) form;
		LocationTO locationTO = new LocationTO();
		LocationTO oldLocation = new LocationTO();
		HttpSession session = request.getSession();
		String mgrid = new String();
		session.removeAttribute("managers");
		oldLocation =(LocationTO) session.getAttribute("locationData");
		session.removeAttribute("locationId");
		session.removeAttribute("businessName");
		session.removeAttribute("locationData");
		String mailid = "";
		ActionMessages messages = new ActionMessages();
		/* the only draw back is if emailid is same as previous then if name, phonne no. changed,, they wil
		 * not update.. need to retrieve the details from db..*/
		try {
			try {
				mailid = (String) request.getParameter("emailIddummy");
				String oldPassword = request.getParameter("oldpassword");
				/* If dealmanager mailid matches with host emailId then setting host as manager true to 
				 * stop emails and not to generate new passwords */
				if(oldLocation.getRestaurantTO().getEmailId().equals(locationForm.getEmailId()))
					locationForm.setHostAsManager("Yes");
				
				BeanUtils.copyProperties(locationTO, locationForm);
				locationTO.setAlternateEmailIds(TangoTabUtility.makeAlternateEmailsList(locationForm));
				mgrid = locationForm.getManagerId();
				if(locationForm.getHostAsManager().equals("Yes")){
					Restaurant rest=(Restaurant)userDao.getRestaurantById(locationForm.getRestaurantId());
					locationTO.setUserId(userBo.getUserIdByMailId(locationForm.getEmailId())); 
					locationTO.setPassword(rest.getUser().getPassword());   
					//locationTO.setZipCode(rest.getUserBO().getZipCode());
					//locationTO.setStateId(rest.getUserBO().getStateId());
					//locationTO.setCityId(rest.getUserBO().getCityId());
					//locationTO.setCountryId(rest.getUserBO().getCountryId());
						 
				}else{				
				/* if directly edited email id or leave as it was */
				if(StringUtils.isNotEmpty(mgrid) && Integer.parseInt(mgrid) == locationForm.getUserId()){
					if(!mailid.equals(locationForm.getEmailId())){
				        if (userBo.checkUserAvailability(locationForm.getEmailId(), 6)) {
						messages.add("message", new ActionMessage("errors.emailexist",
								"Email Id already exists"));
						saveMessages(request, messages);
						return mapping.findForward(TangotabConstants.FAILURE);
				        }
				        else  /* create new user */
				          locationTO.setUserId(0);
					}
				}else if(StringUtils.isEmpty(mgrid) ){
					/* if old manager himself then put his details old ..*/
					  if(mailid.equals(locationForm.getEmailId())){
						  locationTO.setPassword(oldPassword);
					  }
					  /* otherwise check availability and set as new user */
					  else{
						  if (userBo.checkUserAvailability(locationForm.getEmailId(), 6)) {
								messages.add("message", new ActionMessage("errors.emailexist",
										"Email Id already exists"));
								saveMessages(request, messages);
								return mapping.findForward(TangotabConstants.FAILURE);
							}else
						    locationTO.setUserId(0);
					  }
					
				}/* selected existed manager id */
				else if (StringUtils.isNotEmpty(mgrid) && Integer.parseInt(mgrid) != locationForm.getUserId()){
					locationTO.setUserId(Integer.parseInt(mgrid));
				}
			
			
				
				}	
						
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			if (StringUtils.isNotEmpty(locationForm.getLocationImage().getFileName())) {
				String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
						+ "images/client/";
				locationTO.setLocationRestImgPath(ImageSaveUtility.saveFile(directionImgRealPath,
						locationForm.getLocationImage(), "restLocation"));
				
			} else {
				locationTO.setLocationRestImgPath(locationTO.getLocationRestImgPath());
				
			}
			locationTO.setRestLocationId(locationTO.getRestLocationId());
			/* No mail will be sent if email Id not changed */
			if (locationForm.getHostAsManager().equals("Yes") || mailid.equals(locationForm.getEmailId()) )
				locationBo.updateLocation(locationTO, "update"); 
			else
				locationBo.updateLocation(locationTO, "updateM");
			setLocations();
		} catch (ApplicationException e) {
			e.printStackTrace();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		messages.add("message", new ActionMessage("msg.success", "Update location is successful"));
		saveMessages(request, messages);
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	public ActionForward editLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 LocationBO locationBo = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
		log.debug("Entering retrieve location Action");
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		ActionMessages messages = new ActionMessages();
		UserBO userDao = BusinessFactory.getUserBO();
		HttpSession session = request.getSession();
		LocationForm locationForm = (LocationForm) form;

		try {
			String businessname = null;
			if (request.getParameter("businessName") != null)
				businessname = request.getParameter("businessName");
			int locationId = 0;
			if (request.getParameter("restLocationId") != null)
				locationId = Integer.parseInt(request.getParameter("restLocationId"));

			LocationTO locationInfo = locationBo.fetchLocationByLocationId(locationId);
			BeanUtils.copyProperties(locationForm, locationInfo);
			if( locationInfo.getEmailIdArray() != null && locationInfo.getEmailIdArray().length > 0 ){
				fillForm(locationForm, locationInfo);
							
			}
			locationForm.setManagerId(locationInfo.getUserId().toString());

			session.setAttribute("locationData", locationInfo);
			session.setAttribute("locationId", locationId);
			session.setAttribute("businessName", businessname);
			session.setAttribute("locationForm", locationForm);

			ArrayList<RestaurantLocation> locations = new ArrayList<RestaurantLocation>();
			List<RestaurantLocation> managers = (List<RestaurantLocation>) userDao
					.getLocationManagers(locationInfo.getRestaurantId());
			for (Object mgr : managers) {
				RestaurantLocation loc = new RestaurantLocation();
				Object[] details = (Object[]) mgr;

				loc.setStateId((Integer) details[0]);
				loc.setWebSite((String) details[1]);
				loc.setDescription((String) details[2]);
				loc.setZipCode((String) details[3]);
				loc.setAddress((String) details[4]);
				locations.add(loc);
			}
			session.setAttribute("managers", locations);

		} catch (Exception exception) {
			messages.add("No Records", new ActionMessage("result.noRecords", "No Records Found"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	private boolean saveImageInWebApps(String imageSubPath, FormFile image) {
		try {
			String fileName = image.getFileName();

			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/client/";

			if (!fileName.equals("")) {

				File fileToCreate = new File(directionImgRealPath, imageSubPath + fileName);
				if (fileToCreate.exists()) {
					fileToCreate.delete();
					fileToCreate = new File(directionImgRealPath, fileName);
				}
				FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
				fileOutStream.write(image.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
			}
		} catch (FileNotFoundException file) {
			return false;
		} catch (IOException io) {
			return false;
		}
		return true;
	}
	private  void setLocations()
	{
		ServletContext context = servlet.getServletContext();
		DropDownTO dropDownInfo = new DropDownTO();
		dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
		CommonBO commonBO=com.tangotab.businessImpl.BusinessFactory.getCommonBO();
		dropDownInfo.setRestaurants(commonBO.getAllLocations());
		context.removeAttribute("dropDownList");
		context.setAttribute("dropDownList", dropDownInfo);	
	}
	
	private void fillForm(LocationForm form2, LocationTO locationsInfo){
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
