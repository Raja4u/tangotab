package com.tangotab.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tangotab.TO.BookDealTO;
import com.tangotab.TO.CityTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.OfferDetailsTO;
import com.tangotab.TO.QueryTO;
import com.tangotab.TO.ReportTO;
import com.tangotab.TO.RevenueReportTO;
import com.tangotab.TO.SearchTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.UserTO;
import com.tangotab.dao.pojo.AmbReferences;
import com.tangotab.dao.pojo.Ambassador;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.dao.pojo.CharityDetails;
import com.tangotab.dao.pojo.ConsumerReferral;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.Events;
import com.tangotab.dao.pojo.ExternalReferral;
import com.tangotab.dao.pojo.HomeSignUp;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantCC;
import com.tangotab.dao.pojo.RestaurantCcProfile;
import com.tangotab.dao.pojo.RestaurantDeal;
import com.tangotab.dao.pojo.RestaurantDealHistory;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantLocationPreference;
import com.tangotab.dao.pojo.RestaurantPaymentProfile;
import com.tangotab.dao.pojo.SalesManagerInfo;
import com.tangotab.dao.pojo.SalesRepresentInfo;
import com.tangotab.dao.pojo.Support;
import com.tangotab.dao.pojo.User;
import com.tangotab.dao.pojo.UserValidationCode;
import com.tangotab.exception.ApplicationException;

public interface UserDAO {
	public int saveConsumer(User consumer) throws ApplicationException;

	public int updateConsumer(User consumer) throws ApplicationException;

	public int saveRestaurant(User restOwner) throws ApplicationException;

	public void updateRestaurant(User restOwner) throws ApplicationException;
	
	public boolean changeRestaurantAutoDebit(int restaurentId,  short status) throws ApplicationException;

	public int saveLocation(User locationManager) throws ApplicationException;

	public int updateLocation(User locationManager) throws ApplicationException;

	public ArrayList<User> getUser(String emailId, String password) throws ApplicationException;

	// public User getUser(String emailId, String password) throws ApplicationException;

	public User getUser(String emailId, String password, int roleId) throws ApplicationException;

	public boolean verifyValidationCode(String emailId, String password, String validationCode)
			throws ApplicationException;

	public ArrayList<User> getPassword(String emailId) throws ApplicationException;

	public boolean resetPassword(String emailId, String currentPassword, String newPassword)
			throws ApplicationException;

	public void deleteRestaurant(int userId) throws ApplicationException;

	public boolean activateUser(String emailId, int roleId) throws ApplicationException;

	public boolean deactivateUser(String emailId, int roleId) throws ApplicationException;

	public void deleteConsumerPreferences(int consumerID) throws ApplicationException;

	public Restaurant getRestaurantId(int userId) throws ApplicationException;

	public int getNoEnteredLocations(int restaurentID) throws ApplicationException;

	public boolean deleteValidationCode(String emailId, String password, String validationCode)
			throws ApplicationException;

	public ArrayList<RestaurantDeal> searchDeals(SearchTO searchCriteria)
			throws ApplicationException;

	public RestaurantDeal fetchDealByDealId(int restDealId) throws ApplicationException;

	public int saveValidationCode(UserValidationCode ValidationCode) throws ApplicationException;

	public BookDealTO bookDeal(int userId, int dealId, String date,String startTime) throws ApplicationException;

	public BookDealTO bookDeal(int userId, int dealId, int bookdealId, String date)
			throws ApplicationException;

	public DealTO fetchDealTemplateDeal(String dealTemplateId) throws ApplicationException;

	public boolean saveRechargeInfo(BillingCc rechargedPayInfo) throws ApplicationException;

	public int checkAvailability(String emailId) throws ApplicationException;

	public ArrayList<ConsumerReservation> getUserDealsHistory(int userId)
			throws ApplicationException;
	
	public ArrayList<ConsumerReservation> getRestaurantUserDealHistory(int restaurantId) throws ApplicationException;

	
	public ArrayList<ConsumerReservation> getRestaurantUserDealHistory(int restaurantId,Date startDate,Date endDate) throws ApplicationException;
	
	public boolean checkUserAvilability(String emailId);

	public ArrayList<BillingCc> getBillingSummary(int restId) throws ApplicationException;

	public String getUserName(String emailId) throws ApplicationException;

	public ArrayList<Restaurant> getAllRestaurants() throws ApplicationException;

	public int forwardDealToFriend(ConsumerReferral refer) throws ApplicationException;
	
	public int referAFriend(ExternalReferral refer) throws ApplicationException;

	public boolean setRestaurantStatus(int restId, Short status) throws ApplicationException;

	public Restaurant getRestaurantById(Integer restaurantId) throws ApplicationException;

	public ArrayList<Restaurant> getRestaurantByName(String businessName)
			throws ApplicationException;

	public ArrayList<User> getAllUsers() throws ApplicationException;

	public boolean setUserStatus(String emailId, short status, int roleId)
			throws ApplicationException;

	public boolean setUserPwdStatus(String emailId, short pstatus) throws ApplicationException;

	public boolean setUserConsumerStatus(String emailId, short pstatus, int roleId)
			throws ApplicationException;

	public User getUserByUserId(Integer userId) throws ApplicationException;

	public ArrayList<User> getUserById(String name) throws ApplicationException;

	public int saveSupportData(Support support) throws ApplicationException;

	public boolean saveCreditcard(RestaurantCC restaurantCC) throws ApplicationException;

	public ArrayList<Support> getAllSupportIssues() throws ApplicationException;

	public Support getSupportIssueById(Integer supportId) throws ApplicationException;

	public User getUserByEmailId(String email) throws ApplicationException;

	public boolean setSupportStatus(Integer supportId, Integer status) throws ApplicationException;

	public ArrayList<Support> getSupportIssuesByEmail(String name) throws ApplicationException;

	public ArrayList<RestaurantDealHistory> newsearchDeals(SearchTO searchCriteria)
			throws ApplicationException;

	public RestaurantDealHistory fetchDealHistoryByDealId(int restDealId)
			throws ApplicationException;

	public void saveSalesManager(SalesManagerInfo salesManagerInfo) throws ApplicationException;

	public ArrayList<CityTO> fetchCitiesOfMgr(int salesMgrId) throws ApplicationException;

	public void updateSalesMgrInfo(SalesManagerInfo salesManagerInfo) throws ApplicationException;

	public void saveSalesRepresentInfo(SalesRepresentInfo salesRepresentInfo)
			throws ApplicationException;

	public void updateSalesRepresentInfo(SalesRepresentInfo salesRepresentInfo)
			throws ApplicationException;

	public ArrayList<SalesManagerInfo> fetchSalesManagerDetails(String type)
			throws ApplicationException;

	public ArrayList<SalesRepresentInfo> fetchSalesRepresentativeInfo(String type)
			throws ApplicationException;

	public ArrayList<UserTO> getSalesMangers() throws ApplicationException;

	public ArrayList<CityTO> getCitiesOfManger(int managerId);

	public SalesRepresentInfo getSalesRepresentInfo(int salesRepId) throws ApplicationException;

	public SalesManagerInfo getSalesManagerInfo(int salesMgrId) throws ApplicationException;

	public void deleteSalesMgrCities(int salesMgrId) throws ApplicationException;

	public void deleteSalesRepZipcodes(int salesRepId) throws ApplicationException;

	public void updateActives(int[] userId, int[] activeId) throws ApplicationException;

	public RestaurantCC getRestaurantCC(int restId) throws ApplicationException;

	public ArrayList<RestaurantLocationPreference> getCuisinesByLocationId(Integer locationId)
			throws ApplicationException;

	public ArrayList<RestaurantLocation> getLocationManagers(int restId)
			throws ApplicationException;

	public ArrayList<RestaurantLocation> getLocationsOfDealMgr(int userId)
			throws ApplicationException;

	public String getPassword(String emailId, int RoleId) throws ApplicationException;

	public boolean resetPassword(String emailId, String newPassword) throws ApplicationException;

	public boolean checkUserAvailability(String emailId, int roleId);

	public void saveRefferal(AmbReferences amb, int reffercode) throws ApplicationException;

	public Ambassador getAmbassadorbyReffCode(int reffercode) throws ApplicationException;

	public int saveCcProfile(RestaurantCcProfile ccprofile) throws ApplicationException;

	public RestaurantCcProfile getCcProfile(int restId) throws ApplicationException;

	public void savePaymentProfile(RestaurantPaymentProfile pprofile) throws ApplicationException;

	public ArrayList<RestaurantPaymentProfile> getPaymentProfiles(int profileId)
			throws ApplicationException;

	public ArrayList<String> getRolesByEmail(String emailId) throws ApplicationException;

	public User getQuestionsByEmail(String emailId, Integer roleId) throws ApplicationException;

	public void deleteConsumerPreferCity(int consumerID) throws ApplicationException;

	public String getIsAutoDebit(int restId) throws ApplicationException;

	public ConsumerReservation getConReserveByReservationId(int rId) throws ApplicationException;
	
	public long countAllRestaurants() throws ApplicationException;
	
	public ArrayList<Restaurant> getAllRestaurants(int currentPage,SortByTO sortByTO) throws ApplicationException;
	
	public long countRestaurantByName(String businessName)throws ApplicationException;
	
	public ArrayList<Restaurant> getRestaurantByName(String businessName, int currentPage,SortByTO sortByTO)
	throws ApplicationException ;
	
	public ArrayList<User> getUserById(String name, int page,SortByTO sortByTO) throws ApplicationException;
	
	public Long countAllUsers(String name) throws ApplicationException;
	
	public ArrayList<User> getAllUsers(int page,SortByTO sortByTO) throws ApplicationException;
	
	public Long countSearchDeals(SearchTO searchCriteria)throws ApplicationException;
	
	public ArrayList<RestaurantDeal> searchDeals(SearchTO searchCriteria, int currentPage)
	throws ApplicationException;
	public ArrayList< ReportTO> getRestaurantReports() throws ApplicationException;
	public ArrayList< ReportTO> getUserPrefReports(QueryTO queryTo) throws ApplicationException;
	public ArrayList<RestaurantDeal> getHotDeals(SearchTO searchCriteria)	throws ApplicationException ;
	
	public Events getEventById(Integer id)throws ApplicationException;
	
	public void deleteConsumerEvents(int consumerID) throws ApplicationException;
	
	public long countBookedDealsPerDate(int userId, int dealId, String bookedDate) throws ApplicationException;
	
	public long countBookedDeals(int userId, int dealId) throws ApplicationException;
	public ArrayList< ReportTO> getUserBookDealReports(Date startdate,Date enddate) throws ApplicationException;
	public void saveHomeUser(HomeSignUp homeSignUp)throws ApplicationException;
	public ArrayList<ReportTO> getHomeSignUp() throws ApplicationException ;
	public ArrayList<DealTO> searchDealsort(SearchTO searchCriteria,int count)	throws ApplicationException;
	public int  countSearchDealsort(SearchTO searchCriteria) throws ApplicationException ;
	
	public boolean getUserStatus(String emailId,  int roleId)
	throws ApplicationException ;
	public  ArrayList<DealTO> sendDealexpireMails() throws ApplicationException ;
	
	public void saveCharityCount(CharityDetails details) throws ApplicationException;
	
	public Integer getUserIdByMailId(String mailId)throws ApplicationException;
	
	public OfferDetailsTO getOffersDetails(Date startDate,Integer cityId) throws ApplicationException;
	
	public ArrayList<RevenueReportTO> getRevenueReport(QueryTO queryTO) throws ApplicationException;
	
	public boolean updateOfferConfirmationStatus(int conresId, short status)throws ApplicationException;
	
	public ConsumerReservation getReservationDetails(int conresId) throws ApplicationException;
	
	public void updateHostCredits(int restId)throws ApplicationException;
	public Restaurant getRestaurantByConResId(int conresId) throws ApplicationException;
	
	public Landing getLandingBySource(String source) throws ApplicationException ;
	
	public Landing getLandingByRefferCode(int refferCode) throws ApplicationException ;
}