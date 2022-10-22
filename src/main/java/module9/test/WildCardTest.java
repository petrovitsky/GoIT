package module9.test;

import java.util.ArrayList;
import java.util.List;

public class WildCardTest {
    public static void driveAllTransport(List<? extends Transport> t) {
        for (Transport transport : t) {
            transport.drive();
        }
    }

    public static List<? extends Transport> getListOfEntities(Transport tr) {
        List result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new Transport());
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(getListOfEntities(new Transport()));


    }
}

class FirstCar {

}

class Transport extends FirstCar {
    protected static int entityCounter;
    private int index;

    public int getIndex() {
        return index;
    }


    public Transport() {
        this.index = entityCounter++;
    }

    public void drive() {
        System.out.println("Transport " + getIndex() + " is going");
    }

    @Override
    public String toString() {
        return "Transport {" +
                "index=" + index +
                '}';
    }
}

class Car extends Transport {
    @Override
    public void drive() {
        System.out.println("Car " + getIndex() + "  is driving");
    }
}