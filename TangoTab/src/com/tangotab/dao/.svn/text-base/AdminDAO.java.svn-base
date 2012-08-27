package com.tangotab.dao;

import java.util.ArrayList;
import java.util.List;

import com.tangotab.dao.pojo.AdminDealImages;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;

/**
 * 
 * @author Nkumar
 * 
 */
public interface AdminDAO {
	public int saveCuisineType(CuisineType cuisine) throws ApplicationException;

	public int updateCuisineType(CuisineType cuisine) throws ApplicationException;

	public ArrayList<CuisineType> getCuisineTypes() throws ApplicationException;

	public CuisineType getCuisineTypeById(int cuisineTypeId) throws ApplicationException;

	public int deleteCuisineType(int cuisineTypeId) throws ApplicationException;

	public int saveBillingType(BillingType billingType) throws ApplicationException;

	public int updateBillingType(BillingType billingType) throws ApplicationException;

	public ArrayList<BillingType> getBillingTypes() throws ApplicationException;

	public int deleteBillingType(int billingTypeId) throws ApplicationException;

	public BillingType getBillingTypeById(int billingTypeId) throws ApplicationException;

	public int saveBillingMethod(BillingMethod billingMethod) throws ApplicationException;

	public int updateBillingMethod(BillingMethod billingMethod) throws ApplicationException;

	public ArrayList<BillingMethod> getBillingMethods() throws ApplicationException;

	public int deleteBillingMethod(int billingMethodId) throws ApplicationException;

	public BillingMethod getBillingMethodById(int billingMethodId) throws ApplicationException;

	public int saveRestaurantType(RestaurantType restaurantType) throws ApplicationException;

	public int updateRestaurantType(RestaurantType restaurantType) throws ApplicationException;

	public ArrayList<RestaurantType> getRestaurantTypes() throws ApplicationException;

	public int deleteRestaurantType(int restaurantTypeId) throws ApplicationException;

	public RestaurantType getRestaurantTypeById(int restaurantTypeId) throws ApplicationException;

	public DiningStyle getDiningStyleById(int diningStyleId) throws ApplicationException;

	public int deleteDiningStyle(int diningStyleId) throws ApplicationException;

	public List<DiningStyle> getDiningStyles() throws ApplicationException;

	public int saveDiningStyle(DiningStyle diningStyle) throws ApplicationException;

	public int updateDiningStyle(DiningStyle diningStyle) throws ApplicationException;

	public boolean activateRestaurant(int restaurantId) throws ApplicationException;

	public boolean deactivateRestaurant(int restaurantId) throws ApplicationException;

	public boolean activateRestaurantLocation(int restaurantLocationId) throws ApplicationException;

	public boolean deactivateRestaurantLocation(int restaurantLocationId)
			throws ApplicationException;

	public void saveCity(City city) throws ApplicationException;

	public boolean setCityStatus(int city_id, Integer status) throws ApplicationException;

	public boolean setStateStatus(int state_id, Integer status) throws ApplicationException;

	public ArrayList<AdminDealImages> getImages(String dealName) throws ApplicationException;
	
	public void saveLanding(Landing landing) throws ApplicationException;
	
	public ArrayList<Landing> getLandings() throws ApplicationException ;
	
}