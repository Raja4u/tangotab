package com.tangotab.businessImpl;

import com.tangotab.business.RestaurantAdminBO;
import com.tangotab.dao.ResaurantAdminDAO;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.exception.ApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class RestaurantAdminBOImpl implements RestaurantAdminBO {
    @Autowired
    protected ResaurantAdminDAO resaurantAdminDAO;

	public ArrayList<Restaurant> getRestaurant() throws ApplicationException {
		// TODO Auto-generated method stub

		return getResaurantAdminDAO().getRestaurant();

	}

    private ResaurantAdminDAO getResaurantAdminDAO() {
        return resaurantAdminDAO;
    }

    public ArrayList<RestaurantLocation> getRestaurantLocations(int restaurantId)
			throws ApplicationException {
		// TODO Auto-generated method stub

		return getResaurantAdminDAO().getRestaurantLocations(restaurantId);
	}

}
