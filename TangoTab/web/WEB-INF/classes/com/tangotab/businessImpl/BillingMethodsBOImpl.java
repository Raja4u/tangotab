package com.tangotab.businessImpl;

import com.tangotab.business.BillingMethodsBO;
import com.tangotab.dao.BillingMethodDAO;
import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.exception.ApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class BillingMethodsBOImpl implements BillingMethodsBO {

	/* Only Administrator has rights to add, edit,update the below in to database */
	 

	private BillingMethod billingmethod = new BillingMethod();
	private BillingType billingtype = new BillingType();
	private CuisineType cuisinetype = new CuisineType();
	private RestaurantType restauranttype = new RestaurantType();
	private DiningStyle diningstyle = new DiningStyle();

    @Autowired
    protected BillingMethodDAO billingMethodDAO;

    /* get all types of billing methods for display  */
	public List<BillingMethod> getBillingMethods() throws ApplicationException {
		// TODO Auto-generated method stub
		List<BillingMethod> list = null;

		list = getBillingMethodsDAO().getBillingMethods();

		return list;

	}

    private BillingMethodDAO getBillingMethodsDAO() {
        return billingMethodDAO;
    }

    /* add a new billing method by administrator */
	public void saveBillingMethod(BillingMethod billingMethod) throws ApplicationException {
		// TODO Auto-generated method stub

		try {

			getBillingMethodsDAO().saveBillingMethod(billingMethod);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* update status of billing method */
	public void updateBillingMethod(BillingMethod billingMethod, String activeupdate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			/*billingmethod = getBillingMethod(billingMethod.getBillingMethodId());
			if (activeupdate.equals("Yes"))
				billingMethod.setIsActive(billingmethod.getIsActive());*/

			getBillingMethodsDAO().updateBillingMethod(billingMethod);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* retireve the selected billing method to edit 
	 * */
	public BillingMethod getBillingMethod(int billingId) throws ApplicationException {
		// TODO Auto-generated method stub
		BillingMethod billingMethod = new BillingMethod();
		try {

			billingMethod = getBillingMethodsDAO().getBillingMethod(billingId);

		} catch (ApplicationException e) {
			throw e;
		}
		return billingMethod;
	}

	// ******** Methods For Billing Types*************

	/* return all billing types for display */
	public ArrayList<BillingType> getBillingTypes() throws ApplicationException {
		// TODO Auto-generated method stub
		ArrayList<BillingType> list = null;

		list = getBillingMethodsDAO().getBillingTypes();

		return list;

	}

	/* add a new billing type */
	public void saveBillingType(BillingType billingType) throws ApplicationException {
		// TODO Auto-generated method stub

		try {

			getBillingMethodsDAO().saveBillingType(billingType);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* change the status of the billing type */
	public void updateBillingType(BillingType billingType, String activeupdate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			/*billingtype = getBillingType(billingType.getBillingTypeId());
			if (activeupdate.equals("Yes"))
				billingType.setIsActive(billingtype.getIsActive());*/

			getBillingMethodsDAO().updateBillingType(billingType);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* retrieve the selected billing type from the list of billing types */
	public BillingType getBillingType(int billingId) throws ApplicationException {
		// TODO Auto-generated method stub
		BillingType billingType = new BillingType();
		try {

			billingType = getBillingMethodsDAO().getBillingType(billingId);

		} catch (ApplicationException e) {
			throw e;
		}
		return billingType;
	}

	// ******** Methods For cuisine Types*************

	/* retrieve all cuisine types for display */
	public ArrayList<CuisineType> getCuisineTypes() throws ApplicationException {
		// TODO Auto-generated method stub
		ArrayList<CuisineType> list = null;

		list = getBillingMethodsDAO().getCuisineTypes();

		return list;

	}

	/* add a new cuisine type */
	public void saveCuisineType(CuisineType cuisineType) throws ApplicationException {
		// TODO Auto-generated method stub

		try {

			getBillingMethodsDAO().saveCuisineType(cuisineType);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* change the status of cuisine type */
	public void updateCuisineType(CuisineType cuisineType, String activeupdate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			/*cuisinetype = getCuisineType(cuisineType.getCuisineTypeId());
			if (activeupdate.equals("Yes"))
				cuisineType.setIsActive(cuisinetype.getIsActive());*/

			getBillingMethodsDAO().updateCuisineType(cuisineType);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* get the selected cuisine type for edit */
	public CuisineType getCuisineType(int cuisineId) throws ApplicationException {
		// TODO Auto-generated method stub
		CuisineType cuisineType = new CuisineType();
		try {

			cuisineType = getBillingMethodsDAO().getCuisineType(cuisineId);

		} catch (ApplicationException e) {
			throw e;
		}
		return cuisineType;
	}

	// ******** Methods For restaurant Types*************

	/* display all types of restaurant types */
	public ArrayList<RestaurantType> getRestaurantTypes() throws ApplicationException {
		// TODO Auto-generated method stub
		ArrayList<RestaurantType> list = null;

		list = getBillingMethodsDAO().getRestaurantTypes();

		return list;

	}

	/* add a new restaurant type */
	public void saveRestaurantType(RestaurantType restaurantType) throws ApplicationException {
		// TODO Auto-generated method stub

		try {

			getBillingMethodsDAO().saveRestaurantType(restaurantType);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* change the status of the restaurant type */
	public void updateRestaurantType(RestaurantType restaurantType, String activeupdate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			getBillingMethodsDAO().updateRestaurantType(restaurantType);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* get the selected restaurant type */
	public RestaurantType getRestaurantType(int restId) throws ApplicationException {
		// TODO Auto-generated method stub
		RestaurantType restaurantType = new RestaurantType();
		try {

			restaurantType = getBillingMethodsDAO().getRestaurantType(restId);

		} catch (ApplicationException e) {
			throw e;
		}
		return restaurantType;
	}

	// ******** Methods For dining styles*************

	/* display all dining styles */
	public ArrayList<DiningStyle> getDiningStyles() throws ApplicationException {
		// TODO Auto-generated method stub
		ArrayList<DiningStyle> list = null;

		list = getBillingMethodsDAO().getDiningStyles();

		return list;

	}

	/* add a new dining style */
	public void saveDiningStyle(DiningStyle diningStyle) throws ApplicationException {
		// TODO Auto-generated method stub

		try {

			getBillingMethodsDAO().saveDiningStyle(diningStyle);

		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* change the status of the dining style */
	public void updateDiningStyle(DiningStyle diningStyle, String activeupdate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			/*diningstyle = getDiningStyle(diningStyle.getDiningStyleId());
			if (activeupdate.equals("Yes"))
				diningStyle.setIsActive(diningstyle.getIsActive());*/

			getBillingMethodsDAO().updateDiningStyle(diningStyle);

		} catch (ApplicationException e) {
			throw e;
		}
	}
	
	/* retrieve the selected dining style */
	public DiningStyle getDiningStyle(int styleId) throws ApplicationException {
		// TODO Auto-generated method stub
		DiningStyle diningStyle = new DiningStyle();
		try {

			diningStyle = getBillingMethodsDAO().getDiningStyle(styleId);

		} catch (ApplicationException e) {
			throw e;
		}
		return diningStyle;
	}

}
