package module7;

public class WordCombine {
    public boolean canCombine(String sourceWord, String targetWord){
        int counter = 0;
        for (String s : targetWord.toLowerCase().split("")) {
            if (sourceWord.toLowerCase().contains(s)){
                counter++;
            }
        }
        return targetWord.length() == counter;
    }
}

class WordCombineTest {
    public static void main(String[] args) {
        //true
        System.out.println(new WordCombine().canCombine("Forest", "tor"));

        //true
        System.out.println(new WordCombine().canCombine("Magic", "Mama"));

        //false
        System.out.println(new WordCombine().canCombine("War", "Piece"));
    }
}
