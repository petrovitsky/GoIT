package module7;

public class SensitiveDataSearcher {
    public static final String [] WORDS = new String [] {"pass", "key", "login", "email"};

    public boolean isSensitiveDataPresent(String phrase) {
        String [] arr = phrase.toLowerCase().split("\\W+");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < WORDS.length; j++) {
                if (arr[i].equals(WORDS[j])){
                    return true;
                }
            }
        }
        return false;
    }
}


class SensitiveDataSearcherTest {
    public static void main(String[] args) {
        SensitiveDataSearcher searcher = new SensitiveDataSearcher();

        //false
        System.out.println(searcher.isSensitiveDataPresent("Hello world"));

        //true
        System.out.println(searcher.isSensitiveDataPresent("Pass: swordfish"));

    }
}

