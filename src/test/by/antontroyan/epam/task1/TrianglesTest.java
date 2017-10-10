package test.by.antontroyan.epam.task1;

import by.antontroyan.epam.task1.Triangle;
import by.antontroyan.epam.task1.Triangles;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrianglesTest {

    Triangle triangle = new Triangle(5,2,4,3,1,2);
    @Test
    public void testCalculateSquare() throws Exception {
        Assert.assertEquals(Triangles.calculateSquare(triangle),2);
    }

    @Test
    public void testCalculatePerimeter() throws Exception {
        Assert.assertEquals(Triangles.calculatePerimeter(triangle),8);
    }

    @Test
    public void testIsOnStraightLine() throws Exception {
        Assert.assertEquals(Triangles.isOnStraightLine(triangle),false);
    }

    @Test
    public void testIsRectangular() throws Exception {
        Assert.assertEquals(Triangles.isRectangular(triangle),false);
    }

}