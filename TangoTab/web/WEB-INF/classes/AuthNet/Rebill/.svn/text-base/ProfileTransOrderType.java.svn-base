package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ProfileTransOrderType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ProfileTransOrderType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}ProfileTransAmountType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;customerProfileId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;customerPaymentProfileId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot;/&gt;
 *         &lt;element name=&quot;customerShippingAddressId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}long&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;order&quot; type=&quot;{https://api.authorize.net/soap/v1/}OrderExType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;taxExempt&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}boolean&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;recurringBilling&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}boolean&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;cardCode&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileTransOrderType", propOrder = { "customerProfileId",
		"customerPaymentProfileId", "customerShippingAddressId", "order", "taxExempt",
		"recurringBilling", "cardCode" })
@XmlSeeAlso( { ProfileTransAuthCaptureType.class, ProfileTransAuthOnlyType.class,
		ProfileTransCaptureOnlyType.class })
public class ProfileTransOrderType extends ProfileTransAmountType {

	protected long customerProfileId;
	protected long customerPaymentProfileId;
	protected Long customerShippingAddressId;
	protected OrderExType order;
	protected Boolean taxExempt;
	protected Boolean recurringBilling;
	protected String cardCode;

	/**
	 * Gets the value of the customerProfileId property.
	 * 
	 */
	public long getCustomerProfileId() {
		return customerProfileId;
	}

	/**
	 * Sets the value of the customerProfileId property.
	 * 
	 */
	public void setCustomerProfileId(long value) {
		this.customerProfileId = value;
	}

	/**
	 * Gets the value of the customerPaymentProfileId property.
	 * 
	 */
	public long getCustomerPaymentProfileId() {
		return customerPaymentProfileId;
	}

	/**
	 * Sets the value of the customerPaymentProfileId property.
	 * 
	 */
	public void setCustomerPaymentProfileId(long value) {
		this.customerPaymentProfileId = value;
	}

	/**
	 * Gets the value of the customerShippingAddressId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getCustomerShippingAddressId() {
		return customerShippingAddressId;
	}

	/**
	 * Sets the value of the customerShippingAddressId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setCustomerShippingAddressId(Long value) {
		this.customerShippingAddressId = value;
	}

	/**
	 * Gets the value of the order property.
	 * 
	 * @return possible object is {@link OrderExType }
	 * 
	 */
	public OrderExType getOrder() {
		return order;
	}

	/**
	 * Sets the value of the order property.
	 * 
	 * @param value
	 *            allowed object is {@link OrderExType }
	 * 
	 */
	public void setOrder(OrderExType value) {
		this.order = value;
	}

	/**
	 * Gets the value of the taxExempt property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isTaxExempt() {
		return taxExempt;
	}

	/**
	 * Sets the value of the taxExempt property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setTaxExempt(Boolean value) {
		this.taxExempt = value;
	}

	/**
	 * Gets the value of the recurringBilling property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isRecurringBilling() {
		return recurringBilling;
	}

	/**
	 * Sets the value of the recurringBilling property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setRecurringBilling(Boolean value) {
		this.recurringBilling = value;
	}

	/**
	 * Gets the value of the cardCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCardCode() {
		return cardCode;
	}

	/**
	 * Sets the value of the cardCode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCardCode(String value) {
		this.cardCode = value;
	}

}
