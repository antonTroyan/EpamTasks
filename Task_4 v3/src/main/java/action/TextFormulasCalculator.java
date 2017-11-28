package action;

import counter.PolishFormConverter;
import counter.interpreter.Client;
import creator.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormulasCalculator {

    public String calculateTextFormulas (String text, int i, int j){
        String result = text;
        ParametersTextFiller parametersFiller = new ParametersTextFiller();
        result = parametersFiller.fillTextByParameters(text, i, j);
        Matcher matcher = Pattern
                .compile(RegularExpressions.REGEX_MATH_EXPRESSIONS)
                .matcher(result);

        String foundedExpression = "";
        String polishFormExpression = "";
        String answer = "";

        while(matcher.find()){
            foundedExpression = matcher.group();

            polishFormExpression = PolishFormConverter.sortingStation(foundedExpression,
                    PolishFormConverter.MAIN_MATH_OPERATIONS);
            Client interpreter = new Client(polishFormExpression);
            answer = interpreter.calculate().toString();
            System.out.println("Founded " + foundedExpression);
            System.out.println("Answer " + answer);
            result = result.replace(foundedExpression, answer);
        }
        return result;
    }
}
