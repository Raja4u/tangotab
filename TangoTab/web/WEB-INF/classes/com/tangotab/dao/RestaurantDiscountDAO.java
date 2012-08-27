package com.tangotab.dao;

import java.util.ArrayList;
import java.util.List;

import com.tangotab.dao.pojo.RestaurantDiscount;
import com.tangotab.exception.ApplicationException;

public interface RestaurantDiscountDAO {
	public Integer saveCoupon(RestaurantDiscount discount) throws ApplicationException;

	public List<RestaurantDiscount> getRestauantDiscountByLocation(int Locationid)
			throws ApplicationException;

	public RestaurantDiscount getRestauantDiscountDetails(int restDiscountId)
			throws ApplicationException;

	public void updateRestarentDiscount(RestaurantDiscount discount) throws ApplicationException;

}