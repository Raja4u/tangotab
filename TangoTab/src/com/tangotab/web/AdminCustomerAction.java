/**
 * 
 */
package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.SortByTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.UserForm;


public class AdminCustomerAction extends BaseDispatchAction {

	public static Logger log = LoggerFactory.getLogger(AdminClientAction.class);
	private UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	/* Display all Guests in a list */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("Entering retrieve client Action");
        int currentPage = 0;
		ActionMessages messages = new ActionMessages();
		/* checking for the first time or not */		
		SortByTO sortByTO=new SortByTO();
 
		if(request.getParameter("num") == null){
		try {
			String emailId = null;
			/*calculates total pages and set to request scope for display 1 2 3..*/
			int total = (int)userBo.countAllUsers(emailId).longValue();
			int noOfPages = total/TangotabConstants.PAGE_SIZE;
			if(total%TangotabConstants.PAGE_SIZE != 0)
				noOfPages += 1;
			currentPage = 1;

			sortByTO.setDate(TangotabConstants.ASCENDING);
			sortByTO.setName(TangotabConstants.ASCENDING);
			
			request.setAttribute("num",noOfPages);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}else{
	
			/* Read the requested page no, if it not first time */
			String page = (String)request.getParameter("page");
			if(page != null)
				currentPage = Integer.parseInt(page);
			if(currentPage==0)
			{ 
				if(request.getParameter("name").equals(TangotabConstants.ASCENDING))
					sortByTO.setName(TangotabConstants.DECENDING);
				else
					sortByTO.setName(TangotabConstants.ASCENDING); 
			}else if(currentPage==-1)
			{
				if(request.getParameter("date").equals(TangotabConstants.ASCENDING))
					sortByTO.setDate(TangotabConstants.DECENDING);
				else
					sortByTO.setDate(TangotabConstants.ASCENDING); 					
			}else 
			{
				sortByTO.setDate(request.getParameter("date"));
				sortByTO.setName(request.getParameter("name"));
			}
			request.setAttribute("num", request.getParameter("num"));
		}
		
	
		ArrayList<UserTO> usersTo = null;
		try {
			usersTo = userBo.getAllUsers(currentPage, sortByTO);

			if (usersTo == null || usersTo.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}else{
				/* Set UIDate to zipcode as the field type 'userCreateDate' is not suitable 
				 * and it is set only for display purpose and no hidden logic is there */
				for(UserTO user:usersTo){
					user.setZipCode(DateConverterUtility.convertDBTimeStampToUiDate(
							user.getUserCreateDate()));
				}
			}
			if(currentPage==0)
			{
				currentPage=1;
				sortByTO.setDate(null);
			}else 	if(currentPage==-1)
			{
				currentPage=1;
				sortByTO.setName(null);
			}
			request.setAttribute("sort",sortByTO);
			
			request.setAttribute("userdetails", usersTo);
			request.setAttribute("currentPage", currentPage);
			

		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Admin can update status of guests selected by him*/
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String Uid[] = request.getParameterValues("userId");
		String Eid[] = request.getParameterValues("emailId");
		String Status[] = request.getParameterValues("isActive");
		/*  ChangedCustIds contains GuestIds whose status has been change */
		String ChangedCustIds[] = request.getParameterValues("flag"); 
		UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
		Boolean b = false;
		ActionMessages messages = new ActionMessages();
		
		ArrayList<UserTO> users = null;
		try {
			/* Identifying and updating status of only changed guests.*/
			for (int i = 0; i < Uid.length; i++) {
				if (Integer.parseInt(ChangedCustIds[i]) == Integer.parseInt(Uid[i]))
					b = userBo.setUserStatus(Eid[i], Short.parseShort(Status[i]), 4);
			}

			if (b) {
				messages.add("No Records", new ActionMessage("result.noRecords",
						"Status Updated successfully"));
				saveMessages(request, messages);
			}
			display(mapping, form, request, response);

		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	/* Display guests according to search criteria */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("searchname");
		String hname = request.getParameter("hsearch");
		ActionMessages messages = new ActionMessages();
		int currentPage = 0;
		
		ArrayList<User> userlist = null;
		ArrayList<UserTO> usertos = new ArrayList<UserTO>();

		try {
			UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();
			SortByTO sortByTO=new SortByTO();
			/* test if is for the first time or not. Displays first set of records only if
			 * name entered for first time or page request is empty or searchname changed.*/
			if((request.getParameter("num") == null || hname == null)||(!name.equals(hname) )){
					int total = (int)com.tangotab.businessImpl.BusinessFactory.getUserBO().countAllUsers(name).longValue();
					int noOfPages = total/TangotabConstants.PAGE_SIZE;
					if(total%TangotabConstants.PAGE_SIZE != 0)
						noOfPages += 1;
					currentPage = 1;
					sortByTO.setDate(TangotabConstants.ASCENDING);
					sortByTO.setName(TangotabConstants.ASCENDING);
					request.setAttribute("num",noOfPages);
				
				}else{
					/* read the requested page no. */
					String page = (String)request.getParameter("page");
					if(page != null)
						currentPage = Integer.parseInt(page);
					request.setAttribute("num", request.getParameter("num"));
					if(currentPage==0)
					{ 
						if(request.getParameter("name").equals(TangotabConstants.ASCENDING))
							sortByTO.setName(TangotabConstants.DECENDING);
						else
							sortByTO.setName(TangotabConstants.ASCENDING); 
					}else if(currentPage==-1)
					{
						if(request.getParameter("date").equals(TangotabConstants.ASCENDING))
							sortByTO.setDate(TangotabConstants.DECENDING);
						else
							sortByTO.setDate(TangotabConstants.ASCENDING); 					
					}else 
					{
						sortByTO.setDate(request.getParameter("date"));
						sortByTO.setName(request.getParameter("name"));
					}
				
				}
			if(StringUtils.isEmpty(name))
			{
				sortByTO.setDate(TangotabConstants.ASCENDING);
				sortByTO.setName(TangotabConstants.ASCENDING);
			}
			/* search guests by name and page */
			
			if (name != null) {
				userlist = (ArrayList<User>) userBo.getUserById(name,currentPage, sortByTO);

				for (User user : userlist) {
					UserTO userto = new UserTO();
					BeanUtils.copyProperties(userto, user);
					/* Set UIDate to zipcode as the field type 'userCreateDate' is not suitable 
					 * and it is set only for display purpose and no hidden logic is there */
					userto.setZipCode(DateConverterUtility.convertDBTimeStampToUiDate(
							userto.getUserCreateDate()));
					usertos.add(userto);
				}
			}

			if (usertos == null || usertos.size() == 0 || name == null) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
			if(currentPage==0)
			{
				sortByTO.setDate(null);
			}else 	if(currentPage==-1)
			{
				sortByTO.setName(null);
			}
			request.setAttribute("sort",sortByTO);
			
			request.removeAttribute("userdetails");
			request.setAttribute("userdetails", usertos);
			request.setAttribute("currentPage", currentPage );
			request.setAttribute("searchname", name);
		} catch (ApplicationException e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* Readying selected guest details for display and for edit */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			UserForm forms = (UserForm) form;
			String uid = request.getParameter("id");
			UserBO userBo = com.tangotab.businessImpl.BusinessFactory.getUserBO();

			UserTO user = userBo.getUserByUserId(Integer.parseInt(uid));

			request.setAttribute("user", user);
			BeanUtils.copyProperties(forms, user);
			if (user.getConsumerPreferCity() != null)
				forms.setPreferCity(user.getConsumerPreferCity().getCity().getCityId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("editcustomer");
	}
}
