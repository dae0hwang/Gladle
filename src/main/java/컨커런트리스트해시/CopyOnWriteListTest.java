package 컨커런트리스트해시;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {
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

class TestList implements java.lang.Runnable {
    private CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            int addNum = (int) (Math.random() * 10);
            list.add(addNum);
            System.out.println("+" + addNum);
            System.out.println(list);

            int removeNum = list.remove(0);
            System.out.println("-" + removeNum);
            System.out.println(list);

        }

    }
}