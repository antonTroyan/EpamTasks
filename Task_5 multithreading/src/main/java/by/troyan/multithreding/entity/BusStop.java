package by.troyan.multithreding.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BusStop {
    private long busStopId;
    private static long idCounter = 0;

    private List<Passenger> passengersWishedToSitInBus = new ArrayList<>();
    private List<Passenger> busStopPassengers;
    private List<Bus> buses;
    private List<Passenger> passengersWishedChangeBus =new ArrayList<>();


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
                passenger.makeBusWaitersDoSomething(this, passenger, bus);
            }
            addPassangersToBusFromBusStop(this, bus);
            addPassengersChangingBus(bus);
    }


    public void addPassangersToBusFromBusStop(BusStop busStop, Bus bus){

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

    public void addPassengersChangingBus(Bus fromBus){
        if (passengersWishedChangeBus.size() != 0){
            Random random = new Random();
            int toBus;
            do {
                toBus = random.nextInt(buses.size());
            } while (toBus == (int)fromBus.getBusId());

            for (Passenger passenger: passengersWishedChangeBus){
                buses.get(toBus).getBusPassengers().add(passenger);
                System.out.println(passenger + " changed bus and sit in the bus " + buses.get(toBus));
            }

            for(Passenger passenger: passengersWishedChangeBus){
                System.out.println(fromBus.getBusPassengers() + "before remove");
                fromBus.getBusPassengers().remove(passenger);
                System.out.println(passenger + " removed from the bus list " + fromBus);
                System.out.println(fromBus.getBusPassengers() + "after remove");
            }
            System.out.println("From bus passengers " + fromBus.getBusPassengers());
            System.out.println("Now bus has "+ buses.get(toBus).getBusId() + buses.get(toBus).getBusPassengers());
            passengersWishedChangeBus.clear();
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

    public List<Passenger> getPassengersWishedToSitInBus() {
        return passengersWishedToSitInBus;
    }

    public List<Passenger> getPassengersWishedChangeBus() {
        return passengersWishedChangeBus;
    }
}
