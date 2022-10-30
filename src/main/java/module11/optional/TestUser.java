package module11.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestUser {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Oleh", 35, Position.WORKER),
                new User("Vika", 31, Position.MANAGER),
                new User("Olha", 47, Position.WORKER),
                new User("Vasyl ", 23, Position.MANAGER),
                new User("Sergy", 22, Position.DIRECTOR));


     UserService.findUser(users, u -> Position.MANAGER.equals(u.getPosition()));
     UserService.findUser(users, u -> u.getAge() > 30 && u.getPosition() == Position.WORKER);
    }
}
