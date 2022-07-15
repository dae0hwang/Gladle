package TestCriticalSection;

public class TestCritical implements Runnable {

    int num = 0;
    int num2 = 0;

    private Object object = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            num++;
            synchronized (object) {
                num2++;
            }

        }
    }
}
