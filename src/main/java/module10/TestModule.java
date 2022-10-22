package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestModule {
    public static void main(String[] args) throws IOException {
//        File file = new File("./test.txt");
//        System.out.println("file.exists() = " + file.exists());
//        OutputStream fos = new FileOutputStream("./test.txt", false);
//        fos.write("First data\n".getBytes(StandardCharsets.UTF_8));
//        fos.write("Second".getBytes(StandardCharsets.UTF_8));
//
//        fos.close();
//
//        InputStream fis = new FileInputStream(file);
//        System.out.println("fis.available() = " + fis.available());
//        byte[] input = new byte[fis.available()];
//        fis.skip(11L);
//        System.out.println("fis.read(input) = " + fis.read(input));
//        System.out.println(new String(input, StandardCharsets.UTF_8));
//        System.out.println("fis.available() = " + fis.available());
//
//        fis.close();
//
//        byte[] source = "Dude hello".getBytes(StandardCharsets.UTF_8);
//        InputStream bais = new ByteArrayInputStream(source);
//
//        byte[] buffer = new byte[1024];
//        bais.read(buffer, 0, buffer.length);
//
//        for (int i = 0; i < 30; i++) {
//            System.out.println((char) buffer[i]);
//        }


//        phoneValidator("./file.txt");

//        UserTest ut1 = new UserTest("Im", "dede");
//        UserTest ut2 = new UserTest("dew", " 123");
//        List<UserTest> list = List.of(ut1,ut2);
//        Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();
//
//        FileWriter fw = new FileWriter(new File("./json.json"));
//        gson.toJson(list,fw);
//        fw.flush();
//        fw.close();
        Gson gson = new Gson();
        Reader fr = new FileReader("./json.json");
        List<UserTest> newList = gson.fromJson(fr, List.class);
        System.out.println("newList.size() = " + newList.size());
        System.out.println("newList.get(0) = " + newList.get(0));
        System.out.println("newList.get(1) = " + newList.get(1));
        System.out.println("newList.add(new UserTest(\"Alex\", \"5\")) = " + newList.add(new UserTest("Alex", "5")));
        System.out.println("newList.get(2) = " + newList.get(2));

    }

    public static void phoneValidator(String path) {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            StringBuilder sb = new StringBuilder();
            String s = "";
            while (scanner.hasNext()) {
                s = scanner.nextLine();
                if (s.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}") || s.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(s);
                }
            }
            Pattern pattern = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
            Matcher matcher = pattern.matcher(s);
            System.out.println(matcher.find());

            System.out.println(sb);
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public static void frequencyCount(String path) {
        Map<String, Integer> resultMap = new HashMap<>();
        TreeSet<Map.Entry<String, Integer>> treeSet = new TreeSet<>((o1, o2) -> o2.getValue() > o1.getValue() ? 1 : -1);

        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (resultMap.containsKey(s)) {
                    resultMap.put(s, resultMap.get(s) + 1);
                } else {
                    resultMap.put(s, 1);
                }
            }
            System.out.println("result = " + resultMap);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        treeSet.addAll(resultMap.entrySet());
        System.out.println("treeSet = " + treeSet);
        List<Map.Entry<String, Integer>> list = new LinkedList<>(resultMap.entrySet());
        System.out.println("list = " + list);
        Collections.sort(list, ((o1, o2) -> o2.getValue() - o1.getValue()));
        System.out.println("list = " + list);

        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i).getKey() + " " +  list.get(i).getValue());
        }

    }


}

class UserTest {
    private String login;
    private String password;

    public UserTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}