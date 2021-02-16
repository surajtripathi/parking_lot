package example.com.parkinglot.slot;

import example.com.parkinglot.exceptions.SlotFullException;
import example.com.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class SlotImpl implements Slot {
    private final int id;
    private int distance;
    private final int level;
    private int capacity = 100;
    private int usedCapacity = 0;
    private List<Vehicle> vehicles;

    public SlotImpl(int id, int distance, int level) {
        this.id = id;
        this.distance = distance;
        this.level = level;
        this.vehicles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int getTotalCapacity() {
        return capacity;
    }

    @Override
    public int getUsedCapacity() {
        return usedCapacity;
    }

    @Override
    public void incrUsedCapacity(int requiredCapacity) {
        int finalCapacity = getUsedCapacity() + requiredCapacity;
        if (this.canPark(requiredCapacity)) {
            throw new SlotFullException(
                    String.format(
                            "can not assign slot with used = %d, total = %d and required capacity = %d",
                            getUsedCapacity(),
                            getTotalCapacity(),
                            finalCapacity));
        }
        this.usedCapacity = finalCapacity;
    }


    @Override
    public boolean canPark(int required) {
        return getTotalCapacity() <= (getUsedCapacity() + required);
    }

    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "SlotImpl{" +
                "id=" + id +
                ", distance=" + distance +
                ", level=" + level +
                ", capacity=" + capacity +
                ", usedCapacity=" + usedCapacity +
                ", vehicle=" + vehicles +
                '}';
    }

    public boolean equals(Object o) {
        if(o == null)
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        if (getClass() != o.getClass())
        {
            return false;
        }

        SlotImpl e = (SlotImpl) o;
        return (this.getId() == e.getId());
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getId();
        return result;
    }
}
