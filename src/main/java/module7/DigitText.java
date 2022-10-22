package module7;

public class DigitText {
    public boolean detect(String text){
        String[] arr = text.split(" ");
        for (String s: arr) {
            if (s.matches("[a-zA-Zа-яА-Я]+")){
                return false;
            }
        }
        return true;
    }
}


class DigitTextTest {
    public static void main(String[] args) {
        //true
        System.out.println(new DigitText().detect("23 50"));

        //false
        System.out.println(new DigitText().detect("Year 1990"));

        //false
        System.out.println(new DigitText().detect("Привет1 вуцв 4535 3 цуа цф афц23"));
    }
}