package module12.homework.task2;

public class PrintFizzBuzz extends Thread{
    private FizzBuzz data;

    public PrintFizzBuzz(FizzBuzz data) {
        this.data = data;
        this.start();
    }

    @Override
    public void run() {
        try {
            data.fizzbuzz();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

