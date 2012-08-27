package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRegForm;

public class AdminDealUpdateAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		DealRegForm dealForm = (DealRegForm) form;
		ActionMessages actionMessages = new ActionMessages();
		DealTO dealTO = new DealTO();
		String viewDeals = "";
		try {
			if(StringUtils.isNotEmpty(request.getParameter("viewpage"))){
				viewDeals = request.getParameter("viewpage");
				dealForm.setDealPage(viewDeals);
			}
			try {
				if(StringUtils.isEmpty(dealForm.getRestDealPublishedDate()))
					  dealForm.setRestDealPublishedDate(null);
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
			if (StringUtils.isNotEmpty(dealForm.getDealImage().getFileName())) {
				String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
						+ "images/deal/";
				dealTO.setRestDealImagePath(ImageSaveUtility.saveFile(directionImgRealPath,
						dealForm.getDealImage(), "adminDeal"));
			} else {
				dealTO.setRestDealImagePath(dealForm.getExistImagePath());
			}
			locationBO.updateDeal(dealTO);

		} catch (ApplicationException e) {
			e.printStackTrace();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		
		/* If deal Edit is came from View Deals page then it should redirect to 
		 * only view deals page not to pending page */
		if(dealForm.getDealPage()!= null){
			if( StringUtils.isNotEmpty(dealForm.getRestaurantId()) && !dealForm.getRestaurantId().equals("0") ){
			    request.setAttribute("restId", dealForm.getRestaurantId());
		}
			return mapping.findForward("viewdeals");
		}
			
		else
		    return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
