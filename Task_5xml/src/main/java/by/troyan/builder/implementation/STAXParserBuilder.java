package by.troyan.builder.implementation;

import by.troyan.builder.XMLParserBuilder;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.StAXEventBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.IOException;

public class STAXParserBuilder implements XMLParserBuilder {
    @Override
    public Document getDocument(String filename) throws ParserConfigurationException, IOException, SAXException,
            JDOMException, XMLStreamException {
        StAXEventBuilder staxBuilder = new StAXEventBuilder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                new FileInputStream(filename));
        return staxBuilder.build(xmlEventReader);
    }
}
