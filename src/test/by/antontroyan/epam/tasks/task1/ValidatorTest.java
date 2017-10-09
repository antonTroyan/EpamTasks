package test.by.antontroyan.epam.tasks.task1;

import by.antontroyan.epam.tasks.task1.Validator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatorTest {


    @Test
    public void testIsRight() throws Exception {
        String test = "5.0 6.0 7.0";
        Assert.assertEquals(Validator.isRight(test), true);
    }
    @Test
    public void testIsRightIncorrectDataAddChar() throws Exception {
        String test = "5.f0 6.0 7.0";
        Assert.assertEquals(Validator.isRight(test), false);
    }
    @Test
    public void testIsRightIncorrectDataNotDouble() throws Exception {
        String test = "5 6.0 7.0";
        Assert.assertEquals(Validator.isRight(test), true);
    }
    @Test
    public void testIsRightIncorrectRadius() throws Exception {
        String test = "-5 6.0 7.0";
        Assert.assertEquals(Validator.isRight(test), false);
    }
    @Test
    public void testIsRightNotFullData() throws Exception {
        String test = "5.0 6.0";
        Assert.assertEquals(Validator.isRight(test), false);
    }


}