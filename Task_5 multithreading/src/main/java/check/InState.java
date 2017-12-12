package check;

import java.util.Random;
//
//public class InState {
//    private final static Logger logger = Logger.getLogger(InState.class);
//
//    public void doAction(Bus bus, BusStation busStation) {
//        logger.info("Bus number " + bus.getNumber() + " is on the station " + busStation.getName());
//        Random rand = new Random();
//        if (busStation.getSemaphore().availablePermits() == 0) {
//            if (rand.nextInt(10) > 5) {
//                try {
//                    Passengers tmpPassengers = bus.getPassengers();
//                    tmpPassengers = (Passengers) bus.getExchanger().exchange(bus.getPassengers());
//                    bus.setPassengers(tmpPassengers);
//                } catch (InterruptedException e) {
//                    logger.error("Exchanger mistake", e);
//                }
//
//            }
//            else
//                bus.setPassengers(new Passengers(bus.getPassengers().getQuantity() - rand.nextInt(10)));
//        }
//    }
//
//    public String toString() {
//        return "In state";
//    }
//
//}
