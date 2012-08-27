package com.tangotab.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.TO.RatingTO;
import com.tangotab.dao.CommonDAO;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CharityDetails;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.Country;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.PriceIndex;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantRating;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.dao.pojo.State;
import com.tangotab.dao.pojo.User;
import com.tangotab.dao.pojo.UserValidationCode;
import com.tangotab.dao.pojo.ZipCode;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class CommonDAOImpl extends TempDAOImpl implements CommonDAO {
	private Logger log = LoggerFactory.getLogger(CommonDAOImpl.class);
/*
 * 
 * Get Cities 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getCities()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<City> getCities() {
 
			log.error("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(City.class).add(Restrictions.eq("isActive", 1))
				.addOrder(Order.asc("cityName"));
		ArrayList<City> list = (ArrayList<City>) criteria.list();
		//session.close();
		return list;
	}
/*
 * Get Cities For Admin it displays the active and inactive 
 * 	(non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getCitiesForAdmin()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<City> getCitiesForAdmin() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(City.class)
				.addOrder(Order.asc("cityName"));
		ArrayList<City> list = (ArrayList<City>) criteria.list();
		//session.close();
		return list;
	}
/*
 * Get Billing Method
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getBillingMethods()
 */
	@SuppressWarnings("unchecked")
	public List<BillingMethod> getBillingMethods() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(BillingMethod.class);
		ArrayList<BillingMethod> list = (ArrayList<BillingMethod>) criteria.list();
		//session.close();
		return list;
	}
/*
 * 
 * Get Billing Types
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getBillingTypes()
 */
	@SuppressWarnings("unchecked")
	public List<BillingType> getBillingTypes() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(BillingType.class);
		ArrayList<BillingType> list = (ArrayList<BillingType>) criteria.list();
		//session.close();
		return list;
	}
/*
 * 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getBusinessTypes()
 */
	@SuppressWarnings("unchecked")
	public List<RestaurantType> getBusinessTypes() {
		if (log.isDebugEnabled())
			log.debug("Start of getBusinessTypes()) ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(RestaurantType.class);
		ArrayList<RestaurantType> list = (ArrayList<RestaurantType>) criteria.list();
		//session.close();
		return list;
	}
/*
 * 
 * Get Countries 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getCountries()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<Country> getCountries() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		ArrayList<Country> list = null;
		Criteria criteria = session.createCriteria(Country.class, "country").addOrder(
				Order.desc("country.countryName"));
		list = (ArrayList<Country>) criteria.list();
		//session.close();
		return list;
	}
/*
 * get Active states 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getStates()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<State> getStates() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(State.class).add(Restrictions.eq("isActive", 1))
				.addOrder(Order.asc("stateName"));
		ArrayList<State> list = (ArrayList<State>) criteria.list();
		//session.close();
		return list;
	}
/*
 * Get State By state Id 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getStatesById(int)
 */
	
	public State getStatesById(int stateId) {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(State.class).add(
				Restrictions.eq("stateId", stateId)).addOrder(Order.asc("stateName"));
		State state = (State) criteria.uniqueResult();
		//session.close();
		return state;
	}
/*
 * GetStates by searchType
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getStates(java.lang.String)
 */
	@SuppressWarnings("unchecked")
	public ArrayList<State> getStates(String searchType) {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(State.class);
		ArrayList<State> list = (ArrayList<State>) criteria.list();
		//session.close();
		return list;
	}
/*
 *
 *Get All Cuisine Types
 */
	@SuppressWarnings("unchecked")
	public List<CuisineType> getCuisineTypes() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(CuisineType.class).add(Restrictions.eq("isActive", 1)).addOrder(Order.asc("type"));
		ArrayList<CuisineType> list = (ArrayList<CuisineType>) criteria.list();
		//session.close();
		return list;
	}
	/*
	 *
	 *Get All Dining Styles
	 */
	@SuppressWarnings("unchecked")
	public List<DiningStyle> getDiningStyles() {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		Criteria criteria = session.createCriteria(DiningStyle.class).add(Restrictions.eq("isActive", 1)).addOrder(Order.asc("diningStyleName"));
		ArrayList<DiningStyle> list = (ArrayList<DiningStyle>) criteria.list();
		//session.close();
		return list;
	}
/*
 * Get active cities By state Id
 */
	@SuppressWarnings("unchecked")
	public ArrayList<City> getCity(int stateId) throws ApplicationException {
		ArrayList<City> cities = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(City.class).createAlias("state", "state")
					.add(Restrictions.eq("state.stateId", stateId)).add(
							Restrictions.eq("isActive", 1));
			cities = (ArrayList<City>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getCity" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return cities;
	}
	/*
	 * Get all Cities by stateId 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<City> getCityForAdmin(int stateId) throws ApplicationException {
		ArrayList<City> cities = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(City.class).createAlias("state", "state")
					.add(Restrictions.eq("state.stateId", stateId));
			cities = (ArrayList<City>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getCity" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return cities;
	}
/*
 * (non-Javadoc)
 * 
 * @see com.tangotab.dao.CommonDAO#getCity(int, java.lang.String)
 */
	@SuppressWarnings("unchecked")
	public ArrayList<City> getCity(int stateId, String searchType) throws ApplicationException {
		ArrayList<City> cities = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(City.class).createAlias("state", "state")
					.add(Restrictions.eq("state.stateId", stateId));
			cities = (ArrayList<City>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getCity" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return cities;
	}
/*
 * Get States by countryID
 */
	@SuppressWarnings("unchecked")
	public ArrayList<State> getState(int countryId) throws ApplicationException {
		ArrayList<State> states = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(State.class).createAlias("country",
					"country").add(Restrictions.eq("country.countryId", countryId)).add(
					Restrictions.eq("isActive", 1));
			states = (ArrayList<State>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getState" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return states;
	}
/*
 * get Zip Code for each cityID
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getZipCode(int)
 */
	@SuppressWarnings("unchecked")
	public ArrayList<ZipCode> getZipCode(int cityId) throws ApplicationException {
		ArrayList<ZipCode> zipCodes = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(ZipCode.class).createAlias("city", "city")
					.add(Restrictions.eq("city.cityId", cityId));
			zipCodes = (ArrayList<ZipCode>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getZipCodes" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return zipCodes;
	}
/*
 * check  Email Id is Available or not  
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#isEmailIdAvailable(java.lang.String)
 */
	public boolean isEmailIdAvailable(String emailId) throws ApplicationException {
		boolean flag = false;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(User.class).add(
					Restrictions.eq("emailId", emailId));
			if (criteria.uniqueResult() != null) {
				flag = true;
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in isEmailIdAvailable" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return flag;
	}
/*
 * Verify Validation Code ( this verify code send to mail ) 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#verifyValidationCode(java.lang.String, java.lang.String, java.lang.String)
 */
	public boolean verifyValidationCode(String emailId, String password, String validationCode)
			throws ApplicationException {
		boolean flag = false;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(UserValidationCode.class, "validation")
					.createAlias("validation.user", "user").add(
							Restrictions.eq("user.emailId", emailId)).add(
							Restrictions.eq("user.password", password)).add(
							Restrictions.eq("validation.validationCode", validationCode));
			UserValidationCode vCode = (UserValidationCode) criteria.uniqueResult();
			if (vCode != null) {
				flag = true;
				session.delete(vCode);
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in verifyValidationCode" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return flag;
	}
/*
 * Get Deals 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getDeals()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<DealTemplate> getDeals() {
		Session session = getSession(false);
		ArrayList<DealTemplate> deals = null;
		Criteria criteria = session.createCriteria(DealTemplate.class);
		deals = (ArrayList<DealTemplate>) criteria.list();
		//session.close();
		return deals;
	}
/*
 * Get Restaurant Ratings 
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getRestaurantRatings()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<RatingTO> getRestaurantRatings() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getBusinessTypes()) ");
		ArrayList<RatingTO> ratings = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(RestaurantRating.class, "restaurant")
					.setProjection(
							Projections.projectionList().add(
									Projections.property("restaurant.restRatingsId").as(
											"restRatingsId"))).setResultTransformer(
							new AliasToBeanResultTransformer(RatingTO.class));
			ratings = (ArrayList<RatingTO>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {

			//session.close();
		}
		return ratings;
	}
/*
 * Get Prince Indexs
 * (non-Javadoc)
 * @see com.tangotab.dao.CommonDAO#getPriceIndexs()
 */
	@SuppressWarnings("unchecked")
	public ArrayList<PriceIndex> getPriceIndexs() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getBusinessTypes()) ");
		ArrayList<PriceIndex> ratings = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(PriceIndex.class, "price");
			ratings = (ArrayList<PriceIndex>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {

			//session.close();
		}
		return ratings;
	}
	/*
	 * Get All Events 
	 * (non-Javadoc)
	 * @see com.tangotab.dao.CommonDAO#getAllEvents()
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Events> getAllEvents(){
		
		ArrayList<Events> events = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(Events.class, "events");
			events = (ArrayList<Events>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//session.close();
		}
		return events;
	}
	/*
	 * Get All Restaurant Locations
	 * (non-Javadoc)
	 * @see com.tangotab.dao.CommonDAO#getAllLocations()
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocation> getAllLocations() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getBusinessTypes()) ");
		ArrayList<RestaurantLocation> restaurants = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(RestaurantLocation.class, "loc").add(
					Restrictions.eq("loc.isActive", TangotabConstants.ACTIVE));
			restaurants = (ArrayList<RestaurantLocation>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {

			//session.close();
		}
		return restaurants;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocation> getAllLocations(double lat1,double long1) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getBusinessTypes()) ");
		ArrayList<RestaurantLocation> restaurants = new ArrayList<RestaurantLocation>();
		Session session = getSession(false);
		try {
			SQLQuery query = session.createSQLQuery("select rs.REST_LOCATION_ID," +
					"rs.LOCATION_REST_NAME,getCity(rs.PREFER_CITY_ID) as city," +
					"getDistance(?,?,LATITUDE,LONGITUDE) as distance    " +
					" from restaurant_location rs where rs.is_active=1 order by distance ");
			query.setDouble(0, lat1);
			query.setDouble(1, long1);
		 	List list= query.list();
		 	for (Object object : list) {
		 		Object[] columns = (Object[]) object;
		 		RestaurantLocation location=new RestaurantLocation();
			// System.out.println((Integer) columns[0]);
		//	 System.out.print( (String) columns[1]+"===>");
		//	 System.out.print( (String) columns[2]+"===>");
		//	 System.out.println( (Double) columns[3]+"===>");
			 location.setRestLocationId((Integer) columns[0]);
			 location.setLocationRestName((String) columns[1]);
			 location.setCityId((String) columns[2]);
 
					 restaurants.add(location);
		 	//	System.out.println(object);
				
			}
		/*	Criteria criteria = session.createCriteria(SalesManagerInfo.class, "mgr");
			criteria.createAlias("mgr.user", "user");
			criteria.setProjection(
					Projections.distinct(Projections.projectionList().add(
							Projections.property("user.firstname").as("firstname")).add(
							Projections.property("user.lastname").as("lastname")).add(
							Projections.property("mgr.salesManagerId").as("userId"))))
					.setResultTransformer(new AliasToBeanResultTransformer(UserTO.class));
			*/
			/*
			Criteria criteria = session.createCriteria(RestaurantLocation.class, "loc").add(
					Restrictions.eq("loc.isActive", TangotabConstants.ACTIVE));
			restaurants = (ArrayList<RestaurantLocation>) criteria.list();
			
			*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {

			//session.close();
		}
		return restaurants;
	}
	/* returns the latest charity count */
	public Integer getCharityCount() throws ApplicationException{
		
		Session session = getSession(false);
		Integer count = 0;
		try{
			SQLQuery query = session.createSQLQuery(TangotabConstants.CHARITY_COUNT);
			count = (Integer)( (Object)query.uniqueResult());
			
		
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return count;
		
	}
	public static void main(String s[])throws Exception
	{
		CommonDAOImpl commonDAOImpl=new CommonDAOImpl();
		commonDAOImpl.getAllLocations(38.898556,-77.03785);
	}
}