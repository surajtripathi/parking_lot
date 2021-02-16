package example.com.parkinglot.user;

/**
 * Created by surajtripathi on 16/02/21.
 */
public class User {
    //plus other details;
    private final String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
