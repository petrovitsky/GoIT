package module12.homework.task2;

public class PrintResult extends Thread {
    private FizzBuzz data;
    public PrintResult(FizzBuzz data) {
        this.data = data;
        this.start();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(200);
            data.print();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}