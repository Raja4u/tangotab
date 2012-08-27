package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;merchantAuthentication&quot; type=&quot;{https://api.authorize.net/soap/v1/}MerchantAuthenticationType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;subscriptionId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "merchantAuthentication", "subscriptionId" })
@XmlRootElement(name = "ARBCancelSubscription")
public class ARBCancelSubscription {

	protected MerchantAuthenticationType merchantAuthentication;
	protected long subscriptionId;

	/**
	 * Gets the value of the merchantAuthentication property.
	 * 
	 * @return possible object is {@link MerchantAuthenticationType }
	 * 
	 */
	public MerchantAuthenticationType getMerchantAuthentication() {
		return merchantAuthentication;
	}

	/**
	 * Sets the value of the merchantAuthentication property.
	 * 
	 * @param value
	 *            allowed object is {@link MerchantAuthenticationType }
	 * 
	 */
	public void setMerchantAuthentication(MerchantAuthenticationType value) {
		this.merchantAuthentication = value;
	}

	/**
	 * Gets the value of the subscriptionId property.
	 * 
	 */
	public long getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * Sets the value of the subscriptionId property.
	 * 
	 */
	public void setSubscriptionId(long value) {
		this.subscriptionId = value;
	}

}
