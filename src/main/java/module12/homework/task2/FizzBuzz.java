package module12.homework.task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class FizzBuzz {

    private volatile int n;
    private AtomicInteger curr = new AtomicInteger(1);

    private ArrayBlockingQueue<String> result;

    public FizzBuzz(int n) {
        this.n = n;
        result = new ArrayBlockingQueue<>(n);
    }


    public void fizz() throws InterruptedException {
        while (curr.get() < n) {
            if (curr.get() % 3 == 0 && curr.get() % 5 != 0) {
                System.out.println("fizz");
                result.put("fizz");
                curr.incrementAndGet();
                Thread.sleep(500);
            }
        }
    }

    public void buzz() throws InterruptedException {
        while (curr.get() < n) {
            if (curr.get() % 3 != 0 && curr.get() % 5 == 0) {
                System.out.println("buzz ");
                result.put("buzz");
                curr.incrementAndGet();
                Thread.sleep(500);
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (curr.get() < n) {
            if (curr.get() % 15 == 0) {
                System.out.println("fizzbuzz ");
                result.put("fizzbuzz");
                curr.incrementAndGet();
                Thread.sleep(500);
            }
        }
    }

    public void number() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 3 != 0 && curr.get() % 5 != 0) {
                System.out.println(curr);
                result.put(String.valueOf(curr));
                curr.incrementAndGet();
                Thread.sleep(500);
            }
        }
    }

    public void print() throws InterruptedException {
        while (!result.isEmpty()) {
            System.out.print(result.poll() + ", ");
        }
    }
}
