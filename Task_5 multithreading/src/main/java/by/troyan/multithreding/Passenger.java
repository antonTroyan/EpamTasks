package by.troyan.multithreding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passenger {
    private long passengerId;
    private static long idCounter = 0;


    public Passenger() {
        passengerId = createID();
    }

    public static synchronized long createID() {
        return idCounter++;
    }

    public void makePassengerDoSmth(BusStop busStop, Passenger passenger){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 0: stayInBus();
                    break;
            case 1: goToAnotherBus(busStop, passenger);
                    break;
            case 2: stayInBusStop();
                    break;
            default:
                System.out.println("default action");
        }
    }

    private void stayInBus() {
        System.out.println("Passenger " + passengerId + " decided to stay in bus");
    }

    private void goToAnotherBus(BusStop busStop, Passenger passenger) {
        List<Bus> buses =  busStop.buses;

        List<Passenger> passengersFromFirst = buses.get(0).getBusPassengers();
        List<Passenger> passengersFromSecond = buses.get(1).getBusPassengers();

        passengersFromFirst.remove(passenger);
        passengersFromSecond.add(passenger);

        System.out.println("Passenger " + passengerId + " go to another bus");
    }

    private void stayInBusStop() {
        System.out.println("Passenger " + passengerId + " decided to stay in bus Stop");
    }
}
