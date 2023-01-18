package section_seven;

import java.util.Arrays;

public class Dealership {

    private Car[] cars;

    public Dealership(Car[] _cars) {

        // This is an actual DEEP COPY
        this.cars = new Car[_cars.length];
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i] = new Car(_cars[i]);
        }
    }

    public void sell(int index) {
        this.cars[index].drive();
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            String carDescription = this.cars[i].toString();
            temp += carDescription + "\n";
        }
        return temp;
    }
}
