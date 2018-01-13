package by.troyan.builder;

import by.troyan.builder.implementation.DOMParserBuilder;
import by.troyan.builder.implementation.SAXParserBuilder;
import by.troyan.builder.implementation.STAXParserBuilder;
import by.troyan.entity.Candy;
import by.troyan.entity.CandyType;
import by.troyan.entity.CandyValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XMLReader {
    private final static Logger LOG = LogManager.getLogger(XMLReader.class);

    public List<Candy> getListOfCandiesByCertainParser(int parserID, String filename) {
        Director director = new Director();
        XMLParserBuilder parserBuilder = createParserByID(parserID);

        List<Candy> candies = null;
        try {
            director.setXMLParserBuilder(parserBuilder);
            org.jdom2.Document jdomDocument = director.getDocument(filename);
            Element root = jdomDocument.getRootElement();
            List<Element> candiesListElements = root.getChildren("Candy");
            candies = new ArrayList<>();
            for (Element candyElement : candiesListElements) {
                Candy candy = createCandy(candyElement);
                candies.add(candy);
            }

        } catch (Exception e) {
            LOG.fatal(e);
            throw new RuntimeException(e);
        }
        return candies;
    }


    private XMLParserBuilder createParserByID(int parserID) {
        XMLParserBuilder result = null;

        final int DOM_PARSER_ID = 1;
        final int SAX_PARSER_ID = 2;
        final int STAX_PARSER_ID = 3;

        switch (parserID) {
            case DOM_PARSER_ID:
                result = new DOMParserBuilder();
                break;
            case SAX_PARSER_ID:
                result = new SAXParserBuilder();
                break;
            case STAX_PARSER_ID:
                result = new STAXParserBuilder();
                break;
            default:
                result = new DOMParserBuilder();
        }
        return result;
    }

    private Candy createCandy(Element candyElement) {
        Candy result = new Candy();

        result.setId(Integer.parseInt(candyElement.getAttributeValue("id")));
        result.setName(candyElement.getChildText("name"));
        result.setEnergy(Integer.parseInt(candyElement.getChildText("energy")));

        List<CandyType> type = new ArrayList<>();
        switch (candyElement.getChildText("type")) {
            case "Caramel":
                type.add(CandyType.CARAMEL);
                break;
            case "Iris":
                type.add(CandyType.IRIS);
                break;
            case "Chocolate with filling":
                type.add(CandyType.CHOCOLATE_WITH_FILLING);
                break;
            case "Chocolate without filling":
                type.add(CandyType.CHOCOLATE_WITHOUT_FILLING);
                break;
        }
        result.setType(type);

        result.setIngredients(createIngredientsList(candyElement.getChildText("ingredients"), candyElement));
        result.setValue(createCandyValueList(candyElement.getChildText("value")));
        result.setProduction(candyElement.getChildText("production"));

        return result;
    }


    private Map<String, Integer> createIngredientsList(String value, Element candyElement) {
        Map<String, Integer> result = new HashMap<>();
        switch (value) {
            case "water":
                result.put("water",
                        Integer.parseInt(candyElement.getChildText("water")));
                break;
            case "sugar":
                result.put("sugar",
                        Integer.parseInt(candyElement.getChildText("sugar")));
                break;
            case "fructose":
                result.put("fructose",
                        Integer.parseInt(candyElement.getChildText("fructose")));
                break;
            case "chocolate-type":
                result.put("chocolate-type",
                        Integer.parseInt(candyElement.getChildText("chocolate-type")));
                break;
            case "vanilin":
                result.put("vanilin",
                        Integer.parseInt(candyElement.getChildText("vanilin")));
                break;
        }
        return result;
    }


    private List<CandyValue> createCandyValueList(String value) {
        List<CandyValue> result = new ArrayList<>();
        switch (value) {
            case "proteins":
                result.add(CandyValue.PROTEINS);
                break;
            case "fats":
                result.add(CandyValue.FATS);
                break;
            case "carbohydrates":
                result.add(CandyValue.CARBOHYDRATES);
                break;
        }
        return result;
    }
}



