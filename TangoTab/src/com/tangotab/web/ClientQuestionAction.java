package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;

public class ClientQuestionAction extends BaseAction {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		User user = new User();
		Restaurant rest = new Restaurant();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		UserTO sessionUser = (UserTO) session.getAttribute("userInfo");
		try {
			BeanUtils.copyProperties(user, sessionUser);
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {

			user.setUserId(sessionUser.getUserId());
			user.setPassword(sessionUser.getPassword());
			user.setRestaurantId(sessionUser.getRestaurantId());
			user.setCurrentCredits(sessionUser.getCurrentCredits());
			rest.setIsActivated(sessionUser.getRestaurent().getIsActivated());
			rest.setIsAutoDebit(sessionUser.getRestaurent().getIsAutoDebit());
			user.setUserCreateDate(sessionUser.getUserCreateDate());
			user.setRestaurent(rest);
			user.setQuestion1(userForm.getQuestion1());
			user.setAnswer1(userForm.getAnswer1());
			user.setQuestion2(userForm.getQuestion2());
			user.setAnswer2(userForm.getAnswer2());
			userBo.updateClient(user);

			sessionUser.setQuestion1(userForm.getQuestion1());
			sessionUser.setAnswer1(userForm.getAnswer1());
			sessionUser.setQuestion2(userForm.getQuestion2());
			sessionUser.setAnswer2(userForm.getAnswer2());

			session.removeAttribute("userInfo");
			session.setAttribute("userInfo", sessionUser);
		} catch (ApplicationException e) {

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

}
