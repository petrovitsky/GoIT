package module12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx1 {
    public static void main(String[] args) {
        ScheduledExecutorService sES = Executors.newScheduledThreadPool(1);
        sES.scheduleAtFixedRate(new RunnableImpl(), 0, 1, TimeUnit.SECONDS);
        try {
            ThreadPoolEx1.class.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sES.shutdown();
    }


}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " stops work");
    }
}