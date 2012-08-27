package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PaymentScheduleTypeInterval complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;PaymentScheduleTypeInterval&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;length&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}short&quot;/&gt;
 *         &lt;element name=&quot;unit&quot; type=&quot;{https://api.authorize.net/soap/v1/}ARBSubscriptionUnitEnum&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentScheduleTypeInterval", propOrder = { "length", "unit" })
public class PaymentScheduleTypeInterval {

	protected short length;
	@XmlElement(required = true)
	protected ARBSubscriptionUnitEnum unit;

	/**
	 * Gets the value of the length property.
	 * 
	 */
	public short getLength() {
		return length;
	}

	/**
	 * Sets the value of the length property.
	 * 
	 */
	public void setLength(short value) {
		this.length = value;
	}

	/**
	 * Gets the value of the unit property.
	 * 
	 * @return possible object is {@link ARBSubscriptionUnitEnum }
	 * 
	 */
	public ARBSubscriptionUnitEnum getUnit() {
		return unit;
	}

	/**
	 * Sets the value of the unit property.
	 * 
	 * @param value
	 *            allowed object is {@link ARBSubscriptionUnitEnum }
	 * 
	 */
	public void setUnit(ARBSubscriptionUnitEnum value) {
		this.unit = value;
	}

}
