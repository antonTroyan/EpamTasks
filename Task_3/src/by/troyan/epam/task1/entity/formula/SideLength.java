package by.troyan.epam.task1.entity.formula;

import by.troyan.epam.task1.entity.Point;

import static java.lang.Math.abs;
import static java.lang.Math.hypot;

class SideLength {

    static double calculateSideLength (Point fst, Point sec){
        return abs(hypot(sec.getxCoordinate()-fst.getxCoordinate()
                , sec.getyCoordinate() - fst.getyCoordinate()));
    }
}
