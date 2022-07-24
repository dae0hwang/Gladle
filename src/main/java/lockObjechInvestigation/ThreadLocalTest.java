package lockObjechInvestigation;

public class ThreadLocalTest implements Runnable {

    private static final ThreadLocal<String> info = new ThreadLocal<>() {

        protected String initialValue() {
            return new String("Default");
        }
    };

    @Override
    public void run() {
        System.out.println("Strart Thred " +Thread.currentThread().getName() + " - value: " + info.get());
        info.set(Thread.currentThread().getName());
        System.out.println("End Thread" + Thread.currentThread().getName() +" - value: " + info.get());

    }

    public static void main(String[] args) {
        ThreadLocalTest runnable = new ThreadLocalTest();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(runnable);
            thread.start();

        }

    }


}
