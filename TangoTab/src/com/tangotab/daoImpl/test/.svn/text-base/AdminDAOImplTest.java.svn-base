package com.tangotab.daoImpl.test;

import java.util.List;

import junit.framework.TestCase;

import com.tangotab.dao.pojo.BillingMethod;
import com.tangotab.dao.pojo.BillingType;
import com.tangotab.dao.pojo.CuisineType;
import com.tangotab.dao.pojo.DiningStyle;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.daoImpl.AdminDAOImpl;
import com.tangotab.exception.ApplicationException;

public class AdminDAOImplTest extends TestCase {
	private AdminDAOImpl dao = null;

	public void testCuisineTypes() {
		String cuisineType = "TestCuisineType";
		try {
			int cuisineTypeId = dao.saveCuisineType(new CuisineType(cuisineType,1));
			assertTrue(cuisineTypeId > 0);

			CuisineType newVO = dao.getCuisineTypeById(cuisineTypeId);
			assertTrue(newVO.getType().equals(cuisineType));

			int noOfDeletedRows = dao.deleteCuisineType(cuisineTypeId);
			assertTrue(noOfDeletedRows == 1);

			newVO = dao.getCuisineTypeById(cuisineTypeId);
			assertTrue(newVO == null);

			List<CuisineType> list = dao.getCuisineTypes();
			assertTrue(list != null && list.size() > 0);
		} catch (ApplicationException e) {
			e.printStackTrace();
			fail("testCuisineTypes is failed... message: " + e.getMessage());
		}
	}

	public void testBillingTypes() {
		String billingType = "Independent";
		try {
			int billingTypeId = 1;// dao.saveBillingType(new
			// BillingType(billingType));
			assertTrue(billingTypeId > 0);

			BillingType newVO = dao.getBillingTypeById(billingTypeId);
			assertTrue(newVO.getBillingTypeName().equals(billingType));

			int noOfDeletedRows = dao.deleteBillingType(billingTypeId);
			assertTrue(noOfDeletedRows == 1);

			newVO = dao.getBillingTypeById(billingTypeId);
			assertTrue(newVO == null);

			List<BillingType> list = dao.getBillingTypes();
			assertTrue(list != null && list.size() > 0);
		} catch (ApplicationException e) {
			e.printStackTrace();
			fail("testBillingTypes is failed... message: " + e.getMessage());
		}
	}

	public void testBillingMethods() {
		String billingMethod = "TestBillingMethod";
		try {
			int billingMethodId = 1;// dao.saveBillingMethod(new
			// BillingMethod(billingMethod));
			assertTrue(billingMethodId > 0);

			BillingMethod newVO = dao.getBillingMethodById(billingMethodId);
			assertTrue(newVO.getBillingMethodName().equals(billingMethod));

			int noOfDeletedRows = dao.deleteBillingMethod(billingMethodId);
			assertTrue(noOfDeletedRows == 1);

			newVO = dao.getBillingMethodById(billingMethodId);
			assertTrue(newVO == null);

			List<BillingMethod> list = dao.getBillingMethods();
			assertTrue(list != null && list.size() > 0);
		} catch (ApplicationException e) {
			e.printStackTrace();
			fail("testBillingTypes is failed... message: " + e.getMessage());
		}
	}

	public void testRestaurantTypes() {
		String restaurantType = "TestRestaurantType";
		try {
			int restaurantTypeId = 1;// dao.saveRestaurantType(new
			// RestaurantType(restaurantType));
			assertTrue(restaurantTypeId > 0);

			RestaurantType newVO = dao.getRestaurantTypeById(restaurantTypeId);
			assertTrue(newVO.getRestTypeName().equals(restaurantType));

			int noOfDeletedRows = dao.deleteRestaurantType(restaurantTypeId);
			assertTrue(noOfDeletedRows == 1);

			newVO = dao.getRestaurantTypeById(restaurantTypeId);
			assertTrue(newVO == null);

			List<RestaurantType> list = dao.getRestaurantTypes();
			assertTrue(list != null && list.size() > 0);
		} catch (ApplicationException e) {
			e.printStackTrace();
			fail("testRestaurantTypes is failed... message: " + e.getMessage());
		}
	}

	public void testDiningStyles() {
		String diningStyle = "TestDiningStyle";
		try {
			int diningStyleId = dao.saveDiningStyle(new DiningStyle(diningStyle));
			assertTrue(diningStyleId > 0);

			DiningStyle newVO = dao.getDiningStyleById(diningStyleId);
			assertTrue(newVO.getDiningStyleName().equals(diningStyle));

			int isDeleted = dao.deleteDiningStyle(diningStyleId);
			assertTrue(isDeleted == 1);

			newVO = dao.getDiningStyleById(diningStyleId);
			assertTrue(newVO == null);

			List<DiningStyle> list = dao.getDiningStyles();
			assertTrue(list != null && list.size() > 0);
		} catch (ApplicationException e) {
			e.printStackTrace();
			fail("testRestaurantTypes is failed... message: " + e.getMessage());
		}
	}

	public void testDeactivateRestaurant() {
		try {
			boolean isUpdated = dao.deactivateRestaurant(1);
			assertTrue(isUpdated);

			isUpdated = dao.deactivateRestaurant(1212312);
			assertTrue(!isUpdated);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testActivateRestaurant() {
		try {
			boolean isUpdated = dao.activateRestaurant(1);
			assertTrue(isUpdated);

			isUpdated = dao.activateRestaurant(1212312);
			assertTrue(!isUpdated);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testDeactivateRestaurantLocation() {
		try {
			boolean isUpdated = dao.deactivateRestaurantLocation(2);
			assertTrue(isUpdated);

			isUpdated = dao.deactivateRestaurantLocation(1212312);
			assertTrue(!isUpdated);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testActivateRestaurantLocation() {
		try {
			boolean isUpdated = dao.activateRestaurantLocation(2);
			assertTrue(isUpdated);

			isUpdated = dao.activateRestaurantLocation(1212312);
			assertTrue(!isUpdated);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testConfigs() {
		// TODO:
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dao = new AdminDAOImpl();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}