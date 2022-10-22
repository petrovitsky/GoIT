package module7;

public class UniqueCharCounter {
    public int count(String phrase) {
        char[] chars = phrase.toCharArray();
        float unique = chars.length;
//        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length; i++) {
            float counter = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    counter++;
                }
            }
            if (counter > 1) {
                unique -= (1 / counter);
            }
//            System.out.print(counter + " ");
        }
        return (int) unique;
    }
}

class UniqueCharCounterTest {
    public static void main(String[] args) {
        UniqueCharCounter charCounter = new UniqueCharCounter();
        //3
        System.out.println("\n" + charCounter.count("123"));

        //4
        System.out.println("\n" + charCounter.count("ab1000"));

        //3
        System.out.println("\n" + charCounter.count("Java"));
    }
}