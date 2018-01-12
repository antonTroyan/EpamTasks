package by.troyan.blinov;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public Course createCourse() {
        return new Course();
    }

    public University createUniversity() {
        return new University();
    }
}
