package example.com.parkinglot.vehicle;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class Car extends AbstractVehicle {

    public Car(String regNo, String color) {
        super(regNo, color, "car", 50);
    }
}
