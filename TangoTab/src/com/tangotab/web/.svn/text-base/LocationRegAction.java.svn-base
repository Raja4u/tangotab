package com.tangotab.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LocationForm;

public class LocationRegAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

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

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages messages = new ActionMessages();
		String userId = null;
		LocationForm locationForm = (LocationForm) form;
		HttpSession session = request.getSession();
		UserTO useTO = (UserTO) session.getAttribute("userInfo");
		LocationTO locationTO = new LocationTO();
	    userId = locationForm.getManagerId();
		if (userId != null && userId.length() > 0)
			userId = userId.trim();
		/* If dealmanager mailid matches with host emailId then setting host as manager true to 
		 * stop emails and not to generate new passwords */
		if(useTO.getEmailId().equals(locationForm.getEmailId()))
			locationForm.setHostAsManager("Yes");
		
		if(locationForm.getHostAsManager().equals("No"))
		  if (userId == null || userId.length() < 1) {
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
			} catch (Exception e) {
			}
			
			locationTO.setAlternateEmailIds(TangoTabUtility.makeAlternateEmailsList(locationForm));
			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/client/";

			locationTO.setLocationRestImgPath(ImageSaveUtility.saveFile(directionImgRealPath,
					locationForm.getLocationImage(), "restLocation"));
			
									
			if(locationForm.getHostAsManager().equals("Yes")){
				locationTO.setUserId(userBo.getUserIdByMailId(locationForm.getEmailId()));
				locationTO.setPassword(useTO.getPassword());
				//locationTO.setUserTo(useTO);
				
			}
			if (userId != null && userId.length() > 0)
				locationTO.setUserId(Integer.parseInt(userId)); // sets userId only upon selecting
																// existed manager
			locationTO.setRestaurantId(useTO.getRestaurantId());
			locationTO.setIsActive((short)1);
			locationBO.saveLocation(locationTO, useTO.getEmailId());
			
			useTO.setNoOfEnteredLocatios(useTO.getNoOfEnteredLocatios() + 1);

			session.removeAttribute("userInfo");
			session.setAttribute("userInfo", useTO);
			//add servlet context
			
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO=com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setRestaurants(commonBO.getAllLocations());
			context.removeAttribute("dropDownList");
			context.setAttribute("dropDownList", dropDownInfo);	
			
		} catch (ApplicationException e) {
			e.printStackTrace();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
}
