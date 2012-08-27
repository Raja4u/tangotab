package com.tangotab.web;

import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.QueryTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
 

public class GuestReportAction extends BaseAction  {
	public static Logger log = LoggerFactory.getLogger(GuestReportAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@SuppressWarnings("unchecked")
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		QueryTO queryTo = new QueryTO();
		String page=TangotabConstants.CON_SUCCESS;
		try
		{
			DynaActionForm actionForm=(DynaActionForm)form;
			String getAll = actionForm.getString("getAll").toString();
			Date startdate = new Date();
			Date enddate = new Date() ;
			if(getAll.equals("No")){
				if(StringUtils.isNotEmpty(actionForm.get("startDate").toString()))
					startdate =DateConverterUtility.convertUiToServiceDate(actionForm.get("startDate").toString());
				if(StringUtils.isNotEmpty(actionForm.get("endDate").toString()))
					enddate =DateConverterUtility.convertUiToServiceDate(actionForm.get("endDate").toString());
			queryTo.setStartDate(startdate);
			queryTo.setEndDate(enddate);
			}			
			
			queryTo.setGetAll(getAll);
 
	        HSSFWorkbook workbook = userBo.createGuestWorkbook(userBo.getUserPrefReports(queryTo));
	      

	        response.setHeader("Content-Disposition", "attachment; filename=GuestDetails.xls");
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