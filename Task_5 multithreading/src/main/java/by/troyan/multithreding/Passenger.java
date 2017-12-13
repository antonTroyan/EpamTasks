package by.troyan.multithreding;

import java.util.ArrayList;
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
        switch (random.nextInt(2)) {
            case 0:
                stayInBus();
                break;
            case 1:
                goToAnotherBus(busStop, passenger, bus);
                break;
        }
    }

    public void makeBusWaitersDoSmth(BusStop busStop, Passenger passenger, Bus bus) {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 0:
                stayInBusStop();
                break;
            case 1:
                sitInBus(busStop, passenger, bus);
                break;
        }
    }



    private void sitInBus(BusStop busStop, Passenger passenger, Bus bus) {

          busStop.passengersWishedToSitInBus.add(passenger);
        System.out.println(passenger + " added to list of passengersWishedToSitInBus");

//        List<Passenger> busStopPassangers = busStop.getBusStopPassengers();
//        bus.getBusPassengers().add(passenger);
//
//        System.out.println("Passenger " + name + " decided to sit in the Bus: " + bus);
//        System.out.println("Bus stop passengers before remove " + busStopPassangers);
//        busStopPassangers.remove(passenger);
//        System.out.println("Bus stop passengers after remove " + busStopPassangers);
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
        int toBus;
        do{
             toBus = random.nextInt(buses.size());
        } while (toBus == bus.getId());

        List<Passenger> passengersFromOriginalBus = bus.getBusPassengers();
        List<Passenger> passengersFromSecond = buses.get(toBus).getBusPassengers();

        passengersFromOriginalBus.remove(passenger);
        passengersFromSecond.add(passenger);

        System.out.println("Passenger " + name + " decided to change bus from " + bus +
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
