package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DropDownTO;
import com.tangotab.business.DealBO;
import com.tangotab.dao.pojo.DealRestriction;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealRestrictionForm;

public class AdminDealRestrictionAction extends BaseDispatchAction {

	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	/* Display all restrictions */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException,
			ApplicationException {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		ArrayList<DealRestriction> dealrest = null;
		try {
			dealrest = (ArrayList<DealRestriction>) dealBo.getAllRestrictions();
			if (dealrest == null || dealrest.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else
				request.setAttribute("dealrest", dealrest);
			
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Change status of deal restrictions */
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		ArrayList<DealRestriction> dealrest = null;
		boolean b = false;
		try {
			String ids[] = request.getParameterValues("restrictionId");
			String status[] = request.getParameterValues("isActive");
			
			for (int i = 0; i < ids.length; i++) {
				b = dealBo.setRestrictionStatus(Integer.parseInt(ids[i]), Short.parseShort(status[i]));
			}
			dealrest = (ArrayList<DealRestriction>) dealBo.getAllRestrictions();
			
			if (b) {
				
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			dropDownInfo.setDealRestriction(dealrest);
			context.setAttribute("dropDownList", dropDownInfo);
			
			messages.add("No Records", new ActionMessage("result.noRecords",
			"Status Updated Successfully"));
          	saveMessages(request, messages);
			}
			if (dealrest == null || dealrest.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else
				request.setAttribute("dealrest", dealrest);
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Create a new Deal Restriction */
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		DealRestriction rest = new DealRestriction();
		ArrayList<DealRestriction> dealrest = null;
		try {
			DealRestrictionForm rform = (DealRestrictionForm) form;
			BeanUtils.copyProperties(rest, rform);
			if (rest.getRestrictionId() == null || rest.getRestrictionId() < 1) {
				rest.setIsActive(Short.parseShort("1"));
				dealBo.saveRestriction(rest);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"DealRestriction Added Successfully"));
	          	saveMessages(request, messages);
			} 
			else
			{
				dealBo.updateRestriction(rest);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"DealRestriction Updated Successfully"));
				saveMessages(request, messages);
			}

			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			dropDownInfo.setDealRestriction(dealBo.getAllRestrictions());
			// context.removeAttribute("dropDownList");
			context.setAttribute("dropDownList", dropDownInfo);

			dealrest = (ArrayList<DealRestriction>) dealBo.getAllRestrictions();
			if (dealrest == null || dealrest.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else
				request.setAttribute("dealrest", dealrest);

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		} catch (Exception e) {

		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Make a deal ready for Edit */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		DealRestriction rest = new DealRestriction();
		DealRestrictionForm rform = (DealRestrictionForm) form;
		try {
			String id = request.getParameter("id");
			Integer rid = 0;
			if (id != null) {
				rid = Integer.parseInt(id);
				rest = dealBo.getRestrictionById(rid);
				BeanUtils.copyProperties(rform, rest);
			}

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		} catch (Exception e) {

		}

		return mapping.findForward("editable");
	}
}
