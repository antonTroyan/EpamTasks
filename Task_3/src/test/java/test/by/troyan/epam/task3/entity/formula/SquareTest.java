package test.by.troyan.epam.task3.entity.formula;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SquareTest {

    Triangle triangle = new Triangle(new Point(10, 2)
            , new Point(-5, -6)
            , new Point(5, 20));

    @Test
    public void testGetSquare() throws Exception {
        Assert.assertEquals(new Square().calculateSquare(triangle),177.5, 0.01);
    }

}