package module12;

public class Test {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread child = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                counter++;
                System.out.println(Thread.currentThread().getName() + " -> " + counter);

            }
        }, "child" );
        child.start();

        for (int i = 0; i < 20 ; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " -> " + counter);
        }
        System.out.println("child.getState() = " + child.getState());
        new Thread(()-> System.out.println(main.getState())).start();
        System.out.println("Thread.currentThread().getState() = " + Thread.currentThread().getState());

    }
}