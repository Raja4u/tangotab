package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerPaymentProfileBaseType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CustomerPaymentProfileBaseType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;customerType&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerTypeEnum&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;billTo&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerAddressType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerPaymentProfileBaseType", propOrder = { "customerType", "billTo" })
@XmlSeeAlso( { CustomerPaymentProfileType.class, CustomerPaymentProfileMaskedType.class })
public class CustomerPaymentProfileBaseType {

	protected CustomerTypeEnum customerType;
	protected CustomerAddressType billTo;

	/**
	 * Gets the value of the customerType property.
	 * 
	 * @return possible object is {@link CustomerTypeEnum }
	 * 
	 */
	public CustomerTypeEnum getCustomerType() {
		return customerType;
	}

	/**
	 * Sets the value of the customerType property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerTypeEnum }
	 * 
	 */
	public void setCustomerType(CustomerTypeEnum value) {
		this.customerType = value;
	}

	/**
	 * Gets the value of the billTo property.
	 * 
	 * @return possible object is {@link CustomerAddressType }
	 * 
	 */
	public CustomerAddressType getBillTo() {
		return billTo;
	}

	/**
	 * Sets the value of the billTo property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerAddressType }
	 * 
	 */
	public void setBillTo(CustomerAddressType value) {
		this.billTo = value;
	}

}
