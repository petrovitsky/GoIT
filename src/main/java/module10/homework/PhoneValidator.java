package module10.homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PhoneValidator {
    public static void main(String[] args) {
        phoneValidator("./file.txt");
    }

    public static void phoneValidator(String path) {
        try (Scanner scanner = new Scanner(new FileInputStream(path))) {
            String s = "";
            while (scanner.hasNext()) {
                s = scanner.nextLine();
                if (s.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}") || s.matches("\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
