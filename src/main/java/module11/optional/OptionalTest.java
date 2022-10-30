package module11.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        Optional<Integer> result = intFromString("w");
        result.ifPresentOrElse(System.out::println, () -> System.err.println("Integer was not found"));

        System.out.println("result.orElse(789) = " + result.orElse(789));

        System.out.println("result.isPresent() = " + result.isPresent());

        result.orElseGet(() -> Integer.valueOf(222));
    }


    public static Optional<Integer> intFromString(String input) {
        try {
            return Optional.of(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
