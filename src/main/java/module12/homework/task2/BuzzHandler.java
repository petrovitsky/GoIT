package module12.homework.task2;

public class BuzzHandler extends Thread{
    private FizzBuzz data;

    public BuzzHandler(FizzBuzz data) {
        this.data = data;
        this.start();
    }

    @Override
    public void run() {
        try {
            data.buzz();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

