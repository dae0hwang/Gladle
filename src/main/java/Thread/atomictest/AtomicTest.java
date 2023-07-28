package Thread.atomictest;

import java.util.concurrent.atomic.AtomicInteger;
public class AtomicTest implements Runnable {

    int num1 = 0;
    public AtomicInteger num2 = new AtomicInteger(0);


    @Override

    public void run() {
        for (int i = 0; i < 10000000; i++) {
            num1++;
            num2.incrementAndGet();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicTest runnable = new AtomicTest();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("아토믹 사용 x ");
        System.out.println(runnable.num1);
        System.out.println("아토믹 사용 o");
        System.out.println(runnable.num2);
    }
}
