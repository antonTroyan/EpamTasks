package test.by.troyan.epam.task3.entity.formula;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.Perimeter;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PerimeterTest {

    Triangle triangle = new Triangle(new Point(10, 2)
            , new Point(-5, -6)
            , new Point(5, 20));

    @Test
    public void testCalculatePerimeter() throws Exception {
        Assert.assertEquals(new Perimeter().calculatePerimeter(triangle),63.53, 0.01);
    }

}