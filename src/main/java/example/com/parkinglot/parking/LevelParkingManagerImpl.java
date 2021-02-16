package example.com.parkinglot.parking;

import example.com.parkinglot.parkingstrategy.ParkingStrategy;
import example.com.parkinglot.slot.Slot;
import example.com.parkinglot.slot.SlotImpl;
import example.com.parkinglot.ticket.Ticket;
import example.com.parkinglot.ticket.TicketImpl;
import example.com.parkinglot.vehicle.Vehicle;

import java.util.*;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class LevelParkingManagerImpl implements ParkingManager {
    private final ParkingStrategy parkingStrategy;
    private final int level;
    private int availability;
    private final int capacity;
    private Map<Slot, List<Vehicle>> slotVehicleMap;


    public LevelParkingManagerImpl(ParkingStrategy parkingStrategy, int level, int capacity) {
        this.parkingStrategy = parkingStrategy;
        this.level = level;
        this.capacity = capacity;
        this.slotVehicleMap = new HashMap<>();
        for (int i = 1; i <= capacity; i++) {
            SlotImpl slot = new SlotImpl(i, i, level);
            availability += slot.getTotalCapacity();
            slotVehicleMap.put(slot, new ArrayList<>());
            parkingStrategy.addSlot(slot);
        }
    }


    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        Slot availableSlot;
        //if not available throw exception
        //check if vehicle is already parked
        availableSlot = parkingStrategy.getSlot();
        if (vehicle.getRequiredSlotCount() + availableSlot.getUsedCapacity() <= availableSlot.getTotalCapacity()) {
            availableSlot.setVehicle(vehicle);
            availableSlot.incrUsedCapacity(vehicle.getRequiredSlotCount());
            slotVehicleMap.get(availableSlot).add(vehicle);
            availability -= vehicle.getRequiredSlotCount();
            vehicle.setSlot(availableSlot);
            if(availableSlot.getUsedCapacity() == availableSlot.getTotalCapacity()) {
                parkingStrategy.removeSlot(availableSlot);
            }
        } else {
            Slot topUnsedSlot = null;
            if (availableSlot.getUsedCapacity() != 0) {
                topUnsedSlot = availableSlot;
                parkingStrategy.removeSlot(topUnsedSlot);
            }
            //multi slot parking;
            int requiredSlotCount = vehicle.getRequiredSlotCount();
            while (requiredSlotCount > 0) {
                Slot slot = parkingStrategy.getSlot();
                slot.setVehicle(vehicle);
                slot.incrUsedCapacity(slot.getTotalCapacity());
                slotVehicleMap.get(slot).add(vehicle);
                availability -= slot.getTotalCapacity();
                parkingStrategy.removeSlot(slot);
                requiredSlotCount -= availableSlot.getTotalCapacity();
                vehicle.setSlot(availableSlot);
            }
            if (topUnsedSlot != null) {
                parkingStrategy.addSlot(topUnsedSlot);
            }

        }
        return new TicketImpl(vehicle, this.level);
    }

    @Override
    public void removeVehicle(Ticket ticket)
    {
//        if (!slotVehicleMap.get(slotNumber).isPresent()) // Slot already empty
//            return false;
//        availability.incrementAndGet();
//        parkingStrategy.add(slotNumber);
//        slotVehicleMap.put(slotNumber, Optional.empty());
//        return true;
    }

    public List<String> getStatus() {
        return null;
    }

    public int getAvailableSlotsCount()
    {
        return availability;
    }

    public List<String> getRegNumberForColor(String color) {

        return null;
    }

    public List<Slot> getSlotNumbersFromColor(String colour) {
        return null;
    }

    public List<Slot> getSlotNoFromRegistrationNo(String registrationNo) {
        return null;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void doCleanUp() {
    }
}
