package TestTest;

public class Main {

    public static void main(String[] args) {
        UserRead userRead = new UserRead();
        Calc calc = new Calc(userRead);
        System.out.println(calc.runCalc());
        System.out.println(calc.runCalc());



    }

}
