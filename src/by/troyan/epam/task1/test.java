package by.troyan.epam.task1;

import by.troyan.epam.task1.creator.Creator;
import by.troyan.epam.task1.exception.FileCanNotBeFoundedException;
import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.NoFileNameException;


public class test {
    public static void main(String[] args) throws FileIsEmptyException, NoFileNameException, FileCanNotBeFoundedException {
        Creator creator = new Creator();
        creator.fillTriangleList();
        System.out.println(creator.getTriangleByIndex(0));


    }
}
