package by.troyan.multithreding;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Bus extends Thread {
    private long busId;
    private static long idCounter = 0;

    Route busRoute;

    public List<Passenger> getBusPassengers() {
        return busPassengers;
    }

    private List<Passenger> busPassengers;

    public Bus(Route busRoute, List busPassengers) {
        busId = createID();
        this.busRoute = busRoute;
        this.busPassengers = busPassengers;
    }

    public static synchronized long createID() {
        return idCounter++;
    }

    public void startTrip(){
        List <BusStop> busStops = busRoute.getBusStopsList();

        for(BusStop tmp: busStops){
            tmp.comeToBusStop(this);
            tmp.makeBusWaitersDoSmth();
//            for (Passenger passenger: busPassengers){
//                passenger.makePassangersDoSmth(tmp,passenger,this);
//            }
            tmp.getAwayFromBusStop(this);
        }
        System.out.println("finish trip");
    }

    @Override
    public void run() {
        startTrip();
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                '}';
    }
}
