package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CustomerTypeEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;CustomerTypeEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;individual&quot;/&gt;
 *     &lt;enumeration value=&quot;business&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CustomerTypeEnum")
@XmlEnum
public enum CustomerTypeEnum {

	@XmlEnumValue("individual")
	INDIVIDUAL("individual"), @XmlEnumValue("business")
	BUSINESS("business");
	private final String value;

	CustomerTypeEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static CustomerTypeEnum fromValue(String v) {
		for (CustomerTypeEnum c : CustomerTypeEnum.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
