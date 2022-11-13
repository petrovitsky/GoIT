package module12;

import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolExample {
}


class MyAction extends RecursiveAction{
    private  int value;

    public MyAction(int value) {
        this.value = value;
    }

    @Override
    protected void compute() {
        if (value <= 4) {
            System.out.println("Hello before" + Thread.currentThread().getId() + " " + value) ;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello after" + Thread.currentThread().getId() + " " + value) ;
        }
    }
}
