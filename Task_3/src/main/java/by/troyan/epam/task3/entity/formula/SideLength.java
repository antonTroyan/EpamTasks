package by.troyan.epam.task3.entity.formula;

import by.troyan.epam.task3.entity.Point;

import static java.lang.Math.abs;
import static java.lang.Math.hypot;

class SideLength {

    static double calculateSideLength (Point first, Point second){
        return abs(hypot(second.getxCoordinate()-first.getxCoordinate()
                , second.getyCoordinate() - first.getyCoordinate()));
    }
}

