package by.troyan.epam.task3.entity.formula;


import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.observer.OperationObserver;

public class Rectangular implements OperationObserver {

    private boolean isRectangular;

    @Override
    public void valueChanged(Triangle triangle) {
        double sideAB = SideLength.calculateSideLength(triangle.getA(), triangle.getB());
        double sideBC = SideLength.calculateSideLength(triangle.getB(), triangle.getC());
        double sideCA = SideLength.calculateSideLength(triangle.getC(), triangle.getA());

        double sideABSecDegree = sideAB*sideAB;
        double sideBCSecDegree = sideBC*sideBC;
        double sideCASecDegree = sideCA*sideCA;

        isRectangular = ((sideABSecDegree == sideBC+sideCA)
                || (sideBCSecDegree == sideAB+sideCA)
                || (sideCASecDegree == sideAB + sideBC));
    }

    public boolean isRectangular() {
        return isRectangular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangular that = (Rectangular) o;

        return isRectangular == that.isRectangular;
    }

    @Override
    public int hashCode() {
        return (isRectangular ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Is rectangular? = " + isRectangular;
    }
}
