package by.troyan.multithreding;
import by.troyan.multithreding.initialize.Initializer;

public class Test {
    public static void main(String[] args) {

        Initializer init = new Initializer();
        init.initialize("data//initial.txt");
        init.startAllBuses();

    }
}

