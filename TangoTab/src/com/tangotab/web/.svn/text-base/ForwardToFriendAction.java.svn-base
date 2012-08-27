package com.tangotab.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.ConsumerReferral;
import com.tangotab.dao.pojo.User;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.RefferalForm;

public class ForwardToFriendAction extends Action {
	private Logger log = LoggerFactory.getLogger(ForwardToFriendAction.class);
	private UserBO UserBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("start of execute in  forwarding a deal to friend Action");
		ActionMessages messages = new ActionMessages();
		RefferalForm referForm = (RefferalForm) form;
		ConsumerReferral referral = new ConsumerReferral();
		String dealId = null;
		boolean status = false;
		if (StringUtils.isNotEmpty(request.getParameter("dealId"))) {
			dealId = request.getParameter("dealId");
			request.setAttribute("dealId", dealId);
		}
		
		HttpSession session = request.getSession(true);
		UserTO userInfo = (UserTO) session.getAttribute("userInfo");
		User user = new User();
		String emailIds = referForm.getFriendEmailId1();
				
		try {

			BeanUtils.copyProperties(user, userInfo);
			if(StringUtils.isNotEmpty(emailIds)){
				String[] friends = emailIds.split(",");
				for(int no=0; no < friends.length; no++){
					if(!friends[no].contains("@"))
						continue;
				referral.setReferredOn(new Timestamp(new Date().getTime()));
				referral.setIsFriendRegistered((short) 0);
				referral.setUser(user);
				referral.setFriendEmailId(friends[no]);
				if(StringUtils.isNotEmpty(dealId) && dealId!=null && !dealId.equals("0"))
					  status = UserBo.forwardDealToFriend(referral, dealId)|| status;  
					else
					  status =  UserBo.referAFriend(referral) || status ;
				}
			}
			
			if (status) {
				return mapping.findForward(TangotabConstants.SUCCESS);
			}
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc",
					"Unable to forward a requested Deal to the Referral"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		messages.add("message", new ActionMessage("errors.misc",
		"Unable to forward to the Referral.Please check EmailId."));
		saveMessages(request, messages);
		return mapping.findForward(TangotabConstants.FAILURE);
	}

}
