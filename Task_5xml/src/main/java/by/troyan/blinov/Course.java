package by.troyan.blinov;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Course complex type.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Course", propOrder = {"login", "name", "telephone"})
public class Course {
    @XmlElement(required = true)
    protected String login;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String telephone;

    public String getLogin() {
        return login;
    }

    public void setLogin(String value) {
        this.login = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String value) {
        this.telephone = value;
    }
}

