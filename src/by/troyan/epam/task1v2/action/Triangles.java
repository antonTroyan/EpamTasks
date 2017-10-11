package by.troyan.epam.task1v2.action;
import by.troyan.epam.task1v2.entity.Triangle;

import static java.lang.Math.*;

public class Triangles {


    public static int calculateSquare(Triangle triangle) {
        return (int) (abs(((triangle.getB().getxCoordinate() - triangle.getA().getxCoordinate())
                * (triangle.getC().getyCoordinate() - triangle.getA().getyCoordinate()))
                        - ((triangle.getC().getxCoordinate() - triangle.getA().getxCoordinate()
                * (triangle.getB().getyCoordinate()  - triangle.getA().getyCoordinate())))) / 2);
    }

    public static int calculatePerimeter(Triangle triangle) {
        return (int) ((abs(sqrt(pow(triangle.getB().getxCoordinate() - triangle.getA().getxCoordinate(), 2)
                + pow(triangle.getB().getyCoordinate() - triangle.getA().getyCoordinate(), 2))))
                + (abs(sqrt(pow(triangle.getC().getxCoordinate() - triangle.getA().getxCoordinate(), 2)
                + pow(triangle.getC().getyCoordinate() - triangle.getA().getyCoordinate(), 2))))
                + (abs(sqrt(pow(triangle.getC().getxCoordinate() - triangle.getB().getxCoordinate(), 2)
                + pow(triangle.getC().getyCoordinate() - triangle.getB().getyCoordinate(), 2)))));

    }

    public static boolean isOnStraightLine(Triangle triangle) {
        if ((triangle.getA().getyCoordinate() == triangle.getB().getyCoordinate() && triangle.getB().getyCoordinate()
                == triangle.getC().getyCoordinate()) || (triangle.getA().getxCoordinate()
                == triangle.getB().getxCoordinate() && triangle.getB().getxCoordinate()
                == triangle.getC().getxCoordinate())) {
            return true;
        }
        return false;
    }

    public static boolean isRectangular(Triangle triangle){
        int sideAB = (int) abs(sqrt(pow(triangle.getB().getxCoordinate() - triangle.getA().getxCoordinate(), 2)
                + pow(triangle.getB().getyCoordinate() - triangle.getA().getyCoordinate(), 2)));
        int sideBC = (int) abs(sqrt(pow(triangle.getC().getxCoordinate() - triangle.getA().getxCoordinate(), 2)
                + pow(triangle.getC().getyCoordinate() - triangle.getA().getyCoordinate(), 2)));
        int sideCA = (int) abs(sqrt(pow(triangle.getC().getxCoordinate() - triangle.getB().getxCoordinate(), 2)
                + pow(triangle.getC().getyCoordinate() - triangle.getB().getyCoordinate(), 2)));

        int sideABSecDegree = sideAB*sideAB;
        int sideBCSecDegree = sideBC*sideBC;
        int sideCASecDegree = sideCA*sideCA;

        if ((sideABSecDegree == sideBC+sideCA)
                || (sideBCSecDegree == sideAB+sideCA)
                || (sideCASecDegree == sideAB + sideBC)){
            return true;
        }
        return false;

    }

}
