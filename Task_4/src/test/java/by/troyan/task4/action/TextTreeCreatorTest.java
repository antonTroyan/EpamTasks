package by.troyan.task4.action;

import by.troyan.task4.ConstantTestValues;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.*;

public class TextTreeCreatorTest {

    @BeforeClass
    public static void loadFile (){
        try {
            try (PrintStream out = new PrintStream(new FileOutputStream("data//testFile.txt"))) {
                out.print(ConstantTestValues.TEST_TEXT);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void deleteFile (){
        File filePath = new File("data");
        filePath.mkdir();
        new File(filePath + "\\testFile.txt").delete();
    }

    @Test
    public void testDownloadTextFromFile() throws Exception {

    }

    @Test
    public void testCreateTextTree() throws Exception {

    }
}