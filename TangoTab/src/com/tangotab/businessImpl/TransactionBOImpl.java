package com.tangotab.businessImpl;

import com.tangotab.TO.RestaurantTransactionTO;
import com.tangotab.business.TransactionBO;
import com.tangotab.dao.TransactionDAO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantTransaction;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

@Service("com.tangotab.business.TransactionBO")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class TransactionBOImpl implements TransactionBO	 {
	public static Logger log = LoggerFactory.getLogger(TransactionBOImpl.class);

    @Autowired
    protected TransactionDAO transactionDAO;

	/* Get all transaction details of the particular restaurant */
	public ArrayList<RestaurantTransactionTO> getRestaurantTransactions(
			int restaurantId) throws ApplicationException {
		// TODO Auto-generated method stub
        ArrayList<RestaurantTransaction> arrayTrans	= transactionDAO.getRestaurantTransactions(restaurantId);
	ArrayList<RestaurantTransactionTO> trans = new ArrayList<RestaurantTransactionTO>();
	for(RestaurantTransaction t1:arrayTrans)
	{
		User user = t1.getUser();
		log.debug(user.getFirstname());
		RestaurantTransactionTO transto = new RestaurantTransactionTO();
		try {
			BeanUtils.copyProperties(transto, t1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transto.setTransDate(DateConverterUtility.convertDBTimeStampToUiDate(t1.getTransDate()));
		trans.add(transto);
	}
		return trans;
	}
	
	/*
	 * Get transactions of a restaurant form starting date to ending date 
	 * */
	public ArrayList<RestaurantTransactionTO> getRestaurantTransactions(
			int restaurantId,Date startDate, Date endDate) throws ApplicationException{
		ArrayList<RestaurantTransaction> arrayTrans = transactionDAO.getRestaurantTransactions(restaurantId, startDate, endDate);
		ArrayList<RestaurantTransactionTO> trans = new ArrayList<RestaurantTransactionTO>();
		for(RestaurantTransaction t1:arrayTrans)
		{
			User user = t1.getUser();
			log.debug(user.getFirstname());
			RestaurantTransactionTO transto = new RestaurantTransactionTO();
			try {
				BeanUtils.copyProperties(transto, t1);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			transto.setTransDate(DateConverterUtility.convertDBTimeStampToUiDate(t1.getTransDate()));
			trans.add(transto);
		}
			return trans;
	}
	
	/*
	 * Save the current Transaction 
	 * */
	public void saveRestaurantTransactions(RestaurantTransaction restaurantTransaction)throws ApplicationException
	{
		restaurantTransaction.setTransDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		transactionDAO.saveRestaurantTransactions(restaurantTransaction);
	}
	
	/*
	 * Update restaurant credits of a restaurant 
	 * */
	public void updateRestaurantCredits(Integer restId,Double credits) throws ApplicationException{
		transactionDAO.updateRestaurantCredits(restId, credits);
	}
	
	public static void main(String s[])
	{
		try
		{
		TransactionBO transactionBOImpl=com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
		transactionBOImpl.getRestaurantTransactions(40);
		RestaurantTransaction restaurantTransaction=new RestaurantTransaction();
		restaurantTransaction.setAmount(100);
		restaurantTransaction.setCurrentCredits(100);
		restaurantTransaction.setNoOfCredits(100);
		restaurantTransaction.setDescription("des");
		restaurantTransaction.setRemarks("remarks");
		restaurantTransaction.setTypeOfTrans("cr");
		User user=new User();
		user.setUserId(420);
		Restaurant restaurant= new Restaurant();
		restaurant.setRestaurantId(40);
		restaurantTransaction.setUser(user);
		restaurantTransaction.setRestaurant(restaurant);
		transactionBOImpl.saveRestaurantTransactions(restaurantTransaction);
		}
		catch (  ApplicationException e) {
			// TODO: handle exception
		}
	}
}