package module12;

public class Test {
    public static void main(String[] args) {
        TimePrinter time = new TimePrinter();
        new SecondsPrinter(time);
        new FiveSecondsNotification(time);
    }
}

class TimePrinter {
    private int second = 1;

    public synchronized void printSecond() {
        while (second < 5000) {
            try {
                Thread.sleep(1000);
                System.out.println(second);
                second++;
                notify();
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (second % 5 == 0) {
                try {
                    wait(1);
                    System.out.println(second);
                    second++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                notify();
            }
        }
    }

    public synchronized void printFiveSeconds() {
        while (second < 5000) {
            if (second % 5 == 0) {
                try {
                    Thread.sleep(999);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("5 seconds passed");
                notify();
            }
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SecondsPrinter extends Thread {
    private TimePrinter printer;

    public SecondsPrinter(TimePrinter printer) {
        this.printer = printer;
        this.start();
    }

    @Override
    public void run() {
        printer.printSecond();
    }
}

class FiveSecondsNotification extends Thread {
    private TimePrinter printer;

    public FiveSecondsNotification(TimePrinter printer) {
        this.printer = printer;
        this.start();
    }

    @Override
    public void run() {
        printer.printFiveSeconds();
    }
}
