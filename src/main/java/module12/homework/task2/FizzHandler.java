package module12.homework.task2;

public class FizzHandler extends Thread{
    private FizzBuzz data;

    public FizzHandler(FizzBuzz data) {
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
