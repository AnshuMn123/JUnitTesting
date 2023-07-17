package firstDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupDemoTest {

    @Test
    void getType() {
        CupDemo c = new CupDemo("abc", 12.5);
        assertEquals("abc", c.getStr());
    }


    @Test
    void getPercentage() {
    }
}