package test.by.antontroyan.epam.task1;

import by.antontroyan.epam.task1.FileDataDownloader;
import by.antontroyan.epam.task1.FileIsEmptyException;
import by.antontroyan.epam.task1.NoFileNameException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class FileDataDownloaderTest {

    FileDataDownloader fdd =  new FileDataDownloader();

    @Test(expectedExceptions = FileNotFoundException.class)
    public void testGetLinesNotFound() throws Exception {
        fdd.getLines("notExisting.txt");
    }

    @Test(expectedExceptions = FileIsEmptyException.class)
    public void testGetLinesIsEmpty() throws Exception {
        fdd.getLines("empty.txt");
    }

    @Test(expectedExceptions = NoFileNameException.class)
    public void testGetLinesNoFileName() throws Exception {
        fdd.getLines(" ");
    }

    @Test
    public void testGetNormalMode() throws Exception {
        fdd.getLines("triangleData.txt");
    }

}