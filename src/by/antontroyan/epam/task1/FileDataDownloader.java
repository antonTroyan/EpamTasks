package by.antontroyan.epam.task1;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataDownloader {

    private static Logger log = Logger.getLogger("FileDownloaderT");

    public List<String> getLines (String fileName) throws IOException, NoFileNameException, FileIsEmptyException {

        if (fileName == " ") throw new NoFileNameException("Parameter file name is empty");
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if (reader.readLine() == null) throw new FileIsEmptyException("File is empty, or can`t be read");
        log.info("File opened successfully");
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
        lines.add(line);
        }
        return lines;
    }
}
