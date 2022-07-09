package HashFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTest {

    @BeforeEach
    void init() {
    }

    @Test
    void  testGetHashCode()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hash hash = new Hash(10);
        //given
        Method method = Hash.class.getDeclaredMethod("getHashCode", String.class);
        method.setAccessible(true);
        int expectedInt = 414;

        //when
        int actual = (int) method.invoke(hash, "asdf");
        //then
        assertEquals(expectedInt, actual);

    }

    @Test
    void  testGetIndex()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hash hash = new Hash(10);
        //given
        Method method = Hash.class.getDeclaredMethod("getIndex", int.class);
        method.setAccessible(true);
        int expectedInt = 4;

        //when
        int actual = (int) method.invoke(hash, 414);
        //then
        assertEquals(expectedInt, actual);

    }

    @Test
    void  testGetIndex2()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hash hash = new Hash(10);
        //given
        Method method = Hash.class.getDeclaredMethod("getIndex", int.class);
        method.setAccessible(true);
        int expectedInt = 0;

        //when
        int actual = (int) method.invoke(hash, 0);
        //then
        assertEquals(expectedInt, actual);

    }

    @Test
    //잠시 보류
    void  testSearchNode()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Hash hash = new Hash(10);
        Field field = hash.getClass().getDeclaredField("table");
        field.setAccessible(true);


        //given
        Method method = Hash.class.getDeclaredMethod("getIndex", int.class);
        method.setAccessible(true);
        int expectedInt = 4;

        //when
        int actual = (int) method.invoke(hash, 414);
        //then
        assertEquals(expectedInt, actual);

    }



    @Test
    void  testGet() {
        //given
        Hash hash = new Hash(10);
        //when
        hash.put("aa", "aa");
        String result = hash.get("aa");
        //then
        assertEquals(result, "aa");



    }

    @Test
    void  testGet2() {
        //given
        Hash hash = new Hash(10);
        //when
        hash.put("aa", "aa");
        String result = hash.get("bb");
        //then
        assertEquals(result, "null");


    }

    @Test
    //같은 해시코드 = 같은 인덱스에 우치할 때,
    void  testGet3() {
        //given
        Hash hash = new Hash(10);
        //when
        //as와 tt getindex값이 갔다.
        hash.put("as", "as");
        hash.put("tt", "tt");
        String result = hash.get("tt");
        //then
        assertEquals(result, "tt");


    }

    @Test
    //같은 키값이 와서 밸류값 겹쳐질 때
    void  testGet4() {
        //given
        Hash hash = new Hash(10);
        //when
        //as와 tt getindex값이 갔다.
        hash.put("aa", "aa");
        hash.put("aa", "ss");
        String result = hash.get("aa");
        //then
        assertEquals(result, "ss");


    }




}