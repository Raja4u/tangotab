package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for BankAccountTypeEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;BankAccountTypeEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;checking&quot;/&gt;
 *     &lt;enumeration value=&quot;savings&quot;/&gt;
 *     &lt;enumeration value=&quot;businessChecking&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BankAccountTypeEnum")
@XmlEnum
public enum BankAccountTypeEnum {

	@XmlEnumValue("checking")
	CHECKING("checking"), @XmlEnumValue("savings")
	SAVINGS("savings"), @XmlEnumValue("businessChecking")
	BUSINESS_CHECKING("businessChecking");
	private final String value;

	BankAccountTypeEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static BankAccountTypeEnum fromValue(String v) {
		for (BankAccountTypeEnum c : BankAccountTypeEnum.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
