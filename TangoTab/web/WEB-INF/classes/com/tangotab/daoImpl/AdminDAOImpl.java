/****** BEGIN LICENSE BLOCK *****

Codekko Software, Inc. Legal Notice 

Copyright Notice 

Copyright © 2009, Codekko Software, Inc. and/or its affiliates. All rights reserved. 

License Restrictions 

This software and related documentation are provided under a commercial license agreement 
from Codekko Software, Inc. containing restrictions on use and disclosure and are protected 
by patent, copyright and intellectual property laws. Except as expressly permitted in your 
license agreement or allowed by law, you may not use, copy, reproduce, translate, broadcast, 
modify, license, transmit, distribute, exhibit, perform, publish, or display any part, in 
any form, or by any means. Reverse engineering, disassembly, or decompilation of this software, 
unless required by law for interoperability, is prohibited. 

This software is developed for general use in a variety of information management applications. 
It is not developed or intended for use in any inherently dangerous applications, including 
applications which may create a risk of personal injury. If you use this software in dangerous 
applications, then you shall be responsible to take all appropriate fail-safe, backup, redundancy, 
and other measures to ensure the safe use of this software. Codekko Software, Inc. and its 
affiliates disclaim any liability for any damages caused by use of this software. 

Warranty Disclaimer 

The information contained herein is subject to change without notice and is not warranted to be 
error-free. If you find any errors, please report them to Codekko Software, Inc. in writing at 
Codekko Software, Inc., 1820, Preston Park Blvd, Suite 1900, Plano, Texas 75093 

 ****** END LICENSE BLOCK ***** */
package com.tangotab.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tangotab.dao.AdminDAO;
import com.tangotab.dao.pojo.AdminDealImages;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

/**
 * 
 * @author Nkumar
 * 
 */
@Component
public class AdminDAOImpl extends TempDAOImpl implements AdminDAO {
	private static Logger log = LoggerFactory.getLogger(AdminDAOImpl.class);

	/**
	 * 
	 * @param cuisine
	 * @return cuisine id after adding a new cuisine 
	 * @throws ApplicationException
	 */
	public int saveCuisineType(CuisineType cuisine) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveCuisine ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.save(cuisine);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return cuisine.getCuisineTypeId();
	}

	/**
	 * 
	 * @param cuisine
	 * @return cuisine id after updating cuisine into database 
	 * @throws ApplicationException
	 */
	public int updateCuisineType(CuisineType cuisine) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveCuisine ");
		Session session = getSession(false);
		 
		try {
			session.update(cuisine);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return cuisine.getCuisineTypeId();
	}

	/**
	 * @return all cuisine types
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CuisineType> getCuisineTypes() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getCities() ");
		Session session = getSession(false);
		ArrayList<CuisineType> list = null;
		Criteria criteria = session.createCriteria(CuisineType.class);
		list = (ArrayList<CuisineType>) criteria.list();
		//session.close();
		return list;
	}

	/**
	 * 
	 * @param cuisineTypeId
	 * @return cuisine details by cuisine type id
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public CuisineType getCuisineTypeById(int cuisineTypeId) throws ApplicationException {
		CuisineType cuisineType = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(CuisineType.class).add(
					Restrictions.eq("cuisineTypeId", cuisineTypeId));
			List cuisineTypes = (ArrayList<CuisineType>) criteria.list();
			if (cuisineTypes.size() == 1) {
				if (cuisineTypes.iterator().hasNext()) {
					cuisineType = (CuisineType) cuisineTypes.iterator().next();
				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getCity" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return cuisineType;
	}

	/**
	 * 
	 * @param cuisineTypeId
	 * @return status whether the cuisine type is deleted or not
	 * @throws ApplicationException
	 */
	public int deleteCuisineType(int cuisineTypeId) throws ApplicationException {
		int status = 0;
		CuisineType cuisineType = getCuisineTypeById(cuisineTypeId);
		Session session = getSession(false);
		 
		try {
			session.delete(cuisineType);
			//transaction.commit();
			status = 1;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return status;
	}

	/**
	 * 
	 * @param billingType
	 * @ add new billing type to database
	 * @throws ApplicationException
	 */
	public int saveBillingType(BillingType billingType) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveCuisine ");
		Session session = getSession(false);
		 
		try {
			session.save(billingType);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return billingType.getBillingTypeId();
	}

	/**
	 * 
	 * @return all billing types 
	 * @throws ApplicationException
	 */
	@SuppressWarnings("all")
	public ArrayList<BillingType> getBillingTypes() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of BillingType() ");
		Session session = getSession(false);
		ArrayList<BillingType> list = null;
		Criteria criteria = session.createCriteria(BillingType.class);
		list = (ArrayList<BillingType>) criteria.list();
		//session.close();
		return list;
	}

	/* modify and save the billing type */
	public int updateBillingType(BillingType billingType) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveCuisine ");
		Session session = getSession(false);
		 
		try {
			session.update(billingType);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return billingType.getBillingTypeId();
	}

	/* delete the billing type */
	public int deleteBillingType(int billingTypeId) throws ApplicationException {
		int status = 0;
		BillingType billingType = getBillingTypeById(billingTypeId);
		Session session = getSession(false);
		 
		try {
			if (billingType != null) {
				session.delete(billingType);
			}
			//transaction.commit();
			status = 1;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return status;
	}

	/* get billing type information by billingtype id */
	@SuppressWarnings("unchecked")
	public BillingType getBillingTypeById(int billingTypeId) throws ApplicationException {
		BillingType billingType = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(BillingType.class).add(
					Restrictions.eq("billingTypeId", billingTypeId));
			List cuisineTypes = (ArrayList<BillingType>) criteria.list();
			if (cuisineTypes.size() == 1) {
				if (cuisineTypes.iterator().hasNext()) {
					billingType = (BillingType) cuisineTypes.iterator().next();
				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getCity" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return billingType;
	}

	/**
	 * 
	 * @param billingMethod
	 * @return returns id of the billing method added 
	 * @throws ApplicationException
	 */
	public int saveBillingMethod(BillingMethod billingMethod) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveBillingMethod ");
		Session session = getSession(false);
		 
		try {
			session.save(billingMethod);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveBillingMethod" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return billingMethod.getBillingMethodId();
	}

	/**
	 * 
	 * @param billingMethod
	 *            
	 * @return billing method id of the updated billing method 
	 * @throws ApplicationException
	 */
	public int updateBillingMethod(BillingMethod billingMethod) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateBillingMethod ");
		Session session = getSession(false);
		 
		try {
			session.update(billingMethod);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateBillingMethod" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return billingMethod.getBillingMethodId();
	}

	/**
	 * 
	 * @returns all billing methods
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<BillingMethod> getBillingMethods() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getBillingMethods() ");
		Session session = getSession(false);
		ArrayList<BillingMethod> list = null;
		Criteria criteria = session.createCriteria(BillingMethod.class);
		list = (ArrayList<BillingMethod>) criteria.list();
		//session.close();
		return list;
	}

	/* deletes the billing method specified */
	public int deleteBillingMethod(int billingMethodId) throws ApplicationException {
		int status = 0;
		BillingMethod billingMethod = getBillingMethodById(billingMethodId);
		Session session = getSession(false);
		 
		try {
			if (billingMethod != null) {
				session.delete(billingMethod);
			}
			//transaction.commit();
			status = 1;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in deleteBillingMethod: " + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return status;
	}

	/* get the billing method by billing method id */
	@SuppressWarnings("all")
	public BillingMethod getBillingMethodById(int billingMethodId) throws ApplicationException {
		BillingMethod billingMethod = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(BillingMethod.class).add(
					Restrictions.eq("billingMethodId", billingMethodId));
			List cuisineTypes = (ArrayList<BillingMethod>) criteria.list();
			if (cuisineTypes.size() == 1) {
				if (cuisineTypes.iterator().hasNext()) {
					billingMethod = (BillingMethod) cuisineTypes.iterator().next();
				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getBillingMethodById" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return billingMethod;
	}

	/**
	 * 
	 * @param restaurantType
	 * @return restaurant type id of the saved restaurant type 
	 * @throws ApplicationException
	 */
	public int saveRestaurantType(RestaurantType restaurantType) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveRestaurantType ");
		Session session = getSession(false);
		 
		try {
			session.save(restaurantType);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveRestaurantType" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return restaurantType.getRestTypeId();
	}

	/* returns restaurant type id of the updated restaurant type  */
	public int updateRestaurantType(RestaurantType restaurantType) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateRestaurantType ");
		Session session = getSession(false);
		 
		try {
			if (restaurantType.getRestTypeId() > 0) {
				session.update(restaurantType);
			}
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateRestaurantType" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return restaurantType.getRestTypeId();
	}

	/**
	 * 
	 * @returns all restaurant types 
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<RestaurantType> getRestaurantTypes() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getBillingMethods() ");
		Session session = getSession(false);
		ArrayList<RestaurantType> list = null;
		Criteria criteria = session.createCriteria(RestaurantType.class);
		list = (ArrayList<RestaurantType>) criteria.list();
		//session.close();
		return list;
	}

	/* delete the restaurant type */
	public int deleteRestaurantType(int restaurantTypeId) throws ApplicationException {
		int status = 0;
		RestaurantType restaurantType = getRestaurantTypeById(restaurantTypeId);
		Session session = getSession(false);
		 
		try {
			if (restaurantType != null) {
				session.delete(restaurantType);
			}
			//transaction.commit();
			status = 1;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in deleteBillingMethod: " + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return status;
	}

	/* get restaurant type details by type id*/
	@SuppressWarnings("unchecked")
	public RestaurantType getRestaurantTypeById(int restaurantTypeId) throws ApplicationException {
		RestaurantType restaurantType = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(RestaurantType.class).add(
					Restrictions.eq("restTypeId", restaurantTypeId));
			List<RestaurantType> cuisineTypes = (ArrayList<RestaurantType>) criteria.list();
			if (cuisineTypes.size() == 1) {
				if (cuisineTypes.iterator().hasNext()) {
					restaurantType = cuisineTypes.iterator().next();
				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getRestaurantTypeById" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return restaurantType;
	}

	/* get dining style information */
	@SuppressWarnings("unchecked")
	public DiningStyle getDiningStyleById(int diningStyleId) throws ApplicationException {
		DiningStyle diningStyle = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(DiningStyle.class).add(
					Restrictions.eq("diningStyleId", diningStyleId));
			List<DiningStyle> diningStyles = (ArrayList<DiningStyle>) criteria.list();
			if (diningStyles.size() == 1) {
				if (diningStyles.iterator().hasNext()) {
					diningStyle = diningStyles.iterator().next();
				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getDiningStyleById" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return diningStyle;
	}

	/* deletes the dining style */
	public int deleteDiningStyle(int diningStyleId) throws ApplicationException {
		int status = 0;
		DiningStyle diningStyle = getDiningStyleById(diningStyleId);
		Session session = getSession(false);
		 
		try {
			if (diningStyle != null) {
				session.delete(diningStyle);
			}
			//transaction.commit();
			status = 1;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in deleteDiningStyle: " + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return status;
	}

	/* returns all dining styles */
	@SuppressWarnings("unchecked")
	public List<DiningStyle> getDiningStyles() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of getDiningStyles() ");
		Session session = getSession(false);
		ArrayList<DiningStyle> list = null;
		Criteria criteria = session.createCriteria(DiningStyle.class);
		list = (ArrayList<DiningStyle>) criteria.list();
		//session.close();
		return list;
	}

	/* save the new dining style */
	public int saveDiningStyle(DiningStyle diningStyle) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveDiningStyle ");
		Session session = getSession(false);
		 
		try {
			session.save(diningStyle);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveDiningStyle" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return diningStyle.getDiningStyleId();
	}

	/* save the modified dining style */
	public int updateDiningStyle(DiningStyle diningStyle) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateDiningStyle ");
		Session session = getSession(false);
		 
		try {
			if (diningStyle.getDiningStyleId() > 0) {
				session.update(diningStyle);
			}
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateDiningStyle" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return diningStyle.getDiningStyleId();
	}

	public boolean activateRestaurant(int restaurantId) throws ApplicationException {
		return setRestaurantActiveStatus(restaurantId, true);
	}

	public boolean deactivateRestaurant(int restaurantId) throws ApplicationException {
		return setRestaurantActiveStatus(restaurantId, false);
	}

	private boolean setRestaurantActiveStatus(int restaurantId, boolean status)
			throws ApplicationException {
		Session session = getSession(false);
		 
		try {
			if (restaurantId > 0) {
				SQLQuery query = session
						.createSQLQuery("UPDATE restaurant R SET R.is_active=? WHERE R.restaurant_id=?");
				query.setShort(0, status ? new Short("1") : new Short("0"));
				query.setInteger(1, restaurantId);
				query.addEntity("R", Restaurant.class);

				int rows = query.executeUpdate();
				//transaction.commit();

				if (rows > 0) {
					return true;
				}
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}

	public boolean activateRestaurantLocation(int restaurantLocationId) throws ApplicationException {
		return setLocationActiveStatus(restaurantLocationId, true);
	}

	public boolean deactivateRestaurantLocation(int restaurantLocationId)
			throws ApplicationException {
		return setLocationActiveStatus(restaurantLocationId, false);
	}

	private boolean setLocationActiveStatus(int restaurantLocationId, boolean status)
			throws ApplicationException {
		Session session = getSession(false);
		 
		try {
			if (restaurantLocationId > 0) {
				SQLQuery query = session
						.createSQLQuery("UPDATE restaurant_location RL SET RL.is_active=? WHERE RL.rest_location_id=?");
				query.setShort(0, status ? new Short("1") : new Short("0"));
				query.setInteger(1, restaurantLocationId);
				query.addEntity("RL", RestaurantLocation.class);

				int rows = query.executeUpdate();
				//transaction.commit();
				if (rows > 0) {
					return true;
				}
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}

	public void saveCity(City city) throws ApplicationException {
		// TODO Auto-generated method stub

		if (log.isDebugEnabled())
			log.debug("Start of saveDiningStyle ");
		Session session = getSession(false);
		 
		try {

			session.save(city);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveDiningStyle" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}

	}

	public boolean setCityStatus(int city_id, Integer status) throws ApplicationException {
		Session session = getSession(false);
		 
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.CITY_STATUS_UPDATE_QUERY);
			query.setInteger(0, status);
			query.setInteger(1, city_id);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}

	public boolean setStateStatus(int state_id, Integer status) throws ApplicationException {
		Session session = getSession(false);
		 
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.STATE_STATUS_UPDATE_QUERY);
			query.setInteger(0, status);
			query.setInteger(1, state_id);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<AdminDealImages> getImages(String dealName) throws ApplicationException {
		Session session = getSession(false);
		ArrayList<AdminDealImages> images = null;
		try {
			Criteria criteria = session.createCriteria(AdminDealImages.class, "dealImage")
					.createAlias("dealImage.dealName", "dealname");
			if (dealName != null && !dealName.equals("") && !dealName.equals("custom")) {
				criteria.add(Restrictions.eq("dealname.name", dealName));
			}
			images = (ArrayList<AdminDealImages>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return images;
	}
	

	public void saveLanding(Landing landing) throws ApplicationException {
		// TODO Auto-generated method stub
		
		if (log.isDebugEnabled())
			log.debug("Start of save Landing Image ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {

			session.save(landing);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in save Landing Image" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
	}
	
	public ArrayList<Landing> getLandings() throws ApplicationException {
		Session session = getSession(false);
		ArrayList<Landing> landing = null;
		try {
			Criteria criteria = session.createCriteria(Landing.class);
			landing = (ArrayList<Landing>) criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		
		return landing;
	}


}