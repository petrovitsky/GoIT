package module12.homework.task2;

public class PrintFizz extends Thread{
    private FizzBuzz data;

    public PrintFizz(FizzBuzz data) {
        this.data = data;
        this.start();
    }

    @Override
    public void run() {
        try {
            data.fizz();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
