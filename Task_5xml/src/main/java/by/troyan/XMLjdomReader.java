package by.troyan;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XMLjdomReader {
    public static void main(String[] args) {
        String fileName = "file/students.xml";
        try {
            // мы можем создать экземпляр JDOM Document из классов DOM, SAX и STAX Builder
            org.jdom2.Document jdomDocument = createJDOMusingDOMParser(fileName);
            Element root = jdomDocument.getRootElement();
            // получаем список всех элементов Student
            List<Element> studListElements = root.getChildren("Student");
            // список объектов Student, в которых будем хранить
            // считанные данные по каждому элементу
            List<Student> students = new ArrayList<>();
            for (Element studentEl : studListElements) {
                Student student = new Student();
                student.setId(Integer.parseInt(studentEl.getAttributeValue("id")));
                student.setAge(Integer.parseInt(studentEl.getChildText("age")));
                student.setName(studentEl.getChildText("name"));
                student.setLanguage(studentEl.getChildText("language"));

                students.add(student);
            }
            // печатаем полученный список объектов Student
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // получаем экземпляр JDOM Document с помощью DOM Parser
    private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }

    // получаем экземпляр JDOM Document с помощью SAX Parser
    private static org.jdom2.Document createJDOMusingSAXParser(String fileName)
            throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        return saxBuilder.build(new File(fileName));
    }

    // получаем экземпляр JDOM Document с помощью STAX Stream Parser или STAX Event Parser
    private static org.jdom2.Document createJDOMusingSTAXParser(String fileName, String type)
            throws FileNotFoundException, XMLStreamException, JDOMException {
        if (type.equalsIgnoreCase("stream")) {
            StAXStreamBuilder staxBuilder = new StAXStreamBuilder();
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader =
                    xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
            return staxBuilder.build(xmlStreamReader);
        }
        StAXEventBuilder staxBuilder = new StAXEventBuilder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                new FileInputStream(fileName));
        return staxBuilder.build(xmlEventReader);
    }
}
