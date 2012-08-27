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
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DiningStyleForm;

public class DiningStyleAction extends BaseDispatchAction {
	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, ApplicationException {
		log.debug("Entering CuisineTypeAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("DiningStyle Name: " + typeName);
		DiningStyleForm diningStyleForm = (DiningStyleForm) form;
	
		int id = 0;
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

		DiningStyle diningStyle = billingMethodsBO.getDiningStyle(id);

		try {
			BeanUtils.copyProperties(diningStyleForm, diningStyle);

		} catch (Exception e) {

			return mapping.findForward("insert");
		}

		return mapping.findForward("insert");

	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IllegalAccessException,
			InvocationTargetException {
		log.debug("Entering DiningStyleAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		DiningStyleForm diningStyleForm = (DiningStyleForm) form;
		
		

		DiningStyle diningStyle = new DiningStyle();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(diningStyle, diningStyleForm);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			if (diningStyleForm.getDiningStyleId() == 0) {
				diningStyle.setIsActive(1);
				billingMethodsBO.saveDiningStyle(diningStyle);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"DiningStyle Saved Successfully"));
				saveMessages(request, messages);
				
			} else {
				billingMethodsBO.updateDiningStyle(diningStyle, "Yes");
				messages.add("No Records", new ActionMessage("result.noRecords",
				"DiningStyle Updated Successfully"));
				saveMessages(request, messages);
			}

			ArrayList<DiningStyle> list = billingMethodsBO.getDiningStyles();
			/*java.util.Iterator it = list.iterator();
			while (it.hasNext()) {
				dining = (DiningStyle) it.next();
				diningStyleList.add(dining);
			}*/
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setDiningStyles(commonBO.getDiningStyles());
			context.setAttribute("dropDownList", dropDownInfo);

			session.setAttribute("diningStyleList", list);
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
		log.debug("Entering DiningStyleAction");

		String typeName = request.getParameter(mapping.getParameter());
		log.debug("Type Name: " + typeName);
		DiningStyleForm diningStyleForm = (DiningStyleForm) form;

		DiningStyle diningStyle = new DiningStyle();

		try {

			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();
			//billingMethodsBO.saveDiningStyle(diningStyle);
			ArrayList<DiningStyle> list = billingMethodsBO.getDiningStyles();

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
		DiningStyleForm diningStyleForm = (DiningStyleForm) form;
		DiningStyle diningStyle = new DiningStyle();
 
		ActionMessages messages = new ActionMessages();
		try {
			String bid[] = request.getParameterValues("diningStyleId");
			String isactive[] = request.getParameterValues("isActive");
			String billName[] = request.getParameterValues("diningStyleName");
 
			BillingMethodsBO billingMethodsBO = com.tangotab.businessImpl.BusinessFactory.getBillingMethodsBO();

			for (int i = 0; i < bid.length; i++) {
					
				diningStyleForm.setDiningStyleId(Integer.parseInt(bid[i]));
				diningStyleForm.setDiningStyleName(billName[i]);
				diningStyleForm.setIsActive(Integer.parseInt(isactive[i]));
						
				BeanUtils.copyProperties(diningStyle, diningStyleForm);
				billingMethodsBO.updateDiningStyle(diningStyle, "No");
			}
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setDiningStyles(commonBO.getDiningStyles());
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
