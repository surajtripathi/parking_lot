package example.com.parkinglot.vehicle;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class BusOrTruck extends AbstractVehicle {
    public BusOrTruck(String regNo, String color) {
        super(regNo, color, "busOrTruck", 100);
    }
}
