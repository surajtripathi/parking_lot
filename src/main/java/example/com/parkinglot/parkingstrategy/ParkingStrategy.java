package example.com.parkinglot.parkingstrategy;

import example.com.parkinglot.slot.Slot;

import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public interface ParkingStrategy {
    Slot getSlot();
    void addSlot(Slot slot);
    void removeSlot(Slot slot);
}
