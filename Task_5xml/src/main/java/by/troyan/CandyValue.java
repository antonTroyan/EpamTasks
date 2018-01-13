package by.troyan;

import javax.xml.bind.annotation.XmlEnumValue;

 enum CandyValue {

    @XmlEnumValue(value = "Proteins")
    PROTEINS,

    @XmlEnumValue(value = "Fats")
    FATS,

    @XmlEnumValue(value = "Carbohydrates")
    CARBOHYDRATES;

    public int value;

}
