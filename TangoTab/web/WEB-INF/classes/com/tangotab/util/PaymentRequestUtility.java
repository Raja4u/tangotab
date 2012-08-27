package com.tangotab.util;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class PaymentRequestUtility {

	public String getFingerPrint(String loginID, int sequence, long timeStamp, String amount) {
		String fingerPrint = "";
		try {
			String transactionKey = "9f73aUjJ78XzK4KJ";
			KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
			SecretKey key = new SecretKeySpec(transactionKey.getBytes(), "HmacMD5");
			Mac mac = Mac.getInstance("HmacMD5");
			mac.init(key);
			String inputstring = loginID + "^" + sequence + "^" + timeStamp + "^" + amount + "^";
			byte[] result = mac.doFinal(inputstring.getBytes());
			StringBuffer strbuf = new StringBuffer(result.length * 2);
			for (int i = 0; i < result.length; i++) {
				if (((int) result[i] & 0xff) < 0x10)
					strbuf.append("0");
				strbuf.append(Long.toString((int) result[i] & 0xff, 16));
			}
			fingerPrint = strbuf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fingerPrint;
	}

}
