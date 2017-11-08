package by.troyan.epam.task1.validator;

import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.FileNotExistExeption;
import by.troyan.epam.task1.exception.NoFileNameException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Validator {
    private static Logger log = LogManager.getLogger("Validator");
    private final int COLUMN_AMOUNT = 6;

    public boolean validateString(String input) {
        log.info("Validating string " + input);
        if (input.length() == 0) {
            log.info("Length 0 " + input.length());
        }
        try {
            String stringTest[] = input.split(" ");
            int intTest[] = new int[COLUMN_AMOUNT];
            for (int i = 0; i < COLUMN_AMOUNT; i++) {
                intTest[i] = Integer.parseInt(stringTest[i]);
            }
            log.info("String " + input + " was validated successfully");
            return true;
        } catch (NumberFormatException e) {
            log.error("Wrong Format " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Wrong parameters amount " + e);
        }
        return false;
    }

    public boolean validateFile(String filename) throws NoFileNameException, FileIsEmptyException, FileNotExistExeption {
        File file = new File(filename);
        if (filename.isEmpty()) {
            log.fatal("Fatal! Parameter filename is empty ");
            throw new NoFileNameException("Parameter filename is empty");
        }
        if (!file.exists()) {
            log.fatal("Fatal! File is not exist ");
            throw new FileNotExistExeption("File is not exist");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            if (reader.readLine() == null) {
                log.fatal("Fatal! File is empty ");
                throw new FileIsEmptyException("File is empty, or can`t be read");
            }
        } catch (IOException e) {
            log.fatal("Fatal!  " + e);
            throw new RuntimeException();
        }
        return true;
    }
}




