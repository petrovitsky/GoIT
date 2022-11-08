package module12.homework.task2;

public class PrintNumber extends Thread {
    private FizzBuzz data;

    public PrintNumber(FizzBuzz data) {
        this.data = data;
        this.start();
    }

    @Override
    public void run() {
        try {
            data.number();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}