package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.SupportTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class AdminSupportAction extends BaseDispatchAction {

	UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		ActionMessages messages = new ActionMessages();
		ArrayList<SupportTO> supportdetails = null;
		HttpSession session = request.getSession();
		try {
			supportdetails = userBo.getAllSupportIssues();

			if (supportdetails == null || supportdetails.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
			session.setAttribute("supportdetails", supportdetails);
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ActionMessages messages = new ActionMessages();
		SupportTO support = new SupportTO();
		try {
			String sid = request.getParameter("id");
			if (sid != null && sid.length() > 0) {
				support = userBo.getSupportIssueById(Integer.parseInt(sid));
			}
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		request.setAttribute("support", support);
		return mapping.findForward("fullview");
	}

	@SuppressWarnings("unchecked")
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionMessages messages = new ActionMessages();
		try {
			String id[] = request.getParameterValues("supportId");
			String status[] = request.getParameterValues("status");
			HttpSession session = request.getSession();
			boolean b = false;
			ArrayList<SupportTO> support = (ArrayList<SupportTO>) session
					.getAttribute("supportdetails");
			int i = 0;
			for (SupportTO supportTo : support) {
				if (supportTo.getStatus() != Integer.parseInt(status[i])) {
					b = userBo.setSupportStatus(Integer.parseInt(id[i]), Integer
							.parseInt(status[i]));
					supportTo.setStatus(Integer.parseInt(status[i]));
				}
				i++;
			}
			session.removeAttribute("supportdetails");
			session.setAttribute("supportdetails", support);

			if (b) {
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Status updated successfully"));
				saveMessages(request, messages);
			}
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ActionMessages messages = new ActionMessages();
		HttpSession session = request.getSession();
		ArrayList<SupportTO> support = new ArrayList<SupportTO>();
		try {
			String name = request.getParameter("searchname");
			if (name != null && name.length() < 1)
				support = userBo.getAllSupportIssues();
			else
				support = userBo.getSupportIssuesByEmail(name);

			session.removeAttribute("supportdetails");
			session.setAttribute("supportdetails", support);

		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
