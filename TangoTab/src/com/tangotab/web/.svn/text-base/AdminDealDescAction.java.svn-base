package com.tangotab.web;

import java.util.ArrayList;
import java.util.List;
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

import com.tangotab.business.DealBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.dao.pojo.DealDescription;
import com.tangotab.dao.pojo.DealName;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealDescriptionForm;

public class AdminDealDescAction extends BaseDispatchAction {

	public static Logger log = Logger.getLogger(BaseAction.class);
	protected String uri;

	protected boolean isLoginRequired() {
		return true;
	}

	DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();

	/* Display all deal descriptions */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws ServletException,
			ApplicationException {
		ActionMessages messages = new ActionMessages();
		DealBO dealDaoo = BusinessFactory.getDealBO();
		ArrayList<DealName> dealnames = null;
		DealDescriptionForm dform = (DealDescriptionForm) form;
		Integer nameId = 0;

		ArrayList<DealDescription> dealdesc = null;
		try {
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			if (dealnames == null || dealnames.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else {
				request.setAttribute("dealnames", dealnames);

				if (dform.getNameId() == null || dform.getNameId() < 1000)
					nameId = dealnames.get(0).getNameId(); // select nameId for first time
				else
					nameId = dform.getNameId(); // works once the admin selects nameId

			}

			dealdesc = (ArrayList<DealDescription>) dealDaoo.getAllDealDesc(nameId); // fetch
																						// description
																						// according
																						// to
																						// dealnameId
			request.setAttribute("dealdesc", dealdesc);

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Go to a new deal insert page */
	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ActionMessages messages = new ActionMessages();
		DealDescriptionForm dform = (DealDescriptionForm) form;
		DealDescription dealdesc = new DealDescription();
		ArrayList<DealName> dealnames = null;
		Integer nameId = 0;
		 
		try {
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			request.setAttribute("dealnames", dealnames);

			if (request.getParameter("did") == null) { // if descriptionId is null then it is new
				nameId = dform.getNameId();
				DealName dname = (DealName) dealBo.getNameById(nameId);
				dform.setNameId(nameId);
				dform.setName(dname.getName());
				dform.setDescription(null);
				dform.setDescriptionId(null);
				dform.setIsActive(null);
				
			} else { // if descriptionId is null then it came to edit description
				dealdesc = dealBo.getDealDescById(Integer.parseInt(request.getParameter("did")));
				dform.setDescription(dealdesc.getDescription());
				dform.setDescriptionId(dealdesc.getDescriptionId());
				dform.setIsActive(dealdesc.getIsActive());
				nameId = dealdesc.getDealName().getNameId();
				dform.setNameId(nameId);
				dform.setName(dealdesc.getDealName().getName()); // copied all details to form and
																	// display while edit
				request.setAttribute("type", "edit");
			}
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("gotonew");
	}

	/* Update the deal description */
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionMessages messages = new ActionMessages();
		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		ArrayList<DealName> dealnames = null;
		DealDescriptionForm dform = (DealDescriptionForm) form;
		List<DealDescription> dealdesc = null;
		DealBO dealDaoo = BusinessFactory.getDealBO();

		boolean b = false;
		try {
			int nameId = dform.getNameId();
			String ids[] = request.getParameterValues("descriptionId");
			String status[] = request.getParameterValues("isActive");
			for (int i = 0; i < ids.length; i++) {
				b = dealBo.setDealDescStatus(Integer.parseInt(ids[i]), Short.parseShort(status[i]));
			}
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			dealdesc = (List<DealDescription>) dealDaoo.getAllDealDesc(nameId); // fetch
		
			if (b) {
								
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Status Updated Successfully"));
				saveMessages(request, messages);
			}
			/* according to  dealnameId */
			request.setAttribute("dealdesc", dealdesc);
			request.setAttribute("dealnames", dealnames);
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Create a new deal description // for new and update same method used */
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) { 

		ActionMessages messages = new ActionMessages();
		DealDescriptionForm dform = (DealDescriptionForm) form;
		DealDescription dealdesc = new DealDescription();
		ArrayList<DealDescription> dealdesclist = null;
		ArrayList<DealName> dealnames = null;
        DealBO dealDaoo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		DealName dealname = new DealName();
		Integer nameId = 0;

		try {
			nameId = dform.getNameId();
			if ((dform.getDescriptionId() == null) || (dform.getDescriptionId() < 1)) { // if
				/* If descriptionId is null it should save */
				dealname.setNameId(nameId);
				dealdesc.setDescription(dform.getDescription());
				dealdesc.setIsActive(Short.parseShort("1"));
				dealdesc.setDealName(dealname);
				dealBo.saveDealDesc(dealdesc);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"DealDescription Added Successfully"));
				saveMessages(request, messages);
			} else { // if its old it should update
				BeanUtils.copyProperties(dealdesc, dform);
				dealname.setNameId(dform.getNameId());
				dealdesc.setDealName(dealname);
				dealBo.updateDealDesc(dealdesc);
				messages.add("No Records", new ActionMessage("result.noRecords",
				"DealDescription Updated Successfully"));
				saveMessages(request, messages);
			}
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			request.setAttribute("dealnames", dealnames);

			dealdesclist = (ArrayList<DealDescription>) dealDaoo.getAllDealDesc(nameId);
			request.setAttribute("dealdesc", dealdesclist);
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		} catch (Exception e) {

		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	
}
