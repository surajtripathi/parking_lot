package example.com.parkinglot.exceptions;

/**
 * Created by surajtripathi on 17/02/21.
 */
public class ParkingFullException extends RuntimeException {
    public ParkingFullException(String s) {
        super(s);
    }
}
