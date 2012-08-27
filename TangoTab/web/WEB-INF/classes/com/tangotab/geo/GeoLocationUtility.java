package com.tangotab.geo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GeoLocationUtility {

	/**
	 * Gets the City Based on the IPAddress.
	 * 
	 * @param ipAddress
	 * @return City Name
	 */
	public static String getCity(String ipAddress) {
		
		String apiKey = ResourceBundle.getBundle("tangotab").getString("geolocation.api.key");
		String url = "http://api.ipinfodb.com/v3/ip-city/?key=" + apiKey + "&ip=" + ipAddress
				+ "&format=json";
		InputStream inStream = null;
		String city = "";
		try {
			URL getURL = new URL(url);
		      getURL.openConnection().setConnectTimeout(15000);

			inStream = getURL.openConnection().getInputStream();
			byte[] b = new byte[inStream.available()];
			inStream.read(b);
			String jsonContent = new String(b);
			jsonContent = jsonContent.replace("{", "").replace("}", "").replace("\n", "").replace(
					"\t", "").replace("\"", "");

			String[] allProperties = jsonContent.split(",");
			for (String string : allProperties) {
				String keyValue[] = string.split(":");
				if(keyValue.length>=2)
				{
					if ("zipCode".equals(keyValue[0].trim())) {
						city = keyValue[1].trim();
					}
				}
			}
		} 
		catch (Exception e) {
 			city=getCityUsingTempAPI(ipAddress);
 		 	e.printStackTrace();
		} finally {
			try {
				if(inStream!=null)
				inStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return city;
	}

	public static String getCityUsingTempAPI(String ipAddress) {

		InputStream inStream2 = null;
		String city = "";
		try {
			String newApiURL = "http://api.geoio.com/q.php?key=PBeKC3UDmxTjHXeU&qt=geoip&d=pipe&q="
					+ ipAddress;
			URL getURL2 = new URL(newApiURL);
		      getURL2.openConnection().setConnectTimeout(15000);

			inStream2 = getURL2.openConnection().getInputStream();
			byte[] b2 = new byte[inStream2.available()];
			inStream2.read(b2);

			String jsonContent2 = new String(b2);
	 
		if(jsonContent2.indexOf("|")!=-1)
			city = jsonContent2.substring(0, jsonContent2.indexOf("|"));
	 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStream2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// http://api.geoio.com/q.php?key=PBeKC3UDmxTjHXeU&qt=geoip&d=pipe&q=184.215.72.20
		return city;
	}

}
