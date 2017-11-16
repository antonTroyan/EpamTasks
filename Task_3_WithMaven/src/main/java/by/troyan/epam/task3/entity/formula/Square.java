package by.troyan.epam.task3.entity.formula;

import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.observer.OperationObserver;

import static java.lang.Math.abs;

public class Square implements OperationObserver {

    private double square;

    @Override
    public void valueChanged(Triangle triangle) {
        square = (abs(((triangle.getB().getxCoordinate() - triangle.getA().getxCoordinate())
                * (triangle.getC().getyCoordinate() - triangle.getA().getyCoordinate()))
                - ((triangle.getC().getxCoordinate() - triangle.getA().getxCoordinate()
                * (triangle.getB().getyCoordinate() - triangle.getA().getyCoordinate())))) / 2);
    }

    public double getSquare() {
        return square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square1 = (Square) o;

        return Double.compare(square1.square, square) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(square);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Square = " + square;
    }
}
