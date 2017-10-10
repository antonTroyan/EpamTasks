package by.antontroyan.epam.task1;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static Logger log = Logger.getLogger("Validator");


    public int[][] validate (List<String> input){

        int result [][] = new int[input.size()][6];
        for (int i = 0; i < input.size(); i++){
        try{
            String [] arr = input.get(i).split(" ");
            log.info("Validating string " + Arrays.toString(arr));
            for (int r = 0; r < 6; r++){
                result [i][r] = Integer.parseInt(arr[r]);
            }
            log.info("String was validated successfully ");
        } catch (NumberFormatException e){
            log.error("Wrong Format " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Wrong arguments amount " + e);
        }
        }
        return result;
    }

}
