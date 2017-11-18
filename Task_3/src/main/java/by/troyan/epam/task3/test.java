package by.troyan.epam.task3;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.OnStraightLineCheck;
import by.troyan.epam.task3.entity.formula.Perimeter;

public class test {
    public static void main(String[] args) {

        Triangle triangle = new Triangle(new Point(1,2),
                new Point(4,8),
                new Point(100,-5));

        triangle.addObserver(new Perimeter());
        triangle.addObserver(new OnStraightLineCheck());
        System.out.println(triangle);
    }
}
