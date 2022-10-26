package module11.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("eugene", "alex", "vika", "kolya",
                "yana", "denis", "ivan", "olga", "serg", "anna", "tanya", "katya");

        System.out.println(list);
        System.out.println(oddNames(list));
        System.out.println(upAndSort(list));
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
                .map(w -> w.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
