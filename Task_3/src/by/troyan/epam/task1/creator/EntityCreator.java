package by.troyan.epam.task1.creator;

import by.troyan.epam.task1.entity.Triangle;
import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.FileNotExistExeption;
import by.troyan.epam.task1.exception.NoFileNameException;
import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.parser.TriangleParser;
import by.troyan.epam.task1.trianglereader.FileDataDownloader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class EntityCreator {
    private static Logger log = LogManager.getLogger("EntityCreator");
    private static ArrayList<Point> pointList = new ArrayList<>();
    private String filename;

    public EntityCreator(String filename) {
        this.filename = filename;
    }

    public ArrayList<Triangle> getTriangleArrayList() throws NoFileNameException, FileNotExistExeption, FileIsEmptyException {
        fillTriangleList();
        return TriangleSingleton.getInstance();
    }

    private void fillTriangleList() throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {
        fillPointList();
        int counter = 0;
        while (counter < pointList.size()) {
            Triangle t = new Triangle(pointList.get(counter++)
                    , pointList.get(counter++)
                    , pointList.get(counter++));
            TriangleSingleton.getInstance().add(t);
            log.info("Triangle was created " + t);
        }
    }

    private void fillPointList() throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {
        FileDataDownloader fileDataDownloader = new FileDataDownloader();
        TriangleParser triangleParser = new TriangleParser();
        ArrayList<Integer> dataArray = triangleParser.parse(fileDataDownloader.readLines(filename), " ");
        for (int i = 0; i < dataArray.size(); i++) {
            Point p = new Point(dataArray.get(i), dataArray.get(++i));
            pointList.add(p);
            log.info("Point was created " + p);
        }
    }

}
