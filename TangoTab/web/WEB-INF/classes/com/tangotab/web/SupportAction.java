package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.Support;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.SupportForm;

public class SupportAction extends Action {

	private Logger log = LoggerFactory.getLogger(ContactUsAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		ActionMessages messages = new ActionMessages();
		SupportForm sform = (SupportForm) form;
		Support support = new Support();
		if (sform.getEmailId() != null)
			support.setEmailId(sform.getEmailId());
		if (sform.getRoleId() != null)
			support.setRoleId(sform.getRoleId());
		if (sform.getSubject() != null)
			support.setSubject(sform.getSubject());
		if (sform.getDescription() != null)
			support.setDescription(sform.getDescription());

		int id = userBo.saveSupportData(support);

		if (id != 0) {
			messages.add("No Records", new ActionMessage("result.noRecords",
					"Your request has been sent to customer support<BR/>"
							+ "one of our executives will get back to you soon"));
			saveMessages(request, messages);

			return mapping.findForward(TangotabConstants.SUCCESS);
		}

		else
			return mapping.findForward(TangotabConstants.FAILURE);
	}

}
