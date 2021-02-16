package example.com.parkinglot.vehicle;

import example.com.parkinglot.entrypoint.Gate;
import example.com.parkinglot.slot.Slot;
import example.com.parkinglot.slot.SlotImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class AbstractVehicle implements Vehicle {
    private List<Slot> slots;
    private final String regNo;
    private final String color;
    private Gate nearestGate;
    private int requiredSlotCount;
    private final LocalDateTime parkingDateTime;
    private String vehicleType;

    public AbstractVehicle(String regNo, String color, String vehicleType, int requiredSlotCount) {
        this(regNo, color, vehicleType, requiredSlotCount, null);
    }
    public AbstractVehicle(String regNo, String color, String vehicleType, int requiredSlotCount, Gate gate) {
        this.regNo = regNo;
        this.color = color;
        this.vehicleType = vehicleType;
        this.requiredSlotCount = requiredSlotCount;
        this.parkingDateTime = LocalDateTime.now();
        this.nearestGate = gate;
        this.slots = new ArrayList<>();
    }

    public int getRequiredSlotCount() {
        return requiredSlotCount;
    }

    public void setSlot(Slot takenSlots) {
        this.slots.add(takenSlots);
    }


    public List<Slot> getSlots() {
        return slots;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    @Override
    public LocalDateTime getParkingTime() {
        return parkingDateTime;
    }

    @Override
    public String getVehicleType() {
        return "car";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractVehicle)) return false;

        AbstractVehicle that = (AbstractVehicle) o;

        if (getRegNo() != null ? !getRegNo().equals(that.getRegNo()) : that.getRegNo() != null) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = getSlots() != null ? getSlots().hashCode() : 0;
        result = 31 * result + (getRegNo() != null ? getRegNo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbstractVehicle{" +
                //"slots=" + slots +
                ", regNo='" + regNo + '\'' +
                ", color='" + color + '\'' +
                ", nearestGate=" + nearestGate +
                ", parkingDateTime=" + parkingDateTime +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
