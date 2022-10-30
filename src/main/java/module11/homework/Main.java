package module11.homework;

import java.util.*;
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


        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> s2 = Stream.of(10, 40, 60);
        System.out.println(zip(s1, s2).collect(Collectors.toList()));
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


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        List<T> result = new ArrayList<>();
        while (firstIterator.hasNext() && secondIterator.hasNext()){
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }
        return result.stream();
    }
}
