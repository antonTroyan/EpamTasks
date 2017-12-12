package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.List;

public class BusStop {
    private long busStopId;
    private static long idCounter = 0;

    List<Passenger> busStopPassengers;
    List<Bus> buses;

    public BusStop (List<Passenger> busStopPassengers) {
        busStopId = createID();
        this.busStopPassengers = busStopPassengers;
        buses = new ArrayList<>();
    }

    public static synchronized long createID() {
        return idCounter++;
    }

    public void makeBusStopPassengersDoSmth(){
        System.out.println(busStopId + "BusStop");
        for (Passenger passenger: busStopPassengers){
            passenger.makePassengerDoSmth(this,passenger);
        }
    }

    public void comeToBusStop(Bus bus){
        buses.add(bus);
    }

    public void getAwayFromBusStop(Bus bus){
        buses.remove(bus);
    }
}
