package module11.optional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestUser {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Oleh", 35, Position.WORKER,false),
                new User("Vika", 31, Position.MANAGER,false),
                new User("Olha", 47, Position.WORKER,false),
                new User("Vasyl ", 23, Position.MANAGER,false),
                new User("Sergy", 22, Position.DIRECTOR,false));

        Predicate<User> predicate = user -> user.getAge()< 30;
        UserService.findUser(users, predicate.or(user -> user.getPosition() == Position.WORKER));

    }
}
