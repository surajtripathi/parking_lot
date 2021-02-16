package example.com.parkinglot.parking;

import example.com.parkinglot.exceptions.ParkingFullException;
import example.com.parkinglot.parkingstrategy.ParkingStrategy;
import example.com.parkinglot.slot.Slot;
import example.com.parkinglot.ticket.Ticket;
import example.com.parkinglot.vehicle.Vehicle;

import java.util.*;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class MultiLevelParkingManagerImpl {
    private final List<Ticket> tickets;
    private final Map<Integer, ParkingManager> parkingLotManager = new TreeMap<>();
    //implement payment here
    //map for query by color

    public MultiLevelParkingManagerImpl(ParkingStrategy strategy, int levels, int capacity) {
        this.tickets = new ArrayList<>();
        for (int i = 0; i< levels; i++) {
            parkingLotManager.put(i+1, new LevelParkingManagerImpl(strategy, i, capacity));
        }
    }


    public Ticket parkVehicle(Vehicle vehicle) {
        Ticket ticket = null;
        for (ParkingManager parkingManager : parkingLotManager.values()) {
            if (parkingManager.getAvailableSlotsCount() >= vehicle.getRequiredSlotCount()) {
                ticket = parkingManager.parkVehicle(vehicle);
                break;
            }
        }
        if (ticket == null) {
            throw new ParkingFullException("parking full");
        }
        tickets.add(ticket);
        return ticket;
    }

    public boolean removeVehicle(Ticket ticket) {
        parkingLotManager.get(ticket.getLevel()).removeVehicle(ticket);

        System.out.println(String.format("unParked vehical with ticketImpl %s", tickets.toString()));
        return tickets.remove(ticket);
    }

    public int getAvailableSlotsCount() {
        int total = 0;
        for (ParkingManager parkingManager : parkingLotManager.values()) {
            total += parkingManager.getAvailableSlotsCount();
        }
        return total;
    }

    public List<String> getRegNumberForColor(String color) {
        List<String> result = new ArrayList<>();
        for (ParkingManager parkingManager : parkingLotManager.values()) {
            result.addAll(parkingManager.getRegNumberForColor(color));
        }
        return result;
    }

    public List<Slot> getSlotNumbersFromColor(String colour) {
        List<Slot> result = new ArrayList<>();
        for (ParkingManager parkingManager : parkingLotManager.values()) {
            result.addAll(parkingManager.getSlotNumbersFromColor(colour));
        }
        return result;
    }

    public List<Slot> getSlotNoFromRegistrationNo(String registrationNo) {
        List<Slot> result = new ArrayList<>();
        for (ParkingManager parkingManager : parkingLotManager.values()) {
            result.addAll(parkingManager.getSlotNoFromRegistrationNo(registrationNo));
        }
        return result;
    }

    public void doCleanUp() {
        for (ParkingManager parkingManager : parkingLotManager.values()) {
            parkingManager.doCleanUp();
        }
    }

}
