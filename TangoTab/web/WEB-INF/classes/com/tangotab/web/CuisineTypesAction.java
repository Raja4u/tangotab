package com.tangotab.web;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
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

import com.tangotab.TO.DropDownTO;
import com.tangotab.business.BillingMethodsBO;
import com.tangotab.business.CommonBO;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CuisineTypeForm;

public class CuisineTypesAction extends BaseDispatchAction {
	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ApplicationException {
		log.debug("Entering CuisineTypeAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("CuisineType Name: " + typeName);
		CuisineTypeForm cuisineTypeForm = (CuisineTypeForm) form;
	
		int id = 0;
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

		CuisineType cuisineType = billingMethodsBO.getCuisineType(id);

		try {
			BeanUtils.copyProperties(cuisineTypeForm, cuisineType);

		} catch (Exception e) {

			return mapping.findForward("insert");
		}

		return mapping.findForward("insert");

	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering CuisineTypesAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		CuisineTypeForm cuisineTypeForm = (CuisineTypeForm) form;

		CuisineType cuisineType = new CuisineType();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(cuisineType, cuisineTypeForm);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			//List<CuisineType> cuisineTypeList = new ArrayList<CuisineType>();
			//CuisineType cuisine = null;
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			if (cuisineTypeForm.getCuisineTypeId() == 0) {
				cuisineType.setIsActive(1);
				billingMethodsBO.saveCuisineType(cuisineType);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"CuisineType saved Successfully"));
				saveMessages(request, messages);

			} else {
				billingMethodsBO.updateCuisineType(cuisineType, "Yes");
				messages.add("No Records", new ActionMessage("result.noRecords",
				"CuisineType updated Successfully"));
				saveMessages(request, messages);

			}

			ArrayList<CuisineType> list = billingMethodsBO.getCuisineTypes();
			/*java.util.Iterator it = list.iterator();
			while (it.hasNext()) {
				cuisine = (CuisineType) it.next();
			
				cuisineTypeList.add(cuisine);
			}*/

			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setCusineTypes(commonBO.getCuisineTypes());
			context.setAttribute("dropDownList", dropDownInfo);
			
			session.setAttribute("cuisineTypeList", list);
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
		log.debug("Entering BillingMethodAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		CuisineTypeForm cuisineTypeForm = (CuisineTypeForm) form;

		CuisineType cuisineType = new CuisineType();

		try {

			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();
			//billingMethodsBO.saveCuisineType(cuisineType);
			ArrayList<CuisineType> list = billingMethodsBO.getCuisineTypes();
			request.setAttribute("cuisineTypeList", list);
		} catch (ApplicationException e) {

			return mapping.findForward(TangotabConstants.FAILURE);
		}


		return mapping.findForward("display");

	}

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering BillingMethodAction");

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		CuisineTypeForm cuisineTypeForm = (CuisineTypeForm) form;
		CuisineType cuisineType = new CuisineType();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			String bid[] = request.getParameterValues("cuisineTypeId");
			String isactive[] = request.getParameterValues("isActive");
			String billName[] = request.getParameterValues("type");
			CuisineType billing = null;
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			for (int i = 0; i < bid.length; i++) {
				cuisineTypeForm.setCuisineTypeId(Integer.parseInt(bid[i]));
				cuisineTypeForm.setType(billName[i]);
				cuisineTypeForm.setIsActive(Integer.parseInt(isactive[i]));
				BeanUtils.copyProperties(cuisineType, cuisineTypeForm);
				billingMethodsBO.updateCuisineType(cuisineType, "No");
			}
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setCusineTypes(commonBO.getCuisineTypes());
			context.setAttribute("dropDownList", dropDownInfo);
			
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
