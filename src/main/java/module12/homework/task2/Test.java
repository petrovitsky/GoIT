package module12.homework.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new PrintFizz(fizzBuzz);
        new PrintFizzBuzz(fizzBuzz);
        new PrintBuzz(fizzBuzz);
        new PrintNumber(fizzBuzz);

//        System.out.println("fizzBuzz.getCurr() after = " + fizzBuzz.getCurr());

//        new PrintResult(fizzBuzz);

    }
}
