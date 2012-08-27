package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GetCustomerProfileResponseType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;GetCustomerProfileResponseType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}ANetApiResponseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;profile&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerProfileMaskedType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCustomerProfileResponseType", propOrder = { "profile" })
public class GetCustomerProfileResponseType extends ANetApiResponseType {

	protected CustomerProfileMaskedType profile;

	/**
	 * Gets the value of the profile property.
	 * 
	 * @return possible object is {@link CustomerProfileMaskedType }
	 * 
	 */
	public CustomerProfileMaskedType getProfile() {
		return profile;
	}

	/**
	 * Sets the value of the profile property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerProfileMaskedType }
	 * 
	 */
	public void setProfile(CustomerProfileMaskedType value) {
		this.profile = value;
	}

}
