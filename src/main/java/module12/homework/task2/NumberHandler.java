package module12.homework.task2;

public class NumberHandler extends Thread {
    private FizzBuzz data;
    public NumberHandler(FizzBuzz data) {
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