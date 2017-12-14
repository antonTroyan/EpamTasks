package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {

        ArrayList<Passenger> passengersMinsk = new ArrayList<>();
        passengersMinsk.add(new Passenger("masha"));
        passengersMinsk.add(new Passenger("anna"));

        ArrayList<Passenger> passengersLondon = new ArrayList<>();
        passengersLondon.add(new Passenger("donya"));

        BusStop minsk = new BusStop(passengersMinsk);
        BusStop london = new BusStop(passengersLondon);
        ArrayList<BusStop> busStops = new ArrayList<>();
        busStops.add(minsk);
        busStops.add(london);
        Route.MINSK_LONDON.addBusStop(minsk);
        Route.MINSK_LONDON.addBusStop(london);


        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(new Passenger("anton"));
        passengerList.add(new Passenger("vania"));
        passengerList.add(new Passenger("kolia"));

        List<Passenger> passengerList1 = new ArrayList<>();
        passengerList1.add(new Passenger("liu"));
        passengerList1.add(new Passenger("michael"));
        passengerList1.add(new Passenger("meizu"));

        List<Passenger> passengerList2 = new ArrayList<>();
        passengerList2.add(new Passenger("luk"));
        passengerList2.add(new Passenger("vader"));
        passengerList2.add(new Passenger("chewbacca"));

        Semaphore semaphore = new Semaphore(2);
        ReentrantLock lock = new ReentrantLock();

        Bus bus = new Bus(Route.MINSK_LONDON, passengerList, semaphore, lock);
        Bus bus1 = new Bus(Route.MINSK_LONDON, passengerList1, semaphore, lock );
        Bus bus2 = new Bus (Route.MINSK_LONDON, passengerList2, semaphore, lock);

        bus.start();
        bus1.start();
        bus2.start();


//        Random random = new Random();
//        int toBus;
//        do{
//            toBus = random.nextInt(3);
//        } while (toBus == 1);
//        System.out.println(toBus);
    }
}
