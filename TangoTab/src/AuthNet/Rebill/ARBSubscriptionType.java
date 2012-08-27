package AuthNet.Rebill;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ARBSubscriptionType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ARBSubscriptionType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;name&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;paymentSchedule&quot; type=&quot;{https://api.authorize.net/soap/v1/}PaymentScheduleType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;amount&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;trialAmount&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;payment&quot; type=&quot;{https://api.authorize.net/soap/v1/}PaymentType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;order&quot; type=&quot;{https://api.authorize.net/soap/v1/}OrderType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;customer&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;billTo&quot; type=&quot;{https://api.authorize.net/soap/v1/}NameAndAddressType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;shipTo&quot; type=&quot;{https://api.authorize.net/soap/v1/}NameAndAddressType&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARBSubscriptionType", propOrder = { "name", "paymentSchedule", "amount",
		"trialAmount", "payment", "order", "customer", "billTo", "shipTo" })
public class ARBSubscriptionType {

	protected String name;
	protected PaymentScheduleType paymentSchedule;
	protected BigDecimal amount;
	protected BigDecimal trialAmount;
	protected PaymentType payment;
	protected OrderType order;
	protected CustomerType customer;
	protected NameAndAddressType billTo;
	protected NameAndAddressType shipTo;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the paymentSchedule property.
	 * 
	 * @return possible object is {@link PaymentScheduleType }
	 * 
	 */
	public PaymentScheduleType getPaymentSchedule() {
		return paymentSchedule;
	}

	/**
	 * Sets the value of the paymentSchedule property.
	 * 
	 * @param value
	 *            allowed object is {@link PaymentScheduleType }
	 * 
	 */
	public void setPaymentSchedule(PaymentScheduleType value) {
		this.paymentSchedule = value;
	}

	/**
	 * Gets the value of the amount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the value of the amount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setAmount(BigDecimal value) {
		this.amount = value;
	}

	/**
	 * Gets the value of the trialAmount property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getTrialAmount() {
		return trialAmount;
	}

	/**
	 * Sets the value of the trialAmount property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setTrialAmount(BigDecimal value) {
		this.trialAmount = value;
	}

	/**
	 * Gets the value of the payment property.
	 * 
	 * @return possible object is {@link PaymentType }
	 * 
	 */
	public PaymentType getPayment() {
		return payment;
	}

	/**
	 * Sets the value of the payment property.
	 * 
	 * @param value
	 *            allowed object is {@link PaymentType }
	 * 
	 */
	public void setPayment(PaymentType value) {
		this.payment = value;
	}

	/**
	 * Gets the value of the order property.
	 * 
	 * @return possible object is {@link OrderType }
	 * 
	 */
	public OrderType getOrder() {
		return order;
	}

	/**
	 * Sets the value of the order property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderType }
	 * 
	 */
	public void setOrder(OrderType value) {
		this.order = value;
	}

	/**
	 * Gets the value of the customer property.
	 * 
	 * @return possible object is {@link CustomerType }
	 * 
	 */
	public CustomerType getCustomer() {
		return customer;
	}

	/**
	 * Sets the value of the customer property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerType }
	 * 
	 */
	public void setCustomer(CustomerType value) {
		this.customer = value;
	}

	/**
	 * Gets the value of the billTo property.
	 * 
	 * @return possible object is {@link NameAndAddressType }
	 * 
	 */
	public NameAndAddressType getBillTo() {
		return billTo;
	}

	/**
	 * Sets the value of the billTo property.
	 * 
	 * @param value
	 *            allowed object is {@link NameAndAddressType }
	 * 
	 */
	public void setBillTo(NameAndAddressType value) {
		this.billTo = value;
	}

	/**
	 * Gets the value of the shipTo property.
	 * 
	 * @return possible object is {@link NameAndAddressType }
	 * 
	 */
	public NameAndAddressType getShipTo() {
		return shipTo;
	}

	/**
	 * Sets the value of the shipTo property.
	 * 
	 * @param value
	 *            allowed object is {@link NameAndAddressType }
	 * 
	 */
	public void setShipTo(NameAndAddressType value) {
		this.shipTo = value;
	}

}
