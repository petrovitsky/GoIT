package module11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestModule {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Oleh", 35, UserRole.WORKER),
                new User("Vika", 31, UserRole.MANAGER),
                new User("Olha", 47, UserRole.WORKER),
                new User("Vasyl ", 23, UserRole.MANAGER),
                new User("Sergy", 22, UserRole.DIRECTOR));

        System.out.println("users = " + users);
        users.forEach(System.out::println);
        System.out.println(users.stream().mapToInt(a -> a.getAge()).sum());
        System.out.println("users2 = " + users);
    }


}

class User {
    private String name;
    private int age;
    private UserRole userRole;

    public User(String name, int age, UserRole userRole) {
        this.name = name;
        this.age = age;
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", userRole=" + userRole +
                "}\n";
    }
}

enum UserRole {
    MANAGER, WORKER, DIRECTOR
}