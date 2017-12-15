package by.troyan.multithreding.entity;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Bus extends Thread {
    private long busId;
    private static long idCounter = 0;
    private Semaphore semaphore;
    private Lock lock;
    private List<Passenger> busPassengers;
    private Route busRoute;

    public Bus(Route busRoute, List busPassengers, Semaphore semaphore, Lock lock) {
        this.semaphore = semaphore;
        this.busRoute = busRoute;
        this.busPassengers = busPassengers;
        this.lock = lock;
        busId = createID();
    }

    public static long createID() {
        return idCounter++;
    }

    public void startTrip(){
        List <BusStop> busStops = busRoute.getBusStopsList();

        try{
            for(BusStop tmp: busStops){
                tmp.checkInBusStop(this);

                lock.lock();
                System.out.println("resource locked by bus " + this);
                tmp.makeBusWaitersDoSmth(this);

                for (Passenger passenger: busPassengers){
                    passenger.makePassengersDoSomething(tmp,passenger,this);
                }

                lock.unlock();
                System.out.println("resource unlocked by bus " + this);

                TimeUnit.SECONDS.sleep(1);
                tmp.checkOutBusStop(this);
            }

        } catch (InterruptedException e){
            System.out.println("Interrupted!!!!!!!!");

        } catch (IllegalMonitorStateException e){
            System.out.println("!!!");
        }

        System.out.println("finish trip");
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " waiting permission ");
            semaphore.acquire();
            System.out.println(this + " gets permission ");
            startTrip();
            System.out.println(this + " release permission ");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getBusId() {
        return busId;
    }

    public List<Passenger> getBusPassengers() {
        return busPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        if (busId != bus.busId) return false;
        if (semaphore != null ? !semaphore.equals(bus.semaphore) : bus.semaphore != null) return false;
        if (lock != null ? !lock.equals(bus.lock) : bus.lock != null) return false;
        if (busPassengers != null ? !busPassengers.equals(bus.busPassengers) : bus.busPassengers != null) return false;
        return busRoute == bus.busRoute;
    }

    @Override
    public int hashCode() {
        int result = (int) (busId ^ (busId >>> 32));
        result = 31 * result + (semaphore != null ? semaphore.hashCode() : 0);
        result = 31 * result + (lock != null ? lock.hashCode() : 0);
        result = 31 * result + (busPassengers != null ? busPassengers.hashCode() : 0);
        result = 31 * result + (busRoute != null ? busRoute.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                '}';
    }
}
