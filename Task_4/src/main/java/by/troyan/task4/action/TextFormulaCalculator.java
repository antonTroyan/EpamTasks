package by.troyan.task4.action;


import by.troyan.task4.calculating.PolishFormConverter;
import by.troyan.task4.calculating.counter.Client;
import by.troyan.task4.creator.RegularExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormulaCalculator {

    private final static Logger LOG = LogManager.getLogger("ParametersTextFiller");

    public String calculateTextFormulas(String text, int i, int j){

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
            LOG.info("Math expression founded " + foundedExpression);

            polishFormExpression = PolishFormConverter.sortingStation(foundedExpression,
                    PolishFormConverter.MAIN_MATH_OPERATIONS);
            LOG.info("Math expression converted to polish form " + foundedExpression);

            Client interpreter = new Client(polishFormExpression);
            answer = interpreter.calculate().toString();
            LOG.info("Math expression was calculated " + answer);

            result = result.replace(foundedExpression, answer);
        }
        return result;
    }
}
