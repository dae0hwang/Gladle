package ThreadPractice;

import java.util.ArrayList;
import java.util.List;

public class PubSubEx1 {

    int nextInitial = 0;
    private int initialCapcity = 10;
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        PubSubEx1 threadSignaling  = new PubSubEx1();
        Thread publisher1 = new Thread(() -> threadSignaling.publisher());
        publisher1.start();
        Thread subscriber1 = new Thread(() -> threadSignaling.subscriber());
        subscriber1.start();
    }




    public void subscriber() {
        for (int i = 0; i < initialCapcity; i++) {
            synchronized (this) {
                try {
                    while (list.size() == 0) {
                        this.wait();
                    }
                    System.out.println(Thread.currentThread().getName()
                        + " " + nextInitial + ".Message subscribed..."
                        + list.get(0));
                    list.remove(0);
                    this.notifyAll();
                }catch (InterruptedException e) {}
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void publisher() {
        for (int i = 0; i < initialCapcity; i++) {
            synchronized (this) {
                try {
                    while (list.size() == 3) {
                        this.wait();
                    }
                    list.add(nextInitial);
                    System.out.println(Thread.currentThread().getName()
                        + " " + nextInitial + ". Message published..."
                        + nextInitial);
                    nextInitial++;
                    this.notifyAll();
                } catch (InterruptedException e) {

                }
            }
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}


