package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.List;

public class BusStop {
    private long busStopId;
    private static long idCounter = 0;

    List<Passenger> passengersWishedToSitInBus = new ArrayList<>();
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

    public void makeBusWaitersDoSmth(Bus bus){
        System.out.println(busStopId + "№ BusStop");
            for (Passenger passenger: busStopPassengers){
                passenger.makeBusWaitersDoSmth(this, passenger, bus);
            }
            addPassangers(this, bus);
    }


    public void addPassangers (BusStop busStop, Bus bus){

        if(passengersWishedToSitInBus.size() != 0){
            for(Passenger tmp: passengersWishedToSitInBus){
                bus.getBusPassengers().add(tmp);
            }
            System.out.println("passengers added to bus " + bus + passengersWishedToSitInBus);

            for(Passenger tmp1: passengersWishedToSitInBus){
                busStopPassengers.remove(tmp1);
            }
            passengersWishedToSitInBus.clear();
            System.out.println("list of passengers on bus station " + busStopPassengers);
        }

    }

    public void checkInBusStop(Bus bus){
        buses.add(bus);
    }

    public void checkOutBusStop(Bus bus){
        buses.remove(bus);
    }

    public  List<Bus> getBuses() {
        return buses;
    }

    public  synchronized List<Passenger> getBusStopPassengers() {
        return busStopPassengers;
    }
}
