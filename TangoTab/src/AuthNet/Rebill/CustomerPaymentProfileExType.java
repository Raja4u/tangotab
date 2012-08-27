package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerPaymentProfileExType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CustomerPaymentProfileExType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}CustomerPaymentProfileType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;customerPaymentProfileId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerPaymentProfileExType", propOrder = { "customerPaymentProfileId" })
public class CustomerPaymentProfileExType extends CustomerPaymentProfileType {

	protected long customerPaymentProfileId;

	/**
	 * Gets the value of the customerPaymentProfileId property.
	 * 
	 */
	public long getCustomerPaymentProfileId() {
		return customerPaymentProfileId;
	}

	/**
	 * Sets the value of the customerPaymentProfileId property.
	 * 
	 */
	public void setCustomerPaymentProfileId(long value) {
		this.customerPaymentProfileId = value;
	}

}
