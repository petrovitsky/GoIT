package module7;

public class MathDetector {
    public boolean isMath(String text){
        int counter = 0;
        for (char c : text.toCharArray()) {
            if(Character.isDigit(c)){
                counter ++;
            }
        }
        if (counter < 2) {
            return false;
        }


        return text.contains("=") && (text.contains("+") || text.contains("-") || text.contains("*") || text.contains("/")) ;
    }
}

class MathDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new MathDetector().isMath("2+2=4"));

        //false
        System.out.println(new MathDetector().isMath("1992 is great year"));

        //false
        System.out.println(new MathDetector().isMath("Venus vs Earth"));
    }
}
