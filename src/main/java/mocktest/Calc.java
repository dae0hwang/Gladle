package mocktest;

public class Calc {

    private UserRead userRead;

    public Calc(UserRead userRead) {
        this.userRead = userRead;
    }

    public int runCalc() {
        System.out.println("Input 2 Numbers");
        userRead.read2Number();
        return calc(userRead.getNum1(), userRead.getNum2());
    }


    private int calc(int a, int b) {
        if (a == 0) {
            return 0;
        } else {
            return a + b;
        }
    }
}
