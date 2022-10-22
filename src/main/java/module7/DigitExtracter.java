package module7;

import java.util.Arrays;

public class DigitExtracter {
    public int[] extract(String text){
        int [] tmp = new int[text.length()];
        int index = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp[index++] = Integer.parseInt(String.valueOf(c));
            }
        }
        return Arrays.copyOf(tmp, index);
    }
}

class DigitExtracterTest {
    public static void main(String[] args) {


        DigitExtracter digitExtracter = new DigitExtracter();

        int[] extracted = digitExtracter.extract("april 5, year 2000");

        //[5, 2, 0, 0, 0]
        System.out.println(Arrays.toString(extracted));
    }
}