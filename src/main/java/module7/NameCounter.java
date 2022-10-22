package module7;

public class NameCounter {
    public int count(String text){
        int counter = 0;
        for (String s: text.split(" ")) {
            if (s.length() > 1 && (Character.isUpperCase(s.charAt(0)) && Character.isLowerCase(s.charAt(1))) ) {
                counter++;
            }
        }
        return counter;
    }
}

class NameCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new NameCounter().count("Mars is great planet"));

        //2
        System.out.println(new NameCounter().count("Moon is near Earth"));

        //0
        System.out.println(new NameCounter().count("SPACE IS GREAT"));
    }
}
