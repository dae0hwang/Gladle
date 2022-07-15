package ThreadPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentLIst {
    public static void main(String[] args) throws InterruptedException {
        TestList testList = new TestList();
        Thread t1 = new Thread(testList);
        Thread t2 = new Thread(testList);
        Thread t3 = new Thread(testList);
        Thread t4 = new Thread(testList);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();


    }
}

class TestList implements Runnable {
//    ArrayList<Integer> list1 = new ArrayList();
    CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
    List<Object> list = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            int addNum = (int) (Math.random() * 10);
            list1.add(addNum);
            System.out.println("+" + addNum);
            System.out.println(list1);

            int removeNum = list1.remove(0);
            System.out.println("-" + removeNum);
            System.out.println(list1);


        }
    }
}

