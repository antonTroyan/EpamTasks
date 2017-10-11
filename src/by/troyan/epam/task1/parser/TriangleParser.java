package by.troyan.epam.task1.parser;

import by.troyan.epam.task1.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {

    public ArrayList<Integer> parse (List<String> input) {
        ArrayList<Integer> result = new ArrayList<>();
        Validator validator = new Validator();
        for(int i = 0; i < input.size(); i++){
            if(validator.validateString(input.get(i))){
                String [] analized = input.get(i).split(" ");
                for (int r = 0; r < 6; r++){
                    result.add(Integer.parseInt(analized[r]));
                }
            }
        }
        return result;
    }



}
