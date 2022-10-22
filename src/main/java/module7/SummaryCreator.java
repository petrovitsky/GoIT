package module7;

public class SummaryCreator {
    public String create(String text){
        if(text.length() > 15) {
            if(text.charAt(15) != 32){
                return text.substring(0,15) + ("...");
            } else {
                return text.substring(0,15);
            }
        }
        return text;
    }
}

class SummaryCreatorTest {
    public static void main(String[] args) {

        SummaryCreator summaryCreator = new SummaryCreator();

        //Mars
        String shortPhrase = "Mars";
        System.out.println(summaryCreator.create(shortPhrase));

        //Java is very po...
        String longPhrase = "Java is very popular language";
        System.out.println(summaryCreator.create(longPhrase));
        // yxnodalynuleynv
        String phrase = "yxnodalynuleynv ymydibwo";
        System.out.println(summaryCreator.create(phrase));
    }
}

