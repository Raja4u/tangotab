package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
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
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LocationForm;
import com.tangotab.web.form.UserForm;

public class ClientUpdateAction extends BaseAction {
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		User user = new User();
		LocationForm temporaryForm = new LocationForm();
		Restaurant rest = new Restaurant();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		try {
			BeanUtils.copyProperties(user, userForm);
			BeanUtils.copyProperties(temporaryForm, userForm);
			user.setAlternateHosts(TangoTabUtility.makeAlternateEmailsList(temporaryForm));
			temporaryForm = null;
			
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			UserTO sessionUser = (UserTO) session.getAttribute("userInfo");
			user.setUserId(sessionUser.getUserId());
			user.setPassword(sessionUser.getPassword());
			user.setRestaurantId(sessionUser.getRestaurantId());
			user.setCurrentCredits(sessionUser.getCurrentCredits());
			rest.setIsActivated(sessionUser.getRestaurent().getIsActivated());
			rest.setIsAutoDebit(sessionUser.getRestaurent().getIsAutoDebit());
			user.setUserCreateDate(sessionUser.getUserCreateDate());
			user.setRestaurent(rest);
			userBo.updateClient(user);
			
			String alternateEmailIds[] = {};
			String emailArray[] = {};
			String nameArray[] = {};
			if(StringUtils.isNotEmpty(user.getRestaurent().getAlternateHosts())){
				 alternateEmailIds = user.getRestaurent().getAlternateHosts().split(",");
				 emailArray = new String[5];
				 nameArray = new String[5];
			}
			if(alternateEmailIds.length > 0){
				for(int l = 0; l< alternateEmailIds.length; l++){
					String local[] = alternateEmailIds[l].split(":");
					if(local != null && local.length == 1)
						emailArray[l] = local[0];
					else{
					nameArray[l] = local[0];
					emailArray[l] = local[1];
					}
				}	
				sessionUser.setEmailIdArray(emailArray);
				sessionUser.setNameArray(nameArray);
			}				
			sessionUser.setNoOfLocations(user.getNoOfLocations());
			sessionUser.setRoleId(TangotabConstants.RESTAURANT_OWNER);
			sessionUser.setRestTypeId(user.getRestTypeId());
			sessionUser.setFirstname(user.getFirstname());
			sessionUser.setLastname(user.getLastname());
			sessionUser.setAddress(user.getAddress());
			sessionUser.setBusinessName(user.getBusinessName());
			sessionUser.setMobilePhone(user.getMobilePhone());
			sessionUser.setAddress1(user.getAddress1());

			sessionUser.setCountryId(user.getCountryId());
			sessionUser.setStateId(user.getStateId());

			sessionUser.setCityId(user.getCityId());
			sessionUser.setZipCode(user.getZipCode());

			sessionUser.setSrepName(user.getSrepName());
			sessionUser.setSrepEmail(user.getSrepEmail());
			sessionUser.setQuestion1(user.getQuestion1());
			sessionUser.setAnswer1(user.getAnswer1());
			sessionUser.setQuestion2(user.getQuestion2());
			sessionUser.setAnswer2(user.getAnswer2());
			sessionUser.setBusinessTitle(user.getBusinessTitle());
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
