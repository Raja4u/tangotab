package com.tangotab.businessImpl;

import com.tangotab.business.RestaurantDiscountBO;
import com.tangotab.dao.RestaurantDiscountDAO;
import com.tangotab.dao.pojo.RestaurantDiscount;
import com.tangotab.exception.ApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class RestaurantDiscountBOImpl extends BaseBOImpl implements RestaurantDiscountBO {
    public static Logger log = LoggerFactory.getLogger(RestaurantDiscountBOImpl.class);
    @Autowired
    protected RestaurantDiscountDAO restaurantDiscountDAO;

    /*
    *
    * save the restaurant discount
    */
    public void saveCreditDiscount(RestaurantDiscount discount) throws ApplicationException {

        getRestaurantDiscountDAO().saveCoupon(discount);
    }

    /*
    *
    * get All information of all Restaurant discount
    *
    *
    */
    public List<RestaurantDiscount> getRestauantDiscountByLocation(int Locationid)
            throws ApplicationException {

        List<RestaurantDiscount> list = null;

        list = getRestaurantDiscountDAO().getRestauantDiscountByLocation(Locationid);
        return list;
    }

    private RestaurantDiscountDAO getRestaurantDiscountDAO() {
        return restaurantDiscountDAO;
    }

    /*
    * get the Restaurant Discount Details of single Record
    *
    *
    */
    public RestaurantDiscount getRestauantDiscountDetails(int restDiscountId)
            throws ApplicationException {

        RestaurantDiscount restaurantDiscount;
        try {

            restaurantDiscount = getRestaurantDiscountDAO().getRestauantDiscountDetails(restDiscountId);

        } catch (ApplicationException e) {
            throw e;
        }
        return restaurantDiscount;
    }

    /*
    * update the restaurant discount
    */
    public void updateRestarentDiscount(RestaurantDiscount discount) throws ApplicationException {
        try {

            getRestaurantDiscountDAO().updateRestarentDiscount(discount);

        } catch (ApplicationException e) {
            throw e;
        }
    }

}