package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.BookDealTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.util.TangotabConstants;

public class LoginForwardAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		int dealId = (Integer.valueOf(request.getParameter("dealId")));
		 String date = request.getParameter("date");
		 String compressedURL=request.getParameter("compressedURL");

		HttpSession session = request.getSession(true);
		UserTO userInfo = (UserTO) session.getAttribute("userInfo");
		long count = 0;
       /* If the user is logged in, then forward to deal booking */
		if (userInfo != null) {
			if(userInfo.getRole().getRoleId() == 4){
			UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
		//	DealTO dealInfo = userBo.fetchDealByDealId(dealId);
			
		      DealTO dealInfo = userBo.fetchDealByDealId(dealId, date);
		      dealInfo.setCompressedURL(compressedURL);
		
            count = userBo.countBookedDeals(userInfo.getUserId(), dealId);
            if(count >= 5){
            	actionMessages.add("No Records", new ActionMessage("result.noRecords",
        				"Sorry you have exceeded the maximum number of reservations for today." +
        				" If you have reserved an offer by mistake, please check your inbox to ensure that your " +
        				"confirmation has not been placed in the junk folder. Furthermore, please let us know ASAP so we may cancel any reservations made in error."));
        		       saveMessages(request, actionMessages);
        		       return mapping.findForward(TangotabConstants.FAILURE);
            }else {
            	count = userBo.countBookedDealsPerDate(userInfo.getUserId(), dealId, dealInfo.getStartDate());
            	if(count >= 1){
            		
            		actionMessages.add("No Records", new ActionMessage("result.noRecords",
            				"You have already reserved this offer today. If you have not received your reservation confirmation number," +
            				" please check your spam folder or you can retrieve the reservation code from your account profile." +
            				" If you are trying to reserve this great offer for your friends, kindly ask them to join and reserve " +
            				"the offer as it is FREE to join."));
            		     
            		       saveMessages(request, actionMessages);
            		       return mapping.findForward(TangotabConstants.FAILURE);
            	}
            }
           
			BookDealTO to = userBo.bookDeal(userInfo.getUserId(), dealId, dealInfo);
            
			request.setAttribute("dealInfo", dealInfo);

		 	session.setAttribute("book_deal_to", to);
			return mapping.findForward("search_deals");
			}
			else{
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
				"Please switch your Profile to Guest if you have, otherwise" +
				" please register as Guest with TangoTab! "));
		       saveMessages(request, actionMessages);
		       return mapping.findForward(TangotabConstants.FAILURE);
				
			}
		}
		/* if the user is logged in, and if the role is not yet decided then redirect
		 * to switch profile page, after that he will go to deal booking page */
		else if(session.getAttribute("profileUsers") != null){
			request.setAttribute("dealId", dealId);
			return mapping.findForward("switchProfile");
		}
		/* If not at all logged in then, he should go to login page  dealID for login page*/
		request.getSession().setAttribute("dealID", dealId);
		request.getSession().setAttribute("date", date);
		request.getSession().setAttribute("compressedURL", compressedURL);
		return mapping.findForward(TangotabConstants.SUCCESS);
	}
}
