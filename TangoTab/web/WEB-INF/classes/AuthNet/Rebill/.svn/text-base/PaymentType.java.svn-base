package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PaymentType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;PaymentType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name=&quot;bankAccount&quot; type=&quot;{https://api.authorize.net/soap/v1/}BankAccountType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;creditCard&quot; type=&quot;{https://api.authorize.net/soap/v1/}CreditCardType&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "PaymentType", propOrder = { "bankAccount", "creditCard" })
public class PaymentType {

	protected BankAccountType bankAccount;
	protected CreditCardType creditCard;

	/**
	 * Gets the value of the bankAccount property.
	 * 
	 * @return possible object is {@link BankAccountType }
	 * 
	 */
	public BankAccountType getBankAccount() {
		return bankAccount;
	}

	/**
	 * Sets the value of the bankAccount property.
	 * 
	 * @param value
	 *            allowed object is {@link BankAccountType }
	 * 
	 */
	public void setBankAccount(BankAccountType value) {
		this.bankAccount = value;
	}

	/**
	 * Gets the value of the creditCard property.
	 * 
	 * @return possible object is {@link CreditCardType }
	 * 
	 */
	public CreditCardType getCreditCard() {
		return creditCard;
	}

	/**
	 * Sets the value of the creditCard property.
	 * 
	 * @param value
	 *            allowed object is {@link CreditCardType }
	 * 
	 */
	public void setCreditCard(CreditCardType value) {
		this.creditCard = value;
	}

}
