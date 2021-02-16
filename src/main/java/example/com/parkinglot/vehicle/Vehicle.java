package example.com.parkinglot.vehicle;

import example.com.parkinglot.slot.Slot;
import example.com.parkinglot.slot.SlotImpl;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public interface Vehicle {
    List<Slot> getSlots();
    String getRegNo();
    String getColor();
    //TODO: will be used for price calculation
    LocalDateTime getParkingTime();
    String getVehicleType();
    //50
    int getRequiredSlotCount();
    void setSlot(Slot takenSlots);

}
