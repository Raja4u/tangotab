package com.tangotab.web;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.business.BillingMethodsBO;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.RestaurantTypeForm;

public class RestTypeAction extends BaseDispatchAction {
	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ApplicationException {
		log.debug("Entering RestTypeAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("RestType Name: " + typeName);
		RestaurantTypeForm restaurantTypeForm = (RestaurantTypeForm) form;
		
		int id = 0;
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

		RestaurantType restaurantType = billingMethodsBO.getRestaurantType(id);

		try {
			BeanUtils.copyProperties(restaurantTypeForm, restaurantType);

		} catch (Exception e) {

			return mapping.findForward("insert");
		}

		return mapping.findForward("insert");

	}

	@SuppressWarnings("unchecked")
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering CuisineTypesAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		RestaurantTypeForm restaurantTypeForm = (RestaurantTypeForm) form;

		RestaurantType restaurantType = new RestaurantType();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(restaurantType, restaurantTypeForm);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			//List<RestaurantType> restaurantTypeList = new ArrayList<RestaurantType>();
			//RestaurantType restaurant = null;
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			if (restaurantTypeForm.getRestTypeId() == 0) {
				restaurantType.setIsActive(1);
				billingMethodsBO.saveRestaurantType(restaurantType);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"RestaurantType Saved Successfully"));
				saveMessages(request, messages);

			} else {
				billingMethodsBO.updateRestaurantType(restaurantType, "Yes");
				messages.add("No Records", new ActionMessage("result.noRecords",
				"RestaurantType Updated Successfully"));
				saveMessages(request, messages);
			}

			ArrayList<RestaurantType> list =(ArrayList<RestaurantType>) billingMethodsBO.getRestaurantTypes();
			/*java.util.Iterator it = list.iterator();
			while (it.hasNext()) {
				restaurant = (RestaurantType) it.next();
				
				restaurantTypeList.add(restaurant);
			}*/

			session.setAttribute("restaurantTypeList", list);
		} catch (ApplicationException e) {

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		
		return mapping.findForward("display");

	}

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IllegalAccessException, InvocationTargetException {
		log.debug("Entering Restaurant Type Action");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		
		RestaurantType restaurantType = new RestaurantType();

		try {

			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();
			//billingMethodsBO.saveRestaurantType(restaurantType);
			ArrayList<RestaurantType> list = billingMethodsBO.getRestaurantTypes();

			request.setAttribute("restaurantTypeList", list);
		} catch (ApplicationException e) {

			return mapping.findForward(TangotabConstants.FAILURE);
		}
		
		return mapping.findForward("display");

	}

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering RestaurantType Action");

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		RestaurantTypeForm restaurantTypeForm = (RestaurantTypeForm) form;
		RestaurantType restaurantType = new RestaurantType();
		ActionMessages messages = new ActionMessages();
		try {
			String bid[] = request.getParameterValues("restTypeId");
			String isactive[] = request.getParameterValues("isActive");
			String billName[] = request.getParameterValues("restTypeName");
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			for (int i = 0; i < bid.length; i++) {
				restaurantType = new RestaurantType();
				restaurantTypeForm.setRestTypeId(Integer.parseInt(bid[i]));
				restaurantTypeForm.setRestTypeName(billName[i]);
				restaurantTypeForm.setIsActive(Integer.parseInt(isactive[i]));
				
				BeanUtils.copyProperties(restaurantType, restaurantTypeForm);
				billingMethodsBO.updateRestaurantType(restaurantType, "No");
			}

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		messages.add("No Records", new ActionMessage("result.noRecords",
		"Status Updated Successfully"));
		saveMessages(request, messages);
		return mapping.findForward("display");

	}

}
