package example.com;

import example.com.parkinglot.parking.MultiLevelParkingManagerImpl;
import example.com.parkinglot.parkingstrategy.NearestParkingStrategy;
import example.com.parkinglot.ticket.Ticket;
import example.com.parkinglot.vehicle.Bike;
import example.com.parkinglot.vehicle.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MultiLevelParkingManagerImpl multiLevelParkingLot = new MultiLevelParkingManagerImpl(new NearestParkingStrategy(), 2, 16);

        Bike bike = new Bike("1", "blue");
        Bike bike1 = new Bike("2", "blue");
        Bike bike2 = new Bike("3", "blue");
        Bike bike3 = new Bike("4", "blue");

        Ticket ticket1 = null;
        Ticket ticket2 = null;
        Ticket ticket3 = null;
        Ticket ticket4 = null;
        try {
            ticket1 = multiLevelParkingLot.parkVehicle(bike);
            System.out.println(String.format("Parked vehical with ticket %s", ticket1.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ticket2 = multiLevelParkingLot.parkVehicle(bike1);
            System.out.println(String.format("Parked vehical with ticket %s", ticket2.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ticket3 = multiLevelParkingLot.parkVehicle(bike2);
            System.out.println(String.format("Parked vehical with ticket %s", ticket3.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ticket4 = multiLevelParkingLot.parkVehicle(bike3);
            System.out.println(String.format("Parked vehical with ticket %s", ticket4.toString()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Car car = new Car("5", "black");
        Ticket ticket5 = null;

        try {
            ticket5 = multiLevelParkingLot.parkVehicle(car);
            System.out.println(String.format("Parked vehical with ticket %s", ticket5.toString()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(multiLevelParkingLot.getUnusedSlots());
        try {
            multiLevelParkingLot.removeVehicle(ticket1);
            multiLevelParkingLot.removeVehicle(ticket2);
            multiLevelParkingLot.removeVehicle(ticket3);
            multiLevelParkingLot.removeVehicle(ticket4);
            multiLevelParkingLot.removeVehicle(ticket5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
