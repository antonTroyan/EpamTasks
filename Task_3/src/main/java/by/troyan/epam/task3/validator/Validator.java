package by.troyan.epam.task3.validator;

import by.troyan.epam.task3.exception.DataReadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Validator {
    private final static Logger LOG = LogManager.getLogger("Validator");
    public static final int COLUMN_AMOUNT = 6;

    public boolean validateString(String input) {
        LOG.info("Validating string " + input);
        String stringTest[] = input.split(" ");

        if (input.length() == 0) {
            LOG.error("Length = 0 ");
            return false;
        }
        if(stringTest.length != 6) {
            LOG.error("Wrong parameters amount. Need 6, but founded: " + stringTest.length);
            return false;
        }
        try {
            int intTest[] = new int[COLUMN_AMOUNT];
            for (int i = 0; i < COLUMN_AMOUNT; i++) {
                intTest[i] = Integer.parseInt(stringTest[i]);
            }
            LOG.info("String " + input + " was validated successfully");
            return true;
        } catch (NumberFormatException e) {
            LOG.error("Wrong Format " + e);
        }
        return false;
    }

    public boolean validateFile(String filename) throws DataReadException {
        if(filename.isEmpty() || !new File(filename).exists()){
            LOG.fatal("Fatal! Impossible to read data from file: " + filename);
            throw new DataReadException("Impossible to read data from file: " + filename);
        }
        return true;
    }
}




