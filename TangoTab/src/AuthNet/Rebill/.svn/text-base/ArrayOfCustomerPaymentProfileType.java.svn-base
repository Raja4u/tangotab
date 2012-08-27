package AuthNet.Rebill;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ArrayOfCustomerPaymentProfileType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ArrayOfCustomerPaymentProfileType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;CustomerPaymentProfileType&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerPaymentProfileType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCustomerPaymentProfileType", propOrder = { "customerPaymentProfileType" })
public class ArrayOfCustomerPaymentProfileType {

	@XmlElement(name = "CustomerPaymentProfileType", nillable = true)
	protected List<CustomerPaymentProfileType> customerPaymentProfileType;

	/**
	 * Gets the value of the customerPaymentProfileType property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the customerPaymentProfileType property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCustomerPaymentProfileType().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CustomerPaymentProfileType }
	 * 
	 * 
	 */
	public List<CustomerPaymentProfileType> getCustomerPaymentProfileType() {
		if (customerPaymentProfileType == null) {
			customerPaymentProfileType = new ArrayList<CustomerPaymentProfileType>();
		}
		return this.customerPaymentProfileType;
	}

}
