package by.antontroyan.epam.task1;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDataDownloader {
    private String line;
    private static Logger log = Logger.getLogger("FileDownloader");

    public String getLine(String fileName) throws NoValidDataException {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            log.info("File was successfully opened");
            do {
                line = reader.readLine();
                if(line == null) throw new NoValidDataException("Was not founded valid data in the file: " + fileName);
            } while (!Validator.isRight(line));

            log.info("Line was successfully read");
            return line;

        } catch (FileNotFoundException e) {
            log.fatal("File not found");
        } catch (IOException e) {
            log.fatal("Fatal IO error");
        }
        return line;
    }
}
