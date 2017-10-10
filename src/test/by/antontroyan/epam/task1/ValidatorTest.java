package test.by.antontroyan.epam.task1;

import by.antontroyan.epam.task1.Validator;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {

    Validator v = new Validator();
    List<String> testList = new ArrayList<>();


    @Test
    public void testValidateIncorrectCharacter() throws Exception {
        testList.add("2f 2 3 4 1 5");
        v.validate(testList);
    }

    @Test
    public void testValidateMoreCharacters() throws Exception {
        testList.add("2f 2 3 4 1 5");
        v.validate(testList);
    }

}