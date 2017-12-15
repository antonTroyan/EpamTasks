package by.troyan.multithreding.initialize;

import by.troyan.multithreding.entity.Bus;
import by.troyan.multithreding.entity.BusStop;
import by.troyan.multithreding.entity.Passenger;
import by.troyan.multithreding.entity.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


public class Initializer {
        private List<Bus> buses;
        private List<BusStop> busStops;

    public void initialize (String filename){
        buses = new ArrayList<>();
        List<Passenger> passengers = createPassengersList(filename);
        int maxBusStopsAmount =  checkBusStopsAmount(filename);

        Semaphore semaphore = new Semaphore(2);
        ReentrantLock lock = new ReentrantLock();
        Random random = new Random();
        int randomToDividePassengers = random.nextInt(passengers.size());

        List passengersMinsk = new ArrayList();
        passengersMinsk.add(new Passenger("dart mol"));
        passengersMinsk.add(new Passenger("dart sidius"));

        List passengersLondon = new ArrayList();
        passengersLondon.add(new Passenger("obi van"));
        passengersLondon.add(new Passenger("heila"));

        BusStop minsk = new BusStop(passengersMinsk);
        BusStop london = new BusStop(passengersLondon);
        ArrayList<BusStop> busStops = new ArrayList<>();
        busStops.add(minsk);
        busStops.add(london);
        Route.MINSK_LONDON.addBusStop(minsk);
        Route.MINSK_LONDON.addBusStop(london);

        for(int i = 0; i < maxBusStopsAmount; i++){
            List <Passenger> passengerForBus = new ArrayList<>();
            for(int j = 0; j < randomToDividePassengers; j++){
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

    private int checkBusStopsAmount(String filename){
        int result;
        Parser parser = new Parser();
        List<String> busesAmount = parser.findInformationInFile(filename,"BusStopAmount: 3");
        result = Integer.parseInt(busesAmount.get(0));

        return result;
    }

    private List<Passenger> createPassengersList(String filename){
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
