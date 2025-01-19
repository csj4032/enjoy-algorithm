package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UninhabitedTest {

    @Test
    public void test() {
        Uninhabited uninhabited = new Uninhabited();
        Assertions.assertArrayEquals(new int[]{1, 1, 27}, uninhabited.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}));
        Assertions.assertArrayEquals(new int[]{-1}, uninhabited.solution(new String[]{"XXX","XXX","XXX"}));
    }
}