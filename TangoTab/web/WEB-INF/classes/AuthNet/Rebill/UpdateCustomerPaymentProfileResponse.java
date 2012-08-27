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
 *         &lt;element name=&quot;UpdateCustomerPaymentProfileResult&quot; type=&quot;{https://api.authorize.net/soap/v1/}UpdateCustomerPaymentProfileResponseType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "updateCustomerPaymentProfileResult" })
@XmlRootElement(name = "UpdateCustomerPaymentProfileResponse")
public class UpdateCustomerPaymentProfileResponse {

	@XmlElement(name = "UpdateCustomerPaymentProfileResult")
	protected UpdateCustomerPaymentProfileResponseType updateCustomerPaymentProfileResult;

	/**
	 * Gets the value of the updateCustomerPaymentProfileResult property.
	 * 
	 * @return possible object is {@link UpdateCustomerPaymentProfileResponseType }
	 * 
	 */
	public UpdateCustomerPaymentProfileResponseType getUpdateCustomerPaymentProfileResult() {
		return updateCustomerPaymentProfileResult;
	}

	/**
	 * Sets the value of the updateCustomerPaymentProfileResult property.
	 * 
	 * @param value
	 *            allowed object is {@link UpdateCustomerPaymentProfileResponseType }
	 * 
	 */
	public void setUpdateCustomerPaymentProfileResult(UpdateCustomerPaymentProfileResponseType value) {
		this.updateCustomerPaymentProfileResult = value;
	}

}
