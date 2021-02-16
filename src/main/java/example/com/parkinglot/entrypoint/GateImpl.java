package example.com.parkinglot.entrypoint;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class GateImpl implements Gate {
    private final int number;
    private final int level;

    public int getLevel() {
        return level;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public GateImpl(int number, int level) {
        this.number = number;
        this.level = level;
    }
}
