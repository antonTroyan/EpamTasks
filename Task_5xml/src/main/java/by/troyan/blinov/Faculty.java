package by.troyan.blinov;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Faculty {
    FPMI("FPMI"), MMF("MMF"), @XmlEnumValue("Geo") GEO_F("Geo");
    private final String value;

    Faculty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Faculty fromValue(String v) {
        for (Faculty c : Faculty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }
}
