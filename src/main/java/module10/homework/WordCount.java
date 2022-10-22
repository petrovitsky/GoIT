package module10.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        frequencyCount("./words.txt");
    }

    public static void frequencyCount(String path) {
        Map<String, Integer> resultMap = new HashMap<>();
        List<Map.Entry<String, Integer>> list = new LinkedList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (resultMap.containsKey(s)) {
                    resultMap.put(s, resultMap.get(s) + 1);
                } else {
                    resultMap.put(s, 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("e.getMessage() = " + e.getMessage());
        }

        list.addAll(resultMap.entrySet());
        Collections.sort(list, ((o1, o2) -> o2.getValue() - o1.getValue()));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
    }
}
