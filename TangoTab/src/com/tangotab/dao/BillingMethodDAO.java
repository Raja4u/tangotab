package com.tangotab.dao;

import java.util.ArrayList;
import java.util.List;

import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;

public interface BillingMethodDAO {

	public List<BillingMethod> getBillingMethods() throws ApplicationException;

	public Integer saveBillingMethod(BillingMethod billingMethod) throws ApplicationException;

	public void updateBillingMethod(BillingMethod billingMethod) throws ApplicationException;

	public BillingMethod getBillingMethod(int id) throws ApplicationException;

	// ****** For billing type******

	public ArrayList<BillingType> getBillingTypes() throws ApplicationException;

	public void saveBillingType(BillingType billingType) throws ApplicationException;

	public void updateBillingType(BillingType billingType) throws ApplicationException;

	public BillingType getBillingType(int id) throws ApplicationException;

	// ****** For cuisine type******

	public ArrayList<CuisineType> getCuisineTypes() throws ApplicationException;

	public void saveCuisineType(CuisineType cuisineType) throws ApplicationException;

	public void updateCuisineType(CuisineType cuisineType) throws ApplicationException;

	public CuisineType getCuisineType(int id) throws ApplicationException;

	// ****** For Restaurant type******

	public ArrayList<RestaurantType> getRestaurantTypes() throws ApplicationException;

	public void saveRestaurantType(RestaurantType restaurantType) throws ApplicationException;

	public void updateRestaurantType(RestaurantType restaurantType) throws ApplicationException;

	public RestaurantType getRestaurantType(int id) throws ApplicationException;

	// ****** For dining styles******

	public ArrayList<DiningStyle> getDiningStyles() throws ApplicationException;

	public void saveDiningStyle(DiningStyle diningStyle) throws ApplicationException;

	public void updateDiningStyle(DiningStyle diningStyle) throws ApplicationException;

	public DiningStyle getDiningStyle(int id) throws ApplicationException;

}
