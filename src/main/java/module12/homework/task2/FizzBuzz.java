package module12.homework.task2;

import java.util.StringJoiner;
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
    public AtomicInteger getCurr() {
        return curr;
    }
    public synchronized void fizz() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 3 == 0 && curr.get() % 5 != 0) {
                curr.incrementAndGet();
                result.put("fizz");
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void buzz() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 3 != 0 && curr.get() % 5 == 0) {
                result.put("buzz");
                curr.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void fizzbuzz() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 15 == 0) {
                result.put("fizzbuzz");
                curr.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void number() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 3 != 0 && curr.get() % 5 != 0) {
                result.put(String.valueOf(curr));
                curr.incrementAndGet();
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void  print() throws InterruptedException {
        StringJoiner stringJoiner = new StringJoiner(", ");
        while (!result.isEmpty()) {
            stringJoiner.add(result.poll());
        }
        System.out.print(stringJoiner);
    }
}