package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.StateTO;
import com.tangotab.business.AdminBO;
import com.tangotab.business.CommonBO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.State;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CityForm;

public class CityRegAction extends BaseDispatchAction {

	CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
	AdminBO adminBO = com.tangotab.businessImpl.BusinessFactory.getAdminBO();

	public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Integer stateId = 0;

		try {
			ArrayList<StateTO> arrayList = commonBO.getStates("All");
			request.setAttribute("stateDate", arrayList);
			String state = (String) request.getParameter("stateId");
			if (StringUtils.isNotEmpty(state))
				stateId = Integer.valueOf(state);
			if (stateId != null || stateId != 0) {

				request.setAttribute("state", stateId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	public ActionForward Save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		City city = new City();
		State state = new State();
		CityForm cityForm = (CityForm) form;

		cityForm.setIsActive(1);

		try {
			try {
				BeanUtils.copyProperties(city, cityForm);
			} catch (Exception e) {
			}
			state = commonBO.getStatesById(cityForm.getStateId());
			city.setState(state);

			adminBO.saveCity(city);
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setCities(commonBO.getCities());
			context.setAttribute("dropDownList", dropDownInfo);
		} catch (ApplicationException e) {
			e.printStackTrace();

			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("view");

	}

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		CityForm cityForm = (CityForm) form;

		cityForm.setIsActive(1);
		String cityId[] = request.getParameterValues("cityId");
		String isactive[] = request.getParameterValues("isActive");
		/* ChangedCityIds contains CityIds whose status has been change */
		String ChangedCityIds[] = request.getParameterValues("flag");

		try {

			for (int i = 0; i < cityId.length; i++) {
				if(Integer.parseInt(cityId[i]) == Integer.parseInt(ChangedCityIds[i]))
				adminBO.setCityStatus(Integer.parseInt(cityId[i]), Integer.parseInt(isactive[i]));

			}
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
			dropDownInfo.setCities(commonBO.getCities());
			context.setAttribute("dropDownList", dropDownInfo);
			
		} catch (ApplicationException e) {
			e.printStackTrace();

			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("view");

	}

}
