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

import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabPasswordEncrypt;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;

public class AdCustomerEditAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String page;
		ActionMessages messages = new ActionMessages();
		try {
			/* updated details from Form */
			UserForm userForm = (UserForm) form; 
			
			UserTO userInfo = userBo.getTangoTabUser(userForm.getEmailId(), TangoTabPasswordEncrypt
					.getPasswordDecrypt(userForm.getPassword()), 4); 

			User user = new User();
			ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
			City city = new City();

			BeanUtils.copyProperties(user, userForm);
			user.setUserId(userForm.getUserId());
			user.setPassword(userForm.getPassword());
			user.setUserCreateDate(userInfo.getUserCreateDate());

			consumerPreferCity.setUser(user);

			city.setCityId(userForm.getPreferCity());
			consumerPreferCity.setCity(city);
			if (userForm.getPreferCity() != 0) {

				user.setConsumerPreferCity(consumerPreferCity);
			}
			userBo.updateConsumer(user);
			messages.add("message", new ActionMessage("errors.emailexist",
					"Guest Updated successfully"));
			saveMessages(request, messages);
			page = TangotabConstants.CON_SUCCESS;
			

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.CON_FAILURE);
		} catch (Exception e) {
			return mapping.findForward(TangotabConstants.CON_FAILURE);
		}

		return mapping.findForward(page);
	}
}