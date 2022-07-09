package TestTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcTest {

    UserRead userRead;
    Calc calc;

    @BeforeEach
    void init() {
        //scanner대신에 입력값을 제공해준다.
        userRead = mock(UserRead.class);
        calc = new Calc(userRead);
    }

    @Test
    void testCalc() {
        //given 데이터 준비
        when(userRead.getNum1()).thenReturn(1);
        when(userRead.getNum2()).thenReturn(2);

//        when 어떤 동작을 했을 때
        int result = calc.runCalc();

//        then 어떤 결과가 나올지 가정한다.
        assertEquals(result, 3);
//        입력이 몇번 되야 맞는건지 체크
        verify(userRead, times(1)).getNum1();
    }

    @Test
    void testCalc2() {
        //given 데이터 준비
        when(userRead.getNum1()).thenReturn(0);
        when(userRead.getNum2()).thenReturn(1);

//        when 어떤 동작을 했을 때
        int result = calc.runCalc();

//        then 어떤 결과가 나올지 가정한다.
        assertEquals(result, 0);
    }

}




