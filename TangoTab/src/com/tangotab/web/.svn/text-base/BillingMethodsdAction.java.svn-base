package com.tangotab.web;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.BillingMethodForm;

public class BillingMethodsdAction extends BaseDispatchAction {
	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ApplicationException {
		log.debug("Entering BillingMethodAction");

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		BillingMethodForm billingMethodForm = (BillingMethodForm) form;
		 
		int id = 0;
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

		BillingMethod billingMethod = billingMethodsBO.getBillingMethod(id);

		try {
			BeanUtils.copyProperties(billingMethodForm, billingMethod);

		} catch (Exception e) {

			return mapping.findForward("insert");
		}

		return mapping.findForward("insert");

	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering BillingMethodAction");

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		BillingMethodForm billingMethodForm = (BillingMethodForm) form;

		BillingMethod billingMethod = new BillingMethod();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(billingMethod, billingMethodForm);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			if (billingMethodForm.getBillingMethodId() == 0) {
				billingMethod.setIsActive(1);
				billingMethodsBO.saveBillingMethod(billingMethod);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"BillingMethod Saved Successfully"));
				saveMessages(request, messages);

			} else {
				billingMethodsBO.updateBillingMethod(billingMethod, "Yes");
				messages.add("No Records", new ActionMessage("result.noRecords",
				"BillingMethod Updated Successfully"));
				saveMessages(request, messages);

			}

			List<BillingMethod> list = (ArrayList<BillingMethod>) billingMethodsBO.getBillingMethods();
			session.setAttribute("billingMethodList", list);
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

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		BillingMethodForm billingMethodForm = (BillingMethodForm) form;

		BillingMethod billingMethod = new BillingMethod();

		try {

			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();
			//billingMethodsBO.saveBillingMethod(billingMethod);
			List<BillingMethod> list = billingMethodsBO.getBillingMethods();

			request.setAttribute("billingMethodList", list);
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
		BillingMethodForm billingMethodForm = (BillingMethodForm) form;
		BillingMethod billingMethod = new BillingMethod();
		BillingMethodsBO  billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();
		ActionMessages messages = new ActionMessages();
		try {
			String bid[] = request.getParameterValues("billingMethodId");
			String isactive[] = request.getParameterValues("isActive");
			String billName[] = request.getParameterValues("billingMethodName");
	 
			

			for (int i = 0; i < bid.length; i++) {
 
				billingMethodForm.setBillingMethodId(Integer.parseInt(bid[i]));
				billingMethodForm.setBillingMethodName(billName[i]);
				billingMethodForm.setIsActive(Integer.parseInt(isactive[i]));

				BeanUtils.copyProperties(billingMethod, billingMethodForm);
				billingMethodsBO.updateBillingMethod(billingMethod, "No");
			}
			List<BillingMethod> list = (ArrayList<BillingMethod>) billingMethodsBO.getBillingMethods();
			request.setAttribute("billingMethodList", list);

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
