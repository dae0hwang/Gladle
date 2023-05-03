package Runnable;

import java.time.LocalTime;

public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println(LocalTime.now()  + " Thread is started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalTime.now()  + " Thread is exiting");
    }
}
