package by.troyan.epam.task3.parser;

import by.troyan.epam.task3.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class TriangleParser {


    public ArrayList<Integer> parse (List<String> input, String delimiter) {
        ArrayList<Integer> result = new ArrayList<>();
        Validator validator = new Validator();
        for(int i = 0; i < input.size(); i++){
            if(validator.validateString(input.get(i))){
                String [] analized = input.get(i).split(delimiter);
                for (int column = 0; column < Validator.COLUMN_AMOUNT; column++){
                    result.add(Integer.parseInt(analized[column]));
                }
            }
        }
        return result;
    }
}
