package by.troyan.epam.task1.action;
import by.troyan.epam.task1.entity.Point;
import by.troyan.epam.task1.entity.Triangle;
import static java.lang.Math.*;

public class Triangles {

    public static int calculateSideLength (Point fst, Point sec){
        return (int)abs(hypot(sec.getxCoordinate()-fst.getxCoordinate()
                , sec.getyCoordinate() - fst.getyCoordinate()));
    }

    public static int calculateSquare(Triangle triangle) {
        return (int) (abs(((triangle.getB().getxCoordinate() - triangle.getA().getxCoordinate())
                * (triangle.getC().getyCoordinate() - triangle.getA().getyCoordinate()))
                        - ((triangle.getC().getxCoordinate() - triangle.getA().getxCoordinate()
                * (triangle.getB().getyCoordinate()  - triangle.getA().getyCoordinate())))) / 2);
    }

    public static int calculatePerimeter(Triangle triangle) {
        int sideAB = calculateSideLength(triangle.getA(), triangle.getB());
        int sideBC = calculateSideLength(triangle.getB(), triangle.getC());
        int sideCA = calculateSideLength(triangle.getC(), triangle.getA());
        return sideAB + sideBC + sideCA;
    }

    public static boolean isOnStraightLine(Triangle triangle) {

        return ((triangle.getA().getyCoordinate() == triangle.getB().getyCoordinate() && triangle.getB().getyCoordinate()
                == triangle.getC().getyCoordinate()) || (triangle.getA().getxCoordinate()
                == triangle.getB().getxCoordinate() && triangle.getB().getxCoordinate()
                == triangle.getC().getxCoordinate()));
    }

    public static boolean isRectangular(Triangle triangle){
        int sideAB = calculateSideLength(triangle.getA(), triangle.getB());
        int sideBC = calculateSideLength(triangle.getB(), triangle.getC());
        int sideCA = calculateSideLength(triangle.getC(), triangle.getA());

        int sideABSecDegree = sideAB*sideAB;
        int sideBCSecDegree = sideBC*sideBC;
        int sideCASecDegree = sideCA*sideCA;

        return ((sideABSecDegree == sideBC+sideCA)
                || (sideBCSecDegree == sideAB+sideCA)
                || (sideCASecDegree == sideAB + sideBC));
    }
}
