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

    public AtomicInteger getCurr() {
        return curr;
    }

    public synchronized void fizz() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 3 == 0 && curr.get() % 5 != 0) {
                System.out.println("fizz");
//                result.put("fizz");
                System.out.println("curr.incrementAndGet() = " + curr.incrementAndGet());

                notify();
                wait();
            } else {
                notifyAll();
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (curr.get() <= n) {
//            System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());
            if (curr.get() % 3 != 0 && curr.get() % 5 == 0) {
                System.out.println("buzz ");
//                result.put("buzz");
                curr.incrementAndGet();
                notifyAll();

            } else {
                notifyAll();
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (curr.get() <= n) {
            if (curr.get() % 15 == 0) {
                System.out.println("fizzbuzz ");
//                result.put("fizzbuzz");
                curr.incrementAndGet();
                notifyAll();
                wait();
            } else {
                notifyAll();
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (curr.get() <= n) {
            int counter = 1;
            counter++;
            System.out.println("counter = " + counter);

            if (curr.get() % 3 != 0 && curr.get() % 5 != 0) {
                System.out.println(curr);
//                result.put(String.valueOf(curr));
                curr.incrementAndGet();
                notifyAll();
                wait();
            }
            else {
                notifyAll();
//                System.out.println("counter = " + counter);
                wait();
            }
        }
    }

    public synchronized void print() throws InterruptedException {
        while (!result.isEmpty()) {
            System.out.print(result.poll() + ", ");
        }
    }
}
