package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class BusStop {
    private long busStopId;
    private static long idCounter = 0;

    private List<Passenger> busStopPassengers;
    private List<Bus> buses;

    public BusStop (List<Passenger> busStopPassengers) {
        busStopId = createID();
        this.busStopPassengers = busStopPassengers;
        buses = new ArrayList<>();
    }

    public static synchronized long createID() {
        return idCounter++;
    }

    public void makeBusWaitersDoSmth(){
        System.out.println(busStopId + "№ BusStop");
        try{
            for (Passenger passenger: busStopPassengers){
                passenger.makeBusWaitersDoSmth(this, passenger);
            }
        } catch (ConcurrentModificationException e){
            System.out.println("!");
        }
    }

    public void comeToBusStop(Bus bus){
        buses.add(bus);
    }

    public void getAwayFromBusStop(Bus bus){
        buses.remove(bus);
    }

    public  List<Bus> getBuses() {
        return buses;
    }

    public  synchronized List<Passenger> getBusStopPassengers() {
        return busStopPassengers;
    }
}
