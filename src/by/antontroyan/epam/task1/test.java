package by.antontroyan.epam.task1;

import org.apache.log4j.Logger;

public class test {
        private static Logger log = Logger.getLogger("FileDownloader");

    public static void main(String[] args) {
        FileDataDownloader fd = new FileDataDownloader();
        try{
            System.out.println(fd.getLine("data.txt"));
        } catch (NoValidDataException e){
            log.fatal("NoValidData " + e);
        }

        Sphere sphere = new Sphere(Validator.getData()[0],Validator.getData()[1],Validator.getData()[2]);
        System.out.println(sphere);
        System.out.println(Spheres.calcSphereArea(sphere));
        System.out.println(Spheres.isTouch(sphere));
        System.out.println(Spheres.calcSphereVolume(sphere));
        System.out.println(Spheres.calcSphereVolumesCutting(sphere));
        System.out.println(Spheres.isSphere(sphere));

    }
}
