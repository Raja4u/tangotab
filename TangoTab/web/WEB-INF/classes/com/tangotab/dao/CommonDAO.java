package com.tangotab.dao;

import java.util.ArrayList;
import java.util.List;

import com.tangotab.TO.RatingTO;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.Country;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.PriceIndex;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.dao.pojo.State;
import com.tangotab.dao.pojo.ZipCode;
import com.tangotab.exception.ApplicationException;

public interface CommonDAO {
	public ArrayList<Country> getCountries();

	public ArrayList<State> getStates();

	public ArrayList<State> getStates(String searchType);

	public ArrayList<City> getCities();
	
	public ArrayList<City> getCitiesForAdmin();

	public List<CuisineType> getCuisineTypes();

	public List<DiningStyle> getDiningStyles();

	public List<RestaurantType> getBusinessTypes();

	public List<BillingMethod> getBillingMethods();

	public List<BillingType> getBillingTypes();

	public boolean isEmailIdAvailable(String emailId) throws ApplicationException;

	public ArrayList<State> getState(int countryId) throws ApplicationException;

	public ArrayList<City> getCity(int stateId) throws ApplicationException;
	
	public ArrayList<City> getCityForAdmin(int stateId) throws ApplicationException;

	public ArrayList<City> getCity(int stateId, String searchType) throws ApplicationException;

	public ArrayList<ZipCode> getZipCode(int cityId) throws ApplicationException;

	public boolean verifyValidationCode(String emailId, String password, String validationCode)
			throws ApplicationException;

	public ArrayList<DealTemplate> getDeals();

	public ArrayList<RatingTO> getRestaurantRatings() throws ApplicationException;

	public ArrayList<PriceIndex> getPriceIndexs() throws ApplicationException;

	public State getStatesById(int stateId);
	
	public ArrayList<Events> getAllEvents();
	
	public ArrayList<RestaurantLocation> getAllLocations() throws ApplicationException ;
	
	public ArrayList<RestaurantLocation> getAllLocations(double lat1,double long1) throws ApplicationException ;

	public Integer getCharityCount() throws ApplicationException;
		
	
}
