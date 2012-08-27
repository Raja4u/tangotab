package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ProfileTransCaptureOnlyType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ProfileTransCaptureOnlyType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}ProfileTransOrderType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;approvalCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileTransCaptureOnlyType", propOrder = { "approvalCode" })
public class ProfileTransCaptureOnlyType extends ProfileTransOrderType {

	protected String approvalCode;

	/**
	 * Gets the value of the approvalCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getApprovalCode() {
		return approvalCode;
	}

	/**
	 * Sets the value of the approvalCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setApprovalCode(String value) {
		this.approvalCode = value;
	}

}
