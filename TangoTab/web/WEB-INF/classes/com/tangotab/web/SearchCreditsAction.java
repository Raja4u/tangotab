package com.tangotab.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tangotab.TO.RestaurantTransactionTO;
import com.tangotab.business.TransactionBO;
import com.tangotab.util.DateConverterUtility;

public class SearchCreditsAction extends BaseAction{

	
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		try{
			TransactionBO transBO = com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
			ArrayList<RestaurantTransactionTO> trans = null;
			trans = new ArrayList<RestaurantTransactionTO>();
			
			String restId = request.getParameter("restId");
			if(restId!=null && restId.length()>0)
				request.setAttribute("restId", restId);
			
															// (all)
            String sd = request.getParameter("startDate");
            String ed = request.getParameter("endDate");
			
			Date startDate = null;
			Date endDate = null;
			if (sd != null && sd.trim().length()>0) {
				startDate = DateConverterUtility.convertUiToServiceDate(sd);	
			}
			if (ed != null && ed.trim().length()>0) {
				endDate = DateConverterUtility.convertUiToServiceDate(ed);
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(endDate);
				calendar.add(Calendar.HOUR, 24);
				endDate=calendar.getTime();
			}
            trans = (ArrayList<RestaurantTransactionTO>)transBO.getRestaurantTransactions(Integer.parseInt(restId),startDate,endDate);
		
		request.setAttribute("trans", trans);
		request.setAttribute("sd", sd);
		request.setAttribute("ed", ed);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return mapping.findForward("success");
	}
}
