package by.tc.task01.entity;

public class VacuumCleaner extends Appliance{

    private int powerConsumption;
    private int filterType;
    private int bagType;
    private int wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner(int powerConsumption, int filterType, int bagType, int wandType, int motorSpeedRegulation, int cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public int getFilterType() {
        return filterType;
    }

    public int getBagType() {
        return bagType;
    }

    public int getWandType() {
        return wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (powerConsumption != that.powerConsumption) return false;
        if (filterType != that.filterType) return false;
        if (bagType != that.bagType) return false;
        if (wandType != that.wandType) return false;
        if (motorSpeedRegulation != that.motorSpeedRegulation) return false;
        return cleaningWidth == that.cleaningWidth;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + filterType;
        result = 31 * result + bagType;
        result = 31 * result + wandType;
        result = 31 * result + motorSpeedRegulation;
        result = 31 * result + cleaningWidth;
        return result;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "powerConsumption=" + powerConsumption +
                ", filterType=" + filterType +
                ", bagType=" + bagType +
                ", wandType=" + wandType +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }
}
