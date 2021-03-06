package by.troyan.epam.task3.entity.formula;

import by.troyan.epam.task3.entity.Triangle;
import by.troyan.epam.task3.entity.formula.observer.OperationObserver;

public class OnStraightLineCheck implements OperationObserver {

    private boolean isOnStraightLine;

    @Override
    public void valueChanged(Triangle triangle) {
        isOnStraightLine = checkIsOnStraightLine(triangle);
    }

    public boolean checkIsOnStraightLine(Triangle triangle){
        return  ((triangle.getA().getyCoordinate()
                == triangle.getB().getyCoordinate() && triangle.getB().getyCoordinate()
                == triangle.getC().getyCoordinate()) || (triangle.getA().getxCoordinate()
                == triangle.getB().getxCoordinate() && triangle.getB().getxCoordinate()
                == triangle.getC().getxCoordinate()));
    }

    public boolean isOnStraightLine() {
        return isOnStraightLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OnStraightLineCheck that = (OnStraightLineCheck) o;

        return isOnStraightLine == that.isOnStraightLine;
    }

    @Override
    public int hashCode() {
        return (isOnStraightLine ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Is on straight line? = " + isOnStraightLine;
    }
}
