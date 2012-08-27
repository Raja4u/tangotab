package com.tangotab.business;

import java.util.ArrayList;

import com.tangotab.TO.ConsumerReservationTO;
import com.tangotab.TO.DealSummaryTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;

public interface LocationBO {
	public void saveLocation(LocationTO locationTO, String restOwnerEmailId)
			throws ApplicationException;

	public void updateLocation(LocationTO locationTO, String update) throws ApplicationException;

	public void saveDeal(DealTO dealTO) throws ApplicationException;

	public ArrayList<DealTO> getDeals(int userId, int roleId, int restId)
			throws ApplicationException;

	public ArrayList<DealTO> getDeals(int userId, int roleId, int restId, String dealType)
			throws ApplicationException;

	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId, int locationId)
			throws ApplicationException;

	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType) throws ApplicationException;
	
	public Long countDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType) throws ApplicationException;
	
	public Long countDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType, String locname) throws ApplicationException;
	
	/* used for pagination */
	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType, int currentPage) throws ApplicationException;
	
	/* used for pagination */
	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType, int currentPage, String locname) throws ApplicationException;

	public void updateDeal(DealTO dealTO) throws ApplicationException;

	public void publishDeal(int dealId) throws ApplicationException;

	public void unpublishDeal(int dealId) throws ApplicationException;

	public DealTO getDealByDealId(int dealId) throws ApplicationException;

	public ArrayList<LocationTO> getLocationsByRestaurantId(int restId) throws ApplicationException;

	public LocationTO fetchLocationByLocationId(int locationId) throws ApplicationException;

	public ArrayList<ConsumerReservationTO> getConsumerReservationsByDeal(int restaurantId)
			throws ApplicationException;

	public ArrayList<ConsumerReservationTO> getConsumerReservationsByDeal(int restaurantId,
			int locationId) throws ApplicationException;

	public boolean setCustomDealStatus(int dealID, int isActive) throws ApplicationException;

	// admin section
	public ArrayList<Restaurant> getAllLocations() throws ApplicationException;

	public boolean setLocationStatus(int locationId, Short status) throws ApplicationException;

	public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException;

	public void saveAdminLocation(LocationTO locationTO) throws ApplicationException;

	public void updateAdminLocation(LocationTO locationTO) throws ApplicationException;

	public int getNoOfLocations(Integer restId) throws ApplicationException;

    DealSummaryTO getDealSummary(Integer rid) throws ApplicationException;
}
