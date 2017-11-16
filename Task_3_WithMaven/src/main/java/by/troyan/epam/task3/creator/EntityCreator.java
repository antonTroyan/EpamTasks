package by.troyan.epam.task3.creator;

import by.troyan.epam.task3.entity.Point;
import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.exception.FileIsEmptyException;
import by.troyan.epam.task3.exception.FileNotExistExeption;
import by.troyan.epam.task3.exception.NoFileNameException;
import by.troyan.epam.task3.parser.TriangleParser;
import by.troyan.epam.task3.trianglereader.FileDataDownloader;
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
            Triangle triangle = new Triangle(pointList.get(counter++)
                    , pointList.get(counter++)
                    , pointList.get(counter++));
            TriangleSingleton.getInstance().add(triangle);
            log.info("Triangle was created " + triangle);
        }
    }

    private void fillPointList() throws FileIsEmptyException, NoFileNameException, FileNotExistExeption {
        ArrayList<Integer> dataArray = new TriangleParser()
                .parse(new FileDataDownloader()
                .readLines(filename), " ");
        for (int i = 0; i < dataArray.size(); i++) {
            Point point = new Point(dataArray.get(i), dataArray.get(++i));
            pointList.add(point);
            log.info("Point was created " + point);
        }
    }

}
