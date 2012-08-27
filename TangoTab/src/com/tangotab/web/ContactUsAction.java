package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.ContactTO;
import com.tangotab.business.UserBO;
import com.tangotab.web.form.ContactForm;

public class ContactUsAction extends DispatchAction {

	private Logger log = LoggerFactory.getLogger(ContactUsAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward Send(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		ContactForm cform = (ContactForm) form;
		ContactTO contact = new ContactTO();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(contact, cform);

			boolean status = userBo.contactUsMail(contact);

			if (status) {
				contact = new ContactTO();
				BeanUtils.copyProperties(cform, contact);
				request.setAttribute("data", cform.getEmailId());
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Thank you for your inquiry.<BR/>"
								+ "A TangoTab representative will contact you with in 24 hours."));
				saveMessages(request, messages);

				return mapping.findForward("saved");
			}
		} catch (Exception e) {
			e.printStackTrace();

			return mapping.findForward("cleared");
		}
		return mapping.findForward("saved");
	}

}
