package com.tangotab.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.CharityTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.CommonBOImpl;
import com.tangotab.businessImpl.UserBOImpl;
import com.tangotab.web.form.CharityForm;

public class CharityAction extends BaseDispatchAction{
	ActionMessages messages = new ActionMessages();
	ActionMessage message;
	
	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		CharityForm charityForm = (CharityForm)form;
		CharityTO charityTO=new CharityTO();
		try {
			charityTO.setCharityTime(charityForm.getCharityTime());
			charityTO.setTotalCount(charityForm.getTotalCount());
		} catch (Exception e) {
		}
		try{
			com.tangotab.businessImpl.BusinessFactory.getUserBO().saveCharityCount(charityTO);
			ServletContext context  = request.getSession().getServletContext();
			context.setAttribute("charityCount", com.tangotab.businessImpl.BusinessFactory.getCommonBO().getCharityCount());
		}catch(Exception e){
			
		}
		messages.clear();
		messages.add("messages",
				new ActionMessage("result.noRecords", "CharityCount Updated Successfully"));
		saveMessages(request, messages);
		return mapping.findForward("success");
		
	}

}
