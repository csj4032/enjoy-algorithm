package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberBlockTest {

    @Test
    void test() {
        NumberBlock numberBlock = new NumberBlock();
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 3, 1, 4, 3, 5}, numberBlock.solution(1, 10));
        Assertions.assertArrayEquals(new int[]{6}, numberBlock.solution(477559014, 477559014));
        Assertions.assertArrayEquals(new int[]{10000000}, numberBlock.solution(1000000000, 1000000000));
        Assertions.assertArrayEquals(new int[]{5000000}, numberBlock.solution(10000000, 10000000));
        Assertions.assertArrayEquals(new int[]{1}, numberBlock.solution(100000007, 100000007));
        Assertions.assertArrayEquals(new int[]{9999999}, numberBlock.solution(989999901, 989999901));
    }
}