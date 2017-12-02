package by.troyan.task4.action;

import by.troyan.task4.ConstantTestValues;
import by.troyan.task4.entity.SymbolSet;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

public class TextTreeCreatorTest {

    private TextTreeCreator textTreeCreator = new TextTreeCreator();

    @BeforeClass
    public static void loadFile() {
        try (PrintStream out = new PrintStream(new FileOutputStream("data//testFile.txt"))) {
            out.print(ConstantTestValues.TEST_TEXT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void deleteFile() {
        File filePath = new File("data");
        filePath.mkdir();
        new File(filePath + "\\testFile.txt").delete();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testDownloadTextFromFile() throws Exception {
        textTreeCreator.downloadTextFromFile("");
    }

    @Test
    public void testCreateTextTree() throws Exception {
        SymbolSet result = (SymbolSet) textTreeCreator.createTextTree("data//testFile.txt",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertNotEquals(result, null);
    }
}