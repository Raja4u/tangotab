package com.tangotab.daoImpl;

import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tangotab.TO.BookDealTO;
import com.tangotab.TO.CityTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.OfferDetailsTO;
import com.tangotab.TO.QueryTO;
import com.tangotab.TO.ReportTO;
import com.tangotab.TO.RevenueReportTO;
import com.tangotab.TO.SearchTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.ConfigBO;
import com.tangotab.businessImpl.ConfigBOImpl;
import com.tangotab.dao.UserDAO;
import com.tangotab.dao.pojo.AmbReferences;
import com.tangotab.dao.pojo.Ambassador;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.dao.pojo.CharityDetails;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.dao.pojo.ConsumerReferral;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.ExternalReferral;
import com.tangotab.dao.pojo.HomeSignUp;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantCC;
import com.tangotab.dao.pojo.RestaurantCcProfile;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.RestaurantDealHistory;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantLocationPreference;
import com.tangotab.dao.pojo.RestaurantPaymentProfile;
import com.tangotab.dao.pojo.SalesManagerInfo;
import com.tangotab.dao.pojo.SalesRepresentInfo;
import com.tangotab.dao.pojo.Support;
import com.tangotab.dao.pojo.User;
import com.tangotab.dao.pojo.UserValidationCode;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

@Component
public class UserDAOImpl extends BaseDAOImpl<User, Integer> implements UserDAO {
	private Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
 
	/**
	 * 
	 * 
	 * Get user by email and Password
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getUser(String emailId, String password) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getUser ");
		ArrayList<User> users = null;
		Session session = getSession(false);
		if (session.contains(User.class)) {
			session.evict(User.class);
		}
		if (emailId != null && emailId.trim().length() > 0 && password != null
				&& password.trim().length() > 0) {
			try {
				Criteria criteria = session.createCriteria(User.class).add(
						Restrictions.eq("emailId", emailId.trim())).add(
						Restrictions.eq("password", password.trim()));

				users = (ArrayList<User>) criteria.list();
			} catch (Exception e) {
				if (log.isErrorEnabled()) {
					log.error("Error occured in getUser" + e.getMessage());
				}
				e.printStackTrace();
				throw new ApplicationException("DB003", TangotabConstants.ERROR);
			} finally {
				
			}
		}
		return users;
	}

	/**
	 * 
	 * 
	 * Get user by email , Password and role id 
	 */
	public User getUser(String emailId, String password, int roleId) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getUser ");
		User user = null;
		Session session = getSession(false);
		if (session.contains(User.class)) {
			session.evict(User.class);
		}
		if (emailId != null && emailId.trim().length() > 0 && password != null
				&& password.trim().length() > 0) {
			try {
				Criteria criteria = session.createCriteria(User.class).add(
						Restrictions.eq("emailId", emailId.trim())).add(
						Restrictions.eq("password", password.trim())).add(
						Restrictions.eq("role.roleId", roleId));

				user = (User) criteria.uniqueResult();
	 
					updateWebLoginCount(user.getUserId());
		 
			} catch (Exception e) {
				if (log.isErrorEnabled()) {
					log.error("Error occured in getUser" + e.getMessage());
				}
				e.printStackTrace();
				throw new ApplicationException("DB003", TangotabConstants.ERROR);
			} finally {
				
			}
		}
		return user;
	}

	/**
	 * 
	 * 
	 * Save Consumer
	 */
	public int saveConsumer(User consumer) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveConsumer ");
		Session session = getSession(false);
		
		try {
			session.save(consumer);
			
			SQLQuery query = session.createSQLQuery(TangotabConstants.INSERT_USER_SOURCE);
			query.setShort(0, consumer.getSignup_from());
			query.setInteger(1, consumer.getUserId());
			query.executeUpdate();
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return consumer.getUserId();
	}

	/**
	 * Save  Restaurant_location
	 */
	public int saveLocation(User locationManagerWithLocationDeails) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		
		try {
			session.save(locationManagerWithLocationDeails);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return locationManagerWithLocationDeails.getUserId();
	}

	/**
	 * user restaurant
	 */
	public int saveRestaurant(User restOwnerWithRestDetails) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveRestaurantOwner ");
		Session session = getSession(false);
		
		try {
			restOwnerWithRestDetails = (User) session.merge(restOwnerWithRestDetails);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveRestaurantOwner" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return restOwnerWithRestDetails.getUserId();
	}

	/*
	 * Update consumer details 
	 * */
	public int updateConsumer(User consumer) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateConsumer ");
		Session session = getSession(false);
		
		try {
			session.update(consumer);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}
		return consumer.getUserId();
	}

	/*
	 * update location details 
	 * */
	public int updateLocation(User locationManager) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateLocation");
		Session session = getSession(false);
		
		try {
			session.save(locationManager);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateLocation" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return locationManager.getUserId();
	}

	/*
	 * Update the business name details 
	 * */
	public void updateRestaurant(User user) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateRestaurant");
		Session session = getSession(false);
 
		
		try {
			session.merge(user);
			
			updateRestaurantEmail(user);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveRestaurantOwner" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	/*
	 * Updating the host EmailId for the Business Name. (changing host by admin)
	 * */
	private void updateRestaurantEmail(User user) throws ApplicationException {

		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.UPDATE_USER_EMAIL);
			query.setParameter(0, user.getEmailId());
			query.setParameter(1, user.getUserId());
			query.executeUpdate();
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveRestaurantOwner" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	/*
	 *  Delete the preferences for consumer, if they change the preferences
	 * */
	public void deleteConsumerPreferences(int consumerID) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of deleteConsumerPreferences");
		Session session = getSession(false);
		
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.DELETE_CONSUMER_PREFERENCES_QUERY);
			query.setParameter(0, consumerID);
			query.executeUpdate();
			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	/*
	 *  Get the business details for the Host specified 
	 * */
	public Restaurant getRestaurantId(int userId) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of deleteConsumerPreferences");
		Session session = getSession(false);
		Restaurant restaurant = null;
		try {
			restaurant = (Restaurant) session.load(Restaurant.class, userId);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return restaurant;
	}

	/*
	 * Get password for user 
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getPassword(String emailId) throws ApplicationException {
		String currentPassword = null;
		Session session = getSession(false);
		ArrayList<User> users = new ArrayList<User>();
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.FORGOT_PASSWORD_SELECT_QUERY);
			query.setParameter(0, emailId);
			List results = query.list();
			Iterator itr = results.iterator();

			while (itr.hasNext()) {
				User user = new User();
				Object[] columns = (Object[]) itr.next();
				currentPassword = (String) columns[0];
				user.setPassword(currentPassword);
				user.setRoleId((Integer) columns[1]);
				users.add(user);
			}

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return users;
	}

	/*
	 * Reset password for the user for all roles 
	 * */
	public boolean resetPassword(String emailId, String currentPassword, String newPassword)
			throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.RESET_PASSWORD_UPDATE_QUERY);
			query.setString(0, newPassword);
			query.setString(1, emailId);
			query.setString(2, currentPassword);
			int rows = query.executeUpdate();
			
			return rows > 0 ? true : false;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	/*
	 * If guest forgots password, then assign a new password 
	 * */
	public boolean resetPassword(String emailId, String newPassword) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.FORGOT_PASSWORD_UPDATE_QUERY);
			query.setString(0, newPassword);
			query.setString(1, emailId);

			int rows = query.executeUpdate();
			
			return rows > 0 ? true : false;
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	/* Change the status of the user */
	public boolean setUserStatus(String emailId, short status, int roleId)
			throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.USER_STATUS_UPDATE_QUERY_ROLE);
			query.setShort(0, status);
			query.setString(1, emailId);
			query.setInteger(2, roleId);

			int rows = query.executeUpdate();
			
			if (rows > 0) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;
	}

	
	/* Change the status of the user */
	public boolean getUserStatus(String emailId,  int roleId)
			throws ApplicationException {
		Session session = getSession(false);
		
		Boolean status = false;
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.GET_USER_STATUS_QUERY);
			query.setString(0, emailId);
			query.setShort(1, (short)roleId);
		 

			List results = query.list();
			Iterator iter = results.iterator();
			if(iter.hasNext()){
			 
				status = true;
			}
			//
			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return status;
	}
	
	public boolean activateUser(String emailId, int roleId) throws ApplicationException {
		return setUserStatus(emailId, (short) 1, roleId);
	}

	public boolean deactivateUser(String emailId, int roleId) throws ApplicationException {
		return setUserStatus(emailId, (short) 0, 4);
	}

	/* If user password status is '0' then he is new user otherwise it is '1' */
	public boolean setUserPwdStatus(String emailId, short pstatus) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.USER_PWD_STATUS_UPDATE_QUERY);
			query.setShort(0, pstatus);
			query.setString(1, emailId);
			int rows = query.executeUpdate();
			
			if (rows > 0) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;

	}
	/* If user password status is '0' then he is new user otherwise it is '1' specific to roleId  */
	public boolean setUserConsumerStatus(String emailId, short pstatus, int roleId)
			throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.CONSUMER_STATUS_UPDATE_QUERY);
			query.setShort(0, pstatus);
			query.setString(1, emailId);
			query.setInteger(2, roleId);
			int rows = query.executeUpdate();
			
			if (rows > 0) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;

	}

	public boolean deleteValidationCode(String emailId, String password, String validationCode)
			throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.VALIDATION_CODE_DELETE_QUERY);
			query.setParameter(0, emailId);
			query.setParameter(1, password);
			query.setParameter(2, validationCode);

			int rows = query.executeUpdate();
			
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;
	}

	/* Verify validation code */
	@SuppressWarnings("unchecked")
	public boolean verifyValidationCode(String emailId, String password, String validationCode)
			throws ApplicationException {
		Session session = getSession(false);
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.VALIDATION_CODE_SELECT_QUERY);
			query.setParameter(0, emailId);
			query.setParameter(1, password);
			query.setParameter(2, validationCode);
			List results = query.list();
			Iterator itr = results.iterator();
			int count = 0;
			if (itr.hasNext()) {
				Object columns = (Object) itr.next();

				count = ((BigInteger) columns).intValue();
			}
			if (count > 0) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;
	}

	/* No. of created locations at present for the restaurant */
	@SuppressWarnings("unchecked")
	public int getNoEnteredLocations(int restaurentID) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getNoEnteredLocations");
		Session session = getSession(false);
		int status = 0;
		try {
			Criteria criteria = session.createCriteria(RestaurantLocation.class, "location")
					.createAlias("location.restaurant", "restauerant").add(
							Restrictions.eq("restauerant.restaurantId", restaurentID));
			List<RestaurantLocation> locations = criteria.list();
			if (null != locations && locations.size() > 0)
				status = locations.size();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return status;
	}

	/* search deals old method */
	@SuppressWarnings({ "unchecked", "static-access" })
	public ArrayList<RestaurantDeal> searchDeals(SearchTO searchCriteria)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");

			criteria.createAlias("deal.restaurantLocation", "restaurantLocation");
			criteria.createAlias("restaurantLocation.user", "user");
			List<Criterion> criterions = new ArrayList<Criterion>();

			if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
				criteria.createAlias("restaurantLocation.city", "city");
				criterions.add(Restrictions.eq("city.cityName", searchCriteria.getCityName()));
			}
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				criterions.add(Restrictions.eq("restaurantLocation.zipCode", searchCriteria
						.getZipCode()));
			}
			Disjunction disjunction = Restrictions.disjunction();
			for (Criterion criterion : criterions) {
				disjunction.add(criterion);
			}
			criteria.add(disjunction);
			Conjunction con = Restrictions.conjunction();
			Conjunction con1 = Restrictions.conjunction();
			Disjunction dis = Restrictions.disjunction();
			criterions = new ArrayList<Criterion>();
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				List<Criterion> priceCriterions = new ArrayList<Criterion>();
				priceCriterions.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getStartPrice()));
				priceCriterions.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getStartPrice()));
				List<Criterion> priceCriterions1 = new ArrayList<Criterion>();
				priceCriterions1.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getEndPrice()));
				priceCriterions1.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getEndPrice()));
				for (Criterion criterion : priceCriterions) {
					con.add(criterion);
				}
				for (Criterion criterion : priceCriterions1) {
					con1.add(criterion);
				}
			}
			dis.add(con);
			dis.add(con1);

			if (searchCriteria.getCuisineType() != 0) {
				criteria.createAlias("restaurantLocation.locationPreferences",
						"locationPreferences");
				criteria.createAlias("locationPreferences.cuisineTypeId", "cusineType",
						criteria.INNER_JOIN, Restrictions.eq("cuisineTypeId", searchCriteria
								.getCuisineType()));
			}

			if (searchCriteria.getDiningStyle() != 0) {
				criteria.createAlias("restaurantLocation.diningPreferences", "diningPreferences");
				criteria.createAlias("diningPreferences.cuisineTypeId", "dining",
						criteria.INNER_JOIN, Restrictions.eq("diningStyleId", searchCriteria
								.getDiningStyle()));
			}
			if (searchCriteria.getRating() != 0) {
				criterions.add(Restrictions.eq("restaurantLocation.rating", searchCriteria
						.getRating()));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			criteria.add(dis);
			criteria.add(Restrictions.eq("deal.restDealPublishStatus",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			criteria.add(Restrictions.eq("restaurantLocation.isActive",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			Calendar calendar = Calendar.getInstance();
			Date today = new Date();
			calendar.setTime(today);
			calendar.add(Calendar.HOUR, -24);
			today = calendar.getTime();
			criteria.add(Restrictions
					.gt("deal.restDealEndDate", new java.sql.Date(today.getTime())));
			Disjunction dsj = Restrictions.disjunction();
			for(int i = 0; i < 7; i++){
				String s1 =DateConverterUtility.getDayNumber(calendar.getTime()); 
				java.sql.Date dd = new java.sql.Date(today.getTime());
				Conjunction cons = Restrictions.conjunction();
				List<Criterion> dateCriterions = new ArrayList<Criterion>();
				dateCriterions.add(Restrictions
						.gt("deal.restDealEndDate", dd  ));
				dateCriterions.add(Restrictions
						.like("deal.availableWeekDays", "%"+s1+"%" ));
				for(Criterion cr:dateCriterions)
					cons.add(cr);
				dsj.add(cons);
				calendar.add(Calendar.DATE, 1);
				today = calendar.getTime();
			}
			criteria.add(dsj);
			criteria.addOrder(Order.asc("restaurantLocation.cityId"));

			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return deals;

	}
	
	/*
	 *  search deals for pagination 
	 * */
	@SuppressWarnings({ "unchecked", "static-access" })
	public ArrayList<RestaurantDeal> searchDeals(SearchTO searchCriteria, int currentPage)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");

			criteria.createAlias("deal.restaurantLocation", "restaurantLocation");
			criteria.createAlias("restaurantLocation.restaurant", "rest");
			criteria.createAlias("restaurantLocation.user", "user");
			
			
			List<Criterion> criterions = new ArrayList<Criterion>();

			if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
				criteria.createAlias("restaurantLocation.city", "city");
				criterions.add(Restrictions.eq("city.cityName", searchCriteria.getCityName()));
			}
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				criterions.add(Restrictions.eq("restaurantLocation.zipCode", searchCriteria
						.getZipCode()));
			}
			if( searchCriteria.getEventId() > 0){
				criteria.createAlias("deal.dealEvent", "dealevent");
				criteria.createAlias("dealevent.events", "event");
				criteria.add(Restrictions.eq("event.eventId", searchCriteria.getEventId()));
			}
			/**/if( StringUtils.isNotEmpty(searchCriteria.getRestauntName() )){
				criteria.add(Restrictions.eq("restaurantLocation.locationRestName", searchCriteria.getRestauntName()));
			}
			Disjunction disjunction = Restrictions.disjunction();
			for (Criterion criterion : criterions) {
				disjunction.add(criterion);
			}
			criteria.add(disjunction);
			Conjunction con = Restrictions.conjunction();
			Conjunction con1 = Restrictions.conjunction();
			Disjunction dis = Restrictions.disjunction();
			criterions = new ArrayList<Criterion>();
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				List<Criterion> priceCriterions = new ArrayList<Criterion>();
				priceCriterions.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getStartPrice()));
				priceCriterions.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getStartPrice()));
				List<Criterion> priceCriterions1 = new ArrayList<Criterion>();
				priceCriterions1.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getEndPrice()));
				priceCriterions1.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getEndPrice()));
				for (Criterion criterion : priceCriterions) {
					con.add(criterion);
				}
				for (Criterion criterion : priceCriterions1) {
					con1.add(criterion);
				}
			}
			dis.add(con);
			dis.add(con1);

			if (searchCriteria.getCuisineType() != 0) {
				criteria.createAlias("restaurantLocation.locationPreferences",
						"locationPreferences");
				criteria.createAlias("locationPreferences.cuisineTypeId", "cusineType",
						criteria.INNER_JOIN, Restrictions.eq("cuisineTypeId", searchCriteria
								.getCuisineType()));
			}

			if (searchCriteria.getDiningStyle() != 0) {
				criteria.createAlias("restaurantLocation.diningPreferences", "diningPreferences");
				criteria.createAlias("diningPreferences.cuisineTypeId", "dining",
						criteria.INNER_JOIN, Restrictions.eq("diningStyleId", searchCriteria
								.getDiningStyle()));
			}
			if (searchCriteria.getRating() != 0) {
				criterions.add(Restrictions.eq("restaurantLocation.rating", searchCriteria
						.getRating()));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			criteria.add(dis);
			criteria.add(Restrictions.eq("deal.restDealPublishStatus",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			criteria.add(Restrictions.eq("restaurantLocation.isActive",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			
			DetachedCriteria maxdebit = DetachedCriteria.forClass(ConfigPojo.class)
		    .setProjection( Property.forName("creditUserDeal"));
			Conjunction crconj = Restrictions.conjunction();
			List<Criterion> credits = new ArrayList<Criterion>();
		    credits.add( Property.forName("rest.currentCredits").ge(maxdebit) );
		    credits.add(Restrictions.eq("rest.billingMethodId", 1));
		    for(Criterion credit:credits){
		    	crconj.add(credit);
		    }
		    Disjunction crdisj = Restrictions.disjunction();
		    crdisj.add(crconj);
		    crdisj.add(Restrictions.eq("rest.billingMethodId", 2));
		    criteria.add(crdisj);
		    
			criteria.add(Restrictions.gtProperty("deal.availableDealsQty", "deal.usedDealsQty"));
			Calendar calendar = Calendar.getInstance();
			Date today = new Date();
			calendar.setTime(today);
			/* restDealEndDate is set to that date and 00 hrs and 00 mins
			 * and to get current day deals */
			calendar.add(Calendar.HOUR, -24);
			today = calendar.getTime();
			criteria.add(Restrictions
					.gt("deal.restDealEndDate", today));
			/* Here is the filtration for deals whose availability is not there for today
			 * (availableweekdays) but end date is farther. In that case the deal is tested for
			 * today availability and if available then tat date is less than end date, like tat 
			 * it is tested for (mon,tues,..,sun). */
			Disjunction dsj = Restrictions.disjunction();
			for(int i = 0; i < 7; i++){
				String s1 =DateConverterUtility.getDayNumber(calendar.getTime()); 
				java.sql.Date dd = new java.sql.Date(today.getTime());
				Conjunction cons = Restrictions.conjunction();
				List<Criterion> dateCriterions = new ArrayList<Criterion>();
				dateCriterions.add(Restrictions
						.gt("deal.restDealEndDate", dd  ));
				/* Even though the date is checked for greater than one day before, 
				 * but availability is checked from today's day */
				Integer I = Integer.parseInt(s1);
				I = I + 1;
				if(I >7)
					I = I - 7;
				s1 = I.toString();
				dateCriterions.add(Restrictions
						.like("deal.availableWeekDays", "%"+s1+"%" ));
				for(Criterion cr:dateCriterions)
					cons.add(cr);
				dsj.add(cons);
				calendar.add(Calendar.DATE, 1);
				today = calendar.getTime();
			}
			criteria.add(dsj);
			
			criteria.addOrder(Order.asc("restaurantLocation.cityId"));
			currentPage -= 1;
			criteria.setFirstResult(currentPage*TangotabConstants.PAGE_SIZE);
			criteria.setMaxResults(TangotabConstants.PAGE_SIZE);

			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return deals;

	}

	/* To count number of pages */
	@SuppressWarnings({ "static-access" })
	public Long countSearchDeals(SearchTO searchCriteria)
			throws ApplicationException {
		Session session = getSession(false);
		Long l ;
		try {
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");

			criteria.createAlias("deal.restaurantLocation", "restaurantLocation");
			criteria.createAlias("restaurantLocation.restaurant", "rest");
			criteria.createAlias("restaurantLocation.user", "user");
			
			
			List<Criterion> criterions = new ArrayList<Criterion>();

			if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
				criteria.createAlias("restaurantLocation.city", "city");
				criterions.add(Restrictions.eq("city.cityName", searchCriteria.getCityName()));
			}
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				criterions.add(Restrictions.eq("restaurantLocation.zipCode", searchCriteria
						.getZipCode()));
			}
			if( searchCriteria.getEventId() > 0){
				criteria.createAlias("deal.dealEvent", "dealevent");
				criteria.createAlias("dealevent.events", "event");
				criteria.add(Restrictions.eq("event.eventId", searchCriteria.getEventId()));
			}
			
			/* */if( StringUtils.isNotEmpty(searchCriteria.getRestauntName() )){
				criteria.add(Restrictions.eq("restaurantLocation.locationRestName", searchCriteria.getRestauntName()));
			}
			
			Disjunction disjunction = Restrictions.disjunction();
			for (Criterion criterion : criterions) {
				disjunction.add(criterion);
			}
			criteria.add(disjunction);
			Conjunction con = Restrictions.conjunction();
			Conjunction con1 = Restrictions.conjunction();
			Disjunction dis = Restrictions.disjunction();
			criterions = new ArrayList<Criterion>();
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				List<Criterion> priceCriterions = new ArrayList<Criterion>();
				priceCriterions.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getStartPrice()));
				priceCriterions.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getStartPrice()));
				List<Criterion> priceCriterions1 = new ArrayList<Criterion>();
				priceCriterions1.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getEndPrice()));
				priceCriterions1.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getEndPrice()));
				for (Criterion criterion : priceCriterions) {
					con.add(criterion);
				}
				for (Criterion criterion : priceCriterions1) {
					con1.add(criterion);
				}
			}
			dis.add(con);
			dis.add(con1);

			if (searchCriteria.getCuisineType() != 0) {
				criteria.createAlias("restaurantLocation.locationPreferences",
						"locationPreferences");
				criteria.createAlias("locationPreferences.cuisineTypeId", "cusineType",
						criteria.INNER_JOIN, Restrictions.eq("cuisineTypeId", searchCriteria
								.getCuisineType()));
			}

			if (searchCriteria.getDiningStyle() != 0) {
				criteria.createAlias("restaurantLocation.diningPreferences", "diningPreferences");
				criteria.createAlias("diningPreferences.cuisineTypeId", "dining",
						criteria.INNER_JOIN, Restrictions.eq("diningStyleId", searchCriteria
								.getDiningStyle()));
			}
			if (searchCriteria.getRating() != 0) {
				criterions.add(Restrictions.eq("restaurantLocation.rating", searchCriteria
						.getRating()));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			criteria.add(dis);
			DetachedCriteria maxdebit = DetachedCriteria.forClass(ConfigPojo.class)
		    .setProjection( Property.forName("creditUserDeal"));
			Conjunction crconj = Restrictions.conjunction();
			List<Criterion> credits = new ArrayList<Criterion>();
		    credits.add( Property.forName("rest.currentCredits").ge(maxdebit) );
		    credits.add(Restrictions.eq("rest.billingMethodId", 1));
		    for(Criterion credit:credits){
		    	crconj.add(credit);
		    }
		    Disjunction crdisj = Restrictions.disjunction();
		    crdisj.add(crconj);
		    crdisj.add(Restrictions.eq("rest.billingMethodId", 2));
		    criteria.add(crdisj);
		    
			criteria.add(Restrictions.gtProperty("deal.availableDealsQty", "deal.usedDealsQty"));
			criteria.add(Restrictions.eq("deal.restDealPublishStatus",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			criteria.add(Restrictions.eq("restaurantLocation.isActive",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			Calendar calendar = Calendar.getInstance();
			Date today = new Date();
			calendar.setTime(today);
			calendar.add(Calendar.HOUR, -24);
			today = calendar.getTime();
			criteria.add(Restrictions
					.gt("deal.restDealEndDate", today));
			Disjunction dsj = Restrictions.disjunction();
			for(int i = 0; i < 7; i++){
				String s1 =DateConverterUtility.getDayNumber(calendar.getTime()); 
				java.sql.Date dd = new java.sql.Date(today.getTime());
				Conjunction cons = Restrictions.conjunction();
				List<Criterion> dateCriterions = new ArrayList<Criterion>();
				dateCriterions.add(Restrictions
						.gt("deal.restDealEndDate", dd  ));
                Integer I = Integer.parseInt(s1);
				I++;
				if(I >7)
					I = I - 7;
				s1 = I.toString();
				dateCriterions.add(Restrictions
						.like("deal.availableWeekDays", "%"+s1+"%" ));
				for(Criterion cr:dateCriterions)
					cons.add(cr);
				dsj.add(cons);
				calendar.add(Calendar.DATE, 1);
				today = calendar.getTime();
			}
			criteria.add(dsj);
			  if (searchCriteria.getDealAvailDate() != null) {
			        criteria.add(
			          Restrictions.ge("deal.restDealEndDate", searchCriteria.getDealAvailDate()));
			        Calendar avail = Calendar.getInstance();
			        avail.setTime(searchCriteria.getDealAvailDate());
			        String availday = DateConverterUtility.getDayNumber(avail.getTime());
			        criteria.add(
			          Restrictions.like("deal.availableWeekDays", "%" + availday + "%"));
			      }
			criteria.addOrder(Order.asc("restaurantLocation.cityId"));
			criteria.setProjection(Projections.rowCount());
			l = (Long)(criteria.list().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return l;

	}
	
	/* count how many deal qty the user reserved for deal available date */
	public long countBookedDealsPerDate(int userId, int dealId, String bookedDate) throws ApplicationException{
		Session session = getSession(false);
		long count = 0;
		try{
			Criteria criteria = session.createCriteria(ConsumerReservation.class, "conres");
		    criteria.createAlias("conres.user","user").
		    createAlias("conres.restaurantDeal", "restDeal").add(
		    Restrictions.eq("user.userId", userId)).add(
		    Restrictions.eq("restDeal.dealTemplateId", dealId));
		    Calendar calendar = Calendar.getInstance();
		    Date bookDate = new Date();
		    bookDate = DateConverterUtility.convertUiToServiceDate(bookedDate);
		    calendar.setTime(bookDate);
		    Timestamp ts1 = new Timestamp(bookDate.getTime());
		    criteria.add(Restrictions.ge("conres.bookedTimestamp", ts1));
		    calendar.add(Calendar.HOUR, 24);
		    bookDate = calendar.getTime();
		    Timestamp ts2 = new Timestamp(bookDate.getTime());
		    criteria.add(Restrictions.lt("conres.bookedTimestamp", ts2));
		    criteria.setProjection(Projections.rowCount());
		    count = (Long)criteria.list().get(0);
		}catch (Exception e) {
			
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return count;
		
	}
	
	/* It will check how many deals the user booked today. today 00 hrs to today night 24th hour */
	public long countBookedDeals(int userId, int dealId) throws ApplicationException{
		long count = 0;
		Session session = getSession(false);
	 
		try{
			SQLQuery query = session.createSQLQuery(TangotabConstants.RESERVATIONS_BY_GUEST);
			query.setInteger(0, userId);
			//query.setParameter(1, dealId);
			Calendar calendar = Calendar.getInstance();
			Date today = new Date();
			calendar.setTime(today);
			Timestamp ts = new Timestamp(today.getTime());
			query.setTimestamp(2, ts);
			
			today.setHours(0);
			today.setMinutes(0);
			today.setSeconds(0);
			Timestamp ts2 = new Timestamp(today.getTime());
			query.setTimestamp(1, ts2);
			List results = query.list();
		    Iterator iter = results.iterator();
		    while(iter.hasNext()){
		    	Object cnt = (Object)iter.next();
		    	count = ((BigInteger)cnt).longValue();
		    }
		}catch (Exception e) {
			
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return count;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public ArrayList<RestaurantDealHistory> newsearchDeals(SearchTO searchCriteria)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDealHistory> deals = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantDealHistory.class, "deals");
			criteria.createAlias("deals.restaurantDeal", "deal");
			criteria.createAlias("deal.restaurantLocation", "restaurantLocation");
			criteria.createAlias("restaurantLocation.user", "user");
			List<Criterion> criterions = new ArrayList<Criterion>();
			if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
				criteria.createAlias("restaurantLocation.city", "city");
				criterions.add(Restrictions.eq("city.cityName", searchCriteria.getCityName()));
			}
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				criterions.add(Restrictions.eq("user.zipCode", searchCriteria.getZipCode()));
			}
			Disjunction disjunction = Restrictions.disjunction();
			for (Criterion criterion : criterions) {
				disjunction.add(criterion);
			}
			criteria.add(disjunction);
			Conjunction con = Restrictions.conjunction();
			Conjunction con1 = Restrictions.conjunction();
			Disjunction dis = Restrictions.disjunction();
			criterions = new ArrayList<Criterion>();
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				List<Criterion> priceCriterions = new ArrayList<Criterion>();
				priceCriterions.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getStartPrice()));
				priceCriterions.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getStartPrice()));
				List<Criterion> priceCriterions1 = new ArrayList<Criterion>();
				priceCriterions1.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getEndPrice()));
				priceCriterions1.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getEndPrice()));
				for (Criterion criterion : priceCriterions) {
					con.add(criterion);
				}
				for (Criterion criterion : priceCriterions1) {
					con1.add(criterion);
				}
			}
			dis.add(con);
			dis.add(con1);

			if (searchCriteria.getCuisineType() != 0) {
				criteria.createAlias("restaurantLocation.locationPreferences",
						"locationPreferences");
				criteria.createAlias("locationPreferences.cuisineTypeId", "cusineType",
						criteria.INNER_JOIN, Restrictions.eq("cuisineTypeId", searchCriteria
								.getCuisineType()));
			}

			if (searchCriteria.getDiningStyle() != 0) {
				criteria.createAlias("restaurantLocation.diningPreferences", "diningPreferences");
				criteria.createAlias("diningPreferences.cuisineTypeId", "dining",
						criteria.INNER_JOIN, Restrictions.eq("diningStyleId", searchCriteria
								.getDiningStyle()));
			}
			if (searchCriteria.getRating() != 0) {
				criterions.add(Restrictions.eq("restaurantLocation.rating", searchCriteria
						.getRating()));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}

			criteria.add(conjunction);
			criteria.add(dis);
			criteria.add(Restrictions.eq("deal.restDealPublishStatus",
					TangotabConstants.DEAL_PUBLISH_STATUS));

			deals = (ArrayList<RestaurantDealHistory>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return deals;

	}

	/* Get deal details */
	public RestaurantDeal fetchDealByDealId(int restDealId) throws ApplicationException {
		Session session = getSession(false);
		RestaurantDeal deal = null;
		try {
			deal = (RestaurantDeal) session.get(RestaurantDeal.class, restDealId);
			//session.evict(deal);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		}finally{
			
		}
		return deal;
	}

	/* fetch deal history */
	public RestaurantDealHistory fetchDealHistoryByDealId(int restDealId)
			throws ApplicationException {
		Session session = getSession(false);
		RestaurantDealHistory deal = null;
		try {
			deal = (RestaurantDealHistory) session.get(RestaurantDealHistory.class, restDealId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		}finally{
			
		}
		return deal;
	}

	public void deleteRestaurant(int userId) throws ApplicationException {
		// TODO Auto-generated method stub

	}

	public int saveValidationCode(UserValidationCode validationCode) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		
		try {
			validationCode = (UserValidationCode) session.merge(validationCode);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return validationCode.getUserValidationCodeId();
	}

	/* Book Deal when guest made a reservation and here 'date' is the the day for which they reserved the offer(available date) */
	@SuppressWarnings("unchecked")
	public BookDealTO bookDeal(int userId, int dealId, String date,String startTime) throws ApplicationException {
		if (log.isDebugEnabled()) {
			log.debug("Start of saveLocationManager ");
		}
		BookDealTO to = null;
		if (userId > 0 && dealId > 0) {
			to = new BookDealTO();
			to.setUserId(userId);
			to.setDealId(dealId);
			Session session = getSession(false);
			
			try {
				/* 1. create an entry in the rest_reservations table */
				SQLQuery query1 = session
						.createSQLQuery(TangotabConstants.CONSUMER_RESERVATION_INSERT_DATE_QUERY);
				query1.setInteger(0, userId);
				query1.setInteger(1, dealId);
				 query1.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
				Calendar startdate=Calendar.getInstance();
				 startdate.setTime(DateConverterUtility.convertUiToServiceDate(date));
				  
				 
					 String  time[]=startTime.split(" ");
					 if(time.length==2)
					 {
						 if(time[1].equals("PM"))
						 {
							String hm[]=time[0].split(":");
							if(!hm[0].equals("12"))
							startdate.set(Calendar.HOUR, Integer.parseInt(hm[0])+12);
							else 
								startdate.set(Calendar.HOUR, Integer.parseInt(hm[0]));
							startdate.set(Calendar.MINUTE, Integer.parseInt(hm[1]));
							
						 }else 
						 {
							 String hm[]=time[0].split(":");
							 startdate.set(Calendar.HOUR, Integer.parseInt(hm[0]));
							 startdate.set(Calendar.MINUTE, Integer.parseInt(hm[1]));
						 }
					 }
					 
				query1.setTimestamp(2, startdate.getTime());
               
               
				int rows = query1.executeUpdate();

				SQLQuery queryX = session
						.createSQLQuery(TangotabConstants.CONSUMER_RESERVATION_ID_SELECT_QUERY);
				queryX.setInteger(0, userId);
				queryX.setInteger(1, dealId);
				List listX = queryX.list();
				Iterator conResIDs = listX.iterator();
				if (conResIDs.hasNext()) {
					Integer consumerReservationId = (Integer) conResIDs.next();
					to.setConsumerReservationId(consumerReservationId);

				}

				SQLQuery queryZ = session
						.createSQLQuery(TangotabConstants.RESTAURANT_FROM_DEAL_ID_SELECT_QUERY);
				queryZ.setInteger(0, dealId);
				List listZ = queryZ.list();
				Iterator restIds = listZ.iterator();
				if (restIds.hasNext()) {
					Object[] columns = (Object[]) restIds.next();
					int restaurantId = (Integer) columns[0];
					to.setRestaurantId(restaurantId);

					String businessName = (String) columns[1];
					to.setBusinessName(businessName);
					int billingmethodid = (Integer) columns[2];
					to.setBillingMethodId(billingmethodid);
					byte isAutoDebit = (Byte) columns[3];
					to.setIsAutoDebit(isAutoDebit);
				}

				if (rows > 0) {
					/* 2. Reduce the quantity in rest_deal table */
					SQLQuery query2 = session
							.createSQLQuery(TangotabConstants.RESTAURANT_DEALS_QUANTITY_DECREASE_QUERY);
					query2.setInteger(0, dealId);

					rows = query2.executeUpdate();
					if (rows > 0) {
						/* 3. Reduce the credit for the restaurant */
						/* reduce the current credits if billing method is credit card */
						if (to.getBillingMethodId() == 1) {
							SQLQuery query3 = session
									.createSQLQuery(TangotabConstants.RESTAURANT_CREDIT_QUANTITY_DECREASE_QUERY);
							ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
							ConfigPojo configPojo = configBO.getConfigDetails();
							query3.setInteger(0, configPojo.getCreditUserDeal());
							query3.setInteger(1, to.getRestaurantId());
							rows = query3.executeUpdate();
						}
						if (rows > 0) {
							SQLQuery query4 = session
									.createSQLQuery(TangotabConstants.USER_DETAILS_SELECT_QUERY);
							query4.setInteger(0, userId);
							List list = query4.list();

							Iterator userDetails = list.iterator();
							if (userDetails.hasNext()) {
								Object[] columns = (Object[]) userDetails.next();
								String firstName = (String) columns[0];
								String emailId = (String) columns[1];
								to.setConsumerName(firstName);
								to.setConsumerEmailId(emailId);
							}

							SQLQuery query5 = session
									.createSQLQuery(TangotabConstants.DEAL_MGR_EMAIL_ID_SELECT_QUERY);
							query5.setInteger(0, dealId);
							list = query5.list();

							Iterator dealMgrDetails = list.iterator();
							if (dealMgrDetails.hasNext()) {
								Object[] columns = (Object[]) dealMgrDetails.next();
								String emailId = (String) columns[0];
								String dealMgrName= (String) columns[1];
								String locationName = (String) columns[2];
								String dealMgrMobilePhone = (String) columns[3];
 
								to.setLocationName(locationName);
								to.setDealManagerName(dealMgrName);
								to.setDealManagerEmailId(emailId);
								to.setDealManagerMoile(dealMgrMobilePhone);
							}

							SQLQuery query6 = session
									.createSQLQuery(TangotabConstants.ACCOUNT_MGR_DETAILS_SELECT_QUERY);
							query6.setInteger(0, dealId);
							list = query6.list();

							Iterator accountMgrDetails = list.iterator();
							if (accountMgrDetails.hasNext()) {
								Object[] columns = (Object[]) accountMgrDetails.next();
								String emailId = (String) columns[0];
								String name = (String) columns[1];
								Double credits = (Double) columns[2];

								to.setAccountManagerEmailId(emailId);
								to.setAccountManagerName(name);
								to.setCurrentCredits(credits);
							}
							
						} else {
							// NO CREDITS FOUND for the restaurant
						
							to
									.setErrorMessage("No credits found for the restaurant, so cannot" +
											" reserve this deal. Sorry.");
						}
					} else {
						// NO DEALS LEFT
					
						to.setErrorMessage("No deals left. Please try another deal.");
					}
					// 4. Add credit to the consumer = The entry the
					// consumer_reservation table
					// itself
					// will be treated a CREDIT to the consumer.
					// SQLQuery query4 =
					// session.createSQLQuery(TangotabConstants.ADD_CREDIT_TO_CONSUMER);
					// query4.setInteger(0, restaurantId);
					// session.save(consumerReservation);
				} else {
					// RECORD CANNOT BE INSERTED.
				
					to.setErrorMessage("Consumer reservation cannot be inserted in database.");
				}
			} catch (Exception e) {
				if (log.isErrorEnabled()) {
					log.error("Error occured in saveLocationManagerr" + e.getMessage());
				}
				e.printStackTrace();
			
				throw new ApplicationException("DB001", TangotabConstants.ERROR);
			} finally {
				
			}
		}
		return to;
	}

	@SuppressWarnings("unchecked")
	public BookDealTO bookDeal(int userId, int dealId, int bookDealId, String date)
			throws ApplicationException {
		if (log.isDebugEnabled()) {
			log.debug("Start of saveLocationManager ");
		}
		BookDealTO to = null;
		if (userId > 0 && dealId > 0) {
			to = new BookDealTO();
			to.setUserId(userId);
			to.setDealId(dealId);
			Session session = getSession(false);
			
			try {
				// 1. create an entry in the rest_reservations table
				SQLQuery query1 = session
						.createSQLQuery(TangotabConstants.CONSUMER_RESERVATION_INSERT_DATE_QUERY);
				query1.setInteger(0, userId);
				query1.setInteger(1, dealId);
				query1.setTimestamp(2, DateConverterUtility.convertUiToServiceDate(date));

				int rows = query1.executeUpdate();

				SQLQuery queryX = session
						.createSQLQuery(TangotabConstants.CONSUMER_RESERVATION_ID_SELECT_QUERY);
				queryX.setInteger(0, userId);
				queryX.setInteger(1, dealId);
				List listX = queryX.list();
				Iterator conResIDs = listX.iterator();
				if (conResIDs.hasNext()) {
					Integer consumerReservationId = (Integer) conResIDs.next();
					to.setConsumerReservationId(consumerReservationId);

				}

				SQLQuery queryZ = session
						.createSQLQuery(TangotabConstants.RESTAURANT_FROM_DEAL_ID_SELECT_QUERY);
				queryZ.setInteger(0, dealId);
				List listZ = queryZ.list();
				Iterator restIds = listZ.iterator();
				if (restIds.hasNext()) {
					Object[] columns = (Object[]) restIds.next();
					int restaurantId = (Integer) columns[0];
					to.setRestaurantId(restaurantId);

					String businessName = (String) columns[1];
					to.setBusinessName(businessName);
					int billingmethodid = (Integer) columns[2];
					to.setBillingMethodId(billingmethodid);
				}

				if (rows > 0) {
					// 2. Reduce the quantity in rest_deal table
					SQLQuery query2 = session
							.createSQLQuery(TangotabConstants.RESTAURANT_DEALS_QUANTITY_DECREASE_QUERY);
					query2.setInteger(0, bookDealId);

					rows = query2.executeUpdate();
					if (rows > 0) {
						// 3. Reduce the credit for the restaurant
						// reduce the current credits if billing method is credit card
						if (to.getBillingMethodId() == 1) {
							SQLQuery query3 = session
									.createSQLQuery(TangotabConstants.RESTAURANT_CREDIT_QUANTITY_DECREASE_QUERY);

							ConfigBO configBO = com.tangotab.businessImpl.BusinessFactory.getConfigBO();
							ConfigPojo configPojo = configBO.getConfigDetails();
							query3.setInteger(0, configPojo.getCreditUserDeal());
							query3.setInteger(1, to.getRestaurantId());
							rows = query3.executeUpdate();
						}
						if (rows > 0) {
							SQLQuery query4 = session
									.createSQLQuery(TangotabConstants.USER_DETAILS_SELECT_QUERY);
							query4.setInteger(0, userId);
							List list = query4.list();

							Iterator userDetails = list.iterator();
							if (userDetails.hasNext()) {
								Object[] columns = (Object[]) userDetails.next();
								String firstName = (String) columns[0];
								String emailId = (String) columns[1];
								to.setConsumerName(firstName);
								to.setConsumerEmailId(emailId);
							}

							SQLQuery query5 = session
									.createSQLQuery(TangotabConstants.DEAL_MGR_EMAIL_ID_SELECT_QUERY);
							query5.setInteger(0, dealId);
							list = query5.list();

							Iterator dealMgrDetails = list.iterator();
							if (dealMgrDetails.hasNext()) {
								Object[] columns = (Object[]) dealMgrDetails.next();
								String emailId = (String) columns[0];
								String locationName = (String) columns[1];

								to.setLocationName(locationName);
								to.setDealManagerEmailId(emailId);
							}

							SQLQuery query6 = session
									.createSQLQuery(TangotabConstants.ACCOUNT_MGR_DETAILS_SELECT_QUERY);
							query6.setInteger(0, dealId);
							list = query6.list();

							Iterator accountMgrDetails = list.iterator();
							if (accountMgrDetails.hasNext()) {
								Object[] columns = (Object[]) accountMgrDetails.next();
								String emailId = (String) columns[0];
								String name = (String) columns[1];
								Double credits = (Double) columns[2];

								to.setAccountManagerEmailId(emailId);
								to.setAccountManagerName(name);
								to.setCurrentCredits(credits);
							}
							
						} else {
							// NO CREDITS FOUND for the restaurant
						
							to
									.setErrorMessage("No credits found for the restaurant, so cannot" +
											" reserve this deal. Sorry.");
						}
					} else {
						// NO DEALS LEFT
					
						to.setErrorMessage("No deals left. Please try another deal.");
					}
					/* 4. Add credit to the consumer = The entry the consumer_reservation table
					 * itself will be treated a CREDIT to the consumer
					 */
					
					
				} else {
					// RECORD CANNOT BE INSERTED.
				
					to.setErrorMessage("Consumer reservation cannot be inserted in database.");
				}
			} catch (Exception e) {
				if (log.isErrorEnabled()) {
					log.error("Error occured in saveLocationManagerr" + e.getMessage());
				}
				e.printStackTrace();
			
				throw new ApplicationException("DB001", TangotabConstants.ERROR);
			} finally {
				
			}
		}
		return to;
	}

	public DealTO fetchDealTemplateDeal(String dealTemplateName) throws ApplicationException {
		Session session = getSession(false);
		DealTO deal = null;
		Criteria criteria = session.createCriteria(DealTemplate.class, "deal");
		try {
			criteria.add(Restrictions.eq("dealTemplateName", dealTemplateName));
			criteria.setProjection(
					Projections.distinct(Projections.projectionList().add(
							Projections.property("deal.dealTemplateId").as("dealTemplateId")).add(
							Projections.property("deal.dealTemplateDescription").as(
									"dealTemplateDescription")).add(
							Projections.property("deal.dealTemplateImgPath").as(
									"dealTemplateImgPath")).add(
							Projections.property("deal.dealTemplateRestrictions").as(
									"dealTemplateRestrictions")))).setResultTransformer(
					new AliasToBeanResultTransformer(DealTO.class));
			deal = (DealTO) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return deal;
	}

	/*
	 * Check availability for the new user while registration 
	 * */
	@SuppressWarnings("unchecked")
	public int checkAvailability(String emailId) throws ApplicationException {
		int count = 0;
		Session session = getSession(false);
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.CHECK_AVAILABILITY_QUERY);
			query.setParameter(0, emailId);
			List results = query.list();
			Iterator itr = results.iterator();
			if (itr.hasNext()) {
				Object columns = (Object) itr.next();
				BigInteger temp = (BigInteger) columns;
				count = temp.intValue();
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return count;
	}

	/*
	 * save recharge information 
	 * */
	@SuppressWarnings("finally")
	public boolean saveRechargeInfo(BillingCc rechargedPayInfo) throws ApplicationException {
		Session session = getSession(false);
		
		boolean status = false;
		try {
			session.save(rechargedPayInfo);
			SQLQuery query1 = session.createSQLQuery(TangotabConstants.RESTAURANT_CREDITS_UPDATE);
			query1.setInteger(0, rechargedPayInfo.getQty());
			query1.setShort(1, rechargedPayInfo.getIsAutoDebit());
			query1.setInteger(2, rechargedPayInfo.getRestId());
			query1.executeUpdate();
			
			status = true;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);

		} finally {
			
			return status;
		}
	}

	/*
	 * Get deal history of the guest(reservations done in past)
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList<ConsumerReservation> getUserDealsHistory(int userId)
			throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Starts getting history of reserved deals for user ");

		Session session = getSession(false);
		ArrayList<ConsumerReservation> userdeals = null;

		try {

			Criteria criteria = session.createCriteria(ConsumerReservation.class, "creserves")
					.createAlias("creserves.user", "user").createAlias("creserves.restaurantDeal",
							"resdeal").add(Restrictions.eq("user.userId", userId));

			userdeals = (ArrayList<ConsumerReservation>) criteria.list();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deals history" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return userdeals;
	}

	/*
	 *  Get the details of the reservation when clicked on reservation id
	 * */
	public ConsumerReservation getConReserveByReservationId(int rId) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Starts getting history of reserved deals for user ");

		Session session = getSession(false);
		ConsumerReservation conres = null;

		try {

			Criteria criteria = session.createCriteria(ConsumerReservation.class, "creserves").add(
					Restrictions.eq("creserves.conResId", rId));

			conres = (ConsumerReservation) criteria.uniqueResult();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deals history" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return conres;
	}
/*
 * Check user availability(old method)
 * */
	@SuppressWarnings("unchecked")
	public boolean checkUserAvilability(String emailId) {
		boolean avilable = false;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(User.class, "user");
			criteria.add(Restrictions.eq("emailId", emailId));
			criteria.setProjection(Projections.distinct(Projections.projectionList().add(
					Projections.property("user.emailId").as("emailId"))));
			List<User> users = (List<User>) criteria.list();
			if (users != null && users.size() > 0)
				avilable = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return avilable;
	}
/*
 * Checks user availability depending up on role 
 * */
	@SuppressWarnings("unchecked")
	public boolean checkUserAvailability(String emailId, int roleId) {
		boolean avilable = false;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(User.class, "user");
			criteria.add(Restrictions.eq("emailId", emailId)).createAlias("user.role", "role").add(
					Restrictions.eq("role.roleId", roleId));
			criteria.setProjection(Projections.distinct(Projections.projectionList().add(
					Projections.property("user.emailId").as("emailId"))));
			List<User> users = (List<User>) criteria.list();
			if (users != null && users.size() > 0)
				avilable = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return avilable;
	}

	/*
	 * Get the billing details and amount details according to restaurant Id 
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList<BillingCc> getBillingSummary(int restId) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Starts getting history of reserved deals for user ");

		Session session = getSession(false);
		ArrayList<BillingCc> billingCc = null;

		try {

			Criteria criteria = session.createCriteria(BillingCc.class, "billing").add(
					Restrictions.eq("restId", restId));
			billingCc = (ArrayList<BillingCc>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deals history" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return billingCc;

	}

	/* Get user names of guests depending up on email Id */
	@SuppressWarnings("unchecked")
	public String getUserName(String emailId) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Starts getUserName ");

		Session session = getSession(false);
		SQLQuery query4 = session.createSQLQuery(TangotabConstants.USER_NAME_SELECT_QUERY);
		query4.setString(0, emailId);
		List list = query4.list();
 
		Iterator userDetails = list.iterator();
		if (userDetails.hasNext()) {
			Object[] columns = (Object[]) userDetails.next();
			String firstName = (String) columns[0];
			String lastName = (String) columns[1];
			if (lastName != null) {

				return firstName + " " + lastName;
			} else
				return firstName;

		}
		return null;
	}

	/* In Admin .. for client management */
	@SuppressWarnings("unchecked")
	public ArrayList<Restaurant> getAllRestaurants() throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		ArrayList<Restaurant> client = null;
		try{
		Criteria criteria = session.createCriteria(Restaurant.class);
		client = (ArrayList<Restaurant>) criteria.list();
		}finally{
		
		}
		return client;
	}
	
	/*
	 * Gets all restaurants as per pagination 
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList<Restaurant> getAllRestaurants(int currentPage,SortByTO sortByTO) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		ArrayList<Restaurant> client = null;
		try{
		Criteria criteria = session.createCriteria(Restaurant.class,"rest");
		criteria.createAlias("rest.user", "user");
		

		if(sortByTO.getDate()!=null && sortByTO.getDate().equals(TangotabConstants.DECENDING))
			criteria.addOrder(Order.desc("user.userCreateDate"));
	 	else 	if(sortByTO.getDate()!=null &&  sortByTO.getDate().equals(TangotabConstants.ASCENDING))
	 		criteria.addOrder(Order.asc("user.userCreateDate"));

				
		if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.DECENDING))
			criteria.addOrder(Order.desc("rest.businessName"));
		else   	if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.ASCENDING))
			criteria.addOrder(Order.asc("rest.businessName"));


		currentPage -= 1;
		criteria.setFirstResult(currentPage*TangotabConstants.PAGE_SIZE);
		criteria.setMaxResults(TangotabConstants.PAGE_SIZE);
		client = (ArrayList<Restaurant>) criteria.list();
		}finally{
			
		}
		return client;
	}

	/* Count no. of pages will come for all restaurants */
	public long countAllRestaurants() throws ApplicationException{
		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		Long count;
		try{
		Criteria criteria = session.createCriteria(Restaurant.class);
		criteria.setProjection(Projections.rowCount());
		count = (Long)(criteria.list().get(0));
		}finally{
			
		}
		return count;
	}
	/* query to change the status of BusinessName. If host is being suspended, then suspend
	 * all its locations */
	public boolean setRestaurantStatus(int restId, Short status) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.RESTAURANT_STATUS_UPDATE_QUERY);
			query.setShort(0, status);
			query.setInteger(1, restId);

			int rows = query.executeUpdate();
			if (status == 0) {
				SQLQuery query1 = session
						.createSQLQuery(TangotabConstants.REST_LOC_STATUS_UPDATE_QUERY);
				query1.setShort(0, status);
				query1.setInteger(1, restId);
				query1.executeUpdate();
			}
			
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;
	}

	/*
	 * Get Restaurant and its locations details according to id
	 * */
	public Restaurant getRestaurantById(Integer restaurantId) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		Restaurant client = null;
		try {
			client = (Restaurant) session.get(Restaurant.class, restaurantId);

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return client;
	}

	/*
	 * need to retrive as list because business name is not a primay key after setting it just
	 * change it to return type as one column
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Restaurant> getRestaurantByName(String businessName)
			throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get restaurant by name() ");
		Session session = getSession(false);
		ArrayList<Restaurant> restList = null;
		try {
			Criteria criteria = session.createCriteria(Restaurant.class, "restaurant").add(
					Restrictions.like("businessName", "%" + businessName + "%"));
			restList = (ArrayList<Restaurant>) criteria.list();
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return restList;
	}
	
	/* Search for restaurants */
	@SuppressWarnings("unchecked")
	public ArrayList<Restaurant> getRestaurantByName(String businessName, int currentPage,SortByTO sortByTO)
			throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get restaurant by name() ");
		Session session = getSession(false);
		ArrayList<Restaurant> restList = null;
		try {
			Criteria criteria = session.createCriteria(Restaurant.class, "restaurant").add(
					Restrictions.like("businessName", "%" + businessName + "%"));	
					criteria.createAlias("restaurant.user", "user");

			if(sortByTO.getDate()!=null && sortByTO.getDate().equals(TangotabConstants.DECENDING))
				criteria.addOrder(Order.desc("user.userCreateDate"));
			else 	if(sortByTO.getDate()!=null &&  sortByTO.getDate().equals(TangotabConstants.ASCENDING))
				criteria.addOrder(Order.asc("user.userCreateDate"));

					
			if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.DECENDING))
				criteria.addOrder(Order.desc("restaurant.businessName"));
			else   	if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.ASCENDING))
				criteria.addOrder(Order.asc("restaurant.businessName"));
			currentPage -= 1;
			criteria.setFirstResult(currentPage*TangotabConstants.PAGE_SIZE);
			criteria.setMaxResults(TangotabConstants.PAGE_SIZE);
			restList = (ArrayList<Restaurant>) criteria.list();
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return restList;
	}
	
	/* No. of pages for search by restaurant name */
	public long countRestaurantByName(String businessName)throws ApplicationException {
		
		if (log.isDebugEnabled())
			log.debug("Start of get restaurant by name() ");
		Session session = getSession(false);
		long count = 0;
		try {
			Criteria criteria = session.createCriteria(Restaurant.class, "restaurant").add(
					Restrictions.like("businessName", "%" + businessName + "%"));
			criteria.setProjection(Projections.rowCount());
			count = (Long)criteria.list().get(0);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return count;
	}

	/* returns all guests */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllUsers() throws ApplicationException {
		ArrayList<User> users = null;
		Session session = getSession(false);
		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		try{
		Criteria criteria = session.createCriteria(User.class, "user").createAlias("user.role",
				"role").add(Restrictions.eq("role.roleId", (Integer) 4));
		users = (ArrayList<User>) criteria.list();
		}finally{
		     
		}
		return users;
	}
	/* returns guests for the requested page */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getAllUsers(int page,SortByTO sortByTO) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		ArrayList<User> users = null;
		try{
		Criteria criteria = session.createCriteria(User.class, "user").createAlias("user.role",
				"role").add(Restrictions.eq("role.roleId", (Integer) 4));
		if(sortByTO.getDate()!=null && sortByTO.getDate().equals(TangotabConstants.DECENDING))
			criteria.addOrder(Order.desc("user.userCreateDate"));
		else 	if(sortByTO.getDate()!=null &&  sortByTO.getDate().equals(TangotabConstants.ASCENDING))
			criteria.addOrder(Order.asc("user.userCreateDate"));
		
			if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.DECENDING))
				criteria.addOrder(Order.desc("user.firstname"));
			else   	if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.ASCENDING))
				criteria.addOrder(Order.asc("user.firstname"));
		
		
		page -= 1;
		criteria.setFirstResult(page*TangotabConstants.PAGE_SIZE);
		criteria.setMaxResults(TangotabConstants.PAGE_SIZE);
		users = (ArrayList<User>) criteria.list();
		}finally{
			
		}
		return users;
	}
	
    /* count all guests for display of pages */
	public Long countAllUsers(String name) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		Long count;
		try{
		Criteria criteria = session.createCriteria(User.class, "user").createAlias("user.role",
				"role").add(Restrictions.eq("role.roleId", (Integer) 4));
		if(name != null)
			 criteria.add(Restrictions.like("user.emailId", "%" + name + "%"));
		criteria.setProjection(Projections.rowCount());
		count = (Long)criteria.list().get(0);
		}finally{
		    
		}
		return count;
	}

	public User getUserByUserId(Integer userId) throws ApplicationException {

		User user = new User();
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(User.class, "user");
			criteria.add(Restrictions.eq("user.userId", userId));
			user = (User) criteria.uniqueResult();

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return user;
	}

	/* returns the set of users by emailId (old method) */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getUserById(String name) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get restaurant by name() ");
		Session session = getSession(false);
		ArrayList<User> users = null;
		try {
			Criteria criteria = session.createCriteria(User.class, "user").createAlias("user.role",
					"role").add(Restrictions.eq("role.roleId", (Integer) 4)).add(
					Restrictions.like("user.emailId", "%" + name + "%"));
			users = (ArrayList<User>) criteria.list();
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return users;
	}
	
	/* returns the set of users by emailId according to page no. sent */
	@SuppressWarnings("unchecked")
	public ArrayList<User> getUserById(String name, int page,SortByTO sortByTO) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get restaurant by name() ");
		Session session = getSession(false);
		ArrayList<User> users = null;
		try {
			Criteria criteria = session.createCriteria(User.class, "user").createAlias("user.role",
					"role").add(Restrictions.eq("role.roleId", (Integer) 4)).add(
					Restrictions.like("user.emailId", "%" + name + "%"));
			if(sortByTO.getDate()!=null && sortByTO.getDate().equals(TangotabConstants.DECENDING))
				criteria.addOrder(Order.desc("user.userCreateDate"));
			else 	if(sortByTO.getDate()!=null &&  sortByTO.getDate().equals(TangotabConstants.ASCENDING))
				criteria.addOrder(Order.asc("user.userCreateDate"));
			
				if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.DECENDING))
					criteria.addOrder(Order.desc("user.firstname"));
				else   	if(sortByTO.getName()!=null && sortByTO.getName().equals(TangotabConstants.ASCENDING))
					criteria.addOrder(Order.asc("user.firstname"));
			
			page -= 1;
			criteria.setFirstResult(page*TangotabConstants.PAGE_SIZE);
			criteria.setMaxResults(TangotabConstants.PAGE_SIZE);
			users = (ArrayList<User>) criteria.list();
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return users;
	}

	/* returns the guest details by emailId*/
	@SuppressWarnings("unchecked")
	public User getUserByEmailId(String email) throws ApplicationException {

		User user = new User();
		Session session = getSession(false);
		try {
			ArrayList<User> users = null;
			Criteria criteria = session.createCriteria(User.class, "user");

			criteria.add(Restrictions.eq("user.emailId", email));
			users = (ArrayList<User>) criteria.list();
			if (users.size() > 0) {
				user = (User) users.get(0);
			}

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return user;

	}

	/* Refer the deal to a friend and sending mail alert for referral */
	public int forwardDealToFriend(ConsumerReferral refer) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of save Consumer Refferals");
		Session session = getSession(false);
		
		try {
			session.save(refer);
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in save  Consumer Refferals" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return refer.getConsumerReferralId();
	}

	/* Save the support issue */
	public int saveSupportData(Support support) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		
		try {

			session.save(support);
			

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return support.getSupportId();
	}

	/* Save credit card details */
	public boolean saveCreditcard(RestaurantCC restaurantCC) throws ApplicationException {
		// TODO Auto-generated method stub
		if (log.isDebugEnabled())
			log.debug("Start of restaurantCC ");
		Session session = getSession(false);
		
		try {

			if (restaurantCC.getRestCcId() == null)
				session.save(restaurantCC);
			else
				session.update(restaurantCC);

			

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
		return true;
	}

	/* Get all support issues */
	@SuppressWarnings("unchecked")
	public ArrayList<Support> getAllSupportIssues() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of savesupportdata ");

		Session session = getSession(false);
		ArrayList<Support> item = null;
		Criteria criteria = session.createCriteria(Support.class);
		item = (ArrayList<Support>) criteria.list();
		
		return item;

	}

	/* Get issue by id */
	public Support getSupportIssueById(Integer supportId) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get all restaurants() ");
		Session session = getSession(false);
		Support support = null;
		try {
			support = (Support) session.get(Support.class, supportId);

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return support;
	}

	/* change the staus of issue to close/ open */
	public boolean setSupportStatus(Integer supportId, Integer status) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.SUPPORT_STATUS_UPDATE_QUERY);
			query.setInteger(0, status);
			query.setInteger(1, supportId);

			int rows = query.executeUpdate();
			
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return false;
	}

	/* get all issues posted by this person */
	@SuppressWarnings("unchecked")
	public ArrayList<Support> getSupportIssuesByEmail(String name) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of get restaurant by name() ");
		Session session = getSession(false);
		ArrayList<Support> items = null;
		try {
			Criteria criteria = session.createCriteria(Support.class, "support").add(
					Restrictions.like("support.emailId", "%" + name + "%"));
			items = (ArrayList<Support>) criteria.list();
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return items;
	}

	public void saveSalesManager(SalesManagerInfo salesManagerInfo) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			session.save(salesManagerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	public ArrayList<CityTO> fetchCitiesOfMgr(int salesMgrId) throws ApplicationException {
		return null;
	}

	public void saveSalesRepresentInfo(SalesRepresentInfo salesRepresentInfo)
			throws ApplicationException {
		Session session = getSession(false);
		
		try {
			session.save(salesRepresentInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	public void updateSalesMgrInfo(SalesManagerInfo salesManagerInfo) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			session.update(salesManagerInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	public void updateSalesRepresentInfo(SalesRepresentInfo salesRepresentInfo)
			throws ApplicationException {
		Session session = getSession(false);
		
		try {
			session.update(salesRepresentInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SalesManagerInfo> fetchSalesManagerDetails(String type)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<SalesManagerInfo> salesManagerInfo = null;
		try {
			Criteria criteria = session.createCriteria(SalesManagerInfo.class, "mgr");
			if (StringUtils.isNotEmpty(type)) {
				criteria.createAlias("mgr.user", "user");
				List<Criterion> criterion = new ArrayList<Criterion>();
				criterion.add(Restrictions.like("user.firstname", type + "%"));
				criterion.add(Restrictions.like("user.lastname", type + "%"));
				Disjunction disjunction = Restrictions.disjunction();
				for (Criterion condition : criterion) {
					disjunction.add(condition);
				}
				criteria.add(disjunction);
			}
			salesManagerInfo = (ArrayList<SalesManagerInfo>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		}
		return salesManagerInfo;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SalesRepresentInfo> fetchSalesRepresentativeInfo(String type)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<SalesRepresentInfo> salesRepInfo = null;
		try {
			Criteria criteria = session.createCriteria(SalesRepresentInfo.class, "mgr");
			if (StringUtils.isNotEmpty(type)) {
				criteria.createAlias("mgr.user", "user");
				List<Criterion> criterion = new ArrayList<Criterion>();
				criterion.add(Restrictions.like("user.firstname", type + "%"));
				criterion.add(Restrictions.like("user.lastname", type + "%"));
				Disjunction disjunction = Restrictions.disjunction();
				for (Criterion condition : criterion) {
					disjunction.add(condition);
				}
				criteria.add(disjunction);
			}
			salesRepInfo = (ArrayList<SalesRepresentInfo>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		}
		return salesRepInfo;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<UserTO> getSalesMangers() throws ApplicationException {
		Session session = getSession(false);
		ArrayList<UserTO> userInfo = null;
		try {
			Criteria criteria = session.createCriteria(SalesManagerInfo.class, "mgr");
			criteria.createAlias("mgr.user", "user");
			criteria.setProjection(
					Projections.distinct(Projections.projectionList().add(
							Projections.property("user.firstname").as("firstname")).add(
							Projections.property("user.lastname").as("lastname")).add(
							Projections.property("mgr.salesManagerId").as("userId"))))
					.setResultTransformer(new AliasToBeanResultTransformer(UserTO.class));

			userInfo = (ArrayList<UserTO>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		}
		return userInfo;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CityTO> getCitiesOfManger(int managerId) {
		ArrayList<CityTO> cities = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(SalesManagerInfo.class, "mgr");
			criteria.createAlias("mgr.salesMgrCitieses", "mgrCity");
			criteria.createAlias("mgrCity.city", "city");
			criteria.add(Restrictions.eq("mgr.salesManagerId", managerId));
			criteria.setProjection(
					Projections.distinct(Projections.projectionList().add(
							Projections.property("city.cityId").as("cityId")).add(
							Projections.property("city.cityName").as("cityName"))))
					.setResultTransformer(new AliasToBeanResultTransformer(CityTO.class));
			cities = (ArrayList<CityTO>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		return cities;
	}

	public SalesManagerInfo getSalesManagerInfo(int salesMgrId) throws ApplicationException {
		Session session = getSession(false);
		SalesManagerInfo mgrInfo = null;
		try {
			Criteria criteria = session.createCriteria(SalesManagerInfo.class);
			criteria.add(Restrictions.eq("salesManagerId", salesMgrId));
			mgrInfo = (SalesManagerInfo) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		}
		return mgrInfo;
	}

	public SalesRepresentInfo getSalesRepresentInfo(int salesRepId) throws ApplicationException {
		Session session = getSession(false);
		SalesRepresentInfo repInfo = null;
		try {
			Criteria criteria = session.createCriteria(SalesRepresentInfo.class);
			criteria.add(Restrictions.eq("salesRepId", salesRepId));
			repInfo = (SalesRepresentInfo) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		}
		return repInfo;
	}

	public void deleteSalesMgrCities(int salesMgrId) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.DELETE_SALES_MGR_CITIES);
			query.setParameter(0, salesMgrId);
			query.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			
		}
	}

	public void deleteSalesRepZipcodes(int salesRepId) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.DELETE_SALES_REP_ZIP_CODES);
			query.setParameter(0, salesRepId);
			query.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			
		}
	}

	public void updateActives(int[] userId, int[] activeId) throws ApplicationException {
		for (int i = 0; i < userId.length; i++) {
			Session session = getSession(false);
			
			try {
				SQLQuery query = session.createSQLQuery(TangotabConstants.UPDATE_USER_STATUS);
				query.setParameter(0, activeId[i]);
				query.setParameter(1, userId[i]);
				query.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			
				throw new ApplicationException("DB004", TangotabConstants.ERROR);
			} finally {
				
			}
		}

	}

	/* get restaurant cc details for the business name */
	@SuppressWarnings("unchecked")
	public RestaurantCC getRestaurantCC(int restId) throws ApplicationException {
 
		if (log.isDebugEnabled())
			log.debug("Start of get  RestaurantCC ");
		RestaurantCC restaurantCC = null;
		Session session = getSession(false);

		try {
			ArrayList<RestaurantCC> arrayList = null;
			Criteria criteria = session.createCriteria(RestaurantCC.class).add(
					Restrictions.eq("restId", restId));

			arrayList = (ArrayList) criteria.list();

			if (arrayList.size() > 0) {
				restaurantCC = (RestaurantCC) arrayList.get(0);
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getUser" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}

		return restaurantCC;
	}

	/* Get cusine types available for restaurant location */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocationPreference> getCuisinesByLocationId(Integer locationId)
			throws ApplicationException {
		ArrayList<RestaurantLocationPreference> cuisines = null;
		Session session = getSession(false);
		try {

			Criteria criteria = session.createCriteria(RestaurantLocationPreference.class,
					"rlocpref").createAlias("rlocpref.cuisineTypeId", "cuisine").createAlias(
					"rlocpref.restaurantLocation", "restloc").add(
					Restrictions.eq("restloc.restLocationId", locationId));
			cuisines = (ArrayList<RestaurantLocationPreference>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}
		return cuisines;

	}

	/* Get all Locations for the restaurant */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocation> getLocationManagers(int restId)
			throws ApplicationException {

		ArrayList<RestaurantLocation> managers = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(RestaurantLocation.class, "restloc")
					.createAlias("restloc.user", "muser").createAlias("restloc.restaurant", "rest")
					.add(Restrictions.eq("rest.restaurantId", restId));
			criteria.setProjection(Projections.distinct(Projections.projectionList().add(
					Projections.property("muser.userId").as("restloc.userId")).add(
					Projections.property("muser.emailId").as("restloc.webSite")).add(
					Projections.property("muser.firstname").as("restloc.description")).add(
					Projections.property("muser.mobilePhone").as("restloc.zipCode")).add(
					Projections.property("muser.password").as("restloc.address"))));
			managers = (ArrayList<RestaurantLocation>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}
		return managers;
	}

	/* Get locations assigned to deal manager */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocation> getLocationsOfDealMgr(int userId)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantLocation> locations = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantLocation.class, "location");
			criteria.createAlias("location.user", "user");
			criteria.add(Restrictions.eq("user.userId", userId));
			criteria.setProjection(Projections.distinct(Projections.projectionList().add(
					Projections.property("location.restLocationId").as("location.restLocationId"))
					.add(
							Projections.property("location.locationRestName").as(
									"location.locationRestName"))));
			locations = (ArrayList<RestaurantLocation>) criteria.list();
			//	
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}
		return locations;
	}

	/* Return password for the user on role basis */
	@SuppressWarnings("unchecked")
	public String getPassword(String emailId, int roleId) throws ApplicationException {
		String currentPassword = null;
		Session session = getSession(false);
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.FORGOT_PASSWORD_SELECT_QUERY_ROLEID);
			query.setParameter(0, emailId);
			query.setParameter(1, roleId);
			List results = query.list();
			Iterator itr = results.iterator(); 
			if (itr.hasNext()) {
				Object columns = (Object) itr.next();
				currentPassword = (String) columns;
			}

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return currentPassword;
	}

	/*
	 *  Save the referral 
	 * */
	public void saveRefferal(AmbReferences amb, int reffercode) throws ApplicationException {
 
		Session session = getSession(false);
		
		try {
			session.save(amb);
			SQLQuery query = session.createSQLQuery(TangotabConstants.UPDATE_REFERAL_COUNT);
			query.setParameter(0, reffercode);

			query.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			
		}

	}

	/*
	 * By refer code get all new ambassadors 
	 * */
	public Ambassador getAmbassadorbyReffCode(int reffercode) throws ApplicationException {

		Session session = getSession(false);
		Ambassador repInfo = null;
		try {
			Criteria criteria = session.createCriteria(Ambassador.class);
			criteria.add(Restrictions.eq("ambId", reffercode));
			repInfo = (Ambassador) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		}finally{
			
		}
		return repInfo;
	}

	/*
	 * Save payment profile 
	 * */
	public void savePaymentProfile(RestaurantPaymentProfile pprofile) throws ApplicationException {

		Session session = getSession(false);
		
		try {
			session.save(pprofile);
			
		} catch (Exception e) {
			e.printStackTrace();

			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}

	}

	/*
	 * Get payment profile 
	 * */
	public RestaurantPaymentProfile getPaymentProfile(int profileId) throws ApplicationException {

		Session session = getSession(false);
		RestaurantPaymentProfile paymentProfile = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantPaymentProfile.class, "profile")
					.add(Restrictions.eq("profile.paymentProfileId", profileId));

			paymentProfile = (RestaurantPaymentProfile) criteria.uniqueResult();

		} catch (Exception e) {
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return paymentProfile;
	}

	/*
	 * save the credit card profile 
	 * */
	public int saveCcProfile(RestaurantCcProfile ccprofile) throws ApplicationException {
		Session session = getSession(false);
		
		try {
			ccprofile = (RestaurantCcProfile) session.merge(ccprofile);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return ccprofile.getRestaurantCcProfileId();
	}

	/*
	 * Get restaurant ccprofile details
	 * */
	public RestaurantCcProfile getCcProfile(int restId) throws ApplicationException {

		Session session = getSession(false);
		RestaurantCcProfile ccProfile = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantCcProfile.class, "profile");
			criteria.createAlias("profile.restaurant", "restaurant").add(
					Restrictions.eq("restaurant.restaurantId", restId));

			ccProfile = (RestaurantCcProfile) criteria.uniqueResult();

		} catch (Exception e) {
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return ccProfile;
	}

	/*
	 *  Get Payment profile details of a profile id
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantPaymentProfile> getPaymentProfiles(int profileId)
			throws ApplicationException {

		Session session = getSession(false);
		ArrayList<RestaurantPaymentProfile> paymentProfile = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantPaymentProfile.class, "profile");
			criteria.createAlias("profile.restaurantCcProfile", "restaurantCcProfile").add(
					Restrictions.eq("restaurantCcProfile.restaurantCcProfileId", profileId));

			paymentProfile = (ArrayList<RestaurantPaymentProfile>) criteria.list();

		} catch (Exception e) {
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return paymentProfile;
	}

	/*
	 * Get all roles for the email id 
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList<String> getRolesByEmail(String emailId) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<String> roles = null;
		try {
			Criteria criteria = session.createCriteria(User.class, "user");
			criteria.createAlias("user.role", "role");
			criteria.add(Restrictions.eq("user.emailId", emailId));
			criteria.add(Restrictions.eq("user.isActive", Short.parseShort("1")));
			criteria.setProjection(Projections.distinct(Projections.projectionList().add(
					Projections.property("role.roleId").as("roleId"))));
			roles = (ArrayList<String>) criteria.list();
		} catch (Exception e) {
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return roles;
	}
	
	/*
	 * Get event details by event id 
	 * */
	public Events getEventById(Integer id)throws ApplicationException{
		Session session = getSession(false);
		Events event = new Events();
		try{
		Criteria criteria = session.createCriteria(Events.class, "event");
		criteria.add(Restrictions.eq("event.eventId", id));
		event = (Events)criteria.uniqueResult();
		}catch (Exception e) {
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return event;
	}

 /*
  * Get the security questions by email 
  * */
	public User getQuestionsByEmail(String emailId, Integer roleId) throws ApplicationException {
		Session session = getSession(false);

		User role = null;
		try {
			Criteria criteria = session.createCriteria(User.class, "user");
			criteria.createAlias("user.role", "role");
			criteria.add(Restrictions.eq("user.emailId", emailId));
			criteria.add(Restrictions.eq("role.roleId", roleId));
			criteria.setProjection(
					Projections.distinct(Projections.projectionList().add(
							Projections.property("user.question1").as("question1")).add(
							Projections.property("user.answer1").as("answer1")).add(
							Projections.property("user.question2").as("question2")).add(
							Projections.property("user.answer2").as("answer2")).add(
							Projections.property("user.emailId").as("emailId"))))
					.setResultTransformer(new AliasToBeanResultTransformer(User.class)); 
			role = (User) criteria.uniqueResult();

		} catch (Exception e) {
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return role;
	}

	public void deleteConsumerPreferCity(int consumerID) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of deleteConsumerPreferences");
		Session session = getSession(false);
		
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.DELETE_CONSUMER_PREFERCITY_QUERY);
			query.setParameter(0, consumerID);
			query.executeUpdate();
			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
	}

	public void deleteConsumerEvents(int consumerID) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of deleteConsumerPreferences");
		Session session = getSession(false);
		
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.DELETE_CONSUMER_EVENT_QUERY);
			query.setParameter(0, consumerID);
			query.executeUpdate();
			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
	}
	
	/*
	 * Get the debit status of restaurant (auto debit or invoice) 
	 * */
	@SuppressWarnings("unchecked")
	public String getIsAutoDebit(int restId) throws ApplicationException {
		String isautodebit = null;
 
		Session session = getSession(false);
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.REST_IS_AUTO_DEBIT);
			query.setParameter(0, restId);
			
			List results = query.list();
			Iterator itr = results.iterator();

			if (itr.hasNext()) {
				Object columns = (Object) itr.next();
 
				isautodebit = columns.toString();
			}

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return isautodebit;
	}
	/*
	 * Get Restaurant Reports  
	 */
	@SuppressWarnings("unchecked")
	public ArrayList< ReportTO> getRestaurantReports() throws ApplicationException {
 
		Session session = getSession(false);
		ArrayList< ReportTO> arrayList=new ArrayList<ReportTO>();
		try {
			SQLQuery query = session.createSQLQuery("SELECT  u.MOBILE_PHONE,u.PASSWORD,getState(state_id) as STATE_NAME,EMAIL_ID,FIRSTNAME ,LASTNAME,NO_OF_LOCATIONS,ADDRESS,ADDRESS1,BUSINESS_NAME,city_id," +
					"USER_CREATE_DATE,ZIP_CODE,SALES_REP_NAME,SALES_REP_EMAILID    FROM user u, restaurant r " +
					"WHERE u.role_id=5    and r.user_id=u.user_id order by u.user_create_date desc");
			query.setResultTransformer(new AliasToBeanResultTransformer(ReportTO.class));
			arrayList=(ArrayList<ReportTO>)	query.list();

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return arrayList;
	}
	
	/*
	 * For Reports 
	 * */
	@SuppressWarnings("unchecked")
	public ArrayList< ReportTO> getUserPrefReports(QueryTO queryTo) throws ApplicationException {
  
		Session session = getSession(false);
		ArrayList< ReportTO> arrayList=new ArrayList<ReportTO>();
		try {
			String guestQuery = TangotabConstants.GET_ALL_DINERS_REPORT;
			if(queryTo.getGetAll().equals("No")){
			      guestQuery = TangotabConstants.GET_LIMITED_DINERS_REPORT;
			      
			}
			
			SQLQuery query = session.createSQLQuery(guestQuery);
			if(queryTo.getGetAll().equals("No")){
			query.setParameter(0, queryTo.getStartDate());
			query.setParameter(1, queryTo.getEndDate());
			}
			query.setResultTransformer(new AliasToBeanResultTransformer(ReportTO.class));
			arrayList=(ArrayList<ReportTO>)	query.list();
	 
		//	arrayList.addAll(getUserWithoutPrefReports());
		
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return arrayList;
	}
	
	/* For guest repots */
	@SuppressWarnings("unchecked")
	public ArrayList< ReportTO> getUserWithoutPrefReports() throws ApplicationException {
 
		Session session = getSession(false);
		ArrayList< ReportTO> arrayList=new ArrayList<ReportTO>();
		try {
			SQLQuery query = session.createSQLQuery("select EMAIL_ID,FIRSTNAME ,LASTNAME,ADDRESS,ADDRESS1,city_id ,ZIP_CODE, USER_CREATE_DATE,getRefferedBy(user_id) as reffedBy from user  where role_id=4   and  user_id  not in (select user_id from consumer_prefercity)    ORDER BY  USER_CREATE_DATE desc");
			query.setResultTransformer(new AliasToBeanResultTransformer(ReportTO.class));
			arrayList=(ArrayList<ReportTO>)	query.list();
 
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return arrayList;
	}

	
	/*
	 * Random deals for index page 
	 * */
	@SuppressWarnings({ "unchecked", "static-access" })
	public ArrayList<RestaurantDeal> getHotDeals(SearchTO searchCriteria)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");

			criteria.createAlias("deal.restaurantLocation", "restaurantLocation");
			criteria.createAlias("restaurantLocation.restaurant", "rest");
			criteria.createAlias("restaurantLocation.user", "user");
			List<Criterion> criterions = new ArrayList<Criterion>();

			if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
				criteria.createAlias("restaurantLocation.city", "city");
				criterions.add(Restrictions.eq("city.cityName", searchCriteria.getCityName()));
			}
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				criterions.add(Restrictions.eq("restaurantLocation.zipCode", searchCriteria
						.getZipCode()));
			}
			Disjunction disjunction = Restrictions.disjunction();
			for (Criterion criterion : criterions) {
				disjunction.add(criterion);
			}
			criteria.add(disjunction);
			Conjunction con = Restrictions.conjunction();
			Conjunction con1 = Restrictions.conjunction();
			Disjunction dis = Restrictions.disjunction();
			criterions = new ArrayList<Criterion>();
			if (searchCriteria.getPriceStartRate() != null
					&& searchCriteria.getPriceStartRate() != "") {
				List<Criterion> priceCriterions = new ArrayList<Criterion>();
				priceCriterions.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getStartPrice()));
				priceCriterions.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getStartPrice()));
				List<Criterion> priceCriterions1 = new ArrayList<Criterion>();
				priceCriterions1.add(Restrictions.le("restaurantLocation.priceStartRate",
						searchCriteria.getEndPrice()));
				priceCriterions1.add(Restrictions.ge("restaurantLocation.priceEndRate",
						searchCriteria.getEndPrice()));
				for (Criterion criterion : priceCriterions) {
					con.add(criterion);
				}
				for (Criterion criterion : priceCriterions1) {
					con1.add(criterion);
				}
			}
			dis.add(con);
			dis.add(con1);

			if (searchCriteria.getCuisineType() != 0) {
				criteria.createAlias("restaurantLocation.locationPreferences",
						"locationPreferences");
				criteria.createAlias("locationPreferences.cuisineTypeId", "cusineType",
						criteria.INNER_JOIN, Restrictions.eq("cuisineTypeId", searchCriteria
								.getCuisineType()));
			}

			if (searchCriteria.getDiningStyle() != 0) {
				criteria.createAlias("restaurantLocation.diningPreferences", "diningPreferences");
				criteria.createAlias("diningPreferences.cuisineTypeId", "dining",
						criteria.INNER_JOIN, Restrictions.eq("diningStyleId", searchCriteria
								.getDiningStyle()));
			}
			if (searchCriteria.getRating() != 0) {
				criterions.add(Restrictions.eq("restaurantLocation.rating", searchCriteria
						.getRating()));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			criteria.add(dis);
			
			criteria.add(Restrictions.eq("deal.restDealPublishStatus",
					TangotabConstants.DEAL_PUBLISH_STATUS));
			
			DetachedCriteria maxdebit = DetachedCriteria.forClass(ConfigPojo.class)
		    .setProjection( Property.forName("creditUserDeal"));
			Conjunction crconj = Restrictions.conjunction();
			List<Criterion> credits = new ArrayList<Criterion>();
		    credits.add( Property.forName("rest.currentCredits").gt(maxdebit) );
		    credits.add(Restrictions.eq("rest.billingMethodId", 1));
		    for(Criterion credit:credits){
		    	crconj.add(credit);
		    }
		    Disjunction crdisj = Restrictions.disjunction();
		    crdisj.add(crconj);
		    crdisj.add(Restrictions.eq("rest.billingMethodId", 2));
		    criteria.add(crdisj);
		    
			criteria.add(Restrictions.gtProperty("deal.availableDealsQty", "deal.usedDealsQty"));
			Calendar calendar = Calendar.getInstance();
			Date today = new Date();
			calendar.setTime(today);
			/* restDealEndDate is set to that date and 00 hrs and 00 mins
			 * and to get current day deals */
			calendar.add(Calendar.HOUR, -24);
			today = calendar.getTime();
			criteria.add(Restrictions
					.gt("deal.restDealEndDate", new java.sql.Date(today.getTime())));
			/* Here is the filtration for deals whose availability is not there for today
			 * (availableweekdays) but end date is farther. In that case the deal is tested for
			 * today availability and if available then tat date is less than end date, like tat 
			 * it is tested for (mon,tues,..,sun). */
			Disjunction dsj = Restrictions.disjunction();
			for(int i = 0; i < 7; i++){
				String s1 =DateConverterUtility.getDayNumber(calendar.getTime()); 
				java.sql.Date dd = new java.sql.Date(today.getTime());
				Conjunction cons = Restrictions.conjunction();
				List<Criterion> dateCriterions = new ArrayList<Criterion>();
				dateCriterions.add(Restrictions
						.gt("deal.restDealEndDate", dd  ));
				dateCriterions.add(Restrictions
						.like("deal.availableWeekDays", "%"+s1+"%" ));
				for(Criterion cr:dateCriterions)
					cons.add(cr);
				dsj.add(cons);
				calendar.add(Calendar.DATE, 1);
				today = calendar.getTime();
			}
			criteria.add(dsj);
			
			criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
			 
			criteria.setMaxResults(5);

			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			
		}
		return deals;

	}

	/* For Booked Deal  repots */
	 @SuppressWarnings("unchecked")
	public ArrayList< ReportTO> getUserBookDealReports(Date startDate,Date endDate ) throws ApplicationException {
 
		Session session = getSession(false);
		ArrayList< ReportTO> arrayList=new ArrayList<ReportTO>();
		try {
			SQLQuery query = session.createSQLQuery("select SALES_REP_NAME,IS_CONSUMER_SHOWN_UP, BUSINESS_NAME, firstname,lastname	 ,email_id ," +
					" rl.city_id, getCity(rl.prefer_city_id) as preferCity,rl.LOCATION_REST_NAME ,BOOKED_DATE ,REST_DEAL_NAME,cr.REST_DEAL_ID,CON_RES_ID,RESERVED_TIMESTAMP" +
					 " ,getRefferedBy(u.user_id) as reffedBy,cr.source  from restaurant_location rl,consumer_reservation cr,user u,restaurant_deal r,restaurant res  where " +
					" res.restaurant_id=rl.restaurant_id and r.rest_location_id=rl.rest_location_id and u.user_id=cr.user_id and  r.rest_deal_id=cr.rest_deal_id and  " +
					" ( date(RESERVED_TIMESTAMP) between  ? and ?) order by BUSINESS_NAME   ");
		 
			Date today=new Date();
			if(endDate.after(today))
			{
			//	endDate=today;
			}
			query.setDate(0, new java.sql.Date(startDate.getTime()));
			query.setDate(1, new java.sql.Date(endDate.getTime()));

			query.setResultTransformer(new AliasToBeanResultTransformer(ReportTO.class));
			arrayList=(ArrayList<ReportTO>)	query.list();
 
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			
		}
		return arrayList;
	} 


public void saveHomeUser(HomeSignUp homeSignUp) throws ApplicationException {
	Session session = getSession(false);
	
 try
 {
	 if(homeSignUp.getEmailId()!=null)
	 {
	HomeSignUp homeSignUp2 =isHomeUser(homeSignUp.getEmailId());
	if(homeSignUp2!=null)
	{
		homeSignUp.setHomeId(homeSignUp2.getHomeId());
		homeSignUp.setSignupDate(homeSignUp2.getSignupDate());
		 session.update(homeSignUp);
	}
	 else
	 {
		 session.save(homeSignUp);
	 }
	 }
	 
 }catch (Exception ex) {
		if (log.isErrorEnabled()) {
			log.error(ex.getMessage());
		}
	
		ex.printStackTrace();
		throw new ApplicationException("DB002", TangotabConstants.ERROR);
	} finally {
		
	}
	
}

private HomeSignUp isHomeUser(String emailId)  throws ApplicationException {
		Session session = getSession(false);
		 
	 try
	 {
		Criteria criteria=  session.createCriteria(HomeSignUp.class, "criteria"); 
		criteria.add(Restrictions.eq("criteria.emailId",emailId));
		HomeSignUp homeSignUp=null;
		homeSignUp=(HomeSignUp)criteria.uniqueResult();
 return homeSignUp;
	 
	 }catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
	 
			ex.printStackTrace();
			
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
			
		} finally {
			
		}
		
	}
@SuppressWarnings("unchecked")
public ArrayList<ReportTO> getHomeSignUp() throws ApplicationException {
 
		 
			Session session = getSession(false);
			ArrayList< ReportTO> arrayList=new ArrayList<ReportTO>();
			try {
				Criteria criteria =session.createCriteria(HomeSignUp.class,"homesign");
				 
	
			 
				
				criteria.setProjection(Projections.projectionList().add(Projections.property("emailId").as("EMAIL_ID"))
						.add(Projections.property("preferCity").as("preferCity"))
						.add(Projections.property("signupDate").as("USER_CREATE_DATE")));
				criteria.setResultTransformer(new AliasToBeanResultTransformer(ReportTO.class));
				arrayList=(ArrayList<ReportTO>)	criteria.list();
	 
	 }catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
	 
			ex.printStackTrace();
			
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
			
		} finally {
			
		}
		return arrayList;
		
	}
public ArrayList<DealTO> searchDealsort(SearchTO searchCriteria,int count)
throws ApplicationException {
	
	Session session = getSession(false);
	ArrayList<DealTO> arrayList=new 	ArrayList<DealTO>();
	try
	{
	   Date today = new Date();
 	   Calendar cal = Calendar.getInstance();
 	   cal.setTime(today);
 	   cal.set(Calendar.HOUR, 0);
 	   cal.set(Calendar.MINUTE, 0);
 	   cal.set(Calendar.SECOND, 0);
 	   cal.set(Calendar.MILLISECOND, 0);
 	   int hr = cal.get(Calendar.HOUR_OF_DAY);
	   cal.add(Calendar.HOUR_OF_DAY, -hr);
 	   today = cal.getTime();  
		 
		 
		StringBuffer querystring=new StringBuffer("select rd.* ");
		
		int i = 0;

		double lat = 0.0;
		double lon = 0.0;
		String countryCode = null;
		String url="";
		/* For fetching the CountryNameCode from JSON object and set longitude and latitude */
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				searchCriteria.setZipCode(searchCriteria.getZipCode().replace(" ", "%20"));
				try{
				url = "http://maps.googleapis.com/maps/geo?q="+ searchCriteria.getZipCode()+ "&output=json&sensor=true";
				url = url.replace("#", ",");
				url = url.replace("$", ",");
				url = url.replace("\n", "");
				url = url.replace("\r", "");
				InputStream inStream = null;

				URL getURL = new URL(url);
				getURL.openConnection().setConnectTimeout(15000);

				inStream = getURL.openConnection().getInputStream();
				byte[] b = new byte[inStream.available()];
				inStream.read(b);
				String jsonContent = new String(b);
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(jsonContent);

				JSONObject jsonObject = (JSONObject) obj;

				JSONArray msg = (JSONArray) jsonObject.get("Placemark");

				
				for (int j = 0; j < msg.size(); j++) {
					
					JSONObject jsonLineItem = (JSONObject) msg.get(j);
					JSONObject jsonLineItem2 = (JSONObject) jsonLineItem.get("AddressDetails");
					JSONObject jsonLineItem3 = (JSONObject) jsonLineItem2.get("Country");
					countryCode = jsonLineItem3.get("CountryNameCode").toString();

				}
	   		}
	   		catch (Exception e) {
	   			e.printStackTrace();
	   		}

	   		if(StringUtils.isEmpty(countryCode)  || countryCode == null){
	   			url = "http://maps.googleapis.com/maps/geo?q="+ searchCriteria.getZipCode()+ "&output=csv&sensor=true";
	   			}
	   		else if (countryCode.equals("US")) {
					url = "http://maps.googleapis.com/maps/geo?q="+ searchCriteria.getZipCode()+ ",US&output=csv&sensor=true";
				}
	   		else if (countryCode.equals("CA")) {
					url = "http://maps.googleapis.com/maps/geo?q="+ searchCriteria.getZipCode()+ ",CA&output=csv&sensor=true";
				}
	   		else{
	   			url = "http://maps.googleapis.com/maps/geo?q="+ searchCriteria.getZipCode()+ "&output=csv&sensor=true";
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
						lat = Double.parseDouble(csv[2]);
						lon = Double.parseDouble(csv[3]);

					}
				}
	   		}catch(Exception e){
	   			lat = 0.0;
	   			lon = 0.0;
	   			log.error("didn't fetch lat, long for this location: ", e);
	   		}
				querystring.append(" , getDistance(?,?,LATITUDE,LONGITUDE) as distance ");
				
			}
			
		querystring.append(" ,c.city_name ,getAvailableDate(?,rd.availableStartTime, rd.availableEndTime, rd.availableWeekDays) as  dealStartDate  ");
		querystring.append(" from restaurantdeals  rd, restaurant_location rl, city c where   restLocationId=rest_location_id and rl.prefer_city_id=c.city_id  ");


		if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
			querystring.append(" and rl.prefer_city_id=(select city_id from city where city_name=?  and is_active=1 group by city_name)");
			  
		}		
		
		if( StringUtils.isNotEmpty(searchCriteria.getRestauntName() )){
			querystring.append(" and rd.locationRestName= ? ");
		 
		} 
		

		if (searchCriteria.getPriceStartRate() != null
				&& searchCriteria.getPriceStartRate() != ""  ) {
			
			querystring.append(" and ((  rl.PRICE_START_RATE<= ? ");
			querystring.append(" and rl.PRICE_END_RATE>= ?  ) ");
			

			querystring.append("  or( rl.PRICE_START_RATE<= ? ");
			querystring.append(" and rl.PRICE_END_RATE>= ?  ))");
		 
		 
		}
		if (searchCriteria.getDiningStyle() != 0) {
			
			querystring.append(" and rest_location_id in ( select rest_location_id from  restaurant_dininig_style_preferences where  dining_style_id=?) ");
			 
		}

		if (searchCriteria.getCuisineType() != 0) {
			
			querystring.append(" and  rest_location_id in ( select restaurant_location_id from  restaurant_location_preference where  cuisine_type_id=?) ");
			 
		}
		/* If Date is set, then future date should be on or before rest deal end date and there should be availability on the future date */
     if (searchCriteria.getDealAvailDate() != null) {
    	  
    	   querystring.append(" and rd.availableWeekDays like ?");
    	   
    	   if(searchCriteria.getDealAvailDate().compareTo(today) == 0 ){
    		   querystring.append(" and (rd.dealStartDate) <= ? ");
    		      		   
    	   }else{    	   
    	   querystring.append(" and rd.restDealEndDate >=  ?");
    	   querystring.append(" and rd.restDealStartDate <=  ?");
    	   }
    	  
		}
		/* Restrict distance less than 25miles */
     if (StringUtils.isNotEmpty(searchCriteria.getZipCode())&&searchCriteria.isNear()) {
		 
			//querystring.append(" and rl.zip_code= ? and distance <25 ");
			querystring.append(" and getDistance(?,?,LATITUDE,LONGITUDE)< ? ");
		}
     
     querystring.append(" order by ");
     if(searchCriteria.getDealAvailDate().compareTo(today) == 0 ){
     querystring.append("    (date(dealStartDate)-date(now())) ,");
     }
     if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
           querystring.append(" distance , ");
     }
     querystring.append(" dealStartDate ");

		querystring.append("  limit ?,10 ");
 
		SQLQuery query = session.createSQLQuery(querystring.toString());
		if (StringUtils.isNotEmpty(searchCriteria.getZipCode())) {
				 //query.setString(i,  searchCriteria.getZipCode());
				 //i++;
			
			query.setDouble(i, lat);
			i++;
			query.setDouble(i, lon);
			i++;
		}
		query.setDate(i, searchCriteria.getDealAvailDate()  );
		i++;
		if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
			  query.setString(i,  searchCriteria.getCityName());
			 i++;
		}
		
		if( StringUtils.isNotEmpty(searchCriteria.getRestauntName() )){
			 query.setString(i,  searchCriteria.getRestauntName());
			 i++;
		 
		}
		if (searchCriteria.getPriceStartRate() != null
				&& searchCriteria.getPriceStartRate() != ""  ) {
			
			query.setDouble(i,  searchCriteria.getStartPrice());
			i++;
			query.setDouble(i,  searchCriteria.getStartPrice());
			i++;
			query.setDouble(i, searchCriteria.getEndPrice()  );
			i++;	
		
			query.setDouble(i, searchCriteria.getEndPrice()  );
			i++;
			 
		 
		}
		
		if (searchCriteria.getDiningStyle() != 0) {
			
			query.setInteger(i, searchCriteria.getDiningStyle()  );
			i++;
			 
		}
	if (searchCriteria.getCuisineType() != 0) {
			
			query.setInteger(i, searchCriteria.getCuisineType()  );
			i++;
			 
		}
	if (searchCriteria.getDealAvailDate() != null) {
		 String day = "%"+DateConverterUtility.getDayNumber(searchCriteria.getDealAvailDate())+"%";
		 query.setString(i, day);
		 i++;
		 
		/* if(searchCriteria.getDealAvailDate().compareTo(today) == 0){
			 query.setDate(i, today);
			 i++;
			 cal.add(Calendar.HOUR, 24);
			 today = cal.getTime();
			 query.setDate(i, today);
			 i++;
			 
		 }*/
		 if(searchCriteria.getDealAvailDate().compareTo(today) != 0){
		 query.setDate(i, searchCriteria.getDealAvailDate());
		 i++;
		 query.setDate(i, searchCriteria.getDealAvailDate());
		 i++;
		 }
		 if(searchCriteria.getDealAvailDate().compareTo(today) == 0){
			 cal.setTime(new Date());
			 cal.add(Calendar.HOUR, +24);
			 query.setTimestamp(i, cal.getTime());
			 i++;
			 }
		 
	}

	if (StringUtils.isNotEmpty(searchCriteria.getZipCode())&&searchCriteria.isNear()) {
		//	 query.setString(i,  searchCriteria.getZipCode());
		//	 i++;
			query.setDouble(i, lat);
			i++;
			query.setDouble(i, lon);
			i++;
			query.setDouble(i, 25.0);
			i++;
		}
	
			query.setInteger(i,  (count-1)*10);
			i++;
			
			query.setResultTransformer(new AliasToBeanResultTransformer(DealTO.class));
			
			arrayList=(ArrayList<DealTO>)	query.list();

} catch (Exception e) {
	e.printStackTrace();
	throw new ApplicationException("DB003", TangotabConstants.ERROR);
} finally {
	
}
return arrayList;

}

public int  countSearchDealsort(SearchTO searchCriteria)
throws ApplicationException {
	
	Session session = getSession(false);
	ArrayList<DealTO> arrayList=new 	ArrayList<DealTO>();
	Integer count = 0;
	try
	{
		Date today = new Date();
		
	 	   Calendar cal = Calendar.getInstance();
	 	  
	 	   cal.setTimeInMillis(today.getTime());
	 	   cal.set(Calendar.HOUR, 0);
	 	   cal.set(Calendar.MINUTE, 0);
	 	   cal.set(Calendar.SECOND, 0);
	 	   cal.set(Calendar.MILLISECOND, 0);
	 	   int hr = cal.get(Calendar.HOUR_OF_DAY);
	 	   cal.add(Calendar.HOUR_OF_DAY, -hr);
	 	   today = cal.getTime(); 
	 	  StringBuffer querystring=new StringBuffer("select count(*) from restaurantdeals  rd, restaurant_location rl where   restLocationId=rest_location_id");
	 	    double lat=0.0;
			double lon=0.0;
			String countryCode = null;
			String url="";
			/* Counting search deals based on distance*/
			if (StringUtils.isNotEmpty(searchCriteria.getZipCode())&&searchCriteria.isNear()) {
				searchCriteria.setZipCode(searchCriteria.getZipCode().replace(" ", "%20"));
				try{
					
					 url = "http://maps.googleapis.com/maps/geo?q="
							+ searchCriteria.getZipCode()
							+ "&output=json&sensor=true";
					url = url.replace("#", ",");
					url = url.replace("$", ",");
					url = url.replace("\n", "");
					url = url.replace("\r", "");
					InputStream inStream = null;
	  	             URL getURL = new URL(url);
						getURL.openConnection().setConnectTimeout(15000);

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
							JSONObject jsonLineItem2 = (JSONObject) jsonLineItem.get("AddressDetails");
							JSONObject jsonLineItem3 = (JSONObject) jsonLineItem2.get("Country");
							countryCode = jsonLineItem3.get("CountryNameCode").toString();

						}
					}
					catch (Exception e) {
						e.printStackTrace(); 
					}
						
				
					if(StringUtils.isEmpty(countryCode)  || countryCode == null){
						url = "http://maps.googleapis.com/maps/geo?q="
									+ searchCriteria.getZipCode()
									+ "&output=csv&sensor=true";
					}	
					else if (countryCode.equals("US")) {
						url = "http://maps.googleapis.com/maps/geo?q="
									+ searchCriteria.getZipCode()
									+ ",US&output=csv&sensor=true";
					}
					else if (countryCode.equals("CA")) {
						url = "http://maps.googleapis.com/maps/geo?q="
									+ searchCriteria.getZipCode()
									+ ",CA&output=csv&sensor=true";
					}else
						url = "http://maps.googleapis.com/maps/geo?q="
							+ searchCriteria.getZipCode()+ "&output=csv&sensor=true";
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
								lat = Double.parseDouble(csv[2]);
								lon = Double.parseDouble(csv[3]);

							}
						}
					}catch(Exception e){
						lat = 0.0;
						lon = 0.0;
					}
				querystring.append(" and getDistance(?,?,LATITUDE,LONGITUDE)< ? ");
			}
		
		int i=0;


		if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
			querystring.append(" and rl.prefer_city_id=(select city_id from city where city_name=?  and is_active=1 group by city_name)");
			  
		}		

		if( StringUtils.isNotEmpty(searchCriteria.getRestauntName() )){
			querystring.append(" and rd.locationRestName= ? ");
		 
		} 
		

		if (searchCriteria.getPriceStartRate() != null
				&& searchCriteria.getPriceStartRate() != ""  ) {
			
			querystring.append(" and ((  rl.PRICE_START_RATE<= ? ");
			querystring.append(" and rl.PRICE_END_RATE>= ?  ) ");
			

			querystring.append("  or( rl.PRICE_START_RATE<= ? ");
			querystring.append(" and rl.PRICE_END_RATE>= ?  ))");
		 
		 
		}
		if (searchCriteria.getDiningStyle() != 0) {
			
			querystring.append(" and  rest_location_id in ( select rest_location_id from  restaurant_dininig_style_preferences where  dining_style_id=?) ");
			 
		}

		if (searchCriteria.getCuisineType() != 0) {
			
			querystring.append(" and  rest_location_id in ( select restaurant_location_id from  restaurant_location_preference where  cuisine_type_id=?) ");
			 
		}
		
		 if (searchCriteria.getDealAvailDate() != null) {
	    	  
	    	   querystring.append(" and rd.availableWeekDays like ?");
	    	   
	    	   if(searchCriteria.getDealAvailDate().compareTo(today) == 0){
	    		   querystring.append(" and date(rd.dealStartDate) <=?");
	    	   }
	    	   else{ 
	    		   querystring.append(" and rd.restDealEndDate >=  ?");
	    		   querystring.append(" and rd.restDealStartDate <=  ?");
	    	   }
	    	
		}
		SQLQuery query = session.createSQLQuery(querystring.toString());

		if (StringUtils.isNotEmpty(searchCriteria.getZipCode())&&searchCriteria.isNear()) {
				query.setDouble(i, lat);
				i++;
				query.setDouble(i, lon);
				i++;
				query.setDouble(i, 25.0);
				i++;
		}
		if (StringUtils.isNotEmpty(searchCriteria.getCityName())) {
			  query.setString(i,  searchCriteria.getCityName());
			 i++;
		}

		if( StringUtils.isNotEmpty(searchCriteria.getRestauntName() )){
			 query.setString(i,  searchCriteria.getRestauntName());
			 i++;
		 
		}
		if (searchCriteria.getPriceStartRate() != null
				&& searchCriteria.getPriceStartRate() != ""  ) {
			
			query.setDouble(i,  searchCriteria.getStartPrice());
			i++;
			query.setDouble(i,  searchCriteria.getStartPrice());
			i++;
			query.setDouble(i, searchCriteria.getEndPrice()  );
			i++;	
		
			query.setDouble(i, searchCriteria.getEndPrice()  );
			i++;
			 
		 
		}
		if (searchCriteria.getDiningStyle() != 0) {
			
			query.setInteger(i, searchCriteria.getDiningStyle()  );
			i++;
			 
		}
	if (searchCriteria.getCuisineType() != 0) {
			
			query.setInteger(i, searchCriteria.getCuisineType()  );
			i++;
			 
		}
	
	if (searchCriteria.getDealAvailDate() != null) {
		 String day = "%"+DateConverterUtility.getDayNumber(searchCriteria.getDealAvailDate())+"%";
		 query.setString(i, day);
		 i++;
		 /*if(searchCriteria.getDealAvailDate().compareTo(today)==0){
			 query.setDate(i, today);
			 i++;
			 cal.add(Calendar.HOUR, 24);
			 today = cal.getTime();
			 query.setDate(i, today);
			 i++;
			 
		 }*/
		 if(searchCriteria.getDealAvailDate().compareTo(today)!=0){
		 query.setDate(i, searchCriteria.getDealAvailDate());
		 i++;
		 query.setDate(i, searchCriteria.getDealAvailDate());
		 i++;
		 }
		 if(searchCriteria.getDealAvailDate().compareTo(today) == 0){
			 cal.setTime(new Date());
			 cal.add(Calendar.HOUR, +24);
			 query.setTimestamp(i, cal.getTime());
			 i++;
			 }
		 
	}
			
			count = ( (BigInteger)query.uniqueResult() ).intValue();
			

} catch (Exception e) {
	e.printStackTrace();
	throw new ApplicationException("DB003", TangotabConstants.ERROR);
} finally {
	
}
return count;

}

private void updateWebLoginCount(int userId) throws ApplicationException {
 

	Session session = getSession(false);
	
	try {
		SQLQuery query = session.createSQLQuery(TangotabConstants.UPDATE_LOGIN_COUNT);
		query.setParameter(0, userId);
		
		 query.executeUpdate();
		 
		 

	} catch (Exception ex) {
	
		if (log.isErrorEnabled()) {
			log.error(ex.getMessage());
		}
		ex.printStackTrace();
		throw new ApplicationException("DB002", TangotabConstants.ERROR);
	} finally {
		
		
	}
 
}

@SuppressWarnings("unchecked")
public  ArrayList<DealTO> sendDealexpireMails() throws ApplicationException {
 
	Session session = getSession(false);
	ArrayList<DealTO> arrayList=new 	ArrayList<DealTO>();
	try
	{ 
		SQLQuery query = session.createSQLQuery("select * from dealenddates"); 
		query.setResultTransformer(new AliasToBeanResultTransformer(DealTO.class)); 
			arrayList=(ArrayList<DealTO>)	query.list();

} catch (Exception e) {
	e.printStackTrace();
	throw new ApplicationException("DB003", TangotabConstants.ERROR);
} finally {
	
}
return arrayList;

}

/* Saves the charity count */
public void saveCharityCount(CharityDetails details) throws ApplicationException{
	
	Session session = getSession(false);
	
	try{
		session.save(details);
		
	} catch (Exception e) {
		e.printStackTrace();
	
		throw new ApplicationException("DB001", TangotabConstants.ERROR);
	} finally {
		
	}
	
}
public static void main(String a[])throws ApplicationException
{
	try
	{
	UserDAOImpl  userDAOImpl=new UserDAOImpl();
	//ArrayList< ReportTO> arrayList =userDAOImpl.getRestaurantReports();// 
	//System.out.println(arrayList.size());
	}catch (Exception e) {

		e.printStackTrace();
	}
}
public Integer getUserIdByMailId(String mailId)throws ApplicationException{
	Session session = getSession(false);
	Integer userid = 0;
	try{
		SQLQuery query = session.createSQLQuery(TangotabConstants.GET_USERID_BY_MAILID);
		query.setParameter(0, mailId);
		userid = (Integer)query.uniqueResult();
	}catch(Exception e){
		e.printStackTrace();
	}
	return userid;
}

public OfferDetailsTO getOffersDetails(Date startDate,Integer cityId) throws ApplicationException{
	Session session = getSession(false);
	Integer publishedcount = 0;
	Integer availablecount = 0;
	OfferDetailsTO details = new OfferDetailsTO();	
	try{		
		String queryString = TangotabConstants.GET_AVAILABLEOFFERS_QUERY;
		if(cityId > 0 )
			queryString += "and rl.PREFER_CITY_ID =?";
		SQLQuery query = session.createSQLQuery(queryString);
		String day = DateConverterUtility.getDayNumber(startDate);
		day = "%"+day + "%";
		query.setParameter(0, startDate);
		query.setParameter(1, startDate);
		query.setParameter(2, day);
		if(cityId > 0 )
		 query.setParameter(3, cityId);
		Object count = (Object)query.uniqueResult();
		availablecount = ObjectToInteger(count);
		queryString = TangotabConstants.GET_PUBLISHEDOFFERS_QUERY;
		if(cityId > 0 )
			queryString += "and rl.PREFER_CITY_ID =?";
		 query = session.createSQLQuery(queryString);
		query.setParameter(0, startDate);
		query.setParameter(1, startDate);
		if(cityId > 0 )
			query.setParameter(2, cityId);
		 count = (Object)query.uniqueResult();
		publishedcount = ObjectToInteger(count);
		details.setAvailableCount(availablecount);
		details.setPublishedCount(publishedcount);
		details.setDate(startDate);
		details.setCityId(cityId);
		//System.out.println(query);
	}catch(Exception e){
		e.printStackTrace();
	}
	return details;
}
 
private Integer ObjectToInteger(Object obj){
	Integer count = 0;
	if(obj instanceof Integer)
		count = (Integer)obj;
	else if(obj instanceof BigInteger)
		count = ((BigInteger)obj).intValue();
	return count;
	
}
public ArrayList<RevenueReportTO> getRevenueReport(QueryTO queryTO) throws ApplicationException{
	
	Session session = getSession(false);
	ArrayList<RevenueReportTO> report = new ArrayList<RevenueReportTO> ();	
	try{
	SQLQuery query = session.createSQLQuery(TangotabConstants.GET_REVENUE_REPORT);
	int param = 0;
	while(param < 10){
		query.setParameter(param++,queryTO.getStartDate());
		query.setParameter(param++, queryTO.getEndDate());
	}
	query.setResultTransformer(new AliasToBeanResultTransformer(RevenueReportTO.class)); 
	report = (ArrayList<RevenueReportTO>)query.list();
	}catch(Exception e){
		log.error("**RevenueReportError**",e);
	}
	return report;	
	
}

public int referAFriend(ExternalReferral refer) throws ApplicationException{
	Session session = getSession(false);
	
	int status = 0;
	SQLQuery query = session.createSQLQuery(TangotabConstants.INSERT_EXTERNAL_REFERRAL);
	try{
	query.setParameter(0, refer.getReferralEmailId());
	query.setParameter(1, refer.getFriendEmailId());
	query.setParameter(2, new Date());
	
	status = query.executeUpdate();
	
	}catch(Exception e){
		e.printStackTrace();
	
		}
 finally {
	
}
	return status;
	
}

public boolean changeRestaurantAutoDebit(int restaurantId, short status)
		throws ApplicationException {
	// TODO Auto-generated method stub
	Session session = getSession(false);
	
	SQLQuery query = session.createSQLQuery(TangotabConstants.CHANGE_RESTAURANT_IS_AUTO_DEBIT_NO_QUERY);
	int queryStatus = 0;
	try{
		query.setParameter(0,status);
		query.setParameter(1,restaurantId);
		queryStatus = query.executeUpdate();
		

	}catch(Exception e){
		e.printStackTrace();
	
		}
	finally {
		
	}
	if(queryStatus>0)
		return true;
	return false;
}

	@Override
    protected Class getBeanClass() {
        return User.class;
    }

public boolean updateOfferConfirmationStatus(int conresId, short status)throws ApplicationException{
	// TODO Auto-generated method stub
	Session session = getSession(false);
		
	SQLQuery query = session.createSQLQuery(TangotabConstants.UPDATE_OFFER_CONFIRMATION_STATUS);
	int queryStatus = 0;
	try{
		query.setParameter(0,status);
		query.setParameter(1,conresId);
		queryStatus = query.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
		  
		}
	finally {
		 
	}
	if(queryStatus>0)
		return true;
	return false;
}

public ConsumerReservation getReservationDetails(int conresId) throws ApplicationException{
	Session session = getSession(false);
	ConsumerReservation reservation = new  ConsumerReservation();
	Criteria criteria = session.createCriteria(ConsumerReservation.class, "reservation");
	try{
		//(ConsumerReservation)session.load(ConsumerReservation.class, conresId);
	criteria.add(Restrictions.eq("reservation.conResId", conresId));
	reservation = (ConsumerReservation)criteria.uniqueResult();
	
	}catch(Exception e){
		log.error("fetching reservation details: ", e);
	}finally{
		 
	}
	return reservation;
	
}

public void updateHostCredits(int restId)throws ApplicationException{
	
	Session session =  getSession(false);
	String query = TangotabConstants.RESTAURANT_CREDIT_QUANTITY_DECREASE_QUERY;
	query = query.replace(">", ">=");
	int querystatus = 0;
	try{
	SQLQuery sqlquery = session.createSQLQuery(query);
	sqlquery.setParameter(0, -1);
	sqlquery.setParameter(1, restId);	
	querystatus = sqlquery.executeUpdate();
	//transaction.commit();
	}catch(Exception e){
		log.error("while adding credits",e);
		  
	}finally{
		 
	}
}
	public Restaurant getRestaurantByConResId(int conresId) throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of deleteConsumerPreferences");
		Restaurant restaurant = new Restaurant();
		Session session = getSession(false);
		try {   
			/* Get Restaurant by consumer reservation id */
			SQLQuery query=session.createSQLQuery(TangotabConstants.GET_RESTAURANT_BY_CON_RES_ID);
			query.setInteger(0, conresId);
			Object[] object=(Object[])query.uniqueResult(); /* storing the values into object array */
			
			restaurant.setRestaurantId(Integer.parseInt(object[0].toString()));      /* setting restaurant details */
			restaurant.setCurrentCredits(Double.parseDouble(object[1].toString()));
			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
		}
		return restaurant;
	}
	
	public Landing getLandingBySource(String source) throws ApplicationException {
		Session session = getSession(false);
		Landing landing=new Landing();
		try {
			Criteria criteria = session.createCriteria(Landing.class, "landing");
			criteria.add(Restrictions.eq("landing.source", source));
			List list=criteria.list();
			if(list.size()>0)
				landing = (Landing) list.get(0);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			 
		}
		
		return landing;
	}
	
	/* Data fetch int Landig pojo from landing_url table, based on ambassador code */
	public Landing getLandingByRefferCode(int refferCode) throws ApplicationException {
		Session session = getSession(false);
		Landing landing=new Landing();
		try {
			/* Get ambassador name by ambassador id */
			SQLQuery query = session.createSQLQuery(TangotabConstants.GET_SOURCE_BY_REFFERED_CODE);
			query.setInteger(0, refferCode);
			String source=(String)query.uniqueResult();
			/* Get Landing by ambassador name if ambassador name is not empty*/
			System.out.println("source: "+source);
			if(source != null)
			landing = getLandingBySource( source );
			System.out.println("landing: "+landing.getUrl());
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		
		return landing;
	}
	
	@Override
	/**
	 * get restaurant wise deal booked consumers by passing restaurantid
	 */
	public ArrayList<ConsumerReservation> getRestaurantUserDealHistory(
			int restaurantId) throws ApplicationException {
		Session session =  getSession(false);
		ArrayList< ConsumerReservation> arrayList=new ArrayList<ConsumerReservation>();
		try{
			SQLQuery query=session.createSQLQuery("select u.FIRSTNAME,cr.USER_ID,cr.CON_RES_ID,cr.RESERVED_TIMESTAMP,rd.REST_DEAL_NAME,cr.IS_CONSUMER_SHOWN_UP,cr.BOOKED_DATE from consumer_reservation cr," +
					"user u,restaurant r,restaurant_location rl,restaurant_deal rd where " +
					"u.USER_ID=cr.USER_ID  and cr.REST_DEAL_ID=rd.REST_DEAL_ID and rd.REST_LOCATION_ID=rl.REST_LOCATION_ID and " + 
					"rl.RESTAURANT_ID=r.RESTAURANT_ID and r.RESTAURANT_ID="+restaurantId);
					
			List list=query.list();
			for(int i=0;i<list.size();i++)
			{
			                Object[]  obj=(Object[])list.get(i);
			                ConsumerReservation consumer=new ConsumerReservation();
			                RestaurantDeal restaurantDeal=new RestaurantDeal();
			                User user=new User();
			                user.setFirstname((String)obj[0]);
			                user.setUserId((Integer)obj[1]);
			                consumer.setConResId((Integer)obj[2]);
			                consumer.setReservedTimestamp((Timestamp)obj[3]);
			                restaurantDeal.setDealTemplateName((String)obj[4]);
			                consumer.setIsConsumerShownUp(Short.parseShort(obj[5].toString()));
			                consumer.setBookedTimestamp((Timestamp)obj[6]);
			                consumer.setUser(user);
			                consumer.setRestaurantDeal(restaurantDeal);
			                arrayList.add(consumer);  			                
			}
		        

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return arrayList;
	}
	
	@Override
	/**
	 * get restaurant wise deal booked consumers by passing restaurantid,startdate,end date
	 */
	public ArrayList<ConsumerReservation> getRestaurantUserDealHistory(
			int restaurantId,Date startDate,Date endDate) throws ApplicationException {
		
		
		Session session =  getSession(false);
		ArrayList< ConsumerReservation> arrayList=new ArrayList<ConsumerReservation>();
		try{
			StringBuffer queryString=new StringBuffer("select u.FIRSTNAME,cr.USER_ID,cr.CON_RES_ID,cr.RESERVED_TIMESTAMP,rd.REST_DEAL_NAME,cr.IS_CONSUMER_SHOWN_UP,cr.BOOKED_DATE from consumer_reservation cr," +
					"user u,restaurant r,restaurant_location rl,restaurant_deal rd where " +
					"u.USER_ID=cr.USER_ID  and cr.REST_DEAL_ID=rd.REST_DEAL_ID and rd.REST_LOCATION_ID=rl.REST_LOCATION_ID and " + 
					"rl.RESTAURANT_ID=r.RESTAURANT_ID and r.RESTAURANT_ID=?  ");
			if(startDate!=null)
			{
				queryString.append(" and date(RESERVED_TIMESTAMP)>=?");
				
			}
			if(endDate!=null)
			{
				queryString.append(" and date(RESERVED_TIMESTAMP)<=?");
				
			}
			queryString.append(" order by RESERVED_TIMESTAMP desc");
			SQLQuery query=session.createSQLQuery(queryString.toString());
			int paramNum = 0;
			query.setParameter(paramNum, restaurantId);
			
			if(startDate!=null){
				paramNum++;
				query.setParameter(paramNum, startDate);
			}
			if(endDate!=null){
				paramNum++;
				query.setParameter(paramNum, endDate);
			}
			
			List list=query.list();
			for(int i=0;i<list.size();i++)
			{
			                Object[]  obj=(Object[])list.get(i);
			                ConsumerReservation consumer=new ConsumerReservation();
			                RestaurantDeal restaurantDeal=new RestaurantDeal();
			                User user=new User();
			                user.setFirstname((String)obj[0]);
			                user.setUserId((Integer)obj[1]);
			                consumer.setConResId((Integer)obj[2]);
			                consumer.setReservedTimestamp((Timestamp)obj[3]);
			                restaurantDeal.setDealTemplateName((String)obj[4]);
			                consumer.setIsConsumerShownUp(Short.parseShort(obj[5].toString()));
			                consumer.setBookedTimestamp((Timestamp)obj[6]);
			                consumer.setUser(user);
			                consumer.setRestaurantDeal(restaurantDeal);
			                arrayList.add(consumer);  			                
			}
		        

		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return arrayList;
	}
	
}