package by.troyan.builder;

import by.troyan.builder.implementation.DOMParserBuilder;
import by.troyan.builder.implementation.SAXParserBuilder;
import by.troyan.builder.implementation.STAXParserBuilder;
import by.troyan.entity.Candy;
import by.troyan.entity.CandyType;
import by.troyan.entity.CandyValue;
import org.jdom2.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XMLReader {

    public List<Candy> getListOfCandiesByCertainParser (int parser, String filename){
        Director director = new Director();
        XMLParserBuilder builder = null;
        switch(parser){
            case 1: builder = new DOMParserBuilder();
            break;
            case 2: builder = new SAXParserBuilder();
            break;
            case 3: builder = new STAXParserBuilder();
            break;
            default: builder = new DOMParserBuilder();
        }


        List<Candy> candies = null;

        try {
            director.setXMLParserBuilder(builder);
            org.jdom2.Document jdomDocument = director.getDocument(filename);
            Element root = jdomDocument.getRootElement();
            List<Element> candiesListElements = root.getChildren("Student");
            candies = new ArrayList<>();
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

        } catch (Exception e) {
            e.printStackTrace();
        }
      return candies;
    }
    }



