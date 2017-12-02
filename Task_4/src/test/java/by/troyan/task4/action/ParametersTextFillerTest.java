package by.troyan.task4.action;

import by.troyan.task4.ConstantTestValues;
import by.troyan.task4.creator.RegularExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class ParametersTextFillerTest {
    private ParametersTextFiller parametersTextFiller = new ParametersTextFiller();

    @Test
    public void testFillTextByParametersIsFindAll() throws Exception {
        String resultText = parametersTextFiller.fillTextByParameters(ConstantTestValues.TEST_TEXT,
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J
        );
        Scanner parametersScanner = new Scanner(resultText);
        String founded = parametersScanner.findInLine(RegularExpression.REGEX_IANDJ);

        Assert.assertEquals(founded, null);
    }

    @Test
    public void testFillTextByParametersIsCorrect() throws Exception {
        String resultText = parametersTextFiller.fillTextByParameters(ConstantTestValues.TEST_TEXT,
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, ConstantTestValues.RIGHT_RESULT_TEXT_WITH_PARAMETERS);
    }

    @Test
    public void testFillTextByParametersIsCorrectSmall() throws Exception {
        String resultText = parametersTextFiller.fillTextByParameters("++i",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, "6\n");
    }
}