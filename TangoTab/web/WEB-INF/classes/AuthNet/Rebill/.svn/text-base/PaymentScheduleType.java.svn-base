package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for PaymentScheduleType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;PaymentScheduleType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;interval&quot; type=&quot;{https://api.authorize.net/soap/v1/}PaymentScheduleTypeInterval&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;startDate&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}date&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;totalOccurrences&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}short&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;trialOccurrences&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}short&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentScheduleType", propOrder = { "interval", "startDate", "totalOccurrences",
		"trialOccurrences" })
public class PaymentScheduleType {

	protected PaymentScheduleTypeInterval interval;
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar startDate;
	protected Short totalOccurrences;
	protected Short trialOccurrences;

	/**
	 * Gets the value of the interval property.
	 * 
	 * @return possible object is {@link PaymentScheduleTypeInterval }
	 * 
	 */
	public PaymentScheduleTypeInterval getInterval() {
		return interval;
	}

	/**
	 * Sets the value of the interval property.
	 * 
	 * @param value
	 *            allowed object is {@link PaymentScheduleTypeInterval }
	 * 
	 */
	public void setInterval(PaymentScheduleTypeInterval value) {
		this.interval = value;
	}

	/**
	 * Gets the value of the startDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * Sets the value of the startDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setStartDate(XMLGregorianCalendar value) {
		this.startDate = value;
	}

	/**
	 * Gets the value of the totalOccurrences property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getTotalOccurrences() {
		return totalOccurrences;
	}

	/**
	 * Sets the value of the totalOccurrences property.
	 * 
	 * @param value
	 *            allowed object is {@link Short }
	 * 
	 */
	public void setTotalOccurrences(Short value) {
		this.totalOccurrences = value;
	}

	/**
	 * Gets the value of the trialOccurrences property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getTrialOccurrences() {
		return trialOccurrences;
	}

	/**
	 * Sets the value of the trialOccurrences property.
	 * 
	 * @param value
	 *            allowed object is {@link Short }
	 * 
	 */
	public void setTrialOccurrences(Short value) {
		this.trialOccurrences = value;
	}

}
