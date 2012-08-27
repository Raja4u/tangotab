package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.SuggestRestTO;
import com.tangotab.business.UserBO;
import com.tangotab.web.form.suggestRestForm;

public class SuggestRestaurantAction extends Action {

	private Logger log = LoggerFactory.getLogger(ContactUsAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		suggestRestForm cform = (suggestRestForm) form;
		SuggestRestTO user = new SuggestRestTO();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(user, cform);

			boolean status = userBo.suggestRestaurant(user);

			if (status) {
				user = new SuggestRestTO();
				BeanUtils.copyProperties(cform, user);
				request.setAttribute("data", "mailsent");
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Thank you for your inquirry.<BR/>"
								+ "A TangoTab  representative will contact you shortly"));
				//saveMessages(request, messages);  
				return mapping.findForward("saved");
			}
		} catch (Exception e) {
			e.printStackTrace();

			return mapping.findForward("cleared");
		}
		return mapping.findForward("saved");
	}

}
