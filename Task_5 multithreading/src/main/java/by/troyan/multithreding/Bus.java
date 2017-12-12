package by.troyan.multithreding;

import java.util.List;

public class Bus {
    private long busId;
    private static long idCounter = 0;

    Route busRoute;

    public List<Passenger> getBusPassengers() {
        return busPassengers;
    }

    static List<Passenger> busPassengers;

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
            tmp.makeBusStopPassengersDoSmth();
            for (Passenger passenger: busPassengers){
                passenger.makePassengerDoSmth(tmp,passenger);
            }
            tmp.getAwayFromBusStop(this);
        }
    }
}
