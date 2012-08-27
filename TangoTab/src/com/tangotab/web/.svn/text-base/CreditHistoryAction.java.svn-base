package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.RestaurantTransactionTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.TransactionBO;

public class CreditHistoryAction extends BaseAction{
	
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionMessages messages = new ActionMessages();
		TransactionBO transBO = com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		ArrayList<RestaurantTransactionTO> trans = null;
		trans = new ArrayList<RestaurantTransactionTO>();
		String restId = request.getParameter("restid");
		try{
		if(restId!= null && restId.length()>0)
		  trans = (ArrayList<RestaurantTransactionTO>)transBO.getRestaurantTransactions(Integer.parseInt(restId));
		}catch(Exception e){
			
		}
		request.setAttribute("trans", trans);
		request.setAttribute("restId", restId);
		HttpSession session = request.getSession();
		UserTO user = (UserTO)session.getAttribute("userInfo");
		if (trans == null || trans.size() == 0) {
			messages.add("No Records",
					new ActionMessage("result.noRecords", "No transactions done from past one month. Please select before months."));
			saveMessages(request, messages);
		} 
		/*  Using the same action mapping for host and admin credit history */
		if(user.getRoleId()==1)
			return mapping.findForward("adsuccess");
		else if(user.getRoleId()==5)
			return mapping.findForward("hostsuccess");
		else
			return mapping.findForward("success");
				
	}

}
