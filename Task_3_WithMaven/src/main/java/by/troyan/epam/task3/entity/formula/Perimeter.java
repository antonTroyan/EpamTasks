package by.troyan.epam.task3.entity.formula;


import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.observer.OperationObserver;

public class Perimeter implements OperationObserver {

    private double perimeter;

    @Override
    public void valueChanged(Triangle triangle) {
        perimeter = calculatePerimeter(triangle);
    }

    private double calculatePerimeter (Triangle triangle){
        double sideAB = SideLength.calculateSideLength(triangle.getA(), triangle.getB());
        double sideBC = SideLength.calculateSideLength(triangle.getB(), triangle.getC());
        double sideCA = SideLength.calculateSideLength(triangle.getC(), triangle.getA());
        return sideAB + sideBC + sideCA;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perimeter perimeter1 = (Perimeter) o;

        return Double.compare(perimeter1.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(perimeter);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Perimeter = " + perimeter;
    }


}
