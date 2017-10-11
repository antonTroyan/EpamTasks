package by.troyan.epam.task1v2.creator;

import by.troyan.epam.task1v2.exception.FileIsEmptyException;
import by.troyan.epam.task1v2.exception.NoFileNameException;
import by.troyan.epam.task1v2.entity.Point;
import by.troyan.epam.task1v2.entity.Triangle;
import by.troyan.epam.task1v2.parser.TriangleParser;
import by.troyan.epam.task1v2.trianglereader.FileDataDownloader;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Creator {
    private static ArrayList<Triangle> triangleList = new ArrayList<>();
    private static ArrayList<Point> pointList = new ArrayList<>();
    private static Logger log = Logger.getLogger("Creator");

    FileDataDownloader fileDataDownloader = new FileDataDownloader();
    TriangleParser triangleParser = new TriangleParser();


    public void fillTriangleList () throws FileIsEmptyException, NoFileNameException {
        fillPointList();
        for (int i = 0; i < 3; ){
            Triangle t = new Triangle(pointList.get(i++),pointList.get(i++),pointList.get(i++));
            triangleList.add(t);
            log.info("Triangle was created " + t);
        }
    }

    public void fillPointList () throws FileIsEmptyException, NoFileNameException {

        ArrayList <Integer> dataArray = triangleParser.parse(fileDataDownloader.readLines("triangleData.txt"));
        for (int i = 0; i < dataArray.size(); i++){
            Point p = new Point(dataArray.get(i),dataArray.get(++i));
            pointList.add(p);
            log.info("Point was created " + p);
        }
    }

    public Triangle getTriangleByIndex(int index) {
        return triangleList.get(index);
    }

    public Point getPointByIndex(int index) {
        return pointList.get(index);
    }
}
