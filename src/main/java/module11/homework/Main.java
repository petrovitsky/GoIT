package module11.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("eugene", "alex", "vika", "kolya",
                "yana", "denis", "ivan", "olga", "serg", "anna", "tanya", "katya");

        String[] data = new String[]{"1, 2, 0", "4, 5"};

        System.out.println(list);

        System.out.println(oddNames(list));

        System.out.println(upAndSort(list));

        System.out.println(getSortedDigitsFromStringArray(data));

        final Stream<Long> longStream = infiniteStream(25214903917L, 11l, (long) Math.pow(2, 48), 99L);
        System.out.println("longStream.collect(Collectors.toList()) = " + longStream.collect(Collectors.toList()));
    }

    public static String oddNames(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < list.size(); i += 2) {
            sb.append(i + ". ").append(list.get(i) + ", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    public static List<String> upAndSort(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String getSortedDigitsFromStringArray(String[] data) {
        return Arrays.stream(data)
                .map((s -> s.split(", ")))
                .flatMap(Stream::of)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> infiniteStream(long a, long c, long m, long seed) {
        LCGImpl random = new LCGImpl(a, c, m);
        return Stream
                .iterate(seed, random::next)
                .limit(10);
    }
}
