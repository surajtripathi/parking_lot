package example.com.parkinglot.exceptions;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class SlotFullException extends RuntimeException {
    public SlotFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SlotFullException(String message) {
        super(message);
    }
}
