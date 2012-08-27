package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for CreditCardSimpleType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CreditCardSimpleType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;cardNumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;expirationDate&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}gYearMonth&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCardSimpleType", propOrder = { "cardNumber", "expirationDate" })
@XmlSeeAlso( { CreditCardType.class })
public class CreditCardSimpleType {

	protected String cardNumber;
	@XmlSchemaType(name = "gYearMonth")
	protected XMLGregorianCalendar expirationDate;

	/**
	 * Gets the value of the cardNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Sets the value of the cardNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCardNumber(String value) {
		this.cardNumber = value;
	}

	/**
	 * Gets the value of the expirationDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Sets the value of the expirationDate property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setExpirationDate(XMLGregorianCalendar value) {
		this.expirationDate = value;
	}

}
