package module11.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserService {
    public static List<User> findUser(List<User> list, Predicate<User> p) {
        List<User> result = new ArrayList<>();
        for (User user : list) {
            if (p.test(user)) {
                result.add(user);
                System.out.println(user);
            }
        }
        return result;
    }
}
