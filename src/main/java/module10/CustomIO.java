package module10;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CustomIO {
    public static void main(String[] args) {
        byte[] input = "Hello world !!!".getBytes(StandardCharsets.UTF_8);
        InputStream is = new InputStream() {
            private int index = 0;
            @Override
            public int read() {
                if (index == input.length) {
                    return -1;
                }
                return input[index++];
            }
        };
        try (Scanner scanner = new Scanner(is);) {
            while (scanner.hasNext()){
                System.out.print(scanner.nextLine());
            }
        }
    }
}
