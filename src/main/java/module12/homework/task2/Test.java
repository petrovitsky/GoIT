package module12.homework.task2;

public class Test {
    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new FizzHandler(fizzBuzz);
        new FizzBuzzHandler(fizzBuzz);
        new BuzzHandler(fizzBuzz);
        new NumberHandler(fizzBuzz);
        new PrintResult(fizzBuzz);

    }
}
