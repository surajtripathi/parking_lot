package example.com.parkinglot.slot;

import example.com.parkinglot.vehicle.Vehicle;

import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public interface Slot {
    public int getLevel();
    public boolean canPark(int required);
    public int getTotalCapacity();
    public int getUsedCapacity();
    void incrUsedCapacity(int requiredCapacity);
    public List<Vehicle> getVehicle();
    public void setVehicle(Vehicle vehicle);
    int getDistance();
}
