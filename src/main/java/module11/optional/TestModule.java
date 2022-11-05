package module11.optional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestModule {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Oleh", 35, Position.WORKER, false),
                new User("Vika", 31, Position.MANAGER, false),
                new User("Olha", 47, Position.WORKER, false),
                new User("Vasyl ", 23, Position.MANAGER, false),
                new User("Sergy", 22, Position.DIRECTOR, false));

        System.out.println("users = " + users);
        System.out.println("Total age amount " + users.stream().mapToInt(User::getAge).sum());
        processing(users);
        System.out.println("-------------");




        // Method reference block

            // Static method
        System.out.println("\nStatic method:\n");
        IntBinaryOperator sum = Integer::sum;
        System.out.println("sum.applyAsInt(3,5) = " + sum.applyAsInt(3, 5));

        Function<String, Integer> fromStrToInt = Integer::valueOf; ;
        System.out.println("fromStrToInt.apply(\"5\") = " + fromStrToInt.apply("5"));

            // non-static method
        System.out.println("\nnon-static method:\n");
        Function<String, String> trimmer = String::trim;
        System.out.println("trimmer.apply(\"     hello  \") = " + trimmer.apply("    hello   "));

            // non-static method instance-bound
        System.out.println("\nnon-static method instance-bound\n");
        Predicate<String> isFoo = "foo"::equals;
        System.out.println("isFoo.test(\"foo\") = " + isFoo.test("foo"));
        System.out.println("isFoo.test(\"Foo\") = " + isFoo.test("Foo"));
    }


    public static void processing(List<User> list) {
        final List<Integer> result = list.stream()
                .map(u -> u.getAge())
                .filter(age -> age < 30)
                .collect(Collectors.toList());
        System.out.println(result);
    }


}





