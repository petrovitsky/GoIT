package module7;

public class WordDeleter {
    public String remove(String phrase, String[] words){
       String [] split = phrase.split(" ");
       int ocuruance = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (split[i].equals(words[j])){
                    split[i] = " ";
                    ocuruance ++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(" ")){
                sb.append(split[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}


class WordDeleterTest {
    public static void main(String[] args) {
        WordDeleter wordDeleter = new WordDeleter();

        //Hello
        System.out.println(wordDeleter.remove("Hello Java", new String[] {"Java"}));

        //This Sparta
        System.out.println(wordDeleter.remove("This is Sparta", new String[] {"is"}));
        //
        System.out.println(wordDeleter.remove("This is Sparta but that is my home ya", new String[] {"is"}));
    }
}