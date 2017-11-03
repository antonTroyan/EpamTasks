package by.troyan.epam.task1.creator;

import by.troyan.epam.task1.entity.Triangle;

import java.util.ArrayList;

class Singleton {
    private static ArrayList<Triangle> triangleArrayList;

    private Singleton() {
    }

    public static synchronized ArrayList<Triangle> getInstance(){
        if(triangleArrayList == null){
            triangleArrayList = new ArrayList();
        }
        return triangleArrayList;
    }
}
