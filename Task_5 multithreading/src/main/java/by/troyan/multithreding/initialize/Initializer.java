package by.troyan.multithreding.initialize;

import by.troyan.multithreding.entity.Bus;
import by.troyan.multithreding.entity.Passenger;
import by.troyan.multithreding.entity.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


public class Initializer {
        List<Bus> buses;


    public void initialize (String filename){
        buses = new ArrayList<>();
        List<Passenger> passengers = createPassangersList(filename);
        int maxBusAmount = checkBusAmount(filename);

        Semaphore semaphore = new Semaphore(2);
        ReentrantLock lock = new ReentrantLock();
        Random random = new Random();
        int randomToDividePassangers = random.nextInt(passengers.size());

        for(int i = 0; i < maxBusAmount; i++){
            List <Passenger> passengerForBus = new ArrayList<>();
            for(int j = 0; j < randomToDividePassangers; j++){
                passengerForBus.add(passengers.get(j));
            }
            System.out.println(passengerForBus);
            buses.add(new Bus(Route.MINSK_LONDON, passengerForBus, semaphore, lock));
            System.out.println(buses.get(0).getBusPassengers() + "Passengers");
        }
    }


    private int checkBusAmount(String filename){
        int result;
        Parser parser = new Parser();
        List<String> busesAmount = parser.findInformationInFile(filename,"BusesAmount: 3");
        result = Integer.parseInt(busesAmount.get(0));

        return result;
    }

    private List<Passenger> createPassangersList(String filename){
        List<Passenger> result = new ArrayList<>();
        Parser parser = new Parser();
        List<String> passengersNames = parser.findInformationInFile(filename,"Passengers:");
        for(String name: passengersNames){
            result.add(new Passenger(name));
        }
        return result;
    }

    public void startAllBuses (){
        for(Bus bus: buses){
            bus.start();
        }
    }
}
