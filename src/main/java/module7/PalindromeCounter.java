package module7;


public class PalindromeCounter {

    public int count(String phrase) {
        String[] words = phrase.toLowerCase().split(" ");
        int counter = 0;
        for (String s : words) {
            if (isPalendrome(s)){
                counter++;
            }
        }
        return counter;
    }

    private boolean isPalendrome(String input) {
        return input.equals(reverse(input));
    }

    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}


class PalindromeCounterTest {
    public static void main(String[] args) {
        PalindromeCounter counter = new PalindromeCounter();

        //1
        System.out.println(counter.count("Level done!"));

        //0
        System.out.println(counter.count("No palindromes"));
    }
}