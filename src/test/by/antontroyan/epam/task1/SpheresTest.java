
package test.by.antontroyan.epam.task1;

import by.antontroyan.epam.task1.Sphere;
import by.antontroyan.epam.task1.Spheres;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SpheresTest {

    Sphere sphere = new Sphere(5,5,5);


    @Test
    public void testCalcSphereArea() throws Exception {

        Assert.assertEquals(Spheres.calcSphereArea(sphere), 314.1592653589793);
    }

    @Test
    public void testCalcSphereVolume() throws Exception {

        Assert.assertEquals(Spheres.calcSphereVolume(sphere),392.6990816987241);
    }

    @Test
    public void testCalcSphereVolumesCutting() throws Exception {

        Assert.assertEquals(Spheres.calcSphereVolumesCutting(sphere),1.0);
    }

    @Test
    public void testisSphere() throws Exception {

        Assert.assertEquals(Spheres.isSphere(sphere),true);
    }

    @Test
    public void testisTouch() throws Exception {

        Assert.assertEquals(Spheres.isTouch(sphere),true);
    }



}