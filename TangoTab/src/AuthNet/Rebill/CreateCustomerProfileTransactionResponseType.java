package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CreateCustomerProfileTransactionResponseType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;CreateCustomerProfileTransactionResponseType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base=&quot;{https://api.authorize.net/soap/v1/}ANetApiResponseType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;directResponse&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCustomerProfileTransactionResponseType", propOrder = { "directResponse" })
public class CreateCustomerProfileTransactionResponseType extends ANetApiResponseType {

	protected String directResponse;

	/**
	 * Gets the value of the directResponse property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDirectResponse() {
		return directResponse;
	}

	/**
	 * Sets the value of the directResponse property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDirectResponse(String value) {
		this.directResponse = value;
	}

}
