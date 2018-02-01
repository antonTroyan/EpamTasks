package by.troyan.epam.task1.creator;

import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.FileNotExistExeption;
import by.troyan.epam.task1.exception.NoFileNameException;
import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.entity.Triangle;
import by.troyan.epam.task1.parser.TriangleParser;
import by.troyan.epam.task1.trianglereader.FileDataDownloader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EntityCreator {
    private static Logger log = LogManager.getLogger("EntityCreator");
    private static List<Triangle> triangleList = new ArrayList<>();
    private static List<Point> pointList = new ArrayList<>();
    private String filename;

    public EntityCreator(String filename) {
        this.filename = filename;
    }

    public void fillTriangleList () throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {
        fillPointList();
        for (int i = 0; i < 3; ){
            Point pointA = pointList.get(i++);
            Point pointB = pointList.get(i++);
            Point pointC = pointList.get(i++);
            Triangle createdTriangle = new Triangle(pointA,pointB,pointC);

            triangleList.add(createdTriangle);
            log.info("Triangle was created " + createdTriangle);
        }
    }

    public void fillPointList () throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {
        FileDataDownloader fileDataDownloader = new FileDataDownloader();
        TriangleParser triangleParser = new TriangleParser();

        List <Integer> dataArray = triangleParser.parse(fileDataDownloader
                                                      .readLines(filename), " ");

        for (int counter = 0; counter < dataArray.size(); counter++){
            int xCoordinate = dataArray.get(counter);
            int yCoordinate = dataArray.get(counter);
            Point point = new Point(xCoordinate,dataArray.get(yCoordinate));

            pointList.add(point);
            log.info("Point was created " + point);
        }
    }

    public Triangle getTriangleByIndex(int index) {
        return triangleList.get(index);
    }

    public Point getPointByIndex(int index) {
        return pointList.get(index);
    }
}
