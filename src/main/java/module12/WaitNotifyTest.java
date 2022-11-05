package module12;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Market market = new Market();
        Consumer consumer = new Consumer(market);
        Producer producer = new Producer(market);
        Thread thread1 = new Thread(consumer);
        Thread thread2 = new Thread(producer);
        thread1.start();
        thread2.start();
    }
}

class Market {
    public int getCounter() {
        return counter;
    }

    private int counter;

    public synchronized void addProduct(int iter) {
        System.out.println("iteration " + iter);
        while (counter >= 5) {
            System.err.println("Stock is full, iteration " + iter);
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Product added, iteration " + iter);
        counter++;
        System.out.println("Balance " + counter);
        this.notify();
    }

    public synchronized void getProduct(int iteration) {
        while (counter <= 0) {
            try {
                System.err.println("Stock is empty");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Product received");
        counter--;
        System.out.println("Balance " + counter);
        this.notify();
    }
}

class Producer implements Runnable {
    private Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            market.addProduct(i);
        }
    }
}

class Consumer implements Runnable {
    private Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            market.getProduct(i);
        }
    }
}