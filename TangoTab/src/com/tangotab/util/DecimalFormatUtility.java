package com.tangotab.util;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DecimalFormatUtility {

	public static double getDecimalFormat(double number)
	{
	 NumberFormat formatter = new DecimalFormat("#0.00");
	 return Double.parseDouble(formatter.format(number));
	}
}
