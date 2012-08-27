package com.tangotab.business;

import java.util.ArrayList;
import java.util.List;

import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;

public interface BillingMethodsBO {

	// For billing Methods

	public List<BillingMethod> getBillingMethods() throws ApplicationException;

	public void saveBillingMethod(BillingMethod billingMethod) throws ApplicationException;

	public void updateBillingMethod(BillingMethod billingMethod, String activeupdate)
			throws ApplicationException;

	public BillingMethod getBillingMethod(int billingId) throws ApplicationException;

	// For billing Types

	public ArrayList<BillingType> getBillingTypes() throws ApplicationException;

	public void saveBillingType(BillingType billingType) throws ApplicationException;

	public void updateBillingType(BillingType billingType, String activeupdate)
			throws ApplicationException;

	public BillingType getBillingType(int billingId) throws ApplicationException;

	// For cuisine Types

	public ArrayList<CuisineType> getCuisineTypes() throws ApplicationException;

	public void saveCuisineType(CuisineType cuisineType) throws ApplicationException;

	public void updateCuisineType(CuisineType cuisineType, String activeupdate)
			throws ApplicationException;

	public CuisineType getCuisineType(int cuisineId) throws ApplicationException;

	// For restaurant Types

	public ArrayList<RestaurantType> getRestaurantTypes() throws ApplicationException;

	public void saveRestaurantType(RestaurantType restaurantType) throws ApplicationException;

	public void updateRestaurantType(RestaurantType restaurantType, String activeupdate)
			throws ApplicationException;

	public RestaurantType getRestaurantType(int restId) throws ApplicationException;

	// For dining styles

	public ArrayList<DiningStyle> getDiningStyles() throws ApplicationException;

	public void saveDiningStyle(DiningStyle diningStyle) throws ApplicationException;

	public void updateDiningStyle(DiningStyle diningStyle, String activeupdate)
			throws ApplicationException;

	public DiningStyle getDiningStyle(int diningId) throws ApplicationException;

}
