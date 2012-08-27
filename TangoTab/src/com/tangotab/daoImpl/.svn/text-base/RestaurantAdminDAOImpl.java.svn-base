package com.tangotab.daoImpl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.dao.ResaurantAdminDAO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class RestaurantAdminDAOImpl extends TempDAOImpl implements ResaurantAdminDAO {
	private Logger log = LoggerFactory.getLogger(RestaurantAdminDAOImpl.class);

	/*
	 * Get Restaurant 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Restaurant> getRestaurant() throws ApplicationException {
 
		Session session = getSession(false);
		ArrayList<Restaurant> list = null;
		Criteria criteria = session.createCriteria(Restaurant.class);
		list = (ArrayList<Restaurant>) criteria.list();
		return list;
	}
	/*
	 * Get Restaurant Locations 
	 */

	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException {
 
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		ArrayList<RestaurantLocation> list = null;
		Criteria criteria = session.createCriteria(RestaurantLocation.class).createAlias(
				"restaurant", "restaurant").add(
				Restrictions.eq("restaurant.restaurantId", restaurantId));
		list = (ArrayList<RestaurantLocation>) criteria.list();
		//session.close();
		return list;
	}
}
