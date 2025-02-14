package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecipheringTest {

    @Test
    public void test() {
        Deciphering deciphering = new Deciphering();
        Assertions.assertEquals(3, deciphering.solution(10, new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7},
        }, new int[]{2, 3, 4, 3, 3}));
    }
}