package check;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//public class Bus implements Runnable {
//    private Lock lock = new ReentrantLock();
//    private Exchanger<Passengers> exchanger;
//    private Passengers passengers;
//    private ArrayList<BusStation> busStations;
//    private int number;
//    private BeforeState beforeState = new BeforeState();
//    private AfterState afterState = new AfterState();
//
//    public Bus(ArrayList busStations, int number, Passengers passengers, Exchanger<Passengers> exchanger) {
//        this.busStations = busStations;
//        this.number = number;
//        this.passengers = passengers;
//        this.exchanger = exchanger;
//    }
//
//    public void addExchanger(Exchanger exchanger) {
//        this.exchanger = exchanger;
//    }
//
//    public Exchanger getExchanger() {
//        return exchanger;
//    }
//
//    public Bus(ArrayList busStations) {
//        this.busStations = busStations;
//    }
//
//    public void run() {
//        for (int i = 0; i < busStations.size(); i++) {
//            beforeState.doAction(this, busStations.get(i));
//            busStations.get(i).addBus(this);
//            afterState.doAction(this, busStations.get(i));
//            busStations.get(i).getSemaphore().release();
//        }
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void setPassengers(Passengers passengers) {
//        lock.lock();
//        if (passengers.getQuantity() < 0)
//            passengers = new Passengers(0);
//        try {
//            this.passengers = passengers;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public Passengers getPassengers() {
//        lock.lock();
//        try {
//            return passengers;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//}
