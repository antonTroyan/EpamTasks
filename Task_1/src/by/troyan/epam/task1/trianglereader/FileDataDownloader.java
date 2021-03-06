package by.troyan.epam.task1.trianglereader;


import by.troyan.epam.task1.exception.FileIsEmptyException;
import by.troyan.epam.task1.exception.FileNotExistExeption;
import by.troyan.epam.task1.exception.NoFileNameException;
import by.troyan.epam.task1.validator.Validator;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileDataDownloader {

    private static Logger log = LogManager.getLogger("FileDownloaderT");

    public List<String> readLines (String filename) throws NoFileNameException, FileIsEmptyException, FileNotExistExeption {
        Validator validator = new Validator();
        List<String> result = new ArrayList<>();
        if(validator.validateFile(filename)){
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                log.info("File opened successfully");
                while ((line = reader.readLine()) != null) {
                    log.info("Line was downloaded successfully " + line);
                    result.add(line);
                }
            } catch (IOException e) {
                log.fatal("Fatal!  " + e);
                throw new RuntimeException();
        }
    }   return result;
}
}
