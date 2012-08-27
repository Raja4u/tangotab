package com.tangotab.util;
import java.security.MessageDigest;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GenerateHashData {
	
	/**
	 * @param args
	 */
	public  static String getHashValue(String var) throws Exception
	{
		
  	    MessageDigest md = MessageDigest.getInstance("SHA-256");
  	    StringBuffer sb = new StringBuffer();
  	    if(var != null){
        md.update(var.getBytes());
        byte byteData[] = md.digest();
        
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
  	    }
          
        return sb.toString();
	}

}
