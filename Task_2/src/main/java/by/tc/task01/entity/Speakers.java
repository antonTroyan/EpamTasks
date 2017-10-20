package by.tc.task01.entity;

public class Speakers extends Appliance{

    private int powerConsumption;
    private int numberOfSpeakers;
    private int frequencyRange;
    private int cordLength;

    public Speakers(int powerConsumption, int numberOfSpeakers, int frequencyRange, int cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public int getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(int frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speakers speakers = (Speakers) o;

        if (powerConsumption != speakers.powerConsumption) return false;
        if (numberOfSpeakers != speakers.numberOfSpeakers) return false;
        if (frequencyRange != speakers.frequencyRange) return false;
        return cordLength == speakers.cordLength;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + numberOfSpeakers;
        result = 31 * result + frequencyRange;
        result = 31 * result + cordLength;
        return result;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRange=" + frequencyRange +
                ", cordLength=" + cordLength +
                '}';
    }
}
