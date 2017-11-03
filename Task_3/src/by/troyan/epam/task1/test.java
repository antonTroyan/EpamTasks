package by.troyan.epam.task1;

import by.troyan.epam.task1.creator.EntityCreator;
import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.entity.Triangle;
import by.troyan.epam.task1.entity.formula.Perimeter;
import by.troyan.epam.task1.entity.formula.Rectangular;
import by.troyan.epam.task1.entity.formula.Square;
import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.FileNotExistExeption;
import by.troyan.epam.task1.exception.NoFileNameException;



public class test {
    public static void main(String[] args) throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {
//        EntityCreator entityCreator = new EntityCreator("data//triangleData.txt");
//        entityCreator.fillTriangleList();
//        System.out.println(entityCreator.getTriangleByIndex(0));

        Triangle triangle = new Triangle(new Point(1, 2)
                , new Point(4, 2)
                , new Point(-5, 2));

        System.out.println(triangle);
        triangle.addObserver(new Perimeter());
        triangle.addObserver(new Square());
        triangle.setA(new Point(1,6));
        System.out.println(triangle);
        triangle.setC(new Point(2,7));
        System.out.println(triangle);


        Triangle triangle1 = new Triangle(new Point(-2,4)
                , new Point(4,100)
                , new Point(-5,3));

        System.out.println(triangle1);
        triangle1.addObserver(new Rectangular());
        triangle1.addObserver(new Perimeter());
        System.out.println(triangle1);
        triangle1.setC(new Point(-12,4));
        System.out.println(triangle1);

    }
}
