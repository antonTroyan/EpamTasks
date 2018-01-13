package by.troyan;

import javax.xml.bind.annotation.XmlEnumValue;

public enum CandyType {

    @XmlEnumValue(value = "Caramel")
    CARAMEL,

    @XmlEnumValue(value = "Iris")
    IRIS,

    @XmlEnumValue(value = "Chocolate with filling")
    CHOCOLATE_WITH_FILLING,

    @XmlEnumValue(value = "Chocolate without filling")
    CHOCOLATE_WITHOUT_FILLING
}
