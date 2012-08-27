package com.tangotab.web;

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

public class LocationUpdateAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();
	private UserBO userbo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages messages = new ActionMessages();
		HttpSession session = request.getSession();
		UserTO useTO = (UserTO) session.getAttribute("userInfo");
		LocationForm locationForm = (LocationForm) form;
		LocationTO locationTO = new LocationTO();
		String mgrid = new String();
		String mailid = "";
		String oldPassword = request.getParameter("oldpassword");
		try {
			try {
				mailid = (String) request.getParameter("emailIddummy");
				/* If dealmanager mailid matches with host emailId then setting host as manager true to 
				 * stop emails and not to generate new passwords */
				if(useTO.getEmailId().equals(locationForm.getEmailId()))
					locationForm.setHostAsManager("Yes");
				
				BeanUtils.copyProperties(locationTO, locationForm);
				locationTO.setAlternateEmailIds(TangoTabUtility.makeAlternateEmailsList(locationForm));
				mgrid = locationForm.getManagerId();
				if(locationForm.getHostAsManager().equals("Yes")){
					locationTO.setUserId(userbo.getUserIdByMailId(locationForm.getEmailId()));
					locationTO.setPassword(useTO.getPassword());
					locationTO.setIsActive(useTO.getIsActive());
					//locationTO.setZipCode(useTO.getZipCode());
					//locationTO.setStateId(useTO.getStateId());
					//locationTO.setCountryId(useTO.getCountryId());
					//locationTO.setCityId(useTO.getCityId());
					//locationTO.setUserTo(useTO);
				}else{				
				/* if directly edited email id or leave as it was */
				if(StringUtils.isNotEmpty(mgrid) && Integer.parseInt(mgrid) == locationForm.getUserId()){
					if(!mailid.equals(locationForm.getEmailId()))
				        if (userbo.checkUserAvailability(locationForm.getEmailId(), 6)) {
						messages.add("message", new ActionMessage("errors.emailexist",
								"Email Id already exists"));
						saveMessages(request, messages);
						return mapping.findForward(TangotabConstants.FAILURE);
				        }
				        else  /* create new user */
					       locationTO.setUserId(0);
				}else if(StringUtils.isEmpty(mgrid) ){
					/* if old manager himself then put his details old ..*/
					  if(mailid.equals(locationForm.getEmailId())){
						  locationTO.setPassword(oldPassword);
					  }
					  /* otherwise check availability and set as new user */
					  else{
						  if (userbo.checkUserAvailability(locationForm.getEmailId(), 6)) {
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
			/*
			 * string passed for the identification of changed manager inorder to send mail for new
			 * or changed manager
			 */
			if (locationForm.getHostAsManager().equals("Yes") || mailid.equals(locationForm.getEmailId()) )
				locationBO.updateLocation(locationTO, "update"); // no mail will be sent if emailid
																	// not changed
			else
				locationBO.updateLocation(locationTO, "updateM");
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
