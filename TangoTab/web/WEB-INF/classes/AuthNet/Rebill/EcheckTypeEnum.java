package AuthNet.Rebill;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for EcheckTypeEnum.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;EcheckTypeEnum&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;PPD&quot;/&gt;
 *     &lt;enumeration value=&quot;WEB&quot;/&gt;
 *     &lt;enumeration value=&quot;CCD&quot;/&gt;
 *     &lt;enumeration value=&quot;TEL&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EcheckTypeEnum")
@XmlEnum
public enum EcheckTypeEnum {

	PPD, WEB, CCD, TEL;

	public String value() {
		return name();
	}

	public static EcheckTypeEnum fromValue(String v) {
		return valueOf(v);
	}

}
