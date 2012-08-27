package com.tangotab.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class TangoTabPasswordEncrypt {

	public static String getPasswordEncrypt(String password) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("www.tangotab.com");

		String myEncryptedText = textEncryptor.encrypt(password);

		return myEncryptedText;
	}

	public static String getPasswordDecrypt(String password) {

		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("www.tangotab.com");

		String plainText = textEncryptor.decrypt(password);
		//	
		return plainText;
	}

	public static void main(String s[]) {
System.out.println(getPasswordDecrypt("bzK+bEVU544v3b5as4uhXHKMXtQ8yg+R"));
	}
}
