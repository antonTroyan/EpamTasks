package by.troyan.epam.task1.entity;

import by.troyan.epam.task1.entity.formula.*;
import by.troyan.epam.task1.entity.formula.observer.OperationObserver;

import java.util.ArrayList;
import java.util.Iterator;

public class Triangle {
    private Point A;
    private Point B;
    private Point C;

    private static long idCounter = 0;
    private long triangleID;

    private ArrayList<OperationObserver> observerList = new ArrayList<>();

    public Triangle(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
        triangleID = createID();
    }

    public void addObserver(OperationObserver observer) {
        observerList.add(observer);
        observer.valueChanged(this);
    }

    public static synchronized long createID()
    {
        return idCounter++;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }

    public void setA(Point a) {
        A = a;
        notifyObservers();
    }

    public void setB(Point b) {
        B = b;
        notifyObservers();
    }

    public void setC(Point c) {
        C = c;
        notifyObservers();
    }

    private void notifyObservers() {
        Iterator it = observerList.iterator();
        while (it.hasNext()) {
            ((OperationObserver) it.next()).valueChanged(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (A != null ? !A.equals(triangle.A) : triangle.A != null) return false;
        if (B != null ? !B.equals(triangle.B) : triangle.B != null) return false;
        if (C != null ? !C.equals(triangle.C) : triangle.C != null) return false;
        return observerList != null ? observerList.equals(triangle.observerList) : triangle.observerList == null;
    }

    @Override
    public int hashCode() {
        int result = A != null ? A.hashCode() : 0;
        result = 31 * result + (B != null ? B.hashCode() : 0);
        result = 31 * result + (C != null ? C.hashCode() : 0);
        result = 31 * result + (observerList != null ? observerList.hashCode() : 0);
        return result;
    }

    public String toString() {
        String result = "Triangle. id = " + triangleID + "\n";
        Iterator it = observerList.iterator();
        while (it.hasNext()) {
            result = result + (it.next()).toString() + '\n';
        }
        return result;
    }
}
