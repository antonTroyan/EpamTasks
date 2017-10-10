package by.antontroyan.epam.task1;
import org.apache.log4j.Logger;
import java.io.IOException;


public class test {
        private static Logger log = Logger.getLogger("FileDownloader");

    public static void main(String[] args) throws IOException, FileIsEmptyException, NoFileNameException {


          FileDataDownloader fdt = new FileDataDownloader();
          Validator v = new Validator();


          int a [][] = v.validate(fdt.getLines("triangleData.txt"));

          Triangle tr = new Triangle(a[0][0],a[0][1],a[0][2],a[0][3],a[0][4],a[0][5]);
          Triangle tr1 = new Triangle(a[1][0],a[1][1],a[1][2],a[1][3],a[1][4],a[1][5]);
          System.out.println(tr);
          System.out.println(tr1);
          Triangle tr2 = new Triangle(a[2][0],a[2][1],a[2][2],a[2][3],a[2][4],a[2][5]);
          System.out.println(tr2);
    }
}
