package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.List;

public enum Route {
    MINSK_LONDON(new ArrayList<BusStop>()){};

    List<BusStop> busStops = new ArrayList<>();

    Route(ArrayList<BusStop> busStops) { }

    public void addBusStop (BusStop busStop){
        busStops.add(busStop);
    }

    public List<BusStop> getBusStopsList() {
        return busStops;
    }
}
