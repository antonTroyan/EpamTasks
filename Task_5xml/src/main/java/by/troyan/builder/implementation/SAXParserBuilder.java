package by.troyan.builder.implementation;

import by.troyan.builder.XMLParserBuilder;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SAXParserBuilder implements XMLParserBuilder {
    @Override
    public Document getDocument(String filename) throws ParserConfigurationException, IOException, SAXException,
            JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        return saxBuilder.build(new File(filename));
    }
}
