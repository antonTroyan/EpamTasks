package by.troyan.blinov;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"faculty", "course"})
@XmlRootElement(name = "University")

public class University {
    @XmlElement(required = true)
    protected Faculty faculty;
    @XmlElement(required = true)
    protected Course course;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty value) {
        this.faculty = value;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course value) {
        this.course = value;
    }
}
