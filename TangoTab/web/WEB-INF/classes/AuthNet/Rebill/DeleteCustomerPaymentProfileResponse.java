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
 *         &lt;element name=&quot;DeleteCustomerPaymentProfileResult&quot; type=&quot;{https://api.authorize.net/soap/v1/}DeleteCustomerPaymentProfileResponseType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "deleteCustomerPaymentProfileResult" })
@XmlRootElement(name = "DeleteCustomerPaymentProfileResponse")
public class DeleteCustomerPaymentProfileResponse {

	@XmlElement(name = "DeleteCustomerPaymentProfileResult")
	protected DeleteCustomerPaymentProfileResponseType deleteCustomerPaymentProfileResult;

	/**
	 * Gets the value of the deleteCustomerPaymentProfileResult property.
	 * 
	 * @return possible object is {@link DeleteCustomerPaymentProfileResponseType }
	 * 
	 */
	public DeleteCustomerPaymentProfileResponseType getDeleteCustomerPaymentProfileResult() {
		return deleteCustomerPaymentProfileResult;
	}

	/**
	 * Sets the value of the deleteCustomerPaymentProfileResult property.
	 * 
	 * @param value
	 *            allowed object is {@link DeleteCustomerPaymentProfileResponseType }
	 * 
	 */
	public void setDeleteCustomerPaymentProfileResult(DeleteCustomerPaymentProfileResponseType value) {
		this.deleteCustomerPaymentProfileResult = value;
	}

}
