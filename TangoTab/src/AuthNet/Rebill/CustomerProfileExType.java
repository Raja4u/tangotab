package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerProfileExType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CustomerProfileExType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}CustomerProfileBaseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;customerProfileId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerProfileExType", propOrder = { "customerProfileId" })
@XmlSeeAlso( { CustomerProfileMaskedType.class })
public class CustomerProfileExType extends CustomerProfileBaseType {

	protected long customerProfileId;

	/**
	 * Gets the value of the customerProfileId property.
	 * 
	 */
	public long getCustomerProfileId() {
		return customerProfileId;
	}

	/**
	 * Sets the value of the customerProfileId property.
	 * 
	 */
	public void setCustomerProfileId(long value) {
		this.customerProfileId = value;
	}

}
