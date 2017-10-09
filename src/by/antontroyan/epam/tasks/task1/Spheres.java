package by.antontroyan.epam.tasks.task1;


public class Spheres {

    public static double calcSphereArea(Sphere sphere) {

        return (4 * Math.PI * Math.pow(sphere.getRadius(), 2));
    }

    public static double calcSphereVolume(Sphere sphere) {

        return (4 / 3 * Math.PI * Math.pow(sphere.getRadius(), 3));
    }

    public double calcSphereCutting(){
// in development
        return 1.0;
    }

    public boolean isSphere(){
// in development
        return true;
    }

    public static boolean isTouch(Sphere sphere){
        if(sphere.getXCoordinate() == sphere.getRadius()
                || sphere.getYCoordinate() == sphere.getRadius()){
            return true;
        } return false;
    }
}
