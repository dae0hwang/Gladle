package MockTest;

import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRead {

    private int num1;
    private int num2;

    public void read2Number() {
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();
        num2 = sc.nextInt();
    }


}
