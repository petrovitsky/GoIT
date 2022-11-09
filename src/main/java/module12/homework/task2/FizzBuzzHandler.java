package module12.homework.task2;

public class FizzBuzzHandler extends Thread{
    private FizzBuzz data;

    public FizzBuzzHandler(FizzBuzz data) {
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

