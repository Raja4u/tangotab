/**
 * 
 */
package com.tangotab.dao;

import java.util.ArrayList;

import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;

/**
 * @author durga
 * 
 */
public interface ResaurantAdminDAO {

	public ArrayList<Restaurant> getRestaurant() throws ApplicationException;

	public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException;
}
