package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;

public class ConsumerUpdateAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(ConsumerUpdateAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		User user = new User();
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		/* if pref city is changed, capture city name from javascript */
		String prefcityname = request.getParameter("hname");
		try {
			BeanUtils.copyProperties(user, userForm);
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			UserTO sessionUser = (UserTO) session.getAttribute("userInfo");
			ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
			consumerPreferCity.setUser(user);
			City city = new City();
			city.setCityId(userForm.getPreferCity());
			if (prefcityname != null && prefcityname.equals(""))
				city.setCityName(sessionUser.getConsumerPreferCity().getCity().getCityName());
			else
				city.setCityName(prefcityname);

			consumerPreferCity.setCity(city);
			if (userForm.getPreferCity() == 0) {
				user.setConsumerPreferCity(null);
			}

			user.setUserId(sessionUser.getUserId());
			user.setConsumerPreferCity(consumerPreferCity);
			user.setPassword(sessionUser.getPassword());
			user.setUserCreateDate(sessionUser.getUserCreateDate());
			user.setConsumerEvent(sessionUser.getConsumerEvent());
			userBo.updateConsumer(user);
			if (user.getPreferencesList().length == 0) {
				user.setPreferencesList(null);
			} else {
				ServletContext context = servlet.getServletContext();
				DropDownTO dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
				ArrayList<CityTO> cityTO = dropDownInfo.getCities();
				for (CityTO cityto : cityTO) {

					if (cityto.getCityId().equals(city.getCityId())) {
						try {
							BeanUtils.copyProperties(city, cityto);
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}
			}
			try {
				BeanUtils.copyProperties(sessionUser, user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sessionUser.setConsumerPreferCity(consumerPreferCity);
			sessionUser.setRoleId(TangotabConstants.CONSUMER_ROLE);
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
