/****** BEGIN LICENSE BLOCK *****

Codekko Software, Inc. Legal Notice 

Copyright Notice 

Copyright © 2009, Codekko Software, Inc. and/or its affiliates. All rights reserved. 

License Restrictions 

This software and related documentation are provided under a commercial license agreement 
from Codekko Software, Inc. containing restrictions on use and disclosure and are protected 
by patent, copyright and intellectual property laws. Except as expressly permitted in your 
license agreement or allowed by law, you may not use, copy, reproduce, translate, broadcast, 
modify, license, transmit, distribute, exhibit, perform, publish, or display any part, in 
any form, or by any means. Reverse engineering, disassembly, or decompilation of this software, 
unless required by law for interoperability, is prohibited. 

This software is developed for general use in a variety of information management applications. 
It is not developed or intended for use in any inherently dangerous applications, including 
applications which may create a risk of personal injury. If you use this software in dangerous 
applications, then you shall be responsible to take all appropriate fail-safe, backup, redundancy, 
and other measures to ensure the safe use of this software. Codekko Software, Inc. and its 
affiliates disclaim any liability for any damages caused by use of this software. 

Warranty Disclaimer 

The information contained herein is subject to change without notice and is not warranted to be 
error-free. If you find any errors, please report them to Codekko Software, Inc. in writing at 
Codekko Software, Inc., 1820, Preston Park Blvd, Suite 1900, Plano, Texas 75093 

 ****** END LICENSE BLOCK ***** */
package com.tangotab.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TangoTab Mailer component
 * 
 * @author techgene
 * @dated 20-Jan-2011
 * @version 1.0
 * 
 */
public final class TangoTabMailer {
	private static final Logger log = LoggerFactory.getLogger(TangoTabUtility.class);

	/**
	 * Default restricted constructor
	 */
	private TangoTabMailer() {
		// Restricting the default instantiation of this class
	}

	/**
	 * Authenticator customization
	 * 
	 * @author techgene
	 * @dated 20-Jan-2011
	 * @version 1.0
	 */
	private static class TangoTabAuthenticator extends Authenticator {
		private String emailId;
		private String password;

		private TangoTabAuthenticator() {
			// Restricting default instantiation
		}

		private TangoTabAuthenticator(String emailId, String password) {
			this.emailId = emailId;
			this.password = password;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(emailId, password);
		}
	}

	/**
	 * Sends the email with the provided details
	 * 
	 * @param to
	 * @param cc
	 * @param subject
	 * @param mailBody
	 * @return true, if email is sent successfully, otherwise false.
	 */
	public static boolean sendEmail(String to, String cc, String subject, String mailBody) {
		if (log.isDebugEnabled()) {
			log.debug("Send Email is initiated with To: " + to + ", CC: " + cc + ", Subject: "
					+ subject + ", mailBody: " + mailBody);
		}
		String mail="";
        if(to!=null)
        	mail+=to+",";
        if(StringUtils.isNotEmpty(cc))
        	mail+=cc+",";
        String[] mails={};
        if(mail!=null)
        	mails=mail.split(",");
        
		if (TangoTabUtility.getTangoTabResourceBundle() != null) {
			if (log.isDebugEnabled()) {
				log.debug("Found Email configuration details and continuing to send email.");
			}
			Properties config = new Properties();
			config.put("mail.smtp.host", TangoTabUtility.getTangoTabResourceBundle().getString(
					TangotabConstants.MAIL_HOST));
			config.put("mail.smtp.port", TangoTabUtility.getTangoTabResourceBundle().getString(
					TangotabConstants.MAIL_PORT));
			config.put("mail.smtp.starttls.enable", "true");
			config.put("mail.smtp.debug", Boolean.parseBoolean(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_IS_DEBUG)));
			config.put("mail.smtp.auth", Boolean.parseBoolean(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_IS_AUTH)));
			config.put("mail.smtp.socketFactory.port", TangoTabUtility.getTangoTabResourceBundle()
					.getString(TangotabConstants.MAIL_PORT));
			config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			config.put("mail.smtp.socketFactory.fallback", "false");

			TangoTabAuthenticator auth = new TangoTabAuthenticator(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_AUTH_USERNAME),
					TangoTabUtility.getTangoTabResourceBundle().getString(
							TangotabConstants.MAIL_AUTH_PASSWORD));

			Session session = Session.getInstance(config, auth);
			//session.setDebug(true);

			MimeMessage message;
			try {
				if(mails.length > 0){                   /* to, cc */
					for(int i = 0; i< mails.length; i++){
						try{
						
						if(mails[i] != null && mails[i].length() > 0  && mails[i].contains("@")){
							message = new MimeMessage(session);
							message.addRecipient(Message.RecipientType.TO, new InternetAddress(mails[i]));
							message.setSentDate(new Date());
							message.setFrom(new InternetAddress(TangoTabUtility.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_FROM),"TangoTab"));
							message.setSubject(subject);
							//Address[] address=new InternetAddress[1];
							//address[0]=new InternetAddress("srividya.j@techgene.com");
							//message.setReplyTo(address);
							message.setContent(mailBody, "text/html");
							Transport.send(message);
						}
						}catch (MessagingException ex) {
							ex.printStackTrace();
							if (log.isErrorEnabled()) {
								log.error("COULD NOT SEND EMAIL. Reason: " + ex.getMessage());
							}
							
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch(Exception e){
							// to continue the normal flow of mailing
						}
					}
					return true;
				}	
				if (log.isDebugEnabled()) {
					log.debug("Email sent successfully with above details.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return true;
		}
		if (log.isDebugEnabled()) {
			log.debug("COULD NOT SEND EMAIL, as the "
					+ TangotabConstants.TANGO_TAB_RESOURCE_BUNDLE_NAME
					+ " file has some email configuration issues.");
		}
		return false;
	}
	public static boolean sendEmail(String to, String cc, String bcc, String subject, String mailBody) {
		if (log.isDebugEnabled()) {
			log.debug("Send Email is initiated with To: " + to + ", CC: " + cc + ", Subject: "
					+ subject + ", mailBody: " + mailBody);
		}
        String mail="";
        if(to!=null)
        	mail+=to+",";
        if(StringUtils.isNotEmpty(cc))
        	mail+=cc+",";
        if(StringUtils.isNotEmpty(bcc))
        	mail+=bcc;
        String[] mails={};
        if(mail!=null)
        	mails=mail.split(",");
        
		if (TangoTabUtility.getTangoTabResourceBundle() != null) {
			if (log.isDebugEnabled()) {
				log.debug("Found Email configuration details and continuing to send email.");
			}
			Properties config = new Properties();
			config.put("mail.smtp.host", TangoTabUtility.getTangoTabResourceBundle().getString(
					TangotabConstants.MAIL_HOST));
			config.put("mail.smtp.port", TangoTabUtility.getTangoTabResourceBundle().getString(
					TangotabConstants.MAIL_PORT));
			config.put("mail.smtp.starttls.enable", "true");
			config.put("mail.smtp.debug", Boolean.parseBoolean(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_IS_DEBUG)));
			config.put("mail.smtp.auth", Boolean.parseBoolean(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_IS_AUTH)));
			config.put("mail.smtp.socketFactory.port", TangoTabUtility.getTangoTabResourceBundle()
					.getString(TangotabConstants.MAIL_PORT));
			config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			config.put("mail.smtp.socketFactory.fallback", "false");

			TangoTabAuthenticator auth = new TangoTabAuthenticator(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_AUTH_USERNAME),
					TangoTabUtility.getTangoTabResourceBundle().getString(
							TangotabConstants.MAIL_AUTH_PASSWORD));

			Session session = Session.getInstance(config, auth);
		 
			//session.setDebug(true);
			MimeMessage message;
			try {
				 if(mails.length > 0){
					for(int i = 0; i< mails.length; i++){
						try{
						if(mails[i] != null && mails[i].length() > 0  && mails[i].contains("@")){
							message = new MimeMessage(session);
							message.addRecipient(Message.RecipientType.TO, new InternetAddress(mails[i]));
							message.setSentDate(new Date());
							message.setFrom(new InternetAddress(TangoTabUtility.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_FROM),"TangoTab"));
							message.setSubject(subject);
							message.setContent(mailBody, "text/html");
							Transport.send(message);
						}
						}catch (MessagingException ex) {
							ex.printStackTrace();
							if (log.isErrorEnabled()) {
								log.error("COULD NOT SEND EMAIL. Reason: " + ex.getMessage());
							}
							
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch(Exception e){
							// to continue the normal flow of mailing
						}
					}
					return true;
				}			
				if (log.isDebugEnabled()) {
					log.debug("Email sent successfully with above details.");
				}
			} catch (Exception ex) {
				if (log.isErrorEnabled()) {
					log.error("COULD NOT SEND EMAIL. Reason: " + ex.getMessage());
				}
				return false;
			} 
			return true;
		}
		if (log.isDebugEnabled()) {
			log.debug("COULD NOT SEND EMAIL, as the "
					+ TangotabConstants.TANGO_TAB_RESOURCE_BUNDLE_NAME
					+ " file has some email configuration issues.");
		}
		return false;
	}
	
	public static boolean sendEmail(String to, String from, String cc, String bcc, String subject, String mailBody) {
		if (log.isDebugEnabled()) {
			log.debug("Send Email is initiated with To: " + to + ", CC: " + cc + ", Subject: "
					+ subject + ", mailBody: " + mailBody);
		}
		String error = null ;
		String mail="";
        if(to!=null)
        	mail+=to+",";
        if(StringUtils.isNotEmpty(cc))
        	mail+=cc+",";
        if(StringUtils.isNotEmpty(bcc))
        	mail+=bcc;
        String[] mails={};
        if(mail!=null)
        	mails=mail.split(",");
        
		if (TangoTabUtility.getTangoTabResourceBundle() != null) {
			if (log.isDebugEnabled()) {
				log.debug("Found Email configuration details and continuing to send email.");
			}
			Properties config = new Properties();
			config.put("mail.smtp.host", TangoTabUtility.getTangoTabResourceBundle().getString(
					TangotabConstants.MAIL_HOST));
			config.put("mail.smtp.port", TangoTabUtility.getTangoTabResourceBundle().getString(
					TangotabConstants.MAIL_PORT));
			config.put("mail.smtp.starttls.enable", "true");
			config.put("mail.smtp.debug", Boolean.parseBoolean(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_IS_DEBUG)));
			config.put("mail.smtp.auth", Boolean.parseBoolean(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_IS_AUTH)));
			config.put("mail.smtp.socketFactory.port", TangoTabUtility.getTangoTabResourceBundle()
					.getString(TangotabConstants.MAIL_PORT));
			config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			config.put("mail.smtp.socketFactory.fallback", "false");

			TangoTabAuthenticator auth = new TangoTabAuthenticator(TangoTabUtility
					.getTangoTabResourceBundle().getString(TangotabConstants.MAIL_AUTH_USERNAME),
					TangoTabUtility.getTangoTabResourceBundle().getString(
							TangotabConstants.MAIL_AUTH_PASSWORD));

			Session session = Session.getInstance(config, auth);
		 
			//session.setDebug(true);
			MimeMessage message;
			try {
			 if(mails.length > 0){
				for(int i = 0; i< mails.length; i++){
					try{
					if(mails[i] != null && mails[i].length() > 0  && mails[i].contains("@")){
						message = new MimeMessage(session);
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(mails[i]));
						message.setSentDate(new Date());
						if(StringUtils.isNotEmpty(from))
							message.setFrom(new InternetAddress(TangotabConstants.TANGO_TAB_SHARE_EMAIL_ID,from));
						else
						    message.setFrom(new InternetAddress(TangotabConstants.TANGO_TAB_SHARE_EMAIL_ID,"TangoTab"));
						message.setSubject(subject);
						message.setContent(mailBody, "text/html");
						Transport.send(message);
					}
					} catch (MessagingException ex) {
						if (log.isErrorEnabled()) {
							log.error("COULD NOT SEND EMAIL. Reason: " + ex.getMessage());
						}
						error = ex.getMessage();
						//return false;
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						error = e.getMessage();
						e.printStackTrace();
					}catch(Exception e){
						error = e.getMessage();
						e.printStackTrace();
					}
				}
				return true;
			}
			}catch(Exception e){
				error = e.getMessage();
				e.printStackTrace();
			}
			if(error == null)
				return true;
				 				
			else
				return false;
		}
		if (log.isDebugEnabled()) {
			log.debug("COULD NOT SEND EMAIL, as the "
					+ TangotabConstants.TANGO_TAB_RESOURCE_BUNDLE_NAME
					+ " file has some email configuration issues.");
		}
		return false;
	}

	public static void main(String... aArguments) {
		TangoTabMailer.sendEmail("rathnakar.p@techgene.com","srividya.j@techgene.com",null,null,
				"TangoTab CreditCard Processing Failure",TangotabConstants.FORWARD_FRIEND_CONTENT);
		 
		 
	}
}
