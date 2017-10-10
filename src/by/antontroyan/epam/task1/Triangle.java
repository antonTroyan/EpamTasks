package by.antontroyan.epam.task1;

public class Triangle {
    private int topAX;
    private int topAY;
    private int topBX;
    private int topBY;
    private int topCX;
    private int topCY;

    public Triangle(int topAX, int topAY, int topBX, int topBY, int topCX, int topCY) {
        this.topAX = topAX;
        this.topAY = topAY;
        this.topBX = topBX;
        this.topBY = topBY;
        this.topCX = topCX;
        this.topCY = topCY;
    }

    public int getTopAX() {
        return topAX;
    }

    public int getTopAY() {
        return topAY;
    }

    public int getTopBX() {
        return topBX;
    }

    public int getTopBY() {
        return topBY;
    }

    public int getTopCX() {
        return topCX;
    }

    public int getTopCY() {
        return topCY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (topAX != triangle.topAX) return false;
        if (topAY != triangle.topAY) return false;
        if (topBX != triangle.topBX) return false;
        if (topBY != triangle.topBY) return false;
        if (topCX != triangle.topCX) return false;
        return topCY == triangle.topCY;
    }

    @Override
    public int hashCode() {
        int result = topAX;
        result = 31 * result + topAY;
        result = 31 * result + topBX;
        result = 31 * result + topBY;
        result = 31 * result + topCX;
        result = 31 * result + topCY;
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "[topAX=" + topAX +
                ", topAY=" + topAY +
                "], [topBX=" + topBX +
                ", topBY=" + topBY +
                "], [topCX=" + topCX +
                ", topCY=" + topCY +
                "]}";
    }
}
