package example.com.parkinglot.parkingstrategy;

import example.com.parkinglot.entrypoint.Gate;
import example.com.parkinglot.slot.Slot;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class NearestParkingStrategy implements ParkingStrategy {
    TreeSet<Slot> freeSlots = new TreeSet<>((a, b) -> {
        return a.getDistance() - b.getDistance();
    });

    @Override
    public Slot getSlot() {
        return freeSlots.first();
    }

    @Override
    public void addSlot(Slot slots) {
        freeSlots.add(slots);
    }

    @Override
    public void removeSlot(Slot slots) {
        freeSlots.remove(slots);
    }
}
