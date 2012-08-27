package com.tangotab.web;

import java.util.ArrayList;

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
import com.tangotab.TO.UserTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRegForm;

public class DealUpdateAction extends BaseAction {
	private LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		DealRegForm dealForm = (DealRegForm) form;
		ActionMessages actionMessages = new ActionMessages();
		DealTO dealTO = new DealTO();
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
			if (dealForm.getDealImage() != null) {
				if (StringUtils.isNotEmpty(dealForm.getDealImage().getFileName())) {
					String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
							+ "images/deal/";
					dealTO.setRestDealImagePath(ImageSaveUtility.saveFile(directionImgRealPath,
							dealForm.getDealImage(), "adminDeal"));
				}
			} else {
				dealTO.setRestDealImagePath(dealForm.getExistImagePath());
			}
			locationBO.updateDeal(dealTO);

			UserTO userInfo = (UserTO) request.getSession().getAttribute("userInfo");
			ArrayList<DealTO> dealsInfo = locationBO.getDeals(userInfo.getUserId(), userInfo
					.getRoleId(), userInfo.getRestaurantId());
			if (dealsInfo == null || dealsInfo.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"There are No Deals for the dates specified.Please create a new Deal."));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("dealsInfo", dealsInfo);
		} catch (ApplicationException e) {
			e.printStackTrace();
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
