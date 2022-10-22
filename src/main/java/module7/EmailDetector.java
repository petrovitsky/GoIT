package module7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailDetector {
    public boolean isPresent(String text) {
        Pattern pattern = Pattern.compile("\\w\\w@\\w\\w");
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }
}

class EmailDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new EmailDetector().isPresent("This email is no-reply@goo.com"));

        //false
        System.out.println(new EmailDetector().isPresent("No email present, but @ there"));
    }
}

