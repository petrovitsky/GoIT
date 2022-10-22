package module10.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToJson {
    public static void main(String[] args) {
        toJson(readFile("./file.txt"));
    }

    public static List<User> readFile(String path) {
        List<User> list = new ArrayList<>();
        try (FileReader reader = new FileReader(path);
             Scanner scanner = new Scanner(reader)) {
            reader.skip(scanner.nextLine().length());
            while (scanner.hasNext()) {
                list.add(new User(scanner.next(), scanner.nextInt()));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static <T> void toJson(List<T> list) {
        try (FileWriter fw = new FileWriter("./user.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(list, fw);
            fw.flush();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}