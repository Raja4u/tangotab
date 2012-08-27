package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.RestaurantAdminBO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class RestManageAction extends Action {
	public static Logger log = LoggerFactory.getLogger(ConsumerUpdateAction.class);
	private RestaurantAdminBO restaurantAdminBO = com.tangotab.businessImpl.BusinessFactory.getRestaurantAdminBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages messages = new ActionMessages();

		try {

			ArrayList<Restaurant> list = restaurantAdminBO.getRestaurant();

			request.setAttribute("restList", list);

		} catch (ApplicationException e) {

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

}
