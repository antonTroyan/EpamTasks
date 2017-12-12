package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Passenger masha = new Passenger("masha");
        Passenger anna = new Passenger("anna");
        Passenger donya = new Passenger("donya");
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

        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(new Passenger("anton"));
        passengerList.add(new Passenger("vania"));
        passengerList.add(new Passenger("kolia"));

        List<Passenger> passengerList1 = new ArrayList<>();
        passengerList1.add(new Passenger("liu"));
        passengerList1.add(new Passenger("michael"));
        passengerList1.add(new Passenger("meizu"));

        Bus bus = new Bus(route, passengerList);
        Bus bus1 = new Bus(route, passengerList1);

        bus.start();
        bus1.start();

    }
}
