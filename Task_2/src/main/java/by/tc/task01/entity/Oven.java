package by.tc.task01.entity;

public class Oven extends Appliance{

    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private int height;
    private int width;

    public Oven(int powerConsumption, int weight, int capacity, int depth, int height, int width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oven oven = (Oven) o;

        if (powerConsumption != oven.powerConsumption) return false;
        if (weight != oven.weight) return false;
        if (capacity != oven.capacity) return false;
        if (depth != oven.depth) return false;
        if (height != oven.height) return false;
        return width == oven.width;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + capacity;
        result = 31 * result + depth;
        result = 31 * result + height;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        return "Oven{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
