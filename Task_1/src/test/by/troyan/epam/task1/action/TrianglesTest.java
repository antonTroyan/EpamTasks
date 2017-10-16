package test.by.troyan.epam.task1.action;

import by.troyan.epam.task1.action.Triangles;
import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TrianglesTest {

    Triangle triangle = new Triangle(new Point(10, 2)
            , new Point(-5, -6)
            , new Point(5, 20));


    @Test
    public void testCalculateSquare() throws Exception {
        Assert.assertEquals(Triangles.calculateSquare(triangle),177, 0.01);
    }

    @Test
    public void testCalculatePerimeter() throws Exception {
        Assert.assertEquals(Triangles.calculatePerimeter(triangle),62, 0.01);
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