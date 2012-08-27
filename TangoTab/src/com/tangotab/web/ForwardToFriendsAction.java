package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.dao.pojo.ExternalReferral;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.RefferalForm;

public class ForwardToFriendsAction extends Action {
	private Logger log = LoggerFactory.getLogger(ForwardToFriendAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("start of execute in  forwarding a deal to friend Action");
		ActionMessages messages = new ActionMessages();
		RefferalForm referForm = (RefferalForm) form;
		ExternalReferral referral = new ExternalReferral();
		//ConsumerReferral referral = new ConsumerReferral();
		String dealId = null;
		boolean status = false;
		String from = request.getParameter("emailId");
		try{
		if(StringUtils.isNotEmpty(from)){
			/* check whether registered or not  otherwise send to registration page */
			if(getUserBO().checkAvailability(from) > 0){
				String username = getUserBO().getUserName(from);
				referral.setReferralEmailId(from);
				referral.setReferralName(username);
			 status = getUserBO().referAFriend(referral, referForm.getFriendEmailId1());
			}else{
				messages.add("message", new ActionMessage("errors.suspend", "Please sign-up with TangoTab before sharing."));
				saveMessages(request, messages);
				request.setAttribute("share", "true");
				return mapping.findForward(TangotabConstants.CON_FAILURE);
			}
			
		}
		}catch(Exception e){
			
		}
							
		if (status) {
				return mapping.findForward(TangotabConstants.SUCCESS);
			}
		
		messages.add("message", new ActionMessage("errors.misc",
		"Unable to forward to the Referral.Please check EmailId."));
		saveMessages(request, messages);
		return mapping.findForward(TangotabConstants.FAILURE);
	}

    private UserBO getUserBO() {
        return BusinessFactory.getUserBO();
    }

}
