package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MessageTypeEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;MessageTypeEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;Ok&quot;/&gt;
 *     &lt;enumeration value=&quot;Error&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MessageTypeEnum")
@XmlEnum
public enum MessageTypeEnum {

	@XmlEnumValue("Ok")
	OK("Ok"), @XmlEnumValue("Error")
	ERROR("Error");
	private final String value;

	MessageTypeEnum(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static MessageTypeEnum fromValue(String v) {
		for (MessageTypeEnum c : MessageTypeEnum.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
