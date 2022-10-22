package module9.test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CharsetTest {
    public static void main(String[] args) {
        String str = new String( new byte [] {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33}, StandardCharsets.UTF_8 );
        System.out.println(str);

        System.out.println(Arrays.toString("Привет мир".getBytes()));
        String rus = new String("Привет мир".getBytes());
        System.out.println("rus = " + rus);
    }
}
