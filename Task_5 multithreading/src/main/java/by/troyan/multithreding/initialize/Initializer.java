package by.troyan.multithreding.initialize;

import by.troyan.multithreding.entity.Bus;
import by.troyan.multithreding.entity.BusStop;
import by.troyan.multithreding.entity.Passenger;
import by.troyan.multithreding.entity.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


public class Initializer {
    private List<Bus> buses;

    public void initialize(String filename) {
        buses = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        int maxBusesOnBusStop = checkInfoFromFile(filename,"MaxBusesOnBusStop:");
        Semaphore semaphore = new Semaphore(maxBusesOnBusStop);

        List<BusStop> busStops = new ArrayList<>();
        int maxBusStopsAmount = checkInfoFromFile(filename, "BusStopAmount:");

        for (int busStopCounter = 0; busStopCounter < maxBusStopsAmount; busStopCounter++) {
            BusStop busStop = new BusStop(createListOfPassengersFromFile(filename,
                    "PassengersForBusStop" + busStopCounter + ":"));

            busStops.add(busStop);
            Route.MINSK_LONDON.addBusStop(busStop);
        }

        int maxBusAmount = checkInfoFromFile(filename, "BusesAmount:");
        for (int i = 0; i < maxBusAmount; i++) {
            List<Passenger> passengerList = createListOfPassengersFromFile(filename,
                    "PassengersForBus" + i + ":");

            Bus bus = new Bus(Route.MINSK_LONDON
                    , passengerList
                    , semaphore
                    , lock);
            buses.add(bus);
        }
    }


    private int checkInfoFromFile(String filename, String criteria) {
        int result;
        Parser parser = new Parser();
        List<String> busesAmount = parser.findInformationInFile(filename, criteria);
        result = Integer.parseInt(busesAmount.get(0));

        return result;
    }

    private List<Passenger> createListOfPassengersFromFile(String filename, String criteria) {
        List<Passenger> result = new ArrayList<>();
        Parser parser = new Parser();
        List<String> passengersNames = parser.findInformationInFile(filename, criteria);
        for (String name : passengersNames) {
            result.add(new Passenger(name));
        }
        return result;
    }

    public void startAllBuses() {
        for (Bus bus : buses) {
            bus.start();
        }
    }
}
