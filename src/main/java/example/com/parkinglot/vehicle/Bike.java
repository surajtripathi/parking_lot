package example.com.parkinglot.vehicle;

import example.com.parkinglot.slot.SlotImpl;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class Bike extends AbstractVehicle {
    public Bike(String regNo, String color) {
        super(regNo, color, "bike", 25);
    }
}
