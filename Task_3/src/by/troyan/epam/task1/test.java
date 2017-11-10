package by.troyan.epam.task1;

import by.troyan.epam.task1.creator.EntityCreator;
import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.entity.Triangle;
import by.troyan.epam.task1.entity.formula.Square;
import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.FileNotExistExeption;
import by.troyan.epam.task1.exception.NoFileNameException;

import java.util.ArrayList;


public class test {
    public static void main(String[] args) throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {

        EntityCreator entityCreator = new EntityCreator("data//triangleData.txt");
        ArrayList<Triangle> arrayListTriangle = entityCreator.getTriangleArrayList();


        for(Triangle triangle: arrayListTriangle){
            System.out.println(triangle);
        }

        Triangle triangle = arrayListTriangle.get(0);
        triangle.addObserver(new Square());
        System.out.println(triangle);
        triangle.setC(new Point(3,5));
        System.out.println("new " + triangle);

    }
}
