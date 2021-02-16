package example.com.parkinglot.parking;

import example.com.parkinglot.slot.Slot;
import example.com.parkinglot.slot.SlotImpl;
import example.com.parkinglot.ticket.Ticket;
import example.com.parkinglot.vehicle.Vehicle;

import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public interface ParkingManager {
    Ticket parkVehicle(Vehicle vehicle);
    void removeVehicle(Ticket ticket);
    List<String> getRegNumberForColor(String color);
    List<Slot> getSlotNoFromRegistrationNo(String regNo);
    List<Slot> getSlotNumbersFromColor(String color);
    int getAvailableSlotsCount();
    void doCleanUp();
}
