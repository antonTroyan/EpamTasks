package by.troyan.epam.task3.entity;

import by.troyan.epam.task3.entity.formula.observer.OperationObserver;

import java.util.ArrayList;
import java.util.Iterator;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    private static long idCounter = 0;
    private long triangleID;

    private ArrayList<OperationObserver> observerList = new ArrayList<>();

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObservers();
    }

    public void setB(Point b) {
        this.b = b;
        notifyObservers();
    }

    public void setC(Point c) {
        this.c = c;
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

        if (triangleID != triangle.triangleID) return false;
        if (a != null ? !a.equals(triangle.a) : triangle.a != null) return false;
        if (b != null ? !b.equals(triangle.b) : triangle.b != null) return false;
        if (c != null ? !c.equals(triangle.c) : triangle.c != null) return false;
        return observerList != null ? observerList.equals(triangle.observerList) : triangle.observerList == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (int) (triangleID ^ (triangleID >>> 32));
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
