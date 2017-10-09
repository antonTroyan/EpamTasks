package test.by.antontroyan.epam.tasks.task1;

import by.antontroyan.epam.tasks.task1.FileDataDownloader;
import by.antontroyan.epam.tasks.task1.NoValidDataException;
import org.testng.annotations.Test;



public class FileDownloaderTest {

    FileDataDownloader fd = new FileDataDownloader();

    @Test(expectedExceptions = NoValidDataException.class)
    public void testGetLineFileNotFound() throws Exception {
        fd.getLine("wrongData.txt");
    }

}