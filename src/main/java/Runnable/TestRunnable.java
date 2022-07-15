package Runnable;

public class TestRunnable implements Runnable{

    int num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            num++;
        }
    }

}
