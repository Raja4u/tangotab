package com.tangotab.business;

import java.util.List;

import com.tangotab.dao.pojo.RestaurantDiscount;
import com.tangotab.exception.ApplicationException;

public interface RestaurantDiscountBO {
	public void saveCreditDiscount(RestaurantDiscount discount) throws ApplicationException;

	public List<RestaurantDiscount> getRestauantDiscountByLocation(int Locationid)
			throws ApplicationException;

	public RestaurantDiscount getRestauantDiscountDetails(int restDiscountId)
			throws ApplicationException;

	public void updateRestarentDiscount(RestaurantDiscount discount) throws ApplicationException;
}
