package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CustomerType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;type&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerTypeEnum&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;email&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;phoneNumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;faxNumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;driversLicense&quot; type=&quot;{https://api.authorize.net/soap/v1/}DriversLicenseType&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;taxId&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerType", propOrder = { "type", "id", "email", "phoneNumber", "faxNumber",
		"driversLicense", "taxId" })
public class CustomerType {

	protected CustomerTypeEnum type;
	protected String id;
	protected String email;
	protected String phoneNumber;
	protected String faxNumber;
	protected DriversLicenseType driversLicense;
	protected String taxId;

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link CustomerTypeEnum }
	 * 
	 */
	public CustomerTypeEnum getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link CustomerTypeEnum }
	 * 
	 */
	public void setType(CustomerTypeEnum value) {
		this.type = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the phoneNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the value of the phoneNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	/**
	 * Gets the value of the faxNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Sets the value of the faxNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFaxNumber(String value) {
		this.faxNumber = value;
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
