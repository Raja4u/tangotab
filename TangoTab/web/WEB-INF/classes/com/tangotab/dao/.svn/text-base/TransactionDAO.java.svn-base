package com.tangotab.dao;

import java.util.ArrayList;
import java.util.Date;

import com.tangotab.dao.pojo.RestaurantTransaction;
import com.tangotab.exception.ApplicationException;

public interface TransactionDAO {
public ArrayList<RestaurantTransaction> getRestaurantTransactions(int restaurantId)throws ApplicationException;
public void saveRestaurantTransactions(RestaurantTransaction restaurantTransaction)throws ApplicationException;
public void updateRestaurantCredits(Integer restId,Double credits) throws ApplicationException;
public ArrayList<RestaurantTransaction> getRestaurantTransactions(
		int restaurantId,Date startDate, Date endDate) throws ApplicationException;
}
