package com.tangotab.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.tangotab.TO.BillingCcTO;
import com.tangotab.TO.BookDealTO;
import com.tangotab.TO.CharityTO;
import com.tangotab.TO.CityTO;
import com.tangotab.TO.ConsumerReservationTO;
import com.tangotab.TO.ContactTO;
import com.tangotab.TO.DealTO;
import com.tangotab.TO.LandingTO;
import com.tangotab.TO.LocationTO;
import com.tangotab.TO.PublishDealTO;
import com.tangotab.TO.QueryTO;
import com.tangotab.TO.ReportTO;
import com.tangotab.TO.RevenueReportTO;
import com.tangotab.TO.SalesManagerTO;
import com.tangotab.TO.SearchTO;
import com.tangotab.TO.SortByTO;
import com.tangotab.TO.SuggestRestTO;
import com.tangotab.TO.SupportTO;
import com.tangotab.TO.UserTO;
import com.tangotab.dao.pojo.BillingCc;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.dao.pojo.ConsumerReferral;
import com.tangotab.dao.pojo.ConsumerReservation;
import com.tangotab.dao.pojo.ExternalReferral;
import com.tangotab.dao.pojo.HomeSignUp;
import com.tangotab.dao.pojo.Restaurant;
import com.tangotab.dao.pojo.RestaurantCC;
import com.tangotab.dao.pojo.RestaurantCcProfile;
import com.tangotab.dao.pojo.RestaurantLocation;
import com.tangotab.dao.pojo.RestaurantLocationPreference;
import com.tangotab.dao.pojo.RestaurantPaymentProfile;
import com.tangotab.dao.pojo.Support;
import com.tangotab.dao.pojo.User;
import com.tangotab.exception.ApplicationException;
import com.tangotab.web.form.CharityForm;

public interface UserBO {
	
 
	public ArrayList<UserTO> getProfiles(String emailId, String password)
			throws ApplicationException;

	public UserTO getTangoTabUser(String emailId, String password, int roleId)
			throws ApplicationException;

	public User saveConsumer(User consumer) throws ApplicationException;

	public void updateConsumer(User consumer) throws ApplicationException;

	public boolean forgotPassword(String emailId) throws ApplicationException;

	public boolean resetPassword(String emailId, String currentPassword, String newPassword)
			throws ApplicationException;

	public ArrayList<ConsumerReservation> getConsumerReservations(User user)
			throws ApplicationException;

	public ArrayList<ConsumerReferral> getReferrals(User user) throws ApplicationException;

	public int saveRestaurantClient(User client) throws ApplicationException;

	public void updateClient(User client) throws ApplicationException;

	public int getNoOfEnteredLocations(int restaurantId) throws ApplicationException;

	public ArrayList<DealTO> searchDeals(SearchTO searchCriteria) throws ApplicationException;

	public DealTO fetchDealByDealId(int dealId) throws ApplicationException;

	public BookDealTO bookDeal(int userId, int dealId, DealTO dealTO) throws ApplicationException;

	public DealTO fetchDealTemplete(String dealName) throws ApplicationException;

	public boolean contactUsMail(ContactTO contact) throws ApplicationException;

	public boolean publishDealMail(PublishDealTO contact) throws ApplicationException;

	public ArrayList<ConsumerReservationTO> getUserDealsHistory(int userId)
			throws ApplicationException;
	
	public ArrayList<ConsumerReservationTO> getRestaurantUserHistory(int restaurantId)throws ApplicationException;

	public ArrayList<ConsumerReservationTO> getRestaurantUserHistory(int restaurantId,Date StartDate,Date endDate) throws ApplicationException;
	
	public boolean forwardDealToFriend(ConsumerReferral refer, String dealId)
			throws ApplicationException;
	
	public boolean referAFriend(ConsumerReferral refer)
	        throws ApplicationException;

	public ArrayList<BillingCcTO> getBillingSummary(int restId) throws ApplicationException;

	// Admin section
	public ArrayList<Restaurant> getAllRestaurants() throws ApplicationException;

	public boolean setRestaurantStatus(int restId, Short status) throws ApplicationException;

	public boolean setUserConsumerStatus(String emailId, short pstatus, int roleId)
			throws ApplicationException;

	public void saveRestaurantClient(User client, String mail) throws ApplicationException;

	public Restaurant getRestaurantById(Integer restaurantId) throws ApplicationException;

	public ArrayList<Restaurant> getRestaurantByName(String businessName)
			throws ApplicationException;

	public ArrayList<UserTO> getAllUsers() throws ApplicationException;

	public boolean setUserStatus(String emailId, short status, int roleId)
			throws ApplicationException;

	public boolean setUserPwdStatus(String emailId, short pstatus) throws ApplicationException;

	public void saveConsumer(User consumer, String mail) throws ApplicationException;

	public UserTO getUserByUserId(Integer userId) throws ApplicationException;

	public ArrayList<User> getUserById(String name) throws ApplicationException;

	public void saveRechargeInfo(BillingCc paymentTO, String name, String emailId)
			throws ApplicationException;

	public int saveSupportData(Support support) throws ApplicationException;

	public ArrayList<SupportTO> getAllSupportIssues() throws ApplicationException;

	public SupportTO getSupportIssueById(Integer supportId) throws ApplicationException;

	public boolean setSupportStatus(Integer supportId, Integer status) throws ApplicationException;

	public ArrayList<SupportTO> getSupportIssuesByEmail(String name) throws ApplicationException;

	public ArrayList<DealTO> newsearchDeals(SearchTO searchCriteria) throws ApplicationException;

	public DealTO fetchDealHistoryByDealId(int dealId) throws ApplicationException;

	public void saveSalesManager(SalesManagerTO salesManagerTO) throws ApplicationException;

	public ArrayList<SalesManagerTO> fetchSalaeMgrInfo(String type) throws ApplicationException;

	public ArrayList<SalesManagerTO> fetchSalesRepInfo(String type) throws ApplicationException;

	public void saveSalesRepresentInfo(SalesManagerTO salesRepresentInfo)
			throws ApplicationException;

	public ArrayList<UserTO> getSalesManagerList() throws ApplicationException;

	public ArrayList<CityTO> getCitiesOfManger(int managerId);

	public SalesManagerTO getSalesRepInfoById(int salesRepId) throws ApplicationException;

	public SalesManagerTO getSalesManagerInfoById(int salesMgrId) throws ApplicationException;

	public void updateSalesRepInfo(SalesManagerTO repIfo) throws ApplicationException;

	public void updateSalesMgrInfo(SalesManagerTO managerInfo) throws ApplicationException;

	public void updateUserActiveStatus(int[] userId, int[] active) throws ApplicationException;

	public void saveCreditcard(RestaurantCC restaurantCC) throws ApplicationException;

	public RestaurantCC getRestaurantCC(int restId) throws ApplicationException;

	public void autoDebitTransaction(int restId) throws ApplicationException;

	public ArrayList<LocationTO> getLocationsOfDealMgr(int userId) throws ApplicationException;

	public boolean checkUserAvailability(String emailId, int roleId);

	public boolean suggestRestaurant(SuggestRestTO user) throws ApplicationException;

	public ArrayList<DealTO> searchByCityDeals(String cityName) throws ApplicationException;

	public void autoDebitTransactions(int restId, ConfigPojo configPojo)
			throws ApplicationException;

	public int saveCcProfile(RestaurantCcProfile ccprofile);

	public void savePaymentProfile(RestaurantPaymentProfile pprofile);

	public ArrayList<RestaurantPaymentProfile> getPaymentProfiles(int profileId)
			throws ApplicationException;

	public ArrayList<String> getRolesByEmail(String emailId);

	public User getQuestionsByEmail(String emailId, Integer roleId);

	public boolean resendValidationEmail(User user, String toemail, String validationCode);

	public ConsumerReservation getConReserveByReservationId(int rId);
	
	public ArrayList<Restaurant> getAllRestaurants(int currentPage,SortByTO sortByTO) throws ApplicationException;
	
	public ArrayList<Restaurant> getRestaurantByName(String businessName, int currentPage,SortByTO sortByTO) throws ApplicationException;
	
	public ArrayList<User> getUserById(String name, int page,SortByTO sortByTO) throws ApplicationException;
	public Long countAllUsers(String emailId);
	public ArrayList<UserTO> getAllUsers(int page,SortByTO sortByTO) throws ApplicationException;
	/* one method left for guest count for search */
	
	public long countSearchDeals(SearchTO searchCriteria);
	
	public ArrayList<DealTO> searchDeals(SearchTO searchCriteria,int currentPage) throws ApplicationException;
	public ArrayList< ReportTO> getRestaurantReports() throws ApplicationException;
	public HSSFWorkbook createRestaurantWorkbook(ArrayList<ReportTO> userList) throws Exception;
	public ArrayList< ReportTO> getUserPrefReports(QueryTO queryTo) throws ApplicationException;
	public HSSFWorkbook createGuestWorkbook(ArrayList<ReportTO> userList)throws Exception;
	public ArrayList<DealTO> getHotDeals(SearchTO searchCriteria) throws ApplicationException ;
	
	public long countBookedDealsPerDate(int userId, int dealId, String bookedDate) throws ApplicationException;
	
	public long countBookedDeals(int userId, int dealId) throws ApplicationException;
	public ArrayList<ReportTO> getUserBookDealReports(Date startdate,
			Date enddate) throws ApplicationException;
	public HSSFWorkbook createBookDealWorkbook(ArrayList<ReportTO> userList) throws Exception;
	public void saveHomeUser(HomeSignUp homeSignUp)throws ApplicationException;
	public ArrayList<ReportTO> getHomeSignUp() throws ApplicationException ;
	public HSSFWorkbook createHomeSignUpWorkbook(ArrayList<ReportTO> userList) throws Exception;
	public DealTO fetchDealByDealId(int dealId, String date) throws ApplicationException;
	public  ArrayList<DealTO> sendDealexpireMails() throws ApplicationException ;
	public void saveCharityCount(CharityTO charityTO) throws ApplicationException;

	public ReportTO getOffersDetails(QueryTO queryTO) throws ApplicationException;
	public Integer getUserIdByMailId(String mailId)throws ApplicationException;
	
	public HSSFWorkbook createOfferPublishCountWorkbook(ReportTO report) throws Exception;

	public ArrayList<RevenueReportTO>  getRevenueReport(QueryTO queryTO) throws ApplicationException;
	
	public HSSFWorkbook generateRevenueReportWorkbook(ArrayList<RevenueReportTO> report) throws ApplicationException;
	
	public boolean referAFriend(ExternalReferral refer, String to)throws ApplicationException;
	
	public boolean updateOfferConfirmationStatus(int conresId, String status)throws ApplicationException;
	
		public LandingTO getLandingBySource(String source) throws ApplicationException;

	public LandingTO getLandingByRefferCode(int refferCode) throws ApplicationException;
	
	public long countAllRestaurants() throws ApplicationException;

    public RestaurantCcProfile getCcProfile(int i) throws ApplicationException;
    
    public long countRestaurantByName(String searchname) throws ApplicationException;
    public List<RestaurantLocation> getLocationManagers(Integer restaurantId) throws ApplicationException;
    public int checkAvailability(String from) throws ApplicationException;
    public String getUserName(String from) throws ApplicationException;
    public  ArrayList<RestaurantLocationPreference>  getCuisinesByLocationId(Integer locid) throws ApplicationException;
    public boolean verifyValidationCode(String emailid, String password, String roleId, String code) throws ApplicationException;;
	
}