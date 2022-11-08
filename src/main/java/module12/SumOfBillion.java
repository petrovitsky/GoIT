package module12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumOfBillion {
    private static long value = 1_000_000_000L;
    private static long result = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureList = new ArrayList<>();
        long valueDevByTen = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDevByTen * i + 1; // 0 -> 1, 1-> 100...1, 2 -> 200...1
            long to = valueDevByTen * (i + 1); // 0 -> 100, 1 ->  200, 2 -> 300
            CallableSum cS = new CallableSum(from, to);
            final Future<Long> futurePartialRes = executorService.submit(cS);
            futureList.add(futurePartialRes);
        }
        for (Future<Long> future : futureList) {
            try {
                result += future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        System.out.println("result = " + result);
    }
}

class CallableSum implements Callable<Long> {
    private long from;
    private long to;
    private long sum;

    public CallableSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for (long i = from; i <= to; i++) {
            sum += i;
        }
        System.out.println("Sum from " + from + " to " + to);

        return sum;
    }
}