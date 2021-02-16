package example.com.parkinglot.ticket;

import example.com.parkinglot.user.User;
import example.com.parkinglot.vehicle.Vehicle;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class TicketImpl implements Ticket {
    private User userDetails;
    private Vehicle vehicleDetails;
    private int level;

    @Override
    public String toString() {
        return "TicketImpl{" +
                "userDetails=" + userDetails +
                ", vehicleDetails=" + vehicleDetails +
                '}';
    }

    public Vehicle getVehicleDetails() {
        return vehicleDetails;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public TicketImpl(Vehicle vehicleDetails, int level) {
        this(null, vehicleDetails, level);
    }

    public TicketImpl(User customer, Vehicle vehicleDetails, int level) {
        this.userDetails = customer;
        this.vehicleDetails = vehicleDetails;
    }
}
