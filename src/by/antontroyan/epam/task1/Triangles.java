package by.antontroyan.epam.task1;
import static java.lang.Math.*;

public class Triangles {

    public static int calculateSquare(Triangle triangle) {
        return abs(((triangle.getTopBX() - triangle.getTopAX()) * (triangle.getTopCY() - triangle.getTopAY()))
                - ((triangle.getTopCX() - triangle.getTopAX() * (triangle.getTopBY() - triangle.getTopAY())))) / 2;
    }

    public static int calculatePerimeter(Triangle triangle) {
        return (int) ((abs(sqrt(pow(triangle.getTopBX() - triangle.getTopAX(), 2)
                + pow(triangle.getTopBY() - triangle.getTopAY(), 2))))
                + (abs(sqrt(pow(triangle.getTopCX() - triangle.getTopAX(), 2)
                + pow(triangle.getTopCY() - triangle.getTopAY(), 2))))
                + (abs(sqrt(pow(triangle.getTopCX() - triangle.getTopBX(), 2)
                + pow(triangle.getTopCY() - triangle.getTopBY(), 2)))));

    }

    public static boolean isOnStraightLine(Triangle triangle) {
        if ((triangle.getTopAY() == triangle.getTopBY() && triangle.getTopBY() == triangle.getTopCY())
                || (triangle.getTopAX() == triangle.getTopBX() && triangle.getTopBX() == triangle.getTopCX())) {
            return true;
        }
        return false;
    }

    public static boolean isRectangular(Triangle triangle){
        int sideAB = (int) abs(sqrt(pow(triangle.getTopBX() - triangle.getTopAX(), 2)
                + pow(triangle.getTopBY() - triangle.getTopAY(), 2)));
        int sideBC = (int) abs(sqrt(pow(triangle.getTopCX() - triangle.getTopAX(), 2)
                + pow(triangle.getTopCY() - triangle.getTopAY(), 2)));
        int sideCA = (int) abs(sqrt(pow(triangle.getTopCX() - triangle.getTopBX(), 2)
                + pow(triangle.getTopCY() - triangle.getTopBY(), 2)));

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
