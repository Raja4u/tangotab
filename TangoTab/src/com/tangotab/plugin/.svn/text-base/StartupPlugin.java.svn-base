package com.tangotab.plugin;

import com.tangotab.TO.DropDownTO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.DealBO;
import com.tangotab.businessImpl.BusinessFactory;
import com.tangotab.util.ReportGenerator;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.util.Calendar;
import java.util.Timer;

public class StartupPlugin implements PlugIn {
	private Logger log = LoggerFactory.getLogger(CommonBO.class);

	public void destroy() {
	}

	public void init(ActionServlet servlet, ModuleConfig config) {
		if (log.isDebugEnabled()) {
			log.debug("start of init(ActionServlet servlet, ModuleConfig config in StartupPlugin");
		}
		ServletContext context = servlet.getServletContext();
		CommonBO commonBO = BusinessFactory.getCommonBO();
		DealBO dealBO = BusinessFactory.getDealBO();
		DropDownTO dropDownInfo = new DropDownTO();
		try {
			
			dropDownInfo.setCountries(commonBO.getCountries());
			dropDownInfo.setStates(commonBO.getStates());
			dropDownInfo.setCities(commonBO.getCities());
			dropDownInfo.setCusineTypes(commonBO.getCuisineTypes());
			dropDownInfo.setDiningStyles(commonBO.getDiningStyles());
			dropDownInfo.setBillingMethods(commonBO.getBillingMethods());
			dropDownInfo.setBillingTypes(commonBO.getBillingTypes());

			dropDownInfo.setBusinessTypes(commonBO.getBusinessTypes());
			dropDownInfo.setDeals(commonBO.getDeals());
			dropDownInfo.setRatings(commonBO.getRatings());
			dropDownInfo.setPrices(commonBO.getPrices());
			dropDownInfo.setDealName(dealBO.getAllDealNames());
			dropDownInfo.setDealRestriction(dealBO.getAllRestrictions());
			dropDownInfo.setEvents(commonBO.getAllEvents());
			dropDownInfo.setRestaurants(commonBO.getAllLocations());
			 Calendar date = Calendar.getInstance();
			    

			  
			    int days = Calendar.SUNDAY - date.get(Calendar.DAY_OF_WEEK);  
			    if (days < 0)  
			    {  
			        // this will usually be the case since Calendar.SUNDAY is the smallest  
			        days += 8;  
			    } 
			    date.set(Calendar.HOUR, 2);
			    date.set(Calendar.MINUTE, 0);
			    date.set(Calendar.SECOND, 0);
			    date.set(Calendar.MILLISECOND, 0);


			 
			    date.add(Calendar.DAY_OF_MONTH, days); 
			    Timer timer=new Timer();
			    // Schedule to run every Monday in midnight
			    timer.schedule(
			    	      new ReportGenerator(),
			    	      date.getTime(),
			    	      1000 * 60 * 60 * 24 * 7
			    	    );

			    /* setting the charity count */
			    context.setAttribute("charityCount", commonBO.getCharityCount());
			   // System.out.print("charityCount"+commonBO.getCharityCount());
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured in startup pluing" + e.getMessage());
			}
			e.printStackTrace();
		}
		context.setAttribute("dropDownList", dropDownInfo);
	}

}
