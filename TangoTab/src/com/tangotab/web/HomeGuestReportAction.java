package com.tangotab.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
 

public class HomeGuestReportAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(GuestReportAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	  
	public ActionForward  performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 
		String page=TangotabConstants.CON_SUCCESS;
		try
		{
 
	        HSSFWorkbook workbook = userBo.createHomeSignUpWorkbook(userBo.getHomeSignUp());
	        response.setHeader("Content-Disposition", "attachment; filename=HomeGuestDetails.xls");
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Pragma", "no-cache");
	        ServletOutputStream out = response.getOutputStream();
	        workbook.write(out);
	        out.flush();
	        out.close();
		}catch(ApplicationException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
 
			e.printStackTrace();
		}
				page = TangotabConstants.CON_SUCCESS;
			 
		return mapping.findForward(page);
	}
}