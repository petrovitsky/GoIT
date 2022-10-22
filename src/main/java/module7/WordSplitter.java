package module7;


import java.util.Arrays;

public class WordSplitter {
    public String[] split(String phrase){
        return phrase.toLowerCase().split("[^A-Za-zА-Яа-я]+");
    }
}


class WordSplitterTest {
    public static void main(String[] args) {
        WordSplitter wordSplitter = new WordSplitter();

        String[] words = wordSplitter.split("Hello      world");

        //[hello, world]
        System.out.println(Arrays.toString(words));
    }
}