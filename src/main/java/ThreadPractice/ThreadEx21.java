package ThreadPractice;

public class ThreadEx21 {
    public static void main(String[] args) throws InterruptedException {
        RunableEx21 r = new RunableEx21();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t1.join(1000);
        t2.start();
    }
}

class Account {
    private int balance = 1000;
    public int getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            balance -= money;
        }
    }
}

class RunableEx21 implements Runnable {
    Account acc = new Account();

    @Override
    public void run() {
        synchronized (this) {
            while (acc.getBalance() > 0) {
                int money = (int) (Math.random() * 3 + 1) * 100;
                acc.withdraw(money);
                System.out.println("balance : " + acc.getBalance());
            }
        }

    }
}
