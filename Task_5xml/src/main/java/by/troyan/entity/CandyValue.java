package by.troyan.entity;

import javax.xml.bind.annotation.XmlEnumValue;

 public enum CandyValue {

    @XmlEnumValue(value = "Proteins")
    PROTEINS,

    @XmlEnumValue(value = "Fats")
    FATS,

    @XmlEnumValue(value = "Carbohydrates")
    CARBOHYDRATES

}
