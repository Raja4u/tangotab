package com.tangotab.businessImpl;

import com.tangotab.TO.ConsumerReservationTO;
import com.tangotab.TO.DealSummaryTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.RestaurantTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.ConfigBO;
import com.tangotab.business.LocationBO;
import com.tangotab.dao.LocationDAO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DealEvent;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.RestaurantDinnigPreferences;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantLocationPreference;
import com.tangotab.dao.pojo.Role;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangoTabMailer;
import com.tangotab.util.TangoTabPasswordEncrypt;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class LocationBOImpl implements LocationBO {

    private static final Logger logger = Logger.getLogger(LocationBOImpl.class);
    @Autowired
    protected LocationDAO locationDAO;

    /*
      *  Save Restaurant Location
      *
      *
      */
	public void saveLocation(LocationTO locationTO, String restOwnerEmailId)
			throws ApplicationException {
		RestaurantLocation location = constructLocation(locationTO, "");
		
		String dealMgrEmailId = locationTO.getEmailId();
		String dealMgrName = locationTO.getFirstname();
		String password = new String();
		int flag = 1;
		if (location.getUser().getUserId() < 1) {
			location.getUser().setUserId(null);
			flag = 0;
		}
		
		location.getUser().setIsActive((short) 1);
		try {
			getLocationDAO().deleteLocationDiningPreferences(locationTO.getRestLocationId());
			getLocationDAO().deleteLocationDiningPreferences(locationTO.getRestLocationId());
			/* sets new password only for new loc manager */
			if (flag == 0) {
				password = location.getUser().getPassword();
				location.getUser()
						.setPassword(TangoTabPasswordEncrypt.getPasswordEncrypt(password));
				location.getUser().setIsPwdChange((short) 1);

			}else if (location.getUser().getPassword() != null)
				password = TangoTabPasswordEncrypt.getPasswordDecrypt(location.getUser().getPassword());
			
			getLocationDAO().saveLocation(location);

			String validationEmailContent = null;
			
				validationEmailContent = TangotabConstants.DEAL_MGR_WELCOME_EMAIL_CONTENT.replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealMgrName).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, dealMgrEmailId).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, password).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME, location.getLocationRestName());
				


			/*	validationEmailContent = TangotabConstants.DEAL_MGR_ASSIGNED_EMAIL_CONTENT.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealMgrName); */

			
			String cc = null;
			/* attach all alternate emails in cc 
			if( StringUtils.isNotEmpty(location.getAlternateEmailIds()) )
				cc=  location.getAlternateEmailIds().replace(":", ",");*/
			/* If host is not a deal manager then don't send an email */
			if(locationTO.getHostAsManager().equals("No"))
				TangoTabMailer.sendEmail(dealMgrEmailId, null,TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,
					TangotabConstants.VALIDATION_EMAIL_HEADER, validationEmailContent);
			//TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, null,
			//		TangotabConstants.VALIDATION_EMAIL_HEADER, validationEmailContent);
		} catch (ApplicationException e) {
			throw e;
		}
	}

    private LocationDAO getLocationDAO() {
        return locationDAO;
    }

    /*
      *  Update Restaurant Location
      *
      *
      */
	public void updateLocation(LocationTO locationTO, String update) throws ApplicationException {
		RestaurantLocation location = constructLocation(locationTO, update);
		try {
			int newUser = 0;
			String password = new String();
			String validationEmailContent = new String();
			if(location.getLatitude()==null)
			{
			location.setLatitude(0.0);	
			}
			if(location.getLongitude()==null)
			{
			location.setLongitude(0.0);	
			}
			int locationId = locationTO.getRestLocationId();
			getLocationDAO().deleteLocations(locationId);
			getLocationDAO().deleteLocationDiningPreferences(locationId);
			if (location.getUser().getUserId() == 0) {
				password = location.getUser().getPassword();
				location.getUser().setPassword(
						TangoTabPasswordEncrypt
								.getPasswordEncrypt(location.getUser().getPassword()));
				location.getUser().setUserId(null);
				newUser = 1;
			}else if (location.getUser().getPassword() != null)
				password = TangoTabPasswordEncrypt.getPasswordDecrypt(location.getUser().getPassword());
			
			getLocationDAO().updateLocation(location);
			String cc = null;
			/* attach all alternate emails in cc 
			if( StringUtils.isNotEmpty(location.getAlternateEmailIds()) )
				cc = location.getAlternateEmailIds().replace(":", ",");*/
			
			/* Mail should be sent for a new user or updated the dealmanager */
			if ( locationTO.getHostAsManager().equals("No") && ( newUser == 1 || update.equals("updateM") )) {
				validationEmailContent = TangotabConstants.DEAL_MGR_WELCOME_EMAIL_CONTENT.replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, location.getUser().getFirstname()).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, location.getUser().getEmailId()).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, password).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME, location.getLocationRestName());
						TangoTabMailer.sendEmail(location.getUser().getEmailId(), cc, TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,
						TangotabConstants.VALIDATION_EMAIL_HEADER, validationEmailContent);
			} 
			
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 *  Construct  Restaurant Location 
	 *  
	 *  
	 */
	private RestaurantLocation constructLocation(LocationTO locationTO, String typeOfConstruct) {
		RestaurantLocation location = new RestaurantLocation();
		try {
			User user = new User();
			Role role = new Role();
           
			Restaurant restaurant = new Restaurant();

			BeanUtils.copyProperties(location, locationTO);
			BeanUtils.copyProperties(user, locationTO);

			if ((StringUtils.isNotEmpty(typeOfConstruct) && (user.getUserId() > 0))
					|| ( locationTO.getUserId()!=null &&  locationTO.getUserId() > 0))
				user.setUserId(locationTO.getUserId());
			else {
				user.setUserId(0);
				/* if host him self as a manager then dont assign new password */
				if(locationTO.getHostAsManager().equals("No")){
					String randomPassword = TangoTabUtility.generateRandomCode();
					user.setPassword(randomPassword);
				}else
					user.setPassword(locationTO.getPassword());
			}
			user.setIsActive((short) 1);
			user.setUserCreateDate(new java.sql.Timestamp(new java.util.Date()
			.getTime()));
			 
			    role.setRoleId(TangotabConstants.RESTAURANT_STORE_MANAGER);
			 
				user.setRole(role);

			location.setUser(user);

			restaurant.setRestaurantId(locationTO.getRestaurantId());
			int[] preferencesList = locationTO.getPreferencesList();
			Set<RestaurantLocationPreference> preferences = new HashSet<RestaurantLocationPreference>();
			location.setLocationPreferences(preferences);
			for (int i = 0; i < preferencesList.length; i++) {
				RestaurantLocationPreference preference = new RestaurantLocationPreference();
				CuisineType type = new CuisineType();
				type.setCuisineTypeId(preferencesList[i]);
				preference.setCuisineTypeId(type);
				preference.setRestaurantLocation(location);
				preferences.add(preference);
			}
			int[] dininigPreferencesList = locationTO.getDiningStylePreferences();
			Set<RestaurantDinnigPreferences> diningPreferences = new HashSet<RestaurantDinnigPreferences>();
			location.setDiningPreferences(diningPreferences);
			for (int i = 0; i < dininigPreferencesList.length; i++) {
				RestaurantDinnigPreferences preference = new RestaurantDinnigPreferences();
				DiningStyle style = new DiningStyle();
				style.setDiningStyleId(dininigPreferencesList[i]);
				preference.setCuisineTypeId(style);
				preference.setRestaurantLocation(location);
				diningPreferences.add(preference);
			}
			City city = new City();
			city.setCityId(locationTO.getPreferCityId());
			location.setCity(city);
			location.setRestaurant(restaurant);
			
			String addrloc = location.getAddress();
			String addrloc1 = location.getAddress1();
			String cityid = location.getCityId();
			String statename = location.getStreetName();
			// String countryname = location.getCityId();
			String addr = "";
			if (addrloc != null && StringUtils.isNotEmpty(addrloc)) {
				addr = addrloc;
			}
			if (addrloc1 != null && StringUtils.isNotEmpty(addrloc1)) {
				addr = addr + "," + addrloc1;
			}
			if (cityid != null && StringUtils.isNotEmpty(cityid)) {
				addr = addr + "," + cityid;
			}
			if (statename != null && StringUtils.isNotEmpty(statename)) {
				addr = addr + "," + statename;
			}
			addr = addr.replace(".", "");
			addr = addr.replace(" ", "%20");
			addr = addr.replace(" ", "%20");
			String countryCode = null;
			String url="";
			/* For fetching the CountryNameCode from JSON object and set longitude and latitude */
			try {
				url = "http://maps.googleapis.com/maps/geo?q=" + addr
						+ "&output=json&sensor=true";
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
				inStream.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			/* Now get the appropriate lat, longitudes */
			try {
				if(StringUtils.isEmpty(countryCode)  || countryCode == null)
					url = "http://maps.googleapis.com/maps/geo?q=" + addr
					+ "&output=csv&sensor=true";
				
				else if (countryCode.equals("US")) {
					url = "http://maps.googleapis.com/maps/geo?q=" + addr
							+ ",US&output=csv&sensor=true";
				}
				else if (countryCode.equals("CA")) {
					url = "http://maps.googleapis.com/maps/geo?q=" + addr
							+ ",CA&output=csv&sensor=true";
				}else
					url = "http://maps.googleapis.com/maps/geo?q=" + addr
					+ "&output=csv&sensor=true";
					
				
				url = url.replace(" ", "%20");
				url = url.replace(" ", "%20");
				url = url.replace("#", ",");
				url = url.replace("$", ",");
				url = url.replace("\n", "");
				url = url.replace("\r", "");
				URL getNewURL = new URL(url);
				InputStream inStream = null;
				inStream = getNewURL.openConnection().getInputStream();
				byte[] b1 = new byte[inStream.available()];
				inStream.read(b1);
				String jsonContents = new String(b1);

				if (jsonContents.split(",").length == 4) {
					String csv[] = jsonContents.split(",");
					if (Integer.parseInt(csv[0]) == 200) {

						location.setLatitude(Double.parseDouble(csv[2]));
						location.setLongitude(Double.parseDouble(csv[3]));
					}
				}
				inStream.close();
			} catch (Exception e) {
				logger.error("didn't fetch lat, long for this location: ", e);
				//e.printStackTrace();
			}


			if (location.getLatitude() == null) {
				location.setLatitude(0.0);
			}
			if (location.getLongitude() == null) {
				location.setLongitude(0.0);
			}
		} catch (Exception e) {
		}
		return location;
	}
	/*
	 *  Increase the one day 
	 *  
	 *  
	 */
	public static Date addDay(Date date) {
		// TODO you may want to check for a null date and handle it.
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
	/*
	 *  Save Restaurant Location Deal 
	 *  
	 *  
	 */
	public void saveDeal(DealTO dealTO) throws ApplicationException {
		try {
			
			
			RestaurantDeal deal = constructDeal(dealTO);
			if (deal.getCustomDeal() == 0) {
				deal.setIsActive((short) 1);
			}
			if(dealTO.getEventId()!=0)
			{
				Events events=new Events();
				events.setEventId(dealTO.getEventId());
				DealEvent dealEvent =new DealEvent();
				dealEvent.setEvents(events);
				dealEvent.setRestaurantDeal(deal);
				deal.setDealEvent(dealEvent);
			}
			
		 
				getLocationDAO().saveDeal(deal);
			
			if(dealTO.getDealTemplateName().equals("custom"))
					{
				String validationEmailContent = new String();
				validationEmailContent = TangotabConstants.CUSTOM_ADMIN_EMAIL.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME,
						dealTO.getLocationName())
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_DATE, 
								DateConverterUtility.convertDBTimeStampToUiDate(deal.getRestDealStartDate()));
						
			 
				TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, null,
						TangotabConstants.CUSTOM_DEAL_HEADER, validationEmailContent);
				
					}
			
			/*RestaurantDealHistory dealHistory = new RestaurantDealHistory();
			try {

				BeanUtils.copyProperties(dealHistory, deal);
				deal.setDealTemplateId(dealTemplateId);
				dealHistory.setRestaurantDeal(deal);
				Date endDate = deal.getRestDealEndDate();
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(endDate);
				cal2.add(Calendar.HOUR, 24);
				endDate = cal2.getTime();
				int index1 = 1;

				for (Date start = deal.getRestDealStartDate(); start.before(endDate); start = addDay(start)) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(start);
					index1 = index1 + 1;
					if (index1 > 7 && deal.getIsRecurring() == 0)
						break;

					if (deal.getAvailableWeekDays().indexOf(
							String.valueOf(cal.get(Calendar.DAY_OF_WEEK))) > -1) {

						dealHistory.setRestDealStartDate(start);
						locationDAO.saveDealDetails(dealHistory);

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			if (deal.getDealTemplateId() > 0) {
				Object[] columns = (Object[]) getLocationDAO()
						.getCurrentCreditsWithUserDetailsForLocation(dealTO.getRestLocationId());
				double currentCredits = (Double) columns[0];
				String emailId = (String) columns[1];
				String firstName = (String) columns[2];
				Integer billingMethodId = (Integer) columns[3];
				ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
				ConfigPojo configPojo = configBO.getConfigDetails();
 
				double compare = TangotabConstants.MININUM_CREDITS_LIMIT
						/ configPojo.getDefaultDealCreditValue();
				/* compare represents minimun credits and restricts to min credits not amount */

				if ((currentCredits <= compare)
						&& (billingMethodId == TangotabConstants.BILLING_METHOD_ID)) {
					String content = TangotabConstants.LOW_CREDIT_NOTIFICATION_CONTENT.replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, firstName);
					TangoTabMailer.sendEmail(emailId, null,
							TangotabConstants.LOW_CREDIT_NOTIFICATION_HEADER, content);

					/* If audo debit option is checked, need to recharge the account automatically */
				}
			}

		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 *  Construct  Restaurant Location Deal 
	 *  
	 *  
	 */
	private RestaurantDeal constructDeal(DealTO dealTO) {
		RestaurantDeal deal = new RestaurantDeal();
		RestaurantLocation restaurantLocation = new RestaurantLocation();
		restaurantLocation.setRestLocationId(dealTO.getRestLocationId());
		deal.setRestaurantLocation(restaurantLocation);
		try {
			if(StringUtils.isEmpty(dealTO.getRestDealPublishedDate()))
				dealTO.setRestDealPublishedDate((new java.sql.Timestamp(DateConverterUtility.convertUiToServiceDate(dealTO.getStartDate()).getTime())).toString());
			if(StringUtils.isEmpty(dealTO.getRestDealCreateDate()))
				dealTO.setRestDealCreateDate(dealTO.getRestDealPublishedDate());
			BeanUtils.copyProperties(deal, dealTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		deal.setRestDealStartDate(DateConverterUtility
				.convertUiToServiceDate(dealTO.getStartDate()));
		deal.setRestDealEndDate(DateConverterUtility
				.convertUiToServiceDate(dealTO.getDealEndDate()));
		StringBuffer availableWeekDays = new StringBuffer("");
		int[] weekDays = dealTO.getWeekDays();
		if (weekDays != null) {
			for (int i = 0; i < weekDays.length; i++) {
				availableWeekDays.append(weekDays[i] + ",");
			}
		}
		if (dealTO.getCustomDealTemplateName() != null
				&& !dealTO.getCustomDealTemplateName().trim().equals("")) {
			deal.setDealTemplateName(dealTO.getCustomDealTemplateName());
			deal.setCustomDeal((short) 1);
		}
		deal.setAvailableWeekDays(availableWeekDays.toString());
		
		return deal;
	}
	/*
	 *  Get Restaurant Deals  
	 *  
	 *  
	 */
	public ArrayList<DealTO> getDeals(int userId, int roleId, int restId)
			throws ApplicationException {
		ArrayList<DealTO> dealsInfo = null;
		try {
			ArrayList<RestaurantDeal> deals = getLocationDAO().searchDeals(userId, roleId, restId);
			dealsInfo = constructDealsInfo(deals);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealsInfo;
	}
	/*
	 *  Get Restaurant Deals for custom create deals or user create deals  
	 *  
	 *  
	 */
	public ArrayList<DealTO> getDeals(int userId, int roleId, int restId, String dealType)
			throws ApplicationException {
		ArrayList<DealTO> dealsInfo = null;
		try {
			ArrayList<RestaurantDeal> deals = getLocationDAO().searchDeals(userId, roleId, restId,
                    dealType);
			dealsInfo = constructDealsInfo(deals);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealsInfo;
	}
	/*
	 *  Get Restaurant Deals for Particular locations 
	 *  
	 *  
	 */
	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId, int locationId)
			throws ApplicationException {
		ArrayList<DealTO> dealsInfo = null;
		try {
			ArrayList<RestaurantDeal> deals = getLocationDAO().searchDealsForLocation(userId, roleId,
                    restId, locationId);
			dealsInfo = constructDealsInfo(deals);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealsInfo;
	}
	/*
	 *  Get Restaurant Deals for Particular locations for custom deals 
	 *  
	 *  
	 */
	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType) throws ApplicationException {
		ArrayList<DealTO> dealsInfo = null;
		try {
			ArrayList<RestaurantDeal> deals = getLocationDAO().searchDealsForLocation(userId, roleId,
                    restId, locationId, dealType);
			dealsInfo = constructDealsInfo(deals);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealsInfo;
	}
	/* count for deals for pagination and using for pending deals for roles 1,5,6 */
	public Long countDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType) throws ApplicationException {
		Long l;
		try {
			l = getLocationDAO().countSearchDealsForLocation(userId, roleId,
                    restId, locationId, dealType);
			
		} catch (ApplicationException e) {
			throw e;
		}
		return l;
	}
	/* count for deals for pagination and using for pending deals for roles 1,5,6 */
	public Long countDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType, String locname) throws ApplicationException {
		Long l;
		try {
			l = getLocationDAO().countSearchDealsForLocation(userId, roleId,
                    restId, locationId, dealType, locname);
			
		} catch (ApplicationException e) {
			throw e;
		}
		return l;
	}
	/* same as above but used for pagination */
	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType, int currentPage) throws ApplicationException {
		ArrayList<DealTO> dealsInfo = null;
		try {
			ArrayList<RestaurantDeal> deals = getLocationDAO().searchDealsForLocation(userId, roleId,
                    restId, locationId, dealType, currentPage);
			dealsInfo = constructDealsInfo(deals);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealsInfo;
	}
	
	/* same as above but used for pagination  and search */
	public ArrayList<DealTO> getDealsForLocation(int userId, int roleId, int restId,
			int locationId, String dealType, int currentPage, String locname) throws ApplicationException {
		ArrayList<DealTO> dealsInfo = null;
		try {
			ArrayList<RestaurantDeal> deals = getLocationDAO().searchDealsForLocation(userId, roleId,
                    restId, locationId, dealType, currentPage, locname);
			dealsInfo = constructDealsInfo(deals);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealsInfo;
	}
	/*
	 *  ConstructDeals  Restaurant Deals 
	 *  
	 *  
	 */
	private ArrayList<DealTO> constructDealsInfo(ArrayList<RestaurantDeal> deals) {
		ArrayList<DealTO> dealsInfo = new ArrayList<DealTO>();
		for (RestaurantDeal deal : deals) {
			DealTO dealTO = new DealTO();
			dealTO.setDealTemplateId(deal.getDealTemplateId());
			dealTO.setDealTemplateName(deal.getDealTemplateName());
			dealTO.setAvailableWeekDays(deal.getAvailableWeekDays());
			dealTO.setAvailableDealsQty(deal.getAvailableDealsQty());
			dealTO.setUsedDealsQty(deal.getUsedDealsQty());

			int remainingDeals = 0;

			if (deal.getAvailableDealsQty() != null && deal.getUsedDealsQty() != null
					&& deal.getUsedDealsQty() <= deal.getAvailableDealsQty()) {
				remainingDeals = deal.getAvailableDealsQty() - deal.getUsedDealsQty();
			}
			dealTO.setRemainingDeals(remainingDeals);
			dealTO.setLocationRestName(deal.getRestaurantLocation().getRestaurant()
					.getBusinessName());
			dealTO.setLocationName((String) (deal.getRestaurantLocation()).getLocationRestName());
			dealTO.setCity(deal.getRestaurantLocation().getCityId());
			dealTO.setAvailableStartTime(DateConverterUtility.toMeridian(deal
					.getAvailableStartTime()));
			dealTO.setAvailableEndTime(DateConverterUtility.toMeridian(deal.getAvailableEndTime()));
			dealTO.setDealTemplateRestrictions(deal.getDealTemplateRestrictions());
			dealTO.setDealTemplateDescription(deal.getDealTemplateDescription());
			dealTO.setIsRecurring(deal.getIsRecurring());
			dealTO.setStartDate(DateConverterUtility.convertDBTimeStampToUiDate(deal
					.getRestDealStartDate()));
			dealTO.setDealEndDate(DateConverterUtility.convertDBTimeStampToUiDate(deal
					.getRestDealEndDate()));
			dealTO.setRestDealPublishStatus(deal.getRestDealPublishStatus());
			dealTO.setRestDealImagePath(deal.getRestDealImagePath());
			dealTO.setIsActive(deal.getIsActive());
			dealsInfo.add(dealTO);
		}
		return dealsInfo;
	}
	/*
	 *Get particular locations by restaurant  
	 *  
	 *  
	 */
	public ArrayList<LocationTO> getLocationsByRestaurantId(int restId) throws ApplicationException {
		ArrayList<LocationTO> locations = null;
		try {
			locations = getLocationDAO().getRestaurantsById(restId);
		} catch (ApplicationException e) {
			throw e;
		}
		return locations;
	}
	/*
	 *Get Deal by particular deal id  
	 *  
	 *  
	 */
	public DealTO getDealByDealId(int dealId) throws ApplicationException {
		DealTO dealInfo = null;
		try {
			RestaurantDeal deal = getLocationDAO().getDealByDealId(dealId);
			dealInfo = constructDealTO(deal);
			dealInfo.setDealTemplateId(dealId);
		} catch (ApplicationException e) {
			throw e;
		}
		return dealInfo;
	}
	/*
	 *Construct Restaurant Deals  
	 *  
	 *  
	 */
	private DealTO constructDealTO(RestaurantDeal deal) {
		RestaurantLocation location = deal.getRestaurantLocation();
		DealTO dealInfo = new DealTO();
		if (location != null) {
			dealInfo.setRestLocationId(location.getRestLocationId());
			dealInfo.setLocationName(location.getLocationRestName());
			if(location.getRestaurant()!=null)
		 dealInfo.setLocationRestName(location.getRestaurant().getBusinessName());
			dealInfo.setCity(location.getCityId());
		}
		dealInfo.setDealTemplateId(deal.getDealTemplateId());
		dealInfo.setDealTemplateName(deal.getDealTemplateName());
		dealInfo.setDealTemplateDescription(deal.getDealTemplateDescription());
		dealInfo.setDealTemplateRestrictions(deal.getDealTemplateRestrictions());
		dealInfo.setAvailableStartTime(deal.getAvailableStartTime());
		dealInfo.setAvailableEndTime(deal.getAvailableEndTime());
		dealInfo.setIsRecurring(deal.getIsRecurring());
		dealInfo.setRestDealImagePath(deal.getRestDealImagePath());
		dealInfo.setAvailableDealsQty(deal.getAvailableDealsQty());
		dealInfo.setUsedDealsQty(deal.getUsedDealsQty());
		dealInfo.setRewardPoints(deal.getRewardPoints());
		dealInfo.setRestDealPublishStatus(deal.getRestDealPublishStatus());
		dealInfo.setDefaultCreditValue(deal.getDefaultCreditValue());
		dealInfo.setCustomDeal(deal.getCustomDeal());
		dealInfo.setIsActive(deal.getIsActive());
		dealInfo.setStartDate(DateConverterUtility.convertDBTimeStampToUiDate(deal
				.getRestDealStartDate()));
		dealInfo.setDealEndDate(DateConverterUtility.convertDBTimeStampToUiDate(deal
				.getRestDealEndDate()));
		if(deal.getRestDealPublishedDate() != null ) 
		dealInfo.setRestDealPublishedDate(deal.getRestDealPublishedDate().toString());
		if(deal.getRestDealCreateDate() != null ) 
		dealInfo.setRestDealCreateDate(deal.getRestDealCreateDate().toString());
		String weekDays = deal.getAvailableWeekDays();
		if (null != weekDays && weekDays != "") {
			if (weekDays.indexOf("2") != -1) {
				dealInfo.setMonday(1);
			}
			if (weekDays.indexOf("3") != -1) {
				dealInfo.setTuesday(1);
			}
			if (weekDays.indexOf("4") != -1) {
				dealInfo.setWednesday(1);
			}
			if (weekDays.indexOf("5") != -1) {
				dealInfo.setThursday(1);
			}
			if (weekDays.indexOf("6") != -1) {
				dealInfo.setFriday(1);
			}
			if (weekDays.indexOf("7") != -1) {
				dealInfo.setStaturday(1);
			}
			if (weekDays.indexOf("1") != -1) {
				dealInfo.setSunday(1);
			}
		}
		return dealInfo;
	}
/*
 * 
 * Update restaurant Deal
 * 
 */
	public void updateDeal(DealTO dealTO) throws ApplicationException {
		try {
			RestaurantDeal deal = constructDeal(dealTO);
			getLocationDAO().updateDeal(deal);
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * Change the deal Status to publish
	 * 
	 */
	public void publishDeal(int dealId) throws ApplicationException {
		try {
			
			
			DealTO dealInfo = new DealTO();
			if (dealId != 0)
			{
			dealInfo = getDealByDealId(dealId);
			
			String validationEmailContent = null;
		 
				validationEmailContent = TangotabConstants.PUBLISH_DEAL_EMAIL.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealInfo.getLocationRestName()).
				replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME, dealInfo.getLocationName())
						.replace(TangotabConstants.DEAL_START_DATE, dealInfo.getStartDate().toString())
						.replace(TangotabConstants.DEAL_END_DATE, dealInfo.getDealEndDate().toString())
				.replace(TangotabConstants.DEAL_NAME, dealInfo.getDealTemplateName())
				.replace(TangotabConstants.DEAL_DESCRIPTION, dealInfo.getDealTemplateDescription())
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_REFERAL_DEAL, dealInfo.getDealTemplateId().toString());
				TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, null,
						TangotabConstants.TANGO_TAB_AUTO_DEAL,
						TangotabConstants.PUBLISH_DEAL_EMAIL_HEADER, validationEmailContent);
			}
			getLocationDAO().publishDeal(dealId, 1);
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * Change the deal Status to un publish
	 * 
	 */
	public void unpublishDeal(int dealId) throws ApplicationException {
		try {
			getLocationDAO().publishDeal(dealId, 0);
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * Get Location Details 
	 * 
	 */
	public LocationTO fetchLocationByLocationId(int locationId) throws ApplicationException {
		LocationTO locationTO = null;
		try {
			RestaurantLocation location = getLocationDAO().fetchLocationByLocationId(locationId);
			locationTO = constructLocationTO(location);
		} catch (ApplicationException e) {
			throw e;
		}
		return locationTO;
	}
	/*
	 * 
	 * Construct Location Details
	 * 
	 */
	private LocationTO constructLocationTO(RestaurantLocation location) {
		LocationTO locationTO = new LocationTO();
		RestaurantTO restaurantTO = new RestaurantTO();
		try {
			BeanUtils.copyProperties(locationTO, location.getUser());
			BeanUtils.copyProperties(locationTO, location);
			locationTO.setPreferCityId(location.getCity().getCityId());
			locationTO.setRestaurantId(location.getRestaurant().getRestaurantId());
			BeanUtils.copyProperties(restaurantTO, location.getRestaurant());
			BeanUtils.copyProperties(restaurantTO, location.getRestaurant().getUser());
			locationTO.setRestaurantTO(restaurantTO);
			if(location.getUser().getEmailId().equals(location.getRestaurant().getUser().getEmailId()))
				locationTO.setHostAsManager("Yes");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		locationTO.setPreferencesList(getPreferences(location));
		locationTO.setDiningStylePreferences(getDiningPreferences(location));
		/* set emails ids of pojo in to array */
		String alternateEmailIds[] = {};
		String emailArray[]= {};
		String nameArray[] = {};
		if(StringUtils.isNotEmpty(location.getAlternateEmailIds())){
			 alternateEmailIds = location.getAlternateEmailIds().split(",");
			 emailArray = new String[alternateEmailIds.length];
			 nameArray = new String[alternateEmailIds.length];
		}
		if(alternateEmailIds.length > 0){
			for(int i = 0; i< alternateEmailIds.length; i++){
				String local[] = alternateEmailIds[i].split(":");
				if(local != null && local.length == 1)
					emailArray[i] = local[0];
				else{
				nameArray[i] = local[0];
				emailArray[i] = local[1];
				}
			}	
			locationTO.setEmailIdArray(emailArray);
			locationTO.setNameArray(nameArray);
		}
			   
		return locationTO;
	}
	/*
	 * 
	 * Get Dining Preferences
	 * 
	 */
	private int[] getDiningPreferences(RestaurantLocation location) {
		int[] preferencesList = null;
		Set<RestaurantDinnigPreferences> preferences = location.getDiningPreferences();
		if (preferences != null && preferences.size() > 0) {
			preferencesList = new int[preferences.size()];
			Iterator<RestaurantDinnigPreferences> iterator = preferences.iterator();
			for (int i = 0; iterator.hasNext(); i++) {
				preferencesList[i] = iterator.next().getCuisineTypeId().getDiningStyleId();
			}
		}
		return preferencesList;
	}
	/*
	 * 
	 * Get Location Preferences
	 * 
	 */
	private int[] getPreferences(RestaurantLocation location) {
		int[] preferencesList = null;
		Set<RestaurantLocationPreference> preferences = location.getLocationPreferences();
		if (preferences != null && preferences.size() > 0) {
			preferencesList = new int[preferences.size()];
			Iterator<RestaurantLocationPreference> iterator = preferences.iterator();
			for (int i = 0; iterator.hasNext(); i++) {
				preferencesList[i] = iterator.next().getCuisineTypeId().getCuisineTypeId();
			}
		}
		return preferencesList;
	}
	/*
	 * 
	 * Get Consumer Reservations
	 * 
	 */
	public ArrayList<ConsumerReservationTO> getConsumerReservationsByDeal(int restaurantId)
			throws ApplicationException {

		ArrayList<ConsumerReservationTO> viewResTO = new ArrayList<ConsumerReservationTO>();
		ArrayList<ConsumerReservation> reservations = null;
		try {
			reservations = getLocationDAO().getConsumerReservationsByDeal(restaurantId);

			for (ConsumerReservation cr : reservations) {
				ConsumerReservationTO crTO = new ConsumerReservationTO();

				crTO.setConResId(cr.getConResId());
				crTO.setUser(cr.getUser());
				crTO.setRestaurantDeal(cr.getRestaurantDeal());
				crTO.setIsConsumerShownUp(cr.getIsConsumerShownUp());
				crTO.setReservedTimestamp(DateConverterUtility.convertDBTimeStampToUiDate(cr
						.getReservedTimestamp()));
				crTO.setBookedTimestamp(DateConverterUtility.convertDBTimeStampToUiDate(cr
						.getBookedTimestamp()));

				viewResTO.add(crTO);
			}

		} catch (ApplicationException e) {
			throw e;
		}
		return viewResTO;
	}
	/*
	 * 
	 * Get Consumer Reservations
	 * 
	 */
	public ArrayList<ConsumerReservationTO> getConsumerReservationsByDeal(int restaurantId,
			int locationId) throws ApplicationException {

		ArrayList<ConsumerReservationTO> viewResTO = new ArrayList<ConsumerReservationTO>();
		ArrayList<ConsumerReservation> reservations = null;
		try {
			reservations = getLocationDAO().getConsumerReservationsByDeal(restaurantId, locationId);

			for (ConsumerReservation cr : reservations) {
				ConsumerReservationTO crTO = new ConsumerReservationTO();

				crTO.setConResId(cr.getConResId());
				crTO.setUser(cr.getUser());
				crTO.setRestaurantDeal(cr.getRestaurantDeal());
				crTO.setIsConsumerShownUp(cr.getIsConsumerShownUp());
				crTO.setReservedTimestamp(DateConverterUtility.convertDBTimeStampToUiDate(cr
						.getReservedTimestamp()));
				crTO.setBookedTimestamp(DateConverterUtility.convertDBTimeStampToUiDate(cr
						.getBookedTimestamp()));

				viewResTO.add(crTO);
			}

		} catch (ApplicationException e) {
			throw e;
		}
		return viewResTO;
	}
	/*
	 * 
	 * Get Custom Deal Status
	 * 
	 */
	public boolean setCustomDealStatus(int dealID, int isActive) throws ApplicationException {
		boolean status = false;
		try {
			status = getLocationDAO().setCustomDealStatus(dealID, isActive);

		} catch (ApplicationException e) {
			throw e;
		}
		return status;
	}

	/*
	 * 
	 * Get All locations Data
	 * 
	 */
	public ArrayList<Restaurant> getAllLocations() throws ApplicationException {
		try {
			return getLocationDAO().getAllLocations();
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * Set Location Status
	 * 
	 */
	public boolean setLocationStatus(int locationId, Short status) throws ApplicationException {
		try {

			return getLocationDAO().setLocationStatus(locationId, status);
		} catch (ApplicationException e) {
			throw e;
		}

	}
	/*
	 * 
	 * Get RestaurantLocation  by restaurant 
	 * 
	 */
	public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException {
		try {
            ArrayList<RestaurantLocation> restaurantLocations = getLocationDAO().getRestaurantLocations(restaurantId);
            for (RestaurantLocation restaurantLocation : restaurantLocations) {
                City city = restaurantLocation.getCity();
                // print something if not compiler might remove unused variables
                logger.debug(city.getCityName());
            }
            return restaurantLocations;
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * Save location from admin 
	 * 
	 */
	public void saveAdminLocation(LocationTO locationTO) throws ApplicationException {

		RestaurantLocation location = constructLocation(locationTO, "");
		String dealMgrEmailId = locationTO.getEmailId();
		String dealMgrName = locationTO.getFirstname();
		String password = new String();
		String validationEmailContent = new String();
		int flag = 1;
		if (location.getUser()!=null && location.getUser().getUserId() < 1) {
			location.getUser().setUserId(null);
			flag = 0;
		}
		location.getUser().setIsActive((short) 1);
		if (flag == 0 ) {
			password = location.getUser().getPassword();
			location.getUser().setPassword(TangoTabPasswordEncrypt.getPasswordEncrypt(password));
		}else if (location.getUser().getPassword() != null)
			password = TangoTabPasswordEncrypt.getPasswordDecrypt(location.getUser().getPassword());
		try {
			getLocationDAO().deleteLocationDiningPreferences(locationTO.getRestLocationId());
			getLocationDAO().deleteLocationDiningPreferences(locationTO.getRestLocationId());
			getLocationDAO().saveLocation(location);
			
				validationEmailContent = TangotabConstants.DEAL_MGR_WELCOME_EMAIL_CONTENT.replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealMgrName).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, dealMgrEmailId).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, password).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME, location.getLocationRestName());
				
			
				/*validationEmailContent = TangotabConstants.DEAL_MGR_ASSIGNED_EMAIL_CONTENT.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealMgrName);*/
			
			String cc = TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID;
			/* attach all alternate emails in cc 
			if( StringUtils.isNotEmpty(location.getAlternateEmailIds()) )
				cc = cc+","+location.getAlternateEmailIds().replace(":", ",");*/
			if(locationTO.getHostAsManager().equals("No"))
				TangoTabMailer.sendEmail(dealMgrEmailId, cc ,
					TangotabConstants.VALIDATION_EMAIL_HEADER, validationEmailContent);
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * update location from admin 
	 * 
	 */
	public void updateAdminLocation(LocationTO locationTO) throws ApplicationException {
		RestaurantLocation location = constructLocation(locationTO, "update");
		try {
			String dealMgrEmailId = locationTO.getEmailId();
			String dealMgrName = locationTO.getFirstname();
			String password = new String();
			String validationEmailContent = new String();
			Boolean newUser = false;
			int locationId = locationTO.getRestLocationId();
			locationTO.setIsActive((short) 1);
			getLocationDAO().deleteLocations(locationId);
			getLocationDAO().deleteLocationDiningPreferences(locationId);
 
			if (location.getUser().getUserId() == 0) {
				password = location.getUser().getPassword();
				location.getUser().setPassword(
						TangoTabPasswordEncrypt
								.getPasswordEncrypt(location.getUser().getPassword()));
				location.getUser().setUserId(null);
				newUser = true;
			 
			}else if (location.getUser().getPassword() != null)
				password = TangoTabPasswordEncrypt.getPasswordDecrypt(location.getUser().getPassword());
				
			getLocationDAO().updateLocation(location);
			
				validationEmailContent = TangotabConstants.DEAL_MGR_WELCOME_EMAIL_CONTENT.replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealMgrName).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, dealMgrEmailId).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, password).replace(
                        TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME, location.getLocationRestName());
				
				/*validationEmailContent = TangotabConstants.DEAL_MGR_ASSIGNED_EMAIL_CONTENT.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, dealMgrName);*/
			
			String cc = TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID;
			/* attach all alternate emails in cc 
			if( StringUtils.isNotEmpty(location.getAlternateEmailIds()) )
				cc = cc+","+location.getAlternateEmailIds().replace(":", ",");*/
			if(locationTO.getHostAsManager().equals("No"))
				TangoTabMailer.sendEmail(dealMgrEmailId, cc,
					TangotabConstants.VALIDATION_EMAIL_HEADER, validationEmailContent);
			
		} catch (ApplicationException e) {
			throw e;
		}
	}
	/*
	 * 
	 * Get No of locations of restaurant 
	 * 
	 */
	public int getNoOfLocations(Integer restId) throws ApplicationException {
		int nooflocs = 0;
		try {
			nooflocs = getLocationDAO().getNoOfLocations(restId);
		} catch (ApplicationException e) {
			throw e;
		}
		return nooflocs;
	}

    @Override
    public DealSummaryTO getDealSummary(Integer rid) throws ApplicationException {
        return getLocationDAO().getDealSummary(rid);
    }
}
