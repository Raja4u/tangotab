package com.tangotab.util;

import com.tangotab.exception.ApplicationException;
import com.tangotab.web.form.LocationForm;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TangoTabUtility file will contain the utility methods for the TangoTab product.
 * 
 * @author Techgene
 * @dated 20-Jan-2011
 * @version 1.0
 */
public class TangoTabUtility {
	private static Pattern pattern;
	private static Matcher matcher;
	private static final Logger log = LoggerFactory.getLogger(TangoTabUtility.class);
	private static ResourceBundle tangoTabResourceBundle = null;

	/**
	 * @return a random lowercase character from 'a' to 'z'
	 */
	private static char randomLowercase() {
		return (char) (97 + (int) (Math.random() * 26));
	}

	/**
	 * @return a random uppercase character from 'A' to 'Z'
	 */
	private static char randomUppercase() {
		return (char) (65 + (int) (Math.random() * 26));
	}

	/**
	 * @return a random character in this list: !"#$%&'()*+,-./
	 */
	// private static char randomOther() {
	// return (char) (33 + (int) (Math.random() * 15));
	// }
	/**
	 * @return a random character from '0' to '9'
	 */
	private static char randomNumber() {
		return (char) (48 + (int) (Math.random() * 10));
	}

	public static String generateRandomCode() {
		StringBuilder password = new StringBuilder("");
		password.append(randomUppercase());
		password.append(randomLowercase());
		password.append(randomUppercase());
		password.append(randomLowercase());
		password.append(randomNumber());
		password.append(randomNumber());
		password.append(randomLowercase());
		password.append(randomUppercase());
		return password.toString();
	}

	/**
	 * Loads the tangotab.properties resource bundle into a static variable.
	 * 
	 * @return bundle by loading the file when bundle is empty, otherwise it returns the same bundle
	 *         which is already loaded.
	 */
	public static ResourceBundle getTangoTabResourceBundle() {
		if (tangoTabResourceBundle == null) {
			if (log.isDebugEnabled()) {
				log.debug("Loading " + TangotabConstants.TANGO_TAB_RESOURCE_BUNDLE_NAME
						+ " file using FileInputStream");
			}

			tangoTabResourceBundle = ResourceBundle
					.getBundle(TangotabConstants.TANGO_TAB_RESOURCE_BUNDLE_NAME);

			if (log.isDebugEnabled()) {
				log.debug("Loading " + TangotabConstants.TANGO_TAB_RESOURCE_BUNDLE_NAME
						+ " file is successfully completed.");
			}
		}
		return tangoTabResourceBundle;
	}
	
	/* Returns the no.of pages and the current page */
	public static  String paginationForGuestAndHost(String num, String page, String user, String searchname){
		/* checking for the first time or not */
		Integer noOfPages = 0;
		int total = 0;
		String info = new String();
		if(num == null){
		try {
			/*calculates total pages and set to request scope for display 1 2 3..*/
			if(user.equals("host"))
				total = (int)com.tangotab.businessImpl.BusinessFactory.getUserBO().countRestaurantByName(searchname);
			else
				 total = (int)com.tangotab.businessImpl.BusinessFactory.getUserBO().countAllUsers(searchname).longValue();
			noOfPages = total/TangotabConstants.PAGE_SIZE;
			if(total%TangotabConstants.PAGE_SIZE != 0)
				noOfPages += 1;
			info = noOfPages.toString()+","+"1";
	   } catch (ApplicationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}else{
			/* read the requested page no, if it not first time */
			if(page != null)
				info = num +","+ page;
		}
		return info;
	}
	 
	/* convert the week of day number to words */
	
	
	public static  String convertWeekDays(String weekDay){
		StringBuffer wordweekDay=new StringBuffer();
		try {
			String days[] = weekDay.split(",");

			for (int i = 0; i < days.length; i++) {
				if (i > 0 && i < (days.length))
					wordweekDay.append( ","); 
				if (days[i].equals("1")) {
					wordweekDay.append("SUN");
				} else if (days[i].equals("2")) {
					wordweekDay.append(" MON ");
				} else if (days[i].equals("3")) {
					wordweekDay.append( " TUE");
				} else if (days[i].equals("4")) {
					wordweekDay.append( " WED");
				} else if (days[i].equals("5")) {
					wordweekDay.append(" THU");
				} else if (days[i].equals("6")) {
					wordweekDay.append(" FRI");
				} else if (days[i].equals("7")) {
					wordweekDay.append(" SAT");
				}

			}
			wordweekDay.append(" . ");
 
	   } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		return wordweekDay.toString();
	}
	
	public static String makeAlternateEmailsList(LocationForm form){
		String list = "";
		if(StringUtils.isNotEmpty(form.getEmailIdOne())){
			if(StringUtils.isNotEmpty(form.getNameOne()))
			  list = list+ form.getNameOne()+ ":"+ form.getEmailIdOne();
			else
				list = list+ ":"+ form.getEmailIdOne();
		}
		if(StringUtils.isNotEmpty(form.getEmailIdTwo())){
			if(StringUtils.isNotEmpty(form.getNameTwo()))
				  list = list+","+ form.getNameTwo()+ ":"+ form.getEmailIdTwo();
				else
					list = list+","+ ":"+ form.getEmailIdTwo();
			
		}
		if(StringUtils.isNotEmpty(form.getEmailIdThree())){
			if(StringUtils.isNotEmpty(form.getNameThree()))
				  list = list+","+ form.getNameThree()+ ":"+ form.getEmailIdThree();
				else
					list = list+","+ ":"+ form.getEmailIdThree();
		}
		if(StringUtils.isNotEmpty(form.getEmailIdFour())){
			if(StringUtils.isNotEmpty(form.getNameFour()))
				  list = list+","+ form.getNameFour()+ ":"+ form.getEmailIdFour();
				else
					list = list+","+ ":"+ form.getEmailIdFour();
		}
		if(StringUtils.isNotEmpty(form.getEmailIdFive())){
			if(StringUtils.isNotEmpty(form.getNameFive()))
			  list = list+","+ form.getNameFive()+ ":"+ form.getEmailIdFive();
			else
				list = list+","+ ":"+ form.getEmailIdFive();
		}
		/* removing the first character if starts with comma */
		if(list.length()>0 && list.charAt(0) == ','){
			
				list = list.substring(1);
		}
		return list;
		
	}		

	  /**
	   * Validate hex with regular expression
	   * @param hex hex for validation
	   * @return true valid hex, false invalid hex
	   */
	  public static boolean isEmailId(final String hex){
		  pattern = Pattern.compile(TangotabConstants.EMAIL_PATTERN);
		  matcher = pattern.matcher(hex);
		  return matcher.matches();

	  }
}
