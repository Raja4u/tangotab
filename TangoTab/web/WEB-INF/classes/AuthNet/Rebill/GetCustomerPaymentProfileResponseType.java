package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GetCustomerPaymentProfileResponseType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;GetCustomerPaymentProfileResponseType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}ANetApiResponseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;paymentProfile&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerPaymentProfileMaskedType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerPaymentProfileResponseType", propOrder = { "paymentProfile" })
public class GetCustomerPaymentProfileResponseType extends ANetApiResponseType {

	protected CustomerPaymentProfileMaskedType paymentProfile;

	/**
	 * Gets the value of the paymentProfile property.
	 * 
	 * @return possible object is {@link CustomerPaymentProfileMaskedType }
	 * 
	 */
	public CustomerPaymentProfileMaskedType getPaymentProfile() {
		return paymentProfile;
	}

	/**
	 * Sets the value of the paymentProfile property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerPaymentProfileMaskedType }
	 * 
	 */
	public void setPaymentProfile(CustomerPaymentProfileMaskedType value) {
		this.paymentProfile = value;
	}

}
