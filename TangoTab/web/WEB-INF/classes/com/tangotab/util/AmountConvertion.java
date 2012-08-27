package com.tangotab.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AmountConvertion {

	public static String convertUSAmount(String amount) {
		NumberFormat nf = new DecimalFormat("#0.00");
		String usamount = "Not CorrectFormat";
		try {
			usamount = nf.format(Double.parseDouble(amount));
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return usamount;
	}

}
