package by.troyan.multithreding;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Bus extends Thread {
    private long busId;
    private static long idCounter = 0;
    private Semaphore semaphore;
    private Lock lock;

    Route busRoute;

    public List<Passenger> getBusPassengers() {
        return busPassengers;
    }

    private List<Passenger> busPassengers;

    public Bus(Route busRoute, List busPassengers, Semaphore semaphore, Lock lock) {
        this.semaphore = semaphore;
        this.busRoute = busRoute;
        this.busPassengers = busPassengers;
        this.lock = lock;
        busId = createID();
    }

    public static synchronized long createID() {
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
                    passenger.makePassangersDoSmth(tmp,passenger,this);
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

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                '}';
    }
}
