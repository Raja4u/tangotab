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
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.BillingTypeForm;

public class BillingTypesAction extends BaseDispatchAction {
	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ApplicationException {
		log.debug("Entering BillingMethodAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		BillingTypeForm billingTypeForm = (BillingTypeForm) form;
		
		int id = 0;
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

		BillingType billingType = billingMethodsBO.getBillingType(id);

		try {
			BeanUtils.copyProperties(billingTypeForm, billingType);

		} catch (Exception e) {

			return mapping.findForward("insert");
		}

		return mapping.findForward("insert");

	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering BillingTypeAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		BillingTypeForm billingTypeForm = (BillingTypeForm) form;

		BillingType billingType = new BillingType();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(billingType, billingTypeForm);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			if (billingTypeForm.getBillingTypeId() == 0) {
				billingType.setIsActive(1);
				billingMethodsBO.saveBillingType(billingType);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"BillingType Saved Successfully"));
				saveMessages(request, messages);
				
			} else {
				billingMethodsBO.updateBillingType(billingType, "Yes");
				messages.add("No Records", new ActionMessage("result.noRecords",
				"BillingType Updated Successfully"));
				saveMessages(request, messages);
			}

			ArrayList<BillingType> list = (ArrayList<BillingType>)billingMethodsBO.getBillingTypes();
			
			session.setAttribute("billingTypeList", list);
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
		log.debug("Entering BillingTypeAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		BillingTypeForm billingTypeForm = (BillingTypeForm) form;

		BillingType billingType = new BillingType();

		try {

			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();
			//billingMethodsBO.saveBillingType(billingType);
			ArrayList<BillingType> list = billingMethodsBO.getBillingTypes();

			request.setAttribute("billingTypeList", list);
		} catch (ApplicationException e) {

			return mapping.findForward(TangotabConstants.FAILURE);
		}


		return mapping.findForward("display");

	}

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering BillingTypeAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		BillingTypeForm billingTypeForm = (BillingTypeForm) form;
		BillingType billingType = new BillingType();
 
		ActionMessages messages = new ActionMessages();
		try {
			String bid[] = request.getParameterValues("billingTypeId");
			String isactive[] = request.getParameterValues("isActive");
			String billName[] = request.getParameterValues("billingTypeName");
			BillingType billing = null;
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			for (int i = 0; i < bid.length; i++) {
		
				billingTypeForm.setBillingTypeId(Integer.parseInt(bid[i]));
				billingTypeForm.setBillingTypeName(billName[i]);
				billingTypeForm.setIsActive(Integer.parseInt(isactive[i]));

				BeanUtils.copyProperties(billingType, billingTypeForm);
				billingMethodsBO.updateBillingType(billingType, "No");
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
