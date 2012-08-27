package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ValidationModeEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;ValidationModeEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;none&quot;/&gt;
 *     &lt;enumeration value=&quot;testMode&quot;/&gt;
 *     &lt;enumeration value=&quot;liveMode&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ValidationModeEnum")
@XmlEnum
public enum ValidationModeEnum {

	@XmlEnumValue("none")
	NONE("none"), @XmlEnumValue("testMode")
	TEST_MODE("testMode"), @XmlEnumValue("liveMode")
	LIVE_MODE("liveMode");
	private final String value;

	ValidationModeEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static ValidationModeEnum fromValue(String v) {
		for (ValidationModeEnum c : ValidationModeEnum.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
