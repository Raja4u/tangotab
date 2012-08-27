package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ARBSubscriptionUnitEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;ARBSubscriptionUnitEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;days&quot;/&gt;
 *     &lt;enumeration value=&quot;months&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ARBSubscriptionUnitEnum")
@XmlEnum
public enum ARBSubscriptionUnitEnum {

	@XmlEnumValue("days")
	DAYS("days"), @XmlEnumValue("months")
	MONTHS("months");
	private final String value;

	ARBSubscriptionUnitEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static ARBSubscriptionUnitEnum fromValue(String v) {
		for (ARBSubscriptionUnitEnum c : ARBSubscriptionUnitEnum.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
