package by.troyan.epam.task1v2.trianglereader;


import by.troyan.epam.task1v2.exception.FileIsEmptyException;
import by.troyan.epam.task1v2.exception.NoFileNameException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataDownloader {

    private static Logger log = Logger.getLogger("FileDownloaderT");

    public List<String> readLines (String filename) throws NoFileNameException, FileIsEmptyException {

        if (filename == " ") throw new NoFileNameException("Parameter file name is empty");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
//            if (reader.readLine() == null) throw new FileIsEmptyException("File is empty, or can`t be read");
            log.info("File opened successfully");
            while ((line = reader.readLine()) != null) {
                log.info("Line was downloaded successfully " + line);
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            log.fatal("Fatal error " + e);
            throw new RuntimeException();
        }

    }
}
