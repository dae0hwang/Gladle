package Runnable;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RunnableThread runnableThread = new RunnableThread();

        Thread thread = new Thread(runnableThread);

        //system.out.println은 내가 만든 스레드가 아닌
        //메인 스레드이다. 즉 하나의 프로세스에서
        //메인 스레드와 내가 만든 스레드가 동시에 작동되는 것을 확인할 수 있다.
        System.out.println(LocalTime.now() + " Starting the thread");
        thread.start();

        System.out.println(LocalTime.now() + " Waiting the thread()");
        thread.join();
        System.out.println(LocalTime.now() + " alive: " + thread.isAlive());
    }
}
