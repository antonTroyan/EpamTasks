package by.troyan.epam.task3.trianglereader;

import by.troyan.epam.task3.exception.DataReadException;
import by.troyan.epam.task3.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileDataLoader {

    private final static Logger LOG = LogManager.getLogger("FileDownloaderT");

    public List<String> readLines (String filename) throws DataReadException {
        Validator validator = new Validator();
        List<String> result = new ArrayList<>();
        if(validator.validateFile(filename)){
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                LOG.info("File opened successfully");
                while ((line = reader.readLine()) != null) {
                    LOG.info("Line was downloaded successfully " + line);
                    result.add(line);
                }
            } catch (IOException e) {
                LOG.fatal("Fatal!  " + e);
                throw new RuntimeException();
        }
    }   return result;
}
}
