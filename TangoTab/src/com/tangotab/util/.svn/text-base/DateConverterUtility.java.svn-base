package com.tangotab.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.tangotab.TO.DateTO;

public class DateConverterUtility {

	public static Date converUiTimeStampToDate(String uiTimestamp) {
		DateFormat uiFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
		Date date = null;
		try {
			date = uiFormat.parse(uiTimestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date convertUiToServiceDate(String uiDate) {
		DateFormat uiFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = uiFormat.parse(uiDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String convertDBTimeStampToUiDate(Date date) {

		DateFormat uiFormat = new SimpleDateFormat("MM/dd/yyyy");
		String uiDate = null;
		if (date != null)
			uiDate = (uiFormat.format(date));
		return uiDate;
	}

	
	public static String convertDBTimeStampToUiTimeStamp(Date date) {

		DateFormat uiFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String uiDate = null;
		if (date != null)
			uiDate = (uiFormat.format(date));
		return uiDate;
	}
	public static String getUniqueStamp() {
		String uniqueStamp = "";
	//	Date date = new Date();
		Calendar calendar=Calendar.getInstance();
 
 
		uniqueStamp += "_" + calendar.get(Calendar.YEAR) + "_" +calendar.get(Calendar.MONTH) + "_" + calendar.get(Calendar.DAY_OF_MONTH) + "-"
				+calendar.get(Calendar.HOUR_OF_DAY) + "_" + calendar.get(Calendar.MINUTE) + "_" + calendar.get(Calendar.SECOND);
		 
		return uniqueStamp;
	}

	public static String toMeridian(String stime) {
		if(stime==null)
		{
			stime="10:00";
		}
		String array[] = stime.split(":");
		Integer hr = Integer.parseInt(array[0]);
		if (array.length > 1) {
			if (hr >= 13) {
				hr = hr - 12;
				stime = hr.toString() + ":" + array[1] + " " + "PM";
				if (hr == 12) {
					stime = hr.toString() + ":" + array[1] + " " + "AM";
				}
			} else if (hr >= 12 && hr < 13) {
				stime = hr.toString() + ":" + array[1] + " " + "PM";
			} else if (hr < 12) {
				stime = hr.toString() + ":" + array[1] + " " + "AM";
			}
		}
		 
	
	return stime;
	}

	public static String sayDayName(Date d) {
		DateFormat f = new SimpleDateFormat("EEEE");
		try {
			return f.format(d);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static DateTO getDealDay(Date startDate, String availableWeekDays, String startTIme) {
		Calendar dealAvailableDate = fetchAndGetDealDate(startDate, availableWeekDays, startTIme);
		DateTO dateTO = new DateTO();
		String date = dealAvailableDate.get(Calendar.MONTH) + 1 + "/"
				+ dealAvailableDate.get(Calendar.DATE) + "/" + dealAvailableDate.get(Calendar.YEAR);
		dateTO.setDealAvailableDate(date);
		dateTO.setDay(sayDayName(dealAvailableDate.getTime()));
		return dateTO;
	}


	public static DateTO getLastDealDay(Date expirityDate, String availableWeekDays) {
		Calendar dealAvailableDate = Calendar.getInstance();
		dealAvailableDate.setTime(expirityDate);
		int day=dealAvailableDate.get(Calendar.DAY_OF_WEEK);
		int curday=day;
		String[] days=availableWeekDays.split(",");
		for(int i=days.length-1;i>=0;i--) {
			if(day >= Integer.parseInt(days[i])) {
				curday=Integer.parseInt(days[i]);
				break;
			}
		}
		dealAvailableDate.add(Calendar.DATE, -(day-curday));
		DateTO dateTO = new DateTO();
		String date = dealAvailableDate.get(Calendar.MONTH) + 1 + "/"
				+ dealAvailableDate.get(Calendar.DATE) + "/" + dealAvailableDate.get(Calendar.YEAR);
		dateTO.setDealAvailableDate(date);
		dateTO.setDay(sayDayName(dealAvailableDate.getTime()));
		return dateTO;
	}

	private static Calendar fetchAndGetDealDate(Date startDate, String availableWeekDays,
			String endTime) {

		Calendar calendar = Calendar.getInstance();
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		if(endTime==null)
		{
			endTime="23:00";
		}
		if(endTime.equals("24:00"))
		{
			endTime="23:59";
		}
		String[] h_m = endTime.split(":");
		if (h_m != null) {
			start.set(Calendar.HOUR, Integer.valueOf(h_m[0]));
			start.set(Calendar.MINUTE, Integer.valueOf(h_m[1]));
		}
		/* This methods logic is based on deal end time */
		while (calendar.after(start)) {
			start.add(Calendar.DATE, 1);
		}
		/*
		 * if(start.get(Calendar.DAY_OF_MONTH)>calendar.get(Calendar.DAY_OF_MONTH))
		 * start.add(Calendar.DATE, -1);
		 */
		String day = getDayNumber(start.getTime());
		;
		while (!availableWeekDays.contains(day)) {
			start.add(Calendar.DATE, 1);
			day = getDayNumber(start.getTime());
		}
		return start;
	}

	public static String getDayNumber(Date date) {
		return date.getDay() + 1 + "";
	}
	
	public static String getTimeFromDate(Date date){
		
		Calendar c = Calendar.getInstance();
		String time = "10:10";
		if (date != null) {
			c.setTime(date);
			time = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
			time = time + ":" + String.valueOf(c.get(Calendar.MINUTE));
		}
		time = toMeridian(time);
		return time;
		
	}
	public static String convertUiToOffers(String uiDate) {
		DateFormat uiFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat uiFormat1 = new SimpleDateFormat("MMM dd");
	 
		String date="";
		try {
			date=uiFormat1.format(uiFormat.parse(uiDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	} 
}
