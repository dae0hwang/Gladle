package HashFactory;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));
        System.out.println(getIndex(sc.next()));

        }
    private static int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += (int) c;
        }
        return hashCode;
    }

    private static int getIndex(String key) {
        int hashCode = getHashCode(key);
        return hashCode % 10;
    }





}


