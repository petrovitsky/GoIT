package module7;

public class AvgWordLength {

    public double count(String phrase){
        String [] strings = phrase.split(" ");
        char [] chars = phrase.toCharArray();
        return  ((double)  chars.length - (strings.length - 1 ) )/ strings.length;
    }
}

class AvgWordLengthTest {
    public static void main(String[] args) {
        //6
        System.out.println(new AvgWordLength().count("Launch Rocket"));

        //4.5
        System.out.println(new AvgWordLength().count("Life is strange thing"));
    }
}