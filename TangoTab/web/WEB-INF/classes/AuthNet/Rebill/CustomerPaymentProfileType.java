package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerPaymentProfileType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CustomerPaymentProfileType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}CustomerPaymentProfileBaseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;payment&quot; type=&quot;{https://api.authorize.net/soap/v1/}PaymentType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;driversLicense&quot; type=&quot;{https://api.authorize.net/soap/v1/}DriversLicenseType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;taxId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerPaymentProfileType", propOrder = { "payment", "driversLicense", "taxId" })
@XmlSeeAlso( { CustomerPaymentProfileExType.class })
public class CustomerPaymentProfileType extends CustomerPaymentProfileBaseType {

	protected PaymentType payment;
	protected DriversLicenseType driversLicense;
	protected String taxId;

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
	 * Gets the value of the driversLicense property.
	 * 
	 * @return possible object is {@link DriversLicenseType }
	 * 
	 */
	public DriversLicenseType getDriversLicense() {
		return driversLicense;
	}

	/**
	 * Sets the value of the driversLicense property.
	 * 
	 * @param value
	 *            allowed object is {@link DriversLicenseType }
	 * 
	 */
	public void setDriversLicense(DriversLicenseType value) {
		this.driversLicense = value;
	}

	/**
	 * Gets the value of the taxId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTaxId() {
		return taxId;
	}

	/**
	 * Sets the value of the taxId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTaxId(String value) {
		this.taxId = value;
	}

}
