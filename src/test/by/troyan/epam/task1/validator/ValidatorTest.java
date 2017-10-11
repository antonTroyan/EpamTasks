package test.by.troyan.epam.task1.validator;

import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.NoFileNameException;
import by.troyan.epam.task1.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {
    Validator validator = new Validator();
    @Test
    public void testValidateStringNotInteger() throws Exception {
        Assert.assertEquals(validator.validateString("1f 2 3 4 5 6"), false);
    }

    @Test
    public void testValidateStringNotFull() throws Exception {
        Assert.assertEquals(validator.validateString("1 2 3 4 "), false);
    }


    @Test (expectedExceptions = NoFileNameException.class)
    public void testValidateFileNoName() throws Exception {
        validator.validateFile(" ");
    }

    @Test (expectedExceptions = FileIsEmptyException.class)
    public void testValidateFileIsEmpty() throws Exception {
        validator.validateFile("empty.txt");
    }



}