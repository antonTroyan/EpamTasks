package by.troyan;

import by.troyan.entity.Candy;
import by.troyan.entity.CandyType;
import by.troyan.entity.CandyValue;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLReader {

    public static void main(String[] args) {
        String fileName = "file/candies.xml";
        try {

            org.jdom2.Document jdomDocument = createJDOMusingDOMParser(fileName);
            Element root = jdomDocument.getRootElement();

            List<Element> candiesListElements = root.getChildren("Student");

            List<Candy> candies = new ArrayList<>();
            for (Element candyElement : candiesListElements) {
                Candy candy = new Candy();

                candy.setId(Integer.parseInt(candyElement.getAttributeValue("id")));
                candy.setName(candyElement.getChildText("name"));
                candy.setEnergy(Integer.parseInt(candyElement.getChildText("energy")));

                List<CandyType> type = new ArrayList<>();
                switch (candyElement.getChildText("type")){
                    case "Caramel": type.add(CandyType.CARAMEL);
                    break;
                    case "Iris": type.add(CandyType.IRIS);
                        break;
                    case "Chocolate with filling": type.add(CandyType.CHOCOLATE_WITH_FILLING);
                        break;
                    case "Chocolate without filling": type.add(CandyType.CHOCOLATE_WITHOUT_FILLING);
                        break;
                }
                candy.setType(type);

                Map<String, Integer> ingredients = new HashMap<>();
                switch (candyElement.getChildText("ingredients")){
                    case "water": ingredients.put("water",
                            Integer.parseInt(candyElement.getChildText("water")));
                        break;
                    case "sugar": ingredients.put("sugar",
                            Integer.parseInt(candyElement.getChildText("sugar")));
                        break;
                    case "fructose": ingredients.put("fructose",
                            Integer.parseInt(candyElement.getChildText("fructose")));
                        break;
                    case "chocolate-type": ingredients.put("chocolate-type",
                            Integer.parseInt(candyElement.getChildText("chocolate-type")));
                        break;
                    case "vanilin": ingredients.put("vanilin",
                            Integer.parseInt(candyElement.getChildText("vanilin")));
                        break;
                }
                candy.setIngredients(ingredients);

                List<CandyValue> value = new ArrayList<>();
                switch (candyElement.getChildText("value")){
                    case "proteins": value.add(CandyValue.PROTEINS);
                        break;
                    case "fats": value.add(CandyValue.FATS);
                        break;
                    case "carbohydrates": value.add(CandyValue.CARBOHYDRATES);
                        break;
                }
                candy.setValue(value);
                candy.setProduction(candyElement.getChildText("production"));
                candies.add(candy);
            }
            for (Candy candy : candies) {
                System.out.println(candy.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }

    private static org.jdom2.Document createJDOMusingSAXParser(String fileName)
            throws JDOMException, IOException {

        SAXBuilder saxBuilder = new SAXBuilder();
        return saxBuilder.build(new File(fileName));
    }


    private static org.jdom2.Document createJDOMusingSTAXParser(String fileName)
            throws FileNotFoundException, XMLStreamException, JDOMException {

        StAXEventBuilder staxBuilder = new StAXEventBuilder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                new FileInputStream(fileName));
        return staxBuilder.build(xmlEventReader);
    }
}
