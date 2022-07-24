package CouncurrentListEx1;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {

    }
}

class Test implements Runnable {
    ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
    @Override
    public void run() {
        int random = (int) ((Math.random()) * 10);
        hashMap.put(random, random);


    }
}
