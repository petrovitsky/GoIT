package module7;

public class BigOrSmall {
    public String calculate(String text){
        int bigCounter = 0;
        int smallCounter = 0;

        for (char c: text.toCharArray()) {
            if(Character.isUpperCase(c)){
                bigCounter++;
            }
            if (Character.isLowerCase(c)){
                smallCounter++;
            }
        }
        if (bigCounter == smallCounter){
            return "Same";
        }
        return bigCounter > smallCounter ? "Big" : "Small";
    }
}



class BigOrSmallTest {
    public static void main(String[] args) {


        //Small
        System.out.println(new BigOrSmall().calculate("Java"));

        //Big
        System.out.println(new BigOrSmall().calculate("JAVA"));

        //Same
        System.out.println(new BigOrSmall().calculate("jAvA"));

        System.out.println(new BigOrSmall().calculate("a, B"));
    }
}
