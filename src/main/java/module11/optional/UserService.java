package module11.optional;

import java.util.List;

public class UserService {
    public static void findUser (List<User> list, UserChecker u){
        for (User user : list) {
            if(u.checkUser(user)){
                System.out.println(user);
            }
        }
    }
}
