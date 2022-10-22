package module7.lesson;

public class UserTest {
    public static void main(String[] args) {
        User user =  User.getBuilder()
                .name("Eugene")
                .lastName("Petrov")
                .mail("ggg@gmail.com")
                .login("psv").build();

        System.out.println("user = " + user);

    }
}
