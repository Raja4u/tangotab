package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.DealTO;
import com.tangotab.business.LocationBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class AdminDealsApproveForwardAction extends BaseAction {

	LocationBO locationBO = com.tangotab.businessImpl.BusinessFactory.getLocationBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		
		String type = request.getParameter("type");
		int dealId = 0;
		try {
			if (type != null && type.equals("approve")) {
				dealId = Integer.parseInt(request.getParameter("dealId"));
				locationBO.setCustomDealStatus(dealId, TangotabConstants.NOT_ACTIVE);
				locationBO.unpublishDeal(dealId);

			}

			ArrayList<DealTO> dealsInfo = null;
			int currentPage = 0;
			
			String byloc = request.getParameter("byloc");
			String locname = request.getParameter("searchname");
			String hname = request.getParameter("hsearch");
			/* if without search or search name is empty */
			if(StringUtils.isEmpty(byloc) || StringUtils.isEmpty(locname)){
			/* checking for the first time or not */
			if(request.getParameter("num") == null || request.getParameter("page") == null){
				try {
					/*calculates total pages and set to request scope for display 1 2 3..*/
					int total = (int)locationBO.countDealsForLocation(0,
							1, 0, 0, "active").longValue();
					int noOfPages = total/TangotabConstants.PAGE_SIZE;
					if(total%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage = 1;
					request.setAttribute("num",noOfPages);
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else{
					/* read the requested page no, if it not first time */
					String page = (String)request.getParameter("page");
					if(page != null)
						currentPage = Integer.parseInt(page);
					request.setAttribute("num", request.getParameter("num"));
				}
			
			//dealsInfo = locationBO.getDeals(0, 1, 0, "active");
			dealsInfo = locationBO.getDealsForLocation(0, 1, 0, 0, "active", currentPage);
			/* 
			 * if search by location name then come here
			 *  */
			}else{
				/* start fresh pagination if no pagination before or no page num. came or 
				 * search name changes or searching for first time */
				if(request.getParameter("num") == null || request.getParameter("page") == null 
						|| hname == null ||(!locname.equals(hname)) ){
					try {
						/*calculates total pages and set to request scope for display 1 2 3..*/
						int total = (int)locationBO.countDealsForLocation(0,
								1, 0, 0, "active", locname).longValue();
						int noOfPages = total/TangotabConstants.PAGE_SIZE;
						if(total%TangotabConstants.PAGE_SIZE != 0)
							noOfPages += 1;
						currentPage = 1;
						request.setAttribute("num",noOfPages);
					} catch (ApplicationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else{
						/* read the requested page no, if it not first time */
						String page = (String)request.getParameter("page");
						if(page != null)
							currentPage = Integer.parseInt(page);
						request.setAttribute("num", request.getParameter("num"));
					}
					dealsInfo = locationBO.getDealsForLocation(0, 1, 0, 0, "active", currentPage, locname);
				
				
			}
			
			if (dealsInfo == null || dealsInfo.size() == 0) {
				actionMessages.add("No Records", new ActionMessage("result.noRecords",
						"No Records Found"));
				saveMessages(request, actionMessages);
			}
			request.setAttribute("dealsInfo", dealsInfo);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("searchname", locname);

		} catch (ApplicationException e) {
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, actionMessages);
		}

		return mapping.findForward(TangotabConstants.SUCCESS);

	}
}
