package com.tangotab.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tangotab.dao.BillingMethodDAO;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

@Component
public class BillingMethodDAOImpl extends BaseDAOImpl<BillingMethod, Integer> implements BillingMethodDAO {
    private Logger log = LoggerFactory.getLogger(BillingMethodDAOImpl.class);

    /*
      *
      *
      * (non-Javadoc)
      * @see com.tangotab.dao.BillingMethodDAO#getBillingMethods()
      * used fot Get the Billing Method
      */
    @SuppressWarnings("unchecked")
    public List<BillingMethod> getBillingMethods() {
        return getAll();
    }

    /*
      *
      * (non-Javadoc)
      * @see com.tangotab.dao.BillingMethodDAO#saveBillingMethod(com.tangotab.dao.pojo.BillingMethod)
      *  Save Billing Method for admin side
      */
    public Integer saveBillingMethod(BillingMethod billingMethod) throws ApplicationException {
        return save(billingMethod);
    }

    /*
    *  Update Billing Method
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#updateBillingMethod(com.tangotab.dao.pojo.BillingMethod)
    */
    public void updateBillingMethod(BillingMethod billingMethod) throws ApplicationException {
        update(billingMethod);
    }

    /*
    * Get The Billing Methods
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#getBillingMethod(int)
    */
    public BillingMethod getBillingMethod(int billingMethodid) throws ApplicationException {
        return findFirst("billingMethodId", billingMethodid);
    }

    // ********** For Billing Types***********

    @SuppressWarnings("unchecked")
    public ArrayList<BillingType> getBillingTypes() {
        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);
        ArrayList<BillingType> list = null;
        Criteria criteria = session.createCriteria(BillingType.class);
        list = (ArrayList<BillingType>) criteria.list();
        //session.close();
        return list;
    }

    /*
   *
   * save Billing Types
   * */
    public void saveBillingType(BillingType billingType) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.save(billingType);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in billingMethod" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    /*
    * Update Billing Type
    *
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#updateBillingType(com.tangotab.dao.pojo.BillingType)
    */
    public void updateBillingType(BillingType billingType) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.update(billingType);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in billingMethod" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    /*
    * Get Billing Methods
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#getBillingType(int)
    */
    public BillingType getBillingType(int billingTypeid) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);

        Criteria criteria = session.createCriteria(BillingType.class).add(
                Restrictions.eq("billingTypeId", billingTypeid));
        BillingType billingType = new BillingType();


        billingType = (BillingType) criteria.uniqueResult();

        //session.close();
        return billingType;
    }

    // ********** For Cuisine Types***********

    @SuppressWarnings("unchecked")
    public ArrayList<CuisineType> getCuisineTypes() {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);
        ArrayList<CuisineType> list = null;
        Criteria criteria = session.createCriteria(CuisineType.class);
        list = (ArrayList<CuisineType>) criteria.list();
        //session.close();
        return list;
    }

    // ********** For save CuisineTypes***********
    public void saveCuisineType(CuisineType cuisineType) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.save(cuisineType);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in billingMethod" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    // ********** For update CuisineTypes***********
    public void updateCuisineType(CuisineType cuisineType) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.update(cuisineType);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in cuisineType" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    // ********** For get CuisineTypes***********
    public CuisineType getCuisineType(int cuisineTypeid) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);

        Criteria criteria = session.createCriteria(CuisineType.class).add(
                Restrictions.eq("cuisineTypeId", cuisineTypeid));

        CuisineType cuisineType = new CuisineType();


        cuisineType = (CuisineType) criteria.uniqueResult();

        //session.close();
        return cuisineType;
    }

    // ********** For Restaurant Types***********

    @SuppressWarnings("unchecked")
    public ArrayList<RestaurantType> getRestaurantTypes() {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);
        ArrayList<RestaurantType> list = null;
        Criteria criteria = session.createCriteria(RestaurantType.class);
        list = (ArrayList<RestaurantType>) criteria.list();
        //session.close();
        return list;
    }

    public void saveRestaurantType(RestaurantType restaurantType) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.save(restaurantType);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in billingMethod" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    public void updateRestaurantType(RestaurantType restaurantType) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.update(restaurantType);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in restaurantType" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    public RestaurantType getRestaurantType(int restTypeid) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);

        Criteria criteria = session.createCriteria(RestaurantType.class).add(
                Restrictions.eq("restTypeId", restTypeid));
        ;
        RestaurantType restaurantType = new RestaurantType();


        restaurantType = (RestaurantType) criteria.uniqueResult();

        //session.close();
        return restaurantType;
    }

    // ********** For dining styles***********

    @SuppressWarnings("unchecked")
    public ArrayList<DiningStyle> getDiningStyles() {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);
        ArrayList<DiningStyle> list = null;
        Criteria criteria = session.createCriteria(DiningStyle.class);
        list = (ArrayList<DiningStyle>) criteria.list();
        //session.close();
        return list;
    }

    /*
    * Save Dining Style
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#saveDiningStyle(com.tangotab.dao.pojo.DiningStyle)
    */
    public void saveDiningStyle(DiningStyle diningStyle) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.save(diningStyle);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in billingMethod" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    /*
    * update Dining Style
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#updateDiningStyle(com.tangotab.dao.pojo.DiningStyle)
    */
    public void updateDiningStyle(DiningStyle diningStyle) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of billingMethod ");
        Session session = getSession(false);
        //Transaction transaction = session.beginTransaction();
        try {
            session.update(diningStyle);
            //transaction.commit();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error occured in dining style" + e.getMessage());
            }
            e.printStackTrace();
            //transaction.rollback();
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        } finally {
            //session.close();
        }
    }

    /*
    * get Dining style
    * (non-Javadoc)
    * @see com.tangotab.dao.BillingMethodDAO#getDiningStyle(int)
    */
    public DiningStyle getDiningStyle(int diningStyleid) throws ApplicationException {

        if (log.isDebugEnabled())
            log.debug("Start of getCities() ");
        Session session = getSession(false);

        Criteria criteria = session.createCriteria(DiningStyle.class).add(
                Restrictions.eq("diningStyleId", diningStyleid));
        DiningStyle diningStyle = new DiningStyle();


        diningStyle = (DiningStyle) criteria.uniqueResult();

        //session.close();
        return diningStyle;
    }

    @Override
    protected Class getBeanClass() {
        return BillingMethod.class;
    }
}