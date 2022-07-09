package Lombok;

public class Main {

    public static void main(String[] args) {
        Equals a = new Equals("aa", 11, true);
        Equals b = new Equals("aa", 11, true);
        Equals c = new Equals("bb", 22, true);

        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        if (a.equals(c)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        if (a == b) {
            System.out.println("같은 참조");
        } else {
            System.out.println("다른 참조");
        }


    }

}
