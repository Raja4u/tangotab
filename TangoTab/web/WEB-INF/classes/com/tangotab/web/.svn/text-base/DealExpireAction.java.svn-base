package com.tangotab.web;

import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.DealTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangoTabMailer;
import com.tangotab.util.TangotabConstants;
 

public class DealExpireAction extends BaseAction {
	public static Logger log = LoggerFactory.getLogger(DealExpireAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 
		String page=TangotabConstants.CON_SUCCESS;
		try
		{

	        ArrayList<DealTO> arrayList=userBo.sendDealexpireMails();
	        if(arrayList!=null && arrayList.size()!=0)
	        {
	        	HashSet<Integer> hashSet=new HashSet<Integer>();
	        	StringBuffer msg=new StringBuffer();
	        	int i=0;
	        	
	        	for (DealTO dealTO : arrayList) {
	        		if(hashSet.add(dealTO.getRestLocationId()))
	        		{
	        			if(i!=0)
	        			{
	        				msg.append("</table><table><tr><td>&nbsp;</td></tr>" +
	        						"<tr><td>&nbsp;</td></tr>" +
	        						"<tr><td>&nbsp;</td></tr></table>");
	        			}
	        			i=1;
	        	 		msg.append("<table border=1  bgcolor='#FF8800'>");
	        	 		msg.append("<tr><td width='15%'> <b>Host Name</td><td  width='25%'>"+dealTO.getLocationRestName().trim()+"</td>");
	        			msg.append("<td width='15%'> <b>Location Name</td><td  width='25%'>"+dealTO.getLocationName().trim()+"</td>");
	        			
	        			msg.append("<td  width='15%'> <b>Address</td><td colspan=3>"+dealTO.getAddress().trim()+"</td>");
	        			msg.append("<tr><td  width='15%'> <b>Location Phone</td><td  width='15%'>"+dealTO.getLocationphone()+"</td>");
	        			msg.append("<td> <b>Manager Name </td><td>"+dealTO.getFirstname().trim()+"</td>");
	        			msg.append("<td> <b>Email </td><td width=15%>"+dealTO.getLocationEmailId().trim()+"</td>");
	        			msg.append("<td  width=10%> <b>Phone Number </td><td  width=10%>"+dealTO.getCellPhone().trim()+"</td></td>");
	        			msg.append("</table><table><tr><td>&nbsp;</td></tr>" +
        				 
        						"<tr><td>&nbsp;</td></tr></table>");
	        			msg.append("<table border=1>");
	        			msg.append("<tr  bgcolor='#7d9b17'><td colspan=6> Sl.No"+i+"</td></tr>");
	        			msg.append("<tr><td width='10%'> <b>Deal Name</td><td  width='25%'>"+dealTO.getDealTemplateName()+"</td>");
	        			msg.append("<td  width='10%'> <b>Deal Description </td><td  width='25%'>"+dealTO.getDealTemplateDescription()+"</td>");
	        			msg.append("<td  width='10%'> <b>Deal Restrictions</td><td  width='15%'>"+dealTO.getDealTemplateRestrictions()+"</td></tr>");
	        			msg.append("<tr><td> <b>Deal Start Date </td><td>"+dealTO.getRestDealStartDate()+"</td>");
	        			msg.append("<td> <b>Deal End Date </td><td>"+dealTO.getRestDealEndDate()+"</td>");
	        			msg.append("<td> <b>Available Days</td><td>"+dealTO.getAvailableWeekDays()+"</td></td></tr>");
	        			 
	        			//ID==> "+dealTO.getRestLocationId()+" Deal ID==> "+dealTO.getDealTemplateId());
			
	        		}else
	        		{	i++;
	        		msg.append("<tr  bgcolor='#7d9b17'><td colspan=6> Sl.No"+i+"</td></tr>");
	        		msg.append("<tr><td width='10%'> <b>Deal Name</td><td  width='25%'>"+dealTO.getDealTemplateName()+"</td>");
	        		msg.append("<td  width='10%'> <b>Deal Description </td><td  width='25%'>"+dealTO.getDealTemplateDescription()+"</td>");
	        		msg.append("<td  width='10%'> <b>Deal Restrictions</td><td  width='15%'>"+dealTO.getDealTemplateRestrictions()+"</td></tr>");
	        		msg.append("<tr><td> <b>Deal Start Date </td><td>"+dealTO.getRestDealStartDate()+"</td>");
	        		msg.append("<td> <b>Deal End Date </td><td>"+dealTO.getRestDealEndDate()+"</td>");
	        		msg.append("<td> <b>Available Days</td><td>"+dealTO.getAvailableWeekDays()+"</td></td>");
	        	//	msg.append("<br/>"+i+")"+dealTO.getLocationRestName()+"  ID==> "+dealTO.getRestLocationId()+" Deal ID==> "+dealTO.getDealTemplateId());
	        		}
	        	//	admin.append("<br/>"+i+")"+dealTO.getLocationRestName()+"  ID==> "+dealTO.getRestLocationId()+" Deal ID==> "+dealTO.getDealTemplateId());
	        			
	        	}
	        	msg.append("</table>");
	        	if(request.getParameter("send")!=null)
	        	{
	             	TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,null,"rathnakar.p@techgene.com", "TangoTab Offers Expiring in 1 Week", msg.toString());
		        	request.setAttribute("sendmail","yes");
	        	}else 
	        		request.setAttribute("sendmail","");
	        	request.setAttribute("emaildata", msg.toString());
	        	request.setAttribute("noofrecords", arrayList.size());
	        //	
	        }
	        else
	        request.setAttribute("noofrecords", 0);
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