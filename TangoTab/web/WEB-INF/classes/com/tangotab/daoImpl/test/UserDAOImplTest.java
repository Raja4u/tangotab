package com.tangotab.daoImpl.test;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.tangotab.dao.pojo.ConsumerPreference;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantType;
import com.tangotab.dao.pojo.Role;
import com.tangotab.dao.pojo.User;
import com.tangotab.daoImpl.UserDAOImpl;

public class UserDAOImplTest extends TestCase {/*
	UserDAOImpl dao = new UserDAOImpl();

	public void testGetUser() {

	}

	public void testSaveConsumer() {
		try {
			User consumer = new User();
			consumer.setFirstname("Naveen");
			consumer.setLastname("Kumar");
			consumer.setAddress("Begumpet, Hyd");
			consumer.setMobilePhone("1231231231");
			consumer.setHomePhone("333333333333");
			consumer.setZipCode("12311");
			Role role = new Role();
			role.setRoleId(4);
			consumer.setRole(role);
			consumer.setEmailId("consumer" + System.currentTimeMillis() + "@gmail.com");
			consumer.setPassword("kumar");
			consumer.setIsActive(new Short("0"));

			ConsumerPreference preference1 = new ConsumerPreference();
			preference1.setUser(consumer);
			preference1.setPreferenceId(1);

			ConsumerPreference preference2 = new ConsumerPreference();
			preference2.setUser(consumer);
			preference2.setPreferenceId(2);

			ConsumerPreference preference3 = new ConsumerPreference();
			preference3.setUser(consumer);
			preference3.setPreferenceId(3);
			Set set = new HashSet();
			set.add(preference1);
			set.add(preference2);
			set.add(preference3);

			consumer.setConsumerPreferences(set);

		} catch (Exception e) {
			e.printStackTrace();
			fail("Got exception " + e.getMessage());
		}
	}

	public void testSaveRestaurant() {
		User dealManager = new User();
		dealManager.setFirstname("Naveen");
		dealManager.setLastname("Kumar");
		dealManager.setAddress("Begumpet, Hyd");
		dealManager.setMobilePhone("1231231231");
		dealManager.setHomePhone("333333333333");
		dealManager.setZipCode("12311");
		Role role = new Role();
		role.setRoleId(5);
		dealManager.setRole(role);
		dealManager.setEmailId("rest.owner" + System.currentTimeMillis() + "@gmail.com");
		dealManager.setPassword("kumar");
		dealManager.setIsActive(new Short("0"));

		Restaurant restaurant = new Restaurant();
		// restaurant.setRestaurantId(1);
		restaurant.setBusinessName("Sphoorthi Group");
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setRestTypeId(1);

		// restaurant.setRestaurantType(restaurantType);
		restaurant.setNoOfLocations(1);
		restaurant.setUser(dealManager);
		// restaurant.setIsActive(new Short("0"));

		Set rests = new HashSet();
		rests.add(restaurant);
		
	}

	public void testSaveLocation() {
		User locationManager = new User();
		locationManager.setFirstname("Naveen");
		locationManager.setLastname("Kumar");
		locationManager.setAddress("Begumpet, Hyd");
		locationManager.setMobilePhone("1231231231");
		locationManager.setHomePhone("333333333333");
		locationManager.setZipCode("12311");
		Role role = new Role();
		role.setRoleId(6);
		locationManager.setRole(role);
		locationManager.setEmailId("location.mgr" + System.currentTimeMillis() + "@gmail.com");
		locationManager.setPassword("kumar");
		locationManager.setIsActive(new Short("0"));

		RestaurantLocation location = new RestaurantLocation();
		location.setStreetNo("1-5-462/7");
		location.setStreetName("Surya Nagar");
		// location.setCityId(1);
		location.setStateId(3);
		location.setCountryId(2);
		location.setZipCode("12311");
		location.setDirectionImgPath("/images/rest_1/rest_1_dir_img_1.jpg");
		location.setLocationRestName("Sphoorthi Nilayam");
		location.setLocationRestImgPath("/images/rest_1/rest_1_img_1.jpg");

		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(1);

		location.setRestaurant(restaurant);
		location.setIsActive(new Short("0"));
		location.setCuisineTypeIds("1,2,4,5");
		location.setDiningStyleIds("2,3,4");
		location.setPriceStartRate(5.00);
		location.setPriceEndRate(25.00);
		location.setWebSite("www.techgene.com");
		location.setDescription("Don't ask about the restaurant. Find in website.");
		location.setUser(locationManager);
		location.setIsActive(new Short("0"));

		Set restaurantLocations = new HashSet();
		restaurantLocations.add(location);
		locationManager.setRestaurantLocations(restaurantLocations);

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		dao.silentCloseFactory();
	}
*/}
