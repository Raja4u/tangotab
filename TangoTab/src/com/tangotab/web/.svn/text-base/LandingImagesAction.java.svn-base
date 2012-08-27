package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.business.AdminBO;
import com.tangotab.business.CommonBO;
import com.tangotab.businessImpl.AdminBOImpl;
import com.tangotab.businessImpl.CommonBOImpl;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.LandingForm;

public class LandingImagesAction extends BaseAction {

	CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
	AdminBO adminBO=com.tangotab.businessImpl.BusinessFactory.getAdminBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionMessages messages=new ActionMessages();
		LandingForm landingForm=(LandingForm)form;
		if(landingForm.getSource().trim().length() < 1|| landingForm.getUrl().trim().length() < 1)
		{
			messages.add("message", new ActionMessage("msg.success", "Source and URL should not be empty"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.SUCCESS);
		}
		Landing landing=new Landing();
		try {
			BeanUtils.copyProperties(landing, landingForm);
			adminBO.saveLanding(landing);
		} catch (Exception e) {
		}
		
		return mapping.findForward(TangotabConstants.SUCCESS);

	}
}
