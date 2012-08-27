package demo.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tangotab.util.TangoTabMailer;
import com.tangotab.util.TangoTabUtility;
import com.tangotab.util.TangotabConstants;

/**
 * Servlet implementation class MailServlet
 */
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get All the Parameters and Call the PostMail Method..
		String to = request.getParameter("to");
		String[] mailto = to.split(",");

		String from = request.getParameter("from");

		String msg = from + " came across this great site that " + from
				+ " wanted to share with you.";
		msg = msg
				+ " Tangotab offers great deals for all of the restaurants that we like to eat at."
				+ " They offer many great deals on a daily basis, not just one deal a day. The best " +
						"part is that we don't have to pay anything to Tangotab to take advantage of " +
						"these deals. "
				+ "<a style=\"color:#999999=\" href=\""
				+ TangoTabUtility.getTangoTabResourceBundle().getString(
						TangotabConstants.TANGO_TAB_WEB_SITE_HOME)
				+ TangotabConstants.TANGO_TAB_GUEST_PAGE + "\">Click here</a>"
				+ " to signup to receive great deals.";

		try {
			postMail(mailto, from
					+ " thought you might be interested in these great deals at Tangotab", msg,
					from);
			TangoTabMailer.sendEmail(to, null, from
					+ " thought you might be interested in these great deals at Tangotab", msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw = response.getWriter();
		pw.println("Message Has Been Shared Successfully.");
	}

	public void postMail(String recipients[], String subject, String message, String from)
			throws MessagingException {
		boolean debug = false;

		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", ResourceBundle.getBundle("mail").getString("mail.host"));
		props.put("mail.smtp.port", ResourceBundle.getBundle("mail").getString("mail.port"));
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.user", ResourceBundle.getBundle("mail")
				.getString("mail.auth.username"));
		props.put("mail.smtp.password", ResourceBundle.getBundle("mail").getString(
				"mail.auth.password"));
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", ResourceBundle.getBundle("mail").getString(
				"mail.port"));
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		// props.put("mail.transport.protocol","smtps");
		Authenticator auth = new TangoTabAuthenticator(ResourceBundle.getBundle("mail").getString(
				"mail.auth.username"), ResourceBundle.getBundle("mail").getString(
				"mail.auth.password"));
		// create some properties and get the default Session
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];

		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);

		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Optional : You can also set your custom headers in the Email if you
		// Want
		// msg.addHeader("MyHeaderName", "myHeaderValue");

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/html");

		// Transport.send(msg);

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
}
