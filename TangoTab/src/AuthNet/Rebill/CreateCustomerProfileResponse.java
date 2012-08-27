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
 *         &lt;element name=&quot;CreateCustomerProfileResult&quot; type=&quot;{https://api.authorize.net/soap/v1/}CreateCustomerProfileResponseType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "createCustomerProfileResult" })
@XmlRootElement(name = "CreateCustomerProfileResponse")
public class CreateCustomerProfileResponse {

	@XmlElement(name = "CreateCustomerProfileResult")
	protected CreateCustomerProfileResponseType createCustomerProfileResult;

	/**
	 * Gets the value of the createCustomerProfileResult property.
	 * 
	 * @return possible object is {@link CreateCustomerProfileResponseType }
	 * 
	 */
	public CreateCustomerProfileResponseType getCreateCustomerProfileResult() {
		return createCustomerProfileResult;
	}

	/**
	 * Sets the value of the createCustomerProfileResult property.
	 * 
	 * @param value
	 *            allowed object is {@link CreateCustomerProfileResponseType }
	 * 
	 */
	public void setCreateCustomerProfileResult(CreateCustomerProfileResponseType value) {
		this.createCustomerProfileResult = value;
	}

}
