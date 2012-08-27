package com.tangotab.web;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.ReportTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
 

public class DealReportAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(DealReportAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

 
	public ActionForward  performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 
		String page=TangotabConstants.CON_SUCCESS;
		try
		{
			DynaActionForm actionForm=(DynaActionForm)form;
			Date startdate=DateConverterUtility.convertUiToServiceDate(actionForm.get("startDate").toString());
			Date enddate=DateConverterUtility.convertUiToServiceDate(actionForm.get("endDate").toString());	
			ArrayList<ReportTO> arrayList=			userBo.getUserBookDealReports(startdate, enddate);
	        HSSFWorkbook workbook = userBo.createBookDealWorkbook(arrayList);
	        response.setHeader("Content-Disposition", "attachment; filename=GuestDealReservationReport.xls");
	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Pragma", "no-cache");
	        ServletOutputStream out = response.getOutputStream();
	        workbook.write(out);
	        out.flush();
	        out.close();
	        ActionMessages messages = new ActionMessages();
			messages.add("message", new ActionMessage("Sucessfully Downloaded."));
			saveMessages(request, messages);
		}catch(ApplicationException e)
		{
			e.printStackTrace();
			return mapping.findForward(page);
		} catch (Exception e) {
 
			e.printStackTrace();
			return mapping.findForward(page);
		}
				page = TangotabConstants.CON_SUCCESS;
			 
		return mapping.findForward(page);
	}

 
}