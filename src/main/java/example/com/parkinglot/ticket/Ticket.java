package example.com.parkinglot.ticket;

import example.com.parkinglot.user.User;
import example.com.parkinglot.vehicle.Vehicle;

/**
 * Created by surajtripathi on 16/02/21.
 */
public interface Ticket {
    User getUserDetails();
    Vehicle getVehicleDetails();
    int getLevel();
}
