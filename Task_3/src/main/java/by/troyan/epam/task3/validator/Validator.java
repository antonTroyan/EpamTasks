package by.troyan.epam.task3.validator;

import by.troyan.epam.task3.exception.DataReadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Validator {
    private static Logger log = LogManager.getLogger("Validator");
    public static final int COLUMN_AMOUNT = 6;

    public boolean validateString(String input) {
        log.info("Validating string " + input);
        String stringTest[] = input.split(" ");

        if (input.length() == 0) {
            log.error("Length = 0 ");
            return false;
        }
        if(stringTest.length != 6) {
            log.error("Wrong parameters amount. Need 6, but founded: " + stringTest.length);
            return false;
        }
        try {
            int intTest[] = new int[COLUMN_AMOUNT];
            for (int i = 0; i < COLUMN_AMOUNT; i++) {
                intTest[i] = Integer.parseInt(stringTest[i]);
            }
            log.info("String " + input + " was validated successfully");
            return true;
        } catch (NumberFormatException e) {
            log.error("Wrong Format " + e);
        }
        return false;
    }

    public boolean validateFile(String filename) throws DataReadException {
        if(filename.isEmpty() || !new File(filename).exists()){
            log.fatal("Fatal! Impossible to read data");
            throw new DataReadException("Impossible to read data");
        }
        return true;
    }
}




