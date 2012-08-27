package com.tangotab.businessImpl;

import com.tangotab.TO.CityTO;
import com.tangotab.TO.CountryTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.EventsTO;
import com.tangotab.TO.PriceIndexTO;
import com.tangotab.TO.RatingTO;
import com.tangotab.TO.StateTO;
import com.tangotab.business.CommonBO;
import com.tangotab.dao.CommonDAO;
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
import com.tangotab.exception.ApplicationException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class CommonBOImpl implements CommonBO {

    @Autowired
    protected CommonDAO commonDAO;
    private static final Logger logger = Logger.getLogger(LocationBOImpl.class);

    /* returns only active cities */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<CityTO> getCities() {
		ArrayList<CityTO> citiesList = new ArrayList<CityTO>();
		ArrayList<City> cities = getCommonDAO().getCities();
		for (City city : cities) {
			CityTO cityInfo = new CityTO();
			cityInfo.setCityId(city.getCityId());
			cityInfo.setCityName(city.getCityName());
			cityInfo.setCityCode(city.getCityCode());
			cityInfo.setIsActive(city.getIsActive());
			try{
			BeanUtils.copyProperties(cityInfo,city);
			}catch (Exception e) {
				// TODO: handle exception
			}
			citiesList.add(cityInfo);
		}
		return citiesList;
	}

    protected CommonDAO getCommonDAO() {
        return commonDAO;
    }

    /* returns only active cities */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<CityTO> getCitiesForAdmin() {
		ArrayList<CityTO> citiesList = new ArrayList<CityTO>();
		ArrayList<City> cities = getCommonDAO().getCitiesForAdmin();
		for (City city : cities) {
			CityTO cityInfo = new CityTO();
			cityInfo.setCityId(city.getCityId());
			cityInfo.setCityName(city.getCityName());
			cityInfo.setCityCode(city.getCityCode());
			cityInfo.setIsActive(city.getIsActive());
			citiesList.add(cityInfo);
		}
		return citiesList;
	}

	/* returns all countries */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<CountryTO> getCountries() {
		ArrayList<Country> countries = getCommonDAO().getCountries();
		ArrayList<CountryTO> contryList = new ArrayList<CountryTO>();
		for (Country country : countries) {
			CountryTO countryInfo = new CountryTO();
			try {
				BeanUtils.copyProperties(countryInfo, country);
			} catch (Exception e) {
				e.printStackTrace();
			}
			contryList.add(countryInfo);
		}
		return contryList;
	}

	/* get state details by stateid*/
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public State getStatesById(int stateId) {
		return getCommonDAO().getStatesById(stateId);
	}

	/* returns all cuisine types */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<CuisineType> getCuisineTypes() {
		return getCommonDAO().getCuisineTypes();
	}

	/* returns all dining styles */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<DiningStyle> getDiningStyles() {
		return getCommonDAO().getDiningStyles();
	}

	/* returns all states including its country details */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<StateTO> getStates() {
		ArrayList<StateTO> statesList = new ArrayList<StateTO>();
		ArrayList<State> states = getCommonDAO().getStates();
		for (State state : states) {
			StateTO stateInfo = new StateTO();
			stateInfo.setCountry(state.getCountry());
			stateInfo.setStateCode(state.getStateCode());
			stateInfo.setStateId(state.getStateId());
			stateInfo.setStateName(state.getStateName());
			stateInfo.setIsActive(state.getIsActive());
			statesList.add(stateInfo);
		}
		return statesList;
	}

	/* returns all states information */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<StateTO> getStates(String searchType) {
		ArrayList<StateTO> statesList = new ArrayList<StateTO>();
		ArrayList<State> states = getCommonDAO().getStates(searchType);
		for (State state : states) {
			StateTO stateInfo = new StateTO();
			stateInfo.setStateCode(state.getStateCode());
			stateInfo.setStateId(state.getStateId());
			stateInfo.setStateName(state.getStateName());
			stateInfo.setIsActive(state.getIsActive());
			statesList.add(stateInfo);
		}
		return statesList;
	}

	/* returns all active cities which come under the stateid specified */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<CityTO> getCitiesByState(int stateId) {
		ArrayList<CityTO> citiesList = new ArrayList<CityTO>();
		try {

			ArrayList<City> cities = getCommonDAO().getCity(stateId);
			for (City city : cities) {
				CityTO cityInfo = new CityTO();
				cityInfo.setCityId(city.getCityId());
				cityInfo.setCityName(city.getCityName());
				cityInfo.setCityCode(city.getCityCode());
				cityInfo.setIsActive(city.getIsActive());
				citiesList.add(cityInfo);
			}
		} catch (ApplicationException e) {

		}
		return citiesList;
	}

	/* returns all inactive/active cities which come under the stateid specified */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<CityTO> getCitiesByStateForAdmin(int stateId) {
		ArrayList<CityTO> citiesList = new ArrayList<CityTO>();
		try {

			ArrayList<City> cities = getCommonDAO().getCityForAdmin(stateId);
			for (City city : cities) {
				CityTO cityInfo = new CityTO();
				cityInfo.setCityId(city.getCityId());
				cityInfo.setCityName(city.getCityName());
				cityInfo.setCityCode(city.getCityCode());
				cityInfo.setIsActive(city.getIsActive());
				citiesList.add(cityInfo);
			}
		} catch (ApplicationException e) {

		}
		return citiesList;
	}


	/* get all states corresponding to country specified */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<StateTO> getStatesByCountry(int countryId) {
		ArrayList<StateTO> statesList = new ArrayList<StateTO>();
		ArrayList<State> states;
		try {
			states = getCommonDAO().getState(countryId);
			for (State state : states) {
				StateTO stateInfo = new StateTO();
				stateInfo.setStateCode(state.getStateCode());
				stateInfo.setStateId(state.getStateId());
				stateInfo.setStateName(state.getStateName());
				statesList.add(stateInfo);
			}
		} catch (ApplicationException e) {
		}
		return statesList;
	}

	/* get all billing methods */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<BillingMethod> getBillingMethods() {
		return getCommonDAO().getBillingMethods();
	}

	/* get all billing types */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<BillingType> getBillingTypes() {
		return getCommonDAO().getBillingTypes();
	}

	/* get all business types */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<RestaurantType> getBusinessTypes() {
		return getCommonDAO().getBusinessTypes();
	}

	/* get all deals */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public List<DealTO> getDeals() {
        List<DealTemplate> templates = getCommonDAO().getDeals();
        List<DealTO> deals = new ArrayList<DealTO>();
        for (DealTemplate template : templates) {
            DealTO deal = new DealTO();
            try {
                BeanUtils.copyProperties(deal, template);
            } catch (Exception e) {
                e.printStackTrace();
            }
            deals.add(deal);
        }
        return deals;
    }

	/* get details of all prices (start & end )*/
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<PriceIndexTO> getPrices() {
		List<PriceIndexTO> prices = new ArrayList<PriceIndexTO>();
		try {

			List<PriceIndex> pricesInfo = getCommonDAO().getPriceIndexs();
			if (null != pricesInfo && pricesInfo.size() > 0) {
				for (PriceIndex periceInfo : pricesInfo) {

					PriceIndexTO price = new PriceIndexTO();
					price.setPriceId(periceInfo.getPriceId());
					price.setStartPrice(periceInfo.getStartPrice());
					price.setEndPrice(periceInfo.getEndPrice());
					prices.add(price);
				}
			}
		} catch (ApplicationException e) {

		}
		return prices;
	}

	/* get the rating information from database */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<RatingTO> getRatings() {
		List<RatingTO> ratings = null;
		try {
			ratings = getCommonDAO().getRestaurantRatings();
		} catch (ApplicationException e) {

		}
		return ratings;
	}

	/* get all events */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<EventsTO> getAllEvents(){

		ArrayList<EventsTO> eventsTo = new ArrayList<EventsTO>();
		try {
			List<Events> events = getCommonDAO().getAllEvents();
			for(Events event : events){
				EventsTO eventTO = new EventsTO();
				eventTO.setEventId(event.getEventId());
				eventTO.setEventCode(event.getEventCode());
				eventTO.setEventName(event.getEventName());
				eventTO.setIsActive(event.getIsActive());
				eventTO.setStartDate(event.getStartDate());
				eventTO.setEndDate(event.getEndDate());
				eventsTo.add(eventTO);
			}
		}
		catch (Exception e) {
    	}
		return eventsTo;
	}

	/* Get all restaurant locations */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<RestaurantLocation> getAllLocations(){

		ArrayList<RestaurantLocation> restaurants = new ArrayList<RestaurantLocation>();
		try{
			 restaurants = getCommonDAO().getAllLocations();
		}catch(Exception e){

		}
		return restaurants;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public ArrayList<RestaurantLocation> getAllLocations(String address)
			throws ApplicationException {
		ArrayList<RestaurantLocation> restaurants = new ArrayList<RestaurantLocation>();
		double lat1 = 0;
		double long1 = 0;
		try {

			String countryCode = null;
			String url = "";

			try {
				/*
				 * For fetching the CountryNameCode from JSON object and set
				 * longitude and latitude
				 */
				url = "http://maps.googleapis.com/maps/geo?q=" + address
						+ "&output=json&sensor=true";
				url = url.replace(" ", "%20");
				url = url.replace(" ", "%20");
				url = url.replace("#", ",");
				url = url.replace("$", ",");
				url = url.replace("\n", "");
				url = url.replace("\r", "");

				URL getURL = new URL(url);

				InputStream inStream = null;
				inStream = getURL.openConnection().getInputStream();
				byte[] b = new byte[inStream.available()];
				inStream.read(b);
				String jsonContent = new String(b);
				JSONParser parser = new JSONParser();
				
				Object obj = parser.parse(jsonContent);

				JSONObject jsonObject = (JSONObject) obj;

				JSONArray msg = (JSONArray) jsonObject.get("Placemark");

				for (int i = 0; i < msg.size(); i++) {
					JSONObject jsonLineItem = (JSONObject) msg.get(i);

					JSONObject jsonLineItem2 = (JSONObject) jsonLineItem
							.get("AddressDetails");

					JSONObject jsonLineItem3 = (JSONObject) jsonLineItem2
							.get("Country");

					countryCode = jsonLineItem3.get("CountryNameCode")
							.toString();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (StringUtils.isEmpty(countryCode)  || countryCode == null) {
				url = "http://maps.googleapis.com/maps/geo?q=" + address
						+ "&output=csv&sensor=true";
			}
			else if (countryCode.equals("US")) {
				url = "http://maps.googleapis.com/maps/geo?q=" + address
						+ ",US&output=csv&sensor=true";
			}
			else if (countryCode.equals("CA")) {
				url = "http://maps.googleapis.com/maps/geo?q=" + address
						+ ",CA&output=csv&sensor=true";
			}
			else {
				url = "http://maps.googleapis.com/maps/geo?q=" + address
						+ "&output=csv&sensor=true";
			}
			try{
			url = url.replace(" ", "%20");
			url = url.replace(" ", "%20");
			url = url.replace("#", ",");
			url = url.replace("$", ",");
			url = url.replace("\n", "");
			url = url.replace("\r", "");
			
			URL getNewURL = new URL(url);

			InputStream inStream1 = null;
			inStream1 = getNewURL.openConnection().getInputStream();
			byte[] b1 = new byte[inStream1.available()];
			inStream1.read(b1);
			String jsonContents = new String(b1);
			if (jsonContents.split(",").length == 4) {
				String csv[] = jsonContents.split(",");
				if (Integer.parseInt(csv[0]) == 200) {

					lat1 = Double.parseDouble(csv[2]);
					long1 = Double.parseDouble(csv[3]);
					
				}
			}
			}catch(Exception e){
				lat1 = 0;
				long1 = 0;
				logger.error("didn't fetch lat, long for this location: ", e);
			}

			restaurants = getCommonDAO().getAllLocations(lat1, long1);
		} catch (Exception e) {
			logger.error("getCommonDAO().getAllLocations: ", e);
		}
		
		return restaurants;
	}
	/* fetching the latest charity value */
	public Integer getCharityCount() throws ApplicationException{
		Integer count  = 0;
		try{
			 count = getCommonDAO().getCharityCount();
		}catch(Exception e){
			
		}
		return count;
		
	}
}
