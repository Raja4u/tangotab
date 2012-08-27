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
 *         &lt;element name=&quot;merchantAuthentication&quot; type=&quot;{https://api.authorize.net/soap/v1/}MerchantAuthenticationType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;customerProfileId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;customerPaymentProfileId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;customerShippingAddressId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;cardCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;validationMode&quot; type=&quot;{https://api.authorize.net/soap/v1/}ValidationModeEnum&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "merchantAuthentication", "customerProfileId",
		"customerPaymentProfileId", "customerShippingAddressId", "cardCode", "validationMode" })
@XmlRootElement(name = "ValidateCustomerPaymentProfile")
public class ValidateCustomerPaymentProfile {

	protected MerchantAuthenticationType merchantAuthentication;
	protected long customerProfileId;
	protected long customerPaymentProfileId;
	protected long customerShippingAddressId;
	protected String cardCode;
	@XmlElement(required = true)
	protected ValidationModeEnum validationMode;

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

	/**
	 * Gets the value of the customerShippingAddressId property.
	 * 
	 */
	public long getCustomerShippingAddressId() {
		return customerShippingAddressId;
	}

	/**
	 * Sets the value of the customerShippingAddressId property.
	 * 
	 */
	public void setCustomerShippingAddressId(long value) {
		this.customerShippingAddressId = value;
	}

	/**
	 * Gets the value of the cardCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCardCode() {
		return cardCode;
	}

	/**
	 * Sets the value of the cardCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCardCode(String value) {
		this.cardCode = value;
	}

	/**
	 * Gets the value of the validationMode property.
	 * 
	 * @return possible object is {@link ValidationModeEnum }
	 * 
	 */
	public ValidationModeEnum getValidationMode() {
		return validationMode;
	}

	/**
	 * Sets the value of the validationMode property.
	 * 
	 * @param value
	 *            allowed object is {@link ValidationModeEnum }
	 * 
	 */
	public void setValidationMode(ValidationModeEnum value) {
		this.validationMode = value;
	}

}
