package module7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PunctuationMarkCounter {
    public int count(String phrase){
        Pattern pattern = Pattern.compile("[.,!:;]");
        Matcher matcher = pattern.matcher(phrase);
        int counter = 0;
        while (matcher.find()){
            counter++;
        }

        return counter;
    }
}

class PunctuationMarkCounterTest {
    public static void main(String[] args) {
        PunctuationMarkCounter counter = new PunctuationMarkCounter();

        //2
        System.out.println(counter.count("Hello, world!"));

        //1
        System.out.println(counter.count("This is Sparta!"));

        //1
        System.out.println(counter.count("End."));
    }
}

