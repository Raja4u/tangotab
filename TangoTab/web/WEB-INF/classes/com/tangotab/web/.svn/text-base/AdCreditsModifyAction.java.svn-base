package com.tangotab.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.RestaurantTransactionTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.TransactionBO;
import com.tangotab.business.UserBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantTransaction;
import com.tangotab.dao.pojo.User;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;

public class AdCreditsModifyAction extends BaseDispatchAction {
	
	/* Dispatch to Add credits page */
	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		/*  getting restaurant Id from transactionslist and passing over to add page */
		String restId = request.getParameter("restId");
		if(restId!=null && restId.length()>0)
			request.setAttribute("restId", restId);
		return mapping.findForward("add");
	}
	
	/* Dispatch to Reduce credits page */
	public ActionForward Reduce(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String restId = request.getParameter("restId");
		if(restId!=null && restId.length()>0)
			request.setAttribute("restId", restId);
		return mapping.findForward("reduce");
	}
	
	/* Dispatch to modify page */
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		return mapping.findForward("modify");
	}
	
	/* Add credits to the particular restaurant by admin */
	public ActionForward AddCredits(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		TransactionBO transBO = com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		UserBO userBo = BusinessFactory.getUserBO();
		String credits = request.getParameter("credits");
		String description = request.getParameter("desc");
		/* Getting all transactions of the particular restaurants */
		ArrayList<RestaurantTransactionTO> trans = null;
		trans = new ArrayList<RestaurantTransactionTO>();
		String restid = request.getParameter("restId");
		Integer restId =0;
		try{
		if(restid!= null && restid.length()>0)
			restId = Integer.parseInt(restid);
		  trans = (ArrayList<RestaurantTransactionTO>)transBO.getRestaurantTransactions(restId);
		}catch(Exception e){
			
		}
		try{
		TransactionBO transactionBO=com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		Restaurant restaurant;
		restaurant = userBo.getRestaurantById(restId);
		
		RestaurantTransaction restaurantTransaction=new RestaurantTransaction();
		restaurantTransaction.setAmount(0);
		restaurantTransaction.setCurrentCredits((restaurant.getCurrentCredits()).intValue()+Integer.parseInt(credits));
		restaurantTransaction.setNoOfCredits(Integer.parseInt(credits));
		restaurantTransaction.setDescription(description);
		restaurantTransaction.setRemarks("Admin Added");
		restaurantTransaction.setTypeOfTrans(TangotabConstants.CREDIT);
		User user=new User();
		UserTO userTo = (UserTO)request.getSession().getAttribute("userInfo");
		user.setUserId(userTo.getUserId()); //Admin
		user.setFirstname(userTo.getFirstname());

		restaurant.setRestaurantId(restId);
		restaurant.setCurrentCredits(restaurant.getCurrentCredits()+Double.parseDouble(credits));
		restaurantTransaction.setUser(user);
		restaurantTransaction.setRestaurant(restaurant);
	 	transactionBO.saveRestaurantTransactions(restaurantTransaction);
	 	transactionBO.updateRestaurantCredits(restId, restaurant.getCurrentCredits());
	 	/* Added current record to previous list */
	 	RestaurantTransactionTO to = new RestaurantTransactionTO();
	 	BeanUtils.copyProperties(to, restaurantTransaction);
	 	to.setTransDate(DateConverterUtility.convertDBTimeStampToUiDate(restaurantTransaction.getTransDate()));
	 	trans.add(to);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("trans", trans);
		request.setAttribute("restId", restId);
		/*  After successfully added redirected to selected host transactions(previouspage) */
		return mapping.findForward("modified");
	}

	/* Reduce credits to the particular restaurant by admin */
	public ActionForward ReduceCredits(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		TransactionBO transBO = com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		UserBO userDao = BusinessFactory.getUserBO();
		String credits = request.getParameter("credits");
		String description = request.getParameter("desc");
		/* Getting all transactions of the particular restaurants */
		ArrayList<RestaurantTransactionTO> trans = null;
		trans = new ArrayList<RestaurantTransactionTO>();
		String restid = request.getParameter("restId");
		Integer restId =0;
		try{
		if(restid!= null && restid.length()>0)
			restId = Integer.parseInt(restid);
		  trans = (ArrayList<RestaurantTransactionTO>)transBO.getRestaurantTransactions(restId);
		}catch(Exception e){
			
		}
		try{
		TransactionBO transactionBO=com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		Restaurant restaurant;
		restaurant = userDao.getRestaurantById(restId);
		
		RestaurantTransaction restaurantTransaction=new RestaurantTransaction();
		restaurantTransaction.setAmount(0);
		restaurantTransaction.setCurrentCredits((restaurant.getCurrentCredits()).intValue()-Integer.parseInt(credits));
		restaurantTransaction.setNoOfCredits(Integer.parseInt(credits));
		restaurantTransaction.setDescription(description);
		restaurantTransaction.setRemarks("Admin Added");
		restaurantTransaction.setTypeOfTrans(TangotabConstants.DEBIT);
		User user=new User();
		UserTO userTo = (UserTO)request.getSession().getAttribute("userInfo");
		user.setUserId(userTo.getUserId()); //Admin
		user.setFirstname(userTo.getFirstname());

		restaurant.setRestaurantId(restId);
		restaurant.setCurrentCredits(restaurant.getCurrentCredits()-Double.parseDouble(credits));
		restaurantTransaction.setUser(user);
		restaurantTransaction.setRestaurant(restaurant);
	 	transactionBO.saveRestaurantTransactions(restaurantTransaction);
	 	transactionBO.updateRestaurantCredits(restId, restaurant.getCurrentCredits());
	 	/* Added current record to previous list */
	 	RestaurantTransactionTO to = new RestaurantTransactionTO();
	 	BeanUtils.copyProperties(to, restaurantTransaction);
	 	to.setTransDate(DateConverterUtility.convertDBTimeStampToUiDate(restaurantTransaction.getTransDate()));
	 	trans.add(to);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("trans", trans);
		request.setAttribute("restId", restId);
		/*  After successfully added redirected to selected host transactions(previouspage) */
		return mapping.findForward("modified");
	}
	
/* search the details based on start and end dates */
	public ActionForward Search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try{
			ActionMessages messages = new ActionMessages();
			TransactionBO transBO = com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
			ArrayList<RestaurantTransactionTO> trans = null;
			trans = new ArrayList<RestaurantTransactionTO>();
			
			String restId = request.getParameter("restId");
			if(restId!=null && restId.length()>0)
				request.setAttribute("restId", restId);
			
															
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
		if (trans == null || trans.size() == 0) {
			messages.add("No Records",
					new ActionMessage("result.noRecords", " Please select a different date range."));
			saveMessages(request, messages);
		} 
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return mapping.findForward("search");
	}
	
	/* Cancel the process */
	public ActionForward Cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		
		TransactionBO transBO = com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		ArrayList<RestaurantTransactionTO> trans = null;
		trans = new ArrayList<RestaurantTransactionTO>();
		String restId = request.getParameter("restId");
		try{
		if(restId!= null && restId.length()>0)
		  trans = (ArrayList<RestaurantTransactionTO>)transBO.getRestaurantTransactions(Integer.parseInt(restId));
		}catch(Exception e){
			
		}
		request.setAttribute("trans", trans);
		request.setAttribute("restId", restId);
				
		return mapping.findForward("search");
	}
}
