package mathutils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MathUtilsTest1 {
    MathUtils mu = new MathUtils();

    @Test
    void assertEqualTest(){
        Assertions.assertEquals(3, mu.add(1, 2));
        Assertions.assertEquals(2, mu.add(1, 1), () -> "hello world");
    }

    @Test
    void assertArrayTest(){
        Assertions.assertArrayEquals(new int[]{1,2,3,4}, new int[]{1,2,3,4});
    }

    @Test
    void assertIterableTest(){
        Iterable<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        Iterable<Integer> l2 = new ArrayList<>(Arrays.asList(1,2,3,4));

        Assertions.assertIterableEquals(l1, l2);
    }

    @Test
    void assertNotNullTest(){
        String s = "A";
        Assertions.assertNotNull(s);
    }

    @Test
    void assertTrueTest(){
        boolean t = true;
        Assertions.assertTrue(t);
    }

    @Test
    void assertFalseTest(){
        boolean t = false;
        Assertions.assertFalse(t);
    }

    @Test
    void assertThrowTest(){
        Assertions.assertThrows(ArithmeticException.class,  () -> mu.divide(1,0));
    }

    @Test
    void assertAllTest(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(4, mu.add(2,2)),
                () -> Assertions.assertEquals(4, mu.add(2,2)),
                () -> Assertions.assertEquals(4, mu.add(2,2)),
                () -> Assertions.assertEquals(4, mu.add(2,2))

        );
    }

    @Test
    void assertFails(){
        Assertions.fail("h");
    }


}