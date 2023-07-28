package Thread.atomictest;

public class Main {

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
