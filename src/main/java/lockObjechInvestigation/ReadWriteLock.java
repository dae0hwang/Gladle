package lockObjechInvestigation;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data(10);
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();
        Thread.sleep(6000);
        System.exit(0);

    }

}

class Data {
    private final char[] buffer;
    private final java.util.concurrent.locks.ReadWriteLock lock = new ReentrantReadWriteLock(false);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public Data(int size) {
        this.buffer = new char[size];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        readLock.lock();
        try {
            return doRead();
        } finally {
            readLock.unlock();
        }
    }

    public void write(char c) throws InterruptedException {
        writeLock.lock();
        try {
            doWrite(c);
            return;
        } finally {
            writeLock.unlock();
        }
    }

    private char[] doRead() {
        char[] newbuf = new char[buffer.length];

        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}

class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                char[] readbuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException e) {

        }

    }
}

class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filter;
    private int index = 0;

    public WriterThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    public void run() {
        try {
            while (true) {
                char c = nextchar();
                data.write(c);
                System.out.println(" ");
                System.out.println("----------------- 썼어요");
                System.out.println(" ");
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {

        }
    }

    private char nextchar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }

        return c;
    }
}