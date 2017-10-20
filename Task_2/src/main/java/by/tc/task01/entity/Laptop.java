package by.tc.task01.entity;

public class Laptop extends Appliance{

	private int batteryCapacity;
    private int os;
    private int memoryRom;
    private int systemMemory;
    private int cpu;
    private int displayInches;

    public Laptop(int batteryCapacity, int os, int memoryRom, int systemMemory, int cpu, int displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getOs() {
        return os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public int getCpu() {
        return cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (batteryCapacity != laptop.batteryCapacity) return false;
        if (os != laptop.os) return false;
        if (memoryRom != laptop.memoryRom) return false;
        if (systemMemory != laptop.systemMemory) return false;
        if (cpu != laptop.cpu) return false;
        return displayInches == laptop.displayInches;
    }

    @Override
    public int hashCode() {
        int result = batteryCapacity;
        result = 31 * result + os;
        result = 31 * result + memoryRom;
        result = 31 * result + systemMemory;
        result = 31 * result + cpu;
        result = 31 * result + displayInches;
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", os=" + os +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                '}';
    }
}
