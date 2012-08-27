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
import com.tangotab.dao.pojo.DealName;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealNameForm;

public class AdminDealNamesAction extends BaseDispatchAction {

	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	/* Display all deal Names */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException,
			ApplicationException {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		ArrayList<DealName> dealnames = null;
		try {
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			if (dealnames == null || dealnames.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else
				request.setAttribute("dealnames", dealnames);

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Change status (active/inactive) of deal Names */
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		ArrayList<DealName> dealnames = null;
		boolean b = false;
		try {
			String ids[] = request.getParameterValues("nameId");
			String status[] = request.getParameterValues("isActive");

			for (int i = 0; i < ids.length; i++) {
				b = dealBo.setDealNameStatus(Integer.parseInt(ids[i]), Short.parseShort(status[i]));
			}

			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			if (b) {

				ServletContext context = servlet.getServletContext();
				DropDownTO dropDownInfo = new DropDownTO();
				dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
				dropDownInfo.setDealName(dealnames);
				context.setAttribute("dropDownList", dropDownInfo);

				messages.add("No Records", new ActionMessage("result.noRecords",
						"Status Updated Successfully"));
				saveMessages(request, messages);
			}
			request.setAttribute("dealnames", dealnames);
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Create a new Deal Name and update a deal name */
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		DealName name = new DealName();
		ArrayList<DealName> dealnames = null;
		int id = 0;
		try {
			DealNameForm nform = (DealNameForm) form;
			BeanUtils.copyProperties(name, nform);
			if (name.getNameId() == null || name.getNameId() < 1) {
				name.setIsActive(Short.parseShort("1"));
				id = dealBo.saveDealName(name);
				if (id > 0) {

					ServletContext context = servlet.getServletContext();
					DropDownTO dropDownInfo = new DropDownTO();
					dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
					dropDownInfo.setDealName(dealBo.getAllDealNames());
					context.setAttribute("dropDownList", dropDownInfo);

					messages.add("No Records", new ActionMessage("result.noRecords",
							"Deal Name added successfully"));
					saveMessages(request, messages);
				}
			} else {
				dealBo.updateDealName(name);

				ServletContext context = servlet.getServletContext();
				DropDownTO dropDownInfo = new DropDownTO();
				dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
				dropDownInfo.setDealName(dealBo.getAllDealNames());
				// context.removeAttribute("dropDownList");
				context.setAttribute("dropDownList", dropDownInfo);

				messages.add("No Records", new ActionMessage("result.noRecords",
						"Deal Name updated successfully"));
				saveMessages(request, messages);
			}

			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			if (dealnames == null || dealnames.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else
				request.setAttribute("dealnames", dealnames);

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		} catch (Exception e) {

		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Make the deal name editable */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		DealName rest = new DealName();
		DealNameForm nform = (DealNameForm) form;
		
		try {
			String id = request.getParameter("id");
			Integer nid = 0;
			if (id != null) {
				nid = Integer.parseInt(id);
				rest = dealBo.getNameById(nid);
				BeanUtils.copyProperties(nform, rest);
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
