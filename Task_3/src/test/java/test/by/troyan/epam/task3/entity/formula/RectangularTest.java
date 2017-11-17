package test.by.troyan.epam.task3.entity.formula;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.RectangularCheck;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangularTest {

    Triangle triangle = new Triangle(new Point(10, 2)
            , new Point(-5, -6)
            , new Point(5, 20));

    @Test
    public void testCheckIsRectangular() throws Exception {
        Assert.assertEquals(new RectangularCheck().checkIsRectangular(triangle),false);
    }

}