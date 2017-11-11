package test.by.troyan.epam.task3.validator;


import by.troyan.epam.task3.exception.FileIsEmptyException;
import by.troyan.epam.task3.exception.NoFileNameException;
import by.troyan.epam.task3.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ValidatorTest {

    Validator validator = new Validator();

    @BeforeClass
    public static void prepareFile (){
        File filePath = new File("data");
        filePath.mkdir();
        File file = new File(filePath + "\\test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void deleteFile (){
        File filePath = new File("data");
        filePath.mkdir();
        new File(filePath + "\\test.txt").delete();
    }

    @Test
    public void testValidateStringNotInteger() throws Exception {
        Assert.assertEquals(validator.validateString("1f 2 3 4 5 6"), false);
    }

    @Test
    public void testValidateStringNotFull() throws Exception {
        Assert.assertEquals(validator.validateString("1 2 3 4 "), false);
    }


    @Test(expectedExceptions = NoFileNameException.class)
    public void testValidateFileNoName() throws Exception {
        validator.validateFile("");
    }

    @Test(expectedExceptions = FileIsEmptyException.class)
    public void testValidateFileIsEmpty() throws Exception {
        validator.validateFile("data\\test.txt");
    }
}