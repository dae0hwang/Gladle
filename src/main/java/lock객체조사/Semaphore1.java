package lock객체조사;

import java.util.concurrent.Semaphore;

public class Semaphore1 {
    public static void main(String[] args) {
        SomeResource resource = new SomeResource(3);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    resource.use();
                }
            });
            t.start();
        }
    }
}


class SomeResource {

    private final Semaphore semaphore;
    private final int maxThread;

    SomeResource(int maxThread) {
        this.maxThread = maxThread;
        this.semaphore = new Semaphore(maxThread);
    }

    public void use() {
        try {
            semaphore.acquire();
            System.out.println("[" + Thread.currentThread().getName() + "]"
                + semaphore.toString() + " 사용중");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("[" + Thread.currentThread().getName() + "] 종료");
            semaphore.release(); // Thread 가 semaphore에게 종료를 알림
        } catch (InterruptedException e) {

        }
    }

}