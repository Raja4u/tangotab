package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name=&quot;ARBUpdateSubscriptionResult&quot; type=&quot;{https://api.authorize.net/soap/v1/}ARBUpdateSubscriptionResponseType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "arbUpdateSubscriptionResult" })
@XmlRootElement(name = "ARBUpdateSubscriptionResponse")
public class ARBUpdateSubscriptionResponse {

	@XmlElement(name = "ARBUpdateSubscriptionResult")
	protected ARBUpdateSubscriptionResponseType arbUpdateSubscriptionResult;

	/**
	 * Gets the value of the arbUpdateSubscriptionResult property.
	 * 
	 * @return possible object is {@link ARBUpdateSubscriptionResponseType }
	 * 
	 */
	public ARBUpdateSubscriptionResponseType getARBUpdateSubscriptionResult() {
		return arbUpdateSubscriptionResult;
	}

	/**
	 * Sets the value of the arbUpdateSubscriptionResult property.
	 * 
	 * @param value
	 *            allowed object is {@link ARBUpdateSubscriptionResponseType }
	 * 
	 */
	public void setARBUpdateSubscriptionResult(ARBUpdateSubscriptionResponseType value) {
		this.arbUpdateSubscriptionResult = value;
	}

}
