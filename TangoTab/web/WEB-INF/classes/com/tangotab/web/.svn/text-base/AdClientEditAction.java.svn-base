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
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabPasswordEncrypt;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LocationForm;
import com.tangotab.web.form.UserForm;

public class AdClientEditAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String page;
		ActionMessages messages = new ActionMessages();
		try {
			boolean b = false;
			/*
			 *  updated details from Form
			 */
			UserForm userForm = (UserForm) form;
			if (!userForm.getEmailId().equals(userForm.getEmailIdDummy()))
				b = userBo.checkUserAvailability(userForm.getEmailId(), 5);
			if (b) {
				messages.add("message", new ActionMessage("errors.emailexist",
						"Email Id already exists."));
				saveMessages(request, messages);
				return mapping.findForward(TangotabConstants.CLIENT_FAILURE);
			}
			UserTO userInfo = userBo.getTangoTabUser(userForm.getEmailIdDummy(),
					TangoTabPasswordEncrypt.getPasswordDecrypt(userForm.getPassword()), 5); 

			User user = new User();
			Restaurant rest = new Restaurant();
			LocationForm temporaryForm = new LocationForm();

			try{
			BeanUtils.copyProperties(user, userForm);
			BeanUtils.copyProperties(temporaryForm, userForm);
			user.setAlternateHosts(TangoTabUtility.makeAlternateEmailsList(temporaryForm));
			}catch(Exception e){
				e.printStackTrace();
			}
			/* Above is edited data and Below is hidden data which doesn't modify */
			user.setUserId(userInfo.getUserId());
			/*
			 * edited emailId by admin and going to update emailId
			 */
			user.setEmailId(userForm.getEmailId()); 
			user.setPassword(userInfo.getPassword());
			user.setRestaurantId(userInfo.getRestaurantId());
			user.setCurrentCredits(userInfo.getRestaurent().getCurrentCredits());
			rest.setIsActivated(userInfo.getRestaurent().getIsActivated());
			rest.setIsAutoDebit(userForm.getIsAutoDebit());
			rest.setBillingMethodId(userInfo.getBillingMethodId());
			rest.setBillingTypeId(userInfo.getBillingTypeId());
			user.setRestaurent(rest);
			user.setUserCreateDate(userInfo.getUserCreateDate());
			user.setQuestion1(userInfo.getQuestion1());
			user.setQuestion2(userInfo.getQuestion2());
			user.setAnswer1(userInfo.getAnswer1());
			user.setAnswer2(userInfo.getAnswer2());

			userBo.updateClient(user);
			messages.add("message", new ActionMessage("errors.emailexist",
					"Host Updated successfully"));
			saveMessages(request, messages);
			page = TangotabConstants.CLIENT_SUCCESS;

		} catch (ApplicationException e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.CLIENT_FAILURE);
		} catch (Exception e) {
			return mapping.findForward(TangotabConstants.CLIENT_FAILURE);
		}

		return mapping.findForward(page);
	}
}