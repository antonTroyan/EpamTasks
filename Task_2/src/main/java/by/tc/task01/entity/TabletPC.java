package by.tc.task01.entity;

public class TabletPC extends Appliance{

    private int batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private int color;

    public TabletPC(int batteryCapacity, int displayInches, int memoryRom, int flashMemoryCapacity, int color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (batteryCapacity != tabletPC.batteryCapacity) return false;
        if (displayInches != tabletPC.displayInches) return false;
        if (memoryRom != tabletPC.memoryRom) return false;
        if (flashMemoryCapacity != tabletPC.flashMemoryCapacity) return false;
        return color == tabletPC.color;
    }

    @Override
    public int hashCode() {
        int result = batteryCapacity;
        result = 31 * result + displayInches;
        result = 31 * result + memoryRom;
        result = 31 * result + flashMemoryCapacity;
        result = 31 * result + color;
        return result;
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color=" + color +
                '}';
    }
}
