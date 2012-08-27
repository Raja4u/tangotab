package com.tangotab.businessImpl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import net.authorize.aim.Result;
import net.authorize.aim.Transaction;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import AuthNet.Rebill.CreateCustomerProfileTransactionResponseType;
import AuthNet.Rebill.CustomerPaymentProfileMaskedType;
import AuthNet.Rebill.GetCustomerPaymentProfileResponseType;

import com.tangotab.TO.BillingCcTO;
import com.tangotab.TO.BookDealTO;
import com.tangotab.TO.CharityTO;
import com.tangotab.TO.CityTO;
import com.tangotab.TO.ConsumerReservationTO;
import com.tangotab.TO.ContactTO;
import com.tangotab.TO.DateTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.EventsTO;
import com.tangotab.TO.LandingTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.OfferDetailsTO;
import com.tangotab.TO.PublishDealTO;
import com.tangotab.TO.QueryTO;
import com.tangotab.TO.ReportTO;
import com.tangotab.TO.RestaurantTO;
import com.tangotab.TO.RevenueReportTO;
import com.tangotab.TO.SalesManagerTO;
import com.tangotab.TO.SearchTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.SuggestRestTO;
import com.tangotab.TO.SupportTO;
import com.tangotab.TO.UserTO;
import com.tangotab.TO.WeekDate;
import com.tangotab.business.CommonBO;
import com.tangotab.business.ConfigBO;
import com.tangotab.business.TransactionBO;
import com.tangotab.business.UserBO;
import com.tangotab.creditcard.cim.CreateProfiles;
import com.tangotab.creditcard.cim.CreateTransaction;
import com.tangotab.creditcard.cim.GetPaymentProfiles;
import com.tangotab.dao.BillingTypeDAO;
import com.tangotab.dao.UserDAO;
import com.tangotab.dao.pojo.AmbReferences;
import com.tangotab.dao.pojo.Ambassador;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.dao.pojo.CharityDetails;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.dao.pojo.ConsumerEvent;
import com.tangotab.dao.pojo.ConsumerPreferCity;
import com.tangotab.dao.pojo.ConsumerPreference;
import com.tangotab.dao.pojo.ConsumerReferral;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.Country;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.ExternalReferral;
import com.tangotab.dao.pojo.HomeSignUp;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantCC;
import com.tangotab.dao.pojo.RestaurantCcProfile;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.RestaurantDealHistory;
import com.tangotab.dao.pojo.RestaurantDinnigPreferences;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantLocationPreference;
import com.tangotab.dao.pojo.RestaurantPaymentProfile;
import com.tangotab.dao.pojo.RestaurantTransaction;
import com.tangotab.dao.pojo.Role;
import com.tangotab.dao.pojo.SalesInfo;
import com.tangotab.dao.pojo.SalesManagerInfo;
import com.tangotab.dao.pojo.SalesMgrCities;
import com.tangotab.dao.pojo.SalesRepZipcodes;
import com.tangotab.dao.pojo.SalesRepresentInfo;
import com.tangotab.dao.pojo.State;
import com.tangotab.dao.pojo.Support;
import com.tangotab.dao.pojo.User;
import com.tangotab.dao.pojo.UserValidationCode;
import com.tangotab.dao.pojo.ZipCode;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.CreditCardDebit;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangoTabMailer;
import com.tangotab.util.TangoTabPasswordEncrypt;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CreditCardInfo;

@Service("com.tangotab.business.UserBO")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UserBOImpl implements UserBO {
    public static Logger log = LoggerFactory.getLogger(UserBOImpl.class);

    String bccEmails = null;

	@Autowired
    protected UserDAO userDao;

    @Autowired
    protected BillingTypeDAO billingTypeDAO;

	/* This method will retrieve multiple profiles for the emailId and password from login page */
	@SuppressWarnings("unchecked")
	public ArrayList<UserTO> getProfiles(String emailId, String password)
			throws ApplicationException {
		ArrayList<UserTO> tangotabUsers = new ArrayList<UserTO>();
		try {

			ArrayList<User> users = new ArrayList<User>();

			ArrayList<User> userRolePass = userDao.getPassword(emailId.trim());

			int i = 0;

			for (User userRolePasswords : userRolePass) {

				if (password.equals(TangoTabPasswordEncrypt.getPasswordDecrypt(userRolePasswords
						.getPassword()))) {
					User userProfiles = userDao.getUser(emailId, userRolePasswords.getPassword(),
							userRolePasswords.getRoleId());
					users.add(userProfiles);
					i++;
				}
			}
			if (i == 0) {
				return null;
			}

			UserTO userInfo = null;
			for (User user : users) {

				// only active profile added to multiple profiles
				if (null != user) {
					userInfo = new UserTO();
					try {
						if (user.getUserCreateDate() == null)
							user.setUserCreateDate(new java.sql.Timestamp(new java.util.Date()
									.getTime()));
						BeanUtils.copyProperties(userInfo, user);
						BeanUtils.copyProperties(userInfo, user.getRole());
						if(user.getConsumerEvent()!=null && user.getConsumerEvent().size() >0)
						{
							
						}
						int userRole = userInfo.getRoleId();
						if (userRole == TangotabConstants.CONSUMER_ROLE) {
							userInfo.setPreferencesList(getPreferences(user));
							/*if(user.getConsumerEvent().size()>0){
								Iterator<ConsumerEvent> iter = user.getConsumerEvent().iterator();
								userInfo.setEventId(iter.next().getEvents().getEventId());
							}*/
						} else if (userRole == TangotabConstants.RESTAURANT_OWNER) {
							BeanUtils.copyProperties(userInfo, user.getRestaurent());
									String alternateEmailIds[] = {};
							String emailArray[]= {};
							String nameArray[] = {};
							if(StringUtils.isNotEmpty(user.getRestaurent().getAlternateHosts())){
								 alternateEmailIds = user.getRestaurent().getAlternateHosts().split(",");
								 emailArray = new String[5];
								 nameArray = new String[5];
							}
							if(alternateEmailIds.length > 0){
								for(int l = 0; l< alternateEmailIds.length; l++){
									String local[] = alternateEmailIds[l].split(":");
									if(local != null && local.length == 1)
										emailArray[l] = local[0];
									else{
									nameArray[l] = local[0];
									emailArray[l] = local[1];
									}
								}	
								userInfo.setEmailIdArray(emailArray);
								userInfo.setNameArray(nameArray);
						} 
						}else if (userRole == TangotabConstants.RESTAURANT_STORE_MANAGER) {
							Iterator it = user.getRestaurantLocations().iterator();
							while (it.hasNext()) {
								userInfo.setRestaurantLocation((RestaurantLocation) it.next());
							}
						}
						if (users.size() == 1 && user.getRole().getRoleId() != 6)
							tangotabUsers.add(userInfo);
						else if (users.size() == 1 && user.getRole().getRoleId() == 6
								&& user.getRestaurantLocations() != null
								&& !user.getRestaurantLocations().isEmpty())
							tangotabUsers.add(userInfo);
						else if (users.size() > 1 && user.getIsActive() == 1
								&& user.getRole().getRoleId() != 6)
						{
							if(user.getRole().getRoleId() == 5 && user.getRestaurent().getIsActivated()==TangotabConstants.ACTIVE)
							{
							tangotabUsers.add(userInfo);
							}else if(user.getRole().getRoleId() != 5)
								tangotabUsers.add(userInfo);
						}
						
						else if (users.size() > 1 && user.getIsActive() == 1
								&& user.getRole().getRoleId() == 6
								&& user.getRestaurantLocations() != null
								&& !user.getRestaurantLocations().isEmpty())
						{
							
							Iterator it = user.getRestaurantLocations().iterator();
							  
								RestaurantLocation restaurantLocation= (RestaurantLocation) it.next() ;
							 
							if(user.getRole().getRoleId() == 6 && restaurantLocation.getRestaurant().getIsActivated()==TangotabConstants.ACTIVE)
							{
								tangotabUsers.add(userInfo);
							}
						 	
						} 
						

					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
			if (tangotabUsers.size() == 0 && userInfo != null) {
				if (users.size() == 1 && userInfo.getRole().getRoleId() == 6
						&& userInfo.getRestaurantLocations() != null
						&& !userInfo.getRestaurantLocations().isEmpty())
					tangotabUsers.add(userInfo);

			}

		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return tangotabUsers;
	}

	/* Retrieving a user with a roleId specific */
	@SuppressWarnings("unchecked")
	public UserTO getTangoTabUser(String emailId, String password, int roleId)
			throws ApplicationException {
		UserTO tangotabUser = new UserTO();
		try {
			String epassword = userDao.getPassword(emailId.trim(), roleId);
			if (!password.equals(TangoTabPasswordEncrypt.getPasswordDecrypt(epassword))) {
				return null;
			}

			User user = userDao.getUser(emailId, epassword, roleId);

			if (null != user) {

				try {
					if (user.getUserCreateDate() == null)
						user.setUserCreateDate(new java.sql.Timestamp(new java.util.Date()
								.getTime()));
					BeanUtils.copyProperties(tangotabUser, user);
					BeanUtils.copyProperties(tangotabUser, user.getRole());
					int userRole = tangotabUser.getRoleId();
					if (userRole == TangotabConstants.CONSUMER_ROLE) {
						tangotabUser.setPreferencesList(getPreferences(user));
						/*if(user.getConsumerEvent().size()>0){
							Iterator<ConsumerEvent> iter = user.getConsumerEvent().iterator();
							tangotabUser.setEventId(iter.next().getEvents().getEventId());
						}*/
					} else if (userRole == TangotabConstants.RESTAURANT_OWNER) {
						BeanUtils.copyProperties(tangotabUser, user.getRestaurent());
					} else if (userRole == TangotabConstants.RESTAURANT_STORE_MANAGER) {
						Iterator it = user.getRestaurantLocations().iterator();
						while (it.hasNext()) {
							tangotabUser.setRestaurantLocation((RestaurantLocation) it.next());
						}
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return tangotabUser;
	}

	/* Retrieving cuisine type Id from set of consumer preferences */
	private int[] getPreferences(User user) {
		int[] preferencesList = null;
		Set<ConsumerPreference> preferences = user.getConsumerPreferences();
		if (preferences != null && preferences.size() > 0) {
			preferencesList = new int[preferences.size()];
			Iterator<ConsumerPreference> iterator = preferences.iterator();
			for (int i = 0; iterator.hasNext(); i++) {
				preferencesList[i] = iterator.next().getPreferenceId();
			}
		}
		return preferencesList;
	}

	/* Creating a new Restaurant(HOST) */
	public int saveRestaurantClient(User client) throws ApplicationException {
		try {
			constructRestaurantClient(client);
			Restaurant restaurant = client.getRestaurent();
			restaurant.setRestTypeId(null);
			restaurant.setBillingMethodId(null);
			restaurant.setBillingTypeId(null);
			client.setIsActive((short) 1);
			client.setRestaurent(restaurant);
			String password = client.getPassword();
			client.setUserCreateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			client.setPassword(TangoTabPasswordEncrypt.getPasswordEncrypt(client.getPassword()));
			int consumerId = userDao.saveRestaurant(client);
			client.setUserId(consumerId);

			String validationEmailContent = TangotabConstants.CONFIRMATION_EMAIL_CONTENT.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, client.getEmailId())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME,
							client.getFirstname()).replace(
						TangotabConstants.CONTACT_RESTAURANT_NAME, client.getBusinessName())
							.replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, password);
			TangoTabMailer.sendEmail(client.getEmailId(), TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,
					TangotabConstants.TANGO_TAB_AUTO_HOST, 
					TangotabConstants.CONFIRMATION_EMAIL_HEADER, validationEmailContent);
			return consumerId;
		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* Creating a Restaurant(HOST) by Administrator */
	public void saveRestaurantClient(User client, String mail) throws ApplicationException {
		try {
			constructRestaurantClient(client);
			client.setPassword(TangoTabPasswordEncrypt.getPasswordEncrypt(client.getPassword()));
			client.setUserCreateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			client.setIsActive((short) 1);
			int consumerId = userDao.saveRestaurant(client);
			client.setUserId(consumerId);
  		if (consumerId > 0 ) {
				sendClientEmail(client, "code");
			}
		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* Validation Email sent to HOST when the profile is created by Administrator */
	private void sendClientEmail(User client, String code) {
		String clientEmailContent = TangotabConstants.ADMIN_CLIENT_VALIDATION_EMAIL_CONTENT
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, client.getFirstname())
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_CLIENT_BUSINESS_NAME,
						client.getBusinessName()).replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_CLIENT_MGR_NAME,
						client.getFirstname()).replace(
					    TangotabConstants.CONTACT_RESTAURANT_NAME, client.getBusinessName())
						.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, client.getEmailId())
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD,
						TangoTabPasswordEncrypt.getPasswordDecrypt(client.getPassword()));

		TangoTabMailer.sendEmail(client.getEmailId(), TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,
				TangotabConstants.TANGO_TAB_AUTO_HOST,
				TangotabConstants.CLIENT_REGISTRATION_HEADER, clientEmailContent);
	}

	/* Validation Emails sent when the profiles created by themselves or through Website */
	private void sendValidationEmail(User user, String validationCode, String usertype) {

		if (usertype.equals("co")) {
			if(user.getConsumerPreferCity()!=null )
			{
			String consumerValidationContent = TangotabConstants.CONSUMER_VALIDATION_EMAIL_CONTENT
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, user.getFirstname())

					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_VALIDATION_CODE,
							validationCode).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID,
							user.getEmailId()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_USER_TYPE, usertype);
			TangoTabMailer.sendEmail(user.getEmailId(), null,
					TangotabConstants.CONSUMER_VALIDATION_EMAIL_HEADER, consumerValidationContent);
			}else 
			{
				String consumerValidationContent = TangotabConstants.FACE_CONSUMER_VALIDATION_EMAIL_CONTENT
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, user.getFirstname())

				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_VALIDATION_CODE,
						validationCode).replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID,
						user.getEmailId()).replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_USER_TYPE, usertype)
				.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, user.getEmailId())
						.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, TangoTabPasswordEncrypt.getPasswordDecrypt(user.getPassword()));
						
				TangoTabMailer.sendEmail(user.getEmailId(), null,
						TangotabConstants.CONSUMER_VALIDATION_EMAIL_HEADER, consumerValidationContent);
			}
	
			
		} else if (usertype.equals("cl")) {
			String clientValidationContent = TangotabConstants.CLIENT_VALIDATION_EMAIL_CONTENT
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, user.getFirstname())

					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_VALIDATION_CODE,
							validationCode).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID,
							user.getEmailId()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_USER_TYPE, usertype);

			TangoTabMailer.sendEmail(user.getEmailId(), null,
					TangotabConstants.CLIENT_VALIDATION_EMAIL_HEADER, clientValidationContent);

		}

	}

	/* Resends validation email for Guest */
	public boolean resendValidationEmail(User user, String toemail, String validationCode) {

		String usertype = "co";
		String consumerValidationContent = TangotabConstants.CONSUMER_VALIDATION_EMAIL_CONTENT
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, user.getFirstname())

				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_VALIDATION_CODE,
						validationCode).replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, user.getEmailId())
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_USER_TYPE, usertype);

		boolean status = TangoTabMailer.sendEmail(toemail, null,
				TangotabConstants.CONSUMER_VALIDATION_EMAIL_HEADER, consumerValidationContent);

		return status;
	}

	/* Creating a new Guest */
	public User saveConsumer(User consumer) throws ApplicationException {
		try {
			try{
				constructConsumer(consumer);
			}catch(Exception e){
				
			}
			consumer
					.setPassword(TangoTabPasswordEncrypt.getPasswordEncrypt(consumer.getPassword()));
		//	String validationCode = getValidationCode(consumer);
			consumer.setUserCreateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
			consumer.setIsActive((short)1);
						
			int consumerId = userDao.saveConsumer(consumer);
			if (consumerId > 0) {
				consumer.setUserId(consumerId);
				if (consumer.getRefferCode() != null && consumer.getRefferCode() != 0) {
					Ambassador ambassador = userDao.getAmbassadorbyReffCode(consumer
							.getRefferCode());
					if (ambassador != null) {
						AmbReferences ambReferences = new AmbReferences();
						ambReferences.setUserId(consumer.getUserId());
						ambReferences.setAid(ambassador.getAid());
						userDao.saveRefferal(ambReferences, consumer.getRefferCode());
					}

				}
				if(consumer.getLastname()==null)
				{
					consumer.setLastname("");
				}
			//	sendValidationEmail(consumer, validationCode, "co");
				String validationEmailContent = TangotabConstants.CONSUMER_CONFIRMATION_EMAIL_CONTENT
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, consumer.getFirstname()+" "+consumer.getLastname());

		TangoTabMailer.sendEmail(consumer.getEmailId(), null,
				TangotabConstants.USER_CONFIRMATION_EMAIL_HEADER,
				validationEmailContent);
			}
			return consumer;
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
	
		}
	}

	/* Constructing pojo to Transfer object */
	private void constructConsumer(User consumer) {
		int[] preferencesList = consumer.getPreferencesList();
		Set<ConsumerEvent> cevents = new HashSet<ConsumerEvent>();
		Set<ConsumerPreference> preferences = new HashSet<ConsumerPreference>();
		for (int i = 0;  preferencesList!= null && i < preferencesList.length; i++) {
			ConsumerPreference preference = new ConsumerPreference();
			preference.setPreferenceId(preferencesList[i]);
			preference.setUser(consumer);
			preferences.add(preference);
		}
		consumer.setConsumerPreferences(preferences);
		/* Assuming the guest has only one event, if in future one guest-multiple
		 * events, then pass events list as array.. */
		if( consumer.getEventId() > 0 ){
		int eventId = consumer.getEventId();
		for(int i = 0; i < 1; i++ ){
			ConsumerEvent coneve = new ConsumerEvent();
			Events event = new Events();
			try {
				event = userDao.getEventById(eventId);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			coneve.setUser(consumer);
			coneve.setEvents(event);
			cevents.add(coneve);
			}
		}
		consumer.setConsumerEvent(cevents);
		Role role = new Role();
		role.setRoleId(TangotabConstants.CONSUMER_ROLE);
		consumer.setRole(role);
		
		//set prefer city if user not created using with entered zip code set the nearest city
		if(consumer.getConsumerPreferCity()==null )
		{
			setConsumerCity(consumer);
		}
		
	}

	private void setConsumerCity(User consumer){
		/*
		 * For fetching the CountryNameCode from JSON object and set longitude
		 * and latitude
		 */
		try {
			double latitude = 0;
			double longitude = 0;
			String countryCode = null;
			String url = "";
			try {

				url = "http://maps.googleapis.com/maps/geo?q="
						+ consumer.getZipCode() + "&output=json&sensor=true";
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
            try{
			if (StringUtils.isEmpty(countryCode) || countryCode == null) {

				url = "http://maps.googleapis.com/maps/geo?q="
						+ consumer.getZipCode() + "&output=csv&sensor=true";
			}
			else if (countryCode.equals("US")) {
				url = "http://maps.googleapis.com/maps/geo?q="
						+ consumer.getZipCode() + ",US&output=csv&sensor=true";
			}
			else if (countryCode.equals("CA")) {
				url = "http://maps.googleapis.com/maps/geo?q="
						+ consumer.getZipCode() + ",CA&output=csv&sensor=true";
			}else 
				url = "http://maps.googleapis.com/maps/geo?q="
					+ consumer.getZipCode() + "&output=csv&sensor=true";
			
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

					latitude = (Double.parseDouble(csv[2]));
					longitude = (Double.parseDouble(csv[3]));
				}
			}
            }catch(Exception e){
            	
            }
		 
		CommonBO commonBO=com.tangotab.businessImpl.BusinessFactory.getCommonBO();
		ArrayList<CityTO> arrayList=new ArrayList<CityTO>();
		arrayList=commonBO.getCities();

	 
					int cityIndex = -1;
					double minDistance = -1;
					for (CityTO cityTO : arrayList) {
			 				double locDistance = distance(latitude, longitude, cityTO
						.getLatitude(), cityTO.getLongitude(), 'M'); 
 			 				if(minDistance == -1){
								minDistance = locDistance;
								cityIndex=arrayList.indexOf(cityTO);
							}
							else{
								if (locDistance < minDistance){
									minDistance = locDistance;
									cityIndex=arrayList.indexOf(cityTO);
								}
							}
					}
					if(minDistance != -1 && cityIndex != -1){
						ConsumerPreferCity consumerPreferCity = new ConsumerPreferCity();
						consumerPreferCity.setUser(consumer);
						City city = new City();
						city.setCityId(arrayList.get(cityIndex).getCityId());
						consumerPreferCity.setCity(city);
						consumer.setConsumerPreferCity(consumerPreferCity);
					}
				 

			 
		} catch (Exception e) {
			e.printStackTrace();
		}

 

	}
	
	/* Transforms restaurant details to TransferObject */
	private void constructRestaurantClient(User client) {
		Restaurant restaurant = null;
		if (client.getRestaurent() == null) {
			restaurant = new Restaurant();
			client.setRestaurent(restaurant);
		} else {
			restaurant = client.getRestaurent();
		}
		try {
			BeanUtils.copyProperties(restaurant, client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		restaurant.setUser(client);
		if (restaurant.getBillingTypeId() == 0)
			restaurant.setBillingTypeId(1);
		if (restaurant.getBillingMethodId() == 0)
			restaurant.setBillingMethodId(1);
		if (restaurant.getIsActivated() == null)
			restaurant.setIsActivated(TangotabConstants.ACTIVE);
		if (restaurant.getIsAutoDebit() == null)
			restaurant.setIsAutoDebit(TangotabConstants.NON_AUTO_BEBIT);
		Role role = new Role();
		role.setRoleId(TangotabConstants.RESTAURANT_OWNER);
		client.setRole(role);
	}

	/* Updating the HOST details */
	public void updateClient(User client) throws ApplicationException {
		try {
			constructRestaurantClient(client);
			client.setIsActive(TangotabConstants.ACTIVE);
			userDao.updateRestaurant(client);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String getValidationCode(User consumer) {
		// TangoTab generateValidationCode
		String validationCode = TangoTabUtility.generateRandomCode();

		if (validationCode != null && validationCode.length() > 0) {
			// Constructing user validation code
			UserValidationCode userCode = new UserValidationCode();
			userCode.setUser(consumer);
			userCode.setValidationCode(validationCode);
			userCode.setGeneratedDate(new Timestamp(System.currentTimeMillis()));

			Set<UserValidationCode> userValidationCodes = new HashSet<UserValidationCode>();
			userValidationCodes.add(userCode);
			consumer.setUserValidationCodes(userValidationCodes);
		}
		return validationCode;
	}

	/*
	 * Generating Validation code after guest registration, but not using now
	NotU */
	/*
	private UserValidationCode generateValidationCode(User consumer) {
		String validationCode = TangoTabUtility.generateRandomCode();
		UserValidationCode userCode = new UserValidationCode();
		userCode.setUser(consumer);
		userCode.setValidationCode(validationCode);
		userCode.setGeneratedDate(new Timestamp(System.currentTimeMillis()));
		return userCode;
	}*/

	/* Updating GUEST details */
	public void updateConsumer(User consumer) throws ApplicationException {
		try {
			
			constructConsumer(consumer);
			consumer.setIsActive(TangotabConstants.ACTIVE);
			userDao.deleteConsumerPreferences(consumer.getUserId());
			userDao.deleteConsumerPreferCity(consumer.getUserId());
			userDao.deleteConsumerEvents(consumer.getUserId());
			userDao.updateConsumer(consumer);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/* Resets the password for the emailId specified for multiple roles, if exists. */
	public boolean forgotPassword(String emailId) throws ApplicationException {
		try {
			String currentPassword = "rat";
			User usr = new User();
			if (currentPassword != null && currentPassword.length() > 0) {
				// Send an email to user asking him to change the password for his remembrance.
				String newPassword = TangoTabUtility.generateRandomCode();
				userDao.resetPassword(emailId, TangoTabPasswordEncrypt
						.getPasswordEncrypt(newPassword));
				usr = userDao.getUserByEmailId(emailId);
				if (usr.getRole().getRoleId() == 4) {
					String name = userDao.getUserName(emailId);
					String forgetPasswordEmailContent = TangotabConstants.CONSUMER_FORGET_PASSWORD_EMAIL_CONTENT
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, name)
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD,
									newPassword);

					TangoTabMailer.sendEmail(emailId, null,
							"TangoTab - Password Change Notification", forgetPasswordEmailContent);
				} else if (usr.getRole().getRoleId() == 5) {
					String name = userDao.getUserName(emailId);

					String forgetPasswordEmailContent = TangotabConstants.FORGET_PASSWORD_EMAIL_CONTENT
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, name)
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD,
									newPassword);

					TangoTabMailer.sendEmail(emailId, null,
							TangotabConstants.FORGET_PASSWORD_EMAIL_HEADER,
							forgetPasswordEmailContent);
				} else {
					String name = userDao.getUserName(emailId);

					String forgetPasswordEmailContent = TangotabConstants.FORGET_PASSWORD_EMAIL_CONTENT
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, name)
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD,
									newPassword);

					TangoTabMailer.sendEmail(emailId, null,
							TangotabConstants.FORGET_PASSWORD_EMAIL_HEADER,
							forgetPasswordEmailContent);
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Returns the details like for how many friends the guest forwarded the deals in past */
	public ArrayList<ConsumerReferral> getReferrals(User user) throws ApplicationException {
		try {
			user = userDao.getUser(user.getEmailId(), user.getPassword(),
					TangotabConstants.CONSUMER_ROLE);
			return new ArrayList<ConsumerReferral>(user.getConsumerReferrals());
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/* Returns how many deals he has reserved in past */
	@SuppressWarnings("unchecked")
	public ArrayList<ConsumerReservation> getConsumerReservations(User user)
			throws ApplicationException {
		try {
			user = userDao.getUser(user.getEmailId(), user.getPassword(),
					TangotabConstants.CONSUMER_ROLE);
			return new ArrayList<ConsumerReservation>(user.getConsumerReservations());
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/* After login the user resets his password according to his wish. */
	public boolean resetPassword(String emailId, String currentPassword, String newPassword)
			throws ApplicationException {
		try {
			String epassword = "";
			ArrayList<User> userRolePass = userDao.getPassword(emailId.trim());
			String bccmails = null;
            
			int i = 0;
			boolean status = false;
			for (User userRolePasswords : userRolePass) {
				/*
				 * Resets password only for the profiles whose passwords are same with the
				 * currentPassword
				 */
				if (currentPassword.equals(TangoTabPasswordEncrypt
						.getPasswordDecrypt(userRolePasswords.getPassword()))) {
					epassword = userRolePasswords.getPassword();

					status = userDao.resetPassword(emailId, epassword, TangoTabPasswordEncrypt
							.getPasswordEncrypt(newPassword));
					if (status)
						i++;
				}
			}
			if (i == 0) {
				return false;
			} else {
				status = true;
			}

			if (status) {
				String name = userDao.getUserName(emailId);
				// Send an email to user asking him to change the password
				String forgetPasswordEmailContent = TangotabConstants.PASSWORD_CHANGE_EMAIL_CONTENT
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, name);
						//.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD, newPassword);

				status = TangoTabMailer.sendEmail(emailId, null,
						TangotabConstants.PASSWORD_CHANGE_EMAIL_HEADER, forgetPasswordEmailContent);
				if (!status) {
					throw new ApplicationException("EMAIL001");
				}
			}
			return status;
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/* For sending mail to helpline and persons email id both */
	public boolean contactUsMail(ContactTO contact) throws ApplicationException {
		try {

			String contactUsEmailContent = TangotabConstants.CONTACT_US_EMAIL_CONTENT
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME,
							contact.getFirstName())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL,
							contact.getEmailId())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_PHONE, contact.getPhone())
					.replace(TangotabConstants.CONTACT_RESTAURANT_NAME, contact.getRestaurantName())
					.replace(TangotabConstants.CONTACT_RESTAURANT_CITY, contact.getRestaurantCity())
					.replace(TangotabConstants.CONTACT_TYPE_OF_INQUIRY, contact.getTypeOfEnquiry())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_COMMENTS,
							contact.getComments());

			boolean status = TangoTabMailer.sendEmail("help@tangotab.com", null,
					TangotabConstants.CONTACT_US_EMAIL_CONTENT_HEADER, contactUsEmailContent);

			String contactPersonMail = TangotabConstants.CONTACT_PERSON_MAIL.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, contact.getFirstName());

			status = TangoTabMailer.sendEmail(contact.getEmailId(), null,
					TangotabConstants.CONTACT_PERSON_MAIL_HEADER, contactPersonMail);

			if (status) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Send an email regarding any issues to helpline */
	private boolean supportUsMail(Support support, String role) throws ApplicationException {
		try {

			String supportUsEmailContent = TangotabConstants.SUPPORT_US_EMAIL_CONTENT.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL, support.getEmailId())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_ROLE, role).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_SUBJECT, support.getSubject())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_DESCRIPTION,
							support.getDescription());

			boolean status = TangoTabMailer.sendEmail("help@tangotab.com", null,
					TangotabConstants.SUPPORT_US_EMAIL_CONTENT_HEADER, supportUsEmailContent);
			String contactPersonMail = TangotabConstants.CONTACT_PERSON_MAIL.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, support.getEmailId());

			status = TangoTabMailer.sendEmail(support.getEmailId(), null,
					TangotabConstants.CONTACT_PERSON_MAIL_HEADER, contactPersonMail);
			if (status) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Validating the Guest */
	public boolean verifyValidationCode(String emailId, String password, String roleId,
			String validationCode) throws ApplicationException {
		try {
			String epassword = userDao.getPassword(emailId.trim(), Integer.parseInt(roleId));
			if (!password.equals(TangoTabPasswordEncrypt.getPasswordDecrypt(epassword))) {
				return false;
			}
			if(userDao.getUserStatus(emailId, Integer.parseInt(roleId))){
				
			
			if (userDao.verifyValidationCode(emailId, epassword, validationCode)) {
				// Deleting the validation code as the user is activated
				userDao.deleteValidationCode(emailId, epassword, validationCode);
				// Activating the user in the database.
				userDao.activateUser(emailId, Integer.parseInt(roleId));
				String username = userDao.getUserName(emailId);

				if (Integer.parseInt(roleId) == 4) {
					userDao.setUserConsumerStatus(emailId, (short) 2, 4);
					String validationEmailContent = TangotabConstants.CONSUMER_CONFIRMATION_EMAIL_CONTENT
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, username);

					TangoTabMailer.sendEmail(emailId, null,
							TangotabConstants.USER_CONFIRMATION_EMAIL_HEADER,
							validationEmailContent);
				} else if (Integer.parseInt(roleId) == 5) {
					String validationEmailContent = TangotabConstants.CONFIRMATION_EMAIL_CONTENT
					       	.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, emailId)
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, username)
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD,
									password);

					TangoTabMailer.sendEmail(emailId, null,
							TangotabConstants.CONFIRMATION_EMAIL_HEADER, validationEmailContent);
				}

				return true;
			}
			}else 
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Returns number of locations for the business name (HOST) */
	public int getNoOfEnteredLocations(int restaurantId) throws ApplicationException {
		int noOfenteredLocations = 0;
		try {
			noOfenteredLocations = userDao.getNoEnteredLocations(restaurantId);
		} catch (ApplicationException e) {
			throw e;
		}
		return noOfenteredLocations;
	}

	/* Returns published and active deals to display for the Guest */
	public ArrayList<DealTO> searchDeals(SearchTO searchCriteria) throws ApplicationException {
		ArrayList<DealTO> dealInfo = null;
		try {
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				String[] prices = StringUtils.split(searchCriteria.getPriceStartRate(), ",");
				searchCriteria.setStartPrice(Double.valueOf(prices[0]));
				searchCriteria.setEndPrice(Double.valueOf(prices[1]));
			}
			ArrayList<RestaurantDeal> deals = userDao.searchDeals(searchCriteria);
			if (deals != null)
				dealInfo = constructDealsFromSearchDeals(deals);
			for (DealTO dealTo : dealInfo) {
				if (dealTo.getUsedDealsQty() != null) {
					dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
							- dealTo.getUsedDealsQty());
				}
			}
		} catch (ApplicationException e) {
			throw e;
		}
		return dealInfo;
	}

	/* Returns published and active deals to display for the Guest */
	public ArrayList<DealTO> searchDeals(SearchTO searchCriteria,int currentPage) throws ApplicationException {
		ArrayList<DealTO> dealInfo = null;
		ArrayList<DealTO> dealInfo1 =null;
		try {
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				String[] prices = StringUtils.split(searchCriteria.getPriceStartRate(), ",");
				searchCriteria.setStartPrice(Double.valueOf(prices[0]));
				searchCriteria.setEndPrice(Double.valueOf(prices[1]));
			}
			/*
		 	ArrayList<RestaurantDeal> deals = userDao.searchDeals(searchCriteria, currentPage);
			if (deals != null)
				dealInfo = constructDealsFromSearchDeals(deals);
			for (DealTO dealTo : dealInfo) {
				if (dealTo.getUsedDealsQty() != null) {
					dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
							- dealTo.getUsedDealsQty());
				
				}
			} */
			dealInfo=userDao.searchDealsort(searchCriteria,currentPage);
			  dealInfo1 = new ArrayList<DealTO>();
			for (DealTO dealTo : dealInfo) {
				if (dealTo.getUsedDealsQty() != null) {
					dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
							- dealTo.getUsedDealsQty());
					dealTo.setDistance(Math.round(dealTo.getDistance()));
					dealTo.setDay(DateConverterUtility.sayDayName(dealTo.getDealStartDate()));
					dealTo.setStartDate(DateConverterUtility.convertDBTimeStampToUiDate(dealTo.getDealStartDate()));
					if(searchCriteria.getDealAvailDate()!=null)
					dealTo.setStartDate(DateConverterUtility.convertDBTimeStampToUiDate(searchCriteria.getDealAvailDate()));


					if(searchCriteria.getDealAvailDate()!=null)
					{
					 

				//		if(deal.getRestDealStartDate().before(searchCriteria.getDealAvailDate()))
						//deal.setRestDealStartDate(searchCriteria.getDealAvailDate());
					
					 
					}
					Calendar calendar = Calendar.getInstance();
				      calendar.setTime(dealTo.getRestDealEndDate());

				      dealTo.setRestDealEndDate(calendar.getTime());
				      calendar.setTime(dealTo.getRestDealEndDate());

				      dealTo.setRestDealEndDate(calendar.getTime());
					
				 
						      String[] s = dealTo.getAvailableWeekDays().split(",");
						      ArrayList<WeekDate> arrayList = new ArrayList<WeekDate>();
						    
						      if (s.length > 0)
						      {
						    	  TreeSet<Date> dateArrayList = new TreeSet<Date>();
						        Calendar s1 = Calendar.getInstance();
						   
						   /*     for (int i = 0; i < 7; i++)
						        {
						          if (searchCriteria.getDealAvailDate() != null)
						          {
						            s1.setTime(searchCriteria.getDealAvailDate());
						            if (i == 0)
						              s1.add(Calendar.DATE, 1);
						            else if (i == 1)
						              s1.add(Calendar.DATE, 2);
						            else if (i == 2)
						              s1.add(Calendar.DATE, 3);
						            else if (i == 3)
						              s1.add(Calendar.DATE, 4);
						            else if (i == 4)
							              s1.add(Calendar.DATE, 5);
							            else if (i == 5)
							              s1.add(Calendar.DATE, 6);
						            else if (i == 6)
						            	 s1.setTime(searchCriteria.getDealAvailDate());
						            	
						          }
						          else
						          {
						            s1.setTime(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()));
						       
						            if (i == 0)
					              s1.add(Calendar.DATE, 1);
						            else if (i == 1)
					              s1.add(Calendar.DATE, 2);
						            else if (i == 2)
					              s1.add(Calendar.DATE, 3);
						            else if (i == 3)
					              s1.add(Calendar.DATE, 4);
						            else if (i == 4)
						              s1.add(Calendar.DATE, 5);
						            else if (i == 5)
						              s1.add(Calendar.DATE, 6);
						            else if (i == 6)
						            s1.setTime(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()));
								       
							            
						            
						          }

						          if (i > 6)
						            continue;
						          if (dealTo.getAvailableWeekDays().indexOf(Integer.toString(s1.get(Calendar.DAY_OF_WEEK))) != -1) {
						            DateTO dateTO1 = DateConverterUtility.getDealDay(s1.getTime(), 
						            		dealTo.getAvailableWeekDays(), dealTo.getAvailableEndTime());

						            Date date = new Date();
						            date = DateConverterUtility.convertUiToServiceDate(dateTO1.getDealAvailableDate());
						           // if(so.add(date))
						            dateArrayList.add(date);
						          }

						        } */
						        /**
						         * 
						         * with out displaying the dates means after 6 days given by search date filter 
						         */
						        if (searchCriteria.getDealAvailDate() != null)
						          {
						            s1.setTime(searchCriteria.getDealAvailDate());
						          }else 
						          {
						        	  s1.setTime(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()));
								       
						          }
						        
						        if (dealTo.getAvailableWeekDays().indexOf(Integer.toString(s1.get(Calendar.DAY_OF_WEEK))) != -1) {
						            DateTO dateTO1 = DateConverterUtility.getDealDay(s1.getTime(), 
						            		dealTo.getAvailableWeekDays(), dealTo.getAvailableEndTime());

						            Date date = new Date();
						            date = DateConverterUtility.convertUiToServiceDate(dateTO1.getDealAvailableDate());
						           // if(so.add(date))
						            dateArrayList.add(date);
						        }
						     /*   Calendar startDate = Calendar.getInstance();
						        startDate.setTime(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()));
						        startDate.add(Calendar.HOUR, -48);
						        Calendar endDate = Calendar.getInstance();
						        endDate.setTime(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()));
						        endDate.add(Calendar.DATE, 8);
						        */ 
						        for (Date date : dateArrayList)
					            {
						        	Calendar start=Calendar.getInstance();
						        	start.setTime(date);
						          WeekDate weekDate = new WeekDate();
						      	if(searchCriteria.getDealAvailDate()!=null )
								
						          calendar.setTime(searchCriteria.getDealAvailDate());
						      	else 
						      		calendar.setTime(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()));
						          if (dateArrayList.size() > 0)
						          {
						          
						            //  calendar.setTime(date);
						              
						            
						            if (calendar.get(Calendar.DAY_OF_WEEK) == start.get(Calendar.DAY_OF_WEEK))
							          {
							            weekDate.setDayName("Ok");
							            for(WeekDate wd:arrayList)
							            {
							            	wd.setDayName("NO");
							            }
							          } else 
							          {
							        	  weekDate.setDayName("Yes");
							          }
							        	   weekDate.setDate(date);
								              weekDate.setAvailableDates(DateConverterUtility.convertDBTimeStampToUiDate(start.getTime()));
								              weekDate.setDateOfDate(start.get(Calendar.DAY_OF_MONTH));
								             
								           //   break; 
							           
						            }
						            

						           
						          weekDate.setDayLetter(DateConverterUtility.sayDayName(start.getTime()));
						        /*  if (start.get(Calendar.DAY_OF_WEEK) == 1)
						          {
						            weekDate.setDayLetter("Sunday");
						        
						          } else if (start.get(Calendar.DAY_OF_WEEK) == 2)
						          {
						            weekDate.setDayLetter("Monday");
						          } else if (start.get(Calendar.DAY_OF_WEEK) == 3)
						          {
						            weekDate.setDayLetter("Tuesday");
						          } else if (start.get(Calendar.DAY_OF_WEEK) == 4)
						          {
						            weekDate.setDayLetter("Wednesday");
						          } else if (start.get(Calendar.DAY_OF_WEEK) == 5)
						          {
						            weekDate.setDayLetter("Thursday");
						          } else if (start.get(Calendar.DAY_OF_WEEK) == 6)
						          {
						            weekDate.setDayLetter("Friday");
						          } else if (start.get(Calendar.DAY_OF_WEEK) == 7)
						          {
						            weekDate.setDayLetter("Saturday");
						          }*/
						          
						          arrayList.add(weekDate);
						        }
						   //     arrayList=sortAll(arrayList);
						        dealTo.setWeakDate(arrayList);
						      }
						      
						  	dealTo.setAvailableStartTime(DateConverterUtility.toMeridian(dealTo
									.getAvailableStartTime()));
							dealTo.setAvailableEndTime(DateConverterUtility.toMeridian(dealTo.getAvailableEndTime()));
							
							if(searchCriteria.getDealAvailDate()!=null )
							{
								if( searchCriteria.getDealAvailDate().equals(
										DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate())))
								{
									
								if(dealTo.getWeakDate()!=null && dealTo.getWeakDate().size()>0)
									dealInfo1.add(dealTo);		
								}
								
								
							}else if(dealTo.getWeakDate()!=null && dealTo.getWeakDate().size()>0)
								dealInfo1.add(dealTo);	
							
						
							// 
				}
			}
		} catch (ApplicationException e) {
			throw e;
		}
		
		//if(dealInfo != null && dealInfo.size() > 1)
        //    dealInfo = sortAll(dealInfo);

		return dealInfo1;
	}
	
 private ArrayList<WeekDate> sortAll(ArrayList<WeekDate> deals){
        ArrayList<WeekDate> sortDeals = new ArrayList<WeekDate>();
        int i = 0;
        for(WeekDate deal:deals){
              if(i == 0)
                 sortDeals.add(deal);
              else{
                   //Date d = DateConverterUtility.convertUiToServiceDate(deal.getStartDate());
			 
           
                 //   sortDeals.add(compare(sortDeals, deal.getDayNumber())+1,deal);
                    }
              i++;
        }
        return sortDeals;
  }
  private int compare(ArrayList<WeekDate> sortDeals, int d){
        int index = sortDeals.size()-1;     /* index and size has one difference */
        
        while(index > -1){
              	//if(!d.before(DateConverterUtility.convertUiToServiceDate((sortDeals.get(index)).getStartDate())) ){
	//		if( !d.before(sortDeals.get(index)) )
			{	
			      return index;
              }
          //    index--;
        }
        return index;
  }

  
	public ArrayList<DealTO> newsearchDeals(SearchTO searchCriteria) throws ApplicationException {
		ArrayList<DealTO> dealInfo = null;
		try {
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				String[] prices = StringUtils.split(searchCriteria.getPriceStartRate(), ",");
				searchCriteria.setStartPrice(Double.valueOf(prices[0]));
				searchCriteria.setEndPrice(Double.valueOf(prices[1]));
			}
			ArrayList<RestaurantDealHistory> deals = userDao.newsearchDeals(searchCriteria);
			if (deals != null)
				dealInfo = constructDealsFromnewSearchDeals(deals);
			for (DealTO dealTo : dealInfo) {
				if (dealTo.getUsedDealsQty() != null) {
					dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
							- dealTo.getUsedDealsQty());
				}
			}
		} catch (ApplicationException e) {
			throw e;
		}
		return dealInfo;
	}

	private ArrayList<DealTO> constructDealsFromnewSearchDeals(
			ArrayList<RestaurantDealHistory> deals) {
		ArrayList<DealTO> dealInfo = new ArrayList<DealTO>();
		CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
		State state = new State();
		for (RestaurantDealHistory deal : deals) {
			DealTO dealTo = new DealTO();
			try {
				BeanUtils.copyProperties(dealTo, deal);
			} catch (Exception e) {
				e.printStackTrace();
			}

			dealTo.setRestaurantDeal(deal.getRestaurantDeal());
			dealTo.setDealTemplateId(deal.getDealHistoryId());
			DateTO dateTO = DateConverterUtility.getDealDay(deal.getRestDealStartDate(), deal
					.getRestaurantDeal().getAvailableWeekDays(), deal.getRestaurantDeal()
					.getAvailableStartTime());
			dealTo.setStartDate(dateTO.getDealAvailableDate());
			dealTo.setDay(dateTO.getDay());
			dealTo.setCurrentCredits(deal.getRestaurantDeal().getRestaurantLocation()
					.getRestaurant().getCurrentCredits());
			dealTo.setBillingMethodId(deal.getRestaurantDeal().getRestaurantLocation()
					.getRestaurant().getBillingMethodId());
			dealTo.setLocationRestName(deal.getRestaurantDeal().getRestaurantLocation()
					.getLocationRestName());
			dealTo.setAddress(deal.getRestaurantDeal().getRestaurantLocation().getUser()
					.getAddress());

			dealTo.setAddress(deal.getRestaurantDeal().getRestaurantLocation().getAddress());

			dealTo.setAddress1(deal.getRestaurantDeal().getRestaurantLocation().getAddress1());

			dealTo.setCity(deal.getRestaurantDeal().getRestaurantLocation().getCityId());
			int stateid = deal.getRestaurantDeal().getRestaurantLocation().getStateId();
			if (stateid != 0) {
				state = commonBO.getStatesById(stateid);
				dealTo.setState(state.getStateName());
			}
			dealTo.setZipcode(deal.getRestaurantDeal().getRestaurantLocation().getZipCode());
			dealTo.setPrefercity(deal.getRestaurantDeal().getRestaurantLocation().getCity()
					.getCityName());
			Set<RestaurantLocationPreference> locationPreferences = deal.getRestaurantDeal()
					.getRestaurantLocation().getLocationPreferences();
			Iterator<RestaurantLocationPreference> prefIter = locationPreferences.iterator();
			StringBuilder builder = new StringBuilder("");
			while (prefIter.hasNext()) {
				builder.append(prefIter.next().getCuisineTypeId().getType() + ", ");
			}
			if (builder.length() > 2)
				builder.replace(builder.length() - 2, builder.length() - 1, ".");

			dealTo.setCuisineTypeString(builder.toString());
			dealTo.setAvailableStartTime(DateConverterUtility.toMeridian(deal.getRestaurantDeal()
					.getAvailableStartTime()));
			dealTo.setAvailableEndTime(DateConverterUtility.toMeridian(deal.getRestaurantDeal()
					.getAvailableEndTime()));
			dealInfo.add(dealTo);
		}
		return dealInfo;
	}

	private ArrayList<DealTO> constructDealsFromSearchDeals(ArrayList<RestaurantDeal> deals) {

		ArrayList<DealTO> dealInfo = new ArrayList<DealTO>();
		CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
		State state = new State();
		for (RestaurantDeal deal : deals) {
			DealTO dealTo = new DealTO();
			try {
				BeanUtils.copyProperties(dealTo, deal);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/* if deal contains an event then copy event values */
			if(deal.getDealEvent() != null){
			    dealTo.setDealEventId(deal.getDealEvent().getDealEventId());
			    EventsTO eventTo = new EventsTO();
			    eventTo.setEventId(deal.getDealEvent().getEvents().getEventId());
			    eventTo.setEventCode(deal.getDealEvent().getEvents().getEventCode());
			    eventTo.setEventName(deal.getDealEvent().getEvents().getEventName());
			    eventTo.setStartDate(deal.getDealEvent().getEvents().getStartDate());
			    eventTo.setEndDate(deal.getDealEvent().getEvents().getEndDate());
			    eventTo.setIsActive(deal.getDealEvent().getEvents().getIsActive());
			    dealTo.setEventTO(eventTo);
			}
			/* Deal End time is passed (old code with start time) */
			DateTO dateTO = DateConverterUtility.getDealDay(deal.getRestDealStartDate(), deal
					.getAvailableWeekDays(), deal.getAvailableEndTime());
			/* setting the day and date for which the deal is available */
			dealTo.setDay(dateTO.getDay());
			dealTo.setStartDate(dateTO.getDealAvailableDate());
			
			Date dateTime = DateConverterUtility.convertUiToServiceDate(dateTO.getDealAvailableDate());
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateTime);
	        String time[] = deal.getAvailableStartTime().split(":");
	        cal.set(Calendar.HOUR, Integer.parseInt(time[0]));
	        cal.set(Calendar.MINUTE, Integer.parseInt(time[1]));
	        dateTime = cal.getTime();
	        dealTo.setDealDateWithTime(dateTime);
			dealTo.setCurrentCredits(deal.getRestaurantLocation().getRestaurant()
					.getCurrentCredits());
			dealTo.setBillingMethodId(deal.getRestaurantLocation().getRestaurant()
					.getBillingMethodId());
			dealTo.setLocationRestName(deal.getRestaurantLocation().getLocationRestName());

			dealTo.setAddress(deal.getRestaurantLocation().getAddress());

			dealTo.setAddress1(deal.getRestaurantLocation().getAddress1());

			dealTo.setCity(deal.getRestaurantLocation().getCityId());
			int stateid = deal.getRestaurantLocation().getStateId();
			if (stateid != 0) {
				state = commonBO.getStatesById(stateid);
				dealTo.setState(state.getStateName());
			}
			dealTo.setZipcode(deal.getRestaurantLocation().getZipCode());
			dealTo.setPrefercity(deal.getRestaurantLocation().getCity().getCityName());
			Set<RestaurantLocationPreference> locationPreferences = deal.getRestaurantLocation()
					.getLocationPreferences();
			Iterator<RestaurantLocationPreference> prefIter = locationPreferences.iterator();
			StringBuilder builder = new StringBuilder("");
			while (prefIter.hasNext()) {
				builder.append(prefIter.next().getCuisineTypeId().getType() + ", ");
			}
			if (builder.length() > 2)
				builder.replace(builder.length() - 2, builder.length() - 1, ".");

			dealTo.setCuisineTypeString(builder.toString());
			dealTo.setAvailableStartTime(DateConverterUtility.toMeridian(deal
					.getAvailableStartTime()));
			dealTo.setAvailableEndTime(DateConverterUtility.toMeridian(deal.getAvailableEndTime()));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(deal.getRestDealEndDate());
			deal.setRestDealEndDate(calendar.getTime());
			if (deal.getIsRecurring() == 0) {
				calendar.setTime(deal.getRestDealStartDate());
				calendar.add(Calendar.DATE, +6);
				deal.setRestDealEndDate(calendar.getTime());

			}
			if (deal.getRestDealEndDate().after(
					DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()))
					|| deal.getRestDealEndDate().equals(
							DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate()))) {
				dealInfo.add(dealTo);
			}
		}
		return dealInfo;
	}

	/* Returns the deal information of the dealId passed */
	public DealTO fetchDealByDealId(int dealId) throws ApplicationException {
		DealTO dealTo = null;
		try {
			RestaurantDeal deal = userDao.fetchDealByDealId(dealId);
			if (deal != null) {
				dealTo = constructDealTO(deal);

			}

		} catch (ApplicationException e) {
			throw e;
		}
		return dealTo;
	}

	/* Returns the deal history like how many times the deal booked and deal quantity available. */
	public DealTO fetchDealHistoryByDealId(int dealId) throws ApplicationException {
		DealTO dealTo = null;
		try {
			RestaurantDealHistory deal = userDao.fetchDealHistoryByDealId(dealId);
			if (deal != null) {
				dealTo = constructDealHistoryTO(deal);

			}

		} catch (ApplicationException e) {
			throw e;
		}
		return dealTo;
	}

	/*
	 * Creating TransferObject from database pojos
	 */
	private DealTO constructDealTO(RestaurantDeal deal) {
		DealTO dealTo = new DealTO();
		CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
		State state = new State();
		RestaurantLocation location = deal.getRestaurantLocation();
		try {
			BeanUtils.copyProperties(dealTo, deal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Set<RestaurantDinnigPreferences> diningPreferences = location.getDiningPreferences();
		Set<RestaurantLocationPreference> locationPreferences = location.getLocationPreferences();
		dealTo.setDealTemplateId(deal.getDealTemplateId());
		dealTo.setAddress(location.getAddress());

		dealTo.setAddress1(location.getAddress1());
		
		dealTo.setCity(location.getCityId());
		int stateid = location.getStateId();
		if (stateid != 0) {
			state = commonBO.getStatesById(stateid);
			dealTo.setState(state.getStateName());
		}
		dealTo.setZipcode(location.getZipCode());
		dealTo.setPrefercity(location.getCity().getCityName());
		dealTo.setDescription(location.getDescription());
		dealTo.setCellPhone(location.getLocationHomePhone());
		dealTo.setWebsite(location.getWebSite());
		dealTo.setLocationRestImgPath(location.getLocationRestImgPath());
		DateTO dateTO = DateConverterUtility.getDealDay(deal.getRestDealStartDate(), deal
				.getAvailableWeekDays(), deal.getAvailableEndTime());
		dealTo.setStartDate(dateTO.getDealAvailableDate());
		dealTo.setDay(dateTO.getDay());
		dealTo.setLocationName(location.getLocationRestName());
		dealTo.setAvailableStartTime(DateConverterUtility.toMeridian(deal.getAvailableStartTime()));
		dealTo.setAvailableEndTime(DateConverterUtility.toMeridian(deal.getAvailableEndTime()));
		dealTo.setDealTemplateDescription(deal.getDealTemplateDescription());
		dealTo.setDealTemplateRestrictions(deal.getDealTemplateRestrictions());
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

		dealTo.setPrice("" + nf.format(location.getPriceStartRate()) + "-"
				+ nf.format(location.getPriceEndRate()));

		Iterator<RestaurantDinnigPreferences> diningpref = diningPreferences.iterator();
		StringBuffer diningprefString = new StringBuffer("");
		while (diningpref.hasNext()) {
			diningprefString.append(diningpref.next().getCuisineTypeId().getDiningStyleName()
					+ ", ");

		}

		if (diningprefString.length() > 2)
			diningprefString.deleteCharAt(diningprefString.length() - 2);

		dealTo.setDiningStyleString(diningprefString.toString());
		Iterator<RestaurantLocationPreference> locationPref = locationPreferences.iterator();
		StringBuffer locationPrefString = new StringBuffer("");
		while (locationPref.hasNext()) {
			locationPrefString.append(locationPref.next().getCuisineTypeId().getType() + ", ");
		}
		if (locationPrefString.length() > 2)
			locationPrefString.deleteCharAt(locationPrefString.length() - 2);

		dealTo.setCuisineTypeString(locationPrefString.toString());
		if (dealTo.getUsedDealsQty() != null) {
			dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
					- dealTo.getUsedDealsQty());
		}
		String days[] = deal.getAvailableWeekDays().split(",");
		String daysstring = "";
		for (int i = 0; i < days.length; i++) {
			if (i > 0 && i < (days.length))
				daysstring = daysstring + ",";

			if (days[i].equals("1")) {
				daysstring = daysstring + "SUN";
			} else if (days[i].equals("2")) {
				daysstring = daysstring + " MON ";
			} else if (days[i].equals("3")) {
				daysstring = daysstring + " TUE";
			} else if (days[i].equals("4")) {
				daysstring = daysstring + " WED";
			} else if (days[i].equals("5")) {
				daysstring = daysstring + " THU";
			} else if (days[i].equals("6")) {
				daysstring = daysstring + " FRI";
			} else if (days[i].equals("7")) {
				daysstring = daysstring + " SAT";
			}

		}
		daysstring = daysstring + " . ";
		dealTo.setAvailableWeekDays(daysstring);
		String hostAddress = "";
		String hostPhno = "";
		try{
		User user = deal.getRestaurantLocation().getRestaurant().getUser();
		hostAddress = hostAddress + user.getAddress();
		if(user.getAddress1() != null && user.getAddress1().length()>0)
			hostAddress = hostAddress + "<br/>" + user.getAddress1();
		hostPhno = user.getMobilePhone();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		dealTo.setHostAddress(hostAddress);
		dealTo.setHostMobileNumber(hostPhno);
		String modifyMails = location.getAlternateEmailIds();
		if(StringUtils.isNotEmpty(modifyMails))
			modifyMails = modifyMails.replace(":",",");
		dealTo.setAlternateEmailIds(modifyMails);
		modifyMails = location.getRestaurant().getAlternateHosts();
		if(StringUtils.isNotEmpty(modifyMails))
			modifyMails = modifyMails.replace(":",",");
		dealTo.setAlternateHosts(modifyMails);
		return dealTo;
	}

	/*
	 * construct dealHistory transfer object 
	 */
	private DealTO constructDealHistoryTO(RestaurantDealHistory dealHistory) {
		DealTO dealTo = new DealTO();
		CommonBO commonBO = com.tangotab.businessImpl.BusinessFactory.getCommonBO();
		State state = new State();
		RestaurantDeal deal = dealHistory.getRestaurantDeal();
		RestaurantLocation location = deal.getRestaurantLocation();
		User user = location.getUser();
		Set<RestaurantDinnigPreferences> diningPreferences = location.getDiningPreferences();
		Set<RestaurantLocationPreference> locationPreferences = location.getLocationPreferences();
		dealTo.setDealTemplateId(deal.getDealTemplateId());

		dealTo.setAddress(location.getAddress());

		dealTo.setAddress1(location.getAddress1());

		dealTo.setCity(location.getCityId());
		int stateid = location.getStateId();
		if (stateid != 0) {
			state = commonBO.getStatesById(stateid);
			dealTo.setState(state.getStateName());
		}
		dealTo.setZipcode(location.getZipCode());
		dealTo.setPrefercity(location.getCity().getCityName());
		dealTo.setDescription(location.getDescription());
		dealTo.setCellPhone(user.getMobilePhone());
		dealTo.setWebsite(location.getWebSite());
		dealTo.setLocationRestImgPath(location.getLocationRestImgPath());
		DateTO dateTO = DateConverterUtility.getDealDay(dealHistory.getRestDealStartDate(), deal
				.getAvailableWeekDays(), deal.getAvailableStartTime());
		dealTo.setStartDate(dateTO.getDealAvailableDate());
		dealTo.setDay(dateTO.getDay());
		dealTo.setLocationName(location.getLocationRestName());
		dealTo.setAvailableStartTime(DateConverterUtility.toMeridian(deal.getAvailableStartTime()));
		dealTo.setAvailableEndTime(DateConverterUtility.toMeridian(deal.getAvailableEndTime()));
		dealTo.setDealTemplateDescription(deal.getDealTemplateDescription());
		dealTo.setDealTemplateRestrictions(deal.getDealTemplateRestrictions());
		/* Converting the amount in to $ format for display */
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		dealTo.setPrice("" + nf.format(location.getPriceStartRate()) + "-"
				+ nf.format(location.getPriceEndRate()));

		Iterator<RestaurantDinnigPreferences> diningpref = diningPreferences.iterator();
		StringBuffer diningprefString = new StringBuffer("");
		while (diningpref.hasNext()) {
			diningprefString.append(diningpref.next().getCuisineTypeId().getDiningStyleName()
					+ ", ");

		}
		if (diningprefString.length() > 2)
			diningprefString.deleteCharAt(diningprefString.length() - 2);

		dealTo.setDiningStyleString(diningprefString.toString());
		Iterator<RestaurantLocationPreference> locationPref = locationPreferences.iterator();
		StringBuffer locationPrefString = new StringBuffer("");
		while (locationPref.hasNext()) {
			locationPrefString.append(locationPref.next().getCuisineTypeId().getType() + ", ");
		}
		if (locationPrefString.length() > 2)
			locationPrefString.deleteCharAt(locationPrefString.length() - 2);

		dealTo.setCuisineTypeString(locationPrefString.toString());
		String days[] = deal.getAvailableWeekDays().split(",");
		String daysstring = "";
		for (int i = 0; i < days.length; i++) {
			if (i > 0 && i < (days.length))
				daysstring = daysstring + ",";

			if (days[i].equals("1")) {
				daysstring = daysstring + "SUN";
			} else if (days[i].equals("2")) {
				daysstring = daysstring + " MON ";
			} else if (days[i].equals("3")) {
				daysstring = daysstring + " TUE";
			} else if (days[i].equals("4")) {
				daysstring = daysstring + " WED";
			} else if (days[i].equals("5")) {
				daysstring = daysstring + " THU";
			} else if (days[i].equals("6")) {
				daysstring = daysstring + " FRI";
			} else if (days[i].equals("7")) {
				daysstring = daysstring + " SAT";
			}

		}
		daysstring = daysstring + " . ";
		dealTo.setAvailableWeekDays(daysstring);
		return dealTo;
	}

	/* Guest books the deal */
	public BookDealTO bookDeal(int userId, int dealId, DealTO dealTO) throws ApplicationException {
		BookDealTO to = userDao.bookDeal(userId, dealId, dealTO.getStartDate(),dealTO.getAvailableStartTime());
		String website = "";
		if (dealTO.getWebsite() != null && !dealTO.getWebsite().equals("")) {
			website = "<a href='" + dealTO.getWebsite() + "'>" + dealTO.getWebsite() + "</a>";

		}
		if (to != null) {
			if (to.getErrorMessage() == null || to.getErrorMessage().length() <= 0) {
				ConfigBO configBO=com.tangotab.businessImpl.BusinessFactory.getConfigBO();
				ConfigPojo configPojo=	configBO.getConfigDetails();
				  Integer maxdebit=configPojo.getCreditUserDeal();
				
				TransactionBO transactionBO=com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
				RestaurantTransaction restaurantTransaction=new RestaurantTransaction();
				User user=new User();
				user.setUserId(userId);
			 
				restaurantTransaction.setAmount(0);
				restaurantTransaction.setNoOfCredits(maxdebit);
				restaurantTransaction.setCurrentCredits((int)to.getCurrentCredits());
				restaurantTransaction.setDescription("By reservation "+to.getConsumerReservationId());
				restaurantTransaction.setRemarks(dealTO.getDealTemplateDescription()+", Location Name: "+to.getLocationName());
				restaurantTransaction.setTypeOfTrans(TangotabConstants.DEBIT);
			 
				Restaurant restaurant= new Restaurant();
				restaurant.setRestaurantId(to.getRestaurantId());
				restaurantTransaction.setUser(user);
				restaurantTransaction.setRestaurant(restaurant);
			 	transactionBO.saveRestaurantTransactions(restaurantTransaction);
					if(dealTO.getCellPhone()==null)
						dealTO.setCellPhone("");
				String address=dealTO.getAddress()+"<br/>";
				if(StringUtils.isNotEmpty(dealTO.getAddress1()))
					address+= dealTO.getAddress1()+" <br/>";

				if(StringUtils.isNotEmpty(dealTO.getCity()))
				  address+=	dealTO.getCity()+", ";
				if(StringUtils.isNotEmpty(dealTO.getState()))
				  address+= 	dealTO.getState()+", ";
				address+= 	dealTO.getZipcode()+" ";
				String phone=dealTO.getCellPhone();
				if(phone!=null && phone.length()==10)
				{
					phone=phone.substring(0, 3)+"-"+phone.substring(3, 6)+"-"+phone.substring(6, phone.length());
				}
				/* This is default bitley url for .com/searchForward.do */
				if(dealTO.getCompressedURL() == null)
				 dealTO.setCompressedURL("http://bit.ly/MRF4US");
				//String validationEmailContent = getReservationConfirmationEmail()
				String validationEmailContent = TangotabConstants.RESERVATION_CONFIRMATION_EMAIL_CONTENT_TOTAL4
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME,
								to.getConsumerName())
						.replace(
								TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_DEAL_CONFIRMATION_CODE,
								to.getConsumerReservationId() + "")
						
						.replace(TangotabConstants.DEAL_NAME,
								dealTO.getDealTemplateName())		
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_DESCRIPTION,
								dealTO.getDealTemplateDescription())
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_RESTRICTIONS,
								dealTO.getDealTemplateRestrictions())
									
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_WEBSITE, website)
						//.replace(TangotabConstants.EMAIL_CONTENT_PLACE_PHONE_NUMBER,
						//		phone)
						.replace(TangotabConstants.MANAGER_NAME, to.getDealManagerName())
						
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_ADDRESS, address)
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_DATE, dealTO.getStartDate())
						.replace(
								TangotabConstants.EMAIL_CONTENT_PLACE_TIME,
								dealTO.getAvailableStartTime() + " to "
										+ dealTO.getAvailableEndTime())
						.replace(TangotabConstants.EMAIL_CONTENT_PLACE_DAYS, dealTO.getDay())
						.replace(
								TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_RESTAURANT_LOCATION_NAME,
								to.getLocationName())
						.replace(TangotabConstants.DEAL_ID, Integer.valueOf(dealId).toString())
						.replace(TangotabConstants.DEAL_DATE, dealTO.getStartDate())
						.replace(TangotabConstants.SHORT_URL, dealTO.getCompressedURL());
				if(dealTO.getRestDealImagePath() != null)
				validationEmailContent = validationEmailContent
						.replace(TangotabConstants.IMG_PATH, dealTO.getRestDealImagePath().replace("../", ""));
						
				/* Guest is bcced for security */
                String bccEmails = to.getConsumerEmailId()+","+to.getDealManagerEmailId();
                /* if host is not a location manager then include host in email */
                if(!to.getDealManagerEmailId().equals(to.getAccountManagerEmailId()))
					bccEmails = bccEmails+","+to.getAccountManagerEmailId();
                if(StringUtils.isNotEmpty(dealTO.getAlternateEmailIds()))
                	 bccEmails = bccEmails + "," + dealTO.getAlternateEmailIds();
                if(StringUtils.isNotEmpty(dealTO.getAlternateHosts()))
                	bccEmails = bccEmails + "," + dealTO.getAlternateHosts();
				
                bccEmails = bccEmails +","+TangotabConstants.TANGO_TAB_NOREPLY_EMAIL_ID;
				TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, null,bccEmails,
						TangotabConstants.RESERVATION_CONFIRMATION_EMAIL_HEADER,
						validationEmailContent);
				/* If dealquantity for an offer is less than three then send alert emails to host and dealmanager
				 * AccountManager -- TotalBusinessName(mgr) and dealTO.getCellPhone() is.. locationhomephone */
				if(dealTO.getRemainingDeals()<=3)
				{       
					    String cc =  to.getAccountManagerEmailId()+","+TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID;
						if(StringUtils.isNotEmpty(dealTO.getAlternateEmailIds()))
							cc = cc + "," + dealTO.getAlternateEmailIds();
						if(StringUtils.isNotEmpty(dealTO.getAlternateHosts()))
		                	cc = cc + "," + dealTO.getAlternateHosts();
					 	
					 	
						if(dealTO.getRemainingDeals()==1)
						{
							String mailContent = TangotabConstants.DEALS_FINISHED_CONTENT_ZERO.replace(
									TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, to.getDealManagerName()).replace(
									TangotabConstants.DEAL_NAME, dealTO.getDealTemplateName()).replace(
									TangotabConstants.DEAL_ID, dealTO.getDealTemplateId().toString()).replace(
									TangotabConstants.DEALS_LEFT, Integer.valueOf(dealTO.getRemainingDeals()-1).toString()).replace(
									TangotabConstants.LOCATION_PLACE, to.getLocationName()).replace(
							TangotabConstants.DEAL_DESCRIPTION, dealTO.getDealTemplateDescription()).replace(
							TangotabConstants.MANAGER_NAME, to.getDealManagerName()).replace(
							TangotabConstants.MANAGER_PHONE, to.getDealManagerMoile());
							
								TangoTabMailer.sendEmail(to.getDealManagerEmailId(), cc,
									"Your "+dealTO.getDealTemplateName()+" offer has ran out!",
									mailContent); 	
						}else 
						{
							String mailContent = TangotabConstants.DEALS_FINISHED_CONTENT.replace(
									TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, to.getDealManagerName()).replace(
									TangotabConstants.DEAL_NAME, dealTO.getDealTemplateName()).replace(
									TangotabConstants.DEAL_ID, dealTO.getDealTemplateId().toString()).replace(
									TangotabConstants.DEALS_LEFT, Integer.valueOf(dealTO.getRemainingDeals()-1).toString()).replace(
									TangotabConstants.LOCATION_PLACE, to.getLocationName()).replace(
							TangotabConstants.DEAL_DESCRIPTION, dealTO.getDealTemplateDescription()).replace(
							TangotabConstants.MANAGER_NAME, to.getDealManagerName()).replace(
							TangotabConstants.MANAGER_PHONE, to.getDealManagerMoile());
							
								TangoTabMailer.sendEmail(to.getDealManagerEmailId(), cc,
										"Your "+dealTO.getDealTemplateName()+" offer is about to run out!",
									mailContent); 
						}
					/* sending offer details to admin also  
					String adminContent = TangotabConstants.DEALS_FINISHED_CONTENT_FOR_TEAM.replace(
							TangotabConstants.DEAL_NAME, dealTO.getDealTemplateName()).replace(
							TangotabConstants.DEALS_LEFT, Integer.valueOf(dealTO.getRemainingDeals()-1).toString())
							.replace(
							TangotabConstants.DEAL_DESCRIPTION, dealTO.getDealTemplateDescription()).replace(
							TangotabConstants.MANAGER_NAME, to.getDealManagerName()).replace(
							TangotabConstants.MANAGER_EMAIL, to.getDealManagerEmailId()).replace(
							TangotabConstants.MANAGER_PHONE, to.getDealManagerMoile());
					
					TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, null,
							"Reservation is about to close at "+dealTO.getDealTemplateName(), adminContent); */
					
					
				}
				// double compare = TangotabConstants.MININUM_CREDITS_LIMIT
				//		/ configPojo.getDefaultDealCreditValue();
				double compare = TangotabConstants.MININUM_CREDITS_LIMIT;
			
					/*
				 * Sends a mail to recharge his account, if host credits to dollar value is less
				 * than $25.00 or 6 credits
				 */
                
				if ((to.getCurrentCredits() <= compare)
						&& (to.getBillingMethodId() == TangotabConstants.BILLING_METHOD_ID)
						&& to.getIsAutoDebit() == (byte) 0) {
					String bcc = TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID;
					if(StringUtils.isNotEmpty(dealTO.getAlternateHosts()))
						bcc = bcc + "," +dealTO.getAlternateHosts();
					String content = TangotabConstants.LOW_CREDIT_NOTIFICATION_CONTENT.replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, to.getAccountManagerName())
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_ADDRESS, dealTO.getHostAddress())
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_PHONE_NUMBER, dealTO.getHostMobileNumber());
					TangoTabMailer.sendEmail(to.getAccountManagerEmailId(), null,bcc,
							TangotabConstants.LOW_CREDIT_NOTIFICATION_HEADER, content);

					
				}
				 /* If host billing type is AUTODEBIT and there are 6 credits then send an email */
				if ((to.getCurrentCredits() == compare)
						&& (to.getBillingMethodId() == TangotabConstants.BILLING_METHOD_ID)
						&& to.getIsAutoDebit() == (byte) 1) {
					
					String bcc = TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID;
					if(StringUtils.isNotEmpty(dealTO.getAlternateHosts()))
						bcc = bcc + "," +dealTO.getAlternateHosts();
					
					/* Get credit card no */
                    String cardNumber = "";
                    try{
					RestaurantCcProfile ccProfile = userDao.getCcProfile(to.getRestaurantId());
					if(ccProfile != null && ccProfile.getCcProfileId()!=null){
						int paymentProfileId = 0;
					GetPaymentProfiles getPaymentProfiles = new GetPaymentProfiles();
					List<CustomerPaymentProfileMaskedType> list = getPaymentProfiles
							.getPaymentProfiles(ccProfile.getCcProfileId());
					if(list!=null)
					for (CustomerPaymentProfileMaskedType paymentProfile : list) {
						paymentProfileId = (int) paymentProfile.getCustomerPaymentProfileId();

					}
					if (paymentProfileId != 0) {
						GetCustomerPaymentProfileResponseType customerPaymentProfileResponseType = getPaymentProfiles
								.getPaymentProfilebyProfileId(ccProfile.getCcProfileId(), paymentProfileId);
						cardNumber = customerPaymentProfileResponseType.getPaymentProfile().getPayment()
									.getCreditCard().getCardNumber();
					}
					}
                    }catch(Exception e){
                    	log.error("error while getting profile from authorize.net after deal booking", e);
                    }
					
					
					String content = TangotabConstants.LOW_CREDIT_NOTIFICATION_CONTENT_AUTODEBIT.replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, to.getAccountManagerName())
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_ADDRESS, dealTO.getHostAddress())
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_PHONE_NUMBER, dealTO.getHostMobileNumber());
					if(StringUtils.isNotEmpty(cardNumber))
						 content = content.replace(TangotabConstants.CREDIT_CARD_NUMBER, "ending in &nbsp;"+cardNumber);
					else
						   content = content.replace(TangotabConstants.CREDIT_CARD_NUMBER, "");
					TangoTabMailer.sendEmail(to.getAccountManagerEmailId(), null,bcc,
							TangotabConstants.LOW_CREDIT_NOTIFICATION_HEADER, content);
				}
				/*
				 * If host billing type is autodebit and credits went low then the system will
				 * recharge the account automatically
				 */
				if ((to.getCurrentCredits() < compare)
						&& (to.getBillingMethodId() == TangotabConstants.BILLING_METHOD_ID)
						&& to.getIsAutoDebit() == (byte) 1) {
					bccEmails = dealTO.getAlternateHosts();
					autoDebitTransactions(to.getRestaurantId(), configPojo);
				}				       

				/*
				 * If host credits went low then send a no credit
				 * notification email whether autodebtit or not ( most probably mail sent for non auto debit hosts)
				 */
				if ((to.getCurrentCredits() <= maxdebit)
						&& (to.getBillingMethodId() == TangotabConstants.BILLING_METHOD_ID)) {
					
					String bcc = TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID;
					if(StringUtils.isNotEmpty(dealTO.getAlternateHosts()))
						bcc = bcc + "," +dealTO.getAlternateHosts();
					
					String content = TangotabConstants.NO_CREDIT_NOTIFICATION_CONTENT.replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, to.getAccountManagerName())
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_ADDRESS, dealTO.getHostAddress())
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_PHONE_NUMBER, dealTO.getHostMobileNumber());
					TangoTabMailer.sendEmail(to.getAccountManagerEmailId(), null, bcc,
							TangotabConstants.NO_CREDIT_NOTIFICATION_HEADER, content);

				}
			}
		}

		return to;
	}

	/* Consumer Reservation of a user details are saving in Transfer object NotU */
	/*
	private ConsumerReservation constructReservation(DealTO dealTO) {
		User user = new User();
		user.setUserId(dealTO.getLoginUserId());
		RestaurantDeal deal = new RestaurantDeal();
		deal.setDealTemplateId(dealTO.getTobeBookedDealId());
		ConsumerReservation reservation = new ConsumerReservation();
		reservation.setRestaurantDeal(deal);
		reservation.setUser(user);
		reservation.setReservedTimestamp(new Timestamp(new Date().getTime()));

		if (deal != null && deal.getUsedDealsQty() < deal.getAvailableDealsQty()) {
			deal.setUsedDealsQty(deal.getUsedDealsQty() + 1);
		}

		return reservation;
	}
*/
	/* Fetch deal details by deal name */
	public DealTO fetchDealTemplete(String dealName) {
		DealTO dealTo = null;
		try {
			dealTo = userDao.fetchDealTemplateDeal(dealName);

		} catch (ApplicationException e) {
		}
		return dealTo;
	}

	/* Save billing information and amount of the particular host */
	@SuppressWarnings("deprecation")
	public void saveRechargeInfo(BillingCc billingCC, String name, String emailId) {
		BillingCc billingCc = constructBillingCC(billingCC);
		try {
			int restId = billingCc.getRestId();
			String restisautodebit = userDao.getIsAutoDebit(restId);
			Short debit = Short.parseShort(restisautodebit);
			boolean status = userDao.saveRechargeInfo(billingCc);

			String paymentMail = new String();
			if (status) {
				TransactionBO transactionBO=com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
				Restaurant restaurant=userDao.getRestaurantById(restId);
				RestaurantTransaction restaurantTransaction=new RestaurantTransaction();
				restaurantTransaction.setAmount((int)Double.parseDouble(billingCc.getAmount()));
				restaurantTransaction.setCurrentCredits((restaurant.getCurrentCredits()).intValue());
				restaurantTransaction.setNoOfCredits(billingCc.getQty());
				restaurantTransaction.setDescription("By credit card");
				restaurantTransaction.setRemarks(billingCC.getX_account_number());
				restaurantTransaction.setTypeOfTrans(TangotabConstants.CREDIT);
				User user=new User();
				user.setUserId(restaurant.getUser().getUserId());
	 
				restaurant.setRestaurantId(billingCc.getRestId());
				restaurantTransaction.setUser(user);
				restaurantTransaction.setRestaurant(restaurant);
			 	transactionBO.saveRestaurantTransactions(restaurantTransaction);
				/*
				 * This mail should be sent to non autodebit user or if he is changing to auto debit
				 * for first time
				 */
			
				if (billingCC.getIsAutoDebit() == 0
						|| (debit == 0 && billingCC.getIsAutoDebit() == 1)) {
					paymentMail = TangotabConstants.PAYMENT_CONFIRMATION_EMAIL
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, name)
							.replace(TangotabConstants.TRANSACTION_NUMBER,
									billingCc.getX_trans_id())
							.replace(TangotabConstants.DATE_OF_TRANSACTION,
									(billingCc.getPurchasedDate()).toLocaleString())
							.replace(TangotabConstants.TRANSACTION_AMOUNT, billingCc.getAmount())
							.replace(TangotabConstants.NO_OF_CREDITS, billingCc.getQty().toString())
							.replace(TangotabConstants.CREDIT_CARD, billingCc.getX_account_number());

					TangoTabMailer.sendEmail(emailId, TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, bccEmails, "TangoTab Order Confirmation",
							paymentMail);
				}
				/*
				 * This mail should sent only for autodebit transactions done while booking the deal
				 * by guest
				 */
				else if (billingCC.getIsAutoDebit() == 1 && debit == 1) {
					paymentMail = TangotabConstants.AUTO_PAYMENT_CONFIRMATION_EMAIL
							.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, name)
							.replace(TangotabConstants.TRANSACTION_NUMBER,
									billingCc.getX_trans_id())
							.replace(TangotabConstants.DATE_OF_TRANSACTION,
									(billingCc.getPurchasedDate()).toLocaleString())
							.replace(TangotabConstants.TRANSACTION_AMOUNT, billingCc.getAmount())
							.replace(TangotabConstants.NO_OF_CREDITS, billingCc.getQty().toString())
							.replace(TangotabConstants.CREDIT_CARD, billingCc.getX_account_number());
					

					TangoTabMailer.sendEmail(emailId, TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, bccEmails, "TangoTab - Auto Refill Confirmation",
							paymentMail);
				}

			}
		} catch (ApplicationException e) {
		}
	}

	private BillingCc constructBillingCC(BillingCc billingCc) {

		billingCc.setIsPrivacyAccepted(TangotabConstants.PRIVACY_ACCEPTED);

		billingCc.setPurchasedDate(new Timestamp(new Date().getTime()));

		return billingCc;
	}

	/* Get the reservation history of the deals by the guest in the past */
	public ArrayList<ConsumerReservationTO> getUserDealsHistory(int userId)
			throws ApplicationException {

		ArrayList<ConsumerReservationTO> userdealsTO = new ArrayList<ConsumerReservationTO>();
		ArrayList<ConsumerReservation> userdeals = null;

		try {
			userdeals = userDao.getUserDealsHistory(userId);
			for (ConsumerReservation cr : userdeals) {
				ConsumerReservationTO crTO = new ConsumerReservationTO();

				crTO.setConResId(cr.getConResId());
				crTO.setUser(cr.getUser());
				crTO.setRestaurantDeal(cr.getRestaurantDeal());
				crTO.setIsConsumerShownUp(cr.getIsConsumerShownUp());
				crTO.setBusinessName(cr.getRestaurantDeal().getRestaurantLocation().getRestaurant().getBusinessName());
				/* Converting the Time format to U.S time for display */
				crTO.setReservedTimestamp(DateConverterUtility.convertDBTimeStampToUiDate(cr
						.getReservedTimestamp()));
				/* test if the offer is available or not */
				if( new java.sql.Timestamp(new Date().getTime()).after( cr.getBookedTimestamp()) )
				  crTO.setExpired(true);
				else
					crTO.setExpired(false);

				userdealsTO.add(crTO);
			}
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
		return userdealsTO;
	}

	/*
	 * An Email sent to helpline for the person who requested to help him to publish their deals.
	 * This is for the persons who are not signed up.
	 */
	public boolean publishDealMail(PublishDealTO contact) throws ApplicationException {
		try {

			String publishDealEmailContent = TangotabConstants.PUBLISH_DEAL_EMAIL_CONTENT.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_BUSINESS,
					contact.getBusinessname()).replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_ADDRESS, contact.getAddress())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_ADDRESS1,
							contact.getAddress1()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_CITY, contact.getCityId())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_STATE,
							contact.getStateName()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_ZIPCODE,
							contact.getZipCode()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_PHONE, contact.getPhone())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_CONTACT,
							contact.getContactname()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_TITLE, contact.getTitle())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL,
							contact.getEmailId()).replace(
							TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_COMMENTS,
							contact.getComments());

			boolean status = TangoTabMailer.sendEmail("help@tangotab.com", null,
					TangotabConstants.PUBLISH_DEAL_EMAIL_CONTENT_HEADER, publishDealEmailContent);

			if (status) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	/* Checks the availability of the EmailId for those who want to signup with us. */
	public boolean checkUserAvailability(String emailId, int roleId) {
		return userDao.checkUserAvailability(emailId, roleId);
	}

	/* Retrieves the billing history of the particular BusinessName */
	public ArrayList<BillingCcTO> getBillingSummary(int restId) throws ApplicationException {

		ArrayList<BillingCcTO> billingTO = new ArrayList<BillingCcTO>();
		ArrayList<BillingCc> userdeals = null;
		NumberFormat usFormat = new DecimalFormat("#0.00");
		try {
			userdeals = userDao.getBillingSummary(restId);
			for (BillingCc billing : userdeals) {
				BillingCcTO blTO = new BillingCcTO();

				blTO.setRestId(billing.getRestId());
				if (billing.getAmount() != null && billing.getAmount().length() > 0) {
					Double damount = Double.parseDouble(billing.getAmount());
					blTO.setDoubleAmount(damount);
					blTO.setAmount("$" + usFormat.format(damount));
				} else {
					blTO.setDoubleAmount(0.0);
					blTO.setAmount("$" + usFormat.format(0.0));
				}
				blTO.setPurchasedDate(DateConverterUtility.convertDBTimeStampToUiDate(billing
						.getPurchasedDate()));
				blTO.setTransNumber(billing.getX_trans_id());
				blTO.setAccNo(billing.getX_account_number());
				blTO.setNoOfUnits(billing.getQty());
				billingTO.add(blTO);
			}
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
		return billingTO;

	}

	/* The Guest forwards the deal to friend */
	
	public boolean forwardDealToFriend(ConsumerReferral refer, String dealId)
			throws ApplicationException {
		try {

			userDao.forwardDealToFriend(refer);
			String fromName = "";
			
			if(StringUtils.isNotEmpty(refer.getUser().getLastname()))
				fromName = refer.getUser().getLastname();
			if(StringUtils.isNotEmpty(refer.getUser().getFirstname()))
				fromName = refer.getUser().getFirstname() + " " + fromName;
			
			String forwardEmailContent = TangotabConstants.FORWARD_EMAIL_CONTENT.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_REFERAL_DEAL, dealId);
			
			if(StringUtils.isNotEmpty(fromName))
				forwardEmailContent = forwardEmailContent.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL, fromName+" ("+refer.getUser().getEmailId()+") ");
			else
				forwardEmailContent = forwardEmailContent.replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL, refer.getUser().getEmailId());
			
			String header = TangotabConstants.FORWARD_DEAL_EMAIL_CONTENT_HEADER;

			boolean status = TangoTabMailer.sendEmail(refer.getFriendEmailId(), fromName, null, null, header,
					forwardEmailContent);

			if (status) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* Referring a friend and sending mail alert */
public boolean referAFriend(ConsumerReferral refer)
	throws ApplicationException {
try {
	userDao.forwardDealToFriend(refer);
	String fromName = "";
	
	if(StringUtils.isNotEmpty(refer.getUser().getLastname()))
		fromName = refer.getUser().getLastname();
	if(StringUtils.isNotEmpty(refer.getUser().getFirstname()))
		fromName = refer.getUser().getFirstname() + " " + fromName;
	String forwardEmailContent = TangotabConstants.FORWARD_FRIEND_CONTENT;
	if(StringUtils.isNotEmpty(fromName))
	  forwardEmailContent = forwardEmailContent.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL, fromName+" ("+refer.getUser().getEmailId()+") ");
	else
		forwardEmailContent = forwardEmailContent.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL, refer.getUser().getEmailId());
	
	String header = TangotabConstants.FORWARD_FRIEND_EMAIL_CONTENT_HEADER;

	boolean status = TangoTabMailer.sendEmail(refer.getFriendEmailId(), fromName, null, null, header,
			forwardEmailContent);

	if (status) {
		return true;
	}
} catch (Exception e) {
	e.printStackTrace();
}
return false;
}

/* Referring friends without logging to the site */
public boolean referAFriend(ExternalReferral refer, String to)throws ApplicationException{
	boolean atleastOneFriend = false;
	try{
		String toEmails[] = to.split(",");
		ExternalReferral referral = new ExternalReferral();
		/* If successfully referred then only insert in to DB */
		
		for(int toIndex = 0; toIndex < toEmails.length; toIndex++){
			String forwardEmailContent = TangotabConstants.FORWARD_FRIEND_CONTENT
			.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_EMAIL, refer.getReferralName()+" ("+refer.getReferralEmailId()+") ");	
			String header = TangotabConstants.FORWARD_FRIEND_EMAIL_CONTENT_HEADER;

			boolean status = TangoTabMailer.sendEmail(toEmails[toIndex], refer.getReferralName(), null, null, header,
					forwardEmailContent);
				referral.setReferralEmailId(refer.getReferralEmailId());
				referral.setFriendEmailId(toEmails[toIndex]);
				userDao.referAFriend(referral);
			
			atleastOneFriend = status || atleastOneFriend ;
		}
	
		return atleastOneFriend;

} catch (Exception e) {
	e.printStackTrace();
}
return false;
}

	/* Get all Host business information */
	public ArrayList<Restaurant> getAllRestaurants() throws ApplicationException {

		try {
			return userDao.getAllRestaurants();
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}

	}
	
	/* fetch all restaurants according to pagination requests */
	public ArrayList<Restaurant> getAllRestaurants(int currentPage,SortByTO sortByTO) throws ApplicationException {
		
		 try {
	            ArrayList<Restaurant> allRestaurants = userDao.getAllRestaurants(currentPage, sortByTO);
	            // TODO AMAR loading Restautrant Location to avoid Lazy loading Issues
	            // TODO AMAR it there a better way that UI can use this method
	            for (Restaurant restaurant : allRestaurants) {
	                Set<RestaurantLocation> restaurantLocations = restaurant.getRestaurantLocations();
	                System.out.println(restaurantLocations.size());
	            }
	            return allRestaurants;
	        } catch (ApplicationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            throw e;
	        }
		
	}
	
	/* search functionality for restaurants according to name and page numbers */
	public ArrayList<Restaurant> getRestaurantByName(String businessName, int currentPage,SortByTO sortByTO) throws ApplicationException{
		try {
			return userDao.getRestaurantByName(businessName, currentPage,sortByTO);
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
		throw e;	
		}
	}

	/* The businessname(host) can be made active or inactive by administrator */
	public boolean setRestaurantStatus(int restId, Short status) throws ApplicationException {
		try {

			return userDao.setRestaurantStatus(restId, status);
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}

	}

	/* Get host information by host userid */
	public Restaurant getRestaurantById(Integer restaurantId) throws ApplicationException {
		Restaurant restaurant = null;
    	RestaurantTO restaurantTO = new RestaurantTO();
        try {

            restaurant =  userDao.getRestaurantById(restaurantId);
           try{
        	   BeanUtils.copyProperties(restaurantTO, restaurant.getUser());
           }catch(Exception e){
        	   
           }
            
        } catch (ApplicationException e) {
            if (log.isErrorEnabled()) {
                log.error("Got following error while retrieving restaurant details Message: "
                        + e.getMessage());
            }
            throw e;
        }
        return restaurant;
	}

	/* Get host informatin by buisnessname of the restaurant */
	public ArrayList<Restaurant> getRestaurantByName(String businessName)
			throws ApplicationException {

		try {

			return userDao.getRestaurantByName(businessName);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}

	/* Retrieve all Guest information */
	public ArrayList<UserTO> getAllUsers() throws ApplicationException {
		ArrayList<User> users = null;
		ArrayList<UserTO> usersTo = new ArrayList<UserTO>();
		try {

			users = (ArrayList<User>) userDao.getAllUsers();
			for (User user : users) {
				UserTO userto = new UserTO();
				BeanUtils.copyProperties(userto, user);
				usersTo.add(userto);
			}

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving user details Message: "
						+ e.getMessage());

			}
			throw e;
		} catch (Exception e) {

		}
		return usersTo;

	}

	/* Retrieve  Guest information according to page number */
	public ArrayList<UserTO> getAllUsers(int page,SortByTO sortByTO) throws ApplicationException {
		ArrayList<User> users = null;
		ArrayList<UserTO> usersTo = new ArrayList<UserTO>();
		try {

			users = (ArrayList<User>) userDao.getAllUsers(page,sortByTO);
			for (User user : users) {
				UserTO userto = new UserTO();
				if (user.getUserCreateDate() == null)
					user.setUserCreateDate(new java.sql.Timestamp(new java.util.Date()
							.getTime()));
				BeanUtils.copyProperties(userto, user);
				usersTo.add(userto);
			}

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving user details Message: "
						+ e.getMessage());

			}
			throw e;
		} catch (Exception e) {

		}
		return usersTo;

	}
	/* counts all guests */
	public Long countAllUsers(String emailId){
		Long l = null;
		try {
			l =  userDao.countAllUsers(emailId);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	/* getting guests according to name for search functionality and for pagination */
	public ArrayList<User> getUserById(String name, int page,SortByTO sortByTO) throws ApplicationException{
		try {
			return userDao.getUserById(name, page,sortByTO);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}
	/* The User(Host,Guest,DealManager) can be made active or inactive by administrator. */
	public boolean setUserStatus(String emailId, short status, int roleId)
			throws ApplicationException {

		try {

			return userDao.setUserStatus(emailId, status, roleId);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}

	/*
	 * This PwdStatus sets to '1' if the password is forgotten or is set by the system generated
	 * password, so that that the user can be redirected to 'reset_password' page after login
	 */
	public boolean setUserPwdStatus(String emailId, short pstatus) throws ApplicationException {
		try {

			return userDao.setUserPwdStatus(emailId, pstatus);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}

	/*
	 * Sets the status flag so that the guest will be redirected to the editinformation page untill
	 * he completely fills his information.
	 */
	public boolean setUserConsumerStatus(String emailId, short pstatus, int roleId)
			throws ApplicationException {
		try {

			return userDao.setUserConsumerStatus(emailId, pstatus, roleId);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}

	/* send email to customer */
	private void sendCustomerEmail(User user, String code) {

		String userEmailContent = TangotabConstants.ADMIN_CONSUMER_VALIDATION_EMAIL_CONTENT
				.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, user.getFirstname());
				//.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, user.getEmailId())
				//.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_PASSWORD,
					//	TangoTabPasswordEncrypt.getPasswordDecrypt(user.getPassword()));

		TangoTabMailer.sendEmail(user.getEmailId(), null,
				TangotabConstants.CONSUMER_VALIDATION_EMAIL_HEADER, userEmailContent);
	}

	/* Creates a new Guest by the administrator */
	public void saveConsumer(User consumer, String mail) throws ApplicationException {
		try {
			constructConsumer(consumer);
			consumer
					.setPassword(TangoTabPasswordEncrypt.getPasswordEncrypt(consumer.getPassword()));

			int consumerId = userDao.saveConsumer(consumer);
			if (consumerId > 0) {
				sendCustomerEmail(consumer, mail);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/* Get user information by userid */
	@SuppressWarnings("unchecked")
	public UserTO getUserByUserId(Integer userId) throws ApplicationException {
		UserTO userTo = new UserTO();
		try {

			User user = (User) userDao.getUserByUserId(userId);
			user.setPreferencesList(getPreferences(user));
			
			if (user.getUserCreateDate() == null)
				user.setUserCreateDate(new java.sql.Timestamp(new java.util.Date()
						.getTime()));
			
			BeanUtils.copyProperties(userTo, user);
			BeanUtils.copyProperties(userTo, user.getRole());
			int userRole = userTo.getRoleId();
			if (userRole == TangotabConstants.CONSUMER_ROLE) {
				userTo.setPreferencesList(getPreferences(user));
			} else if (userRole == TangotabConstants.RESTAURANT_OWNER) {
				BeanUtils.copyProperties(userTo, user.getRestaurent());
			} else if (userRole == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				Iterator it = user.getRestaurantLocations().iterator();
				while (it.hasNext()) {
					userTo.setRestaurantLocation((RestaurantLocation) it.next());
				}
			}
			userTo.setPreferencesList(user.getPreferencesList());

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTo;
	}

	/* Returns the Guests whose Email contains the parameter passed as a substring. */
	public ArrayList<User> getUserById(String name) throws ApplicationException {

		try {
			return userDao.getUserById(name);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}

	/* Returns Role name according to role id */
	private String convertRoleIdtoString(Integer id) {
		String role = new String();

		if (id == 1)
			role = "Administrator";
		else if (id == 4)
			role = "Guest";
		else if (id == 5)
			role = "Host";
		else if (id == 6)
			role = "Location Manager";
		return role;
	}

	/* Saves the support data and their status (closed or open) */
	public int saveSupportData(Support support) throws ApplicationException {

		int id = 0;
		String role = new String();
		try {
			id = userDao.saveSupportData(support);
			if (id != 0) {

				if (support.getRoleId() != null) {
					role = convertRoleIdtoString(support.getRoleId());
				}
				supportUsMail(support, role);
			}

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
		return id;
	}

	/* Display all support issues */
	public ArrayList<SupportTO> getAllSupportIssues() throws ApplicationException {

		ArrayList<SupportTO> supportTos = new ArrayList<SupportTO>();
		ArrayList<Support> support = null;
		try {
			support = userDao.getAllSupportIssues();
			for (Support sup : support) {
				SupportTO supto = new SupportTO();
				BeanUtils.copyProperties(supto, sup);
				supto.setSupportDate(DateConverterUtility.convertDBTimeStampToUiDate(sup
						.getSupportDate()));
				supto.setRolename(convertRoleIdtoString(sup.getRoleId()));
				supportTos.add(supto);
			}
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supportTos;
	}

	/* Get the details of the support issue by id */
	public SupportTO getSupportIssueById(Integer supportId) throws ApplicationException {

		Support support = new Support();
		SupportTO supportTo = new SupportTO();
		try {
			support = userDao.getSupportIssueById(supportId);
			BeanUtils.copyProperties(supportTo, support);
			supportTo.setSupportDate(DateConverterUtility.convertDBTimeStampToUiDate(support
					.getSupportDate()));
			supportTo.setRolename(convertRoleIdtoString(support.getRoleId()));
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supportTo;
	}

	/* Change the status (open or close) of the issue by the administrator */
	public boolean setSupportStatus(Integer supportId, Integer status) throws ApplicationException {

		try {
			return userDao.setSupportStatus(supportId, status);

		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}

	/*
	 * Get all the issues if the name(emailId) is similar to the person's emailId who posted the
	 * issue.
	 */
	public ArrayList<SupportTO> getSupportIssuesByEmail(String name) throws ApplicationException {

		ArrayList<SupportTO> supportTos = new ArrayList<SupportTO>();
		ArrayList<Support> support = new ArrayList<Support>();

		try {
			support = userDao.getSupportIssuesByEmail(name);
			SupportTO supportTo = new SupportTO();
			for (Support sup : support) {
				BeanUtils.copyProperties(supportTo, sup);
				supportTo.setSupportDate(DateConverterUtility.convertDBTimeStampToUiDate(sup
						.getSupportDate()));
				supportTo.setRolename(convertRoleIdtoString(sup.getRoleId()));
				supportTos.add(supportTo);
			}
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: "
						+ e.getMessage());
			}
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supportTos;
	}

	public void saveSalesManager(SalesManagerTO salesManagerTO) throws ApplicationException {
		SalesManagerInfo salesManagerInfo = constructSalesManagerInfo(salesManagerTO);
		try {
			userDao.saveSalesManager(salesManagerInfo);
		} catch (ApplicationException e) {
			throw e;
		}
	}

	public void saveSalesRepresentInfo(SalesManagerTO salesRepresentInfo)
			throws ApplicationException {
		SalesRepresentInfo salesRepInfo = constructSalesRepInfo(salesRepresentInfo);
		try {
			userDao.saveSalesRepresentInfo(salesRepInfo);
		} catch (ApplicationException e) {
			throw e;
		}

	}

	private SalesRepresentInfo constructSalesRepInfo(SalesManagerTO salesRepresentInfo) {
		SalesRepresentInfo salesRep = new SalesRepresentInfo();
		User user = new User();
		salesRep.setUser(user);
		try {
			BeanUtils.copyProperties(user, salesRepresentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SalesInfo salesInfo = new SalesInfo();
		salesRep.setSalesInfo(salesInfo);
		Role role = new Role();
		role.setRoleId(TangotabConstants.SALES_MANAGER_ROLE);
		user.setRole(role);
		if (salesRepresentInfo.getUserId() != 0) {
			user.setUserId(salesRepresentInfo.getUserId());
		} else {
			user.setUserId(null);
		}
		salesInfo.setHireDate(DateConverterUtility.convertUiToServiceDate(salesRepresentInfo
				.getHireDate()));
		salesInfo.setTerminationDate(DateConverterUtility.convertUiToServiceDate(salesRepresentInfo
				.getTerminationDate()));
		salesInfo.setSalesInfoId(salesRepresentInfo.getSalesInfoId());
		City city = new City();
		city.setCityId(salesRepresentInfo.getCityId());
		salesInfo.setCity(city);
		salesInfo.setSalesRepresentInfos(salesRep);
		if (salesRepresentInfo.getSalesInfoId() != 0) {
			salesInfo.setSalesInfoId(salesRepresentInfo.getSalesInfoId());
		} else {
			salesInfo.setSalesInfoId(null);
		}
		String[] zipCodes = salesRepresentInfo.getCities();
		Set<SalesRepZipcodes> salesRepZipCodes = new HashSet<SalesRepZipcodes>();
		salesRep.setSalesRepZipcodeses(salesRepZipCodes);
		for (String zipCode : zipCodes) {
			SalesRepZipcodes zip = new SalesRepZipcodes();
			zip.setSalesRepresentInfo(salesRep);
			ZipCode zip_code = new ZipCode();
			zip_code.setZipCode(zipCode);
			zip_code.setSalesZipCodes(salesRepZipCodes);
			zip.setZipCode(zip_code);
			salesRepZipCodes.add(zip);
		}
		SalesManagerInfo salesMangerInfo = new SalesManagerInfo();
		salesMangerInfo.setSalesManagerId(salesRepresentInfo.getAssignedManager());
		salesRep.setAssignedManger(salesMangerInfo);
		if (salesRepresentInfo.getSalasMgrUserId() != 0) {
			salesRep.setSalesRepId(salesRepresentInfo.getSalasMgrUserId());
		}

		return salesRep;
	}

	private SalesManagerInfo constructSalesManagerInfo(SalesManagerTO salesManagerTO) {
		SalesManagerInfo managerInfo = new SalesManagerInfo();
		User user = new User();
		managerInfo.setUser(user);
		SalesInfo salesInfo = new SalesInfo();
		managerInfo.setSalesInfo(salesInfo);
		try {
			BeanUtils.copyProperties(user, salesManagerTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (salesManagerTO.getUserId() != 0) {
			user.setUserId(salesManagerTO.getUserId());
		} else {
			user.setUserId(null);
		}
		Role role = new Role();
		role.setRoleId(TangotabConstants.SALES_MANAGER_ROLE);
		user.setRole(role);
		salesInfo.setHireDate(DateConverterUtility.convertUiToServiceDate(salesManagerTO
				.getHireDate()));
		salesInfo.setTerminationDate(DateConverterUtility.convertUiToServiceDate(salesManagerTO
				.getTerminationDate()));
		salesInfo.setSalesManagerInfos(managerInfo);
		if (salesManagerTO.getSalesInfoId() != 0) {
			salesInfo.setSalesInfoId(salesManagerTO.getSalesInfoId());
		} else {
			salesInfo.setSalesInfoId(null);
		}
		String[] cities = salesManagerTO.getCities();
		Set<SalesMgrCities> salesMgrCities = new HashSet<SalesMgrCities>();
		managerInfo.setSalesMgrCitieses(salesMgrCities);
		for (String city : cities) {
			SalesMgrCities salCity = new SalesMgrCities();
			salCity.setSalesManagerInfo(managerInfo);
			City cityId = new City();
			cityId.setCityId(Integer.valueOf(city));
			salCity.setCity(cityId);
			salesMgrCities.add(salCity);
		}
		if (salesManagerTO.getSalasMgrUserId() != 0) {
			managerInfo.setSalesManagerId(salesManagerTO.getSalasMgrUserId());
		}
		return managerInfo;
	}

	public ArrayList<SalesManagerTO> fetchSalaeMgrInfo(String type) throws ApplicationException {
		ArrayList<SalesManagerInfo> managerInfo = userDao.fetchSalesManagerDetails(type);
		return constructSalesMgrTO(managerInfo);
	}

	private ArrayList<SalesManagerTO> constructSalesMgrTO(ArrayList<SalesManagerInfo> managerInfo) {
		ArrayList<SalesManagerTO> salesMgrList = new ArrayList<SalesManagerTO>();
		if (managerInfo != null) {
			for (SalesManagerInfo mgrInfo : managerInfo) {
				SalesManagerTO manager = new SalesManagerTO();
				salesMgrList.add(manager);
				User user = mgrInfo.getUser();
				manager.setFirstname(user.getFirstname());
				manager.setLastname(user.getLastname());
				manager.setSalasMgrUserId(mgrInfo.getSalesManagerId());
				manager.setIsActive(user.getIsActive());
				manager.setUserId(user.getUserId());
				StringBuffer citiesString = new StringBuffer("");
				Set<SalesMgrCities> mgrCities = mgrInfo.getSalesMgrCitieses();
				Iterator<SalesMgrCities> citiesIter = mgrCities.iterator();
				while (citiesIter.hasNext()) {
					SalesMgrCities mgrCity = citiesIter.next();
					City city = mgrCity.getCity();
					citiesString.append(city.getCityName() + " ");
				}
				manager.setCitiesString(citiesString.toString());
			}
		}
		return salesMgrList;
	}

	public ArrayList<SalesManagerTO> fetchSalesRepInfo(String type) throws ApplicationException {
		ArrayList<SalesRepresentInfo> salesRepInfo = userDao.fetchSalesRepresentativeInfo(type);
		return constructSalesRepTO(salesRepInfo);
	}

	private ArrayList<SalesManagerTO> constructSalesRepTO(ArrayList<SalesRepresentInfo> salesRepInfo) {
		ArrayList<SalesManagerTO> salesMgrList = new ArrayList<SalesManagerTO>();
		if (salesRepInfo != null) {
			for (SalesRepresentInfo repInfo : salesRepInfo) {
				SalesManagerTO manager = new SalesManagerTO();
				salesMgrList.add(manager);
				User user = repInfo.getUser();
				manager.setSalasMgrUserId(repInfo.getSalesRepId());
				manager.setFirstname(user.getFirstname());
				manager.setLastname(user.getLastname());
				manager.setIsActive(user.getIsActive());
				manager.setSalesManagerFirstName(repInfo.getAssignedManger().getUser()
						.getFirstname());
				manager
						.setSalesManagerLastName(repInfo.getAssignedManger().getUser()
								.getLastname());
				manager.setUserId(user.getUserId());
				StringBuffer zipCodeString = new StringBuffer("");
				Set<SalesRepZipcodes> repZipCodes = repInfo.getSalesRepZipcodeses();
				Iterator<SalesRepZipcodes> zipIter = repZipCodes.iterator();
				while (zipIter.hasNext()) {
					SalesRepZipcodes repZipCode = zipIter.next();
					ZipCode zip = repZipCode.getZipCode();
					zipCodeString.append(zip.getZipCode() + " ");
				}
				manager.setCitiesString(zipCodeString.toString());
			}
		}
		return salesMgrList;
	}

	public ArrayList<UserTO> getSalesManagerList() throws ApplicationException {
		return userDao.getSalesMangers();
	}

	public ArrayList<CityTO> getCitiesOfManger(int managerId) {
		return userDao.getCitiesOfManger(managerId);
	}

	public SalesManagerTO getSalesManagerInfoById(int salesMgrId) throws ApplicationException {
		SalesManagerTO managerInfo = null;
		SalesManagerInfo mgrInfo = userDao.getSalesManagerInfo(salesMgrId);
		managerInfo = constructSalesMgrTO(mgrInfo);
		return managerInfo;
	}

	private SalesManagerTO constructSalesMgrTO(SalesManagerInfo mgrInfo) {
		if (mgrInfo != null) {
			SalesManagerTO managerInfo = new SalesManagerTO();
			try {
				BeanUtils.copyProperties(managerInfo, mgrInfo.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
			managerInfo.setHireDate(DateConverterUtility.convertDBTimeStampToUiDate(mgrInfo
					.getSalesInfo().getHireDate()));
			managerInfo.setTerminationDate(DateConverterUtility.convertDBTimeStampToUiDate(mgrInfo
					.getSalesInfo().getTerminationDate()));
			managerInfo.setSalesInfoId(mgrInfo.getSalesInfo().getSalesInfoId());
			ArrayList<CityTO> cities = new ArrayList<CityTO>();
			managerInfo.setCitiesInfo(cities);
			managerInfo.setSalasMgrUserId(mgrInfo.getSalesManagerId());
			Set<SalesMgrCities> mgrCities = mgrInfo.getSalesMgrCitieses();
			if (mgrCities != null) {
				Iterator<SalesMgrCities> citiesIter = mgrCities.iterator();
				while (citiesIter.hasNext()) {
					CityTO city = new CityTO();
					try {
						BeanUtils.copyProperties(city, citiesIter.next().getCity());
					} catch (Exception e) {
						e.printStackTrace();
					}
					cities.add(city);
				}
			}
			managerInfo.setSalasMgrUserId(mgrInfo.getSalesManagerId());
			return managerInfo;
		}
		return null;
	}

	public SalesManagerTO getSalesRepInfoById(int salesRepId) throws ApplicationException {
		SalesManagerTO representInfo = null;
		try {
			SalesRepresentInfo repInfo = userDao.getSalesRepresentInfo(salesRepId);
			representInfo = constructSalesMgrTO(repInfo);
		} catch (ApplicationException e) {
			throw e;
		}
		return representInfo;
	}

	private SalesManagerTO constructSalesMgrTO(SalesRepresentInfo repInfo) {
		if (repInfo != null) {
			SalesManagerTO representInfo = new SalesManagerTO();
			try {
				BeanUtils.copyProperties(representInfo, repInfo.getUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
			representInfo.setSalasMgrUserId(repInfo.getSalesRepId());
			representInfo.setHireDate(DateConverterUtility.convertDBTimeStampToUiDate(repInfo
					.getSalesInfo().getHireDate()));
			representInfo.setTerminationDate(DateConverterUtility
					.convertDBTimeStampToUiDate(repInfo.getSalesInfo().getTerminationDate()));
			representInfo.setSalesInfoId(repInfo.getSalesInfo().getSalesInfoId());
			representInfo.setCityName(repInfo.getSalesInfo().getCity().getCityName());
			representInfo.setCityId(repInfo.getSalesInfo().getCity().getCityId());
			representInfo.setAssignedManager(repInfo.getAssignedManger().getSalesManagerId());
			Set<SalesRepZipcodes> zipCodes = repInfo.getSalesRepZipcodeses();
			if (null != zipCodes) {
				Iterator<SalesRepZipcodes> zipTer = zipCodes.iterator();
				ArrayList<String> zipCodesList = new ArrayList<String>();
				while (zipTer.hasNext()) {
					zipCodesList.add(zipTer.next().getZipCode().getZipCode());
				}
				String[] zipCodesInfo = (String[]) zipCodesList.toArray(new String[zipCodesList
						.size()]);
				representInfo.setZipCodes(zipCodesInfo);
			}
			return representInfo;
		}
		return null;
	}

	public void updateSalesMgrInfo(SalesManagerTO managerInfo) throws ApplicationException {
		SalesManagerInfo salesManagerInfo = constructSalesManagerInfo(managerInfo);
		try {
			userDao.deleteSalesMgrCities(salesManagerInfo.getSalesManagerId());
			userDao.updateSalesMgrInfo(salesManagerInfo);
		} catch (ApplicationException e) {
			throw e;
		}
	}

	public void updateSalesRepInfo(SalesManagerTO repIfo) throws ApplicationException {
		SalesRepresentInfo salesRepInfo = constructSalesRepInfo(repIfo);
		try {
			userDao.deleteSalesRepZipcodes(salesRepInfo.getSalesRepId());
			userDao.updateSalesRepresentInfo(salesRepInfo);
		} catch (ApplicationException e) {
			throw e;
		}
	}

	public void updateUserActiveStatus(int[] userId, int[] active) throws ApplicationException {
		userDao.updateActives(userId, active);
	}

	
	public ArrayList<LocationTO> getLocationsOfDealMgr(int userId) throws ApplicationException {
		ArrayList<LocationTO> locationList = new ArrayList<LocationTO>();
		ArrayList<RestaurantLocation> locations = userDao.getLocationsOfDealMgr(userId);

		for (Object location : locations) {
			LocationTO locationInfo = new LocationTO();
			Object[] columns = (Object[]) location;
			locationInfo.setRestaurantId((Integer) (columns[0]));
			locationInfo.setLocationRestName((String) (columns[1]));

			locationList.add(locationInfo);
		}

		return locationList;

	}

	/* Save the card(encrypted) details for the particular businessname */
	public void saveCreditcard(RestaurantCC restaurantCC) throws ApplicationException

	{
		try {
			userDao.saveCreditcard(restaurantCC);

		} catch (ApplicationException e) {
			throw e;
		}

	}

	/* Get restaurant billing details */
	public RestaurantCC getRestaurantCC(int restId) throws ApplicationException

	{
		try {

			RestaurantCC restaurantCC = userDao.getRestaurantCC(restId);
			return restaurantCC;

		} catch (ApplicationException e) {
			throw e;
		}

	}

	/* AutoDebits the minimun amount specified in the configuration table from the Host creditcard */
	public void autoDebitTransaction(int restId, ConfigPojo configPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			Result<Transaction> result = null;
			RestaurantCC restaurantCC = userDao.getRestaurantCC(restId);
			restaurantCC.setCardNumber(TangoTabPasswordEncrypt.getPasswordDecrypt(restaurantCC
					.getCardNumber()));
			restaurantCC.setExpiryMonth(TangoTabPasswordEncrypt.getPasswordDecrypt(restaurantCC
					.getExpiryMonth()));
			restaurantCC.setExpiryYear(TangoTabPasswordEncrypt.getPasswordDecrypt(restaurantCC
					.getExpiryYear()));
			restaurantCC.setVerificationCode(TangoTabPasswordEncrypt
					.getPasswordDecrypt(restaurantCC.getVerificationCode()));
			restaurantCC.setCardType(TangoTabPasswordEncrypt.getPasswordDecrypt(restaurantCC
					.getCardType()));

			CreditCardInfo creditcard = new CreditCardInfo();

			Restaurant restaurant = userDao.getRestaurantById(restId);
			BeanUtils.copyProperties(creditcard, restaurantCC);
			Date d = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			creditcard.setAmount(Double.toString(configPojo.getMinChargeAmt()));

			String startdate = sf.format(d);

			result = CreditCardDebit.advancepaymentMethod(creditcard.getEmail(), creditcard
					.getFirstName(), creditcard.getLastName(), creditcard.getCardNumber()
					.toString(), creditcard.getCardType(), creditcard.getCardName(), creditcard
					.getVerificationCode().toString(), creditcard.getExpiryYear(), creditcard
					.getExpiryMonth(), creditcard.getExpiryYear() + "-"
					+ creditcard.getExpiryMonth(), creditcard.getAmount(), startdate, creditcard
					.getCity(), creditcard.getState(), creditcard.getAddress1(), creditcard
					.getAddress2(), creditcard.getZip(), creditcard.getCountry());
			if (result.isApproved()) {

				BillingCc billingCc = new BillingCc();
				billingCc.setAmount(creditcard.getAmount());
				double qty = configPojo.getMinChargeAmt() / configPojo.getDefaultDealCreditValue();
				String emailId = restaurant.getUser().getEmailId();
				billingCc.setPurchasedBy(emailId);
				billingCc.setQty((int) qty);
				billingCc.setRestId(restId);
				billingCc.setX_trans_id(result.getTarget().getTransactionId());
				billingCc.setX_response_reason_code(result.getResponseCode().getCode());
				billingCc.setX_response_reason_text(result.getResponseText());
				billingCc.setIsAutoDebit(restaurant.getIsAutoDebit());

				billingCc.setX_account_number((creditcard.getCardNumber()).substring((creditcard
						.getCardNumber().length() - 4), creditcard.getCardNumber().length()));

				saveRechargeInfo(billingCc, restaurant.getUser().getFirstname(), emailId);

			}else{
				String responseMessage = new String();
				responseMessage = "TangoTab CreditCard Processing Failed";
				String  mailContent = TangotabConstants.CREDIT_CARD_FAILURE;
				String hostName = "";
				if(StringUtils.isNotEmpty(restaurant.getUser().getFirstname()))
					hostName = restaurant.getUser().getFirstname();
				if(StringUtils.isNotEmpty(restaurant.getUser().getLastname()))
					hostName = hostName+restaurant.getUser().getLastname();
				if(StringUtils.isEmpty(hostName))
					hostName = restaurant.getUser().getAccountManagerName();
				if(hostName == null)
					hostName = " ";
				
				mailContent = mailContent.replace(TangotabConstants.FAILED_REASON, responseMessage);
				mailContent = mailContent.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_BUSINESS, restaurant.getBusinessName()).replace(
						TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, hostName);
				TangoTabMailer.sendEmail(restaurant.getUser().getEmailId(),TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,   "TangoTab CreditCard Processing Failure",
						mailContent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* suggest a restaurant to user and send email */
	public boolean suggestRestaurant(SuggestRestTO user) throws ApplicationException {
		try {

			String suggestRestEmailContent = TangotabConstants.SUGGEST_RESTAURANT_MAIL.replace(
					TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, user.getCname())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_EMAIL_ID, user.getEmailId())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_CITY, user.getCity())
					.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_BUSINESS, user.getBusinessName())
					.replace(TangotabConstants.EMAIL_PLATFORM, user.getMobile())
					.replace(TangotabConstants.EMAIL_OTHER, user.getOther());

			boolean status = TangoTabMailer.sendEmail("requests@tangotab.com", null,
					TangotabConstants.SUGGEST_RESTAURANT_MAIL_HEADER, suggestRestEmailContent);

			if (status) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void autoDebitTransaction(int restId) throws ApplicationException {
		// TODO Auto-generated method stub

	}

	/* Search deals which are available in the restaurants, which are located in the CITY specified. */
	public ArrayList<DealTO> searchByCityDeals(String cityName) throws ApplicationException {
		ArrayList<DealTO> dealInfo = null;
		try {

			SearchTO searchCriteria = new SearchTO();
			searchCriteria.setCityName(cityName);
			ArrayList<RestaurantDeal> deals = userDao.getHotDeals(searchCriteria);
			if (deals != null)
				dealInfo = constructDealsFromSearchDeals(deals);
			for (DealTO dealTo : dealInfo) {
				if (dealTo.getUsedDealsQty() != null) {
					dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
							- dealTo.getUsedDealsQty());
				}
			}

		} catch (ApplicationException e) {
			throw e;
		}
		return dealInfo;
	}

	/* This procedure is for hosts who selected auto debit mode for their restaurant */
	public void autoDebitTransactions(int restId, ConfigPojo configPojo)
			throws ApplicationException {
		RestaurantCcProfile ccProfile;
		// TODO Auto-generated method stub
		try {

			ccProfile = userDao.getCcProfile(restId);

			if (ccProfile != null) {
				int paymentProfileId = 0;

				GetPaymentProfiles getPaymentProfiles = new GetPaymentProfiles();
				List<CustomerPaymentProfileMaskedType> list = getPaymentProfiles
						.getPaymentProfiles(ccProfile.getCcProfileId());
				if(list!=null)
				for (CustomerPaymentProfileMaskedType paymentProfile : list) {
					paymentProfileId = (int) paymentProfile.getCustomerPaymentProfileId();

				}

				if (paymentProfileId != 0) {
					GetCustomerPaymentProfileResponseType customerPaymentProfileResponseType = getPaymentProfiles
							.getPaymentProfilebyProfileId(ccProfile.getCcProfileId(),
									paymentProfileId);

					CreateProfiles createProfiles = new CreateProfiles();
					CreditCardInfo creditCardInfo = createProfiles
							.constructCustAddressToCreditAddress(customerPaymentProfileResponseType
									.getPaymentProfile().getBillTo());
					creditCardInfo.setCardNumber(customerPaymentProfileResponseType
							.getPaymentProfile().getPayment().getCreditCard().getCardNumber());
					creditCardInfo.setExpiryMonth(customerPaymentProfileResponseType
							.getPaymentProfile().getPayment().getCreditCard().getExpirationDate());

					BigDecimal amount = new BigDecimal(Double
							.toString(configPojo.getMinChargeAmt()));
					String invoiceCode = TangoTabUtility.generateRandomCode();
					CreateCustomerProfileTransactionResponseType responseType = CreateTransaction
							.createTransaction((long) ccProfile.getCcProfileId(),
									(long) paymentProfileId, amount, invoiceCode);

					if (responseType != null) {
						if (responseType.getResultCode().value().equals("Ok")) {

							Restaurant restaurant = ccProfile.getRestaurant();
							String s[] = responseType.getDirectResponse().split(",");
							CreditCardInfo creditcard = new CreditCardInfo();
							creditcard = creditCardInfo;
							BillingCc billingCc = new BillingCc();
							billingCc.setAmount(Double.toString(configPojo.getMinChargeAmt()));
							double qty = configPojo.getMinChargeAmt()
									/ configPojo.getDefaultDealCreditValue();
							String emailId = restaurant.getUser().getEmailId();
							billingCc.setPurchasedBy(emailId);
							billingCc.setQty((int) qty);
							billingCc.setRestId(restId);
							billingCc.setIsAutoDebit(restaurant.getIsAutoDebit());

							billingCc.setX_trans_id(s[6]);
							billingCc.setX_response_reason_code(1);
							billingCc.setX_response_reason_text(s[3]);

							billingCc.setX_account_number((creditcard.getCardNumber()));

							saveRechargeInfo(billingCc, restaurant.getUser().getFirstname(),
									emailId);
						}else{
							String responseMessage = new String();
							try{
								responseMessage = responseType.getMessages().getMessagesTypeMessage().get(0).getText().toString();
							}catch(NullPointerException ne){
								responseMessage = "TangoTab CreditCard Processing Failed";
							}
							String hostName = "";
							if(StringUtils.isNotEmpty(ccProfile.getRestaurant().getUser().getFirstname()))
								hostName = ccProfile.getRestaurant().getUser().getFirstname();
							if(StringUtils.isNotEmpty(ccProfile.getRestaurant().getUser().getLastname()))
								hostName = hostName+ccProfile.getRestaurant().getUser().getLastname();
							if(StringUtils.isEmpty(hostName))
								hostName = ccProfile.getRestaurant().getUser().getAccountManagerName();
							if(hostName == null)
								hostName = " ";
							String  mailContent = TangotabConstants.CREDIT_CARD_FAILURE;
							mailContent = mailContent.replace(TangotabConstants.FAILED_REASON, responseMessage);
							mailContent = mailContent.replace(TangotabConstants.EMAIL_CONTENT_PLACE_HODLER_BUSINESS, ccProfile.getRestaurant().getBusinessName()).replace(
									TangotabConstants.EMAIL_CONTENT_PLACE_HOLDER_NAME, hostName);
							try{
								userDao.changeRestaurantAutoDebit(restId, (short)0);
							}catch(Exception e){
								
							}
							
							TangoTabMailer.sendEmail(ccProfile.getRestaurant().getUser().getEmailId(),TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID, "srividya.j@techgene.com", "TangoTab CreditCard Processing Failure",
									mailContent);
							/* Set restaurant to non-autodebit so that system should not try to process failed cards */
							
						}
					} /* profile found but there is no response for the card */
					else{
						String mailContent = "TangoTab tried to process the card, but there is no response for this card from Authorize.net. Host: "+ccProfile.getRestaurant().getUser().getEmailId();
						TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,null, "srividya.j@techgene.com", "TangoTab CreditCard Processing Failure",
								mailContent);
					}

				} /* If there is no profile for this card in our gate way ( i.e test cards) */
				else{
					String mailContent = "TangoTab tried to get profile from Authorize.net , but there are no profiles found for Host: "+ccProfile.getRestaurant().getUser().getEmailId();
					
					TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,"srividya.j@techgene.com",  "TangoTab CreditCard Profile not found",
							mailContent);
				}
			}

		} catch (Exception e) {
			String mailContent = "TangoTab tried to get profile from Authorize.net , but there are no profiles found for HostId: "+restId;
			
			TangoTabMailer.sendEmail(TangotabConstants.TANGO_TAB_ADMIN_EMAIL_ID,"srividya.j@techgene.com",  "TangoTab CreditCard Profile not found",
					mailContent);
			e.printStackTrace();
		}

	}

	/* save creditcard profile */
	public int saveCcProfile(RestaurantCcProfile ccprofile) {
		try {
			return userDao.saveCcProfile(ccprofile);
		} catch (ApplicationException e) {
			e.printStackTrace();

		}
		return 0;
	}

	/* save payment profile information */
	public void savePaymentProfile(RestaurantPaymentProfile pprofile) {
		try {
			userDao.savePaymentProfile(pprofile);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/* Fetches all payment profiles */
	public ArrayList<RestaurantPaymentProfile> getPaymentProfiles(int profileId)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return userDao.getPaymentProfiles(profileId);

	}

	/* Returns how many roles are there for the emailId given. */
	public ArrayList<String> getRolesByEmail(String emailId) {
		ArrayList<String> roles = null;
		try {
			roles = (ArrayList<String>) userDao.getRolesByEmail(emailId);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return roles;
	}

	/* Retrieves Security Questions of the HOST incase of forgotten password. */
	public User getQuestionsByEmail(String emailId, Integer roleId) {
		User questions = null;

		try {
			questions = (User) userDao.getQuestionsByEmail(emailId, roleId);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return questions;
	}

	/* Get the deal reservation details by the reservationId */
	public ConsumerReservation getConReserveByReservationId(int rId) {
		ConsumerReservation conres = null;
		try {
			conres = (ConsumerReservation) userDao.getConReserveByReservationId(rId);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return conres;
	}
	
	/* Counts no. of deals according to criteria, used for finding no. of pages */
	public long countSearchDeals(SearchTO searchCriteria){
		long count = 0;
		try {
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != ""  ) {
				String[] prices = StringUtils.split(searchCriteria.getPriceStartRate(), ",");
				if(prices.length>=1)
				{
				searchCriteria.setStartPrice(Double.valueOf(prices[0]));
				searchCriteria.setEndPrice(Double.valueOf(prices[1]));
				} 
			}

			count = userDao.countSearchDealsort(searchCriteria);
 
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return count;
	}

	/* Get reports for all restaurants */
	public ArrayList<ReportTO> getRestaurantReports()
			throws ApplicationException {
		ArrayList<ReportTO> arrayList=userDao.getRestaurantReports();
 
		return arrayList;
	}
	public HSSFWorkbook createRestaurantWorkbook(ArrayList<ReportTO> userList) throws Exception {
		   HSSFWorkbook wb = new HSSFWorkbook();
		   HSSFSheet sheet = wb.createSheet("Restaurant Data");

	        /**
	         * Setting the width of the first three columns.
	         */
	        sheet.setColumnWidth(0, 3500);
	        sheet.setColumnWidth(1, 3500);
	        sheet.setColumnWidth(2, 7000);
	        sheet.setColumnWidth(3, 3000);
	        sheet.setColumnWidth(4, 5000);
	        sheet.setColumnWidth(5, 6000);
	        sheet.setColumnWidth(6, 6000);
	        sheet.setColumnWidth(7, 4500);
	        sheet.setColumnWidth(8, 7500);
	        sheet.setColumnWidth(9, 2200);
	        sheet.setColumnWidth(10, 4500);
	        sheet.setColumnWidth(11, 4500);
	        sheet.setColumnWidth(12, 4500);
	        sheet.setColumnWidth(13, 5000);
	        sheet.setColumnWidth(14, 4500);
	        sheet.setColumnWidth(15, 4500); 
	        /**
	         * Style for the header cells.
	         */
	        HSSFCellStyle headerCellStyle = wb.createCellStyle();
	        HSSFFont boldFont = wb.createFont();
	        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        boldFont.setColor(HSSFFont.COLOR_RED);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setWrapText(true);
	        HSSFRow row = sheet.createRow(0);
	        HSSFCell cell = row.createCell(0);
	        cell.setCellStyle(headerCellStyle);
	        HSSFCellStyle wraptext = wb.createCellStyle();
		       
	        wraptext.setWrapText(true);
	        
	        cell.setCellValue(new HSSFRichTextString("FIRST NAME"));
	        cell = row.createCell(1);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("LAST NAME"));
	        cell = row.createCell(2);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("BUSINESS NAME"));
	        cell = row.createCell(3);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("NO OF Locations"));
	        cell = row.createCell(4);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("ADDRESS1"));
	        cell = row.createCell(5);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("ADDRESS2"));
	        cell = row.createCell(6);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("CITY NAME"));
	        cell = row.createCell(7);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("STATE  NAME"));
	        cell = row.createCell(8);
	        cell.setCellStyle(headerCellStyle);
	      
	        cell.setCellValue(new HSSFRichTextString("EMAIL ID"));
	        cell = row.createCell(9);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("PASSWORD"));
	        
	        cell = row.createCell(10);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("ZIP CODE"));
	        cell = row.createCell(11);
	        
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("USER CREATE DATE"));
	        cell = row.createCell(12);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("SALES REP NAME"));
	        cell = row.createCell(13);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("SALES REP EMAIL ID"));
	        cell = row.createCell(14);
	        
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Administrator's Phone"));
	       	        
	  
	        for (int index = 1; index <= userList.size(); index++) {
	            row = sheet.createRow(index);
	      
	            ReportTO reportTO = (ReportTO) userList.get(index-1);
	            
	            cell = row.createCell(0);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getFIRSTNAME()));
	            
	            cell = row.createCell(1);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getLASTNAME()));
	            
	            cell = row.createCell(2);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getBUSINESS_NAME()));
	            cell = row.createCell(3);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(Integer.toString(reportTO.getNO_OF_LOCATIONS())));
	            
	            cell = row.createCell(4);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getADDRESS()));
	            
	            cell = row.createCell(5);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getADDRESS1()));
	            
	            cell = row.createCell(6);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getCity_id()));

	            cell = row.createCell(7);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getSTATE_NAME()));
	            
	            cell = row.createCell(8);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getEMAIL_ID()));
	            
	            cell = row.createCell(9);	
	            cell.setCellStyle(wraptext);
	            String password = TangoTabPasswordEncrypt.getPasswordDecrypt(reportTO.getPASSWORD());
	            cell.setCellValue(new HSSFRichTextString(password));
	            
	            cell = row.createCell(10);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getZIP_CODE()));
	            cell = row.createCell(11);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiDate(reportTO.getUSER_CREATE_DATE())));
	            
	            cell = row.createCell(12);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getSALES_REP_NAME()));
	            cell = row.createCell(13);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getSALES_REP_EMAILID()));
	            cell = row.createCell(14);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getMOBILE_PHONE()));
	            
	        }
		   return wb;
	  }

	/* Get User Preferences (dining styles) */
	public ArrayList<ReportTO> getUserPrefReports(QueryTO queryTo) throws ApplicationException {
 
	 
		ArrayList<ReportTO> arrayList=userDao.getUserPrefReports(queryTo);
		 
		return arrayList;
	}
	
	/* Prepare an excel sheet for guest report */
	public HSSFWorkbook createGuestWorkbook(ArrayList<ReportTO> userList) throws Exception {
		   HSSFWorkbook wb = new HSSFWorkbook();
		   HSSFSheet sheet = wb.createSheet("Guest Data");

	        /**
	         * Setting the width of the first three columns.
	         */
	        sheet.setColumnWidth(0, 5500);
	        sheet.setColumnWidth(1, 3500);
	        sheet.setColumnWidth(2, 7000);
	        sheet.setColumnWidth(3, 4000);
	        sheet.setColumnWidth(4, 5000);
	        sheet.setColumnWidth(5, 5000);
	        sheet.setColumnWidth(6, 5000);
	        sheet.setColumnWidth(7, 5000);
	        sheet.setColumnWidth(8, 4500);
	        sheet.setColumnWidth(9, 7500);
	        sheet.setColumnWidth(10, 7500);
	        sheet.setColumnWidth(11, 6000);
	        sheet.setColumnWidth(12, 5000);
	        sheet.setColumnWidth(13, 5000);
	        sheet.setColumnWidth(14, 5000);
	        sheet.setColumnWidth(15, 7500);
	        /**
	         * Style for the header cells.
	         */
	        HSSFCellStyle headerCellStyle = wb.createCellStyle();
	        HSSFFont boldFont = wb.createFont();
	        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        boldFont.setColor(HSSFFont.COLOR_RED);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setWrapText(true);
	        HSSFRow row = sheet.createRow(0);
	        HSSFCellStyle wraptext = wb.createCellStyle();
		       
	        wraptext.setWrapText(true);
	        HSSFCell cell = row.createCell(0);
	        cell.setCellStyle(headerCellStyle);
	    
	        
	        cell.setCellValue(new HSSFRichTextString("EMAIL ID"));
	        cell = row.createCell(1);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("FIRST NAME"));
	        cell = row.createCell(2);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("LAST NAME"));
	        
	        cell = row.createCell(3);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Gender"));
	        
	        cell = row.createCell(4);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Mobile Number"));
	        cell = row.createCell(5);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Home Number"));
	        
	        cell = row.createCell(6);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("ADDRESS1"));
	        cell = row.createCell(7);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("ADDRESS2"));
	        cell = row.createCell(8);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("CITY NAME"));	    
	        cell = row.createCell(9);
	        cell.setCellStyle(headerCellStyle);	      
	        cell.setCellValue(new HSSFRichTextString("ZIP CODE"));
	        cell = row.createCell(10);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("PREFER CITY")); 
	        cell = row.createCell(11);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("SOURCE"));

	        cell = row.createCell(12);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("WEB LOGIN COUNT"));
	        cell = row.createCell(13);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("iPhone LOGIN COUNT"));
	        
	        cell = row.createCell(14);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("SIGNUP_FROM"));
	        
	        cell = row.createCell(15);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("USER CREATE DATE"));
	  
	        for (int index = 1; index <= userList.size(); index++) {
	            row = sheet.createRow(index);
	            ReportTO reportTO = (ReportTO) userList.get(index-1);
	            
	            cell = row.createCell(0);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getEMAIL_ID())); 	            
	            cell = row.createCell(1);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getFIRSTNAME()));
	            cell = row.createCell(2);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getLASTNAME()));
	            cell = row.createCell(3);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getGENDER()));	
	            cell = row.createCell(4);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getMOBILE_PHONE()));
	            cell = row.createCell(5);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getHOME_PHONE()));
	            cell = row.createCell(6);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getADDRESS()));	            
	            cell = row.createCell(7);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getADDRESS1()));	            
	            cell = row.createCell(8);	 
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getCity_id()));
	            cell = row.createCell(9);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getZIP_CODE()));
	            
	            cell = row.createCell(10);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getCITY_NAME()));
	            cell = row.createCell(11);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getReffedBy()));
	            cell = row.createCell(12);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(Integer.toString(reportTO.getWeb_login_count()))); 
	            cell = row.createCell(13);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(Integer.toString(reportTO.getIphone_login_count())));
	            cell = row.createCell(14);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(Short.toString(reportTO.getSignup_from())));
	            cell = row.createCell(15);	
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiTimeStamp(reportTO.getUSER_CREATE_DATE())));

	        }
		   return wb;
	  }

 /* Gets three random deals for index page previously, but not using now */
	public ArrayList<DealTO> getHotDeals(SearchTO searchCriteria) throws ApplicationException {
		ArrayList<DealTO> dealInfo = null;
		try {
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				String[] prices = StringUtils.split(searchCriteria.getPriceStartRate(), ",");
				searchCriteria.setStartPrice(Double.valueOf(prices[0]));
				searchCriteria.setEndPrice(Double.valueOf(prices[1]));
			}
			ArrayList<RestaurantDeal> deals = userDao.getHotDeals(searchCriteria);
			if (deals != null)
				dealInfo = constructDealsFromSearchDeals(deals);
			for (DealTO dealTo : dealInfo) {
				if (dealTo.getUsedDealsQty() != null) {
					dealTo.setRemainingDeals(dealTo.getAvailableDealsQty()
							- dealTo.getUsedDealsQty());
				}
			}
		} catch (ApplicationException e) {
			throw e;
		}
		return dealInfo;
	}
	
	/* Count No. Of deals a guest reserved today (dealid not using) */
	public long countBookedDeals(int userId, int dealId) throws ApplicationException{
		long count = 0;
		try{
			count = userDao.countBookedDeals(userId, dealId);
		}catch (ApplicationException e) {
			throw e;
		}
		return count;
	}
	
	/* Counts how many times the specific deal is booked by user for the specified date */ 
	public long countBookedDealsPerDate(int userId, int dealId, String bookedDate) throws ApplicationException{
	
		long count = 0;
		try{
			count = userDao.countBookedDealsPerDate(userId, dealId, bookedDate);
		}catch (ApplicationException e) {
			throw e;
		}
		return count;
	}

	public ArrayList<ReportTO> getUserBookDealReports(Date startdate,Date enddate) throws ApplicationException {
		// TODO Auto-generated method stub
		
		ArrayList<ReportTO> arrayList=userDao.getUserBookDealReports( startdate, enddate);
		 
		return arrayList;
	}
	/* Prepare an excel sheet for guest deal report */
	public HSSFWorkbook createBookDealWorkbook(ArrayList<ReportTO> userList) throws Exception {
		   HSSFWorkbook wb = new HSSFWorkbook();
		   HSSFSheet sheet = wb.createSheet("Deal Reservation Report Data");

	        /**
	         * Setting the width of the first three columns.
	         */
	        sheet.setColumnWidth(0, 5000);
	        sheet.setColumnWidth(1, 5500);
	        sheet.setColumnWidth(2, 3500);
	        sheet.setColumnWidth(3, 3500);
	        sheet.setColumnWidth(4, 3000);
	        sheet.setColumnWidth(5, 7000);
	        sheet.setColumnWidth(6, 4500);
	        sheet.setColumnWidth(7, 3500);
	        sheet.setColumnWidth(8, 3500);
	        sheet.setColumnWidth(9, 5000);
	        sheet.setColumnWidth(10, 5000);
	        sheet.setColumnWidth(11, 5000);
	        sheet.setColumnWidth(12, 5000);
	        sheet.setColumnWidth(13, 5000);
	        sheet.setColumnWidth(14, 7000);
	        sheet.setColumnWidth(15, 5000);
	        /**
	         * Style for the header cells.
	         */
	        HSSFCellStyle headerCellStyle = wb.createCellStyle();
	        HSSFFont boldFont = wb.createFont();
	        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        boldFont.setColor(HSSFFont.COLOR_RED);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setWrapText(true);
	        HSSFRow row = sheet.createRow(0);
	        HSSFCell cell = row.createCell(0);
	        HSSFCellStyle wraptext = wb.createCellStyle();
	       
	        wraptext.setWrapText(true);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("Host Name"));
	        cell = row.createCell(1);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Restaurant Name"));
	        cell = row.createCell(2);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("City"));
	        cell = row.createCell(3);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("Prefer City"));
	        cell = row.createCell(4);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("Deal ID"));
	        cell = row.createCell(5);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Deal Name"));
	        cell = row.createCell(6);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Deal Reservation Date(mm/dd/yyyy)"));
	        cell = row.createCell(7);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString(" Time"));	    
	        cell = row.createCell(8);
	        cell.setCellStyle(headerCellStyle);	      
	        cell.setCellValue(new HSSFRichTextString("Confirmation Number"));
	        cell = row.createCell(9);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Guest name")); 
	        cell = row.createCell(10);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Guest email"));
	        cell = row.createCell(11);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("SOURCE"));
	        cell = row.createCell(12);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("TangoTab booking Date (mm/dd/yyyy)"));
	        cell = row.createCell(13);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Booked From"));
	        
	        cell=row.createCell(14);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Check-in Status"));
	        	        
	        cell = row.createCell(15);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("SalesRepName"));
	        
	        for (int index = 1; index <= userList.size(); index++) {
	            row = sheet.createRow(index);
	            ReportTO reportTO = (ReportTO) userList.get(index-1);
	            
	            cell = row.createCell(0);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getBUSINESS_NAME()));
	            
	            cell = row.createCell(1);	 
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getLOCATION_REST_NAME()));
	            
	            cell = row.createCell(2);	            
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getCITY_ID()));

	         
	            
	            cell = row.createCell(3);	 
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getPreferCity()));
	            
	            
	            cell = row.createCell(4);	            
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(Integer.toString(reportTO.getREST_DEAL_ID())));
	            
	            
	            cell = row.createCell(5);
	            cell.setCellStyle(wraptext);
	             cell.setCellValue(new HSSFRichTextString(reportTO.getREST_DEAL_NAME()));	            
	            cell = row.createCell(6);	            
	            cell.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiDate(reportTO.getBOOKED_DATE())));
	    	    	            
	            cell = row.createCell(7);	            
	            cell.setCellValue(new HSSFRichTextString(DateConverterUtility.getTimeFromDate(reportTO.getBOOKED_DATE())));
		    	  
	            cell = row.createCell(8);	            
	            cell.setCellValue(new HSSFRichTextString(Integer.toString(reportTO.getCON_RES_ID())));
	 	       
	        
	            
	           
	            cell = row.createCell(9);	 
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getFIRSTNAME()+" "+ reportTO.getLASTNAME()));  
	            cell = row.createCell(10);	   
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getEMAIL_ID()));
	            cell = row.createCell(11);	   
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getReffedBy()));
	             cell = row.createCell(12);	            
	             cell.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiTimeStamp(reportTO.getRESERVED_TIMESTAMP())));
	             
	             cell = row.createCell(13);	   
		            cell.setCellStyle(wraptext);
		            if(reportTO.getSource().equalsIgnoreCase("M"))
		            {
		            	reportTO.setSource("iPhone");
		            }else if (reportTO.getSource().equalsIgnoreCase("F")) {
						reportTO.setSource("Facebook");
					} else
		            	reportTO.setSource("WEB SITE");
		            
		            cell.setCellValue(new HSSFRichTextString(reportTO.getSource()));
		            
		            
		            cell=row.createCell(14);
		            cell.setCellStyle(wraptext);
		           
		             if(reportTO.getIS_CONSUMER_SHOWN_UP()==1)
		            {
		            	reportTO.setCheck_in("Checked In (Manual)");
		            }
		            else if(reportTO.getIS_CONSUMER_SHOWN_UP()==2)
		            {
		            	reportTO.setCheck_in("Checked In (Auto)");
		            }
		            else if(reportTO.getIS_CONSUMER_SHOWN_UP()==3)
		            {
		            	reportTO.setCheck_in("Checked In (User confirmed later)");
		            }
		            else if(reportTO.getIS_CONSUMER_SHOWN_UP()==4)
		            {
		            	reportTO.setCheck_in("Did Not Go (User confirmed later)");
		            }
		            else if(reportTO.getIS_CONSUMER_SHOWN_UP()==-1)
		            {
		            	reportTO.setCheck_in("Cancelled");
		            }
		            else
		            	reportTO.setCheck_in("Claimed");
		            cell.setCellValue(new HSSFRichTextString(reportTO.getCheck_in()));
		            
		            		            
		            cell = row.createCell(15);	            
		            cell.setCellStyle(wraptext);
		            cell.setCellValue(new HSSFRichTextString(reportTO.getSALES_REP_NAME()));
	        }
		   return wb;
	  }
/*
 * save Home Page User
 * */
	public void saveHomeUser(HomeSignUp homeSignUp) throws ApplicationException {
			 try
			 {
					userDao.saveHomeUser(homeSignUp);
			 }catch(Exception ex)
			 {
			ex.printStackTrace();	 
			 }
	}
	/*
	 * 
	 * 
	 * get Home page Sign Up Data
	 */
	public ArrayList<ReportTO> getHomeSignUp() throws ApplicationException 
	{
		ArrayList<ReportTO> arrayList=userDao.getHomeSignUp();
		 
		return arrayList;
	}
	/* Prepare an excel sheet for guest report */
	public HSSFWorkbook createHomeSignUpWorkbook(ArrayList<ReportTO> userList) throws Exception {
		   HSSFWorkbook wb = new HSSFWorkbook();
		   HSSFSheet sheet = wb.createSheet("Home Page Sign Up");

	        /**
	         * Setting the width of the first three columns.
	         */
	        sheet.setColumnWidth(0, 5000);
	        sheet.setColumnWidth(1, 5500);
	        sheet.setColumnWidth(2, 3500);
	        sheet.setColumnWidth(3, 3500); 
	        /**
	         * Style for the header cells.
	         */
	        HSSFCellStyle headerCellStyle = wb.createCellStyle();
	        HSSFFont boldFont = wb.createFont();
	        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        boldFont.setColor(HSSFFont.COLOR_RED);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setWrapText(true);
	        HSSFRow row = sheet.createRow(0);
	        HSSFCell cell = row.createCell(0);
	        HSSFCellStyle wraptext = wb.createCellStyle();
	       
	        wraptext.setWrapText(true);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("Email Id"));
	        cell = row.createCell(1);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("Prefer City"));
	        cell = row.createCell(2);
	        cell.setCellStyle(headerCellStyle);
	        
	        cell.setCellValue(new HSSFRichTextString("User Create Date"));
	        
	  
	        for (int index = 1; index <= userList.size(); index++) {
	            row = sheet.createRow(index);
	            ReportTO reportTO = (ReportTO) userList.get(index-1);
	            
	            cell = row.createCell(0);
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getEMAIL_ID()));
	            
	            cell = row.createCell(1);	 
	            cell.setCellStyle(wraptext);
	            cell.setCellValue(new HSSFRichTextString(reportTO.getPreferCity()));
	            
	             
	            
	             cell = row.createCell(2);	            
	             cell.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiDate(reportTO.getUSER_CREATE_DATE())));
	        }
		   return wb;
	  }
	
	 public DealTO fetchDealByDealId(int dealId, String date) throws ApplicationException
	  {
	    DealTO dealTo = null;
	    try {
	      RestaurantDeal deal = this.userDao.fetchDealByDealId(dealId);
	      if (deal != null) {
	        dealTo = constructDealTO(deal);
	        /* For Future deals */
	        Date date2=new Date();
	        try{
	        	date2 = DateConverterUtility.convertUiToServiceDate(date);
	        }catch (Exception e) {
			}
	        if (date2 != null && date2.compareTo(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate())) > 0){
	        	DateTO dateTO = DateConverterUtility.getDealDay(date2, deal.getAvailableWeekDays(), deal.getAvailableEndTime());
	    		dealTo.setStartDate(dateTO.getDealAvailableDate());
	    		dealTo.setDay(dateTO.getDay());
	        }
	        
	        dealTo.setExpired(false);
			/* For Expired deal */
			if((deal.getRestDealEndDate()).compareTo(DateConverterUtility.convertUiToServiceDate(dealTo.getStartDate())) < 0)
			{
				DateTO dateTO=DateConverterUtility.getLastDealDay(deal.getRestDealEndDate(), deal.getAvailableWeekDays());
				dealTo.setStartDate(dateTO.getDealAvailableDate());
				dealTo.setDay(dateTO.getDay());
				dealTo.setExpired(true);
			}
	      }
	    }
	    catch (ApplicationException e)
	    {
	      throw e;
	    }
	    return dealTo;
	  }

	public ArrayList<DealTO> sendDealexpireMails() throws ApplicationException {
		ArrayList<DealTO> arrayList=new ArrayList<DealTO>();
		  try {
			  arrayList = userDao.sendDealexpireMails();
		      for (DealTO dealTo : arrayList) {
		    	  dealTo.setStartDate(DateConverterUtility.convertDBTimeStampToUiDate(dealTo.getDealStartDate()));
		    	  dealTo.setDealEndDate(DateConverterUtility.convertDBTimeStampToUiDate(dealTo.getRestDealEndDate()));
		    	  dealTo.setAvailableWeekDays(TangoTabUtility.convertWeekDays(dealTo.getAvailableWeekDays()));
		    	  if(dealTo.getLocationphone()==null)
		    	  {
		    		  dealTo.setLocationphone("&nbsp;");
		    	  }
			} 
		    }
		    catch (ApplicationException e)
		    {
		      throw e;
		    }
		
		return arrayList;
	}
	
	public void saveCharityCount(CharityTO charityTO) throws ApplicationException{
		CharityDetails details = new CharityDetails();
		details.setTotalCount(charityTO.getTotalCount());
		try{
			userDao.saveCharityCount(details);
		} 
		catch (ApplicationException e)
		{
			throw e;
		}
		
	}
	
	public Integer getUserIdByMailId(String mailId)throws ApplicationException{
		Integer userId = 0;
		try{
			userId = userDao.getUserIdByMailId(mailId);
		} 
		catch (ApplicationException e)
		{
			throw e;
		}
		return userId;
	}
	
	public ReportTO getOffersDetails(QueryTO queryTO) throws ApplicationException{
		ReportTO report = new ReportTO();
		List<OfferDetailsTO> list = new ArrayList<OfferDetailsTO>();
		Date startDate = queryTO.getStartDate();
		Date backupStartDate = queryTO.getStartDate();
		Date endDate = queryTO.getEndDate();
		Calendar cal = Calendar.getInstance();
		Integer cityId = 0;
		//if(StringUtils.isNotEmpty(queryTO.getCityId()))
		//	cityId = Integer.parseInt(queryTO.getCityId());
		/* If no city selected, then fetch for all cities */
		
		int i = 0;
		for(CityTO cityto : queryTO.getCities()){
			i++;
		cityId = cityto.getCityId();
		cal.setTime(backupStartDate);
		startDate.setTime(cal.getTimeInMillis());
		cal.add(Calendar.HOUR, 24);
		for( ; !startDate.after(endDate); cal.add(Calendar.HOUR, 24)){
			
			try{
				OfferDetailsTO detailsTO = userDao.getOffersDetails(startDate, cityId);
				detailsTO.setCityName(cityto.getCityName());
				list.add(detailsTO);
			
			}catch(ApplicationException e){
				
			}
			
			startDate = cal.getTime();			
		}
	   
		}
		
		report.setOffers(list);	
		return report;
	}
	
	/* Prepare an excel sheet for guest report */
	public HSSFWorkbook createOfferPublishCountWorkbook(ReportTO report) throws Exception {
		   List<OfferDetailsTO> offerList = new ArrayList<OfferDetailsTO>();
		   offerList = report.getOffers();
		   HSSFWorkbook wb = new HSSFWorkbook();
		   HSSFSheet sheet = wb.createSheet("Offers Count details");
      try{
	        /**
	         * 
	         * Style for the header cells.
	         */
	        HSSFCellStyle headerCellStyle = wb.createCellStyle();
	        HSSFCellStyle wraptext = wb.createCellStyle();
	        wraptext.setWrapText(true);
	        HSSFFont boldFont = wb.createFont();
	        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        boldFont.setColor(HSSFFont.COLOR_RED);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setWrapText(true);
	        HSSFRow rowone = sheet.createRow(0);
	        HSSFRow rowtwo = sheet.createRow(1);
	        
	        HSSFCell cell = rowone.createCell(0);
	        cell.setCellStyle(headerCellStyle);
	        cell.setCellValue(new HSSFRichTextString("CityName"));
	        sheet.setColumnWidth(0, 4500);
	        
	        /* Creating headings for excel sheet */
	        int cityId = offerList.get(0).getCityId();
	        for (int index = 1; index <= offerList.size(); index++) {
	        	 OfferDetailsTO detailsTO = (OfferDetailsTO) offerList.get(index-1);
	        	 
	        	if(cityId == detailsTO.getCityId()){
	        		
	        	HSSFCell cell1 = rowone.createCell(index*2-1);
	        	cell1.setCellStyle(headerCellStyle);
		        cell1.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiDate(detailsTO.getDate())));
		        
		        HSSFCell cell2 = rowone.createCell(index*2);
		        cell2.setCellStyle(headerCellStyle);
		        cell2.setCellValue(new HSSFRichTextString(DateConverterUtility.convertDBTimeStampToUiDate(detailsTO.getDate())));
		        
		        
		        HSSFCell cell3 = rowtwo.createCell(index*2-1);
		        cell3.setCellStyle(wraptext);
		        cell3.setCellValue(new HSSFRichTextString("PublishedOffers"));
		        
		        
		        HSSFCell cell4 = rowtwo.createCell(index*2);
		        cell4.setCellStyle(wraptext);
		        cell4.setCellValue(new HSSFRichTextString("AvailableOffers"));
		        
		        sheet.addMergedRegion(new Region(0,(short)(index*2-1),0,(short)(index*2)));
		        sheet.setColumnWidth(index*2-1, 4500);
		        sheet.setColumnWidth(index*2, 4500);
		       
	        	}else
	        		break;
	        	
	        }
	       
	        /* Fill up the data */ 
	        int rowIndex = 2;
	        int colIndex = 1;
	        HSSFRow nextRow = sheet.createRow(rowIndex);
	        for (int index = 1; index <= offerList.size(); index++) {
	        		        	
	        	 OfferDetailsTO detailsTO = (OfferDetailsTO) offerList.get(index-1);
	        	if(index == 1){
	        		HSSFCell cell3 = nextRow.createCell(0);
	 		        cell3.setCellStyle(wraptext);
	 		        cell3.setCellValue(new HSSFRichTextString(detailsTO.getCityName()));
	        	}
	        	if(cityId != detailsTO.getCityId()){
	        		rowIndex += 1;
	        		colIndex = 1;
	        		nextRow = sheet.createRow(rowIndex);
	        		cityId = detailsTO.getCityId(); 
	        		
	        		HSSFCell cell3 = nextRow.createCell(0);
	 		        cell3.setCellStyle(wraptext);
	 		        cell3.setCellValue(new HSSFRichTextString(detailsTO.getCityName()));
	        			        
	             }	            	 
	            	 		        
	        		HSSFCell cell1 = nextRow.createCell(colIndex*2-1);
		        	cell1.setCellStyle(wraptext);
			        cell1.setCellValue(new HSSFRichTextString(detailsTO.getPublishedCount().toString()));
			        
			        HSSFCell cell2 = nextRow.createCell(colIndex*2);
			        cell2.setCellStyle(wraptext);
			        cell2.setCellValue(new HSSFRichTextString(detailsTO.getAvailableCount().toString()));
			        
			        sheet.setColumnWidth(index*2-1, 4500);
			        sheet.setColumnWidth(index*2, 4500);
			        colIndex++;        	
	        		
	        }	        
      }catch(Exception e){
    	  e.printStackTrace();
      }
		   return wb;
	  }
	
	public ArrayList<RevenueReportTO> getRevenueReport(QueryTO queryTO) throws ApplicationException{
		ArrayList<RevenueReportTO> report = new ArrayList<RevenueReportTO>();
		try{
			report = userDao.getRevenueReport(queryTO);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return report;
		
	}
	
	public HSSFWorkbook generateRevenueReportWorkbook(ArrayList<RevenueReportTO> report) throws ApplicationException {
		ArrayList<RevenueReportTO> reports = report;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Host Revenue Report");
		try{
			for(int heading = 0; heading < 9; heading++){
				sheet.setColumnWidth(heading, 4000);
			}
	        /**
	         * Style for the header cells.
	         */
	        HSSFCellStyle headerCellStyle = wb.createCellStyle();
	        HSSFFont boldFont = wb.createFont();
	        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        boldFont.setColor(HSSFFont.COLOR_RED);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setFont(boldFont);
	        headerCellStyle.setWrapText(true);	        
	           
	        HSSFCellStyle wraptext = wb.createCellStyle();
	        wraptext.setWrapText(true);
	        
	        HSSFRow row = sheet.createRow(0);
	        
	        for(int heading= 0; heading <9; heading++){
	        	HSSFCell cell = row.createCell(heading);
		        cell.setCellStyle(headerCellStyle);
		        switch(heading){
		        case 0:
		        	cell.setCellValue(new HSSFRichTextString("BusinessName"));
		        	break;
		        case 1:
		        	cell.setCellValue(new HSSFRichTextString("City"));
		        	break;
		        case 2:
		        	cell.setCellValue(new HSSFRichTextString("State"));
		        	break;
		        case 3:
		        	cell.setCellValue(new HSSFRichTextString("AmountCharged"));
		        	break;
		        case 4:
		        	cell.setCellValue(new HSSFRichTextString("Accured # of Credits"));
		        	break;
		        case 5:
		        	cell.setCellValue(new HSSFRichTextString("# of deals Published"));
		        	break;
		        case 6:
		        	cell.setCellValue(new HSSFRichTextString("# of deals Reserved "));
		        	break;
		        case 7:
		        	cell.setCellValue(new HSSFRichTextString("Revenue"));
		        	break;
		        case 8:
		        	cell.setCellValue(new HSSFRichTextString("CreditsUnused"));
		        	break;
		        }
			} 
	        
	        if(reports != null && reports.size() > 0)
	        	for(int rows = 1; rows < reports.size(); rows++){
	        		HSSFRow nextRow = sheet.createRow(rows);
	        		
	        		for(int col=0; col<9; col++){
	        		HSSFCell cell = nextRow.createCell(col);
		            cell.setCellStyle(wraptext);
		            switch(col){
		            case 0:
		            	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getBUSINESS_NAME()));
			        	break;
			        case 1:
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getCity_id()));
			        	break;
			        case 2:
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getState()));
			        	break;
			        case 3:
			        	if(reports.get(rows-1).getAmountCharged() != null)
			        	 cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getAmountCharged().toString()));
			        	break;
			        case 4:
			        	if(reports.get(rows-1).getAccuredCredits() != null)
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getAccuredCredits().toString()));
			        	break;
			        case 5:
			        	if(reports.get(rows-1).getPublishedDeals() != null)
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getPublishedDeals().toString()));
			        	break;
			        case 6:
			        	if(reports.get(rows-1).getNoOfDealsReserved() != null)
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getNoOfDealsReserved().toString()));
			        	break;
			        case 7:
			        	if(reports.get(rows-1).getRevenue() != null)
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getRevenue().toString()));
			        	break;
			        case 8:
			        	if(reports.get(rows-1).getCURRENT_CREDITS() != null)
			        	cell.setCellValue(new HSSFRichTextString(reports.get(rows-1).getCURRENT_CREDITS().toString()));
			        	break;		            
		            }
		            
	        		}
	        	}
	        
			
		}catch(Exception e){
			log.error("RevenuReport BOIMPL",e);
		}
		return wb;
	}
	private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		  double theta = lon1 - lon2;
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  if (unit == 'K') {
		    dist = dist * 1.609344;
		  } else if (unit == 'N') {
		  	dist = dist * 0.8684;
		    }
		  DecimalFormat twoDForm = new DecimalFormat("#.##");
			return Double.valueOf(twoDForm.format(dist));
		 
		}
		private double deg2rad(double deg) {
			  return (deg * Math.PI / 180.0);
			}

			/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
			/*::  This function converts radians to decimal degrees             :*/
			/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
			private double rad2deg(double rad) {
			  return (rad * 180.0 / Math.PI);
			}
	/*public static void main(String args[])throws ApplicationException{
		ConfigBO configBO=new ConfigBOImpl();
		UserBO user = new UserBOImpl();
		ConfigPojo configPojo=	configBO.getConfigDetails();
		try{
			user.autoDebitTransactions(43, configPojo);
		}catch(Exception e){
			
		}
	}*/
			
			 @Override
			    public long countRestaurantByName(String searchname) throws ApplicationException {
			        return userDao.countRestaurantByName(searchname);
			    }

			    @Override
			    public long countAllRestaurants() throws ApplicationException {
			        return userDao.countAllRestaurants();
			    }

			    @Override
			    public RestaurantCcProfile getCcProfile(int i) throws ApplicationException {
			        return userDao.getCcProfile(i);
			    }

			    @Override
			    public List<RestaurantLocation> getLocationManagers(Integer restaurantId) throws ApplicationException {
			        return userDao.getLocationManagers(restaurantId);
			    }

			    @Override
			    public int checkAvailability(String from) throws ApplicationException {
			        return userDao.checkAvailability(from);
			    }

			    @Override
			    public String getUserName(String from) throws ApplicationException {
			        return userDao.getUserName(from);
			    }

			    @Override
			    public  ArrayList<RestaurantLocationPreference>  getCuisinesByLocationId(Integer locid) throws ApplicationException {
			        return userDao.getCuisinesByLocationId(locid);
			    }
public boolean updateOfferConfirmationStatus(int conresId, String status)throws ApplicationException{
	boolean updated = false;
	short newstatus = 0;
	if(status.equals("cancel"))
		 newstatus = -1;
	if(status.equals("claim"))
		newstatus = 0;
	try{
		updated = userDao.updateOfferConfirmationStatus(conresId, newstatus );
		/* if the offer cancelled then add credits to host */
		if(newstatus == -1 && updated){
			addCreditsToHost(conresId);
		}
	} 
	catch (ApplicationException e)
	{
		throw e;
	}
	return updated;
				
}

/*  Need to addCreditsToHost in this method  */

public boolean addCreditsToHost(int conresId)throws ApplicationException{
	ConsumerReservation reservation = new ConsumerReservation();
	RestaurantTransaction transaction = new RestaurantTransaction();
	TransactionBO transactionBO=com.tangotab.businessImpl.BusinessFactory.getTransactionBO();
	try{
		
	/* make a transaction to add one credit back to host */
	reservation = userDao.getReservationDetails(conresId);
	
	/* getting restaurant by consumer reservation id */
	Restaurant restaurant = userDao.getRestaurantByConResId(conresId);
	User user = reservation.getUser();
	
	if(reservation != null){
		
		/* Transaction details */
		transaction.setTypeOfTrans("Cr");
		transaction.setTransDate(new java.sql.Timestamp(new Date().getTime()));
		transaction.setNoOfCredits(1);
		transaction.setAmount(0);
		transaction.setRemarks(conresId+" has cancelled offer");
		transaction.setDescription("OfferCancelled for "+conresId);
		
		transaction.setCurrentCredits(((Double)(restaurant.getCurrentCredits()+1)).intValue());
		transaction.setUser(user);
		transaction.setRestaurant(restaurant);
		transactionBO.saveRestaurantTransactions(transaction);
		userDao.updateHostCredits(restaurant.getRestaurantId());
		return true;
	}
	}catch(Exception e){
		e.printStackTrace();
		log.error("addCreditsToHost",e);
		
	}
	return false;
	
	}

			public LandingTO getLandingBySource(String source) throws ApplicationException {
				
				LandingTO landingTO=new LandingTO();
				try{
					Landing landing=new Landing();
					landing=userDao.getLandingBySource(source.split("-")[0]);
					BeanUtils.copyProperties(landingTO, landing);
					
				}catch (Exception e) {
					// TODO: handle exception
				}
				return landingTO;		
			}
			public LandingTO getLandingByRefferCode(int refferCode) throws ApplicationException {
				
				LandingTO landingTO=new LandingTO();
				try{
					Landing landing=new Landing();
					landing=userDao.getLandingByRefferCode(refferCode);
					BeanUtils.copyProperties(landingTO, landing);
					
				}catch (Exception e) {
					// TODO: handle exception
				}
				return landingTO;		
			}

@Override
public ArrayList<ConsumerReservationTO> getRestaurantUserHistory(
		int restaurantId) throws ApplicationException {
	
	ArrayList<ConsumerReservationTO> userdealsTO = new ArrayList<ConsumerReservationTO>();
	ArrayList<ConsumerReservation> userdeals = null;

	try {
	  userdeals = userDao.getRestaurantUserDealHistory( restaurantId);
	   for (ConsumerReservation cr : userdeals) {
		ConsumerReservationTO crTO = new ConsumerReservationTO();
         
		crTO.setConResId(cr.getConResId());
		crTO.setUser(cr.getUser());
		crTO.setRestaurantDeal(cr.getRestaurantDeal());
		crTO.setIsConsumerShownUp(cr.getIsConsumerShownUp());
		/* Converting the Time format to U.S time for display */
		crTO.setReservedTimestamp(DateConverterUtility.convertDBTimeStampToUiDate(cr
				.getReservedTimestamp()));
		/* test if the offer is available or not */
		if( new java.sql.Timestamp(new Date().getTime()).after( cr.getBookedTimestamp()) )
		  crTO.setExpired(true);
		else
			crTO.setExpired(false);
		
		userdealsTO.add(crTO);
	}
	} catch (ApplicationException e) {
	if (log.isErrorEnabled()) {
		log.error("Got following error while retrieving restaurant details Message: "
				+ e.getMessage());
	}
	throw e;
	}
	return userdealsTO;
	}

	@Override
	public ArrayList<ConsumerReservationTO> getRestaurantUserHistory(
			int restaurantId, Date startDate, Date endDate)
			throws ApplicationException {
		ArrayList<ConsumerReservationTO> userdealsTO = new ArrayList<ConsumerReservationTO>();
		ArrayList<ConsumerReservation> userdeals = null;
		try {
			userdeals = userDao.getRestaurantUserDealHistory(restaurantId,
					startDate, endDate);
			for (ConsumerReservation cr : userdeals) {
				ConsumerReservationTO crTO = new ConsumerReservationTO();

				crTO.setConResId(cr.getConResId());
				crTO.setUser(cr.getUser());
				crTO.setRestaurantDeal(cr.getRestaurantDeal());
				crTO.setIsConsumerShownUp(cr.getIsConsumerShownUp());
				/* Converting the Time format to U.S time for display */
				crTO.setReservedTimestamp(DateConverterUtility
						.convertDBTimeStampToUiDate(cr.getReservedTimestamp()));
				/* test if the offer is available or not */
				if (new java.sql.Timestamp(new Date().getTime()).after(cr
						.getBookedTimestamp()))
					crTO.setExpired(true);
				else
					crTO.setExpired(false);

				userdealsTO.add(crTO);
			}
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving restaurant details Message: ",
								 e.getMessage());
			}
			throw e;
		}
		return userdealsTO;
	}
	
 }




