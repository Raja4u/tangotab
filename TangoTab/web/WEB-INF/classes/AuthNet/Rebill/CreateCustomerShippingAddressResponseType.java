package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateCustomerShippingAddressResponseType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CreateCustomerShippingAddressResponseType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}ANetApiResponseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;customerAddressId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCustomerShippingAddressResponseType", propOrder = { "customerAddressId" })
public class CreateCustomerShippingAddressResponseType extends ANetApiResponseType {

	protected long customerAddressId;

	/**
	 * Gets the value of the customerAddressId property.
	 * 
	 */
	public long getCustomerAddressId() {
		return customerAddressId;
	}

	/**
	 * Sets the value of the customerAddressId property.
	 * 
	 */
	public void setCustomerAddressId(long value) {
		this.customerAddressId = value;
	}

}
