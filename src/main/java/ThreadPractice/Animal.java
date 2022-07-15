package ThreadPractice;




public class Animal implements Runnable {

    private String name;

    Animal(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("저는" +name +"쓰레드입니다.");
            try {
                Thread.sleep(150);
            }catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        Animal cat = new Animal("cat");
        Animal dog = new Animal("dog");
        Thread t1 = new Thread(cat);
        Thread t2 = new Thread(dog);
        t1.start();
        try{
            t1.sleep(2000);
        }catch (InterruptedException e){}
        t2.start();
    }

}