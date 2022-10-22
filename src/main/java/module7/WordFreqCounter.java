package module7;

public class WordFreqCounter {
    public float countFreq(String phrase, String word) {

        String [] words = phrase.toLowerCase().split(" ");
        float counter = 0;
        for (int i = 0; i < words.length ; i++) {
            if (words[i].equals(word.toLowerCase())){
                counter++;
            }
        }
        return counter/words.length;
    }
}



class WordFreqCounterTest {
    public static void main(String[] args) {
        WordFreqCounter freqCounter = new WordFreqCounter();

        //0.5
        System.out.println(freqCounter.countFreq("kecyecjo goecomwaohc zoxobuamvy Dogerame uqbyvo risy joexv Dogerame zu ehjypuy yq", "Dogerame"));

        //0
        System.out.println(freqCounter.countFreq("Hello World", "java"));
    }
}
