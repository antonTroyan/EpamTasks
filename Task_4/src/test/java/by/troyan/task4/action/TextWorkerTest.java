package by.troyan.task4.action;

import by.troyan.task4.ConstantTestValues;
import by.troyan.task4.entity.component.Component;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TextWorkerTest {
    private TextWorker textWorker = new TextWorker();
    private static Component TEST_COMPONENT;

    @BeforeTest
    public static void loadFile() {
        try (PrintStream out = new PrintStream(new FileOutputStream("data//testFile.txt"))) {
            out.print(ConstantTestValues.TEST_TEXT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void init(){
        TextTreeCreator textTreeCreator = new TextTreeCreator();
        TEST_COMPONENT = textTreeCreator.createTextTree("data//testFile.txt",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);
    }


    @AfterTest
    public static void deleteFile() {
        File filePath = new File("data");
        filePath.mkdir();
        new File(filePath + "\\testFile.txt").delete();
    }

    @Test
    public void testCountWithSimilarWords() throws Exception {
        Assert.assertEquals(textWorker.countSentenciesWithSimilarWords(TEST_COMPONENT), 9);
    }

    @Test
    public void testCreateSortedSentenciesByLexemsAmmount() throws Exception {
        Assert.assertEquals(textWorker.sortSentenciesByLexemsAmmount(TEST_COMPONENT),
                ConstantTestValues.RIGHT_SENTENCE_SORT);
    }

    @Test
    public void testSortLexemsInAlphobetic() throws Exception {
        Assert.assertEquals(textWorker.sortLexemsInAlphobetic(TEST_COMPONENT),
                ConstantTestValues.RIGHT_LEXEMS_IN_ALPHOBETIC);
    }
}