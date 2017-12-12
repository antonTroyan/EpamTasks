package check;

import java.util.concurrent.Semaphore;

//public class BusStation {
//    private final static Logger logger = Logger.getLogger(BusStation.class);
//    private String name;
//    private final int busLimit = 2;
//    private Semaphore semaphore = new Semaphore(busLimit);
//
//    public BusStation(String name) {
//        this.name = name;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public void addBus(Bus bus){
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            logger.error("Semaphore error", e);
//        }
//        new InState().doAction(bus, this);
//    }
//    public Semaphore getSemaphore(){
//        return semaphore;
//    }

//}
