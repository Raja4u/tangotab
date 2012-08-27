package AuthNet.Rebill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ProfileTransAmountType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ProfileTransAmountType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;amount&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}decimal&quot;/&gt;
 *         &lt;element name=&quot;tax&quot; type=&quot;{https://api.authorize.net/soap/v1/}ExtendedAmountType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;shipping&quot; type=&quot;{https://api.authorize.net/soap/v1/}ExtendedAmountType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;duty&quot; type=&quot;{https://api.authorize.net/soap/v1/}ExtendedAmountType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;lineItems&quot; type=&quot;{https://api.authorize.net/soap/v1/}LineItemType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileTransAmountType", propOrder = { "amount", "tax", "shipping", "duty",
		"lineItems" })
@XmlSeeAlso( { ProfileTransPriorAuthCaptureType.class, ProfileTransRefundType.class,
		ProfileTransOrderType.class })
public class ProfileTransAmountType {

	@XmlElement(required = true)
	protected BigDecimal amount;
	protected ExtendedAmountType tax;
	protected ExtendedAmountType shipping;
	protected ExtendedAmountType duty;
	protected List<LineItemType> lineItems;

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
	 * Gets the value of the tax property.
	 * 
	 * @return possible object is {@link ExtendedAmountType }
	 * 
	 */
	public ExtendedAmountType getTax() {
		return tax;
	}

	/**
	 * Sets the value of the tax property.
	 * 
	 * @param value
	 *            allowed object is {@link ExtendedAmountType }
	 * 
	 */
	public void setTax(ExtendedAmountType value) {
		this.tax = value;
	}

	/**
	 * Gets the value of the shipping property.
	 * 
	 * @return possible object is {@link ExtendedAmountType }
	 * 
	 */
	public ExtendedAmountType getShipping() {
		return shipping;
	}

	/**
	 * Sets the value of the shipping property.
	 * 
	 * @param value
	 *            allowed object is {@link ExtendedAmountType }
	 * 
	 */
	public void setShipping(ExtendedAmountType value) {
		this.shipping = value;
	}

	/**
	 * Gets the value of the duty property.
	 * 
	 * @return possible object is {@link ExtendedAmountType }
	 * 
	 */
	public ExtendedAmountType getDuty() {
		return duty;
	}

	/**
	 * Sets the value of the duty property.
	 * 
	 * @param value
	 *            allowed object is {@link ExtendedAmountType }
	 * 
	 */
	public void setDuty(ExtendedAmountType value) {
		this.duty = value;
	}

	/**
	 * Gets the value of the lineItems property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the lineItems property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLineItems().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link LineItemType }
	 * 
	 * 
	 */
	public List<LineItemType> getLineItems() {
		if (lineItems == null) {
			lineItems = new ArrayList<LineItemType>();
		}
		return this.lineItems;
	}

}
