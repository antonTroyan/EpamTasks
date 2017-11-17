package test.by.troyan.epam.task3.entity;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.Perimeter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {

    Triangle triangle = new Triangle(new Point(10, 2)
            , new Point(-5, -6)
            , new Point(5, 20));
    Perimeter perimeter = new Perimeter();

    @Test
    public void testAddObserver() throws Exception {
        triangle.addObserver(perimeter);
        assertEquals(perimeter.getPerimeter(),63.53,0.01);
    }

    @Test
    public void testDataModify() throws Exception {
        triangle.addObserver(perimeter);
        triangle.setB(new Point(5,9));
        assertEquals(perimeter.getPerimeter(),38.28,0.01);
    }

}