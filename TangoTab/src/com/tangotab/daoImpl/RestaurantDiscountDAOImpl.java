package com.tangotab.daoImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tangotab.dao.RestaurantDiscountDAO;
import com.tangotab.dao.pojo.RestaurantDiscount;
import com.tangotab.exception.ApplicationException;

@Component
public class RestaurantDiscountDAOImpl extends BaseDAOImpl<RestaurantDiscount, Integer> implements
        RestaurantDiscountDAO {
    /*
    * Save  Restaurant Coupon
    */
    public Integer saveCoupon(RestaurantDiscount discount) throws ApplicationException {
    	return super.save(discount);
    	
      }

    /*
    * Get Restaurant Discount per  restaurant Locations
    */
    @SuppressWarnings("unchecked")
    public List<RestaurantDiscount> getRestauantDiscountByLocation(int Locationid)
            throws ApplicationException {
        return find("restLocationId", Locationid);
    }

    /*
    * Get Restaurant Discount Deatails
    */
    public RestaurantDiscount getRestauantDiscountDetails(int restDiscountId)
            throws ApplicationException {
        return findFirst("restDiscountId", restDiscountId);
    }

    /*
    * Update Restaurant Discount
    */
    public void updateRestarentDiscount(RestaurantDiscount discount) throws ApplicationException {
        update(discount);
    }

    @Override
    protected Class getBeanClass() {
        return RestaurantDiscount.class;
    }
}
