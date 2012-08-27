package com.tangotab.web;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.DropDownTO;
import com.tangotab.TO.QueryTO;
import com.tangotab.business.UserBO;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;

public class PublishedOffersReportAction extends BaseAction {
	UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();
	public ActionForward performExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		QueryTO queryTo = new QueryTO();
		DynaActionForm actionForm=(DynaActionForm)form;
		Date startdate=DateConverterUtility.convertUiToServiceDate(actionForm.get("startDate").toString());
		Date enddate=DateConverterUtility.convertUiToServiceDate(actionForm.get("endDate").toString());	
		//dealReportForm form 
		queryTo.setStartDate(startdate);
		queryTo.setEndDate(enddate);
		queryTo.setCityId(actionForm.getString("cityId"));
		
			ServletContext context = servlet.getServletContext();
			DropDownTO dropDownInfo = new DropDownTO();
			dropDownInfo = (DropDownTO) context.getAttribute("dropDownList");
			if(StringUtils.isEmpty(queryTo.getCityId())){
			queryTo.setCities(dropDownInfo.getCities());
		    }
			else{
				for(CityTO cityto:dropDownInfo.getCities()){
					if(Integer.parseInt(queryTo.getCityId()) == cityto.getCityId()){
						   queryTo.getCities().add(cityto);
				           break;
					}
				}
			}
		try{			
			
			 HSSFWorkbook workbook = userBO.createOfferPublishCountWorkbook(userBO.getOffersDetails(queryTo));
		        response.setHeader("Content-Disposition", "attachment; filename=PublishedOffersCount.xls");
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Pragma", "no-cache");
		        ServletOutputStream out = response.getOutputStream();
		        workbook.write(out);
		        out.flush();
		        out.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mapping.findForward(TangotabConstants.CON_SUCCESS);
	}

}
