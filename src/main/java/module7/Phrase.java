package module7;
import java.util.Arrays;

public class Phrase {
    private final String[] words;

    public Phrase(String[] words) {
        this.words = Arrays.copyOf(words,words.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.words.length ; i++) {
            sb.append(this.words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

class PhraseTest {
    public static void main(String[] args) {
        String[] words = {"alpha", "beta", "gamma"};

        Phrase phrase = new Phrase(words);

        //alpha beta gamma
        System.out.println(phrase);

        words[0] = "zero";

        //alpha beta gamma
        System.out.println(phrase);
    }
}