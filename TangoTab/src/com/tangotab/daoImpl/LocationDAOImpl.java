package com.tangotab.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;

import com.tangotab.TO.DealSummaryTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.dao.LocationDAO;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.RestaurantDealHistory;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class LocationDAOImpl extends TempDAOImpl implements LocationDAO {
/*
 * 
 * Save Restaurant  Locations 
 */
	public void saveLocation(RestaurantLocation location) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.save(location);
			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
/*
 *Save  Deal creation  
 * 
 */
	@SuppressWarnings("finally")
	public int saveDeal(RestaurantDeal deal) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		int dealId = 0;
		try {
	
			deal.setRestDealCreateDate(new java.sql.Timestamp(new java.util.Date().getTime()));

			deal = (RestaurantDeal) session.merge(deal);
			dealId = deal.getDealTemplateId();
			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
			return dealId;
		}
	}
/*
 * save Restaurant Deal History 
 */
	@SuppressWarnings("finally")
	public int saveDealDetails(RestaurantDealHistory deal) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		int dealId = 0;
		try {

			session.merge(deal);

			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
			return dealId;
		}
	}

	/* Returns deals of a restaurant, if its admin role, returns all custom deals (active/approved)*/
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchDeals(int userID, int roleId, int restId)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userID));
			} else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.createAlias("location.user", "user");
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}

	/* Returns active/inactive deals as specified for role 5 or 6. If its admin, then
	 * return pending/approved custom deals only */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchDeals(int userID, int roleId, int restId, String dealType)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			if (dealType.equals("active"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			else if (dealType.equals("inactive"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.NOT_ACTIVE));

			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userID));
			} else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.createAlias("location.user", "user");
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}

	/* not using any where */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchCustumDeals(int userID, int roleId, int restId)
			throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userID));
			} else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.add(Restrictions.eq("deal.CUSTOM_DEAL", TangotabConstants.NOT_ACTIVE));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}

	/* returns active deals (published or not) for role 5 and 6 -- 
	 * using for 5,6-- view deals--  latest */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userId));
			}
			if (locationId != 0) {
				criterions.add(Restrictions.eq("location.restLocationId", locationId));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}

	/* returns active/inactive for  deals for role 5 or 6 for a specified location and
	 * if its admin, then return all custom deals */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			if (searchType.equals("active"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			else if (searchType.equals("inactive"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.NOT_ACTIVE));

			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userId));
			}else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			if (locationId != 0) {
				criterions.add(Restrictions.eq("location.restLocationId", locationId));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}

	/* returns active/inactive deals for role 5 or 6 for a specified location and
	 * if its admin, then return all custom deals. This is for pagination - not used */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType, int currentPage) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			if (searchType.equals("active"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			else if (searchType.equals("inactive"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.NOT_ACTIVE));

			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userId));
			}else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			if (locationId != 0) {
				criterions.add(Restrictions.eq("location.restLocationId", locationId));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			currentPage -= 1;
			criteria.setFirstResult(currentPage*TangotabConstants.PAGE_SIZE);
			criteria.setMaxResults(TangotabConstants.PAGE_SIZE);
			
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}
	/* returns active/inactive -- deal summary link -- deals for role 5 or 6 for a specified location and
	 * if its admin(pending/approved), then return all custom deals. This is for pagination 
	 * added search by location name functionality for admin -- latest */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantDeal> searchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType, int currentPage, String locname) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<RestaurantDeal> deals = null;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			if (searchType.equals("active"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			else if (searchType.equals("inactive"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.NOT_ACTIVE));

			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userId));
			}else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			if (locationId != 0) {
				criterions.add(Restrictions.eq("location.restLocationId", locationId));
			}
			if(StringUtils.isNotEmpty(locname))
				criterions.add(Restrictions.like("location.locationRestName", "%"+locname+"%"));
			
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			currentPage -= 1;
			criteria.setFirstResult(currentPage*TangotabConstants.PAGE_SIZE);
			criteria.setMaxResults(TangotabConstants.PAGE_SIZE);
			
			deals = (ArrayList<RestaurantDeal>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deals;
	}
	/* returns count of active/inactive deals for role 5 or 6 for a specified location and
	 *  if its admin, then return all custom deals  */
	public Long countSearchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType) throws ApplicationException {
		Session session = getSession(false);
		Long l;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			if (searchType.equals("active"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			else if (searchType.equals("inactive"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.NOT_ACTIVE));

			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userId));
			}else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			if (locationId != 0) {
				criterions.add(Restrictions.eq("location.restLocationId", locationId));
			}
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			criteria.setProjection(Projections.rowCount());
			l = (Long)(criteria.list().get(0));
			} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return l;
	}
	
	/* returns count of active/inactive deals for role 5 or 6 for a specified location and
	 *  if its admin, then return all custom deals  */
	public Long countSearchDealsForLocation(int userId, int roleId, int restId,
			int locationId, String searchType, String locname) throws ApplicationException {
		Session session = getSession(false);
		Long l;
		try {
			List<Criterion> criterions = new ArrayList<Criterion>();
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal");
			if (searchType.equals("active"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.ACTIVE));
			else if (searchType.equals("inactive"))
				criteria.add(Restrictions.eq("deal.isActive", TangotabConstants.NOT_ACTIVE));

			criteria.createAlias("deal.restaurantLocation", "location");
			if (roleId == TangotabConstants.RESTAURANT_OWNER) {
				criteria.createAlias("location.restaurant", "restaurant");
				criterions.add(Restrictions.eq("restaurant.restaurantId", restId));
			} else if (roleId == TangotabConstants.RESTAURANT_STORE_MANAGER) {
				criteria.createAlias("location.user", "user");
				criterions.add(Restrictions.eq("user.userId", userId));
			}else if (roleId == TangotabConstants.ADMIN_ROLE) {
				criteria.add(Restrictions.eq("deal.customDeal", TangotabConstants.ACTIVE));
			}
			if (locationId != 0) {
				criterions.add(Restrictions.eq("location.restLocationId", locationId));
			}
			if(StringUtils.isNotEmpty(locname))
				criterions.add(Restrictions.like("location.locationRestName", "%"+locname+"%"));
			
			Conjunction conjunction = Restrictions.conjunction();
			for (Criterion criterion : criterions) {
				conjunction.add(criterion);
			}
			criteria.add(conjunction);
			criteria.setProjection(Projections.rowCount());
			l = (Long)(criteria.list().get(0));
			} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return l;
	}
	
	
	public RestaurantDeal getRestaurantDeal(int restaurantDealId) throws ApplicationException {
		Session session = getSession(false);
		RestaurantDeal deal = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantDeal.class).add(
					Restrictions.eq("dealTemplateId", restaurantDealId));
			deal = (RestaurantDeal) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deal;
	}
/*
 * Get Restaurants By  restaurant Id 
 */
	@SuppressWarnings("unchecked")
	public ArrayList<LocationTO> getRestaurantsById(int restaurantId) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<LocationTO> location = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantLocation.class, "location")
					.createAlias("location.restaurant", "restaurant").createAlias("location.user",
							"user").add(Restrictions.eq("restaurant.restaurantId", restaurantId));
							
			criteria.setProjection(
					Projections.distinct(Projections.projectionList().add(
							Projections.property("location.restLocationId").as("restLocationId"))
							.add(Projections.property("location.address1").as("address1"))
							.add(Projections.property("location.address").as("address"))
							.add(Projections.property("location.isActive").as("isActive"))
							.add(Projections.property("user.userId").as("userId"))
							.add(Projections.property("location.locationRestName").as(
											"locationRestName")))).setResultTransformer(
					new AliasToBeanResultTransformer(LocationTO.class));

			location = (ArrayList<LocationTO>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return location;

	}
/*
 * 
 * Get Individual Deal by Deal ID 
 */
	public RestaurantDeal getDealByDealId(int dealId) throws ApplicationException {
		Session session = getSession(false);
		RestaurantDeal deal = null;
		try {
			Criteria criteria = session.createCriteria(RestaurantDeal.class, "deal").add(
					Restrictions.eq("deal.dealTemplateId", dealId));
			deal = (RestaurantDeal) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return deal;
	}
/*
 * Update Deal
 */
	public void updateDeal(RestaurantDeal deal) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.merge(deal);
			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}

	}
/*
 * 
 * Change Publish Deal 
 */
	public void publishDeal(int dealId, int status) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.UPDATE_DEAL_QUERY);
			query.setParameter(0, status);
			query.setParameter(1, dealId);

			query.executeUpdate();
			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
	/*
	 * 
	 * Get Restaurant Location By locationId
	 */

	public RestaurantLocation fetchLocationByLocationId(int locationId) throws ApplicationException {

		Session session = getSession(false);
		RestaurantLocation location = null;
		try {
			location = (RestaurantLocation) session.get(RestaurantLocation.class, locationId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return location;

	}
/*
 * 
 * Update ResturantLocation 
 * 
 */
	public void updateLocation(RestaurantLocation location) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			User user = new User();
			user = location.getUser();
			if(user.getUserId()!= null){
			    session.update(user);
			    location.setUser(user);
			}
			session.update(location);
			//transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
/*
 * 
 * Delete Location by location Id
 * 
 */
	public void deleteLocations(int locationId) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.DELETE_REST_LOCATION_PREFERENCES_QUERY);
			query.setParameter(0, locationId);
			query.executeUpdate();
			//transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
/*
 * 
 * Delete Location Dining Preferences
 * 
 */
	public void deleteLocationDiningPreferences(int locationId) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.DELETE_REST_DINING_PREFERENCES_QUERY);
			query.setParameter(0, locationId);
			query.executeUpdate();
			//transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}

	/**
	 * 
	 * @param get
	 *            all dealTemplates
	 * @return reservations
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<ConsumerReservation> getConsumerReservationsByDeal(int restaurantId)
			throws ApplicationException {

		Session session = getSession(false);
		ArrayList<ConsumerReservation> reservations = null;
		try {
			Criteria criteria = session.createCriteria(ConsumerReservation.class, "creserves")
					.createAlias("creserves.user", "user").createAlias("creserves.restaurantDeal",
							"resdeal").createAlias("resdeal.restaurantLocation", "resloc")
					.createAlias("resloc.restaurant", "restaurant").add(
							Restrictions.eq("restaurant.restaurantId", restaurantId));

			reservations = (ArrayList<ConsumerReservation>) criteria.list();
		} catch (Exception e) {
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}

		return reservations;
	}
/*
 * 
 * get consumer reservations by restaurantId, locationid
 * 
 */
	@SuppressWarnings("unchecked")
	public ArrayList<ConsumerReservation> getConsumerReservationsByDeal(int restaurantId,
			int locationId) throws ApplicationException {

		Session session = getSession(false);
		ArrayList<ConsumerReservation> reservations = null;
		try {
			Criteria criteria = session.createCriteria(ConsumerReservation.class, "creserves")
					.createAlias("creserves.user", "user").createAlias("creserves.restaurantDeal",
							"resdeal").createAlias("resdeal.restaurantLocation", "resloc")
					.createAlias("resloc.restaurant", "restaurant").add(
							Restrictions.eq("restaurant.restaurantId", restaurantId)).add(
							Restrictions.eq("resloc.restLocationId", locationId));

			reservations = (ArrayList<ConsumerReservation>) criteria.list();
		} catch (Exception e) {
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}

		return reservations;
	}
/*
 * 
 * get Custom Deal status  by deal Id , actiove   
 * 
 */
	public boolean setCustomDealStatus(int dealID, int isActive) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.CUSTOM_DEAL_ACTIVATE_UPDATE_QUERY);
			query.setShort(0, (short) isActive);
			query.setTimestamp(1, new java.util.Date());
			query.setInteger(2, dealID);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {

			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}

	// need to rename as getAllRestaurants.
	@SuppressWarnings("unchecked")
	public ArrayList<Restaurant> getAllLocations() throws ApplicationException {

		Session session = getSession(false);
		ArrayList<Restaurant> location = null;
		Criteria criteria = session.createCriteria(Restaurant.class);
		location = (ArrayList<Restaurant>) criteria.list();
		//session.close();
		return location;

	}
	/*
	 *  change Location Status by location Id and status 
	 * 
	 */

	public boolean setLocationStatus(int locationId, Short status) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.RESTAURANT_LOCATION_STATUS_UPDATE_QUERY);
			query.setShort(0, status);
			query.setInteger(1, locationId);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception e) {

			//transaction.rollback();
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}
/*
 * Get RestaurantLocations by restaurant Id 
 * 
 */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = getSession(false);
		ArrayList<RestaurantLocation> list = null;
		try {

			Criteria criteria = session.createCriteria(RestaurantLocation.class).createAlias(
					"restaurant", "restaurant").add(
					Restrictions.eq("restaurant.restaurantId", restaurantId));
			list = (ArrayList<RestaurantLocation>) criteria.list();
		} catch (Exception e) {
			throw new ApplicationException("DB004", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return list;
	}
/*
 * Credit by Restaurant location Id 
 * 
 */
	public boolean debitCreditForCustomDeal(int restLocationId) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.DEBIT_CREDITS_FOR_CUSTOM_DEAL_QUERY);
			query.setInteger(0, restLocationId);

			int rows = query.executeUpdate();
			if (rows == 1) {
				//transaction.commit();
				return true;
			}
			//transaction.rollback();
		} catch (Exception e) {
			//transaction.rollback();
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}
/*
 * 
 * get Current Credits by Restaurant Id
 * 
 */
	@SuppressWarnings("unchecked")
	public Object[] getCurrentCreditsWithUserDetailsForLocation(int restLocationId)
			throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		Object[] columns = new Object[2];
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.CURRENT_CREDITS_SELECT_QUERY);
			query.setInteger(0, restLocationId);

			List results = query.list();
			Iterator itr = results.iterator();

			if (itr.hasNext()) {
				columns = (Object[]) itr.next();
			}
		} catch (Exception e) {
			//transaction.rollback();
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return columns;
	}
/*
 * 
 * get Deal Summary by restaurant Id
 * 
 */
	@SuppressWarnings("unchecked")
	public DealSummaryTO getDealSummary(int resId) throws ApplicationException {

		DealSummaryTO to = null;
		if (resId > 0) {
			to = new DealSummaryTO();

			Session session = getSession(false);
			//Transaction transaction = session.beginTransaction();
			try {
				// 1. create an entry in the rest_reservations table

				SQLQuery queryX = session
						.createSQLQuery(TangotabConstants.DEAL_SUMMARY_SELECT_QUERY);
				queryX.setInteger(0, resId);

				List listX = queryX.list();
				Iterator conResIDs = listX.iterator();
				int publishdeal = 0;
				int unpublishdeal = 0;
			 
				double currentcredits = 0;
			  
				while (conResIDs.hasNext()) {

					Object[] columns = (Object[]) conResIDs.next();

					if ( columns[0] != null && (Short) columns[0] == 1) {
						publishdeal = publishdeal + 1;
					} else {
						unpublishdeal = unpublishdeal + 1;
					}
					currentcredits = (Double) columns[1];

				}
				SQLQuery query1 = session.createSQLQuery(TangotabConstants.DEAL_BILL_QTY);
				query1.setInteger(0, resId);

				List list1 = query1.list();
				Iterator dealBillqty = list1.iterator();
				int qty = 0;
				while (dealBillqty.hasNext()) {

					Object[] columns = (Object[]) dealBillqty.next();

					qty = qty + (Integer) columns[0];

				}

				to.setTotalqty(qty);
				to.setCurrentcredits(currentcredits);
				to.setPublishdeal(publishdeal);
				to.setUnpublishdeal(unpublishdeal);

			} catch (Exception e) {

				e.printStackTrace();
				//transaction.rollback();
				throw new ApplicationException("DB001", TangotabConstants.ERROR);
			} finally {
				//session.close();
			}
		}
		return to;
	}
	/*
	 * get no of locations by restaurant Id 
	 */

	@SuppressWarnings("unchecked")
	public int getNoOfLocations(Integer restId) throws ApplicationException {
		int nooflocations = 0;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(RestaurantLocation.class,
					"restaurantlocation")
					.createAlias("restaurantlocation.restaurant", "restaurant").add(
							Restrictions.eq("restaurant.restaurantId", restId));
			criteria.setProjection(Projections.rowCount());
			//locs = (ArrayList<RestaurantLocation>) criteria.list();
			Object object = criteria.uniqueResult();
		
			if (object instanceof Long)
				nooflocations = ((Long) object).intValue();
	        
			
		} catch (Exception e) {

			e.printStackTrace();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//locs = null;
			//session.close();
		}
		return nooflocations;
	}

}
