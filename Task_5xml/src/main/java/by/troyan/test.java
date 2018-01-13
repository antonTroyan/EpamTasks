package by.troyan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int id = 5;
        String name = "the cow";
        int energy = 15;
        List<CandyType> type = new ArrayList<>();
        type.add(CandyType.CARAMEL);
        type.add(CandyType.CHOCOLATE_WITH_FILLING);

        Map<String, Integer> ingredients = new HashMap<>();
        ingredients.put("water", 150);
        ingredients.put("sugar", 600);

        List<CandyValue> value = new ArrayList<>();
        CandyValue.CARBOHYDRATES.value = 20;
        value.add(CandyValue.CARBOHYDRATES);

        String production = "Roshen";

        Candy candy = new Candy(id, name, energy, type, ingredients, value, production);

        System.out.println(candy);
    }
}
