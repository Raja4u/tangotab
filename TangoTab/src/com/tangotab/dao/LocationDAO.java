package com.tangotab.dao;

import java.util.ArrayList;

import com.tangotab.TO.DealSummaryTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.RestaurantDealHistory;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;

public interface LocationDAO {
	public void saveLocation(RestaurantLocation location) throws ApplicationException;

	public int saveDeal(RestaurantDeal deal) throws ApplicationException;

	public int saveDealDetails(RestaurantDealHistory deal) throws ApplicationException;

	public void deleteLocations(int locationId) throws ApplicationException;

	public void updateDeal(RestaurantDeal deal) throws ApplicationException;

	public ArrayList<RestaurantDeal> searchDeals(int userId, int roleId, int restId)
			throws ApplicationException;

	public ArrayList<RestaurantDeal> searchDeals(int userId, int roleId, int restId, String dealType)
			throws ApplicationException;

	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId) throws ApplicationException;

	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType) throws ApplicationException;
	
	/* returns count of active/inactive deals for role 5 or 6 for a specified location */
	public Long countSearchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType) throws ApplicationException;
	
	/* returns count of active/inactive deals for role 5 or 6 for a specified location */
	public Long countSearchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType, String locname) throws ApplicationException;
	
	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType, int currentPage) throws ApplicationException;
	
	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType, int currentPage, String locname) throws ApplicationException;

	public RestaurantDeal getRestaurantDeal(int restaurantDealId) throws ApplicationException;

	public ArrayList<LocationTO> getRestaurantsById(int restaurantId) throws ApplicationException;

	public RestaurantDeal getDealByDealId(int dealId) throws ApplicationException;

	public void publishDeal(int dealId, int status) throws ApplicationException;

	public RestaurantLocation fetchLocationByLocationId(int locationId) throws ApplicationException;

	public void updateLocation(RestaurantLocation location) throws ApplicationException;

	public void deleteLocationDiningPreferences(int locationId) throws ApplicationException;

	public ArrayList<ConsumerReservation> getConsumerReservationsByDeal(int restaurantId)
			throws ApplicationException;

	public boolean setCustomDealStatus(int dealID, int isActive) throws ApplicationException;

	public ArrayList<Restaurant> getAllLocations() throws ApplicationException;

	public boolean setLocationStatus(int locationId, Short status) throws ApplicationException;

	public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException;

	public ArrayList<ConsumerReservation> getConsumerReservationsByDeal(int restaurantId,
			int locationId) throws ApplicationException;

	public boolean debitCreditForCustomDeal(int restLocationId) throws ApplicationException;

	public Object[] getCurrentCreditsWithUserDetailsForLocation(int restLocationId)
			throws ApplicationException;

	public DealSummaryTO getDealSummary(int resId) throws ApplicationException;

	public int getNoOfLocations(Integer restId) throws ApplicationException;

}
