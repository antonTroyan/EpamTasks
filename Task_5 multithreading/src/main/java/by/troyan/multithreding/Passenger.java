package by.troyan.multithreding;

import java.util.List;
import java.util.Random;

public class Passenger {
    private long passengerId;
    private static long idCounter = 0;
    private String name;

    public Passenger(String name) {
        passengerId = createID();
        this.name = name;
    }

    public static synchronized long createID() {
        return idCounter++;
    }

    public void makePassangersDoSmth(BusStop busStop, Passenger passenger, Bus bus) {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                stayInBus();
                break;
            case 1:
                goToAnotherBus(busStop, passenger, bus);
                break;
            case 2:
                stayInBusStop();
                break;
            default:
                System.out.println("default action");
        }
    }

    public void makeBusWaitersDoSmth(BusStop busStop, Passenger passenger) {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0:
                stayInBusStop();
                break;
            case 1:
                sitInBus(busStop, passenger);
                break;
            default:
                System.out.println("default action");
        }
    }


    private synchronized void sitInBus(BusStop busStop, Passenger passenger) {

        List<Passenger> busStopPassangers = busStop.getBusStopPassengers();
        Random random = new Random();
        int toBus = random.nextInt(busStop.getBuses().size());

        List<Bus> busesOnBusStation = busStop.getBuses();
        Bus bus = busesOnBusStation.get(toBus);
        bus.getBusPassengers().add(passenger);

        System.out.println("Bus stop passangers before remove " + busStopPassangers);
        busStopPassangers.remove(passenger);
        System.out.println("Passenger " + name + " get away from bus Stop " +
                " and go to the " + bus);
        System.out.println("Bus stop passangers after remove " + busStopPassangers);
    }

    private void stayInBus() {
        System.out.println("Passenger " + name + " decided to stay in bus");
    }

    private void goToAnotherBus (BusStop busStop, Passenger passenger, Bus bus) {

        if(busStop.getBuses().size() <= 1) {
            System.out.println("there only 1 bus on the station");
            return;
        }

        List<Bus> buses = busStop.getBuses();
        Random random = new Random();

        int toBus = random.nextInt(buses.size());

        List<Passenger> passengersFromOriginalBus = bus.getBusPassengers();
        List<Passenger> passengersFromSecond = buses.get(toBus).getBusPassengers();

        passengersFromOriginalBus.remove(passenger);
        passengersFromSecond.add(passenger);

        System.out.println("TPassenger " + name + " get away from bus " + bus +
                " and go to the " + buses.get(toBus));
    }

    private void stayInBusStop() {
        System.out.println("Passenger " + name + " decided to stay in bus Stop ");
    }

    @Override
    public String toString() {
        return "Passenger " +
                name;
    }
}
