package by.troyan.epam.task1.validator;

import by.troyan.epam.task1.exception.FileCanNotBeFoundedException;
import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.NoFileNameException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Validator {
    private static Logger log = LogManager.getLogger("Validator");
    private final int COLUMN_AMOUNT = 6;

    public boolean validateString(String input) {
        log.info("Validating string " + input);
        if (input.length() == 0) {
            log.info("Length 0 " + input.length());
            return false;
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
            // возможно тут стоит выбросить свое исключение
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Wrong parameters amount " + e);
            return false;
        }

    }

    public boolean validateFile(String filename) throws NoFileNameException, FileIsEmptyException, FileCanNotBeFoundedException {

        if (filename == " ") throw new NoFileNameException("Parameter file name is empty");
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            if (reader.readLine() == null) {
                log.fatal("Fatal! File is empty " );
                throw new FileIsEmptyException("File is empty, or can`t be read");
            }
        }  catch (FileNotFoundException e) {
            log.fatal("Fatal! File cannot be founded  " + e);
            throw new FileCanNotBeFoundedException("It is impossible to find the file " + e);
        } catch (IOException e) {
            log.fatal("Fatal!  " + e);
            return false;
        }
        return true;
    }

}




