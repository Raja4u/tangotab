/**
 * 
 */
package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.PublishDealTO;
import com.tangotab.business.UserBO;
import com.tangotab.web.form.PublishDealForm;

public class PublishDealAction extends Action {

	private Logger log = LoggerFactory.getLogger(ContactUsAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("start of performExecute");
		}
		PublishDealForm cform = (PublishDealForm) form;
		PublishDealTO contact = new PublishDealTO();
		try {

			contact.setEmailId(cform.getEmailId());
			contact.setComments(cform.getComments());
			contact.setBusinessname(cform.getBusinessname());
			contact.setContactname(cform.getContactname());
			contact.setTitle(cform.getTitle());
			contact.setPhone(cform.getPhone());
			contact.setZipCode(cform.getZipCode());
			contact.setAddress(cform.getAddress());
			contact.setAddress1(cform.getAddress1());
			contact.setCityId(cform.getCityId());
			contact.setStateId(cform.getStateId());
			contact.setStateName(cform.getStateName());

			boolean status = userBo.publishDealMail(contact);

			ArrayList<String> data = new ArrayList<String>();

			if (cform.getFirstname() != null)
				data.add(cform.getFirstname());
			if (cform.getLastname() != null)
				data.add(cform.getLastname());
			if (cform.getEmailId() != null)
				data.add(cform.getEmailId());
			if (cform.getPhone() != null)
				data.add(cform.getPhone());
			if (cform.getComments() != null)
				data.add(cform.getComments());

			request.setAttribute("data", data);

			if (status) {
				return mapping.findForward("saved");
			}
		} catch (Exception e) {
			e.printStackTrace();

			return mapping.findForward("cleared");
		}
		return mapping.findForward("saved");
	}
	

}
