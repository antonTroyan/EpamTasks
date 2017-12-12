package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Passenger masha = new Passenger();
        Passenger anna = new Passenger();
        Passenger donya = new Passenger();
        ArrayList<Passenger> passengersMinsk = new ArrayList<>();
        passengersMinsk.add(masha);
        passengersMinsk.add(anna);

        ArrayList<Passenger> passengersLondon = new ArrayList<>();
        passengersLondon.add(donya);

        BusStop minsk = new BusStop(passengersMinsk);
        BusStop london = new BusStop(passengersLondon);
        ArrayList<BusStop> busStops = new ArrayList<>();
        busStops.add(minsk);
        busStops.add(london);
        Route route = new Route(busStops);

        List<Passenger> passengerList = new ArrayList<Passenger>();
        Passenger anton = new Passenger();
        Passenger vania = new Passenger();
        Passenger kolia = new Passenger();

        passengerList.add(anton);
        passengerList.add(vania);
        passengerList.add(kolia);

        Bus bus = new Bus(route, passengerList);
        bus.startTrip();
    }
}
