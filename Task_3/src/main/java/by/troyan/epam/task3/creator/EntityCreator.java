package by.troyan.epam.task3.creator;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.exception.DataReadException;
import by.troyan.epam.task3.parser.TriangleParser;
import by.troyan.epam.task3.trianglereader.FileDataLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class EntityCreator {
    private final static Logger LOG = LogManager.getLogger("EntityCreator");
    private static ArrayList<Point> pointList = new ArrayList<>();

    public ArrayList<Triangle> getTriangleArrayList(String filename) throws DataReadException {
        fillTriangleList(filename);
        return TriangleSingleton.getInstance();
    }

    private void fillTriangleList(String filename) throws DataReadException {
        fillPointList(filename);
        int counter = 0;
        while (counter < pointList.size()) {
            Triangle triangle = new Triangle(pointList.get(counter++)
                    , pointList.get(counter++)
                    , pointList.get(counter++));
            TriangleSingleton.getInstance().add(triangle);
            LOG.info("Triangle was created " + triangle);
        }
    }

    private void fillPointList(String filename) throws DataReadException {
        ArrayList<Integer> dataArray = new TriangleParser()
                .parse(new FileDataLoader()
                .readLines(filename), " ");
        for (int i = 0; i < dataArray.size(); i++) {
            Point point = new Point(dataArray.get(i), dataArray.get(++i));
            pointList.add(point);
            LOG.info("Point was created " + point);
        }
    }
}
