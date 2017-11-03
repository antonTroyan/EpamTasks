package test.by.troyan.epam.task1.action;


import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.entity.Triangle;
import by.troyan.epam.task1.entity.formula.OnStraightLine;
import by.troyan.epam.task1.entity.formula.Perimeter;
import by.troyan.epam.task1.entity.formula.Rectangular;
import by.troyan.epam.task1.entity.formula.Square;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TrianglesTest {

    Triangle triangle = new Triangle(new Point(10, 2)
                                   , new Point(-5, -6)
                                   , new Point(5, 20));

    @Test
    public void testCalculateSquare() throws Exception {
        Square square = new Square();
        square.valueChanged(triangle);
        Assert.assertEquals(square.getSquare(),177.5, 0.01);
    }

    @Test
    public void testCalculatePerimeter() throws Exception {
        Perimeter perimeter = new Perimeter();
        perimeter.valueChanged(triangle);
        Assert.assertEquals(perimeter.getPerimeter(),63.53, 0.01);
    }

    @Test
    public void testIsOnStraightLine() throws Exception {
        OnStraightLine onStraightLine = new OnStraightLine();
        onStraightLine.valueChanged(triangle);
        Assert.assertEquals(onStraightLine.isOnStraightLine(),false);
    }

    @Test
    public void testIsRectangular() throws Exception {
        Rectangular rectangular = new Rectangular();
        rectangular.valueChanged(triangle);
        Assert.assertEquals(rectangular.isRectangular(),false);
    }
}