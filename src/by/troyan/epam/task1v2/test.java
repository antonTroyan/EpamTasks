package by.troyan.epam.task1v2;

import by.troyan.epam.task1v2.creator.Creator;
import by.troyan.epam.task1v2.exception.FileIsEmptyException;
import by.troyan.epam.task1v2.exception.NoFileNameException;


public class test {
    public static void main(String[] args) throws FileIsEmptyException, NoFileNameException {
        Creator creator = new Creator();
        creator.fillTriangleList();
        System.out.println(creator.getTriangleByIndex(0));

    }
}
