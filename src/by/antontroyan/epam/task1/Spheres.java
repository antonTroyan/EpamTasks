package by.antontroyan.epam.task1;
import static java.lang.Math.*;

public class Spheres {

    public static double calcSphereArea(Sphere sphere) {

        return (4 * PI * pow(sphere.getRadius(), 2));
    }

    public static double calcSphereVolume(Sphere sphere) {

        return (4 / 3 * PI * pow(sphere.getRadius(), 3));
    }

    public static double calcSphereVolumesCutting(Sphere sphere){

        double volume1 = 2 * PI * sphere.getRadius() * (2 * sphere.getRadius() - abs(sphere.getYCoordinate()));
        double volume2 = 2 * PI * sphere.getRadius() * (2 * sphere.getRadius() - abs(sphere.getYCoordinate()));
        return abs(volume1/volume2);
    }

    public static boolean isSphere(Sphere sphere){
        if(PI == (calcSphereVolume(sphere))/(4/3 * pow(sphere.getRadius(),3))) return true;
        return false;
    }

    public static boolean isTouch(Sphere sphere){

        if(abs(sphere.getXCoordinate()) == sphere.getRadius()
                || abs(sphere.getYCoordinate()) == sphere.getRadius()){
            return true;
        } return false;
    }

}
