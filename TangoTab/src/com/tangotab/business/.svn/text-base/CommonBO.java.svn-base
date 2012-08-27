package com.tangotab.business;

import java.util.ArrayList;
import java.util.List;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.CountryTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.EventsTO;
import com.tangotab.TO.PriceIndexTO;
import com.tangotab.TO.RatingTO;
import com.tangotab.TO.StateTO;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.dao.pojo.State;
import com.tangotab.exception.ApplicationException;

public interface CommonBO {
	public ArrayList<CountryTO> getCountries();

	public ArrayList<StateTO> getStates();

	public ArrayList<StateTO> getStates(String searchType);

	public ArrayList<StateTO> getStatesByCountry(int countryId);

	public State getStatesById(int stateId);

	public ArrayList<CityTO> getCities();

	public ArrayList<CityTO> getCitiesByState(int stateId);
	
	public ArrayList<CityTO> getCitiesForAdmin();

	public ArrayList<CityTO> getCitiesByStateForAdmin(int stateId);

	public List<CuisineType> getCuisineTypes();

	public List<DiningStyle> getDiningStyles();

	public List<RestaurantType> getBusinessTypes();

	public List<BillingMethod> getBillingMethods();

	public List<BillingType> getBillingTypes();

	public List<DealTO> getDeals();

	public List<RatingTO> getRatings();

	public List<PriceIndexTO> getPrices();
	
	public ArrayList<EventsTO> getAllEvents();
	
	public ArrayList<RestaurantLocation> getAllLocations();
	public ArrayList<RestaurantLocation> getAllLocations(String address) throws ApplicationException ;
	public Integer getCharityCount() throws ApplicationException;
}
