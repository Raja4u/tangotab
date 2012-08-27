package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for PaymentMaskedType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;PaymentMaskedType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name=&quot;bankAccount&quot; type=&quot;{https://api.authorize.net/soap/v1/}BankAccountMaskedType&quot; minOccurs=&quot;0&quot;/&gt;
 *           &lt;element name=&quot;creditCard&quot; type=&quot;{https://api.authorize.net/soap/v1/}CreditCardMaskedType&quot; minOccurs=&quot;0&quot;/&gt;
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
@XmlType(name = "PaymentMaskedType", propOrder = { "bankAccount", "creditCard" })
public class PaymentMaskedType {

	protected BankAccountMaskedType bankAccount;
	protected CreditCardMaskedType creditCard;

	/**
	 * Gets the value of the bankAccount property.
	 * 
	 * @return possible object is {@link BankAccountMaskedType }
	 * 
	 */
	public BankAccountMaskedType getBankAccount() {
		return bankAccount;
	}

	/**
	 * Sets the value of the bankAccount property.
	 * 
	 * @param value
	 *            allowed object is {@link BankAccountMaskedType }
	 * 
	 */
	public void setBankAccount(BankAccountMaskedType value) {
		this.bankAccount = value;
	}

	/**
	 * Gets the value of the creditCard property.
	 * 
	 * @return possible object is {@link CreditCardMaskedType }
	 * 
	 */
	public CreditCardMaskedType getCreditCard() {
		return creditCard;
	}

	/**
	 * Sets the value of the creditCard property.
	 * 
	 * @param value
	 *            allowed object is {@link CreditCardMaskedType }
	 * 
	 */
	public void setCreditCard(CreditCardMaskedType value) {
		this.creditCard = value;
	}

}
