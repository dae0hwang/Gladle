package Thread.runnablethread;

public class SynchronizedRunnable implements Runnable {

    public int num1 = 0;
    public int num2 = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            num1++;
            synchronized (this) {
                num2++;
            }
        }
    }
}
