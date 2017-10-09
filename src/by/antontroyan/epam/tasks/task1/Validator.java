package by.antontroyan.epam.tasks.task1;


import org.apache.log4j.Logger;

public class Validator {
    private static Logger log = Logger.getLogger("FileDownloader");
    private static int fullDataAmount = 3;
    private static double [] data = new double[fullDataAmount];

    public static double[] getData() {
        return data;
    }

    public static boolean isRight (String analized)  {
            int counter = 0;
            log.info("Try to validate: " + analized);
        try{
            String strArr[] = analized.split(" ");
            for (int i = 0; i < strArr.length; i++) {
                data[i] = Double.parseDouble(strArr[i]);
                counter++;
            }
            if(counter < 3) {
                log.error("IncorrectRadius: " + data[0]);
                return false;
            }
            if(data[0] < 0) {
                log.error("NotFullData: " + analized);
                return false;
            }
            return true;
        } catch (NumberFormatException e){
            log.error("NumberFormatException: " + analized);
            return false;
        } catch (NullPointerException e){
            log.error("NullPointerException: " + analized);
            return false;
        }

    }
}
