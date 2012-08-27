package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;

public class AdCustomerRegAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String page;
		UserForm userForm = (UserForm) form;
		User user = new User();
		ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
		City city = new City();

		ActionMessages messages = new ActionMessages();

		if (userBo.checkUserAvailability(userForm.getEmailId(), TangotabConstants.CONSUMER_ROLE)) {
			messages.add("message", new ActionMessage("errors.emailexist",
					"Email Id already exists."));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.CON_FAILURE);

		}

		try {
			BeanUtils.copyProperties(user, userForm);
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.CON_FAILURE);
		}

		try {
			/* The status of the Guest created by administrator is Active by default */
			String password = TangoTabUtility.generateRandomCode();
			user.setPassword(password);
			user.setIsActive(Short.parseShort("1"));
			user.setUserCreateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			consumerPreferCity.setUser(user);
			city.setCityId(userForm.getPreferCity());
			consumerPreferCity.setCity(city);
			if (userForm.getPreferCity() != 0)
				user.setConsumerPreferCity(consumerPreferCity);
			userBo.saveConsumer(user, "admin");
			messages.add("message", new ActionMessage("errors.emailexist",
					"Guest added successfully"));
			saveMessages(request, messages);
			page = TangotabConstants.CON_SUCCESS;
		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.CON_FAILURE);
		}

		return mapping.findForward(page);
	}
}