package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ProfileTransactionType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ProfileTransactionType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name=&quot;profileTransAuthOnly&quot; type=&quot;{https://api.authorize.net/soap/v1/}ProfileTransAuthOnlyType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;profileTransAuthCapture&quot; type=&quot;{https://api.authorize.net/soap/v1/}ProfileTransAuthCaptureType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;profileTransRefund&quot; type=&quot;{https://api.authorize.net/soap/v1/}ProfileTransRefundType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;profileTransCaptureOnly&quot; type=&quot;{https://api.authorize.net/soap/v1/}ProfileTransCaptureOnlyType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;profileTransPriorAuthCapture&quot; type=&quot;{https://api.authorize.net/soap/v1/}ProfileTransPriorAuthCaptureType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;profileTransVoid&quot; type=&quot;{https://api.authorize.net/soap/v1/}ProfileTransVoidType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileTransactionType", propOrder = { "profileTransAuthOnly",
		"profileTransAuthCapture", "profileTransRefund", "profileTransCaptureOnly",
		"profileTransPriorAuthCapture", "profileTransVoid" })
public class ProfileTransactionType {

	protected ProfileTransAuthOnlyType profileTransAuthOnly;
	protected ProfileTransAuthCaptureType profileTransAuthCapture;
	protected ProfileTransRefundType profileTransRefund;
	protected ProfileTransCaptureOnlyType profileTransCaptureOnly;
	protected ProfileTransPriorAuthCaptureType profileTransPriorAuthCapture;
	protected ProfileTransVoidType profileTransVoid;

	/**
	 * Gets the value of the profileTransAuthOnly property.
	 * 
	 * @return possible object is {@link ProfileTransAuthOnlyType }
	 * 
	 */
	public ProfileTransAuthOnlyType getProfileTransAuthOnly() {
		return profileTransAuthOnly;
	}

	/**
	 * Sets the value of the profileTransAuthOnly property.
	 * 
	 * @param value
	 *            allowed object is {@link ProfileTransAuthOnlyType }
	 * 
	 */
	public void setProfileTransAuthOnly(ProfileTransAuthOnlyType value) {
		this.profileTransAuthOnly = value;
	}

	/**
	 * Gets the value of the profileTransAuthCapture property.
	 * 
	 * @return possible object is {@link ProfileTransAuthCaptureType }
	 * 
	 */
	public ProfileTransAuthCaptureType getProfileTransAuthCapture() {
		return profileTransAuthCapture;
	}

	/**
	 * Sets the value of the profileTransAuthCapture property.
	 * 
	 * @param value
	 *            allowed object is {@link ProfileTransAuthCaptureType }
	 * 
	 */
	public void setProfileTransAuthCapture(ProfileTransAuthCaptureType value) {
		this.profileTransAuthCapture = value;
	}

	/**
	 * Gets the value of the profileTransRefund property.
	 * 
	 * @return possible object is {@link ProfileTransRefundType }
	 * 
	 */
	public ProfileTransRefundType getProfileTransRefund() {
		return profileTransRefund;
	}

	/**
	 * Sets the value of the profileTransRefund property.
	 * 
	 * @param value
	 *            allowed object is {@link ProfileTransRefundType }
	 * 
	 */
	public void setProfileTransRefund(ProfileTransRefundType value) {
		this.profileTransRefund = value;
	}

	/**
	 * Gets the value of the profileTransCaptureOnly property.
	 * 
	 * @return possible object is {@link ProfileTransCaptureOnlyType }
	 * 
	 */
	public ProfileTransCaptureOnlyType getProfileTransCaptureOnly() {
		return profileTransCaptureOnly;
	}

	/**
	 * Sets the value of the profileTransCaptureOnly property.
	 * 
	 * @param value
	 *            allowed object is {@link ProfileTransCaptureOnlyType }
	 * 
	 */
	public void setProfileTransCaptureOnly(ProfileTransCaptureOnlyType value) {
		this.profileTransCaptureOnly = value;
	}

	/**
	 * Gets the value of the profileTransPriorAuthCapture property.
	 * 
	 * @return possible object is {@link ProfileTransPriorAuthCaptureType }
	 * 
	 */
	public ProfileTransPriorAuthCaptureType getProfileTransPriorAuthCapture() {
		return profileTransPriorAuthCapture;
	}

	/**
	 * Sets the value of the profileTransPriorAuthCapture property.
	 * 
	 * @param value
	 *            allowed object is {@link ProfileTransPriorAuthCaptureType }
	 * 
	 */
	public void setProfileTransPriorAuthCapture(ProfileTransPriorAuthCaptureType value) {
		this.profileTransPriorAuthCapture = value;
	}

	/**
	 * Gets the value of the profileTransVoid property.
	 * 
	 * @return possible object is {@link ProfileTransVoidType }
	 * 
	 */
	public ProfileTransVoidType getProfileTransVoid() {
		return profileTransVoid;
	}

	/**
	 * Sets the value of the profileTransVoid property.
	 * 
	 * @param value
	 *            allowed object is {@link ProfileTransVoidType }
	 * 
	 */
	public void setProfileTransVoid(ProfileTransVoidType value) {
		this.profileTransVoid = value;
	}

}
