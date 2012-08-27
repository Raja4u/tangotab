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
 *         &lt;element name=&quot;profile&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerProfileType&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "", propOrder = { "merchantAuthentication", "profile", "validationMode" })
@XmlRootElement(name = "CreateCustomerProfile")
public class CreateCustomerProfile {

	protected MerchantAuthenticationType merchantAuthentication;
	protected CustomerProfileType profile;
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
	 * Gets the value of the profile property.
	 * 
	 * @return possible object is {@link CustomerProfileType }
	 * 
	 */
	public CustomerProfileType getProfile() {
		return profile;
	}

	/**
	 * Sets the value of the profile property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerProfileType }
	 * 
	 */
	public void setProfile(CustomerProfileType value) {
		this.profile = value;
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
