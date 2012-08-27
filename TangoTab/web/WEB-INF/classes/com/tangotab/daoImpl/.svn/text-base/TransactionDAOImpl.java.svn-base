package com.tangotab.daoImpl;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.util.Calendar;
import com.tangotab.dao.TransactionDAO;
import com.tangotab.dao.pojo.RestaurantTransaction;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class TransactionDAOImpl extends TempDAOImpl implements TransactionDAO {
	private Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
/*
 * 
 * Get Restaurant Transaction authorize.net
 */
@SuppressWarnings("unchecked")
public ArrayList<RestaurantTransaction> getRestaurantTransactions(
		int restaurantId) throws ApplicationException {
 
	if (log.isDebugEnabled())
		log.debug("Start of getUser ");
	ArrayList<RestaurantTransaction>  transaction  = null;
	Session session = getSession(false);
	if (session.contains(RestaurantTransaction.class)) {
		session.evict(RestaurantTransaction.class);
	}
	if (restaurantId != 0) {
		try {
			Calendar end = Calendar.getInstance();
			Date d = new Date();
			end.setTime(d);
			end.add(Calendar.MONTH, -1);
			Date d1 = end.getTime();
			Criteria criteria = session.createCriteria(RestaurantTransaction.class, "transaction")
			.createAlias("transaction.restaurant", "restaurant").add(
					Restrictions.eq("restaurant.restaurantId", restaurantId));
			criteria.add(
					Restrictions.ge("transaction.transDate", new java.sql.Timestamp(d1.getTime())));
			transaction=(ArrayList<RestaurantTransaction>)	  criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getUser" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
	return transaction;
}
/*
 * 
 * Get Restaurant Transactions for  authorize.net
 */
@SuppressWarnings("unchecked")
public ArrayList<RestaurantTransaction> getRestaurantTransactions(
		int restaurantId,Date startDate, Date endDate) throws ApplicationException {
 
	if (log.isDebugEnabled())
		log.debug("Start of getUser ");
	ArrayList<RestaurantTransaction>  transaction  = null;
	Session session = getSession(false);
	if (session.contains(RestaurantTransaction.class)) {
		session.evict(RestaurantTransaction.class);
	}
	if (restaurantId != 0) {
		try {
			 
			Criteria criteria = session.createCriteria(RestaurantTransaction.class, "transaction")
			.createAlias("transaction.restaurant", "restaurant").add(
					Restrictions.eq("restaurant.restaurantId", restaurantId));
			if(startDate != null)
				criteria.add(
					Restrictions.ge("transaction.transDate", new java.sql.Timestamp(startDate.getTime())));
			if(endDate != null)
				criteria.add(
				    Restrictions.le("transaction.transDate", new java.sql.Timestamp(endDate.getTime()) ));
			transaction=(ArrayList<RestaurantTransaction>)criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getUser" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
	return transaction;
}
/*
 * 
 * Save Restaurant Transaction authorize.net
 * 
 */
public void saveRestaurantTransactions(RestaurantTransaction restaurantTransaction)
		throws ApplicationException {
	if (log.isDebugEnabled())
		log.debug("Start of saveConsumer ");
	Session session = getSession(false);
	//Transaction transaction1 = session.beginTransaction();
	try {
		session.save(restaurantTransaction);
		//transaction1.commit();
	} catch (Exception e) {
		if (log.isErrorEnabled()) {
			log.error("Error occured in saveConsumer" + e.getMessage());
		}
		e.printStackTrace();
		//transaction1.rollback();
		throw new ApplicationException("DB001", TangotabConstants.ERROR);
	} finally {
		//session.close();
	}
 
	
}

public void updateRestaurantCredits(Integer restId,Double credits) throws ApplicationException{
	if (log.isDebugEnabled())
		log.debug("Start of saveConsumer ");
	Session session = getSession(false);
	//Transaction transaction = session.beginTransaction();
	try {
		SQLQuery query = session
		.createSQLQuery(TangotabConstants.UPDATE_HOST_CREDITS);
		query.setParameter(0, credits);
		query.setParameter(1, restId);
        query.executeUpdate();
		//transaction.commit();
	} catch (Exception e) {
		if (log.isErrorEnabled()) {
			log.error("Error occured in saveConsumer" + e.getMessage());
		}
		e.printStackTrace();
		//transaction.rollback();
		throw new ApplicationException("DB001", TangotabConstants.ERROR);
	} finally {
		//session.close();
	}
}
}