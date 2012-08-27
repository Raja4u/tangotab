package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerProfileType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CustomerProfileType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}CustomerProfileBaseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;paymentProfiles&quot; type=&quot;{https://api.authorize.net/soap/v1/}ArrayOfCustomerPaymentProfileType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;shipToList&quot; type=&quot;{https://api.authorize.net/soap/v1/}ArrayOfCustomerAddressType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerProfileType", propOrder = { "paymentProfiles", "shipToList" })
public class CustomerProfileType extends CustomerProfileBaseType {

	protected ArrayOfCustomerPaymentProfileType paymentProfiles;
	protected ArrayOfCustomerAddressType shipToList;

	/**
	 * Gets the value of the paymentProfiles property.
	 * 
	 * @return possible object is {@link ArrayOfCustomerPaymentProfileType }
	 * 
	 */
	public ArrayOfCustomerPaymentProfileType getPaymentProfiles() {
		return paymentProfiles;
	}

	/**
	 * Sets the value of the paymentProfiles property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfCustomerPaymentProfileType }
	 * 
	 */
	public void setPaymentProfiles(ArrayOfCustomerPaymentProfileType value) {
		this.paymentProfiles = value;
	}

	/**
	 * Gets the value of the shipToList property.
	 * 
	 * @return possible object is {@link ArrayOfCustomerAddressType }
	 * 
	 */
	public ArrayOfCustomerAddressType getShipToList() {
		return shipToList;
	}

	/**
	 * Sets the value of the shipToList property.
	 * 
	 * @param value
	 *            allowed object is {@link ArrayOfCustomerAddressType }
	 * 
	 */
	public void setShipToList(ArrayOfCustomerAddressType value) {
		this.shipToList = value;
	}

}
