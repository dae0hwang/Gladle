package ThreadPractice;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TreadWaitEx4 {
    public static void main(String[] args) throws InterruptedException {
        Table4 table = new Table4();

        Thread t1 = new Thread(new Cook4(table), "cook1");
        Thread t2 = new Thread(new Customer4(table,"donut"), "cust1");
        Thread t3 = new Thread(new Customer4(table,"burger"), "cust2");

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.exit(0);
    }


}

class Customer4 implements Runnable{
    private Table4 table;
    private String food;

    Customer4(Table4 table, String food){
        this.table = table;
        this.food = food;
    }

    public void run(){
        while(true){
            try { Thread.sleep(100); } catch (InterruptedException e){}
            String name = Thread.currentThread().getName();
            table.removes(food);
            System.out.println(name +" ate a " + food);
        }
    }
}

class Cook4 implements Runnable{
    private Table4 table;
    Cook4(Table4 table) { this.table = table; }
    public void run(){
        while(true) {
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(10); } catch (InterruptedException e) { }
        }
    }
}

class Table4 {
    String[] dishNames = {"donut", "donut", "Burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish) {
        lock.lock();
        try {
            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name +"is waiting");
                try {
                    forCook.await();
                    Thread.sleep(500);
                }catch (InterruptedException e ){}

            }
            dishes.add(dish);
            forCust.signal();

            System.out.println("Dishes" + dishes.toString());

        }finally {
            lock.unlock();
        }
    }

    public void removes(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();
        try {
            while (dishes.size() == 0) {
                System.out.println(name + "is waiting");
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        return;
                    }
                }
                try {
                    System.out.println(name + "is waiting");
                    forCust.await();
                    Thread.sleep(500);
                }catch (InterruptedException e) {}
            }
        }finally {
            lock.unlock();
        }
    }
    public int dishNum(){ return dishNames.length; }
}
