package TestCriticalSection;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        TestCritical critical = new TestCritical();

        Thread t1 = new Thread(critical);
        Thread t2 = new Thread(critical);
        Thread t3 = new Thread(critical);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(critical.num);
        System.out.println(critical.num2);
    }

}
