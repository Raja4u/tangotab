package com.tangotab.web;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.tangotab.business.RestaurantDiscountBO;
import com.tangotab.dao.pojo.RestaurantDiscount;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.RestaurantDiscountForm;

public class RestaurantDiscountAction extends DispatchAction {

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String targetAction = new String("failure");

		RestaurantDiscountForm creditDiscountVO = (RestaurantDiscountForm) form;
		try {

			boolean status = true;
			if (request.getParameter("id") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				creditDiscountVO.setDiscountAmount(10.0);
				creditDiscountVO.setRestLocationId(1);
				creditDiscountVO.setRestDiscountId(1);
				creditDiscountVO.setReferredBy("rathnakar");
				request.setAttribute("id", id);
				status = false;

				targetAction = "insert";
			}
			
			if (status) {
				targetAction = "insert";
			}
			return mapping.findForward(targetAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String targetAction = new String("failure");

		RestaurantDiscountForm restaurantDiscountForm = (RestaurantDiscountForm) form;
		RestaurantDiscount discount = new RestaurantDiscount();
		try {
		 
			discount.setDiscountAmount(restaurantDiscountForm.getDiscountAmount());
			discount.setReferredBy(restaurantDiscountForm.getReferredBy());
			discount.setReasonForDiscount(restaurantDiscountForm.getReasonForDiscount());
			discount.setRestLocationId(restaurantDiscountForm.getRestLocationId());
			discount.setStartDate(new Timestamp(DateConverterUtility.convertUiToServiceDate(restaurantDiscountForm.getStartDate()).getTime()));
					
			
			discount.setEndDate(new Timestamp(DateConverterUtility.convertUiToServiceDate(restaurantDiscountForm.getEndDate()).getTime()));
			
			
			RestaurantDiscountBO crediDiscountBO = com.tangotab.businessImpl.BusinessFactory.getRestaurantDiscountBO();
			boolean status = true;

			discount.setIsActive((short) 1);
			crediDiscountBO.saveCreditDiscount(discount);

			if (status) {
				targetAction = new String("display");
			}
			return mapping.findForward(targetAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String targetAction = new String("failure");

		try {

			boolean status = true;
			List<RestaurantDiscountForm> list = new ArrayList<RestaurantDiscountForm>();

			request.setAttribute("creditDiscount", list);
			if (status) {
				targetAction = new String("display");
			}
			return mapping.findForward(targetAction);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering Rest");

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		RestaurantDiscount restaurantDiscount = new RestaurantDiscount();
		ActionMessages messages = new ActionMessages();
		try {

			String restid[] = request.getParameterValues("restDiscountId");
			String isactive[] = request.getParameterValues("isActive");
			RestaurantDiscountBO reDiscountBO = com.tangotab.businessImpl.BusinessFactory.getRestaurantDiscountBO();

			for (int i = 0; i < restid.length; i++) {
				
				restaurantDiscount = reDiscountBO.getRestauantDiscountDetails(Integer
						.parseInt(restid[i]));

				restaurantDiscount.setIsActive(Short.parseShort(isactive[i]));

				reDiscountBO.updateRestarentDiscount(restaurantDiscount);
			}
			request.setAttribute("msg", "Successfully Updated");

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}

		return mapping.findForward("display");

	}

}