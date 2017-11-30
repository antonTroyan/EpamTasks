package action;

import counting.PolishFormConverter;
import counting.counter.Client;
import creator.RegularExpression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormulaCalculator {

    public String calculateTextFormulas (String text, int i, int j){
        ParametersTextFiller parametersFiller = new ParametersTextFiller();
        String result = parametersFiller.fillTextByParameters(text, i, j);
        Matcher matcher = Pattern
                .compile(RegularExpression.REGEX_MATH_EXPRESSIONS)
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
            result = result.replace(foundedExpression, answer);
        }
        return result;
    }
}
