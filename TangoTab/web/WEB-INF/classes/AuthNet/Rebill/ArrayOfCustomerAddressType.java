package AuthNet.Rebill;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ArrayOfCustomerAddressType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;ArrayOfCustomerAddressType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;CustomerAddressType&quot; type=&quot;{https://api.authorize.net/soap/v1/}CustomerAddressType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCustomerAddressType", propOrder = { "customerAddressType" })
public class ArrayOfCustomerAddressType {

	@XmlElement(name = "CustomerAddressType", nillable = true)
	protected List<CustomerAddressType> customerAddressType;

	/**
	 * Gets the value of the customerAddressType property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any
	 * modification you make to the returned list will be present inside the JAXB object. This is
	 * why there is not a <CODE>set</CODE> method for the customerAddressType property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCustomerAddressType().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CustomerAddressType }
	 * 
	 * 
	 */
	public List<CustomerAddressType> getCustomerAddressType() {
		if (customerAddressType == null) {
			customerAddressType = new ArrayList<CustomerAddressType>();
		}
		return this.customerAddressType;
	}

}
