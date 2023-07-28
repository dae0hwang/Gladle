package Thread.runnablethread;


import Thread.criticalsection.SynchronizedRunnable;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread.criticalsection.SynchronizedRunnable critical = new SynchronizedRunnable();

        Thread t1 = new Thread(critical);
        Thread t2 = new Thread(critical);
        Thread t3 = new Thread(critical);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("num1= "+ critical.num1);
        System.out.println("num2= "+ critical.num2);
    }
}
