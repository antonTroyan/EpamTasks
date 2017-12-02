package by.troyan.task4.calculating;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PolishFormConverterTest {

    @Test
    public void testSortingStationAddition() throws Exception {
        String result = PolishFormConverter.sortingStation("2+2+16", PolishFormConverter.MAIN_MATH_OPERATIONS);

        Assert.assertEquals(result,"2 2 + 16 +");
    }

    @Test
    public void testSortingStationSubtraction() throws Exception {
        String result = PolishFormConverter.sortingStation("2-2-16", PolishFormConverter.MAIN_MATH_OPERATIONS);

        Assert.assertEquals(result,"2 2 - 16 -");
    }

    @Test
    public void testSortingStationMultiplication() throws Exception {
        String result = PolishFormConverter.sortingStation("2*2*16", PolishFormConverter.MAIN_MATH_OPERATIONS);

        Assert.assertEquals(result,"2 2 * 16 *");
    }

    @Test
    public void testSortingStationDivision() throws Exception {
        String result = PolishFormConverter.sortingStation("16-2-2", PolishFormConverter.MAIN_MATH_OPERATIONS);

        Assert.assertEquals(result,"16 2 - 2 -");
    }

    @Test
    public void testSortingStationBrackets() throws Exception {
        String result = PolishFormConverter.sortingStation("(2+2)*16", PolishFormConverter.MAIN_MATH_OPERATIONS);

        Assert.assertEquals(result,"2 2 + 16 *");
    }
}