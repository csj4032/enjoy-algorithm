package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DividingPowerTest {

    @Test
    public void test() {
        DividingPower dividingPower = new DividingPower();
        Assertions.assertEquals(3, dividingPower.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
//        Assertions.assertEquals(0, dividingPower.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
//        Assertions.assertEquals(1, dividingPower.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}