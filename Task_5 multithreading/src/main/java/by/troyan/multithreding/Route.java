package by.troyan.multithreding;

import java.util.List;

public class Route {
    private long routeId;
    private static long idCounter = 0;

    List<BusStop> busStopsList;

    public Route (List <BusStop> busStopsList) {
        this.busStopsList = busStopsList;
        routeId = createID();
    }

    public static synchronized long createID() {
        return idCounter++;
    }

    public List<BusStop> getBusStopsList() {
        return busStopsList;
    }
}
