package module7;

public class PhraseMaker {
    public String join(String[] words) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if (words [i].length() < 4) {
                result.append(words[i].toUpperCase()).append(" ");
            } else {
                result.append(words[i].toLowerCase()).append(" ");
            }
        }
        return result.toString().trim();
    }
}

class PhraseMakerTest {
    public static void main(String[] args) {
        String[] words = {"Life", "is", "great", "thing"};

        //life IS great thing
        System.out.println(new PhraseMaker().join(words));
    }
}
