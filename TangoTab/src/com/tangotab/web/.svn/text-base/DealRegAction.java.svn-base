package com.tangotab.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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

import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRegForm;

public class DealRegAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	private boolean saveImageInWebApps(String imageSubPath, FormFile image) {
		try {
			String fileName = image.getFileName();
			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/deal/";
			if (!fileName.equals("")) {
				File fileToCreate = new File(directionImgRealPath, imageSubPath + fileName);

				if (fileToCreate.exists()) {
					fileToCreate.delete();
					fileToCreate = new File(directionImgRealPath, imageSubPath + fileName);
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

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		DealRegForm dealForm = (DealRegForm) form;
		ActionMessages actionMessages = new ActionMessages();
		DealTO dealTO = new DealTO();
		HttpSession httpSession =request.getSession();
		ArrayList<RestaurantLocation> location =null;
		if(httpSession.getAttribute("location")!=null)
		{
		  location =(ArrayList<RestaurantLocation>)httpSession.getAttribute("location");
		}
 
		try {
			try {
				BeanUtils.copyProperties(dealTO, dealForm);
				dealTO.setRestDealStartDate(DateConverterUtility
						.convertUiToServiceDate(dealForm.getStartDate()));
				dealTO.setRestDealEndDate(DateConverterUtility
						.convertUiToServiceDate(dealForm.getDealEndDate()));
				
				if(dealForm.getAvailableEndTime() == null){
					String endTime = request.getParameter("endT");
					if(StringUtils.isNotEmpty(endTime))
					    dealTO.setAvailableEndTime(endTime);
				}
			} catch (Exception e) {
			}
			UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/deal/";
			

				if (dealForm.getDealImage() != null && StringUtils.isNotEmpty(dealForm.getDealImage().getFileName()) ) {
					
						dealTO.setRestDealImagePath(ImageSaveUtility.saveFile(directionImgRealPath,
								dealForm.getDealImage(), "restLocationDeal"));
					
				}
				/*else {
					dealTO.setRestDealImagePath(dealForm.getExistImagePath());
			    }*/
			if (dealForm.getDealTemplateName().equals("custom")) {
				dealTO.setDealTemplateDescription(dealForm.getCustdealdesc());
			}
			ArrayList<LocationTO> locationsInfo = new ArrayList<LocationTO>();
			if (dealTO.getRestLocationId() == 0 && userInfo.getRoleId()!=1) {
				locationsInfo = locationBO.getLocationsByRestaurantId(userInfo.getRestaurantId());
				if (userInfo.getRoleId() == 6) {

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
					request.setAttribute("locationsInfo", locationsInfo);

				}
				for(LocationTO loc:locationsInfo){
					if(loc.getIsActive()==1)
					{
					dealTO.setRestLocationId(((LocationTO) loc).getRestLocationId());
					dealTO.setLocationName(((LocationTO) loc).getLocationRestName());
					 locationBO.saveDeal(dealTO);
					}
				}
				}
			else if (dealTO.getRestLocationId() == 0 && userInfo.getRoleId()==1){
				if(httpSession.getAttribute("location")!=null)
				{
				for(RestaurantLocation restaurantLocation:location)
				{
			
					if(restaurantLocation.getIsActive()==1)
					{
						dealTO.setRestLocationId(restaurantLocation.getRestLocationId());
						dealTO.setLocationName(restaurantLocation.getLocationRestName());
						 locationBO.saveDeal(dealTO);
					}
				}
				}
			/*	if(!StringUtils.isEmpty(restid)){
					locationsInfo = locationBO.getLocationsByRestaurantId(Integer.parseInt(restid));
					for(LocationTO loc:locationsInfo){
						if(loc.getIsActive()==1)
						{
						dealTO.setRestLocationId(((LocationTO) loc).getRestLocationId());
						dealTO.setLocationName(((LocationTO) loc).getLocationRestName());
						 locationBO.saveDeal(dealTO);
						}
					}
				}*/
			} else
			{
				if(httpSession.getAttribute("location")!=null)
				{
				for(RestaurantLocation restaurantLocation:location)
				{
			
					if(restaurantLocation.getRestLocationId().equals(dealTO.getRestLocationId()))
					{
						dealTO.setLocationName(restaurantLocation.getLocationRestName());
					}
				}
				}else 
				{
				LocationTO locationTO=locationBO.fetchLocationByLocationId(dealTO.getRestLocationId());
				dealTO.setLocationName(locationTO.getLocationRestName());
				}
				locationBO.saveDeal(dealTO);
			}

			if (dealForm.getDealTemplateName().equals("custom") && userInfo.getRoleId() != 1) {
				actionMessages
						.add(
								"No Records",
								new ActionMessage(
										"result.noRecords",
										"Thank you for creating a new offer!<br/> Your offer will be reviewed as quickly as possible. " +
										" You will receive an email as soon as it's published." +
										"<br/> Please contact your Account Manager if you have any questions."));
				saveMessages(request, actionMessages);
				if(httpSession.getAttribute("location")!=null)
					httpSession.removeAttribute("location");
				return mapping.findForward(TangotabConstants.SUCCESS);
			} else {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"Thank you for creating an offer."));
				saveMessages(request, actionMessages);

			}
			
			if(userInfo.getRoleId() != 1){
			ArrayList<DealTO> dealsInfo = locationBO.getDeals(userInfo.getUserId(), userInfo
					.getRoleId(), userInfo.getRestaurantId());
			if (dealsInfo == null || dealsInfo.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"You have no deals at present. Please create Deal."));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("dealsInfo", dealsInfo);
			}/* If admin creates then come here and if it is custom deal go to pending page */
			else if (dealForm.getDealTemplateName().equals("custom")){
			//	int locid = dealTO.getRestLocationId();
				if(httpSession.getAttribute("location")!=null)
					httpSession.removeAttribute("location");
				return mapping.findForward("pending");
			}/* otherwise go to create deals page  */
			else{				
				if(httpSession.getAttribute("location")!=null)
					httpSession.removeAttribute("location");
				return mapping.findForward(TangotabConstants.SUCCESS);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
