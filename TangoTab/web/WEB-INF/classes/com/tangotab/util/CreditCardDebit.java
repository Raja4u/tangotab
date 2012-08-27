package com.tangotab.util;

import java.math.BigDecimal;

import net.authorize.Environment;
import net.authorize.Merchant;
import net.authorize.TransactionType;
import net.authorize.aim.Result;
import net.authorize.aim.Transaction;
import net.authorize.data.Customer;
import net.authorize.data.EmailReceipt;

public class CreditCardDebit {

	public static Result<Transaction> advancepaymentMethod(String email, String firstname,
			String lastname, String cardnumber, String cardtype, String nameoncard, String verfnum,
			String exp_year, String exp_month, String exp_date, String amount, String start_date,
			String city, String state, String streetnum, String streetname, String zip,
			String country) {
		// amount="1";

		String apiLoginID = "537MsxG7Pt7";
		String transactionKey = "9sVPPr2eW9F96e89";
		Merchant merchant = Merchant.createMerchant(Environment.PRODUCTION, apiLoginID,
				transactionKey);

		/*
		 * String apiLoginID = "6Mqv4P6B"; String transactionKey = "7VH5Ss6sm84y5h7f"; Merchant
		 * merchant = Merchant .createMerchant(Environment.SANDBOX, apiLoginID, transactionKey);
		 */

		// CHANGE ENVIRONMENT.SANDBOX TO ENVIRONMENT.PRODUCTION
		net.authorize.data.creditcard.CreditCard creditCard = net.authorize.data.creditcard.CreditCard
				.createCreditCard();
		creditCard.setCreditCardNumber(cardnumber);
		creditCard.setExpirationMonth(exp_month);
		creditCard.setExpirationYear(exp_year);
		Transaction authCaptureTransaction = merchant.createAIMTransaction(
				TransactionType.AUTH_CAPTURE, new BigDecimal(amount));
		authCaptureTransaction.setCreditCard(creditCard);
		Customer c = Customer.createCustomer();
		c.setCity(city);
		c.setAddress(streetname + streetnum);
		c.setCountry(country);
		c.setFirstName(firstname);
		c.setLastName(lastname);
		c.setEmail(email);
		// c.setCustomerId("1");
		// c.setPhone("919908817076");
		c.setState(state);
		c.setZipPostalCode(zip);

		authCaptureTransaction.setCustomer(c);
		EmailReceipt e = EmailReceipt.createEmailReceipt();
		e.setEmail(email);
		authCaptureTransaction.setEmailReceipt(e);
		authCaptureTransaction.setAuthorizationCode("BCC_TEST");
		Result<Transaction> result = (net.authorize.aim.Result) merchant
				.postTransaction(authCaptureTransaction);
		return result;

	}

}
