package structure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    public void appendTest() {
        Array array = new Array(10);
        assertEquals(0, array.size());
        for (int i = 0; i < 10; i++) array.append(i);
        assertEquals(10, array.size());
    }
}